package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.danielbigham.io.Out;
import com.danielbigham.lui.ChartParser;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.evaluation.ParseForestEvaluation;

public class TestParserState
{
	@Test
	public void testCombineVariableMaps()
	{
		List<Map<String, Set<String>>> variableSets = new ArrayList<Map<String, Set<String>>>();
		
		Map<String, Set<String>> variableSet = new HashMap<String, Set<String>>();
		Set<String> values = new HashSet<String>();
		values.add("1");
		values.add("2");
		variableSet.put("a", values);
		variableSets.add(variableSet);
		
		variableSet = new HashMap<String, Set<String>>();
		values = new HashSet<String>();
		values.add("3");
		variableSet.put("a", values);
		values = new HashSet<String>();
		values.add("4");
		variableSet.put("b", values);
		variableSets.add(variableSet);
		
		Map<String, Set<String>> res = ParserState.combineVariableMaps(variableSets);
		
		assertEquals(res.get("a").size(), 3);
		assertEquals(res.get("b").size(), 1);
	}
	
	@Test
	public void testEvaluate1()
	{
		assertEquals(
			"Wrapper[]",
			parse(
				"start: one two -> Wrapper[]",
				"one two"
			)
		);
	}
	
	// Binding on literal
	@Test
	public void testEvaluate2()
	{
		assertEquals(
			"Wrapper[one]",
			parse(
				"start: a=one two -> Wrapper[a]",
				"one two"
			)
		);
	}
	
	// Binding on literals
	@Test
	public void testEvaluate3()
	{
		assertEquals(
			"Wrapper[one, two]",
			parse(
				"start: a=one b=two -> Wrapper[a, b]",
				"one two"
			)
		);
	}
	
	@Test
	public void testEvaluate4()
	{
		assertEquals(
			"Wrapper[SPACEX_REDDIT]",
			parse(
				"start: open a=$website -> Wrapper[a]\n" +
				"website: spacex reddit -> SPACEX_REDDIT",
				"open spacex reddit"
			)
		);
	}
	
	@Test
	public void testEvaluate5()
	{
		assertEquals(
			"Wrapper[open, SPACEX_REDDIT]",
			parse(
				"start: (a=open | \"go to\") b=$website -> Wrapper[a, b]\n" +
				"website: spacex reddit -> SPACEX_REDDIT",
				"open spacex reddit"
			)
		);
	}
	
	@Test
	public void testEvaluate6()
	{
		assertEquals(
			"Wrapper[a, SPACEX_REDDIT]",
			parse(
				"start: (open | a=\"go to\") b=$website -> Wrapper[a, b]\n" +
				"website: spacex reddit -> SPACEX_REDDIT",
				"open spacex reddit"
			)
		);
	}
	
	// Not currently supported because "go to" gets turned into a SequencePattern (I think)
	// without bindings on any of the inner parts. Would require more thought.
//	@Test
//	public void testEvaluate7()
//	{
//		assertEquals(
//			"Wrapper[go to, SPACEX_REDDIT]",
//			parse(
//				"start: (open | a=\"go to\") b=$website -> Wrapper[a, b]\n" +
//				"website: spacex reddit -> SPACEX_REDDIT",
//				"go to spacex reddit"
//			)
//		);
//	}
	
	@Test
	public void testEvaluate8()
	{
		assertEquals(
			"Wrapper[SPACEX_REDDIT]",
			parse(
				"start: open a=($website|$file) -> Wrapper[a]\n" +
				"website: spacex reddit -> SPACEX_REDDIT",
				"open spacex reddit"
			)
		);
	}
	
	/**
	 * Returns the parsed expression.
	 * 
	 * @param grammar		the grammar.
	 * @param input			the input.
	 */
	public static String parse(String grammar, String input)
	{
		Grammar grammarObj = new Grammar(grammar, false);
		ParserState state = ChartParser.parse(grammarObj, input);
		return ParseForestEvaluation.evaluate(state);
	}
}
