package com.danielbigham.lui.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.danielbigham.lui.patternmatch.IPatternMatch;

public class OptionalPattern extends Pattern implements IPattern
{
	public OptionalPattern(IPattern pattern, int resultSymbol)
	{		
		super(null, resultSymbol, PatternType.OPTIONAL);
		
		this.patterns = new ArrayList<IPattern>(1);
		this.patterns.add(pattern);
	}
	
	@Override
	public IPattern create(List<IPattern> subPatterns, int resultSymbol)
	{
		return new OptionalPattern(subPatterns.get(0), resultSymbol);
	}

	@Override
	public IPatternMatch toPatternMatch(int tokenId, int startPos, int endPos)
	{
		// TODO
		throw new UnsupportedOperationException();
	}
	
	@Override
	public List<Integer> getTriggeringSubPatternIndices(Map<Integer, Integer> tokenCounts)
	{
		// TODO
		throw new UnsupportedOperationException();
	}
}
