package com.danielbigham.lui.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.GrammarSymbols;
import com.danielbigham.lui.pattern.SymbolPattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public class IdParser implements RegexParser
{
	private Pattern pattern;
	private List<String> symbols;
	
	public IdParser()
	{
		pattern = Pattern.compile("[A-Za-z][A-Za-z0-9]+");
		symbols = new ArrayList<String>();
		symbols.add(GrammarSymbols.ID);
	}
	
	@Override
	public void parse(Grammar grammar, List<IPatternMatch> tokens, String str)
	{
		Matcher matcher = pattern.matcher(str);
		while (matcher.find())
		{
			//Out.print("Regex match: " + matcher.start() + " to " + matcher.end());
			tokens.add(new SymbolPattern(grammar, GrammarSymbols.ID, matcher.start(), matcher.end() - 1, false));
		}
	}

	@Override
	public List<String> grammarSymbols()
	{
		return symbols;
	}
}
