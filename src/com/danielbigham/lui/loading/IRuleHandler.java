package com.danielbigham.lui.loading;

import com.danielbigham.lui.antlr.GrammarParser.GrammarRulesContext;

/**
 * Classes that can accept a list of ANTLR-parsed rules and do
 * something with them.
 * 
 * @author danielb
 */
public interface IRuleHandler
{
	public void handle(GrammarRulesContext rules);
}
