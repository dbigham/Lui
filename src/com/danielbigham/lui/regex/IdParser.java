package com.danielbigham.lui.regex;

import java.util.regex.Pattern;

import com.danielbigham.Util;
import com.danielbigham.lui.GrammarSymbols;

public class IdParser extends RegexParserBase
{
	public IdParser()
	{
		pattern = Pattern.compile("[A-Za-z][A-Za-z0-9]*");
		symbols.add(GrammarSymbols.ID);
	}
	
	@Override
	public String toExpression(String str)
	{
		return Util.createDoubleQuotedString(str);
	}
}
