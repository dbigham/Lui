package com.danielbigham.lui.pattern;

import java.util.List;

import com.danielbigham.lui.patternmatch.IPatternMatch;

public class OrPattern extends Pattern implements IPattern
{
	public OrPattern(List<IPattern> patterns, int resultSymbol)
	{		
		super(patterns, resultSymbol);
	}
	
	@Override
	public IPatternMatch toPatternMatch(int startPos, int endPos)
	{
		// TODO
		throw new UnsupportedOperationException();
	}
}
