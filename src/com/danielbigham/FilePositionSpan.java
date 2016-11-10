package com.danielbigham;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import com.danielbigham.io.IOHelpers;

/**
 * Denotes a span within a file that may pertain to some object, etc.
 * 
 * @author Daniel
 */
public class FilePositionSpan
{
	private final String file;
	private final int start;
	private final int end;
	
	public FilePositionSpan(String file, int start, int end)
	{
		this.file = file;
		this.start = start;
		this.end = end;
	}
	
	/**
	 * The file.
	 */
	public String getFile()
	{
		return file;
	}

	/**
	 * The start position of the span in the file.
	 */
	public int getStart()
	{
		return start;
	}

	/**
	 * The ending position of the span in the file.
	 */
	public int getEnd()
	{
		return end;
	}
	
	/**
	 * Replace this span of a file with new contents.
	 * 
	 * Could do this more efficiently by skipping the StringBuilder
	 * and just streaming it out to the file.
	 * 
	 * @param str	The new contents.
	 * 
	 * @throws IOException 
	 */
	public void replace(String str) throws IOException
	{
		replaceHelper(str, end);
	}
	
	/**
	 * Replace this span of a file with new contents.
	 * 
	 * Could do this more efficiently by skipping the StringBuilder
	 * and just streaming it out to the file.
	 * 
	 * @param str			The new contents.
	 * @param endOffset		Extend the span to be replaced.
	 * 
	 * @throws IOException 
	 */
	public void replace(String str, int endOffset) throws IOException
	{
		replaceHelper(str, end + endOffset);
	}
	
	private void replaceHelper(String str, int end) throws IOException
	{
		String contents = IOHelpers.readFile(Paths.get(file));
		//StringBuilder str2 = new StringBuilder(contents.length() - (end - start + 1) + str.length() + 1);
		try(PrintWriter out = new PrintWriter(file))
		{
			out.print(contents.substring(0, start));
			out.print(str);
			out.print(contents.substring(end + 1));
		}
	}
	
	public String toString()
	{
		return
			"<FilePositionSpan: " +
			Paths.get(file).getFileName().toString() +
			"@" + start + "-" + end + ">";
	}

	/**
	 * Returns the text associated with this span of the file.
	 * 
	 * @throws IOException 
	 */
	public String getText() throws IOException
	{
		return IOHelpers.readFile(Paths.get(file)).substring(start - 1, end + 1);
	}
}
