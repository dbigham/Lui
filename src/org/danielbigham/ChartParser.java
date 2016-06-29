package org.danielbigham;

import java.util.List;


public class ChartParser
{
	public final static int START_SYMBOL = -1;
	
	public static ParserState parse(Grammar grammar, String str)
	{
		List<IPatternMatch> tokens = Tokenizer.tokenize(grammar, str);
		
		Chart chart = new Chart(tokens.size(), grammar.getNumTokenIds(), tokens.size() - 1);
		ParserState state = new ParserState(tokens, chart, grammar);
		
		state.populateChartWithTokens(tokens);

		mainLoop(state);
		
		return state;
	}
	
	/**
	 * For each literal token produced by the tokenizer, we consider which
	 * grammar patterns can be triggered.
	 * 
	 * @param state		the parser state.
	 */
	private static void mainLoop(ParserState state)
	{
		List<IPatternMatch> tokens = state.tokens();
		List<IPatternMatch> toTrigger = state.toTrigger();
		Grammar grammar = state.grammar();
		
		while(toTrigger.size() > 0)
		{
			for (IPatternMatch trigger : toTrigger)
			{
				List<IPatternMatch> triggeredPatterns =
						grammar.getTriggeredPatterns(
								trigger.pattern().resultSymbol(),
								trigger.startPos(),
								trigger.endPos());
				
				if (triggeredPatterns != null)
				{
					for (IPatternMatch match : triggeredPatterns)
					{
						System.out.println("Triggered: " + match.toString());
						
						if (match.isMatchComplete())
						{
							// This pattern only required its trigger to match.
							state.matchCompleted(match);
							continue;
						}
						
						if (match.pattern().resultSymbol() == ChartParser.START_SYMBOL)
						{
							if (// If this is a START pattern and we aren't
								// attempting to match it from the beginning of
								// the string, then don't bother.
								match.startPos() > 0)
							{
								continue;
							}
						}
						
						if (// If we don't have enough tokens to match all of
							// the sub-patterns, then don't bother trying to match it.
							match.pattern().patterns().size() > tokens.size() ||
							match.numTokensRequiredAtRight() > tokens.size() - match.endPos() - 1 ||
							match.numTokensRequiredAtLeft() > match.startPos())
						{
							continue;
						}
						
						match.extendMatchAsFarAsPossible(state);
					}
				}
			}
			
			continuationsPartialMatches(state);
			
			state.swapTriggerList();
			toTrigger = state.toTrigger();
		}
	}
	
	/**
	 * Check whether any partial matches should be continued due to
	 * new matches having been made.
	 * 
	 * @param state		the parser state.
	 */
	private static void continuationsPartialMatches(ParserState state)
	{
		Chart chart = state.chart();
		List<IPatternMatch> newMatches = chart.getAndResetPartialQueue();
		
		while (newMatches != null && newMatches.size() > 0)
		{
			for (IPatternMatch trigger : newMatches)
			{
				List<IPatternMatch> partials = chart.getRightPartialsTriggeredBy(trigger);
				
				if (partials != null)
				{
					for (IPatternMatch partial : partials)
					{
						System.out.println("Continue partial right: " + partial.toString());
						partial.extendMatchAsFarAsPossibleUsing(state, 1, trigger);
					}
				}
				
				partials = chart.getLeftPartialsTriggeredBy(trigger);
				
				if (partials != null)
				{
					for (IPatternMatch partial : partials)
					{
						System.out.println("Continue partial left: " + partial.toString());
						partial.extendMatchAsFarAsPossibleUsing(state, -1, trigger);
					}
				}
			}
			
			newMatches = chart.getAndResetPartialQueue();
		}
	}
}
