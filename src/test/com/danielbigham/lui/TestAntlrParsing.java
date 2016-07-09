package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.danielbigham.lui.grammarrule.GrammarRule;
import com.danielbigham.lui.loading.AntlrHelpers;

public class TestAntlrParsing
{
	// No action
	@Test
	public void test1()
	{
		List<GrammarRule> rules = parseGrammar("webpage: spacex reddit");
		assertEquals(1, rules.size());
		assertEquals("<$webpage:2>:\n    {<spacex:0> <reddit:1>}\n        null", rules.get(0).toString());
	}
	
	// Simple action (string)
	@Test
	public void test2()
	{
		List<GrammarRule> rules = parseGrammar("webpage: spacex reddit -> \"https://www.reddit.com/r/spacex\"");
		assertEquals(1, rules.size());
		assertEquals("<$webpage:2>:\n    {<spacex:0> <reddit:1>}\n        \"https://www.reddit.com/r/spacex\"", rules.get(0).toString());
	}
	
	// OR
	@Test
	public void test3()
	{
		List<GrammarRule> rules = parseGrammar("webpage: spacex|spx reddit");
		assertEquals(1, rules.size());
		assertEquals("<$webpage:3>:\n    {<spacex:0>|<spx:1> <reddit:2>}\n        null", rules.get(0).toString());
	}
	
	// Top level OR (should avoid wrapping it with an unnecessary SequencePattern)
	@Test
	public void test4()
	{
		List<GrammarRule> rules = parseGrammar("~spacex: spacex|spx");
		assertEquals(1, rules.size());
		assertEquals("<~spacex:2>:\n    <spacex:0>|<spx:1>\n        null", rules.get(0).toString());
	}
	
	// Avoid unnecessary SequencePatterns
	@Test
	public void test5()
	{
		List<GrammarRule> rules = parseGrammar("~spacex: (((((spacex|spx)))))");
		assertEquals(1, rules.size());
		assertEquals("<~spacex:2>:\n    <spacex:0>|<spx:1>\n        null", rules.get(0).toString());
	}
	
	// Symbols ($directory) in pattern
	@Test
	public void test6()
	{
		List<GrammarRule> rules = parseGrammar("directory: $directory dir|directory");
		assertEquals(1, rules.size());
		assertEquals("<$directory:0>:\n    {<$directory:0> <dir:1>|<directory:2>}\n        null", rules.get(0).toString());
	}
	
	// Rules grouped by LHS symbol
	@Test
	public void test7()
	{
		List<GrammarRule> rules = parseGrammar("webpage:\n\tspacex|spx reddit\n\tslashdot\n\tthe verge");
		assertEquals(3, rules.size());
		assertEquals("<$webpage:3>:\n    {<spacex:0>|<spx:1> <reddit:2>}\n        null", rules.get(0).toString());
		assertEquals("<$webpage:3>:\n    <slashdot:4>\n        null", rules.get(1).toString());
		assertEquals("<$webpage:3>:\n    {<the:5> <verge:6>}\n        null", rules.get(2).toString());
	}
	
	/**
	 * Parses the given grammar rules.
	 * 
	 * @param grammarRules		the grammar rules.
	 * @return					the parsed grammar rules.
	 */
	private static List<GrammarRule> parseGrammar(String grammarRules)
	{
		return AntlrHelpers.parseGrammar(grammarRules);
	}
}
