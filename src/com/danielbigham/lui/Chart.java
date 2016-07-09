package com.danielbigham.lui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.danielbigham.lui.pattern.LiteralPattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;
import com.danielbigham.lui.patternmatch.PatternMatchWrapper;

public class Chart
{
	// The key is for this map is computed from:
	// 		(literal or symbol) and input span
	// This is where we keep track, for a given literals/symbol
	// and string span what patterns have been matched. Thus,
	// this is essentially the parse forest. When we update it
	// with a new match, we can see whether this is the first
	// match of its type. ie. The first match for a given symbol
	// and string position. If it is, then and only then do we
	// need to extend any partials that would be interested
	// in this new match.
	private final Map<Integer, List<IPatternMatch>> matchesForSpan;
	
	// The key for this map is computed from:
	//		(literal or symbol) and input pos
	// When extending a match, we need to be able to look to the right and
	// see all of the ways we can extend our match. The values of
	// this map are the end positions of those match extensions.
	// When extending a match right, we need to iterate over all of those
	// end positions and create a new match for each of those new
	// end positions.
	private final Map<Integer, Set<Integer>> matchesStartingAt;
	
	// The key for this map is computed from:
	//		(literal or symbol) + input pos
	// When extending a match, we need to be able to look to the left and
	// see all of the ways we can extend our match. The values of
	// this map are the start positions of those match extensions.
	// When extending a match left, we need to iterate over all of those
	// start positions and create a new match for each of those new
	// start positions.
	private final Map<Integer, Set<Integer>> matchesEndingAt;
	
	// The key for this map is computed from:
	//		(literal or symbol) + input pos
	// When we see the first instance of a given symbol at a given
	// string span, we need to extend any partials waiting for it.
	// This map keeps track of what partials are waiting for new
	// matches with a given START position.
	private final Map<Integer, List<PatternMatchWrapper>> partialsTriggeredByStartPos;
	
	// The key for this map is computed from:
	//		(literal or symbol) + input pos
	// When we see the first instance of a given symbol at a given
	// string span, we need to extend any partials waiting for it.
	// This map keeps track of what partials are waiting for new
	// matches with a given END position.
	private final Map<Integer, List<PatternMatchWrapper>> partialsTriggeredByEndPos;
	
	// The new matches that might trigger partials to be extended.
	private List<PatternMatchWrapper> toTriggerPartials;
	
	private final int inputLengthInTokens;
	private final int numTokenIds;
	private final int inputEndPos;
	
	public Chart(int inputLengthInTokens, int numTokenIds, int inputEndPos)
	{
		this.matchesForSpan = new HashMap<Integer, List<IPatternMatch>>();
		this.matchesStartingAt = new HashMap<Integer, Set<Integer>>();
		this.matchesEndingAt = new HashMap<Integer, Set<Integer>>();
		this.partialsTriggeredByStartPos = new HashMap<Integer, List<PatternMatchWrapper>>();
		this.partialsTriggeredByEndPos = new HashMap<Integer, List<PatternMatchWrapper>>();
		this.toTriggerPartials = new ArrayList<PatternMatchWrapper>();
		this.inputLengthInTokens = inputLengthInTokens;
		this.numTokenIds = numTokenIds;
		this.inputEndPos = inputEndPos;
	}
	
	/**
	 * Add a matched pattern to the chart.
	 * 
	 * @param match				the pattern match.
	 * @param triggerPartials	should the addition of this match check whether
	 * 							partials need to be extended?
	 */
	public void add(IPatternMatch match, boolean triggerPartials, ParserState state)
	{
		// Theoretically we could bail out of the match spans the entire
		// input. Could experiment whether that speeds the parser up or not,
		// but full parses are so rare that the test would probably slow things
		// down on average.
		
		{
			// Update matchesExistForSpan
			int chartKey = chartKey(match);
			List<IPatternMatch> matchesForThisSpan = matchesForSpan.get(chartKey);
			if (matchesForThisSpan == null)
			{
				matchesForThisSpan = new ArrayList<IPatternMatch>();
				matchesForSpan.put(chartKey, matchesForThisSpan);
				
				// We've not yet seen a pattern match with this result symbol
				// for this span. This means that we should trigger partials.
				// (so long as triggerPartials==true, which is the case other
				// than when we initially populate the chart with literal tokens)
				if (triggerPartials &&
					!(match instanceof LiteralPattern) &&
					!(match.startPos() == 0 && match.endPos() == inputEndPos))
				{
					if (ChartParser.debugFlag) { System.out.println("New result might trigger partials: " + match.toString()); }
					// Important to increment this BEFORE creating the PatternMatchWrapper
					// below, otherwise the previous partial we created (if any) will believe
					// that it shouldn't be extended by this token.
					state.incrementIterationCounter();
					toTriggerPartials.add(new PatternMatchWrapper(match, state.iterationCounter()));
				}
			}
			matchesForThisSpan.add(match);
		}
		
		int tokenId = match.pattern().resultSymbol();
		
		// Update matchesStartingAt
		{
			int chartKey = chartKey(match.startPos(), tokenId);
			Set<Integer> set = matchesStartingAt.get(chartKey);
			if (set == null)
			{
				set = new HashSet<Integer>();
				matchesStartingAt.put(chartKey, set);
			}
			set.add(match.endPos());
		}
		
		// Update matchesEndingAt
		{
			int chartKey = chartKey(match.endPos(), tokenId);
			Set<Integer> set = matchesEndingAt.get(chartKey);
			if (set == null)
			{
				set = new HashSet<Integer>();
				matchesEndingAt.put(chartKey, set);
			}
			set.add(match.startPos());
		}
	}
	
	/**
	 * Given an input span and a literal or grammar symbol of interest,
	 * create an integer key that can be used with lookup maps.
	 * 
	 * @param startPos			the starting position of the span.
	 * @param endPos			the ending position of the span.
	 * @param tokenId			grammar symbol or literal. (as integer)
	 */
	private int chartKey(int startPos, int endPos, int tokenId)
	{
		return
			numTokenIds * inputLengthInTokens * startPos +
			numTokenIds * endPos +
			tokenId;
	}
	
	/**
	 * Given a starting or ending position in the input and a literal or grammar symbol
	 * of interest, create an integer key that can be used with lookup maps.
	 * 
	 * @param inputPos			a position in the input.
	 * @param tokenId			grammar symbol or literal. (as integer)
	 */
	private int chartKey(int inputPos, int tokenId)
	{
		return
			numTokenIds * inputPos +
			tokenId;
	}
	
	/**
	 * Given a matched pattern, use its start/end position and its literal
	 * or grammar symbol (token ID) to create an integer key that can be used
	 * with lookup maps.
	 * 
	 * @param match			a matched pattern.
	 */
	private int chartKey(IPatternMatch match)
	{
		return chartKey(
			match.startPos(),
			match.endPos(),
			match.pattern().resultSymbol()
		);
	}
	
	/**
	 * Given a starting position and a token ID (which corresponds to a particular
	 * literal or symbol), returns the ending positions of all known matches, or
	 * null if there are none.
	 * 	
	 * @param startPos		the starting position of the matches we seek.
	 * @param tokenId		the token ID that corresponds to a literal or symbol.
	 * @return				the list of ending positions of known matches. (or null if none)
	 */
	public Set<Integer> getMatchExtensionPositionsToRight(int startPos, int tokenId)
	{
		int chartKey = chartKey(startPos, tokenId);
		return matchesStartingAt.get(chartKey);
	}
	
	/**
	 * Given an ending position and a token ID (which corresponds to a particular
	 * literal or symbol), returns the starting positions of all known matches, or
	 * null if there are none.
	 * 	
	 * @param endPos		the ending position of the matches we seek.
	 * @param tokenId		the token ID that corresponds to a literal or symbol.
	 * @return				the list of starting positions of known matches. (or null if none)
	 */
	public Set<Integer> getMatchExtensionPositionsToLeft(int endPos, int tokenId)
	{
		int chartKey = chartKey(endPos, tokenId);
		return matchesEndingAt.get(chartKey);
	}
	
	/**
	 * Add a partial match to the partials chart, awaiting a new
	 * sub-match to the right.
	 * 
	 * @param match				the partial match.
	 * @param startPos			the starting position of the new sub-match we're waiting for.
	 * @param symbol			the symbol of the new sub-match we're waiting for.
	 * @param iterationCounter	See: AvoidingUnnecessaryPartialExtension.md
	 */
	public void addStartPosPartial(IPatternMatch match, int startPos, int symbol, int iterationCounter)
	{
		int key = chartKey(startPos, symbol);
		List<PatternMatchWrapper> partials = partialsTriggeredByStartPos.get(key);
		if (partials == null)
		{
			partials = new ArrayList<PatternMatchWrapper>();
			partialsTriggeredByStartPos.put(key, partials);
		}
		partials.add(new PatternMatchWrapper(match, iterationCounter));
		
		if (ChartParser.debugFlag)
		{
			System.out.println(match.toString() + " -> Partials\n  Start pos: " + startPos + "\n  Symbol: " + symbol);
			System.out.println("  Iteration counter: " + iterationCounter);
		}
	}
	
	/**
	 * Add a partial match to the partials chart, awaiting a new
	 * sub-match to the right.
	 * 
	 * @param match				the partial match.
	 * @param startPos			the starting position of the new sub-match we're waiting for.
	 * @param symbol			the symbol of the new sub-match we're waiting for.
	 * @param iterationCounter	See: AvoidingUnnecessaryPartialExtension.md
	 */
	public void addEndPosPartial(IPatternMatch match, int endPos, int symbol, int iterationCounter)
	{
		int key = chartKey(endPos, symbol);
		List<PatternMatchWrapper> partials = partialsTriggeredByEndPos.get(key);
		if (partials == null)
		{
			partials = new ArrayList<PatternMatchWrapper>();
			partialsTriggeredByEndPos.put(key, partials);
		}
		partials.add(new PatternMatchWrapper(match, iterationCounter));
		
		System.out.println(match.toString() + " -> Partials\n  End: " + endPos + "\n  Symbol: " + symbol);
	}
	
	/**
	 * Returns the completed matches for the given span and token ID.
	 * 
	 * @param tokenId		the token ID of the literal/symbol.
	 * @param startPos		the start position of the span.
	 * @param endPos		the end position of the span.
	 */
	public List<IPatternMatch> getMatchesForSpan(int tokenId, int startPos, int endPos)
	{
		int chartKey = chartKey(startPos, endPos, tokenId);
		return matchesForSpan.get(chartKey);
	}
	
	/**
	 * Returns the new matches that we determined might trigger partial
	 * matches to continue.
	 */
	public List<PatternMatchWrapper> getAndResetPartialQueue()
	{
		List<PatternMatchWrapper> tmp = toTriggerPartials;
		// Would be more efficient to have two instances of ArrayList<PatternMatchWrapper>
		// and just alternate which one we return here so that we don't have to re-allocate
		// memory every time to build a new 'toTriggerPartials'.
		toTriggerPartials = new ArrayList<PatternMatchWrapper>();
		return tmp;
	}
	
	/**
	 * Returns the partial matches that can be extended to the right by the given
	 * sub-match. Returns null if no partials.
	 * 
	 * @param trigger		the sub-match for continuing a partial match.
	 */
	public List<PatternMatchWrapper> getRightPartialsTriggeredBy(IPatternMatch trigger)
	{
		int key = chartKey(trigger.startPos(), trigger.pattern().resultSymbol());
		return partialsTriggeredByStartPos.get(key);
	}
	
	/**
	 * Returns the partial matches that can be extended to the left by the given
	 * sub-match. Returns null if no partials.
	 * 
	 * @param trigger		the sub-match for continuing a partial match.
	 */
	public List<PatternMatchWrapper> getLeftPartialsTriggeredBy(IPatternMatch trigger)
	{
		int key = chartKey(trigger.endPos(), trigger.pattern().resultSymbol());
		return partialsTriggeredByEndPos.get(key);
	}
}
