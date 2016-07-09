package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.danielbigham.lui.ChartParser;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.ParserState;

public class TestToWL
{
//	@Test
//	public void test1()
//	{
//		assertEquals(
//			"{{{-1,0,2},null,{{0,0,2}}},{{0,0,2},null,{{6,0,0},{8,1,2}}},{{6,0,0},null,{{1,0,0}}},{{8,1,2},null,{{7,1,2}}},{{7,1,2},null,{{4,1,1},{5,2,2}}},Null}",
//			toWL(
//				"start: $webpage\n" +
//				"webpage: spacex|spx webpage|(web page)",
//				"spacex web page"
//			)
//		);
//	}
	
//	@Test
//	public void test2()
//	{
//		assertEquals(
//			"{{{-1,0,2},HoldComplete[a+b],{{0,0,0},{1,1,1},{2,2,2}}},{{0,0,0},HoldComplete[1],{{3,0,0}}},{{2,2,2},HoldComplete[2],{{4,2,2}}},Null}",
//			toWL(
//				"start: a=$a PLUS b=$b -> a+b\n" +
//				"a: ONE -> 1\n" +
//				"b: TWO -> 2",
//				"ONE PLUS TWO"
//			)
//		);
//	}
	
//	@Test
//	public void test3()
//	{
//		assertEquals(
//			"{{{-1,0,0},\"Hey!\",{{0,0,0}}},Null}",
//			toWL(
//				"start: hello -> \"Hey!\"",
//				"hello"
//			)
//		);
//	}
	
	/**
	 * Parses the input and returns the Wolfram Language expression.
	 * 
	 * @param grammar		the grammar.
	 * @param input			the input.
	 */
	public static String toWL(String grammar, String input)
	{
		Grammar grammarObj = new Grammar(grammar);
		ParserState state = ChartParser.parse(grammarObj, input);
		return state.toWL();
	}
}
