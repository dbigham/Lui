package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.danielbigham.Util;

public class TestUtil
{
	@Test
	public void test1()
	{
		assertEquals(
			"\tabc",
			Util.indent("abc", 1)
		);
	}
	
	@Test
	public void test2()
	{
		assertEquals(
			"\tabc\n\tdef",
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
}
