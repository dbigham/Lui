package com.danielbigham.lui;

import java.util.List;

import com.danielbigham.io.Out;
import com.danielbigham.lui.patternmatch.IPatternMatch;
import com.danielbigham.lui.patternmatch.PatternMatchWrapper;

public class ChartParser
{
	public final static int START_SYMBOL = -1;
	
	public final static boolean debugFlag = true;
	
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
						if (ChartParser.debugFlag) { Out.print("Triggered: " + match.toString()); }
						
						if (match.isMatchComplete())
						{
							// This pattern only required its trigger to match.
							state.matchCompleted(match, state);
							continue;
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
	 * @param state					the parser state.
	 */
	private static void continuationsPartialMatches(ParserState state)
	{
		Chart chart = state.chart();
		List<PatternMatchWrapper> newMatches = chart.getAndResetPartialQueue();
		
		while (newMatches != null && newMatches.size() > 0)
		{
			for (PatternMatchWrapper trigger : newMatches)
			{
				List<PatternMatchWrapper> partials = chart.getRightPartialsTriggeredBy(trigger.match);
				
				// See: AvoidingUnnecessaryPartialExtension.md
				int valueOfIterationCounterWhenTriggeringMatchCreated = trigger.valueOfIterationCounterWhenCreated;
				
				if (partials != null)
				{
					for (PatternMatchWrapper wrapper : partials)
					{
						if (valueOfIterationCounterWhenTriggeringMatchCreated > wrapper.valueOfIterationCounterWhenCreated)
						{
							if (ChartParser.debugFlag) { Out.print("Continue partial right: " + wrapper.match.toString()); }
							++state.numTimesWeCheckedAPartialForPossibleExtension;
							wrapper.match.extendMatchAsFarAsPossibleUsing(state, 1, trigger.match);
						}
						else
						{
							if (ChartParser.debugFlag)
							{
								Out.print("Skip partial:\n  Value of iteration counter when triggering token created: " + valueOfIterationCounterWhenTriggeringMatchCreated + "\n  Value of iteration counter when partial formed: " + wrapper.valueOfIterationCounterWhenCreated);
							}
						}
					}
				}
				
				partials = chart.getLeftPartialsTriggeredBy(trigger.match);
				
				if (partials != null)
				{
					for (PatternMatchWrapper wrapper : partials)
					{
						if (valueOfIterationCounterWhenTriggeringMatchCreated > wrapper.valueOfIterationCounterWhenCreated)
						{
							if (ChartParser.debugFlag) { Out.print("Continue partial left: " + wrapper.match.toString()); }
							++state.numTimesWeCheckedAPartialForPossibleExtension;
							wrapper.match.extendMatchAsFarAsPossibleUsing(state, -1, trigger.match);
						}
						else
						{
							if (ChartParser.debugFlag)
							{
								Out.print("Skip partial:\n  Value of iteration counter when triggering token created: " + valueOfIterationCounterWhenTriggeringMatchCreated + "\n  Value of iteration counter when partial formed: " + wrapper.valueOfIterationCounterWhenCreated);
							}
						}
					}
				}
			}
			
			newMatches = chart.getAndResetPartialQueue();
		}
	}
}
