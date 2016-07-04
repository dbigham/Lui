package com.danielbigham.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOHelpers
{
	/**
	 * Reads a file as a string.
	 * 
	 * @param path				the file.
	 * @param encoding			the character encoding. ex. StandardCharsets.UTF_8
	 * @return					the contents of the file as a String.
	 * 
	 * @throws IOException
	 */
	public static String readFile(Path path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(path);
		return new String(encoded, encoding);
	}

	/**
	 * Reads a file as a string using the UTF8 encoding.
	 * 
	 * @param path				the file.
	 * @return					the contents of the file as a String.
	 * 
	 * @throws IOException
	 */
	public static String readFile(Path path) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(path);
		return new String(encoded, StandardCharsets.UTF_8);
	}
}
