package com.danielbigham.lui.loading;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.danielbigham.Util;
import com.danielbigham.Util2;
import com.danielbigham.io.Out;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRulesContext;
import com.danielbigham.lui.antlr.GrammarRuleSyntaxError;
import com.danielbigham.lui.grammarrule.GrammarRule;


/**
 * Represents one or more grammar files that can be loaded. A 'reload' method will intelligently
 * determine which files have been modified and reload only them. It will then update the associated
 * 'grammar' object, removing any deleted rules and adding any new rules.
 * 
 * @author danielb
 */
public class GrammarFiles implements IFileLoader
{
	private FileLoaderAndReloader fileWatcherThread;
	private Grammar grammar;
	private final List<Path> allFiles;
	private static final Map<String, GrammarFiles> objs;
	
	static
	{
		objs = new HashMap<String, GrammarFiles>();
	}
	
	/**
	 * Create a GrammarFiles object.
	 * 
	 * Ensure that duplicates don't get created for the same directory.
	 * 
	 * @param dir		The directory to watch.
	 * @return			The FileLoaderAndReloader object.
	 */
	public static GrammarFiles create(String dir, Grammar grammar) throws IOException
	{
		GrammarFiles existing = objs.get(dir);
		if (existing != null)
		{
			return existing;
		}
		else
		{
			GrammarFiles obj = new GrammarFiles(dir, grammar);
			objs.put(dir, obj);
			return obj;
		}
	}
	
	private GrammarFiles(Path baseDir, Grammar grammar) throws IOException
	{
		this.grammar = grammar;
		this.allFiles = new ArrayList<Path>();
		fileWatcherThread = new FileLoaderAndReloader(baseDir, this);
		fileWatcherThread.run();
	}
	
	private GrammarFiles(String baseDir, Grammar grammar) throws IOException
	{
		this.grammar = grammar;
		this.allFiles = new ArrayList<Path>();
		fileWatcherThread = new FileLoaderAndReloader(Paths.get(baseDir), this);
		fileWatcherThread.start();
	}
	
	/**
	 * Handles grammar syntax errors upon loading.
	 */
	private void handleGrammarRuleSyntaxError(Exception e)
	{
		if (e instanceof GrammarRuleSyntaxError)
		{
			Out.print(e);
			GrammarRuleSyntaxError e2 = (GrammarRuleSyntaxError)e;
			Util2.callWL(
				"OpenFileInWorkbench[" +
					Util.createDoubleQuotedString(e2.getSourceName()) + "," +
					"\"Line\" -> " + e2.getLine() +
				"]"
			);
		}
		else
		{
			Out.print("TODO");
		}
	}
	
	/**
	 * Reloads the entire grammar.
	 * 
	 * For now, whenever a file is modified/created/removed, we just
	 * reload the whole grammar. Once grammars gets large, we would want
	 * to be more sophisticated than this. ie. Remove the old version of
	 * a rule and add a new version of a rule. (ie. diff old version of file
	 * to new version of file)
	 * 
	 * @throws IOException 
	 */
	private void reloadAll() throws IOException
	{
		grammar.init();
		for (Path path : allFiles)
		{
			class RuleHandler implements IRuleHandler
			{
				@Override
				public void handle(GrammarRulesContext rules)
				{
					List<GrammarRule> luiRules = AntlrHelpers.convert(rules, grammar);
					grammar.addRules(luiRules);
				}
			}
			
			try
			{
				AntlrHelpers.loadGrammarFile(path, new RuleHandler());
			}
			catch (Exception e)
			{
				handleGrammarRuleSyntaxError(e);
			}
		}
		
		grammar.processRules();
	}
	
	/**
	 * Shut down the file watching thread.
	 */
	public void close()
	{
		fileWatcherThread.interrupt();
	}

	@Override
	public void loadFile(Path path) throws IOException
	{
		if (isGrammarFile(path))
		{
			//Out.print("Load file: " + path);
			
			allFiles.add(path);
			
			class RuleHandler implements IRuleHandler
			{
				@Override
				public void handle(GrammarRulesContext rules)
				{
					List<GrammarRule> luiRules = AntlrHelpers.convert(rules, grammar);
					
					grammar.addRules(luiRules);
				}
			}
			
			try
			{
				AntlrHelpers.loadGrammarFile(path, new RuleHandler());
			}
			catch (Exception e)
			{
				handleGrammarRuleSyntaxError(e);
			}
		}
	}

	@Override
	public void fileModified(Path path) throws IOException
	{
		if (isGrammarFile(path))
		{
			//Out.print("--------------------------------------------------------------------------------");
			//Out.print("File modified: " + path);
			reloadAll();
		}
	}

	@Override
	public void fileCreated(Path path) throws IOException
	{
		if (isGrammarFile(path))
		{
			allFiles.add(path);
			//Out.print("File created: " + path);
			reloadAll();
		}
	}

	@Override
	public void fileRemoved(Path path) throws IOException
	{
		if (isGrammarFile(path))
		{
			allFiles.remove(path);
			//Out.print("File removed: " + path);
			reloadAll();
		}
	}
    
    /**
     * Returns true if the given file is a grammar file.
     */
    public boolean isGrammarFile(Path path)
    {
    	return "grammar".equals(extension(path));
    }
    
    /**
     * Given a file path, returns its extension.
     */
    public String extension(Path path)
    {
    	String str = path.toString();
        int dotPos = str.lastIndexOf(".");
        return str.substring(dotPos + 1);
    }

    // Load the grammar files in a current directory and watch for changes
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Path dir = Paths.get(args[0]);
        Grammar grammar = new Grammar();
        new FileLoaderAndReloader(dir, new GrammarFiles(dir, grammar)).run();
    }

	@Override
	public void doneVisitingFiles()
	{
		grammar.processRules();
	}
}
