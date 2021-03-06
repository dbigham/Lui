package com.danielbigham.lui.grammarrule;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.pattern.IPattern;

/**
 * Represents a grammar rule.
 * 
 * @author danielb
 */
public class GrammarRule
{
	private final String resultSymbol;
	private final int resultSymbolInt;
	private final IPattern pattern;
	private final String action;
	
	public GrammarRule(Grammar grammar, String resultSymbol, IPattern pattern, String action)
	{
		super();
		String symbol = resultSymbol;
		if (Character.isLetter(symbol.charAt(0)))
		{
			// If no symbol character (such as "$" or "~") was explicitly
			// specified in front of the grammar rule's LHS, then assume
			// they meant '$'.
			symbol = "$" + symbol;
		}
		this.resultSymbol = symbol;
		this.resultSymbolInt = grammar.getTokenIdAndDefineIfNecessary(symbol);
		this.pattern = pattern;
		this.action = action;
	}
	
	/**
	 * @return the result symbol.
	 */
	public String getResultSymbol()
	{
		return resultSymbol;
	}
	
	/**
	 * @return the result symbol integer.
	 */
	public int getResultSymbolInt()
	{
		return resultSymbolInt;
	}

	/**
	 * @return the rule's pattern.
	 */
	public IPattern getPattern()
	{
		return pattern;
	}

	/**
	 * @return the rule's action.
	 */
	public String getAction()
	{
		return action;
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		
		str.append(resultSymbol)
			.append(":\n    ")
				.append(pattern.toString())
			.append("\n        ")
				.append(action);
		
		return str.toString();
	}

	/**
	 * Explode nested patterns so that every pattern only has basic
	 * patterns as its sub-patterns. Introduce new grammar symbols as
	 * necessary. Calls grammar.addFinalPattern to accrue the final set
	 * of patterns.
	 * 
	 * See also: Rule Explosion.md
	 * 
	 * @param grammar		the grammar.
	 */
	public void explode(Grammar grammar)
	{
		IPattern explodedPattern = pattern.explode(grammar);
		explodedPattern.setAction(action);
	}
}
