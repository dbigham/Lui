package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;
import how.How;

import org.junit.Test;

public class TestHow
{
	@Test
	public void formatLongDateTime()
	{
		assertEquals(
			"2017-01-07 12:43:25",
			How.formatLongDateTime(1483811005000L, "yyyy-MM-dd hh:mm:ss")
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest1()
	{
		assertEquals(
			"    one",
			How.replaceTabsWithSpaces("\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest2()
	{
		assertEquals(
			"a   one",
			How.replaceTabsWithSpaces("a\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest3()
	{
		assertEquals(
			"ab  one",
			How.replaceTabsWithSpaces("ab\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest4()
	{
		assertEquals(
			"abc one",
			How.replaceTabsWithSpaces("abc\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest5()
	{
		assertEquals(
			"abc\n    one",
			How.replaceTabsWithSpaces("abc\n\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest6()
	{
		assertEquals(
			"a           one",
			How.replaceTabsWithSpaces("a\t\t\tone", 4)
		);
	}
	
	@Test
	public void replaceSpacesWithTabs()
	{
		assertEquals(
			"abc\n\t\n\tabc\n\t\tabc",
			How.replaceSpacesWithTabs("abc\n    \n    abc\n        abc", 4)
		);
	}
}
