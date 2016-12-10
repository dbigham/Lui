package com.danielbigham;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.danielbigham.io.Out;

public class Util
{
	/**
	 * Perform an HTTP POST.
	 * 
	 * @param url			the URL.
	 * @param data			the data to upload.
	 * @param contentType	the content type.
	 * @return				the response.
	 * 
	 * @throws IOException
	 */
	public static String httpPost(String url, String data, String contentType) throws IOException
	{
		HttpURLConnection connection = null;
	
		try
		{
			connection = httpConnection(url, contentType, data);
		
			httpUpload(connection, data);
			
			return httpDownload(connection);
		}
		finally
		{
			if (connection != null)
			{
				connection.disconnect();
			}
		}
	}
	
	/**
	 * Creates an HTTP POST connection.
	 * 
	 * @param url				the URL.
	 * @param contentType		the content type.
	 * @param data				the data to upload.
	 * @return					the HTTP connection.
	 * 
	 * @throws IOException
	 */
	public static HttpURLConnection httpConnection(String url, String contentType, String data) throws IOException
	{
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", contentType);
		connection.setRequestProperty("Content-Length",
			Integer.toString(data.getBytes().length));
		connection.setConnectTimeout(4000);
		connection.setUseCaches(false);
		connection.setDoOutput(true);
		return connection;
	}
	
	/**
	 * Uploads data for an HTTP POST operation.
	 * 
	 * @param connection		the HTTP connection.
	 * @param data				the data to upload.
	 * 
	 * @throws IOException
	 */
	public static void httpUpload(HttpURLConnection connection, String data) throws IOException
	{
		DataOutputStream uploadStream = new DataOutputStream(connection.getOutputStream());
		uploadStream.writeBytes(data);
		uploadStream.close();
	}
	
	/**
	 * Downloads the data for an HTTP POST operation.
	 * 
	 * @param connection		the HTTP connection.
	 * @return					the HTTP response.
	 * 
	 * @throws IOException
	 */
	public static String httpDownload(HttpURLConnection connection) throws IOException
	{
		InputStream downloadStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(downloadStream));
		StringBuilder response = new StringBuilder();
		while (true)
		{
			String line = reader.readLine();
			if (line == null) { break; }
			response.append(line);
			response.append('\n');
		}
		reader.close();
		
		return response.toString();
	}
	
	public static String createDoubleQuotedString(String str, boolean encodeNewlines)
	{
		if (str == null)
		{
			return "null";
		}
		else
		{
			String res = "\"" + str.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
			if (encodeNewlines)
			{
				res = res.replaceAll("\r?\n", "\\\\n");
			}
			else
			{
				res = res.replaceAll("\r?\n", "\n");
			}
			
			return res;
		}
	}
	
	public static String createDoubleQuotedString(String str)
	{
		return createDoubleQuotedString(str, true);
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
	 * Indents a multi-line string.
	 * 
	 * @param str						the string to indent.
	 * @param indentationWhitespace		the whitespace to add at the beginning of each line.
	 */
	public static String indent(String str, String indentationWhitespace)
	{
		return str.replaceAll("(?m)^", indentationWhitespace);
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

	/**
	 * Convert a string's newlines to Windows format.
	 */
	public static String toWindowsString(String str)
	{
		return str.replaceAll("(?<!\r)\n", "\r\n");
	}
	
	/**
	 * Returns true if all characters are letters.
	 */
	public static boolean allLetters(String str)
	{
		for (int i = 0; i < str.length(); ++i)
		{
			if (!Character.isLetter(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	private static double prevTime = System.nanoTime();
	public static void profile(String name)
	{
		double now = System.nanoTime();
		double millis = Math.round(((now - prevTime) / 1000000.0) * 100.0) / 100.0;
		Out.print("+" + millis + " ms: " + name);
		prevTime = now;
	}
	
	/**
	 * Replace the tabs in a string with spaces.
	 * 
	 * @param str				the string.
	 * @param spacesPerTab		the number of spaces per tab.
	 * @return					the string with tabs converted to spaces.
	 */
	public static String replaceTabsWithSpaces(String str, int spacesPerTab)
	{
		StringBuilder builder = new StringBuilder((int)Math.round(str.length() * 1.5));
		int column = -1;
		for (int i = 0; i < str.length(); ++i)
		{
			++column;
			
			char c = str.charAt(i);
			
			if (c == '\n') {
				column = -1;
				builder.append(c);
			}
			else if (c == '\t')
			{
				int spacesNeededHere = 4 - (column % spacesPerTab);
				for (int j = 0; j < spacesNeededHere; ++j)
				{
					builder.append(' ');
				}
				column += spacesNeededHere - 1;
			}
			else
			{
				builder.append(c);
			}
		}
		
		return builder.toString();
	}

	public static boolean allDigits(String str)
	{
		for (int i = 0; i < str.length(); ++i)
		{
			if (!Character.isDigit(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Read a file containing a list of key/value pairs into a map. Each line is of the form
	 * 
	 * key: value
	 * 
	 * @param file		the file to read.
	 * @return			the map.
	 * @throws IOException
	 */
	public static Map<String, String> readMap(String file) throws IOException
	{
		Map<String, String> map = new HashMap<String, String>();
		String lines = readFile(file);
		for(String line : lines.split("\n"))
		{
			line = line.trim();
			if (!line.isEmpty())
			{
				String[] parts = line.trim().split("=");
				String key = parts[0].trim();
				String value = parts[1].trim();
				map.put(key, value);
			}
		}
		return map;
	}
	
	/**
	 * Invert a map so that its keys become values and its values become keys.
	 * Assumes there are no duplicate values.
	 * 
	 * @param map	the map to be inverted.
	 */
	public static <Type1, Type2> Map<Type2, Type1> invertMap(Map<Type1, Type2> map) {
		Map<Type2, Type1> invertedMap = new HashMap<>();
		for (Map.Entry<Type1, Type2> entry : map.entrySet()) {
			invertedMap.put(entry.getValue(), entry.getKey());
		}
		return invertedMap;
	}
}
