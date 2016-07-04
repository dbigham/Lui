package com.danielbigham.lui.pattern;

import java.util.ArrayList;

import com.danielbigham.lui.patternmatch.IPatternMatch;

public class OptionalPattern extends Pattern implements IPattern
{
	public OptionalPattern(IPattern pattern, int resultSymbol)
	{		
		super(null, resultSymbol);
		
		this.patterns = new ArrayList<IPattern>(1);
		this.patterns.add(pattern);
	}

	@Override
	public IPatternMatch toPatternMatch(int startPos, int endPos)
	{
		// TODO
		throw new UnsupportedOperationException();
	}
}
