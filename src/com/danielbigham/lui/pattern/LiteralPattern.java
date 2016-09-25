package com.danielbigham.lui.pattern;

import com.danielbigham.lui.Grammar;

/**
 * Represents a literal string that may be found in an input.
 * 
 * @author Daniel
 */
public class LiteralPattern extends BasicPattern
{
	// We don't strictly need to store the string representation
	// since we have the 'literalNum' but we will for now for
	// ease of debugging.
	private String literal;
	
	/**
	 * Create a LiteralPattern.
	 * 
	 * @param grammar				the grammar.
	 * @param literal				the literal string.
	 * @param pos					the input position. (token index)
	 * @param createTokenIds		create an ID for this literal string if necessary?
	 */
	public LiteralPattern(Grammar grammar, String literal, int pos, boolean createTokenIds)
	{
		super(pos, pos, "L");
		
		this.literal = literal;
		
		if (createTokenIds)
		{
			this.tokenId = grammar.getTokenIdAndDefineIfNecessary(literal);
		}
		else
		{
			this.tokenId = grammar.getTokenId(literal);
		}
	}
	
	/**
	 * Create a LiteralPattern.
	 * 
	 * @param grammar				the grammar.
	 * @param literal				the literal string.
	 * @param startPos				the starting input position.
	 * @param endPos				the ending input position.
	 * @param createTokenIds		create an ID for this literal string if necessary?
	 */
	public LiteralPattern(Grammar grammar, String literal, int startPos, int endPos, boolean createTokenIds)
	{
		super(startPos, endPos, "L");
		
		this.literal = literal;
		
		if (createTokenIds)
		{
			this.tokenId = grammar.getTokenIdAndDefineIfNecessary(literal);
		}
		else
		{
			this.tokenId = grammar.getTokenId(literal);
		}
	}
	
	/**
	 * The literal string that this pattern represents.
	 */
	public String getLiteral()
	{
		return literal;
	}
	
	public String toString()
	{
		return toStringHelper(literal);
	}
	
	public boolean subPatternsAreAllLiterals()
	{
		return true;
	}
}
