package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.pattern.OrPattern;

public class TestOrPattern
{
	private static final int RESULT_SYMBOL = 1;
	
	@Test
	public void test1()
	{
		Grammar grammar = new Grammar();
		OrPattern pattern = OrPattern.create(grammar, "apple|orange|banana", RESULT_SYMBOL);
		
		assertEquals("(apple|orange|banana)", pattern.toString());
	}
}
