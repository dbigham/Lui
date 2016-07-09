package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.danielbigham.lui.grammarrule.GrammarRule;
import com.danielbigham.lui.loading.AntlrHelpers;

public class TestRuleExplosion
{
	// No action
	@Test
	public void test1()
	{
		List<GrammarRule> rules = parseGrammar("webpage: spacex reddit");
		
	}
	
	/**
	 * Parses the given grammar rules.
	 * 
	 * @param grammarRules		the grammar rules.
	 * @return					the parsed grammar rules.
	 */
	private static List<GrammarRule> parseGrammar(String grammarRules)
	{
		return AntlrHelpers.parseGrammar(grammarRules);
	}
}
