package test.com.danielbigham.lui;

import org.junit.Test;

import com.danielbigham.lui.regex.QuotedStringParser;

public class TestQuotedStringParser extends TestRegexParser
{
	@Override
	protected void setUp() throws Exception
	{
		super.setUp(new QuotedStringParser(), "$QuotedString"); 
	}
	
	@Test
	public void test1()
	{
		doTest("\"quoted string\"");
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
		doTest("'quoted string'");
	}
}
