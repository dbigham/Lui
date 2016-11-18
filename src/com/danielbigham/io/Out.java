package com.danielbigham.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.StdLink;

public class Out
{
	private static File outFile;
	private static FileWriter fw;
	private static BufferedWriter bw;
	private static PrintWriter printWriter;

	/**
	 * Outputs a string. Will print to a Mathematica notebook if one is available.
	 * 
	 * @param str		the string.
	 */
	public static void print(String str)
	{
		if (outFile != null)
		{
			printToFile(str);
			return;
		}
		
		KernelLink link = StdLink.getLink();
		if (link != null)
		{
			link.print(str);
		}
		else
		{
			System.out.println(str);
		}
	}
	
	public static void printError(String str)
	{
		if (outFile != null)
		{
			printToFile(str);
			return;
		}
		
		KernelLink link = StdLink.getLink();
		if (link != null)
		{
			link.print(str);
		}
		else
		{
			System.err.println(str);
		}
	}
	
	/**
	 * Print to the output file.
	 * 
	 * @param str		the string to print.
	 */
	private static void printToFile(String str)
	{
		printWriter.println(str);
		printWriter.flush();
	}

	public static void print(Object obj)
	{
		print(obj.toString());
	}
	
	public static void line()
	{
		Out.print("--------------------------------------------------------------------------------");
	}
	
	/**
	 * Prints a 'section' name with dashed lines before and after.
	 * 
	 * @param section	the name of the section.
	 */
	public static void section(String section)
	{
		line();
		print(section);
		line();
	}
	
	/**
	 * Output should be directed to a file instead of to stdout/stderr.
	 * 
	 * @param file		the file to direct output to.
	 * 
	 * @throws IOException
	 */
	public static void redirectOutputToLogFile(File file) throws IOException
	{
		Out.outFile = file;
		fw = new FileWriter(file, true);
		bw = new BufferedWriter(fw);
		printWriter = new PrintWriter(bw);
	}
}
