package com.danielbigham.lui.regex;

import java.util.List;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public interface ParserHelper
{
	public void parse(Grammar grammar, List<IPatternMatch> tokens, String str);
	
	/**
	 * Returns the list of grammar symbols used by this parser.
	 */
	public List<String> grammarSymbols();
	
	/**
	 * Takes the matched substring and turns it into a semantic expression.
	 * 
	 * @param str		the matched substring.
	 * @return			a semantic expression.
	 */
	public String toExpression(String str);
}
