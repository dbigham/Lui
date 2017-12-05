package com.danielbigham.lui.regex;

import java.util.regex.Pattern;

import com.danielbigham.Util;
import com.danielbigham.lui.GrammarSymbols;

public class DigitsParser extends RegexParserBase
{
	public DigitsParser()
	{
		pattern = Pattern.compile("[A-Za-z0-9]+");
		symbols.add(GrammarSymbols.Digits);
	}
	
	@Override
	public String toExpression(String str)
	{
		return str;
	}
}
