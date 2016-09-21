package com.danielbigham.io;

import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.StdLink;

public class Out
{
	/**
	 * Outputs a string. Will print to a Mathematica notebook if one is available.
	 * 
	 * @param str		the string.
	 */
	public static void print(String str)
	{
		KernelLink link = StdLink.getLink();
		//String link = null;
		if (link != null)
		{
			link.print(str);
		}
		else
		{
			System.out.println(str);
		}
	}
	
	public static void print(Object obj)
	{
		print(obj.toString());
	}
	
	public static void line()
	{
		Out.print("--------------------------------------------------------------------------------");
	}
}
