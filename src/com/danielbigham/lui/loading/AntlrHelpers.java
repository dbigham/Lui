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
import com.danielbigham.lui.antlr.DescriptiveErrorListener;
import com.danielbigham.lui.antlr.GrammarLexer;
import com.danielbigham.lui.antlr.GrammarParser;
import com.danielbigham.lui.antlr.GrammarParser.BasicRulePart2Context;
import com.danielbigham.lui.antlr.GrammarParser.BasicRulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.BindingContext;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRuleContext;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRulesContext;
import com.danielbigham.lui.antlr.GrammarParser.OrRulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.RulePart2Context;
import com.danielbigham.lui.antlr.GrammarParser.RulePart3Context;
import com.danielbigham.lui.antlr.GrammarParser.RulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.SeqRulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.SimpleRuleContext;
import com.danielbigham.lui.antlr.GrammarParser.SymbolContext;
import com.danielbigham.lui.grammarrule.GrammarRule;
import com.danielbigham.lui.pattern.BasicPattern;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.LiteralPattern;
import com.danielbigham.lui.pattern.OrPattern;
import com.danielbigham.lui.pattern.Pattern;
import com.danielbigham.lui.pattern.SequencePattern;
import com.danielbigham.lui.pattern.SymbolPattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;

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
			//if (ChartParser.debugFlag) { Out.print("Parsing Rule; " + rule.lhs().getText()); }
			
			String lhs = rule.lhs().getText();
			String action = rule.expr() == null ? null : rule.expr().getText();
			
			action = processAction(action, lhs);
			
			// This is actually multiple rules in one.
			if (rule.simpleRule().size() > 0)
			{
				for (SimpleRuleContext simpleRule : rule.simpleRule())
				{
					action = simpleRule.expr() == null ? null : simpleRule.expr().getText();
					action = processAction(action, lhs);
					
					out.add(
							convert(
								lhs,
								simpleRule.rulePart3(),
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
						rule.rulePart3(),
						action,
						grammar
					)
				);
			}
		}
	}
	
	/**
	 * - If this is a $start rule, then wrap the action in HoldComplete to
	 *   prevent it from evaluating.
	 * 
	 * @param action	the grammar action.
	 * @param lhs		the lhs symbol of the rule.
	 * @return			the action, possibly modified.
	 */
	private static String processAction(String action, String lhs)
	{
		if (action != null && "start".equals(lhs) && !action.isEmpty())
		{
			action = "HoldComplete[" + action + "]";
		}
		
		if (action == null)
		{
			
		}
		
		return action;
	}

	/**
	 * Convert a grammar rule.
	 * 
	 * @param lhs			the lhs symbol.
	 * @param ruleParts		the rule parts.
	 * @param action		the grammar action.
	 * @param grammar		the grammar.
	 */
	static GrammarRule convert(String lhs, List<RulePart3Context> ruleParts, String action, Grammar grammar)
	{
		List<IPattern> subPatterns = convert(ruleParts, grammar);
		IPattern pattern;
		
		// We'd LIKE to not "needlessly" wrap BasicPattern in SequencePattern
		// here, except that this isn't "needless", because BasicPattern
		// doesn't support having a result symbol, and currently we shoe-horn
		// IPattern into allowing a result symbol within the parser. So for
		// now, we will wrap basic patterns with SequencePattern. What this
		// means is that something like:
		// webpage: slashdot
		// ... becomes: webpage: SequencePattern[slashdot]
		
		if (subPatterns.size() == 1 && !(subPatterns.get(0) instanceof BasicPattern))
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
					Pattern.NO_LHS
				);
		}
		
		if (action == null)
		{
			if (pattern instanceof SequencePattern)
			{
				action = defaultAction((SequencePattern)pattern);
			}
		}
		
		GrammarRule rule =
			new GrammarRule(
				grammar,
				lhs,
				pattern,
				action
			);
		
		// Since we're currently also storing and using
		// the result symbol within the pattern itself,
		// we need to take care to replace the NO_LHS that
		// we originally gave the pattern with the LHS
		// that we now have for it.
		pattern.setSymbol(rule.getResultSymbolInt());
		
		return rule;
	}
	
	/**
	 * If a rule doesn't have an action, but it does have $symbol sub-patterns,
	 * then create a default action that uses the value of that sub-match.
	 * 
	 * @param pattern	the rule's pattern.
	 * @return			the action to use. (possibly null)
	 */
	public static String defaultAction(SequencePattern pattern)
	{
		// Any sub-patterns that are symbol patterns that have
		// a binding?
		for (IPattern subPattern : pattern.patterns())
		{
			if (subPattern instanceof SymbolPattern && subPattern.getBinding() != null)
			{
				return subPattern.getBinding();
			}
		}
		
		// Any sub-patterns that are at least a symbol pattern?
		for (IPattern subPattern : pattern.patterns())
		{
			if (subPattern instanceof SymbolPattern)
			{
				String symbol = ((SymbolPattern)subPattern).symbol().substring(1);
				subPattern.setBinding(symbol);
				return symbol;
			}
		}
		
		return null;
	}

	/**
	 * Convert a list of rule parts into a list of IPattern.
	 * 
	 * @param ruleParts		the rule parts.
	 * @param grammar		the grammar.
	 * @return				list of IPattern.
	 */
	static List<IPattern> convert(List<RulePart3Context> ruleParts, Grammar grammar)
	{
		List<IPattern> res = new ArrayList<IPattern>(ruleParts.size());
		for (RulePart3Context rulePart : ruleParts)
		{
			res.add(convert(rulePart, grammar));
		}
		return res;
	}
	
	/**
	 * Convert a list of rule parts into a list of IPattern.
	 * 
	 * @param ruleParts		the rule parts.
	 * @param grammar		the grammar.
	 * @return				list of IPattern.
	 */
	static List<IPattern> convert2(List<RulePartContext> ruleParts, Grammar grammar)
	{
		List<IPattern> res = new ArrayList<IPattern>(ruleParts.size());
		for (RulePartContext rulePart : ruleParts)
		{
			res.add(convert(rulePart, grammar));
		}
		return res;
	}
	
	static IPattern convert(RulePart3Context rulePart, Grammar grammar)
	{
		if (rulePart.rulePart() != null)
		{
			return convert(rulePart.rulePart(), grammar);
		}
		else
		{
			return convert(rulePart.rulePart2(), grammar);
		}
	}
	
	static IPattern convert(RulePart2Context rulePart, Grammar grammar)
	{
		return
			new OrPattern(
				convert3(rulePart.basicRulePart(), grammar),
				Pattern.NO_LHS
			);
	}
	
	static List<IPattern> convert3(List<BasicRulePartContext> ruleParts, Grammar grammar)
	{
		List<IPattern> res = new ArrayList<IPattern>(ruleParts.size());
		for (BasicRulePartContext rulePart : ruleParts)
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
					convert2(((OrRulePartContext) rulePart).rulePart(), grammar),
					Pattern.NO_LHS
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
						convert2(((SeqRulePartContext) rulePart).rulePart(), grammar),
						Pattern.NO_LHS
					);
			}
		}
		else if (rulePart instanceof BindingContext)
		{
			IPattern pattern = convert(((BindingContext) rulePart).rulePart(), grammar);
			pattern.setBinding(((BindingContext) rulePart).ID().getText());
			return pattern;
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
		else if (rulePart.STRING() != null)
		{
			String literal = rulePart.getText();
			literal = literal.substring(1, literal.length() - 1);
			
			List<IPatternMatch> subPatterns =
				grammar.getTokenizer().tokenize(grammar, literal, true);
			if (subPatterns.size() > 1)
			{
				List<IPattern> subPatterns2 = new ArrayList<IPattern>();
				for (IPatternMatch subPattern : subPatterns)
				{
					subPatterns2.add(subPattern.pattern());
				}
				return new SequencePattern(subPatterns2, Pattern.NO_LHS);
			}
			else
			{
				return new LiteralPattern(grammar, literal, -1, true);
			}
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
		//lexer.removeErrorListeners();
		lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);
		
		//parser.removeErrorListeners();
		parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
		
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
	
	/**
	 * Parses the given grammar rules.
	 * 
	 * @param grammarRules		the grammar rules.
	 * @return					the parsed grammar rules.
	 */
	public static List<GrammarRule> parseGrammar(String grammarRules)
	{
		return parseGrammar(new Grammar(), grammarRules);
	}
	
	/**
	 * Parses the given grammar rules.
	 * 
	 * @param grammarRules		the grammar rules.
	 * @return					the parsed grammar rules.
	 */
	public static List<GrammarRule> parseGrammar(Grammar grammar, String grammarRules)
	{
		RuleHandler ruleHandler = new RuleHandler(grammar);
		AntlrHelpers.parseGrammar(grammarRules, ruleHandler);
		return ruleHandler.getRules();
	}
}
