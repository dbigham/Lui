package com.danielbigham.lui.pattern;

import java.util.ArrayList;
import java.util.List;

import com.danielbigham.lui.EvaluationResult;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.ParserState;

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
		
		literal = literal.toLowerCase();
		
		// For now we want to be case insensitive.
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

	@Override
	public EvaluationResult evaluate(ParserState state, int subMatchStartPos, int subMatchEndPos)
	{
		if (binding != null)
		{
			List<String> exprs = new ArrayList<String>();
			exprs.add(literal);
			EvaluationResult res = new EvaluationResult(exprs);
			// Populate the variable
			res.populateVariable(binding);
			return res;
		}
		else
		{
			// If there isn't any binding, then this sub-pattern
			// can't affect the final expression, so just return
			// null.
			
			// But what if there's a rule who's LHS is only a literal, and it doesn't
			// have an action -- but it's used in a higher up rule that does have
			// a binding on it's use? TBD.
//			List<String> exprs = new ArrayList<String>();
//			exprs.add(literal);
//			EvaluationResult res = new EvaluationResult(exprs);
			
			return null;
		}
	}

	@Override
	public String toString(boolean decorate)
	{
		return toString();
	}
}
