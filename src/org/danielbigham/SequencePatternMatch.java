package org.danielbigham;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
			pattern.triggerIndex,
			pattern.triggerIndex,
			(pattern.triggerIndex >= pattern.length() - 1) ? -1 : 1,
			new int[pattern.patterns().size() + 1]
		);
		
		subPatternStartPositions[pattern.triggerIndex] = startPos;
		subPatternStartPositions[pattern.triggerIndex + 1] = endPos + 1;
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
		
		Chart chart = state.chart();
		
		BasicPattern nextPattern;
		if (dir == 1)
		{
			nextPattern = (BasicPattern)pattern.subPattern(rightDot + 1);
			
			// Add this partial match to the partials chart.
			if (!pattern.subPatternsAreAllLiterals())
			{
				boolean theMatchWereExtendingIsAlreadyInPartialsChart = extensionPositions != null;
				if (!theMatchWereExtendingIsAlreadyInPartialsChart)
				{
					chart.addStartPosPartial(this, endPos + 1, nextPattern.resultSymbol());
				}
			}
			
			if (extensionPositions == null)
			{
				extensionPositions = nextPattern.getMatchExtensionPositionsToRight(chart, endPos + 1);
			}
			
			if (extensionPositions != null)
			{
				newMatches = extendRight(extensionPositions);
			}
		}
		else
		{
			nextPattern = (BasicPattern)pattern.subPattern(leftDot - 1);
			
			// Add this partial match to the partials chart.
			if (!pattern.subPatternsAreAllLiterals() && extensionPositions == null)
			{
				boolean theMatchWereExtendingIsAlreadyInPartialsChart = extensionPositions != null;
				if (!theMatchWereExtendingIsAlreadyInPartialsChart)
				{
					chart.addEndPosPartial(this, startPos - 1, nextPattern.resultSymbol());
				}
			}
			
			if (extensionPositions == null)
			{
				extensionPositions = nextPattern.getMatchExtensionPositionsToLeft(chart, startPos - 1);
			}
			
			if (extensionPositions != null)
			{
				newMatches = extendLeft(state, extensionPositions);
			}
		}
		
		return newMatches;
	}
	
	/**
	 * Create a new pattern match by extending this one to the right.
	 */
	private List<IPatternMatch> extendRight(Set<Integer> extensionPositions)
	{
		List<IPatternMatch> res = new ArrayList<IPatternMatch>();
		
		for (Integer newEndPos : extensionPositions)
		{
			int newRightDot = rightDot + 1;
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
	private List<IPatternMatch> extendLeft(ParserState state, Set<Integer> extensionPositions)
	{
		List<IPatternMatch> res = new ArrayList<IPatternMatch>();
		
		for (Integer newStartPos : extensionPositions)
		{
			int newLeftDot = leftDot - 1;
			
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
}
