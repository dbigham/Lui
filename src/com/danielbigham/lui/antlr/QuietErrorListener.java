package com.danielbigham.lui.antlr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Quiet errors.
 * 
 * Todo: Still seems to print errors to stderr?
 * 
 * @author Daniel
 */
public class QuietErrorListener extends BaseErrorListener
{
	public static QuietErrorListener INSTANCE = new QuietErrorListener();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
							int line, int charPositionInLine,
							String msg, RecognitionException e)
	{
	}
}