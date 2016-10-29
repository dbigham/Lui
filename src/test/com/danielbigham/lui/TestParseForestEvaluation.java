package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.danielbigham.lui.evaluation.ParseForestEvaluation;

public class TestParseForestEvaluation
{
	@Test
	public void testSubstituteVariables()
	{
		Map<String, String> variables = new HashMap<String, String>();
		
		variables.put("var", "1");
		
		assertEquals(
			"1",
			ParseForestEvaluation.substituteVariables(
				"var",
				variables
			)
		);
	}
	
	@Test
	public void testSubstituteVariables2()
	{
		Map<String, String> variables = new HashMap<String, String>();
		
		variables.put("var1", "1");
		variables.put("var2", "2");
		
		assertEquals(
			"1 2",
			ParseForestEvaluation.substituteVariables(
				"var1 var2",
				variables
			)
		);
	}
	
	@Test
	public void testSubstituteVariables3()
	{
		Map<String, String> variables = new HashMap<String, String>();
		
		variables.put("a", "1");
		variables.put("b", "2");
		
		assertEquals(
			"Wrapper[1, 2, c]",
			ParseForestEvaluation.substituteVariables(
				"Wrapper[a, b, c]",
				variables
			)
		);
	}
	
	// Don't do variable substitution in strings.
	@Test
	public void testSubstituteVariables4()
	{
		Map<String, String> variables = new HashMap<String, String>();
		
		variables.put("a", "1");
		
		assertEquals(
			"Wrapper[1, \"a b c\", 'a b c']",
			ParseForestEvaluation.substituteVariables(
				"Wrapper[a, \"a b c\", 'a b c']",
				variables
			)
		);
	}
	
	// Remove newlines
	@Test
	public void testSubstituteVariables5()
	{
		Map<String, String> variables = new HashMap<String, String>();
		
		variables.put("a", "1");
		
		assertEquals(
			"Wrapper[1, \"a b c\", 'a b c']",
			ParseForestEvaluation.substituteVariables(
				"\nWrapper[\n    a,\n    \"a b c\",\n    'a b c'\n]\n",
				variables
			)
		);
	}
	
	@Test
	public void testFlattenVariables()
	{
		Map<String, Set<String>> variableValues = new HashMap<String, Set<String>>();
		
		Set<String> values = new HashSet<String>();
		values.add("1");
		values.add("2");
		variableValues.put("a", values);
		
		values = new HashSet<String>();
		values.add("3");
		variableValues.put("b", values);
		
		List<Map<String, String>> res =
				ParseForestEvaluation.flattenVariables(variableValues);
		
		assertEquals(2, res.size());
	}
	
	@Test
	public void testFlattenVariables2()
	{
		Map<String, Set<String>> variableValues = new HashMap<String, Set<String>>();
		
		Set<String> values = new HashSet<String>();
		values.add("1");
		values.add("2");
		variableValues.put("a", values);
		
		values = new HashSet<String>();
		values.add("3");
		values.add("4");
		variableValues.put("b", values);
		
		List<Map<String, String>> res =
				ParseForestEvaluation.flattenVariables(variableValues);
		
		assertEquals(4, res.size());
	}
}
