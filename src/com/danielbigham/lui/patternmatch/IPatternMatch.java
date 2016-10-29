package com.danielbigham.lui.patternmatch;

import java.util.List;
import java.util.Set;

import com.danielbigham.lui.EvaluationResult;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.pattern.IPattern;

public interface IPatternMatch
{
	/**
	 * Attempts to extend the match as far as it can.
	 * 
	 * @param state		the parser state.
	 */
	public void extendMatchAsFarAsPossible(ParserState state);
	
	/**
	 * Extends the match using the given pattern, and then attempts to
	 * continue extending the partial match as far as possible.
	 * 
	 * @param state			the parser state.
	 * @param dir			the direction of the match extension.
	 * @param nextMatch		the sub-pattern-match to use to extend the match.
	 */
	public void extendMatchAsFarAsPossibleUsing(ParserState state, int dir, IPatternMatch nextMatch);
	
	/**
	 * Attempts to extend the match once. Returns new matches if
	 * the match was extended, or null otherwise. Since there can
	 * be multiple ways to extend a match at any given position,
	 * we return a list.
	 * 
	 * @param state					parser state.
	 * @param extensionPositions	if matching to the right, these are the end positions
	 * 								of the extended matches, or if to the left, these are the
	 * 								start positions of the extended matches. When passed in
	 * 								as null, we use the chart to figure out what extension
	 * 								are available. This is only non-null when we are
	 * 								extending a partial match.
	 */
	public List<IPatternMatch> extendMatch(ParserState state, Set<Integer> extensionPositions);
	
	/**
	 * Returns the pattern being matched.
	 */
	public IPattern pattern();
	
	/**
	 * Returns true if the match is complete.
	 */
	public boolean isMatchComplete();

	/**
	 * The starting position of the match in the input. (token index)
	 */
	public int startPos();
	
	/**
	 * The ending position of the match in the input. (token index)
	 */
	public int endPos();
	
	/**
	 * The input positions of the matched sub-patterns. The integer in
	 * position 'i' is the start position of sub-pattern 'i'. The extra
	 * integer at the end is 1+endPos of the last sub-pattern.
	 */
	public int[] subPatternStartPositions();
	
	/**
	 * How many tokens would we need to the right of the current match to
	 * complete the match?
	 */
	public int numTokensRequiredAtRight();
	
	/**
	 * How many tokens would we need to the left of the current match to
	 * complete the match?
	 */
	public int numTokensRequiredAtLeft();
	
	/**
	 * When a pattern matches, we can create a new SymbolPattern to
	 * represent the match. The symbol used will be the original pattern's
	 * result symbol.
	 */
	public IPatternMatch resultToSymbolPattern();

	/**
	 * If we have the grammar available then we can include the result
	 * symbol in the toString output.
	 * 
	 * @param grammar		the grammar.
	 */
	public String toString(Grammar grammar);

	/**
	 * Convert the pattern match to a Wolfram Language expression.
	 * Recurses to also convert all sub-matches.
	 * 
	 * @param wl		a StringBuilder.
	 */
	public void toWL(StringBuilder wl, ParserState state);
	
	/**
	 * Returns all of the sub-patterns that actually matched. For
	 * OR patterns, this will only be one of the sub-patterns, while
	 * for sequence patterns, this will be all of them. (unless some
	 * were optional)
	 */
	public List<IPattern> getMatchedSubPatterns();

	/**
	 * When we convert string positions to token indices, we update our
	 * patterns.
	 * 
	 * @param newStart		the new start position.
	 * @param newEnd		the new end position.
	 */
	public void setStartEnd(int newStart, int newEnd);
	
	/**
	 * The semantic expression associated with this pattern match, if
	 * applicable. (null otherwise)
	 */
	public String expr();

	/**
	 * Evaluate the pattern match and return the resultant expression.
	 * 
	 * For now we do this in a very hacky way.
	 * 
	 * @param state		the parser state.
	 * @return			the evaluation result.
	 */
	public EvaluationResult evaluate(ParserState state);
}
