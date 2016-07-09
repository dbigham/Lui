package test.com.danielbigham.lui;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.grammarrule.GrammarRule;
import com.danielbigham.lui.loading.AntlrHelpers;
import com.danielbigham.lui.pattern.IPattern;

public class TestRuleExplosion
{
	private static final boolean debugFlag = true;
	
	@Test
	public void test1()
	{
		assertEquals(
				"<$webpage:2>: {<<spacex:0>> <reddit:1>}",
				explodeRulesAndCreateString("webpage: spacex reddit")
		);
	}
	
	// Multiple rules
	@Test
	public void test2()
	{
		assertEquals(
				"<$webpage:2>: {<<spacex:0>> <reddit:1>}\n" +
				// When exploding the rules, a symbol integer
				// gets allocated for "$1" as the LHS of the first
				// rule, resulting in 'woodstock' getting ID 3.
				"<$city:5>: {<<woodstock:3>> <ontario:4>}",
				explodeRulesAndCreateString(
					"webpage: spacex reddit\n" + 
					"city: woodstock ontario"
				)
		);
	}
	
	// OR sub-pattern
	@Test
	public void test3()
	{
		assertEquals(
				"<$1:4>: <spacex:0>|<spx:1>\n" +
				"<$webpage:3>: {<<$1:4>> <reddit:2>}",
				explodeRulesAndCreateString("webpage: spacex|spx reddit")
		);
	}

	// Pattern is just a literal. Whitebox test to ensure that we don't
	// choke on the fact that a pattern that is just a LHS can't support
	// a result symbol, and therefore, currently, must be wrapped in
	// a SequencePattern. (denoted by curly braces here)
	@Test
	public void test4()
	{
		assertEquals(
				"<$webpage:1>: {<<spacex:0>>}",
				explodeRulesAndCreateString("webpage: spacex")
		);
	}
	
	/**
	 * Parse and explode the given grammar rules, and return a string that
	 * contains the resulting patterns.
	 * 
	 * @param rules
	 *            grammar rules.
	 * 
	 * @return exploded patterns as string.
	 */
	public static String explodeRulesAndCreateString(String rules)
	{
		Grammar grammar = new Grammar();
		List<IPattern> patterns = explodeRules(grammar, rules);
		StringBuilder str = new StringBuilder(100);

		boolean first = true;
		for (IPattern pattern : patterns)
		{
			if (!first)
			{
				str.append("\n");
			}
			str.append(pattern.toString2(grammar));
			first = false;
		}
		
		if (debugFlag)
		{
			System.out.println(str.toString());
		}

		return str.toString();
	}

	/**
	 * Parse and explode the given grammar rules.
	 * 
	 * @param grammar		the grammar; 
	 * @param rules			grammar rules.
	 * 
	 * @return list of exploded patterns.
	 */
	public static List<IPattern> explodeRules(Grammar grammar, String rules)
	{
		List<GrammarRule> rules2 = parseGrammar(grammar, rules);
		return grammar.setGrammarRules(rules2);
	}

	/**
	 * Parses the given grammar rules.
	 * 
	 * @param grammarRules
	 *            the grammar rules.
	 * @return the parsed grammar rules.
	 */
	private static List<GrammarRule> parseGrammar(Grammar grammar,
			String grammarRules)
	{
		return AntlrHelpers.parseGrammar(grammar, grammarRules);
	}
}
