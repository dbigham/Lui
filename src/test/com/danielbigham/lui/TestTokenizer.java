package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.Tokenizer;
import com.danielbigham.lui.pattern.Pattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public class TestTokenizer
{
	@Test
	public void test1()
	{
		Grammar grammar = new Grammar();
		// This will initialize the literal-to-integer mapping.
		Pattern.parse(grammar, "just testing");
		List<IPatternMatch> tokens = new Tokenizer().tokenize(grammar, "just testing");
		assertEquals("[just, testing]", tokens.toString());
	}
	
	@Test
	public void test2()
	{
		Grammar grammar = new Grammar();
		// This will initialize the literal-to-integer mapping.
		Pattern.parse(grammar, "testing 123");
		List<IPatternMatch> tokens = new Tokenizer().tokenize(grammar, "testing123");
		assertEquals("[testing, 123]", tokens.toString());
	}
	
	@Test
	public void test3()
	{
		Grammar grammar = new Grammar();
		// This will initialize the literal-to-integer mapping.
		Pattern.parse(grammar, "testing ( 123 )");
		List<IPatternMatch> tokens = new Tokenizer().tokenize(grammar, "testing(123)");
		assertEquals("[testing, \"(\", 123, \")\"]", tokens.toString());
	}
}
