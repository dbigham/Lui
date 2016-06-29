package org.danielbigham;

import java.util.List;


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
		super(patterns, resultSymbol);
	}
	
	public static SequencePattern create(Grammar grammar, String str, int resultSymbol)
	{
		return new SequencePattern(Pattern.parse(grammar, str), resultSymbol);
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("{");
		int patternIndex = 0;
		for(IPattern subPattern : patterns)
		{
			if (patternIndex > 0) { str.append(" "); }
			if (patternIndex == triggerIndex)
			{
				// Double carets denote the sub-pattern
				// that is playing the role of trigger.
				str.append("<");
			}
			str.append(subPattern.toString());
			if (patternIndex == triggerIndex)
			{
				str.append(">");
			}
			++patternIndex;
		}
		str.append("}");
		return str.toString();
	}

	@Override
	public IPatternMatch toPatternMatch(int startPos, int endPos)
	{
		return new SequencePatternMatch(this, startPos, endPos);
	}
}
