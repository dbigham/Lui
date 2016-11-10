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
}
