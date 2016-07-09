package com.danielbigham.lui.pattern;


import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public class SymbolPattern extends BasicPattern implements IPatternMatch
{
	// We don't strictly need to store the string representation
	// since we have the 'literalNum' but we will for now for
	// ease of debugging.
	private String symbol;
	
	/**
	 * Create a SymbolPattern.
	 * 
	 * @param grammar				the grammar.
	 * @param symbol				the symbol.
	 * @param startPos				the starting input position.
	 * @param endPos				the ending input position.
	 * @param createTokenIds		create an ID for this symbol if necessary?
	 */
	public SymbolPattern(Grammar grammar, String symbol, int startPos, int endPos, boolean createTokenIds)
	{
		super(startPos, endPos, "S");
		
		this.symbol = symbol;
		if (createTokenIds)
		{
			this.tokenId = grammar.getTokenIdAndDefineIfNecessary(symbol);
		}
		else
		{
			this.tokenId = grammar.getTokenId(symbol);
		}
	}
	
	/**
	 * Create a SymbolPattern.
	 * 
	 * @param symbol			the symbol ID.
	 * @param startPos			the starting input position.
	 * @param endPos			the ending input position.
	 */
	public SymbolPattern(int symbol, int startPos, int endPos)
	{
		super(startPos, endPos, "S");
		this.tokenId = symbol;
	}
	
	/**
	 * Create a SymbolPattern.
	 * 
	 * @param symbol			the symbol.
	 * @param symbolInt			the symbol ID.
	 * @param startPos			the starting input position.
	 * @param endPos			the ending input position.
	 */
	public SymbolPattern(String symbol, int symbolInt, int startPos, int endPos)
	{
		super(startPos, endPos, "S");
		this.symbol = symbol;
		this.tokenId = symbolInt;
	}

	public String symbol()
	{
		return symbol;
	}
	
	public String toString()
	{
		if (symbol != null)
		{
			StringBuilder str = new StringBuilder(symbol.length() + 7);
			return toStringHelper(str.append("<").append(symbol).append(":").append(tokenId).append(">").toString());
		}
		else
		{
			StringBuilder str = new StringBuilder(11);
			return toStringHelper(str.append("<?:").append(tokenId).append(">").toString());
		}
	}
	
	public boolean subPatternsAreAllLiterals()
	{
		return false;
	}
}
