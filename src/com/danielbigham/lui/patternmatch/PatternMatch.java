package com.danielbigham.lui.patternmatch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.danielbigham.io.Out;
import com.danielbigham.lui.Chart;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.pattern.BasicPattern;
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
			
			if (newMatch.isMatchComplete())
			{
				state.matchCompleted(newMatch, state);
			}
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
	
	public String toString(Grammar grammar)
	{
		String resultSymbol = grammar.getSymbolOrLiteral(pattern.resultSymbol());
		return resultSymbol + ": " + this.toString();
	}
	
	
	public void toWL(StringBuilder wl, ParserState state)
	{
		//Out.print(startPos + "-" + endPos + ": " + pattern.toString2(state.grammar()));
		
		wl.append("{{");
		wl.append(pattern.resultSymbol()).append(",");
		wl.append(startPos).append(",");
		wl.append(endPos).append("},\"");
		wl.append(pattern.getType()).append("\",");
		wl.append("HoldComplete[");
		String action = pattern.getAction();
		wl.append(action == null ? "Null" : action).append("],");

		// Children
		int[] subMatchPos = subPatternStartPositions();
		int i = 0;
		int subMatchStartPos;
		int subMatchEndPos;
		Chart chart = state.chart();
		wl.append("{");
		for (IPattern subPattern : getMatchedSubPatterns())
		{
			subMatchStartPos = subMatchPos[i];
			subMatchEndPos = subMatchPos[i+1] - 1;
			
			wl.append("{{");
			wl.append(subPattern.resultSymbol()).append(",");
			wl.append(subMatchStartPos).append(",");
			wl.append(subMatchEndPos).append("},\"");
			wl.append(subPattern.getType()).append("\",");
			String binding = subPattern.getBinding();
			if (binding == null)
			{
				wl.append("Null");
			}
			else
			{
				wl.append("HoldComplete[").append(binding).append("]");
			}
			wl.append("}");
			
			if (i < subMatchPos.length - 2)
			{
				wl.append(",");
			}
			
			++i;
		}
		wl.append("}");
		
		wl.append("},");
		
		// Recurse on children
		i = 0;
		for (IPattern subPattern : getMatchedSubPatterns())
		{
			subMatchStartPos = subMatchPos[i];
			subMatchEndPos = subMatchPos[i+1] - 1;
			
			List<IPatternMatch> subPatternMatches =
					chart.getMatchesForSpan(subPattern.resultSymbol(), subMatchStartPos, subMatchEndPos);
			
			//Out.print("    Sub-pattern: " + startPos + "-" + endPos + ":" + subPattern + ":");
			//Out.print("        Chart matches: " +  subPatternMatches);
			
			if (subPatternMatches != null)
			{
				for (IPatternMatch subMatch : subPatternMatches)
				{
					subMatch.toWL(wl, state);
				}
			}
			
			++i;
		}
	}
	
	public void setStartEnd(int newStart, int newEnd)
	{
		this.startPos = newStart;
		this.endPos = newEnd;
	}
}
