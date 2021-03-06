package com.danielbigham.lui.loading;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.danielbigham.io.Out;

/**
 * This class can be used to explore a directory hierarchy and load all
 * files of a certain type. It also supports watching files for modification
 * in a scalable way, and reloading those files if they change. (Likewise
 * watching for new files and loading them)
 * 
 * This class is a Thread and so can be started with the 'run' method.
 * It needs to be in its own thread because it uses an infinite loop
 * to repeatedly get and process events as they become available.
 * 
 * @author danielb
 */
public class FileLoaderAndReloader extends Thread
{
	private IFileLoader fileLoader;
	private WatchService watchService;
	private Map<WatchKey, Path> keys;
	private Map<String, Long> fileTimestamps;
	
	public FileLoaderAndReloader(Path dir, IFileLoader fileLoader) throws IOException
	{
		List<Path> dirs = new ArrayList<Path>();
		dirs.add(dir);
		init(dirs, fileLoader);
	}
	
	public FileLoaderAndReloader(List<String> dirs, IFileLoader fileLoader) throws IOException
	{
		List<Path> paths = new ArrayList<Path>();
		for (String dir : dirs)
		{
			paths.add(Paths.get(dir));
		}
		init(paths, fileLoader);
	}
	
	private void init(List<Path> dirs, IFileLoader fileLoader) throws IOException
	{
		this.fileLoader = fileLoader;
		this.watchService = FileSystems.getDefault().newWatchService();
		this.keys = new HashMap<WatchKey, Path>();
		this.fileTimestamps = new HashMap<String, Long>();
		
		loadFiles(dirs);
		
		addDirectories(dirs);
	}

	/**
	 * Call fileLoader.loadPath for each file in this directory hierarchy.
	 * It is up to fileLoader.loadFile to decide whether it cares about
	 * the given file.
	 * 
	 * @param dir		the base directory.
	 * 
	 * @throws IOException
	 */
	private void loadFiles(List<Path> dirs) throws IOException
	{
		for (Path dir : dirs)
		{
			Files.walkFileTree(
					dir,
					new SimpleFileVisitor<Path>()
					{
						@Override
						public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException
						{
							fileLoader.loadFile(path);
							return FileVisitResult.CONTINUE;
						}
					}
				);
		}
		
		fileLoader.doneVisitingFiles();
	}

	/**
	 * Adds the directory and all sub-directories recursively to the
	 * watch service so that we'll be notified when files are modified,
	 * added, or deleted.
	 * 
	 * @param dir		the base directory.
	 * 
	 * @throws IOException
	 */
	private void addDirectories(List<Path> dirs) throws IOException
	{
		for (Path dir : dirs)
		{
			addDirectories(dir);
		}
	}
	
	private void addDirectories(Path dir) throws IOException
	{
		Files.walkFileTree(
			dir,
			new SimpleFileVisitor<Path>()
			{
				@Override
				public FileVisitResult preVisitDirectory(Path thisDir, BasicFileAttributes attrs) throws IOException
				{
					addDirectory(thisDir);
					return FileVisitResult.CONTINUE;
				}
			}
		);
	}

	/**
	 * Adds the given directory to the watch service.
	 * 
	 * @param thisDir		the directory to add/watch.
	 * 
	 * @throws IOException 
	 */
	protected void addDirectory(Path dir) throws IOException
	{
		WatchKey key = dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		keys.put(key, dir);
	}
	
	/**
	 * Process events from the watch service.
	 */
	public void run()
	{
		while(true)
		{
			// Wait for the next event
			WatchKey key;
			try
			{
				key = watchService.take();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
				break;
			}
			
			Path dir = keys.get(key);
			if (dir == null) { continue; }
			
			for (WatchEvent<?> event : key.pollEvents())
			{
				@SuppressWarnings("rawtypes")
				WatchEvent.Kind kind = event.kind();
				
				if (kind == StandardWatchEventKinds.OVERFLOW) { continue; }
				
				@SuppressWarnings("unchecked")
				WatchEvent<Path> pathEvent = (WatchEvent<Path>)event;
				
				Path name = pathEvent.context();
				Path path = dir.resolve(name);
				
				if (kind == StandardWatchEventKinds.ENTRY_CREATE)
				{
					if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS))
					{
						// New directory
						try
						{
							Out.print("Add directory: " + path);
							addDirectories(path);
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
					else
					{
						// New file
						try
						{
							fileLoader.fileCreated(path);
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				}
				else if (kind == StandardWatchEventKinds.ENTRY_DELETE)
				{
					if (!Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS))
					{
						// File deleted
						try
						{
							fileLoader.fileRemoved(path);
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				}
				else if (kind == StandardWatchEventKinds.ENTRY_MODIFY)
				{
					if (!Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS))
					{
						// File modified
						try
						{
							long fileLastModified = new File(path.toString()).lastModified();
							Long lastKnownModified = fileTimestamps.get(path.toString());
							// The Java WatcherService seems to see two file modifications in
							// rapid succession (ex. 10 milliseconds apart). We don't want to
							// reload the grammar twice, so we'll make sure the timestamp changes
							// enough.
							if (lastKnownModified == null || lastKnownModified < fileLastModified - 100)
							{
								//Out.print("File modified: " + path + " (" + Thread.currentThread().getId() + ")");
								//Out.print("  File last modified:  " + fileLastModified + " (" + Thread.currentThread().getId() + ")");
								//Out.print("  Last known modified: " + lastKnownModified + " (" + Thread.currentThread().getId() + ")");
								fileTimestamps.put(path.toString(), fileLastModified);
								fileLoader.fileModified(path);
							}
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				}
			}
			
			boolean valid = key.reset();
			if (!valid)
			{
				keys.remove(key);
				
				if (keys.isEmpty())
				{
					break;
				}
			}
		}
	}
}
