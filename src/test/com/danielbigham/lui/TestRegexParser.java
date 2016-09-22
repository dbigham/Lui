package test.com.danielbigham.lui;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.patternmatch.IPatternMatch;
import com.danielbigham.lui.regex.RegexParser;

public class TestRegexParser extends TestCase
{
	protected String grammarSymbol;
	protected RegexParser parser;
	
	protected void setUp(RegexParser parser, String grammarSymbol) throws Exception
	{
		this.parser = parser;
		this.grammarSymbol = grammarSymbol;
	}
	
	/**
	 * Run the input through the regex parser and ensure the given substring
	 * parses to the expected symbol.
	 */
	protected void doTest(String str, String substring)
	{
		Grammar grammar = new Grammar();
		List<IPatternMatch> tokens = new ArrayList<IPatternMatch>();
		parser.parse(grammar, tokens, str);
		int pos = str.indexOf(substring);
		assertNotEquals(-1, pos);
		assertEquals(1, tokens.size());
		assertEquals(pos, tokens.get(0).startPos());
		assertEquals(pos + substring.length() - 1, tokens.get(0).endPos());
		assertEquals(
			"[<" + grammarSymbol + ":-2>]",
			tokens.toString()
		);
	}
	
	/**
	 * Run the input through the regex parser and ensure it parses to the
	 * expected thing.
	 */
	protected void doTest(String str)
	{
		doTest(str, str);
	}
	
	@Test
	public void test1()
	{
	}
}