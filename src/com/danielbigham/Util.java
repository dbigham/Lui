package com.danielbigham;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	
	/**
	 * Reads a file into a string.
	 * 
	 * @param path			the file to read.
	 * @param encoding		the character encoding.
	 * @return				the contents of the file.
	 * @throws IOException
	 */
	public static String readFile(String path, Charset encoding) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
	
	public static String readFile(File path) throws IOException
	{
		return readFile(path.toString());
	}
	
	public static String readFile(String path) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, StandardCharsets.UTF_8);
	}
	
	/**
	 * Writes a string to a file.
	 * 
	 * @param path		the path to the file.
	 * @param data		the string data.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void writeFile(String path, String data) throws FileNotFoundException
	{
		try (PrintWriter out = new PrintWriter(path))
		{
			out.println(data);
		}
	}
	
	/**
	 * Indents a multi-line string.
	 * 
	 * @param str		the string to indent.
	 * @param levels	the number of levels to indent.
	 */
	public static String indent(String str, int levels)
	{
		String indent = "";
		
		for (int i = 0; i < levels; ++i)
		{
			indent += "    ";
		}
		
		return str.replaceAll("(?m)^", indent);
	}
	
	/**
	 * Send an HTTP request.
	 * 
	 * @param url		the URL.
	 * @return			the response string.
	 * 
	 * @throws IOException
	 */
	public static String httpRequest(String url) throws IOException
	{
		StringBuilder str = new StringBuilder(200);
		URL url2 = new URL(url);
		URLConnection urlConnection = url2.openConnection();
		BufferedReader in =
			new BufferedReader(
				new InputStreamReader(
					urlConnection.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) 
			str.append(inputLine);
		
		in.close();
		
		return str.toString();
	}
	
	/**
	 * Given a string and a substring, returns the line number where the substring
	 * first occurs, or -1 if it doesn't occur.
	 * 
	 * @param str		the string.
	 * @param substr	the substring.
	 * @return			the line number where the substring first occurs, or -1 if it doesn't occur.
	 */
	public static int getLineNum(String str, String substr)
	{
		int index = str.indexOf(substr);
		if (index == -1)
		{
			return -1;
		}
		else
		{
			int numNewlineCharacters = 0;
			for (int i = 0; i <= index; ++i)
			{
				if (str.charAt(i) == '\n')
				{
					++numNewlineCharacters;
				}
			}
			
			return numNewlineCharacters + 1;
		}
	}
}
