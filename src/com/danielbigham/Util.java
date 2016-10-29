package com.danielbigham;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
