package com.danielbigham.lui.loading;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.danielbigham.lui.antlr.GrammarLexer;
import com.danielbigham.lui.antlr.GrammarParser;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRuleContext;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRulesContext;
import com.danielbigham.lui.grammarrule.GrammarRule;

/**
 * Code for converting ANTLR-parsed grammar rules to our internal GrammarRule class.
 * 
 * @author danielb
 */
public class AntlrHelpers
{
	/**
	 * Convert a list of ANTLR-parsed grammar rules to a list of LUI GrammarRules.
	 */
	static List<GrammarRule> convert(GrammarRulesContext in)
	{
		List<GrammarRuleContext> arules = in.grammarRule();
		List<GrammarRule> out = new ArrayList<GrammarRule>(arules.size());
		
		for (GrammarRuleContext arule : arules)
		{
			out.add(convert(arule));
		}
		
		return out;
	}
	
	/**
	 * Convert a single ALTLR-parsed grammar rule to a LUI GrammarRule.
	 */
	static GrammarRule convert(GrammarRuleContext arule)
	{
		if (arule != null && arule.lhs() != null && arule.lhs().symbolName != null)
		{
			System.out.println("RULE: " + arule.lhs().symbolName.getText());
			System.out.println("  Simple rules: " + arule.simpleRule().size());
		}
		
		// TODO
		
		return null;
	}
	
	/**
	 * Load a .grammar file. Calls ruleHandler.handle to do something with the loaded rules.
	 * 
	 * @param path				the .grammar file.
	 * @param ruleHandler		the class that will be passed the rules.
	 * 
	 * @throws IOException 
	 */
	static void loadGrammarFile(Path path, IRuleHandler ruleHandler) throws IOException
	{
		GrammarLexer lexer = new GrammarLexer(new ANTLRFileStream(path.toString()));
		parseGrammar(lexer, ruleHandler);
	}
	
	/**
	 * Parse the grammar that was passed to this lexer. Calls ruleHandler.handle
	 * to do something with the loaded rules.
	 * 
	 * @param lexer				the lexer that was passed the input.
	 * @param ruleHandler		the class that will be passed the rules.
	 */
	private static void parseGrammar(GrammarLexer lexer, IRuleHandler ruleHandler)
	{
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);
		GrammarParser.GrammarRulesContext tree = parser.grammarRules();	
		if (ruleHandler != null)
		{
			GrammarRulesListener extractor = new GrammarRulesListener(ruleHandler);
			ParseTreeWalker.DEFAULT.walk(extractor, tree);		
		}
	}

	/**
	 * Parse the grammar. Calls ruleHandler.handle to do something with the loaded rules.
	 * 
	 * @param grammarRules		the grammar rules.
	 * @param ruleHandler		the class that will be passed the rules.
	 */
	public static void parseGrammar(String grammarRules, RuleHandler ruleHandler)
	{
		GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(grammarRules));
		parseGrammar(lexer, ruleHandler);
	}
}
