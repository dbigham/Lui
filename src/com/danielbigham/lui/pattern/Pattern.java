package com.danielbigham.lui.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.danielbigham.lui.Grammar;

public abstract class Pattern
{
	protected List<IPattern> patterns;
	
	public Pattern(List<IPattern> patterns, int resultSymbol)
	{
		this.patterns = patterns;
		// Call the below so that it pre-computes its result.
		// Best to do at grammar construction time, I think, rather than at runtime.
		this.subPatternsAreAllLiterals();
		this.resultSymbol = resultSymbol;
		// Default to null until the time when the trigger index
		// is actually set. That way if we create a pattern and
		// do a toString() on it, it won't falsely look like the
		// triggerIndices have been set.
		this.triggerIndices = null;
	}
	
	// The integer that corresponds to the grammar symbol that
	// is produced by this grammar pattern.
	protected int resultSymbol;
	
	// The indices into 'patterns' of the sub-patterns that acts as the triggers.
	// ie. The word or symbol sub-patterns that, when seen, acts as the bottom-up
	// trigger for this pattern.
	private List<Integer> triggerIndices;
	
	public int length()
	{
		return patterns.size();
	}
	
	public List<IPattern> patterns()
	{
		return patterns;
	}
	
	public int resultSymbol()
	{
		return resultSymbol;
	}
	
	public IPattern subPattern(int index)
	{
		return patterns.get(index);
	}
	
	/**
	 * A pattern and the number of times it occurs in the grammar.
	 */
	class PatternWithCount
	{
		public int count;
		public IPattern pattern;
		public int patternIndex;
		public PatternWithCount(int count, IPattern pattern, int patternIndex)
		{
			this.count = count;
			this.pattern = pattern;
			this.patternIndex = patternIndex;
		}
	}
	
	/**
	 * Used for sorting.
	 */
	class PatternWithCountComparator implements Comparator<PatternWithCount>
	{
		@Override
		public int compare(PatternWithCount a, PatternWithCount b)
		{
			return compare(a.count, b.count);
		}
		
		private int compare(long a, long b)
		{
			return a < b ? -1
				:  a > b ? 1
				:  0;
		}
	}
	
	/**
	 * Return the index of the sub-pattern that is least common within
	 * the grammar. (used when choosing which token should be used to
	 * trigger the pattern in a bottom-up fashion)
	 * 
	 * @param tokenCounts		the counts of tokens in the grammar.
	 */
	public int getIndexOfRarestSubPattern(Map<Integer, Integer> tokenCounts)
	{
		List<PatternWithCount> patternsWithCounts = new ArrayList<>(patterns.size());
		int patternIndex = 0;
		for(IPattern subPattern : patterns)
		{
			if (subPattern instanceof BasicPattern)
			{
				int tokenId = ((BasicPattern)subPattern).getTokenId();
				Integer count = tokenCounts.get(tokenId);
				patternsWithCounts.add(new PatternWithCount(count, subPattern, patternIndex));
			}
			++patternIndex;
		}
		
		
		Collections.sort(patternsWithCounts, new PatternWithCountComparator());
		
		int indexOfRarestToken = patternsWithCounts.get(0).patternIndex;
		
		return indexOfRarestToken;
	}
	
	public void setTriggerIndices(List<Integer> triggerIndices)
	{
		this.triggerIndices = triggerIndices;
	}
	
	/**
	 * Tokenize a string into a sequence of tokens.
	 * 
	 * @param grammar			the grammar. (defines mappings from words -> integers)
	 * @param str				the input string.
	 */
	public static List<IPattern> parse(Grammar grammar, String str)
	{
		String split = "\\s+";
		if (str.contains("|"))
		{
			// For now, if the pattern contains any vertical bars, then assume
			// this is a simple OR rule.
			split = "\\|";
		}
		
		String[] rawTokens = str.trim().split(split);
		
		List<IPattern> tokens = new ArrayList<IPattern>(rawTokens.length);
		int pos = 0;
		for (String token : rawTokens)
		{
			IPattern pattern;
			
			token = token.trim();
			
			if (token.startsWith("$"))
			{
				// Treat as a symbol
				pattern = new SymbolPattern(grammar, token, pos, pos, true);
			}
			else
			{
				pattern = new LiteralPattern(grammar, token, pos, true);
			}
			
			tokens.add(pattern);
			
			++pos;
		}
		
		return tokens;
	}
	
	private Boolean subPatternsAreAllLiteralsCached;
	public boolean subPatternsAreAllLiterals()
	{
		if (subPatternsAreAllLiteralsCached != null)
		{
			return subPatternsAreAllLiteralsCached;
		}
		
		subPatternsAreAllLiteralsCached = true;
		for(IPattern pattern : patterns)
		{
			if (!(pattern instanceof LiteralPattern))
			{
				subPatternsAreAllLiteralsCached = false;
				break;
			}
		}
		
		return subPatternsAreAllLiteralsCached;
	}
	
	/**
	 * The indices of the sub-patterns that are acting as the triggers for this pattern.
	 */
	public List<Integer> getTriggerIndices()
	{
		return triggerIndices;
	}
}
