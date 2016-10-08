package com.danielbigham.lui.regex;

import java.util.regex.Pattern;

import com.danielbigham.Util;
import com.danielbigham.lui.GrammarSymbols;

public class QuotedStringParser extends RegexParserBase
{
	public QuotedStringParser()
	{
		// Note that the order of the OR is important.
		// - \\\\\" needs to come before [^\"]
		// - Otherwise, the [^\"] can match the backslash
		//   of an escaped double quote on its own, after
		//   which the double quoted is matched as the closing
		//   double quote.
		//   ex. "quoted string \"with escaped double quotes\""
		//   ... would think that: "quoted string \"
		//   ... is a match.
		pattern = Pattern.compile("(\"(\\\\\"|[^\"])*\")|('(\\\\\'|[^\'])*')");
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
			return res;
		}
	}
}
