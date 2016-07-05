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
		
		List<IPatternMatch> tokens = Tokenizer.tokenize(grammar, "just testing");
		
		assertEquals("[<just:0>, <testing:1>]", tokens.toString());
	}
}
