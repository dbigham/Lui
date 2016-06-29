package org.danielbigham;

import java.util.List;
import java.util.Map;

public interface IPattern
{
	/**
	 * Returns the number of sub-patterns.
	 */
	public int length();
	
	/**
	 * Returns the list of sub-patterns.
	 */
	public List<IPattern> patterns();
	
	/**
	 * The resulting symbol produced by this grammar rule.
	 * (it's corresponding integer) For LiteralPattern and
	 * SymbolPattern, this returns the token ID of the
	 * literal/symbol.
	 */
	public int resultSymbol();
	
	/**
	 * Returns the sub-pattern at the given index.
	 * 
	 * @param index		the sub-pattern index.
	 */
	public IPattern subPattern(int index);
	
	/**
	 * Return the index of the sub-pattern that is least common within
	 * the grammar. (used when choosing which token should be used to
	 * trigger the pattern in a bottom-up fashion)
	 * 
	 * @param tokenCounts		the counts of tokens in the grammar.
	 */
	public int getIndexOfRarestSubPattern(Map<Integer, Integer> tokenCounts);
	
	/**
	 * Set this pattern's trigger.
	 * 
	 * @param triggerIndex		an index into 'patterns'.
	 */
	public void setTriggerIndex(int triggerIndex);
	
	/**
	 * Given a pattern, construct a pattern match object.
	 * 
	 * @param startPos			the starting position of the triggering subparse.
	 * @param endPos			then ending position of the triggering subparse.
	 */
	public IPatternMatch toPatternMatch(int startPos, int endPos);
	
	/**
	 * Returns true if every sub-pattern is a literal. This is useful
	 * to know when extending a match, since we don't need to add things
	 * to the partials chart if a pattern only consists of sub-patterns
	 * that are literals.
	 * 
	 * This could be enhanced in the future if we use a tokenizer that
	 * produces SymbolPattern tokens. If any of those symbols are only
	 * produced by the tokenizer (and not the grammar), then we could likewise
	 * avoid adding things to the partials chart if it only conists of
	 * literals and/or those symbols.
	 */
	public boolean subPatternsAreAllLiterals();
}
