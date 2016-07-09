package test.com.danielbigham.lui;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.danielbigham.io.Out;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.grammarrule.GrammarRule;
import com.danielbigham.lui.loading.AntlrHelpers;
import com.danielbigham.lui.pattern.IPattern;

/**
 * See also: Rule Explosion.md
 * 
 * @author Daniel
 */
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
	
	// Two OR sub-patterns
	@Test
	public void test5()
	{
		assertEquals(
			"<$1:5>: <spacex:0>|<spx:1>\n" +
			"<$2:6>: <webpage:2>|<website:3>\n" +
			"<$webpage:4>: {<<$1:5>> <$2:6>}",
			explodeRulesAndCreateString("webpage: spacex|spx webpage|website")
		);
	}
	
	// OR containing sequence (doubly nested sub-patterns)
	@Test
	public void test6()
	{
		assertEquals(
			"<$1:5>: {<<web:2>> <page:3>}\n" +
			"<$2:6>: <webpage:1>|<$1:5>\n" +
			"<$webpage:4>: {<<spacex:0>> <$2:6>}",
			explodeRulesAndCreateString("webpage: spacex webpage|(web page)")
		);
	}
	
	// Grouped rules + double nesting
	@Test
	public void test7()
	{
		assertEquals(
			"<$1:6>: {<<web:2>> <page:3>}\n" +
			"<$2:7>: <webpage:1>|<$1:6>\n" +
			"<$webpage:4>: {<<spacex:0>> <$2:7>}\n" +
			"<$webpage:4>: {<<slashdot:5>>}",
			explodeRulesAndCreateString("webpage:\n\tspacex webpage|(web page)\n\tslashdot")
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
			Out.print(str.toString());
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
	 * @param grammarRules		the grammar rules.
	 * @return					the parsed grammar rules.
	 */
	private static List<GrammarRule> parseGrammar(Grammar grammar, String grammarRules)
	{
		return AntlrHelpers.parseGrammar(grammar, grammarRules);
	}
}
