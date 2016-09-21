package com.danielbigham.lui.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.grammarrule.GrammarRule;

public abstract class Pattern implements IPattern
{
	protected List<IPattern> patterns;
	protected String type = "E";
	protected String action;
	protected String binding;
	
	// Constant used to mark sub-patterns that don't actually
	// produce a grammar symbol.
	public static final int NO_LHS = -999;

	public final PatternType patternType;
		
	public Pattern(List<IPattern> patterns, int resultSymbol, PatternType patternType)
	{
		this.patterns = patterns;
		this.patternType = patternType;
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
		
		// I think Java's Collections.sort is stable here, which is nice,
		// because our unit tests can then assume that the first trigger
		// pattern with the lowest count will be the trigger, and when
		// we do pattern.toString, the triggering pattern does make itself
		// evident.
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
	
	/**
	 * Do the work of exploding all of the pattern's sub-patterns.
	 * 
	 * Returns null if we determine that all sub-patterns are basic,
	 * in which case we don't need to explode anything.
	 * 
	 * See also: Rule Explosion.md
	 * 
	 * @param grammar		the grammar.
	 * @param pattern		the pattern to explode.
	 * 
	 * @return				all of the pattern's sub-patterns after explosion.
	 */
	public static List<IPattern> explodeHelper(Grammar grammar, IPattern pattern)
	{
		boolean allSubPatternsBasic = true;
		for (IPattern subPattern : pattern.patterns())
		{
			if (!(subPattern instanceof BasicPattern))
			{
				allSubPatternsBasic = false;
				break;
			}
		}
		
		if (allSubPatternsBasic)
		{
			// Nothing to do. Return 'null' as a signal that the original
			// pattern is fine.
			return null;
		}
		
		List<IPattern> subPatterns = pattern.patterns();
		
		List<IPattern> newSubPatterns = new ArrayList<IPattern>();
		
		for (IPattern subPattern : subPatterns)
		{
			if (subPattern instanceof BasicPattern)
			{
				// We don't need to explode basic patterns; they are already atoms.
				newSubPatterns.add(subPattern);
			}
			else
			{
				IPattern explodedSubPattern = subPattern.explode(grammar);
				explodedSubPattern.setBinding(subPattern.getBinding());
				explodedSubPattern.setType("D");
				newSubPatterns.add(explodedSubPattern);
			}
		}
		
		return newSubPatterns;
	}
	
	public void setSymbol(int newSymbol)
	{
		this.resultSymbol = newSymbol;
	}
	
	public IPattern explode(Grammar grammar)
	{
		List<IPattern> explodedSubPatterns = explodeHelper(grammar, this);
		
		IPattern newPattern;
		
		if (explodedSubPatterns == null)
		{
			// None of the sub-patterns needed exploding.
			if (this.resultSymbol != Pattern.NO_LHS)
			{
				// This is a top-level rule that didn't need any exploding, so
				// just stop here and add the pattern unmodified.
				grammar.addFinalPattern(this);
				return this;
			}
			
			explodedSubPatterns = patterns();
		}
		
		newPattern = this.create(explodedSubPatterns, this.resultSymbol);
		
		// Add the pattern to the final list of patterns for this grammar.
		// This will generate a dynamic symbol if necessary. There are three cases:
		// - Top level rule: Will just echo back this pattern's result symbo..
		// - Sub-rule never seen before: Will generate a new symbol.
		// - Sub-rule seen before: Will re-use the same symbol we generated previously for this pattern.
		int symbol = grammar.addFinalPattern(newPattern);
		
		if (symbol != resultSymbol)
		{
			newPattern.setType("D");
		}
		
		newPattern.setSymbol(symbol);
		
		if (this.resultSymbol == Pattern.NO_LHS)
		{
			return new SymbolPattern(grammar.getSymbolOrLiteral(symbol), symbol, -1, -1);
		}
		else
		{
			// We return the actual pattern in this case, since it's
			// a top level pattern and the caller (GrammarRule.sxplode)
			// wants it so that we can call setAction on it.
			return newPattern;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((binding == null) ? 0 : binding.hashCode());
		result = prime * result
				+ ((patternType == null) ? 0 : patternType.hashCode());
		result = prime * result
				+ ((patterns == null) ? 0 : patterns.hashCode());
		result = prime * result + resultSymbol;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pattern other = (Pattern) obj;
		if (binding == null)
		{
			if (other.binding != null)
				return false;
		} else if (!binding.equals(other.binding))
			return false;
		if (patternType != other.patternType)
			return false;
		if (patterns == null)
		{
			if (other.patterns != null)
				return false;
		} else if (!patterns.equals(other.patterns))
			return false;
		if (resultSymbol != other.resultSymbol)
			return false;
		return true;
	}

	@Override
	public void setAction(String action)
	{
		this.action = action;
	}

	/**
	 * Used by unit tests.
	 * 
	 * @param patterns	list of patterns.
	 * @param grammar	the grammar. 
	 */
	public static List<GrammarRule> toGrammarRules(List<IPattern> patterns, Grammar grammar)
	{
		List<GrammarRule> rules = new ArrayList<GrammarRule>(patterns.size());
		
		for (IPattern pattern : patterns)
		{
			rules.add(new GrammarRule(grammar, "DUMMY_SYMBOL", pattern, "DUMMY_ACTION"));
		}
		
		return rules;
	}
	
	public String toString2(Grammar grammar)
	{
		StringBuilder str = new StringBuilder(20);
		str.append("<").append(grammar.getSymbolOrLiteral(resultSymbol)).append(":");
		str.append(resultSymbol).append(">: ").append(toString());
		if (getAction() != null)
		{
			str.append(" -> ").append(getAction());
		}
		return str.toString();
	}
	
	public void setBinding(String binding)
	{
		this.binding = binding;
	}
	
	public String getBinding()
	{
		return this.binding;
	}
	
	/**
	 * toString implementation common to all pattern types.
	 * Called from derived classes' toString metohds.
	 */
	protected String toStringHelper(String str)
	{
		if (binding != null)
		{
			return binding + "=" + str;
		}
		else
		{
			return str;
		}
	}
	
	public String getAction()
	{
		return action;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
}
