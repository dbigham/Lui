package com.danielbigham.lui.pattern;

import java.util.List;
import java.util.Map;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.patternmatch.IPatternMatch;

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
	 * Returns the token ID(s) that should be cause for triggering
	 * this pattern to try matching.
	 * 
	 * @param tokenCounts		the counts of tokens in the grammar. (useful for SequencePattern so that it can choose its rarest non-optional sub-pattern as its trigger)
	 */
	public List<Integer> getTriggeringSubPatternIndices(Map<Integer, Integer> tokenCounts);
	
	/**
	 * Set this pattern's triggers.
	 * 
	 * @param triggerIndices		indices into 'patterns'.
	 */
	public void setTriggerIndices(List<Integer> triggerIndices);
	
	/**
	 * Given a pattern, construct a pattern match object.
	 * 
	 * @param tokenId			the token ID of the triggering token.
	 * @param startPos			the starting position of the triggering subparse.
	 * @param endPos			then ending position of the triggering subparse.
	 */
	public IPatternMatch toPatternMatch(int tokenId, int startPos, int endPos);
	
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
	
	/**
	 * Explode nested patterns so that every pattern only has basic
	 * patterns as its sub-patterns. Introduce new grammar symbols as
	 * necessary. Calls grammar.addFinalPattern to accrue the final set
	 * of patterns.
	 * 
	 * See also: Rule Explosion.md
	 * 
	 * @param grammar		the grammar.
	 */
	public IPattern explode(Grammar grammar);

	/**
	 * When exploding sub-rules, we assign them new symbols.
	 */
	public void setSymbol(int newSymbol);
	
	/**
	 * Create a pattern. (will be overridden by each of the subtypes)
	 * 
	 * @param subPatterns			the sub patterns.
	 * @param resultSymbol			the result symbol.
	 */
	public IPattern create(List<IPattern> subPatterns, int resultSymbol);

	/**
	 * Although a pattern doesn't technically contain an action, it's
	 * convenient for us to do this since as of now we use IPattern all
	 * over the place in the parser, and it would be a bit hairy to refactor
	 * the parser to use IGrammarRule instead. (which doesn't even exist yet)
	 * 
	 * @param action	the grammar action. WL expression as string.
	 */
	public void setAction(String action);

	/**
	 * Like toString() but also include the LHS if present.
	 * 
	 * @param grammar	the grammar.
	 */
	public String toString2(Grammar grammar);

	/**
	 * Set this pattern's bound symbol.
	 */
	public void setBinding(String binding);
	
	/**
	 * Get this pattern's bound symbol, or null if none.
	 */
	public String getBinding();
}
