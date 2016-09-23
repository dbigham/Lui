package com.danielbigham.lui;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.danielbigham.lui.pattern.LiteralPattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public class Tokenizer
{
	private Pattern pattern;
	
	public Tokenizer()
	{
		pattern = Pattern.compile("[A-Za-z]+|[0-9]+|[^\\s]");
	}
	
	/**
	 * Tokenize a string into a sequence of tokens.
	 * 
	 * @param grammar			the grammar. (defines mappings from words -> integers)
	 * @param str				the input string.
	 * @param createTokenIds	create new token IDs if never-before-literals are seen?
	 */
	public List<IPatternMatch> tokenize(Grammar grammar, String str, boolean createTokenIds)
	{
		List<IPatternMatch> tokens = new ArrayList<IPatternMatch>();
		
		Matcher matcher = pattern.matcher(str);
		while (matcher.find())
		{
			//Out.print("Tokenizer match: " + matcher.start() + " to " + matcher.end());
			String substring = str.substring(matcher.start(), matcher.end());
			tokens.add(new LiteralPattern(grammar, substring, matcher.start(), matcher.end() - 1, createTokenIds));
		}
		
		return tokens;
	}
	
	public List<IPatternMatch> tokenize(Grammar grammar, String str)
	{
		return tokenize(grammar, str, false);
	}
}
