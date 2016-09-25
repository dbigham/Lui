package com.danielbigham;

public class Util
{
	public static String createDoubleQuotedString(String str)
	{
		return "\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
	}
}
