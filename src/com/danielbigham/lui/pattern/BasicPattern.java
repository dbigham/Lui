package com.danielbigham.lui.pattern;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.danielbigham.lui.Chart;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.patternmatch.IPatternMatch;

/**
 * A pattern that is either a LiteralPattern or a SymbolPattern, which
 * get associated with numeric token IDs, and can be used as things that
 * trigger higher-level patterns.
 * 
 * NOTE: There are lots of methods here that are not applicable since
 *       we implement IPattern but we don't patterns. This may imply that
 *       a better design would be to have INonBasicPattern, and have things
 *       like SequencePattern and OrPattern implement INonBasicPattern,
 *       and have NonBasicPattern if they could share some of that
 *       implementation. Not sure.
 * 
 * @author Daniel
 */
public abstract class BasicPattern implements IPattern, IPatternMatch
{
	protected int tokenId;
	protected int startPos;
	protected int endPos;
	
	BasicPattern(int startPos, int endPos)
	{
		this.startPos = startPos;
		this.endPos = endPos;
	}
	
	/**
	 * The numeric token ID associated with this literal or symbol.
	 */
	public Integer getTokenId()
	{
		return tokenId;
	}

	public int startPos()
	{
		return startPos;
	}

	public int endPos()
	{
		return endPos;
	}
	
	/**
	 * Given a starting position, and using the token ID of this pattern,
	 * returns the ending positions of all known matches, or null if
	 * there are none.
	 * 	
	 * @param startPos		the starting position of the matches we seek.
	 * @return				the list of ending positions of known matches. (or null if none)
	 */
	public Set<Integer> getMatchExtensionPositionsToRight(Chart chart, int startPos)
	{
		return chart.getMatchExtensionPositionsToRight(startPos, tokenId);
	}
	
	/**
	 * Given an ending position, and using the token ID of this pattern,
	 * returns the starting positions of all known matches, or null
	 * if there are none.
	 * 	
	 * @param endPos		the ending position of the matches we seek.
	 * @return				the list of starting positions of known matches. (or null if none)
	 */
	public Set<Integer> getMatchExtensionPositionsToLeft(Chart chart, int endPos)
	{
		return chart.getMatchExtensionPositionsToLeft(endPos, tokenId);
	}

	@Override
	public IPatternMatch toPatternMatch(int tokenId, int startPos, int endPos)
	{
		return this;
	}

	@Override
	public List<IPatternMatch> extendMatch(ParserState state, Set<Integer> extensionPositions)
	{
		// Basic patterns can't be extended.
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void extendMatchAsFarAsPossible(ParserState state)
	{
		// Basic patterns can't be extended.
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void extendMatchAsFarAsPossibleUsing(ParserState state, int dir, IPatternMatch nextPattern)
	{
		// Basic patterns can't be extended.
		throw new UnsupportedOperationException();
	}

	@Override
	public IPattern pattern()
	{
		return this;
	}

	@Override
	public boolean isMatchComplete()
	{
		// Basic patterns can't be extended, they are matched by definition.
		return true;
	}
	
	public int numTokensRequiredAtRight()
	{
		// Just a single token, so nothing more to match.
		return 0;
	}

	public int numTokensRequiredAtLeft()
	{
		// Just a single token, so nothing more to match.
		return 0;
	}

	public int length()
	{
		return 1;
	}

	@Override
	public List<IPattern> patterns()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public int resultSymbol()
	{
		return tokenId;
	}

	@Override
	public IPattern subPattern(int index)
	{
		throw new UnsupportedOperationException();
	}
	
	public int[] subPatternStartPositions()
	{
		throw new UnsupportedOperationException();
	}
	
	public IPatternMatch resultToSymbolPattern()
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public List<Integer> getTriggeringSubPatternIndices(Map<Integer, Integer> tokenCounts)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setTriggerIndices(List<Integer> triggerIndices)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IPattern explode(Grammar grammar)
	{
		// We don't need to explode basic patterns; they are already atoms.
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setSymbol(int newSymbol)
	{
		// We shouldn't need to override the symbol of basic patterns.
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IPattern create(List<IPattern> subPatterns, int resultSymbol)
	{
		// Only used by non-basic patterns.
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void setAction(String action)
	{
		// Only used by non-basic patterns.
		throw new UnsupportedOperationException();
	}
}
