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
		
		// Also ensure that the rule parser assigned the result symbol integer
		// to the pattern itself, since that's actually where it ends up getting
		// used right now. (as opposed to in the wrapping grammar rule object)
		assertEquals(2, rules.get(0).getPattern().resultSymbol());
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
		assertEquals("<$webpage:3>:\n    {(<spacex:0>|<spx:1>) <reddit:2>}\n        null", rules.get(0).toString());
	}
	
	// Top level OR (should avoid wrapping it with an unnecessary SequencePattern)
	@Test
	public void test4()
	{
		List<GrammarRule> rules = parseGrammar("~spacex: spacex|spx");
		assertEquals(1, rules.size());
		assertEquals("<~spacex:2>:\n    (<spacex:0>|<spx:1>)\n        null", rules.get(0).toString());
	}
	
	// Avoid unnecessary SequencePatterns
	@Test
	public void test5()
	{
		List<GrammarRule> rules = parseGrammar("~spacex: (((((spacex|spx)))))");
		assertEquals(1, rules.size());
		assertEquals("<~spacex:2>:\n    (<spacex:0>|<spx:1>)\n        null", rules.get(0).toString());
	}
	
	// Symbols ($directory) in pattern
	@Test
	public void test6()
	{
		List<GrammarRule> rules = parseGrammar("directory: $directory (dir|directory)");
		assertEquals(1, rules.size());
		assertEquals("<$directory:0>:\n    {directory=<$directory:0> (<dir:1>|<directory:2>)}\n        directory", rules.get(0).toString());
	}
	
	// Rules grouped by LHS symbol
	@Test
	public void test7()
	{
		List<GrammarRule> rules = parseGrammar("webpage:\n\t(spacex|spx) reddit\n\tslashdot\n\tthe verge");
		assertEquals(3, rules.size());
		assertEquals("<$webpage:3>:\n    {(<spacex:0>|<spx:1>) <reddit:2>}\n        null", rules.get(0).toString());
		assertEquals("<$webpage:3>:\n    {<slashdot:4>}\n        null", rules.get(1).toString());
		assertEquals("<$webpage:3>:\n    {<the:5> <verge:6>}\n        null", rules.get(2).toString());
	}
	
	@Test
	public void test8()
	{
		List<GrammarRule> rules = parseGrammar("start: $webpage\nwebpage: slashdot");
		assertEquals(2, rules.size());
		assertEquals("<$start:-1>:\n    {webpage=<$webpage:0>}\n        webpage", rules.get(0).toString());
		assertEquals("<$webpage:0>:\n    {<slashdot:1>}\n        null", rules.get(1).toString());
	}
	
	// Bindings
	@Test
	public void test9()
	{
		List<GrammarRule> rules = parseGrammar("expr: a=$integer b=$integer -> a + b");
		assertEquals(1, rules.size());
		assertEquals("<$expr:1>:\n    {a=<$integer:0> b=<$integer:0>}\n        a + b", rules.get(0).toString());
	}
	
	// Bindings inside of an OR pattern
	@Test
	public void test10()
	{
		List<GrammarRule> rules = parseGrammar("expr: (a=$integer|b=$integer) -> Wrapper[a,b]");
		assertEquals(1, rules.size());
		assertEquals("<$expr:1>:\n    (a=<$integer:0>|b=<$integer:0>)\n        Wrapper[a,b]", rules.get(0).toString());
	}
	
	// Default action
	@Test
	public void test11()
	{
		List<GrammarRule> rules = parseGrammar("start: $symbol test");
		assertEquals(1, rules.size());
		assertEquals("<$start:-1>:\n    {symbol=<$symbol:0> <test:1>}\n        symbol", rules.get(0).toString());
	}
	
	// Default action
	@Test
	public void test12()
	{
		List<GrammarRule> rules = parseGrammar("start: $symbol");
		assertEquals(1, rules.size());
		assertEquals("<$start:-1>:\n    {symbol=<$symbol:0>}\n        symbol", rules.get(0).toString());
	}
	
	// Newlines between rules
	@Test
	public void test13()
	{
		List<GrammarRule> rules = parseGrammar("start: $symbol\n\nstart: $symbol2");
		assertEquals(2, rules.size());
	}
	
	// Newline + tab between rules
	@Test
	public void test14()
	{
		List<GrammarRule> rules = parseGrammar("start:\n\t$symbol\n\t\n\t$symbol2");
		assertEquals(2, rules.size());
	}
	
	// Newline between rules
	@Test
	public void test15()
	{
		List<GrammarRule> rules = parseGrammar("start:\n\t$symbol\n\n\t$symbol2");
		assertEquals(2, rules.size());
	}
	
	// Whitespace
	@Test
	public void test16()
	{
		List<GrammarRule> rules = parseGrammar("start:\n\t$symbol\n \n  \n   \n\t$symbol2");
		assertEquals(2, rules.size());
	}
	
	// Whitespace before and after rules
	@Test
	public void test17()
	{
		List<GrammarRule> rules = parseGrammar(" \n start:\n\t$symbol\n \n  \n   \n\t$symbol2 \n ");
		assertEquals(2, rules.size());
	}
	
	// String
	@Test
	public void test18()
	{
		List<GrammarRule> rules = parseGrammar("symbol: twenty|\"twenty one\"");
		assertEquals(1, rules.size());
		assertEquals("<$symbol:2>:\n    (<twenty:0>|{<twenty:0> <one:1>})\n        null", rules.get(0).toString());
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
