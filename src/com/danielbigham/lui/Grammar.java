package com.danielbigham.lui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.danielbigham.FilePositionSpan;
import com.danielbigham.io.Out;
import com.danielbigham.lui.grammarrule.GrammarRule;
import com.danielbigham.lui.loading.AntlrHelpers;
import com.danielbigham.lui.pattern.BasicPattern;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.Pattern;
import com.danielbigham.lui.pattern.SymbolPattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;

/**
 * The grammar, consisting of grammar rules that have been wired up to
 * 'triggers'. ie. One of their non-optional sub-patterns has been chosen
 * as that pattern's trigger. (see the 'triggers' map)
 * 
 * @author Daniel
 */
public class Grammar
{
	public final int UNKNOWN_TOKEN_ID = -2;
	
	private Map<Integer, List<IPattern>> triggers;
	
	// Keep track of the mapping from literals (ex. "the") and
	// grammar symbols (ex. "$city") to numeric equivalents.
	// We use the numeric equivalents during parsing since integer
	// operations are more efficient than string operations.
	private Map<String, Integer> tokenIds;
	private Map<Integer, String> tokenIdToSymbolOrLiteral;
	private int dynamicRuleCounter;
	
	// The following two are used during setPattern's many calls to pattern.explode, then then
	// cleared.
	
	// The final list of patterns after grammar explosion.
	private List<IPattern> finalPatterns;
	// Mapping from pattern+symbol -> grammar symbol integer
	// wrt generating dynamic rules during grammar explosion.
	// See also: Rule Explosion.md
	private Map<IPattern, Integer> finalPatternsToResultSymbol;
	
	private int tokenCounter;
	private int ruleCount;
	private boolean debugFlag;
	private static Set<String> symbolsSupportingDynamicRuleCreation;
	// Given a grammar symbol, is there a particular grammar file
	// and span within that file where we define linguistics for
	// objects of that type?
	private Map<String, FilePositionSpan> grammarSymbolFileSpan;
	// Given a grammar symbol and expression, is there an existing
	// file and position in that file where we define its linguistic?
	private Map<String, FilePositionSpan> objectFileSpan;
	
	static
	{
		symbolsSupportingDynamicRuleCreation = new HashSet<String>();
		symbolsSupportingDynamicRuleCreation.add("notebook");
		symbolsSupportingDynamicRuleCreation.add("sourceFile");
		symbolsSupportingDynamicRuleCreation.add("webpage");
		symbolsSupportingDynamicRuleCreation.add("directory");
		symbolsSupportingDynamicRuleCreation.add("sourceCodeDirectory");
		symbolsSupportingDynamicRuleCreation.add("file");
		symbolsSupportingDynamicRuleCreation.add("app");
	}

	private Tokenizer tokenizer;
	
	public Grammar()
	{
		init();
		
		tokenizer = new Tokenizer();
	}
	
	/**
	 * Construct a grammar from grammar rules.
	 * 
	 * @param grammarRules		the grammar rules.
	 */
	public Grammar(String grammarRules)
	{
		this(grammarRules, false);
		
	}
	
	public Grammar(String grammarRules, boolean debugFlag)
	{
		this();
		List<GrammarRule> rules = AntlrHelpers.parseGrammar(this, grammarRules);
		this.debugFlag = debugFlag;
		if (debugFlag)
		{
			for (GrammarRule rule : rules)
			{
				Out.print(rule.toString());
			}
			Out.line();
		}
		setGrammarRules(rules);
	}
	
	/**
	 * Add some rules to the grammar.
	 * 
	 * @param rules		The rules to add.
	 */
	public void addRules(List<GrammarRule> rules)
	{
		ruleCount += rules.size();
		
		// See also: Rule Explosion.md
		for (GrammarRule rule : rules)
		{
			rule.explode(this);
		}
	}
	
	/**
	 * Ones rules have been added, they are processed.
	 * 
	 * @return The resultant patterns.
	 */
	public List<IPattern> processRules()
	{
		// Ensure all of the grammar symbols used by regex parsers are defined.
		ChartParser.defineRegexParserSymbols(this);
		
		defaultBindings();
		
		if (debugFlag)
		{
			for (IPattern pattern : finalPatterns)
			{
				Out.print(pattern.toString2(this));
			}
			Out.line();
		}
		
		setTriggers(finalPatterns);
		
		List<IPattern> res = finalPatterns;
		// We won't clear this for now since it's so handy
		// for testing.
		//finalPatterns = null;
		finalPatternsToResultSymbol = null;
		
		return res;
	}

	/**
	 * Add default bindings to patterns so that for example:
	 * 
	 * start: go to $directory -> SystemOpen[directory]
	 * 
	 * ... works.
	 */
	private void defaultBindings()
	{
		for (IPattern pattern : finalPatterns)
		{
			defaultBindings(pattern);
		}
	}

	private void defaultBindings(IPattern pattern)
	{
		Set<String> userSpecifiedBindings = new HashSet<String>();
		for (IPattern subPattern : pattern.patterns())
		{
			if (subPattern.getBinding() != null)
			{
				userSpecifiedBindings.add(subPattern.getBinding());
			}
		}
		
		for (IPattern subPattern : pattern.patterns())
		{
			if (subPattern instanceof SymbolPattern &&
				subPattern.getBinding() == null &&
				!"D".equals(subPattern.getType())) {
				
				String symbolName = ((SymbolPattern)subPattern).symbolName();
				if (!userSpecifiedBindings.contains(symbolName))
				{
					subPattern.setBinding(symbolName);
				}
			}
		}
	}

	/**
	 * Set the grammar's patterns.
	 * 
	 * @param rules		the grammar rules.
	 * 
	 * @return			the final grammar rules, but only for testing purposes.
	 */
	public List<IPattern> setGrammarRules(List<GrammarRule> rules)
	{
		finalPatterns = new ArrayList<IPattern>();
		finalPatternsToResultSymbol = new HashMap<IPattern, Integer>();
		
		addRules(rules);
		
		return processRules();
	}
	
	/**
	 * Return the exploded rules as an array of strings. Handy for testing
	 * from WL.
	 */
	public String[] getRulesAsStrings()
	{
		String[] arr = new String[finalPatterns.size()];
		for (int i = 0; i < arr.length; ++i)
		{
			arr[i] = finalPatterns.get(i).toString2(this);
		}
		return arr;
	}
	
	/**
	 * Like setGrammarRules, but only really useful for unit tests.
	 * 
	 * @param patterns		the patterns.
	 */
	public void setPatterns(List<IPattern> patterns)
	{
		setGrammarRules(Pattern.toGrammarRules(patterns, this));
	}
	
	/**
	 * Accrue patterns produced by the pattern.explode process performed
	 * in the 'setPatterns' method.
	 * 
	 * See also: Rule Explosion.md
	 * 
	 * @param pattern		the pattern.
	 * @return				the grammar symbol produced by this pattern, possibly dynamically generated. 
	 */
	public int addFinalPattern(IPattern pattern)
	{
		Integer symbolTokenId;
		
		if (pattern.resultSymbol() == Pattern.NO_LHS)
		{
			// This is a sub-pattern, so we need to generate a
			// result symbol for it, unless we've already seen an
			// equivalent pattern.
			
			symbolTokenId = finalPatternsToResultSymbol.get(pattern);
			
			if (symbolTokenId == null)
			{
				// We need to assign a new dynamic grammar symbol to
				// this.
				++dynamicRuleCounter;
				String newSymbol = "$" + dynamicRuleCounter;
				symbolTokenId = getTokenIdAndDefineIfNecessary(newSymbol);
				finalPatterns.add(pattern);
			}
			else
			{
				// Otherwise, we don't update 'finalPatterns', because
				// we've already seen an equivalent pattern.
			}
			
			finalPatternsToResultSymbol.put(pattern, symbolTokenId);
		}
		else
		{
			// This is a top level rule, no need to generate
			// a new result symbol for it.
			symbolTokenId = pattern.resultSymbol();
			finalPatterns.add(pattern);
		}
		
		return symbolTokenId;
	}
	
	/**
	 * Based on the patterns that make up this grammar, choose
	 * for each pattern a sub-pattern that will act as its
	 * bottom-up trigger.
	 * 
	 * @param patterns		the patterns.
	 */
	public void setTriggers(List<IPattern> patterns)
	{
		Map<Integer, Integer> tokenCounts = countBasicPatternInstances(patterns);
		
		for(IPattern pattern : patterns)
		{
			List<Integer> triggerIndices = pattern.getTriggeringSubPatternIndices(tokenCounts);
			pattern.setTriggerIndices(triggerIndices);
			
			for (Integer subPatternIndex : triggerIndices)
			{
				BasicPattern patternThatTriggers =
						(BasicPattern) pattern.patterns().get(subPatternIndex);
				
				int tokenId = patternThatTriggers.getTokenId();
				
				List<IPattern> triggeredPatterns = triggers.get(tokenId);
				if (triggeredPatterns == null)
				{
					triggeredPatterns = new ArrayList<IPattern>();
					triggers.put(tokenId, triggeredPatterns);
				}
				triggeredPatterns.add(pattern);
			}
		}
	}
	
	/**
	 * Count the occurrence of each literal/symbol token in the grammar patterns.
	 * 
	 * @param patterns		the patterns.
	 * @return				a map from token ID to count.
	 */
	public static Map<Integer, Integer> countBasicPatternInstances(List<IPattern> patterns)
	{
		Map<Integer, Integer> tokenCounts = new HashMap<>();
		for(IPattern pattern : patterns)
		{
			List<IPattern> subPatterns = pattern.patterns();
			for(IPattern subPattern : subPatterns)
			{
				if (subPattern instanceof BasicPattern)
				{
					int tokenId = ((BasicPattern)subPattern).getTokenId();
					Integer count = tokenCounts.get(tokenId);
					if (count == null)
					{
						count = 1;
					}
					else
					{
						++count;
					}
					tokenCounts.put(tokenId,  count);
				}
			}
		}
		
		return tokenCounts;
	}
	
	/**
	 * Given a literal string from an input, returns the corresponding
	 * token ID integer. Returns null if there is no applicable token ID.
	 * 
	 * @param str		generally a word or character.
	 */
	public Integer getTokenId(String str)
	{
		Integer res = tokenIds.get(str);
		if (res == null)
		{
			return UNKNOWN_TOKEN_ID;
		}
		else
		{
			return res;
		}
	}
	
	/**
	 * Given a token ID, what was the corresponding symbol or literal?
	 * 
	 * @param tokenId		token ID.
	 */
	public String getSymbolOrLiteral(int tokenId)
	{
		return tokenIdToSymbolOrLiteral.get(tokenId);
	}
	
	/**
	 * Given a literal string from an input, returns the corresponding
	 * token ID integer. If there is no token ID for this literal string
	 * yet, then an ID is set aside for it and returned.
	 * 
	 * @param str		generally a word or character.
	 */
	public Integer getTokenIdAndDefineIfNecessary(String str)
	{
		Integer id = tokenIds.get(str);
		if (id == null)
		{
			id = tokenCounter;
			++tokenCounter;
			tokenIds.put(str, id);
			tokenIdToSymbolOrLiteral.put(id, str);
		}
	
		//Out.print(str + " -> " + id);
		return id;
	}
	
	/**
	 * The number of token IDs we've used.
	 */
	public int getNumTokenIds()
	{
		return tokenIds.size();
	}

	/**
	 * Given a token ID, return the patterns triggered.
	 * Returns null if no patterns are triggered.
	 * 
	 * Used by unit tests.
	 * 
	 * @param tokenId		the token ID acting as trigger.
	 * @param startPos		the trigger token's starting position in the input.
	 * @param endPos		the trigger token's ending position in the input.
	 */
	public List<IPatternMatch> getTriggeredPatterns(int tokenId, int startPos, int endPos)
	{
		List<IPattern> triggeredPatterns = triggers.get(tokenId);
		if (triggeredPatterns != null)
		{
			List<IPatternMatch> patternMatches = new ArrayList<IPatternMatch>(triggeredPatterns.size());
			for(IPattern pattern : triggeredPatterns)
			{
				patternMatches.add(pattern.toPatternMatch(tokenId, startPos, endPos));
			}
			return patternMatches;
		}
		else
		{
			return null;
		}
	}

	/**
	 * The number of rules in the grammar. (prior to rule explosion)
	 */
	public int getRuleCount()
	{
		return ruleCount;
	}

	public Tokenizer getTokenizer()
	{
		return tokenizer;
	}

	/**
	 * Initialize or reset a grammar.
	 */
	public void init()
	{
		triggers = new HashMap<Integer, List<IPattern>>();
		tokenIds = new HashMap<String, Integer>();
		tokenIdToSymbolOrLiteral = new HashMap<Integer, String>();
		tokenCounter = 0;
		dynamicRuleCounter = 0;
		finalPatterns = new ArrayList<IPattern>();
		finalPatternsToResultSymbol = new HashMap<IPattern, Integer>();
		grammarSymbolFileSpan = new HashMap<String, FilePositionSpan>();
		objectFileSpan = new HashMap<String, FilePositionSpan>();
		
		tokenIds.put("$start", ChartParser.START_SYMBOL);
		tokenIdToSymbolOrLiteral.put(ChartParser.START_SYMBOL, "$start");
	}
	
	/**
	 * Does the given symbol support the dynamic creation of new rules?
	 * (and/or the modification of existing ones?) ie. Updating the
	 * appropriate source file.
	 */
	public boolean symbolSupportsDynamicRuleCreation(String symbol)
	{
		return symbolsSupportingDynamicRuleCreation.contains(symbol);
	}
	
	/**
	 * For a given grammar symbol, record the file and the span in
	 * that file where linguistics for it are defined.
	 * 
	 * @param symbol	The grammar symbol.
	 * @param file		The file.
	 * @param start		The starting position in the file.
	 * @param end		The ending position in the file.
	 */
	public void setGrammarSymbolFileSpan(String symbol, String file, int start, int end)
	{
		FilePositionSpan fileSpan = new FilePositionSpan(file, start, end);
		grammarSymbolFileSpan.put(symbol, fileSpan);
		//Out.print("setGrammarSymbolFileSpan: " + symbol + ": " + fileSpan);
	}
	
	/**
	 * For a given object, record the file and the span in that file where
	 * linguistics for it are defined.
	 * 
	 * @param symbol		The grammar symbol.
	 * @param expression	The semantic expression.
	 * @param file			The file.
	 * @param start			The starting position in the file.
	 * @param end			The ending position in the file.
	 */
	public void setObjectFileSpan(
		String symbol, String expression, String file, int start, int end)
	{
		String key = objectFileSpanKey(symbol, expression);
		FilePositionSpan fileSpan = new FilePositionSpan(file, start, end);
		objectFileSpan.put(key, fileSpan);
		//Out.print("setObjectFileSpan: " + symbol + ", " + expression + ": " + fileSpan);
	}
	
	/**
	 * Create a hash key for an object. (grammar symbol + expression)
	 * Used by objectFileSpan.
	 * 
	 * @param symbol		The grammar symbol.
	 * @param expression	The semantic expression.
	 */
	private String objectFileSpanKey(String symbol, String expression)
	{
		return symbol + "::" + expression;
	}
	
	/**
	 * Sets the linguistic for a certain grammar symbol and expression.
	 * For example, the linguistics associated with a webpage.
	 * 
	 * @param symbol		The grammar symbol.
	 * @param expression	The semantic expression.
	 * @param linguistic	The linguistic.
	 * 
	 * @throws Exception
	 */
	public void setLinguistic(String symbol, String expression, String linguistic) throws Exception
	{
		symbol = symbol.trim();
		expression = expression.trim();
		
		//Out.print("setLinguistic: " + symbol + ", " + expression);
		
		String newRule = linguistic + " -> " + expression;
		
		if (!AntlrHelpers.isSimpleRule(newRule))
		{
			throw new Exception("Invalid rule: " + newRule);
		}
		
		String key = objectFileSpanKey(symbol, expression);
		FilePositionSpan fileSpan = objectFileSpan.get(key);
		if (fileSpan == null)
		{
			FilePositionSpan grammarSymbolSpan =
				grammarSymbolFileSpan.get(symbol);
			
			if (grammarSymbolSpan != null)
			{
				grammarSymbolSpan.replace(symbol + ":\n\t" + newRule, 1);
			}
			else
			{
				// We don't even have a section yet for this grammar
				// symbol.
				throw new Exception("No section yet defined for grammar symbol: " + symbol);
			}
		}
		else
		{
			//Out.print("  " + filePos);
			fileSpan.replace(newRule);
		}
	}
	
	/**
	 * Gets the linguistic for a certain grammar symbol and expression.
	 * For example, the linguistics associated with a webpage.
	 * 
	 * @param symbol		The grammar symbol.
	 * @param expression	The semantic expression.
	 * 
	 * @throws Exception
	 */
	public String getLinguistic(String symbol, String expression) throws Exception
	{
		symbol = symbol.trim();
		expression = expression.trim();
				
		String key = objectFileSpanKey(symbol, expression);
		FilePositionSpan fileSpan = objectFileSpan.get(key);
		if (fileSpan != null)
		{
			return fileSpan.getText().trim();
		}
		else
		{
			return null;
		}
	}
}
