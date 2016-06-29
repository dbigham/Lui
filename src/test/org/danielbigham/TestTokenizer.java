package test.org.danielbigham;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.danielbigham.Grammar;
import org.danielbigham.Tokenizer;
import org.danielbigham.pattern.Pattern;
import org.danielbigham.patternmatch.IPatternMatch;
import org.junit.Test;

public class TestTokenizer
{
	@Test
	public void test1()
	{
		Grammar grammar = new Grammar();
		
		// This will initialize the literal-to-integer mapping.
		Pattern.parse(grammar, "just testing");
		
		List<IPatternMatch> tokens = Tokenizer.tokenize(grammar, "just testing");
		
		assertEquals("[<just:0>, <testing:1>]", tokens.toString());
	}
}
