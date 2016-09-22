package com.danielbigham.lui.regex;

import java.util.regex.Pattern;

import com.danielbigham.lui.GrammarSymbols;

public class QuotedStringParser extends RegexParserBase
{
	public QuotedStringParser()
	{
		pattern = Pattern.compile("(\"(?:[^\"]|\\\")*\")|('(?:[^\']|\\\')*')");
		symbols.add(GrammarSymbols.QuotedString);
	}
}
