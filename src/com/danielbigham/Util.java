package com.danielbigham;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.danielbigham.io.Out;

public class Util
{
	/**
	 * Reads an XML string into a list of maps.
	 * 
	 * @param xml		the XML string.
	 * @param tag		the tag of interest.
	 * @return			the list of maps.
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static List<Map<String, String>> parseXml(
			String xml, String tag) throws SAXException, IOException, ParserConfigurationException
	{
		List<Map<String, String>> result = new ArrayList<>();
		
		// Create InputStream from String
		InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(inputStream);
		
		doc.getDocumentElement().normalize();
		
		NodeList nodes = doc.getElementsByTagName(tag);
		
		// For each XML element.
		for (int i = 0; i < nodes.getLength(); ++i)
		{
			Map<String, String> map = new HashMap<>();
			result.add(map);
			
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				// For each child of the XML element.
				NodeList childNodes = node.getChildNodes();
				for (int j = 0; j < childNodes.getLength(); ++j)
				{
					Node childNode = childNodes.item(j);
					map.put(childNode.getNodeName(), childNode.getTextContent());
				}
				
				// For each attribute.
				if (node.hasAttributes())
				{
					NamedNodeMap nodeMap = node.getAttributes();
					for (int k = 0; k < nodeMap.getLength(); ++k)
					{
						Node attribute = nodeMap.item(k);
						map.put(attribute.getNodeName(), attribute.getNodeValue());
					}
				}
			}
		}
		
		return result;
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
			indent += "	";
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
	
	public static String escapeHTML(String s) {
		
		// Hard to know what to do here.
		if (s == null) { return "null"; }
		
		StringBuilder out = new StringBuilder(Math.max(16, s.length()));
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
				out.append("&#");
				out.append((int) c);
				out.append(';');
			} else {
				out.append(c);
			}
		}
		return out.toString();
	}
	
	/**
	 * Returns the values of a map, sorted.
	 * 
	 * @param map		the map.
	 * @return			the values of the map sorted.
	 */
	public static List<String> sortedValues(Map<String, String> map)
	{
		List<String> list = new ArrayList<String>();
		list.addAll(map.values());
		Collections.sort(list);
		
		return list;
	}
	
	/**
	 * Returns the keys of a map, sorted.
	 * 
	 * @param map		the map.
	 * @return			the keys of the map sorted.
	 */
	public static List<String> sortedKeys(Map<String, String> map)
	{
		List<String> list = new ArrayList<String>();
		list.addAll(map.keySet());
		Collections.sort(list);
		
		return list;
	}

	/**
	 * Given a string and a position within that string of an opening bracket --
	 * where that bracket could be something like "{" or "[" or "(" -- return the
	 * position of the matching closing bracket. (for AutoHotKey, where double
	 * quoted strings work differently)
	 * 
	 * If single or double quoted strings occur, closing brackets within them are
	 * ignored.
	 * 
	 * @param str					the string.
	 * @param posOfOpeningBracket	the position of the opening bracket.
	 * @param openingBracket		the opening bracket character.
	 * @param closing				the closing bracket character.
	 * @return						the position of the closing bracket,
	 *								or -1 if not found.
	 */
	public static int getMatchingClosingBracketAutoHotKey(String str, int posOfOpeningBracket, char openingBracket, char closingBracket) {
		
		if (str.charAt(posOfOpeningBracket) != openingBracket) {
			throw new IllegalArgumentException("Initial character expected to be: '" + openingBracket + "'");
		}
	
		int depth = 1;
		
		for (int i = posOfOpeningBracket + 1; i < str.length(); ++i) {
			
			char thisChar = str.charAt(i);
			
			if (thisChar == closingBracket) {
				--depth;
				if (depth == 0) {
					return i;
				}
			} else if (thisChar == openingBracket) {
				++depth;
			} else if (thisChar == '"') {
				i = getClosingDoubleQuoteOfStringAutoHotKey(str, i);
				if (i == -1) { break; }
			}
		}
		
		return -1;
	}
	
	/**
	 * Given a string and a position within that string that is the double quote of
	 * the start of a double quoted string, returns the string position of the
	 * closing double quote. (for AutoHotKey strings)
	 * 
	 * @param str						the string.
	 * @param posOfOpeningDoubleQuote	the position of the opening double quote.
	 * @return						  	the position of the closing double quote,
	 *								  	or -1 if not found.
	 */
	public static int getClosingDoubleQuoteOfStringAutoHotKey(String str, int posOfOpeningDoubleQuote) {
		
		if (str.charAt(posOfOpeningDoubleQuote) != '"') {
			throw new IllegalArgumentException("Initial character expected to be a double quote.");
		}
				
		for (int i = posOfOpeningDoubleQuote + 1; i < str.length(); ++i) {
			char thisChar = str.charAt(i);
			
			if (thisChar == '"') {
				if (i == str.length() - 1 || str.charAt(i + 1) != '"') {
					return i;
				} else if (str.charAt(i + 1) == '"') {
					++i;
				}
			}
		}
		
		return -1;
	}
}
