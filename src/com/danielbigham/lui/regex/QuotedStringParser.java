package com.danielbigham.lui.regex;

import java.util.regex.Pattern;

import com.danielbigham.Util;
import com.danielbigham.io.Out;
import com.danielbigham.lui.GrammarSymbols;

public class QuotedStringParser extends RegexParserBase
{
	public QuotedStringParser()
	{
		pattern = Pattern.compile("(\"(?:[^\"]|\\\")*\")|('(?:[^\']|\\\')*')");
		symbols.add(GrammarSymbols.QuotedString);
	}
	
	@Override
	public String toExpression(String str)
	{
		if (str.startsWith("\""))
		{
			return str;
		}
		else
		{
			String inner = str.substring(1, str.length() - 1);
			inner = inner.replace("\\'", "'");
			inner = inner.replace("\\\\", "\\");
			String res = Util.createDoubleQuotedString(inner);
			Out.print(res);
			return res;
		}
	}
}
