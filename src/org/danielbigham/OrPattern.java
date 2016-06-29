package org.danielbigham;

import java.util.List;

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
