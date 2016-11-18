package com.danielbigham.lui.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.patternmatch.IPatternMatch;
import com.danielbigham.lui.patternmatch.SequencePatternMatch;


/**
 * A pattern that consists of one or more sub-patterns, where each
 * pattern must be matched in a contiguous fashion from left to right.
 * 
 * @author Daniel
 */
public class SequencePattern extends Pattern implements IPattern
{
	public SequencePattern(List<IPattern> patterns, int resultSymbol)
	{
		super(patterns, resultSymbol, PatternType.SEQUENCE);
	}
	
	@Override
	public IPattern create(List<IPattern> subPatterns, int resultSymbol)
	{
		return new SequencePattern(subPatterns, resultSymbol);
	}
	
	public static SequencePattern create(Grammar grammar, String str, int resultSymbol)
	{
		return new SequencePattern(Pattern.parse(grammar, str), resultSymbol);
	}
	
	public String toString()
	{
		return toString(true);
	}
	
	public String toString(boolean decorate)
	{
		StringBuilder str = new StringBuilder();
		if (decorate) { str.append("{"); } else { str.append("("); }
		int patternIndex = 0;
		int triggerIndex = -1;
		if (getTriggerIndices() != null)
		{
			triggerIndex = getTriggerIndices().get(0);
		}
		for(IPattern subPattern : patterns)
		{
			if (patternIndex > 0) { str.append(" "); }
			if (patternIndex == triggerIndex)
			{
				// Double carets denote the sub-pattern
				// that is playing the role of trigger.
				if (decorate) { str.append("<"); }
			}
			str.append(subPattern.toString(decorate));
			if (patternIndex == triggerIndex)
			{
				if (decorate) { str.append(">"); }
			}
			++patternIndex;
		}
		if (decorate) { str.append("}"); } else { str.append(")"); }
		return toStringHelper(str.toString());
	}

	@Override
	public IPatternMatch toPatternMatch(int tokenId, int startPos, int endPos)
	{
		return new SequencePatternMatch(this, startPos, endPos);
	}
	
	@Override
	public List<Integer> getTriggeringSubPatternIndices(Map<Integer, Integer> tokenCounts)
	{
		// For sequence patterns, we use the rarest sub-pattern as the trigger.
		int rarest = getIndexOfRarestSubPattern(tokenCounts);
		
		List<Integer> res = new ArrayList<Integer>(1);
		res.add(rarest);
		
		return res;
	}
}
