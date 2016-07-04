package com.danielbigham.lui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.danielbigham.lui.pattern.BasicPattern;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public class Grammar
{
	private Map<Integer, List<IPattern>> triggers;
	private Map<String, Integer> tokenIds;
	
	public Grammar()
	{
		triggers = new HashMap<Integer, List<IPattern>>();
		tokenIds = new HashMap<String, Integer>();
	}
	
	/**
	 * Set the grammar's patterns.
	 * 
	 * @param patterns		the patterns.
	 */
	public void setPatterns(List<IPattern> patterns)
	{
		setTriggers(patterns);
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
			int indexOfRarestToken = pattern.getIndexOfRarestSubPattern(tokenCounts);
			
			pattern.setTriggerIndex(indexOfRarestToken);
			
			BasicPattern patternThatTriggers =
					(BasicPattern) pattern.patterns().get(indexOfRarestToken);
			
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
				patternMatches.add(pattern.toPatternMatch(startPos, endPos));
			}
			return patternMatches;
		}
		else
		{
			return null;
		}
	}
}
