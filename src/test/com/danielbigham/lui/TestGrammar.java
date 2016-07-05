package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.SequencePattern;

public class TestGrammar
{
	private static final int RESULT_SYMBOL = 1;
	
	@Test
	public void countBasicPatternInstancesTest1()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(SequencePattern.create(grammar, "just just testing", RESULT_SYMBOL));
		
		Map<Integer, Integer> counts = Grammar.countBasicPatternInstances(patterns);
		
		// 'just' occurs twice
		assertEquals(2, counts.get(0).intValue());
		
		// 'testing' occurs once
		assertEquals(1, counts.get(1).intValue());
	}
	
	// The second word, which is 'testing', should be used
	// as the trigger, since it occurs less often than 'just'.
	@Test
	public void getTriggeredPatternsTest1()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(SequencePattern.create(grammar, "just just testing", RESULT_SYMBOL));
		grammar.setPatterns(patterns);
		
		assertEquals(null, grammar.getTriggeredPatterns(0, 0, 0));
		assertEquals(1, grammar.getTriggeredPatterns(1, 0, 0).size());
		assertEquals(null, grammar.getTriggeredPatterns(2, 0, 0));
	}
	
	// Test the case where we must consider multiple patterns properly
	// to determine the rarest token. In this case, 'just' should be
	// used as the trigger, since it occurs 3 times in comparison to
	// 'testing' occurring 4 times.
	@Test
	public void getTriggeredPatternsTest2()
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = new ArrayList<IPattern>();
		patterns.add(SequencePattern.create(grammar, "just just testing", RESULT_SYMBOL));
		patterns.add(SequencePattern.create(grammar, "just testing testing testing", RESULT_SYMBOL));
		grammar.setPatterns(patterns);
		
		assertEquals(2, grammar.getTriggeredPatterns(0, 0, 0).size());
		assertEquals(null, grammar.getTriggeredPatterns(1, 0, 0));
		assertEquals(null, grammar.getTriggeredPatterns(2, 0, 0));
	}
}
