package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.pattern.SequencePattern;

public class TestSequencePattern
{
	private static final int RESULT_SYMBOL = 1;
	
	// Both instances of the literal 'just' get assigned the token ID 0.
	@Test
	public void test1()
	{
		Grammar grammar = new Grammar();
		SequencePattern pattern = SequencePattern.create(grammar, "just just testing", RESULT_SYMBOL);
		
		assertEquals("{just just testing}", pattern.toString());
	}
}
