package com.danielbigham.lui.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.pattern.SymbolPattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public abstract class RegexParserBase implements RegexParser
{
	protected Pattern pattern;
	protected List<String> symbols;
	
	public RegexParserBase()
	{
		symbols = new ArrayList<String>();
	}
	
	@Override
	public void parse(Grammar grammar, List<IPatternMatch> tokens, String str)
	{
		Matcher matcher = pattern.matcher(str);
		while (matcher.find())
		{
			//Out.print(this.getClass().getCanonicalName() + " regex match: " + matcher.start() + " to " + matcher.end() + ": " + str.substring(matcher.start(), matcher.end()));
			SymbolPattern patternMatch = new SymbolPattern(grammar, symbols.get(0), matcher.start(), matcher.end() - 1, false);
			
			String substr = str.substring(matcher.start(), matcher.end());
			patternMatch.setExpr(toExpression(substr));
			
			tokens.add(patternMatch);
		}
	}

	@Override
	public List<String> grammarSymbols()
	{
		return symbols;
	}
	
	@Override
	public String toExpression(String str)
	{
		return str;
	}
}
