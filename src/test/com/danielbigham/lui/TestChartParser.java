package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.danielbigham.lui.ChartParser;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.OrPattern;
import com.danielbigham.lui.pattern.SequencePattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public class TestChartParser
{
	private static final boolean debugFlag = true;
	
	// Test matching a simple grammar rule, only literals.
	// The trigger will be 'testing', since it is the most rare literal,
	// so this will match in a right-to-left direction.
	@Test
	public void test1()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(SequencePattern.create(grammar, "just just testing", ChartParser.START_SYMBOL));
		grammar.setPatterns(patterns);
		
		ParserState state = ChartParser.parse(grammar, "just just testing");
		
		List<IPatternMatch> matches = state.chart().getMatchesForSpan(ChartParser.START_SYMBOL, 0, 5);
		assertEquals(1, matches.size());
		assertEquals("[0, 2, 4, 6]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
	}
	
	// Because 'just' is the rarest literal, this will match in a left-to-right fashion.
	// And because there is nothing more to match to the left, it should detect that
	// and consider itself complete after matching all the way to the right.
	@Test
	public void test2()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(SequencePattern.create(grammar, "just testing testing", ChartParser.START_SYMBOL));
		grammar.setPatterns(patterns);
		
		ParserState state = ChartParser.parse(grammar, "just testing testing");
		
		List<IPatternMatch> matches = state.chart().getMatchesForSpan(ChartParser.START_SYMBOL, 0, 5);
		assertEquals(1, matches.size());
		assertEquals("[0, 2, 4, 6]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
	}
	
	// Trigger will be 'testing', so this will match to the right, then match
	// to the left.
	@Test
	public void test3()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(SequencePattern.create(grammar, "just testing just", ChartParser.START_SYMBOL));
		grammar.setPatterns(patterns);
		
		ParserState state = ChartParser.parse(grammar, "just testing just");
		
		List<IPatternMatch> matches = state.chart().getMatchesForSpan(ChartParser.START_SYMBOL, 0, 5);
		assertEquals(1, matches.size());
		assertEquals("[0, 2, 4, 6]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
	}
	
	// One rule produces a symbol and the other rule uses that symbol.
	@Test
	public void test4()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(SequencePattern.create(grammar, "$symbol again", ChartParser.START_SYMBOL));
		patterns.add(SequencePattern.create(grammar, "just testing", grammar.getTokenId("$symbol")));
		grammar.setPatterns(patterns);
		
		//Out.print(patterns.toString());
		
		ParserState state = ChartParser.parse(grammar, "just testing again");
		
		// Check that "just testing" matched
		List<IPatternMatch> matches = state.chart().getMatchesForSpan(grammar.getTokenId("$symbol"), 0, 3);
		assertEquals(1, matches.size());
		assertEquals("[0, 2, 4]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
		
		// Check that "$symbol again" matched
		matches = state.chart().getMatchesForSpan(ChartParser.START_SYMBOL, 0, 5);
		assertEquals(1, matches.size());
		assertEquals("[0, 4, 6]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
		
		assertEquals(1, state.results().size());
	}
	
	// Test requiring two subparses to be created, but doesn't need partials.
	@Test
	public void test5()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(SequencePattern.create(grammar, "$symbol $symbol2", ChartParser.START_SYMBOL));
		patterns.add(SequencePattern.create(grammar, "again again", grammar.getTokenId("$symbol2")));
		patterns.add(SequencePattern.create(grammar, "just testing", grammar.getTokenId("$symbol")));
		grammar.setPatterns(patterns);
		
		//Out.print(patterns.toString());
		
		ParserState state = ChartParser.parse(grammar, "just testing again again");
		
		// Check that "just testing" matched
		List<IPatternMatch> matches = state.chart().getMatchesForSpan(grammar.getTokenId("$symbol"), 0, 3);
		assertEquals(1, matches.size());
		assertEquals("[0, 2, 4]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
		
		// Check that "again again" matched
		matches = state.chart().getMatchesForSpan(grammar.getTokenId("$symbol2"), 4, 7);
		assertEquals(1, matches.size());
		assertEquals("[4, 6, 8]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
		
		// Check that "$symbol $symbol2" matched
		matches = state.chart().getMatchesForSpan(ChartParser.START_SYMBOL, 0, 7);
		assertEquals(1, matches.size());
		assertEquals("[0, 4, 8]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
		
		assertEquals(1, state.results().size());
	}
	
	// Partials are required because the 'just $symbol $symbol' rule starts matching
	// before any instances of $symbol have been parsed. We make sure that 'just'
	// is rarer than $symbol so that it acts as trigger.
	//
	// Also tests rules that have a RHS of size 1.
	@Test
	public void test6()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(SequencePattern.create(grammar, "just $symbol $symbol", ChartParser.START_SYMBOL));
		patterns.add(SequencePattern.create(grammar, "testing", grammar.getTokenId("$symbol")));
		grammar.setPatterns(patterns);
		
		//Out.print(patterns.toString());
		
		ParserState state = ChartParser.parse(grammar, "just testing testing");
		
		// Check that "testing" matched twice.
		List<IPatternMatch> matches = state.chart().getMatchesForSpan(grammar.getTokenId("$symbol"), 2, 3);
		assertEquals(1, matches.size());
		assertEquals("[2, 4]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
		matches = state.chart().getMatchesForSpan(grammar.getTokenId("$symbol"), 4, 5);
		assertEquals(1, matches.size());
		assertEquals("[4, 6]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
		
		// Check that "just $symbol $symbol" matched
		matches = state.chart().getMatchesForSpan(ChartParser.START_SYMBOL, 0, 5);
		assertEquals(1, matches.size());
		assertEquals("[0, 2, 4, 6]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
		
		assertEquals(1, state.results().size());
		
		// See: AvoidingUnnecessaryPartialExtension.md
		assertEquals(1, state.numTimesWeCheckedAPartialForPossibleExtension);
	}
	
	// OrPattern. Input matches first sub-pattern.
	@Test
	public void orPatternTest1()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(OrPattern.create(grammar, "apple|orange|banana", ChartParser.START_SYMBOL));
		grammar.setPatterns(patterns);
		
		ParserState state = ChartParser.parse(grammar, "apple");
		
		List<IPatternMatch> matches = state.chart().getMatchesForSpan(ChartParser.START_SYMBOL, 0, 1);
		assertEquals(1, matches.size());
		assertEquals("[0, 2]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
	}
	
	// OrPattern. Input matches second sub-pattern.
	@Test
	public void orPatternTest2()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(OrPattern.create(grammar, "apple|orange|banana", ChartParser.START_SYMBOL));
		grammar.setPatterns(patterns);
		
		ParserState state = ChartParser.parse(grammar, "orange");
		
		List<IPatternMatch> matches = state.chart().getMatchesForSpan(ChartParser.START_SYMBOL, 0, 1);
		assertEquals(1, matches.size());
		assertEquals("[0, 2]", TestUtils.intArrayToStr(matches.get(0).subPatternStartPositions()));
	}
	
	// Test that uses the ANTLR parsing.
	@Test
	public void test9()
	{
		assertEquals(
			1,
			parses(
				"start: $webpage\n" +
				"webpage: slashdot",
				"slashdot"
			)
		);
	}
	
	// Nested OR
	@Test
	public void test10()
	{
		assertEquals(
			1,
			parses(
				"start: $webpage\n" +
				"webpage: (spacex|spx) reddit",
				"spacex reddit"
			)
		);
	}
	
	// Double nesting
	@Test
	public void test11()
	{
		assertEquals(
			1,
			parses(
				"start: $webpage\n" +
				"webpage: (spacex|spx) (webpage|(web page))",
				"spacex web page"
			)
		);
	}
	
	// ID regex parser
	@Test
	public void test12()
	{
		assertEquals(
			1,
			parses(
				"start: $id and $id",
				"one and two"
			)
		);
	}
	
	// URL regex parser
	@Test
	public void test13()
	{
		assertEquals(
			1,
			parses(
				"start: $url",
				"http://www.danielbigham.ca"
			)
		);
	}
	
	/**
	 * Returns the number of times the given input parses to a spanning START result for the
	 * given grammar.
	 * 
	 * @param grammar		the grammar.
	 * @param input			the input.
	 */
	public static int parses(String grammar, String input)
	{
		Grammar grammarObj = new Grammar(grammar, debugFlag);
		ParserState state = ChartParser.parse(grammarObj, input);
		List<IPatternMatch> matches = state.chart().getMatchesForSpan(ChartParser.START_SYMBOL, 0, state.getEndPos());
		return matches == null ? 0 : matches.size();
	}
}
