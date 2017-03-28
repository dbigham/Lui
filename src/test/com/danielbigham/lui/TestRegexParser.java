package test.com.danielbigham.lui;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.patternmatch.IPatternMatch;
import com.danielbigham.lui.regex.ParserHelper;

public class TestRegexParser extends TestCase
{
	protected String grammarSymbol;
	protected ParserHelper parser;
	
	protected void setUp(ParserHelper parser, String grammarSymbol) throws Exception
	{
		this.parser = parser;
		this.grammarSymbol = grammarSymbol;
	}
	
	/**
	 * Run the input through the regex parser and ensure the given substring
	 * parses to the expected symbol.
	 */
	protected IPatternMatch doTest(String str, String substring)
	{
		Grammar grammar = new Grammar();
		List<IPatternMatch> tokens = new ArrayList<IPatternMatch>();
		parser.parse(grammar, tokens, str);
		int pos = str.indexOf(substring);
		assertNotEquals(-1, pos);
		assertEquals(1, tokens.size());
		assertEquals(pos, tokens.get(0).startPos());
		assertEquals(pos + substring.length() - 1, tokens.get(0).endPos());
		assertTrue(
			tokens.toString().matches("\\[\\" + grammarSymbol + ".*\\]")
		);
		return tokens.get(0);
	}
	
	/**
	 * Run the input through the regex parser and ensure it parses to the
	 * expected thing.
	 */
	protected IPatternMatch doTest(String str)
	{
		return doTest(str, str);
	}
	
	protected void testExpression(String str, String expectedExpression)
	{
		IPatternMatch match = doTest(str);
		assertEquals(match.expr(), expectedExpression);
	}
	
	@Test
	public void test1()
	{
	}
}