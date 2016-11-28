package test.com.danielbigham.lui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.danielbigham.Util;

public class TestUtil
{
	@Test
	public void test1()
	{
		assertEquals(
			"    abc",
			Util.indent("abc", 1)
		);
	}
	
	@Test
	public void test2()
	{
		assertEquals(
			"    abc\n    def",
			Util.indent("abc\ndef", 1)
		);
	}
	
	@Test
	public void test3()
	{
		assertEquals(
			"just\r\ntesting",
			Util.toWindowsString("just\ntesting")
		);
	}
	
	@Test
	public void test4()
	{
		assertEquals(
			"just\r\ntesting",
			Util.toWindowsString("just\r\ntesting")
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest1()
	{
		assertEquals(
			"    one",
			Util.replaceTabsWithSpaces("\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest2()
	{
		assertEquals(
			"a   one",
			Util.replaceTabsWithSpaces("a\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest3()
	{
		assertEquals(
			"ab  one",
			Util.replaceTabsWithSpaces("ab\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest4()
	{
		assertEquals(
			"abc one",
			Util.replaceTabsWithSpaces("abc\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest5()
	{
		assertEquals(
			"abc\n    one",
			Util.replaceTabsWithSpaces("abc\n\tone", 4)
		);
	}
	
	@Test
	public void replaceTabsWithSpacesTest6()
	{
		assertEquals(
			"a           one",
			Util.replaceTabsWithSpaces("a\t\t\tone", 4)
		);
	}
}
