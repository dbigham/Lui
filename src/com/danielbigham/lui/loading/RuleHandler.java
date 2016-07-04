package com.danielbigham.lui.loading;

import java.util.List;

import com.danielbigham.lui.antlr.GrammarParser.GrammarRulesContext;
import com.danielbigham.lui.grammarrule.GrammarRule;

/**
 * Default implementation of IRuleHandler. Can be passed to code that
 * parses grammar rules (via ANTLR), which then calls this class's
 * handle method. The handle method converts the grammar rules to
 * LUI rules and stores them within the class for later retrieval.
 * 
 * @author danielb
 */
public class RuleHandler implements IRuleHandler
{
	private List<GrammarRule> rules;
	
	@Override
	public void handle(GrammarRulesContext rules)
	{
		this.rules = AntlrHelpers.convert(rules);
	}

	public List<GrammarRule> getRules()
	{
		return rules;
	}
}
