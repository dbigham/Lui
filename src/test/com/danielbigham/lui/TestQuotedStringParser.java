package test.com.danielbigham.lui;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.GrammarSymbols;
import com.danielbigham.lui.patternmatch.IPatternMatch;
import com.danielbigham.lui.regex.QuotedStringParser;

public class TestQuotedStringParser extends TestRegexParser
{
	@Override
	protected void setUp() throws Exception
	{
		super.setUp(new QuotedStringParser(), GrammarSymbols.QuotedString); 
	}
	
	@Test
	public void test1()
	{
		testExpression("\"quoted string\"", "\"quoted string\"");
	}
	
	@Test
	public void test2()
	{
		doTest("just another \"quoted string\" to parse", "\"quoted string\"");
	}
	
	@Test
	public void test3()
	{
		doTest("\"quoted string \\\"with escaped double quotes\\\"\"");
	}
	
	@Test
	public void test4()
	{
		testExpression("'quoted string'", "\"quoted string\"");
	}
	
	@Test
	public void test5()
	{
		testExpression("'quoted \"string\"'", "\"quoted \\\"string\\\"\"");
	}
	
	@Test
	public void test6()
	{
		testExpression("'quoted \\'string\\''", "\"quoted 'string'\"");
	}
	
	@Test
	public void test7()
	{
		String str = "\"quoted string\" and \"another quoted string\"";
		String substring = "\"quoted string\"";
		
		Grammar grammar = new Grammar();
		List<IPatternMatch> tokens = new ArrayList<IPatternMatch>();
		parser.parse(grammar, tokens, str);
		int pos = str.indexOf(substring);
		assertNotEquals(-1, pos);
		assertEquals(2, tokens.size());
		assertEquals(pos, tokens.get(0).startPos());
		assertEquals(pos + substring.length() - 1, tokens.get(0).endPos());
		assertTrue(
			tokens.toString().matches("\\[\\" + grammarSymbol + ".*\\]")
		);
	}
}
