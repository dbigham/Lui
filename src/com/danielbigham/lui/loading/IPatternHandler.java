package com.danielbigham.lui.loading;

import com.danielbigham.lui.antlr.GrammarParser.RulePatternContext;

/**
 * Classes that can accept a list of ANTLR-parsed rule patterns.
 * 
 * @author danielb
 */
public interface IPatternHandler
{
	public void handle(RulePatternContext rules);
}
