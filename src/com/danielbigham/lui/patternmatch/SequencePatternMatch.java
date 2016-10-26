package com.danielbigham.lui.patternmatch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.danielbigham.io.Out;
import com.danielbigham.lui.Chart;
import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.pattern.BasicPattern;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.SequencePattern;

/**
 * A pattern that consists of one or more sub-patterns, where each
 * pattern must be matched in a contiguous fashion from left to right.
 * 
 * @author Daniel
 */
public class SequencePatternMatch extends PatternMatch
{
	private final SequencePattern pattern;
	private final int[] subPatternStartPositions;
	private final int leftDot;
	private final int rightDot;
	private final int dir;
	
	public SequencePatternMatch(SequencePattern pattern, int startPos, int endPos)
	{
		this(
			pattern,
			startPos,
			endPos,
			pattern.getTriggerIndices().get(0),
			pattern.getTriggerIndices().get(0),
			(pattern.getTriggerIndices().get(0) >= pattern.length() - 1) ? -1 : 1,
			new int[pattern.patterns().size() + 1]
		);
		
		subPatternStartPositions[pattern.getTriggerIndices().get(0)] = startPos;
		subPatternStartPositions[pattern.getTriggerIndices().get(0) + 1] = endPos + 1;
	}
	
	private SequencePatternMatch(
			SequencePattern pattern,
			int startPos,
			int endPos,
			int leftDot,
			int rightDot,
			int dir,
			int[] subPatternStartPositions)
	{
		this.pattern = pattern;
		super.pattern = pattern;
		this.subPatternStartPositions = subPatternStartPositions;
		this.startPos = startPos;
		this.endPos = endPos;
		this.leftDot = leftDot;
		this.rightDot = rightDot;
		this.dir = dir;
		
		if (leftDot == 0 && rightDot == pattern.patterns().size() - 1)
		{
			matchComplete = true;
		}
	}
	
	public List<IPatternMatch> extendMatch(ParserState state, Set<Integer> extensionPositions)
	{
		if (matchComplete) { throw new UnsupportedOperationException(); }
		
		List<IPatternMatch> newMatches = null;
		List<IPatternMatch> newMatches2 = null;
		
		Chart chart = state.chart();
		
		boolean theMatchWereExtendingIsAlreadyInPartialsChart = (extensionPositions != null);
		
		BasicPattern nextPattern;
		if (dir == 1)
		{
			nextPattern = (BasicPattern)pattern.subPattern(rightDot + 1);
			
			// Add this partial match to the partials chart.
			if (!pattern.subPatternsAreAllLiterals())
			{
				if (!theMatchWereExtendingIsAlreadyInPartialsChart)
				{
					chart.addStartPosPartial(this, endPos + 1, nextPattern.resultSymbol(), state.iterationCounter());
				}
			}
			
			if (extensionPositions == null)
			{
				extensionPositions = nextPattern.getMatchExtensionPositionsToRight(chart, endPos + 1);
			}
			
			boolean extendedAlready = false;
			if (extensionPositions != null)
			{
				extendedAlready = true;
				newMatches = extendRight(extensionPositions, rightDot + 1);
			}
			
			if (nextPattern.isOptional() && !theMatchWereExtendingIsAlreadyInPartialsChart)
			{
				// Also try extending the match by skipping the optional.
				int offset = 2;
				extensionPositions = null;
				if (rightDot + offset < pattern.length())
				{
					nextPattern = (BasicPattern)pattern.subPattern(rightDot + offset);
					extensionPositions = nextPattern.getMatchExtensionPositionsToRight(chart, endPos + 1);
				}
				else if (!extendedAlready)
				{
					// A complete match then, since the last pattern is optional.
					extensionPositions = new HashSet<Integer>();
					offset = 1;
					extensionPositions.add(endPos);
				}
					
				if (extensionPositions != null)
				{
					newMatches2 = extendRight(extensionPositions, rightDot + offset);
					if (newMatches == null)
					{
						newMatches = newMatches2;
					}
					else
					{
						newMatches.addAll(newMatches2);
					}
				}
			}
		}
		else
		{
			nextPattern = (BasicPattern)pattern.subPattern(leftDot - 1);
			
			// Add this partial match to the partials chart.
			if (!pattern.subPatternsAreAllLiterals())
			{
				if (!theMatchWereExtendingIsAlreadyInPartialsChart)
				{
					chart.addEndPosPartial(this, startPos - 1, nextPattern.resultSymbol(), state.iterationCounter());
				}
			}
			
			if (extensionPositions == null)
			{
				extensionPositions = nextPattern.getMatchExtensionPositionsToLeft(chart, startPos - 1);
			}
			
			boolean extendedAlready = false;
			
			if (extensionPositions != null)
			{
				extendedAlready = true;
				newMatches = extendLeft(state, extensionPositions, leftDot - 1);
			}
			
			if (nextPattern.isOptional() && !theMatchWereExtendingIsAlreadyInPartialsChart)
			{
				// Also try extending the match by skipping the optional.
				int offset = 2;
				extensionPositions = null;
				if (leftDot - offset >= 0)
				{
					nextPattern = (BasicPattern)pattern.subPattern(leftDot - offset);
					extensionPositions = nextPattern.getMatchExtensionPositionsToLeft(chart, startPos - 1);
				}
				else if (!extendedAlready)
				{
					// A complete match then, since the last pattern is optional.
					extensionPositions = new HashSet<Integer>();
					offset = 1;
					extensionPositions.add(0);
				}
				
				if (extensionPositions != null)
				{
					newMatches2 = extendLeft(state, extensionPositions, leftDot - offset);
					if (newMatches == null)
					{
						newMatches = newMatches2;
					}
					else
					{
						newMatches.addAll(newMatches2);
					}
				}
			}
		}
		
		return newMatches;
	}
	
	/**
	 * Create a new pattern match by extending this one to the right.
	 */
	private List<IPatternMatch> extendRight(Set<Integer> extensionPositions, int newRightDot)
	{
		List<IPatternMatch> res = new ArrayList<IPatternMatch>();
		
		for (Integer newEndPos : extensionPositions)
		{
			int newDir;
			if (newRightDot == pattern.length() - 1)
			{
				// We've matched as far as we can to the right, now
				// try matching to the left.
				newDir = -1;
			}
			else
			{
				newDir = dir;
			}
			
			int[] newSubPatternStartPositions = subPatternStartPositions.clone();
			newSubPatternStartPositions[newRightDot + 1] = newEndPos + 1;
			
			SequencePatternMatch newMatch = new SequencePatternMatch(pattern, startPos, newEndPos, leftDot, newRightDot, newDir, newSubPatternStartPositions);
			
			// If we just matched as far as we could to the right, but we're already
			// done matching to the left, then mark this match as complete.
			if (newDir == -1 && leftDot == 0)
			{
				newMatch.matchComplete = true;
			}
			
			res.add(newMatch);
		}
		return res;
	}
	
	/**
	 * Create a new pattern match by extending this one to the left.
	 */
	private List<IPatternMatch> extendLeft(ParserState state, Set<Integer> extensionPositions, int newLeftDot)
	{
		List<IPatternMatch> res = new ArrayList<IPatternMatch>();
		
		for (Integer newStartPos : extensionPositions)
		{
			int[] newSubPatternStartPositions = subPatternStartPositions.clone();
			newSubPatternStartPositions[newLeftDot] = newStartPos;
			
			SequencePatternMatch newMatch =
					new SequencePatternMatch(pattern, newStartPos, endPos, newLeftDot, rightDot, dir, newSubPatternStartPositions);
			
			if (newLeftDot == 0)
			{
				// We've matched as far as we can both to the right
				// and to the left, so we have a complete match.
				newMatch.matchComplete = true;
			}
			
			res.add(newMatch);
		}
		
		return res;
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("{");
		int patternIndex = 0;
		for(IPattern subPattern : pattern.patterns())
		{
			if (patternIndex == leftDot)
			{
				str.append(".");
			}
			str.append(subPattern.toString());
			if (patternIndex == rightDot)
			{
				str.append(".");
			}
			++patternIndex;
		}
		str.append("}");
		return str.toString();
	}
	
	public int numTokensRequiredAtRight()
	{
		return pattern.length() - rightDot - 1;
	}

	public int numTokensRequiredAtLeft()
	{
		return leftDot;
	}
	
	public int[] subPatternStartPositions()
	{
		return subPatternStartPositions;
	}
	
	@Override
	public List<IPattern> getMatchedSubPatterns()
	{
		// Until we have optionals, we return everything here.
		if (matchComplete)
		{
			return pattern.patterns();
		}
		else
		{
			throw new UnsupportedOperationException();
		}
	}
	
	@Override
	public String expr()
	{
		return null;
	}
}
