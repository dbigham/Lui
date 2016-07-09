package com.danielbigham.lui;

import java.util.ArrayList;
import java.util.List;

import com.danielbigham.lui.patternmatch.IPatternMatch;

/**
 * Chart parser's state.
 * 
 * @author Daniel
 */
public class ParserState
{
	private final Chart chart;
	private final Grammar grammar;
	private final List<IPatternMatch> tokens;
	// The main list of complete matches that we now need
	// to use as triggers for other patterns.
	private List<IPatternMatch> toTrigger;
	// The secondary list of complete matches that we add to
	// while we're processing the primary list.
	private List<IPatternMatch> toTrigger2;
	private final List<IPatternMatch> results;
	private final int endPos;
	// See: AvoidingUnnecessaryPartialExtension.md
	private int iterationCounter;
	// Useful for whitebox unit tests to ensure we're not trying to extend
	// partials that we shouldn't be.
	public int numTimesWeCheckedAPartialForPossibleExtension;
	
	public ParserState(List<IPatternMatch> tokens, Chart chart, Grammar grammar)
	{
		this.chart = chart;
		this.grammar = grammar;
		this.tokens = tokens;
		this.toTrigger = new ArrayList<IPatternMatch>();
		this.toTrigger2 = new ArrayList<IPatternMatch>();
		this.results = new ArrayList<IPatternMatch>();
		this.endPos = tokens.size() - 1;
		this.iterationCounter = 0;
	}
	
	/**
	 * The chart, which contains the dynamic programming data structures
	 * used to parse the input.
	 */
	public Chart chart()
	{
		return chart;
	}
	
	/**
	 * The grammar.
	 */
	public Grammar grammar()
	{
		return grammar;
	}
	
	/**
	 * The input tokens (literals).
	 */
	public List<IPatternMatch> tokens()
	{
		return tokens;
	}
	
	/**
	 * The pattern matches with the START symbol that span the input.
	 */
	public List<IPatternMatch> results()
	{
		return results;
	}
	
	/**
	 * Take the initial tokens produced by the tokenizer and populate the
	 * chart with them.
	 * 
	 * @param tokens	the tokens.
	 */
	public void populateChartWithTokens(List<IPatternMatch> tokens)
	{
		for (IPatternMatch token : tokens)
		{
			chart.add(
				token,
				// We don't trigger partials at this point because none exist.
				false,
				null
			);
		}
		
		toTrigger = new ArrayList<IPatternMatch>(tokens);
	}

	/**
	 * Called when a pattern has been matched successfully.
	 * 
	 * @param match		the matched pattern.
	 * @param state		parser state.
	 */
	public void matchCompleted(IPatternMatch match, ParserState state)
	{
		chart.add(match, true, state);
		
		toTrigger2.add(match.resultToSymbolPattern());
		
		int resultSymbol = match.pattern().resultSymbol();
		
		if (resultSymbol == ChartParser.START_SYMBOL && match.endPos() == endPos)
		{
			results.add(match);
		}
	}
	
	public List<IPatternMatch> toTrigger()
	{
		return toTrigger;
	}
	
	/**
	 * After we process all of the items in 'toTrigger' within ChartParser's main loop,
	 * we re-populate toTrigger with all of the matches that we completed. Those
	 * completed matches were put into toTrigger2. Rather than set toTrigger to
	 * a newly allocated list, we recycle the old toTrigger list, and we clear it.
	 * Since toTrigger might have been sizable, this hopefully prevents us from
	 * having to re-allocate all of that memory. (hopefully the clear method
	 * doesn't un-allocate it)
	 */
	public void swapTriggerList()
	{
		List<IPatternMatch> tmp = toTrigger;
		toTrigger = toTrigger2;
		toTrigger2 = tmp;
		toTrigger2.clear();
	}
	
	/**
	 * See: AvoidingUnnecessaryPartialExtension.md
	 */
	public int iterationCounter()
	{
		return iterationCounter;
	}
	
	/**
	 * See: AvoidingUnnecessaryPartialExtension.md
	 */
	public void incrementIterationCounter()
	{
		++iterationCounter;
		if (ChartParser.debugFlag) { System.out.println("Increment iteration counter -> " + iterationCounter); }
	}
	
	/**
	 * The token index of the last token.
	 */
	public int getEndPos()
	{
		return endPos;
	}
}
