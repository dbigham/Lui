package test.com.danielbigham.lui;

import org.junit.Test;

import com.danielbigham.lui.GrammarSymbols;
import com.danielbigham.lui.regex.UrlParser;

public class TestUrlParser extends TestRegexParser
{
	@Override
	protected void setUp() throws Exception
	{
		super.setUp(new UrlParser(), GrammarSymbols.URL); 
	}
	
	@Test
	public void test1()
	{
		doTest("http://www.danielbigham.ca");
	}
	
	@Test
	public void test2()
	{
		doTest("http://www.danielbigham.ca/");
	}
	
	@Test
	public void test3()
	{
		doTest("http://www.danielbigham.ca/dir");
	}
	
	@Test
	public void test4()
	{
		doTest("http://www.danielbigham.ca/dir/subdir");
	}
	
	@Test
	public void test5()
	{
		doTest("http://www.danielbigham.ca/abc_def");
	}
}
