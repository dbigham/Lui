package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.danielbigham.lui.antlr.GrammarRuleSyntaxError;
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
		assertEquals("$webpage:\n    {spacex reddit}\n        null", rules.get(0).toString());
		
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
		assertEquals("$webpage:\n    {spacex reddit}\n        \"https://www.reddit.com/r/spacex\"", rules.get(0).toString());
	}
	
	// OR
	@Test
	public void test3()
	{
		List<GrammarRule> rules = parseGrammar("webpage: spacex|spx reddit");
		assertEquals(1, rules.size());
		assertEquals("$webpage:\n    {(spacex|spx) reddit}\n        null", rules.get(0).toString());
	}
	
	// Top level OR (should avoid wrapping it with an unnecessary SequencePattern)
	@Test
	public void test4()
	{
		List<GrammarRule> rules = parseGrammar("~spacex: spacex|spx");
		assertEquals(1, rules.size());
		assertEquals("~spacex:\n    (spacex|spx)\n        null", rules.get(0).toString());
	}
	
	// Avoid unnecessary SequencePatterns
	@Test
	public void test5()
	{
		List<GrammarRule> rules = parseGrammar("~spacex: (((((spacex|spx)))))");
		assertEquals(1, rules.size());
		assertEquals("~spacex:\n    (spacex|spx)\n        null", rules.get(0).toString());
	}
	
	// Symbols ($directory) in pattern
	@Test
	public void test6()
	{
		List<GrammarRule> rules = parseGrammar("directory: $directory (dir|directory)");
		assertEquals(1, rules.size());
		assertEquals("$directory:\n    {directory=$directory (dir|directory)}\n        directory", rules.get(0).toString());
	}
	
	// Rules grouped by LHS symbol
	@Test
	public void test7()
	{
		List<GrammarRule> rules = parseGrammar("webpage:\n\t(spacex|spx) reddit\n\tslashdot\n\tthe verge");
		assertEquals(3, rules.size());
		assertEquals("$webpage:\n    {(spacex|spx) reddit}\n        null", rules.get(0).toString());
		assertEquals("$webpage:\n    {slashdot}\n        null", rules.get(1).toString());
		assertEquals("$webpage:\n    {the verge}\n        null", rules.get(2).toString());
	}
	
	@Test
	public void test8()
	{
		List<GrammarRule> rules = parseGrammar("start: $webpage\nwebpage: slashdot");
		assertEquals(2, rules.size());
		assertEquals("$start:\n    {webpage=$webpage}\n        webpage", rules.get(0).toString());
		assertEquals("$webpage:\n    {slashdot}\n        null", rules.get(1).toString());
	}
	
	// Bindings
	@Test
	public void test9()
	{
		List<GrammarRule> rules = parseGrammar("expr: a=$integer b=$integer -> a + b");
		assertEquals(1, rules.size());
		assertEquals("$expr:\n    {a=$integer b=$integer}\n        a + b", rules.get(0).toString());
	}
	
	// Bindings inside of an OR pattern
	@Test
	public void test10()
	{
		List<GrammarRule> rules = parseGrammar("expr: (a=$integer|b=$integer) -> Wrapper[a,b]");
		assertEquals(1, rules.size());
		assertEquals("$expr:\n    (a=$integer|b=$integer)\n        Wrapper[a,b]", rules.get(0).toString());
	}
	
	// Default action
	@Test
	public void test11()
	{
		List<GrammarRule> rules = parseGrammar("start: $symbol test");
		assertEquals(1, rules.size());
		assertEquals("$start:\n    {symbol=$symbol test}\n        symbol", rules.get(0).toString());
	}
	
	// Default action
	@Test
	public void test12()
	{
		List<GrammarRule> rules = parseGrammar("start: $symbol");
		assertEquals(1, rules.size());
		assertEquals("$start:\n    {symbol=$symbol}\n        symbol", rules.get(0).toString());
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
		assertEquals("$symbol:\n    (twenty|{twenty one})\n        null", rules.get(0).toString());
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
	
	@Test
	public void test19()
	{
		assertTrue(AntlrHelpers.isSimpleRule("one -> 1"));
		//assertFalse(AntlrHelpers.isSimpleRule(":"));
	}
	
	// Syntax error
	@Test(expected=GrammarRuleSyntaxError.class)
	public void test20()
	{
		parseGrammar(":");
	}
	
	// Syntax error
	@Test
	public void test21()
	{
		try
		{
			parseGrammar(":");
		}
		catch (Exception e)
		{
			assertEquals("Syntax error at line 1, column 0.", e.getMessage());
		}
	}
	
	
	// Top level OR has composite sub-patterns, and isn't surrounded by parens
	@Test
	public void test22()
	{
		List<GrammarRule> rules = parseGrammar("start: dbca | (my (webpage|website))");
		assertEquals(1, rules.size());
		assertEquals("$start:\n    (dbca|{my (webpage|website)})\n        null", rules.get(0).toString());
	}
	
	@Test
	public void test23()
	{
		List<GrammarRule> rules = parseGrammar("start: testing 1 2 3 123");
		assertEquals(1, rules.size());
		assertEquals("$start:\n    {testing 1 2 3 123}\n        null", rules.get(0).toString());
	}
	
	@Test
	public void test24()
	{
		List<GrammarRule> rules = parseGrammar(" \n start:\n\ta b? c");
		assertEquals(1, rules.size());
	}
}
