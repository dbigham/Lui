package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.Pattern;

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
