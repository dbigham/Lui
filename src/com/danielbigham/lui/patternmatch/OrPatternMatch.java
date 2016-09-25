package com.danielbigham.lui.patternmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.OrPattern;

/**
 * Any one of the sub-patterns must match. (OR)
 * 
 * @author Daniel
 */
public class OrPatternMatch extends PatternMatch
{
	private final OrPattern pattern;
	private final int subPatternIndex;
	
	public OrPatternMatch(
			OrPattern pattern,
			int startPos,
			int endPos,
			int subPatternIndex)
	{
		this.pattern = pattern;
		super.pattern = pattern;
		this.startPos = startPos;
		this.endPos = endPos;
		this.subPatternIndex = subPatternIndex;
		matchComplete = true;
	}
	
	public List<IPatternMatch> extendMatch(ParserState state, Set<Integer> extensionPositions)
	{
		// OR patterns are completely matched as soon as they are triggered.
		throw new UnsupportedOperationException();
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		int patternIndex = 0;
		for(IPattern subPattern : pattern.patterns())
		{
			if (patternIndex > 0) { str.append("|"); }
			if (patternIndex == subPatternIndex)
			{
				str.append("<");
			}
			str.append(subPattern.toString());
			if (patternIndex == subPatternIndex)
			{
				str.append(">");
			}
			++patternIndex;
		}
		return str.toString();
	}
	
	public int numTokensRequiredAtRight()
	{
		return 0;
	}

	public int numTokensRequiredAtLeft()
	{
		return 0;
	}
	
	public int[] subPatternStartPositions()
	{
		int[] res = new int[2];
		res[0] = startPos;
		res[1] = endPos + 1;
		return res;
	}

	@Override
	public List<IPattern> getMatchedSubPatterns()
	{
		if (matchComplete)
		{
			List<IPattern> list = new ArrayList<IPattern>(1);
			list.add(pattern.patterns().get(subPatternIndex));
			return list;
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
