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
	private static final boolean debugFlag = false;
	
	@Test
	public void test1()
	{
		assertEquals(
			"$webpage: {<spacex> reddit}",
			explodeRulesAndCreateString("webpage: spacex reddit")
		);
	}
	
	// Multiple rules
	@Test
	public void test2()
	{
		assertEquals(
			"$webpage: {<spacex> reddit}\n" +
			// When exploding the rules, a symbol integer
			// gets allocated for "$1" as the LHS of the first
			// rule, resulting in 'woodstock' getting ID 3.
			"$city: {<woodstock> ontario}",
			explodeRulesAndCreateString(
				"webpage: spacex reddit\n" + 
				"city: woodstock ontario"
			)
		);
	}
	
	// OR sub-pattern
	// We also ensure here that bindings on exploded sub-patterns get
	// transfered onto the dynamically created sub-pattern that replaced
	// them.
	@Test
	public void test3()
	{
		assertEquals(
			"$1: (spacex|spx)\n" +
			"$webpage: {<a=$1> b=reddit}",
			explodeRulesAndCreateString("webpage: a=(spacex|spx) b=reddit")
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
			"$webpage: {<spacex>}",
			explodeRulesAndCreateString("webpage: spacex")
		);
	}
	
	// Two OR sub-patterns
	@Test
	public void test5()
	{
		assertEquals(
			"$1: (spacex|spx)\n" +
			"$2: (webpage|website)\n" +
			"$webpage: {<$1> $2}",
			explodeRulesAndCreateString("webpage: (spacex|spx) (webpage|website)")
		);
	}
	
	// OR containing sequence (doubly nested sub-patterns)
	@Test
	public void test6()
	{
		assertEquals(
			"$1: {<web> page}\n" +
			"$2: (webpage|$1)\n" +
			"$webpage: {<spacex> $2}",
			explodeRulesAndCreateString("webpage: spacex (webpage|(web page))")
		);
	}
	
	// Grouped rules + double nesting
	@Test
	public void test7()
	{
		assertEquals(
			"$1: {<web> page}\n" +
			"$2: (webpage|$1)\n" +
			"$webpage: {<spacex> $2}\n" +
			"$webpage: {<slashdot>}",
			explodeRulesAndCreateString("webpage:\n\tspacex (webpage|(web page))\n\tslashdot")
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
