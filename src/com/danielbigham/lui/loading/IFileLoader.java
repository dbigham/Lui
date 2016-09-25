package com.danielbigham.lui.loading;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Allows files to be loaded/reloaded/etc. Can be passed to
 * FileLoaderAndReloader for it to make use of for automatic
 * file reloading, etc.
 * 
 * @author danielb
 */
public interface IFileLoader
{
	/**
	 * Load the given file.
	 */
	public void loadFile(Path path) throws IOException;
	
	/**
	 * The given file was modified.
	 * @throws IOException 
	 */
	public void fileModified(Path path) throws IOException;
	
	/**
	 * The given file was created after we performed initial
	 * loading of files.
	 */
	public void fileCreated(Path path) throws IOException;
	
	/**
	 * The given file was removed.
	 */
	public void fileRemoved(Path path) throws IOException;

	/**
	 * Called once all of the files have been visited/loaded.
	 */
	public void doneVisitingFiles();
}
