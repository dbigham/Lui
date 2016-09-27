package com.danielbigham.lui.antlr;

import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Exception representing a syntax error that occurred while parsing
 * a .grammar file.
 * 
 * @author Daniel
 */
public class GrammarRuleSyntaxError extends ParseCancellationException
{
	private static final long serialVersionUID = 1L;
	private final String sourceName;
	private final int line;
	private final int charPositionInLine;
	private final String msg;

	public GrammarRuleSyntaxError(
			String sourceName,
			int line,
			int charPositionInLine,
			String msg)
	{
		this.sourceName = sourceName;
		this.line = line;
		this.charPositionInLine = charPositionInLine;
		this.msg = msg;
	}

	public String getSourceName()
	{
		return sourceName;
	}

	public int getLine()
	{
		return line;
	}

	public int getCharPositionInLine()
	{
		return charPositionInLine;
	}

	/**
	 * The raw message produced by ANTLR.
	 */
	public String getMsg()
	{
		return msg;
	}
	
	@Override
	public String getMessage()
	{
		String errorLocation;
		if (!sourceName.isEmpty() && !"<unknown>".equals(sourceName)) {
			errorLocation =
				String.format("in %s at line %d, column %d", sourceName, line, charPositionInLine);
		}
		else
		{
			errorLocation = String.format("line %d, column %d", line, charPositionInLine);
		}
		
		return "Syntax error at " + errorLocation + ".";
	}
}
