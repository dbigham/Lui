package com.danielbigham.lui.antlr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Error listener for ANTLR that will allow us to direct output elsewhere,
 * such as to the WL notebook.
 * 
 * http://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
 * 
 * @author Daniel
 */
public class DescriptiveErrorListener extends BaseErrorListener
{
	public static DescriptiveErrorListener INSTANCE = new DescriptiveErrorListener();

	@Override
	public void syntaxError(
		Recognizer<?, ?> recognizer,
		Object offendingSymbol,
		int line,
		int charPositionInLine,
		String msg,
		RecognitionException e)
	{
		String sourceName = recognizer.getInputStream().getSourceName();
		throw new GrammarRuleSyntaxError(sourceName, line, charPositionInLine, msg);

		//Out.print("Line " + line + " column " + charPositionInLine + ": " + msg);
	}
}