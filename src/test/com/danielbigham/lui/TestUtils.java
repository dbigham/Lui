package test.com.danielbigham.lui;

public class TestUtils
{
	public static String intArrayToStr(int[] arr)
	{
		StringBuilder str = new StringBuilder(arr.length * 4 + 2);
		str.append("[");
		for (int i = 0; i < arr.length; ++i)
		{
			if (i > 0) { str.append(", "); }
			str.append(arr[i]);
		}
		str.append("]");
		return str.toString();
	}
}
