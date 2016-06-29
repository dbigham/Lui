package test.org.danielbigham;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.danielbigham.Grammar;
import org.danielbigham.pattern.IPattern;
import org.danielbigham.pattern.Pattern;
import org.junit.Test;

public class TestPattern
{
	// Literals
	@Test
	public void test1()
	{
		Grammar grammar = new Grammar();
		
		List<IPattern> pattern = Pattern.parse(grammar, "just testing");
		
		assertEquals("[<just:0>, <testing:1>]", pattern.toString());
	}
	
	// Literals and symbols
	@Test
	public void test2()
	{
		Grammar grammar = new Grammar();
		
		List<IPattern> pattern = Pattern.parse(grammar, "just $testing");
		
		assertEquals("[<just:0>, <$testing:1>]", pattern.toString());
	}
}
