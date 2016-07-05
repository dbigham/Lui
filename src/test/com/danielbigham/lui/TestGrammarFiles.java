package test.com.danielbigham.lui;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.danielbigham.lui.grammarrule.GrammarRule;
import com.danielbigham.lui.loading.AntlrHelpers;
import com.danielbigham.lui.loading.RuleHandler;

public class TestGrammarFiles
{
	@Test
	public void test1()
	{
		List<GrammarRule> rules = parseGrammar("webpage: spacex reddit");
		assertEquals(1, rules.size());
	}
	
//	@Test
//	public void test2()
//	{
//		List<GrammarRule> rules = parseGrammar("webpage:\n\tspacex reddit\n\tslashdot\n\tthe verge");
//		assertEquals(3, rules.size());
//	}
	
	/**
	 * Parses the given grammar rules.
	 * 
	 * @param grammarRules		the grammar rules.
	 * @return					the parsed grammar rules.
	 */
	private static List<GrammarRule> parseGrammar(String grammarRules)
	{
		RuleHandler ruleHandler = new RuleHandler();
		AntlrHelpers.parseGrammar(grammarRules, ruleHandler);
		return ruleHandler.getRules();
	}
}
