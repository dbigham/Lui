package com.danielbigham.lui.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.danielbigham.io.Out;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.GrammarSymbols;
import com.danielbigham.lui.pattern.SymbolPattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public class UrlParser implements RegexParser
{
	private Pattern pattern;
	private List<String> symbols;
	
	public UrlParser()
	{
		pattern = Pattern.compile("(http|https|ftp)://([A-Za-z0-9]+\\.)*[A-Za-z0-9]+");
		symbols = new ArrayList<String>();
		symbols.add(GrammarSymbols.URL);
	}
	
	@Override
	public void parse(Grammar grammar, List<IPatternMatch> tokens, String str)
	{
		Matcher matcher = pattern.matcher(str);
		while (matcher.find())
		{
			Out.print("URL regex match: " + matcher.start() + " to " + matcher.end() + ": " + str.substring(matcher.start(), matcher.end()));
			tokens.add(new SymbolPattern(grammar, GrammarSymbols.URL, matcher.start(), matcher.end() - 1, false));
		}
	}

	@Override
	public List<String> grammarSymbols()
	{
		return symbols;
	}
}
