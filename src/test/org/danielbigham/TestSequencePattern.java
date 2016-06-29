package test.org.danielbigham;

import static org.junit.Assert.assertEquals;

import org.danielbigham.Grammar;
import org.danielbigham.SequencePattern;
import org.junit.Test;

public class TestSequencePattern
{
	private static final int RESULT_SYMBOL = 1;
	
	// Both instances of the literal 'just' get assigned the token ID 0.
	@Test
	public void test1()
	{
		Grammar grammar = new Grammar();
		SequencePattern pattern = SequencePattern.create(grammar, "just just testing", RESULT_SYMBOL);
		
		assertEquals("{<just:0> <just:0> <testing:1>}", pattern.toString());
	}
}
