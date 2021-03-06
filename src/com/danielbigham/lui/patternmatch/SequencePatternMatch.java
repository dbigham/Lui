package com.danielbigham.lui.patternmatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.danielbigham.io.Out;
import com.danielbigham.lui.Chart;
import com.danielbigham.lui.ChartParser;
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
		
		List<IPatternMatch> newMatches;
		
		if (dir == 1)
		{
			newMatches = extendRight(state, extensionPositions);
		}
		else
		{
			newMatches = extendLeft(state, extensionPositions);
		}
		
		return newMatches;
	}
	
	public List<IPatternMatch> extendRight(ParserState state, Set<Integer> extensionPositions)
	{
		if (matchComplete) { throw new UnsupportedOperationException(); }
		
		List<IPatternMatch> newMatches = null;
		Chart chart = state.chart();
		boolean theMatchWereExtendingIsAlreadyInPartialsChart = (extensionPositions != null);
		BasicPattern nextPattern;
		
		nextPattern = (BasicPattern)pattern.subPattern(rightDot + 1);
		
		// Commented out this IF since we *do* now want all-literal sequence
		// patterns to add partials to the chart. Why? Because the global
		// alternatives system may add new literals to the chart after the
		// initial parse fails, which should be able to extend partials.
		//if (!pattern.subPatternsAreAllLiterals())
		//{
			if (!theMatchWereExtendingIsAlreadyInPartialsChart)
			{
				// Add this partial match to the partials chart.
				chart.addStartPosPartial(this, endPos + 1, nextPattern.resultSymbol(), state.iterationCounter());
			}
		//}
		
		if (extensionPositions == null)
		{
			extensionPositions = nextPattern.getMatchExtensionPositionsToRight(chart, endPos + 1);
		}
		
		// I guess this isn't required now that I'm using "rightDot + 1 < pattern.length()" below? (instead of "rightDot + 2")
//		if (extensionPositions == null && nextPattern.isOptional() && rightDot + 2 >= pattern.length() && endPos == state.getEndPos())
//		{
//			if (ChartParser.debugOptionals) { Out.print("Skipping right optional reaches end of input: " + this); }
//			extensionPositions = new HashSet<Integer>(Arrays.asList(endPos));
//		}
		
		if (extensionPositions != null)
		{
			newMatches = extendRightHelper(extensionPositions, rightDot + 1);
		}
		
		boolean nonOptionalMatches = newMatches != null;
		
		if (!nonOptionalMatches &&
			nextPattern.isOptional() &&
			!theMatchWereExtendingIsAlreadyInPartialsChart &&
			rightDot + 1 < pattern.length())
		{
			if (ChartParser.debugOptionals) { Out.print("Skipping right optional: " + this); }
			extensionPositions = new HashSet<Integer>(Arrays.asList(endPos));
			List<IPatternMatch> newMatches2 = extendRightHelper(extensionPositions, rightDot + 1);
			if (newMatches == null)
			{
				newMatches = newMatches2;
			}
			else
			{
				newMatches.addAll(newMatches2);
			}
		}
		
		if (!nonOptionalMatches)
		{
			List<IPatternMatch> newMatches2 = trySkippingWord(state, 1);
			if (newMatches == null)
			{
				newMatches = newMatches2;
			}
			else if (newMatches2 != null)
			{
				newMatches.addAll(newMatches2);
			}
		}
		
		return newMatches;
	}
	
	/**
	 * If the next word to the left/right (depending on which direction we're
	 * matching) is a skippable word, then skip the word.
	 * 
	 * @param state		The ParserState.
	 * @param dir		The direction we're trying to extend the match.
	 * @return			The new match (in a list) if the word was skippable,
	 * 					or null otherwise.
	 */
	private List<IPatternMatch> trySkippingWord(ParserState state, int dir)
	{
		List<Integer> skipPositions;
		List<IPatternMatch> newMatches = null;
		
		if (dir == 1)
		{
			skipPositions = state.getSkipRightPositions(endPos);
		}
		else
		{
			skipPositions = state.getSkipLeftPositions(startPos);
		}
		
		if (skipPositions != null)
		{
			for (Integer pos : skipPositions)
			{
				
				int[] newSubPatternStartPositions = subPatternStartPositions.clone();
				int startPos = this.startPos;
				int endPos = this.endPos;
				if (dir == 1)
				{
					endPos = pos;
				}
				else
				{
					startPos = pos;
				}
				SequencePatternMatch newMatch = new SequencePatternMatch(pattern, startPos, endPos, leftDot, rightDot, dir, newSubPatternStartPositions);
				newMatches = new ArrayList<>();
				newMatches.add(newMatch);
				if (ChartParser.debugMatchExtension || ChartParser.debugSkipping) { Out.print("Skipping skippable word."); }
			}
		}
		
		return newMatches;
	}
	
	public List<IPatternMatch> extendLeft(ParserState state, Set<Integer> extensionPositions)
	{
		if (matchComplete) { throw new UnsupportedOperationException(); }
		
		List<IPatternMatch> newMatches = null;
		Chart chart = state.chart();
		boolean theMatchWereExtendingIsAlreadyInPartialsChart = (extensionPositions != null);
		BasicPattern nextPattern;
	
		nextPattern = (BasicPattern)pattern.subPattern(leftDot - 1);
		
		// Commented out this IF since we *do* now want all-literal sequence
		// patterns to add partials to the chart. Why? Because the global
		// alternatives system may add new literals to the chart after the
		// initial parse fails, which should be able to extend partials.
		//if (!pattern.subPatternsAreAllLiterals())
		//{
			if (!theMatchWereExtendingIsAlreadyInPartialsChart)
			{
				// Add this partial match to the partials chart.
				chart.addEndPosPartial(this, startPos - 1, nextPattern.resultSymbol(), state.iterationCounter());
			}
		//}
		
		if (extensionPositions == null)
		{
			extensionPositions = nextPattern.getMatchExtensionPositionsToLeft(chart, startPos - 1);
		}
		
		// I guess this isn't required now that I'm using "leftDot - 1 >= 0" below? (instead of "leftDot - 2")
//		if (extensionPositions == null && nextPattern.isOptional() && leftDot - 2 < 0 && startPos == 0)
//		{
//			if (ChartParser.debugOptionals) { Out.print("Skipping left optional reaches start of input: " + this); }
//			extensionPositions = new HashSet<Integer>(Arrays.asList(0));
//		}
		
		if (extensionPositions != null)
		{
			newMatches = extendLeftHelper(state, extensionPositions, leftDot - 1);
		}
		
		boolean nonOptionalMatches = newMatches != null;
		
		if (!nonOptionalMatches &&
			nextPattern.isOptional() &&
			!theMatchWereExtendingIsAlreadyInPartialsChart &&
			leftDot - 1 >= 0)
		{
			if (ChartParser.debugOptionals) { Out.print("Skipping left optional: " + this); }
			extensionPositions = new HashSet<Integer>(Arrays.asList(startPos));
			List<IPatternMatch> newMatches2 = extendLeftHelper(state, extensionPositions, leftDot - 1);
			if (newMatches == null)
			{
				newMatches = newMatches2;
			}
			else
			{
				newMatches.addAll(newMatches2);
			}
		}
		
		if (!nonOptionalMatches)
		{
			List<IPatternMatch> newMatches2 = trySkippingWord(state, -1);
			if (newMatches == null)
			{
				newMatches = newMatches2;
			}
			else if (newMatches2 != null)
			{
				newMatches.addAll(newMatches2);
			}
		}
		
		return newMatches;
	}
	
	/**
	 * Create a new pattern match by extending this one to the right.
	 */
	private List<IPatternMatch> extendRightHelper(Set<Integer> extensionPositions, int newRightDot)
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
			
			if (ChartParser.debugMatchExtension) { Out.print("Extended right: " + newMatch); }
			
			res.add(newMatch);
		}
		return res;
	}
	
	/**
	 * Create a new pattern match by extending this one to the left.
	 */
	private List<IPatternMatch> extendLeftHelper(ParserState state, Set<Integer> extensionPositions, int newLeftDot)
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
			
			if (ChartParser.debugMatchExtension) { Out.print("Extended left: " + newMatch); }
			
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
			if (patternIndex > 0)
			{
				str.append(' ');
			}
			
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
