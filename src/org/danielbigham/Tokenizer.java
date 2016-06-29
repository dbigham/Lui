package org.danielbigham;

import java.util.ArrayList;
import java.util.List;

import org.danielbigham.pattern.LiteralPattern;
import org.danielbigham.patternmatch.IPatternMatch;


public class Tokenizer
{
	/**
	 * Tokenize a string into a sequence of tokens.
	 * 
	 * @param grammar			the grammar. (defines mappings from words -> integers)
	 * @param str				the input string.
	 */
	public static List<IPatternMatch> tokenize(Grammar grammar, String str)
	{
		String[] rawTokens = str.trim().split("\\s+");
		
		List<IPatternMatch> tokens = new ArrayList<IPatternMatch>(rawTokens.length);
		int pos = 0;
		for (String token : rawTokens)
		{
			tokens.add(new LiteralPattern(grammar, token, pos, false));
			++pos;
		}
		
		return tokens;
	}
}
