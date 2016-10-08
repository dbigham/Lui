package com.danielbigham;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.danielbigham.io.Out;
import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.StdLink;

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

	/**
	 * Append to a file. Adds newlines as well.
	 * 
	 * @param file		the file's path.
	 * @param str		the string to append.
	 * 
	 * @throws IOException 
	 */
	public static void fileAppend(String file, String str) throws IOException
	{
		try(FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw))
		{
			out.println("\n" + str);
		}
	}
	
	/**
	 * Gets the clipboard as text.
	 * 
	 * @return the contents of the clipboard.
	 * 
	 * @throws HeadlessException
	 * @throws UnsupportedFlavorException
	 * @throws IOException
	 */
	public static String getClipboard() throws HeadlessException, UnsupportedFlavorException, IOException
	{
		return (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
	}
}
