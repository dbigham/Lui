package com.danielbigham.lui.regex;

import java.util.regex.Pattern;

import com.danielbigham.lui.GrammarSymbols;

public class UrlParser extends RegexParserBase
{
	public UrlParser()
	{
		// http://stackoverflow.com/questions/3809401/what-is-a-good-regular-expression-to-match-a-url
		pattern = Pattern.compile("(http|https|ftp)://(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&/=]*)");
		symbols.add(GrammarSymbols.URL);
	}
}
