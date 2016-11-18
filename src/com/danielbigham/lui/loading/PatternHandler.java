package com.danielbigham.lui.loading;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.antlr.GrammarParser.RulePatternContext;
import com.danielbigham.lui.pattern.IPattern;

/**
 * Default implementation of IPatternHandler. Can be passed to code that
 * parses grammar patterns (via ANTLR), which then calls this class's
 * handle method. The handle method stores the patterns for later
 * retrieval.
 * 
 * @author danielb
 */
public class PatternHandler implements IPatternHandler
{
	private IPattern pattern;
	private Grammar grammar;
	
	public PatternHandler(Grammar grammar)
	{
		this.grammar = grammar;
	}
	
	@Override
	public void handle(RulePatternContext pattern)
	{
		this.pattern = (IPattern) AntlrHelpers.convertPattern(pattern.rulePart3(), grammar);
	}

	public IPattern getPattern()
	{
		return pattern;
	}
}
