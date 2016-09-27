package com.danielbigham;

public class Util
{
	public static String createDoubleQuotedString(String str)
	{
		if (str == null)
		{
			return "Null";
		}
		else
		{
			return "\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
		}
	}
}
