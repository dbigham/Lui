package com.danielbigham.lui.loading;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.antlr.GrammarLexer;
import com.danielbigham.lui.antlr.GrammarParser;
import com.danielbigham.lui.antlr.GrammarParser.BasicRulePart2Context;
import com.danielbigham.lui.antlr.GrammarParser.BasicRulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRuleContext;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRulesContext;
import com.danielbigham.lui.antlr.GrammarParser.OrRulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.RulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.SeqRulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.SimpleRuleContext;
import com.danielbigham.lui.antlr.GrammarParser.SymbolContext;
import com.danielbigham.lui.grammarrule.GrammarRule;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.LiteralPattern;
import com.danielbigham.lui.pattern.OrPattern;
import com.danielbigham.lui.pattern.SequencePattern;
import com.danielbigham.lui.pattern.SymbolPattern;

/**
 * Code for converting ANTLR-parsed grammar rules to our internal GrammarRule class.
 * 
 * @author danielb
 */
public class AntlrHelpers
{
	/**
	 * Convert a list of ANTLR-parsed grammar rules to a list of LUI GrammarRules.
	 * 
	 * @param grammar		the grammar.
	 */
	static List<GrammarRule> convert(GrammarRulesContext in, Grammar grammar)
	{
		List<GrammarRuleContext> arules = in.grammarRule();
		List<GrammarRule> out = new ArrayList<GrammarRule>(arules.size());
		
		for (GrammarRuleContext arule : arules)
		{
			convert(arule, out, grammar);
		}
		
		return out;
	}
	
	/**
	 * Convert a single ALTLR-parsed grammar rule to a LUI GrammarRule.
	 * 
	 * @param out			the output list of rules. 
	 * @param grammar		the grammar. 
	 */
	static void convert(GrammarRuleContext rule, List<GrammarRule> out, Grammar grammar)
	{
		if (rule != null && rule.lhs() != null)
		{
			System.out.println("RULE: " + rule.lhs().getText());
			System.out.println("  Simple rules: " + rule.simpleRule().size());
			
			String lhs = rule.lhs().getText();
			String action = rule.expr() == null ? null : rule.expr().getText();
			
			// This is actually multiple rules in one.
			if (rule.simpleRule().size() > 0)
			{
				for (SimpleRuleContext simpleRule : rule.simpleRule())
				{
					out.add(
							convert(
								lhs,
								simpleRule.rulePart(),
								action,
								grammar
							)
						);
				}
			}
			else
			{
				// A single rule (not multiple in one)
				out.add(
					convert(
						lhs,
						rule.rulePart(),
						action,
						grammar
					)
				);
			}
		}
	}
	
	/**
	 * Convert a grammar rule.
	 * 
	 * @param lhs			the lhs symbol.
	 * @param ruleParts		the rule parts.
	 * @param action		the grammar action.
	 * @param grammar		the grammar.
	 */
	static GrammarRule convert(String lhs, List<RulePartContext> ruleParts, String action, Grammar grammar)
	{
		List<IPattern> subPatterns = convert(ruleParts, grammar);
		IPattern pattern;
		if (subPatterns.size() == 1)
		{
			// Don't needlessly wrap something with SequencePattern
			// if it's just a single thing.
			pattern = subPatterns.get(0);
		}
		else
		{
			pattern =
				new SequencePattern(
					subPatterns,
					-1
				);
		}
		
		return
			new GrammarRule(
				grammar,
				lhs,
				pattern,
				action
			);
	}
	
	/**
	 * Convert a list of rule parts into a list of IPattern.
	 * 
	 * @param ruleParts		the rule parts.
	 * @param grammar		the grammar.
	 * @return				list of IPattern.
	 */
	static List<IPattern> convert(List<RulePartContext> ruleParts, Grammar grammar)
	{
		List<IPattern> res = new ArrayList<IPattern>(ruleParts.size());
		for (RulePartContext rulePart : ruleParts)
		{
			res.add(convert(rulePart, grammar));
		}
		return res;
	}
	
	static IPattern convert(RulePartContext rulePart, Grammar grammar)
	{
		if (rulePart instanceof BasicRulePart2Context)
		{
			return convert(((BasicRulePart2Context)rulePart).basicRulePart(), grammar);
		}
		else if (rulePart instanceof OrRulePartContext)
		{
			return
				new OrPattern(
					convert(((OrRulePartContext) rulePart).rulePart(), grammar),
					-1
				);
		}
		else if (rulePart instanceof SeqRulePartContext)
		{
			if (((SeqRulePartContext) rulePart).rulePart().size() == 1)
			{
				// Don't needlessly wrap something with SequencePattern
				// if it's just a single thing.
				return
					convert(
						((SeqRulePartContext) rulePart).rulePart().get(0),
						grammar
					);
			}
			else
			{
				return
					new SequencePattern(
						convert(((SeqRulePartContext) rulePart).rulePart(), grammar),
						-1
					);
			}
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Convert a 'basicRulePart' to an IPattern.
	 * 
	 * @param rulePart		the basicRulePart.
	 * @param grammar		the grammar.
	 * @return				the IPattern.
	 */
	static IPattern convert(BasicRulePartContext rulePart, Grammar grammar)
	{
		SymbolContext symbol = rulePart.symbol();
		if (symbol != null)
		{
			String symbolName = symbol.getText();
			// We're assigning dummy start/end positions here because
			// this isn't a pattern MATCH, it's just a pattern. This
			// implies that our decision to make BasicPattern implement
			// IPatternMatch seems suspect.
			return new SymbolPattern(grammar, symbolName, -1, -1, true);
		}
		else
		{
			String literal = rulePart.getText();
			return new LiteralPattern(grammar, literal, -1, true);
		}
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