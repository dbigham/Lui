package com.danielbigham.lui.loading;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.danielbigham.io.Out;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRulesContext;
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
	private Thread fileWatcherThread;
	private Grammar grammar;
	
	public GrammarFiles(Path baseDir, Grammar grammar) throws IOException
	{
		this.grammar = grammar;
		fileWatcherThread = new FileLoaderAndReloader(baseDir, this);
		fileWatcherThread.run();
	}
	
	public GrammarFiles(String baseDir, Grammar grammar) throws IOException
	{
		this.grammar = grammar;
		fileWatcherThread = new FileLoaderAndReloader(Paths.get(baseDir), this);
		fileWatcherThread.start();
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
			Out.print("Load file: " + path);
			
			class RuleHandler implements IRuleHandler
			{
				@Override
				public void handle(GrammarRulesContext rules)
				{
					List<GrammarRule> luiRules = AntlrHelpers.convert(rules, grammar);
					
					grammar.addRules(luiRules);
				}
			}
			
			AntlrHelpers.loadGrammarFile(path, new RuleHandler());
		}
	}

	@Override
	public void fileModified(Path path) throws IOException
	{
		if (isGrammarFile(path))
		{
			Out.print("--------------------------------------------------------------------------------");
			Out.print("File modified: " + path);
			
			class RuleHandler implements IRuleHandler
			{
				@Override
				public void handle(GrammarRulesContext rules)
				{
					List<GrammarRule> luiRules = AntlrHelpers.convert(rules, grammar);
					
					//Out.print("TODO: Reload file.");
				}
			}
			
			AntlrHelpers.loadGrammarFile(path, new RuleHandler());
		}
	}

	@Override
	public void fileCreated(Path path) throws IOException
	{
		if (isGrammarFile(path))
		{
			Out.print("File created: " + path);
		}
	}

	@Override
	public void fileRemoved(Path path)
	{
		if (isGrammarFile(path))
		{
			Out.print("File removed: " + path);
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
