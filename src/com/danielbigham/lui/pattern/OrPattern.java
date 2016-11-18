package com.danielbigham.lui.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.patternmatch.IPatternMatch;
import com.danielbigham.lui.patternmatch.OrPatternMatch;

public class OrPattern extends Pattern implements IPattern
{
	public OrPattern(List<IPattern> patterns, int resultSymbol)
	{		
		super(patterns, resultSymbol, PatternType.OR);
	}
	
	@Override
	public IPattern create(List<IPattern> subPatterns, int resultSymbol)
	{
		return new OrPattern(subPatterns, resultSymbol);
	}
	
	public static OrPattern create(Grammar grammar, String str, int resultSymbol)
	{
		return new OrPattern(Pattern.parse(grammar, str), resultSymbol);
	}
	
	@Override
	public IPatternMatch toPatternMatch(int tokenId, int startPos, int endPos)
	{
		// TODO
		// Inefficient to iterate here to find the sub-pattern index. Should
		// we store that in our trigger table?
		int subPatternIndex = -1;
		for (int i = 0; i < patterns.size(); ++i)
		{
			if (((BasicPattern)patterns.get(i)).getTokenId() == tokenId)
			{
				subPatternIndex = i;
				break;
			}
		}
		if (subPatternIndex == -1)
		{
			throw new IllegalArgumentException("OrPattern: Couldn't find subpattern with token ID " + tokenId);
		}
		return new OrPatternMatch(this, startPos, endPos, subPatternIndex);
	}
	
	@Override
	public List<Integer> getTriggeringSubPatternIndices(Map<Integer, Integer> tokenCounts)
	{
		List<Integer> res = new ArrayList<Integer>();
		// Could be optimized to return something that indicates Range[1, n]
		// rather than a literal list.
		for (int i = 0 ; i < patterns.size(); ++i)
		{
			res.add(i);
		}
		return res;
	}
	
	public String toString(boolean decorate)
	{
		StringBuilder str = new StringBuilder();
		int patternIndex = 0;
		str.append("(");
		for(IPattern subPattern : patterns)
		{
			if (patternIndex > 0) { str.append("|"); }
			str.append(subPattern.toString(decorate));
			++patternIndex;
		}
		str.append(")");
		return toStringHelper(str.toString());
	}
	
	@Override
	public String toString()
	{
		return toString(true);
	}
}
