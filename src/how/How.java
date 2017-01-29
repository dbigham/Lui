package how;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

public class How
{
	// <answer questionid="get-matching-double-quote-of-string" version="2017-01-04 09:36:44">

	/**
	 * Given a string and a position within that string that is the double quote of
	 * the start of a double quoted string, returns the string position of the
	 * closing double quote.
	 * 
	 * @param str						the string.
	 * @param posOfOpeningDoubleQuote	the position of the opening double quote.
	 * @return							the position of the closing double quote,
	 *									or -1 if not found.
	 */
	public static int getClosingDoubleQuoteOfString(String str, int posOfOpeningDoubleQuote) {
		
		if (str.charAt(posOfOpeningDoubleQuote) != '"') {
			throw new IllegalArgumentException("Initial character expected to be a double quote.");
		}
		
		boolean nextCharacterIsEscaped = false;
		
		for (int i = posOfOpeningDoubleQuote + 1; i < str.length(); ++i) {
			char thisChar = str.charAt(i);
			
			if (!nextCharacterIsEscaped) {
				if (thisChar == '"') {
					return i;
				} else if (thisChar == '\\') {
					nextCharacterIsEscaped = true;
				}
			} else {
				nextCharacterIsEscaped = false;
			}
		}
		
		return -1;
	}
	
	// </answer>

	// <answer questionid="get-matching-closing-bracket" version="2016-12-18 09:36:47">
	
	/**
	 * Given a string and a position within that string of an opening bracket --
	 * where that bracket could be something like "{" or "[" or "(" -- return the
	 * position of the matching closing bracket.
	 * 
	 * If single or double quoted strings occur, closing brackets within them are
	 * ignored.
	 * 
	 * @param str						the string.
	 * @param posOfOpeningBracket		the position of the opening bracket.
	 * @param openingBracket			the opening bracket character.
	 * @param closingBracket			the closing bracket character.
	 * @return							the position of the closing bracket,
	 *									or -1 if not found.
	 */
	public static int getMatchingClosingBracket(
		String str, int posOfOpeningBracket, char openingBracket, char closingBracket) {
		
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
				i = getClosingDoubleQuoteOfString(str, i);
				if (i == -1) { break; }
			} else if (thisChar == '\'') {
				i = getClosingSingleQuoteOfString(str, i);
				if (i == -1) { break; }
			}
		}
		
		return -1;
	}
	
	// </answer>

	// <answer questionid="get-closing-single-quote-of-string" version="2016-12-31 09:50:23">
	
	/**
	 * Given a string and a position within that string that is the single quote of
	 * the start of a single quoted string, returns the string position of the
	 * closing single quote.
	 * 
	 * @param str						the string.
	 * @param posOfOpeningSingleQuote	the position of the opening single quote.
	 * @return							the position of the closing single quote,
	 *									or -1 if not found.
	 */
	public static int getClosingSingleQuoteOfString(String str, int posOfOpeningSingleQuote) {
		
		if (str.charAt(posOfOpeningSingleQuote) != '\'') {
			throw new IllegalArgumentException("Initial character expected to be a single quote.");
		}
		
		boolean nextCharacterIsEscaped = false;
		
		for (int i = posOfOpeningSingleQuote + 1; i < str.length(); ++i) {
			char thisChar = str.charAt(i);
			
			if (!nextCharacterIsEscaped) {
				if (thisChar == '\'') {
					return i;
				} else if (thisChar == '\\') {
					nextCharacterIsEscaped = true;
				}
			} else {
				nextCharacterIsEscaped = false;
			}
		}
		
		return -1;
	}
	
	// </answer>

	// <answer questionid="replace-a-span-within-a-string" version="2016-12-17 10:22:50">
	
	/**
	 * Given a string and a span [start, end) within that string, replace the span
	 * with the given replacement.
	 * 
	 * @param str		the string.
	 * @param start		the starting index of the span to replace, inclusive.
	 * @param end		the ending index of the span to replace, exclusive.
	 */
	public static String replaceStringSpan(
		String str, int start, int end, String replacement)
	{
		if (start != 0 && end != str.length()) {
			return
				str.substring(0, start) +
				replacement +
				str.substring(end);
		} else if (start == 0) {
			return replacement + str.substring(end - 1);
		} else if (end == str.length()) {
			return str.substring(0, start) + replacement;
		} else {
			return replacement;
		}
	}
	
	// </answer>

	// <answer questionid="convert-long-to-formatted-datetime" version="2017-01-07 12:47:07">
	
	/**
	 * Format a long date-time. (number of milliseconds since Jan 1 1970)
	 * 
	 * @param longDateTime		the long date-time.
	 * @param format			the format. ex. "yyyy-MM-dd hh:mm:ss"
	 * @return					the formatted date-time.
	 */
	public static String formatLongDateTime(long longDateTime, String format) {
		Date dateTime = new Date(longDateTime);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(dateTime);
	}
	
	// </answer>

	// <answer questionid="get-the-next-character-of-a-given-type-after-whitespace" version="2016-12-12 08:05:39">
	
	/**
	 * Given a string and a string position, return the index of the next character
	 * of the given character type that occurs after optional whitespace characters.
	 *
	 * @param str		the string.
	 * @param pos		the 0-based string position.
	 * @param character the character of interest.
	 * @return			the index of the next character of the given type after
	 *					whitespace or -1 if there isn't one.
	 */
	public static int nextCharacterOfTypeAfterWhitespace(String str, int pos, char character) {
		for (pos = pos + 1; pos < str.length(); ++pos) {
			if (!Character.isWhitespace(str.charAt(pos))) {
				if (str.charAt(pos) == character) {
					return pos;
				}
				else
				{
					return -1;
				}
			}
		}
		
		return -1;
	}
	
	// </answer>

	// <answer questionid="get-list-of-substrings-matched-by-regex" version="2016-12-15 10:57:08">
	
	/**
	 * Extract substrings using a regular expression.
	 * 
	 * @param str		the string.
	 * @param pattern	the regex to match.
	 * @return			the list of values for the first capturing group
	 *					or the list of matched substrings if no capturing groups
	 */
	public static List<String> extractSubstrings(String str, String pattern) {
		Pattern patternObj = Pattern.compile(pattern);
		return extractSubstrings(str, patternObj);
	}
	
	/**
	 * Extract substrings using a regular expression.
	 * 
	 * @param str			the string.
	 * @param pattern		the regex to match.
	 * @return				the list of values for the first capturing group
	 *						or the list of matched substrings if no capturing groups
	 */
	public static List<String> extractSubstrings(String str, Pattern pattern) {
		Matcher matcher = pattern.matcher(str);
		
		List<String> list = new ArrayList<>();
		
		while (matcher.find()) {
			if (matcher.groupCount() == 1) {
				// The first capturing group.
				list.add(matcher.group(1));
			} else if (matcher.groupCount() > 1) {
				throw new IllegalArgumentException(
					"This method only supports a single capturing group.");
			} else {
				// The entire match.
				list.add(matcher.group(0));
			}
		}
		
		return list;
	}
	
	// </answer>

	// <answer questionid="reverse-a-map" version="2016-12-09 08:31:54">
	
	/**
	 * Invert a map so that its keys become values and its values become keys.
	 * Assumes there are no duplicate values.
	 * 
	 * @param map	the map to be inverted.
	 * @return		the inverted map.
	 */
	public static <Type1, Type2> Map<Type2, Type1> invertMap(Map<Type1, Type2> map) {
		Map<Type2, Type1> invertedMap = new HashMap<>();
		for (Map.Entry<Type1, Type2> entry : map.entrySet()) {
			invertedMap.put(entry.getValue(), entry.getKey());
		}
		return invertedMap;
	}
	
	// </answer>

	// <answer questionid="convert-tabs-to-spaces" version="2016-12-20 08:29:46">
	
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
				int spacesNeededHere = spacesPerTab - (column % spacesPerTab);
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
	
	// </answer>

	// <answer questionid="get-line-number-of-substring" version="2017-01-11 07:51:04">
	
	/**
	 * Given a string and a substring to find within that string, returns the
	 * line number that the substring first occurs on.
	 * 
	 * @param str		the string.
	 * @param substring the substring to find.
	 * @return			the line number where the substring first occurs
	 *					or -1 if not found.
	 */
	 public static int getLineNumberOfSubstring(String str, String substr)
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
	
	// </answer>

	// <answer questionid="repeat-a-string" version="2016-12-20 08:46:06">
	
	/**
	 * Repeat a string.
	 * 
	 * @param stringToRepeat	the string to repeat.
	 * @param count				the number of times to repeat the string.
	 * @return					the concatenation of the repeated strings.
	 */
	public static String repeatString(String stringToRepeat, int count) {
		return new String(new char[count]).replace("\0", stringToRepeat);    
	}
	
	// </answer>

	// <answer questionid="replace-spaces-with-tabs" version="2017-01-07 01:55:02">
	
	/**
	 * Replace the spaces in a string with tabs.
	 * 
	 * @param str			the string.
	 * @param spacesPerTab	the number of spaces per tab.
	 * @return				the string with spaces converted to tabs.
	 */
	public static String replaceSpacesWithTabs(String str, int spacesPerTab)
	{
		StringBuilder builder = new StringBuilder((int)Math.round(str.length() * 0.8));
		int column = -1;
		for (int i = 0; i < str.length(); ++i) {
			++column;
			
			char c = str.charAt(i);
			
			if (c == '\n') {
				column = -1;
				builder.append(c);
			} else if (c == '\t') {
				column += spacesPerTab - 1;
				builder.append(c);
			} else if (c == ' ') {
				// Read the one or more spaces at this location.
				int spacesStartIndex = i;
				while(i < str.length() && str.charAt(i) == ' ') {
					++i;
					++column;
				}
				
				int spacesEndIndex = i;
				
				int numContiguousSpaces = spacesEndIndex - spacesStartIndex;
				
				if (numContiguousSpaces > 1 && column % spacesPerTab == 0) {
					int numTabs = numContiguousSpaces / spacesPerTab;
					if (numContiguousSpaces % spacesPerTab != 0) {
						++numTabs;
					}
					builder.append(repeatString("\t", numTabs));
				} else {
					// Not enough spaces 
					builder.append(str.substring(spacesStartIndex, spacesEndIndex));
				}
				
				if (i < str.length()) {
					--i;
					--column;
				}
			} else {
				builder.append(c);
			}
		}
		
		return builder.toString();
	}
	
	// </answer>

	// <answer questionid="get-next-character-of-a-given-type" version="2016-12-31 10:13:52">
	
	/**
	 * Returns the index of the next character of the given type.
	 * 
	 * @param str			the string.
	 * @param startIndex	the index to start looking from.
	 * @param charType		the character to look for.
	 * @return				the index of the next character of the given type
	 *						or -1 if not found.
	 */
	public static int nextIndexOfCharacter(String str, int startIndex, char charType) {
		for (int i = startIndex; i < str.length(); ++i) {
			if (str.charAt(i) == charType) {
				return i;
			}
		}
		return -1;
	}
	
	// </answer>

	// <answer questionid="http-request" version="2016-11-27 08:01:36">
	
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
	
	// </answer>

	// <answer questionid="indent-lines" version="2017-01-13 11:25:08">
	
	/**
	 * Indents a multi-line string.
	 * 
	 * @param str						the string to indent.
	 * @param indentationWhitespace		the whitespace to add at the beginning of each line.
	 */
	public static String indentLines(String str, String indentationWhitespace) {
		return str.replaceAll("(?m)^", indentationWhitespace);
	}
	
	// </answer>

	// <answer questionid="get-string-index-beyond-whitespace" version="2016-12-31 03:52:55">
	
	/**
	 * Given a string and a string position, return the index of the next character
	 * at or after the given position that isn't a whitespace character.
	 * 
	 * @param str		the string.
	 * @param startPos	the 0-based string position.
	 * @return			the index of the next non-whitespace character
	 *					or -1 if there isn't one.
	 */
	public static int skipWhitespace(String str, int startPos) {
		for (int pos = startPos; pos < str.length(); ++pos) {
			if (!Character.isWhitespace(str.charAt(pos))) {
				return pos;
			}
		}
		
		return -1;
	}

	// <answer questionid="encrypt-data" version="2017-01-29 11:37:43">
	
	/**
	 * Encrypt data.
	 * 
	 * @param publicKey		the public key. 
	 * @param bytes			the bytes to encrypt.
	 * @return				the encrypted bytes.
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] encryptByteArray(PublicKey publicKey, byte[] bytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");	
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
		return cipher.doFinal(bytes);
	}
	
	// </answer>

	// <answer questionid="encrypt-data-as-base64-encoded-string" version="2017-01-29 11:38:20">
	
	/**
	 * Encrypt an array of bytes as a BASE64 encoded string.
	 * 
	 * @param publicKey		the public key.
	 * @param bytes			the bytes to encrypt.
	 * @return				the encrypted data as a BASE64 encoded string.
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws UnsupportedEncodingException
	 */
	public static String encryptByteArrayToString(PublicKey publicKey, byte[] bytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		byte[] encryptedBytes = encryptByteArray(publicKey, bytes);
		return DatatypeConverter.printBase64Binary(encryptedBytes);
	}
	
	// </answer>

	// <answer questionid="decrypt-data" version="2017-01-29 11:26:01">
	
	/**
	 * Decrypt an array of bytes.
	 * 
	 * @param key		the private key.
	 * @param bytes		the bytes to decrypt.
	 * @return			the decrypted bytes.
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public static byte[] decryptByteArray(PrivateKey key, byte[] bytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");	
		cipher.init(Cipher.DECRYPT_MODE, key);	
		return cipher.doFinal(bytes);
	}
	
	// </answer>
}