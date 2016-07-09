package com.danielbigham.lui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.danielbigham.lui.grammarrule.GrammarRule;
import com.danielbigham.lui.pattern.BasicPattern;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.Pattern;
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
	
	public Grammar()
	{
		triggers = new HashMap<Integer, List<IPattern>>();
		tokenIds = new HashMap<String, Integer>();
		tokenIdToSymbolOrLiteral = new HashMap<Integer, String>();
		dynamicRuleCounter = 0;
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
		
		// See also: Rule Explosion.md
		for (GrammarRule rule : rules)
		{
			rule.explode(this);
		}
		
		setTriggers(finalPatterns);
		
		List<IPattern> res = finalPatterns;
		finalPatterns = null;
		finalPatternsToResultSymbol = null;
		
		return res;
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
		return tokenIds.get(str);
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
			id = tokenIds.size();
			tokenIds.put(str, id);
			tokenIdToSymbolOrLiteral.put(id, str);
		}
		
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
}
