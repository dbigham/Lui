package com.danielbigham;

import com.danielbigham.io.Out;
import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.StdLink;

public class Util2
{
	/**
	 * Make a call to Wolfram Language and execute a command.
	 * 
	 * @param command		the command to execute.
	 */
	public static void callWL(String command)
	{
		final KernelLink link = StdLink.getLink();
		if (link != null)
		{
			try
			{
				link.evaluate(command);
				link.discardAnswer();
			}
			catch (MathLinkException e2)
			{
				link.print("Unexpected problem calling WL: " + e2.toString());
			}
		}
		else
		{
			Out.print("ERROR: Couldn't find KernelLink via JLink");
		}
	}
}
