package com.danielbigham.lui.patternmatch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.SymbolPattern;

/**
 * Represents an active attempt to match a particular pattern
 * on a particular input.
 * 
 * @author Daniel
 */
public abstract class PatternMatch implements IPatternMatch
{
	protected IPattern pattern;
	protected boolean matchComplete;
	protected int startPos;
	protected int endPos;
	
	public int startPos()
	{
		return startPos;
	}

	public int endPos()
	{
		return endPos;
	}
	
	public void extendMatchAsFarAsPossible(ParserState state)
	{
		List<IPatternMatch> extendedMatches;
		if (!matchComplete)
		{
			extendedMatches = extendMatch(state, null);
			if (extendedMatches != null)
			{
				for (IPatternMatch match : extendedMatches)
				{
					if (match.isMatchComplete())
					{
						state.matchCompleted(match, state);
					}
				}
				
				for (IPatternMatch match : extendedMatches)
				{
					// Continue extending the matches as far as possible.
					match.extendMatchAsFarAsPossible(state);
				}
			}
		}
	}
	
	@Override
	public void extendMatchAsFarAsPossibleUsing(ParserState state, int dir, IPatternMatch nextMatch)
	{
		Set<Integer> extensionPositions = new HashSet<Integer>(1);
		if (dir == 1)
		{
			extensionPositions.add(nextMatch.endPos());
		}
		else
		{
			extensionPositions.add(nextMatch.startPos());
		}
		
		List<IPatternMatch> newMatches = extendMatch(state, extensionPositions);
		
		for (IPatternMatch newMatch : newMatches)
		{
			// Continue extending the matches as far as possible.
			newMatch.extendMatchAsFarAsPossible(state);
		}
	}
	
	public IPattern pattern()
	{
		return pattern;
	}

	public boolean isMatchComplete()
	{
		return matchComplete;
	}
	
	public IPatternMatch resultToSymbolPattern()
	{
		return new SymbolPattern(pattern.resultSymbol(), startPos, endPos);
	}
}
