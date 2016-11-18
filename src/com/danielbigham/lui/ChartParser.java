package com.danielbigham.lui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.danielbigham.io.Out;
import com.danielbigham.lui.evaluation.ParseForestEvaluation;
import com.danielbigham.lui.patternmatch.IPatternMatch;
import com.danielbigham.lui.patternmatch.PatternMatchWrapper;
import com.danielbigham.lui.regex.IdParser;
import com.danielbigham.lui.regex.QuotedStringParser;
import com.danielbigham.lui.regex.RegexParser;
import com.danielbigham.lui.regex.UrlParser;

public class ChartParser
{
	public final static int START_SYMBOL = -1;

	public static boolean debugFlag = false;
	public static boolean debugOptionals = false;
	public static boolean debugMatchExtension = false;
	public static boolean debugPartials = false;
	public static boolean debugIterationCounter = false;
	
	private static List<RegexParser> regexParsers;
	
	private static Tokenizer tokenizer;
	
	static
	{
		tokenizer = new Tokenizer();
		regexParsers = new ArrayList<RegexParser>();
		regexParsers.add(new IdParser());
		regexParsers.add(new UrlParser());
		regexParsers.add(new QuotedStringParser());
	}

	public static ParserState parse(Grammar grammar, String str)
	{
		str = str.trim();
		
		List<IPatternMatch> tokens = tokenizer.tokenize(grammar, str);
		
		for (RegexParser regexParser : regexParsers)
		{
			regexParser.parse(grammar, tokens, str);
		}
		
		adjustTokenPositions(tokens);
		
		Chart chart = new Chart(tokens.size(), grammar.getNumTokenIds(), tokens.size() - 1);
		ParserState state = new ParserState(tokens, chart, grammar);
		state.populateChartWithTokens(tokens);

		mainLoop(state);

		return state;
	}
	
	/**
	 * Given a grammar and an input string, returns the parsed expression,
	 * or null if none.
	 * 
	 * Currently this is not a full implementation, since we can't evaluate
	 * grammar actions in Java.
	 * 
	 * @param grammar	the grammar.
	 * @param str		the input string.
	 * @return			the parsed expression, or null if none.
	 */
	public static String parseToExpression(Grammar grammar, String str)
	{
		ParserState state = parse(grammar, str);
		return ParseForestEvaluation.evaluate(state);
	}
	
	/**
	 * The initial tokenization and regex parser steps create tokens that
	 * use start/end positions which are string positions.
	 * 
	 * Here, we convert those into token index positions.
	 * 
	 * @param tokens	the tokens to adjust.
	 */
	private static void adjustTokenPositions(List<IPatternMatch> tokens)
	{
		Map<Integer, Integer> posMap =
			createCharPositionToTokenIndexMap(tokens);
		
		for (IPatternMatch token : tokens)
		{
			int newStart = posMap.get(token.startPos());
			int newEnd = posMap.get(token.endPos());
			token.setStartEnd(newStart, newEnd);
			if (debugFlag)
			{
				Out.print(newStart + "-" + newEnd + ": " + token);
			}
		}
	}
	
	/**
	 * Create a mapping from character positions to token index positions.
	 * 
	 * @param tokens	the tokens.
	 * @return 			mapping from character positions to token index positions.
	 */
	private static Map<Integer, Integer> createCharPositionToTokenIndexMap(List<IPatternMatch> tokens)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> charPositions = uniqueCharPositions(tokens);
		int i = 0;
		for (Integer pos : charPositions)
		{
			map.put(pos, i);
			++i;
		}
		return map;
	}
	
	/**
	 * Given a list of tokens, returns all of the unique string positions that
	 * serve as either start or end positions of tokens.
	 * 
	 * @param tokens	the tokens.
	 */
	private static List<Integer> uniqueCharPositions(List<IPatternMatch> tokens)
	{
		Set<Integer> res = new HashSet<Integer>();
		for (IPatternMatch token : tokens)
		{
			res.add(token.startPos());
			res.add(token.endPos());
		}
		
		List<Integer> list = new ArrayList<Integer>(res);
		Collections.sort(list);
		
		return list;
	}

	/**
	 * Given a grammar, ensure that all of the grammar symbols used by
	 * the regex parsers are defined.
	 * 
	 * @param grammar	The grammar.
	 */
	public static void defineRegexParserSymbols(Grammar grammar)
	{
		for (RegexParser regexParser : regexParsers)
		{
			List<String> symbols = regexParser.grammarSymbols();
			for (String symbol : symbols)
			{
				grammar.getTokenIdAndDefineIfNecessary(symbol);
			}
		}
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
							// TODO: Why on earth are we passing in the 'state' here to the state?
							state.matchCompleted(match, state);
							continue;
						}
						
						// I'm going to disable this for now, since the introduction
						// of optionals means that things like 'numTokensRequiredAtRight'
						// can no longer be computed super quickly. Might still be worth
						// having this, could experiment later.
						//if (// If we don't have enough tokens to match all of
						//	// the sub-patterns, then don't bother trying to match it.
						//	match.pattern().patterns().size() > tokens.size() ||
						//	match.numTokensRequiredAtRight() > tokens.size() - match.endPos() - 1 ||
						//	match.numTokensRequiredAtLeft() > match.startPos())
						//{
						//	continue;
						//}

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
							if (ChartParser.debugPartials) { Out.print("Continue partial right: " + wrapper.match.toString()); }
							++state.numTimesWeCheckedAPartialForPossibleExtension;
							wrapper.match.extendMatchAsFarAsPossibleUsing(state, 1, trigger.match);
						}
						else
						{
							if (ChartParser.debugPartials)
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
							if (ChartParser.debugPartials) { Out.print("Continue partial left: " + wrapper.match.toString()); }
							++state.numTimesWeCheckedAPartialForPossibleExtension;
							wrapper.match.extendMatchAsFarAsPossibleUsing(state, -1, trigger.match);
						}
						else
						{
							if (ChartParser.debugPartials)
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
