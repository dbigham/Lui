package com.danielbigham.lui.patternmatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.danielbigham.lui.Chart;
import com.danielbigham.lui.EvaluationResult;
import com.danielbigham.lui.Grammar;
import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.evaluation.ParseForestEvaluation;
import com.danielbigham.lui.pattern.BasicPattern;
import com.danielbigham.lui.pattern.IPattern;
import com.danielbigham.lui.pattern.SymbolPattern;

/**
 * Represents an active attempt to match a particular pattern
 * on a particular input.
 * 
 * @author Daniel
 */
public abstract class PatternMatch implements IPatternMatch
{
	protected IPattern pattern;
	protected boolean matchComplete;
	protected int startPos;
	protected int endPos;
	
	public int startPos()
	{
		return startPos;
	}

	public int endPos()
	{
		return endPos;
	}
	
	public void extendMatchAsFarAsPossible(ParserState state)
	{
		List<IPatternMatch> extendedMatches;
		if (!matchComplete)
		{
			extendedMatches = extendMatch(state, null);
			if (extendedMatches != null)
			{
				for (IPatternMatch match : extendedMatches)
				{
					if (match.isMatchComplete())
					{
						state.matchCompleted(match, state);
					}
				}
				
				for (IPatternMatch match : extendedMatches)
				{
					// Continue extending the matches as far as possible.
					match.extendMatchAsFarAsPossible(state);
				}
			}
		}
	}
	
	@Override
	public void extendMatchAsFarAsPossibleUsing(ParserState state, int dir, IPatternMatch nextMatch)
	{
		Set<Integer> extensionPositions = new HashSet<Integer>(1);
		if (dir == 1)
		{
			extensionPositions.add(nextMatch.endPos());
		}
		else
		{
			extensionPositions.add(nextMatch.startPos());
		}
		
		List<IPatternMatch> newMatches = extendMatch(state, extensionPositions);
		
		for (IPatternMatch newMatch : newMatches)
		{
			// Continue extending the matches as far as possible.
			newMatch.extendMatchAsFarAsPossible(state);
			
			if (newMatch.isMatchComplete())
			{
				state.matchCompleted(newMatch, state);
			}
		}
	}
	
	public IPattern pattern()
	{
		return pattern;
	}

	public boolean isMatchComplete()
	{
		return matchComplete;
	}
	
	public IPatternMatch resultToSymbolPattern()
	{
		return new SymbolPattern(pattern.resultSymbol(), startPos, endPos);
	}
	
	public String toString(Grammar grammar)
	{
		String resultSymbol = grammar.getSymbolOrLiteral(pattern.resultSymbol());
		return resultSymbol + ": " + this.toString();
	}
	
	
	public void toWL(StringBuilder wl, ParserState state)
	{
		//Out.print(startPos + "-" + endPos + ": " + pattern.toString2(state.grammar()));
		
		wl.append("{{");
		wl.append(pattern.resultSymbol()).append(",");
		wl.append(startPos).append(",");
		wl.append(endPos).append("},\"");
		wl.append(pattern.getType()).append("\",");
		wl.append("HoldComplete[");
		String action = pattern.getAction();
		
		String dynamicBinding = null;
		
		if (action == null && this instanceof OrPatternMatch)
		{
			// This is an OR sub-pattern. Set it's 'action' to the semantic expression
			// of the alternative that did match.
			action = getMatchedSubPatterns().get(0).getBinding();
			if (action == null) {
				dynamicBinding = action = "auto";
			}
		}
		
		wl.append(action == null ? "Null" : action).append("],");

		// Children
		int[] subMatchPos = subPatternStartPositions();
		int i = 0;
		int subMatchStartPos;
		int subMatchEndPos;
		Chart chart = state.chart();
		wl.append("{");
		for (IPattern subPattern : getMatchedSubPatterns())
		{
			subMatchStartPos = subMatchPos[i];
			subMatchEndPos = subMatchPos[i+1] - 1;
			
			wl.append("{{");
			wl.append(subPattern.resultSymbol()).append(",");
			wl.append(subMatchStartPos).append(",");
			wl.append(subMatchEndPos).append("},\"");
			wl.append(subPattern.getType()).append("\",");
			String binding = subPattern.getBinding();
			if (binding == null && dynamicBinding != null)
			{
				binding = dynamicBinding;
			}
			if (binding == null)
			{
				wl.append("Null");
			}
			else
			{
				wl.append("HoldComplete[").append(binding).append("]");
			}
			wl.append("}");
			
			if (i < subMatchPos.length - 2)
			{
				wl.append(",");
			}
			
			++i;
		}
		wl.append("}");
		
		wl.append("},");
		
		// Recurse on children
		i = 0;
		for (IPattern subPattern : getMatchedSubPatterns())
		{
			subMatchStartPos = subMatchPos[i];
			subMatchEndPos = subMatchPos[i+1] - 1;
			
			List<IPatternMatch> subPatternMatches =
					chart.getMatchesForSpan(subPattern.resultSymbol(), subMatchStartPos, subMatchEndPos);
			
			//Out.print("    Sub-pattern: " + startPos + "-" + endPos + ":" + subPattern + ":");
			//Out.print("        Chart matches: " +  subPatternMatches);
			
			if (subPatternMatches != null)
			{
				for (IPatternMatch subMatch : subPatternMatches)
				{
					subMatch.toWL(wl, state);
				}
			}
			
			++i;
		}
	}
	
	public void setStartEnd(int newStart, int newEnd)
	{
		this.startPos = newStart;
		this.endPos = newEnd;
	}
	

	@Override
	public EvaluationResult evaluate(ParserState state)
	{
		Map<String, Set<String>> variables;
		List<Map<String, Set<String>>> variableSets = new ArrayList<Map<String, Set<String>>>();
		
		int[] subMatchPos = subPatternStartPositions();
		int i = 0;
		for (IPattern subPattern : getMatchedSubPatterns())
		{
			if (subPattern instanceof BasicPattern)
			{
				int subMatchStartPos = subMatchPos[i];
				int subMatchEndPos = subMatchPos[i+1] - 1;
				
				EvaluationResult res =
						((BasicPattern)subPattern).evaluate(state, subMatchStartPos, subMatchEndPos);
				
				if (res != null)
				{
					if (!"E".equals(subPattern.getType()))
					{
						variableSets.add(res.getVariables());
					}
				}
			}
			else
			{
				throw new UnsupportedOperationException("Sequence patterns expected to have basic sub-patterns: " + toString());
			}
			
			++i;
		}
		
		List<String> exprs = new ArrayList<String>();
		
		if (variableSets.size() > 0)
		{
			variables = ParserState.combineVariableMaps(variableSets);
		}
		else
		{
			variables = new HashMap<String, Set<String>>();
		}
		
		if ("D".equals(pattern.getType()))
		{
			return new EvaluationResult(exprs, variables);
		}
		else
		{
			String action = pattern.getAction();
			//System.out.println("Variable substitution:");
			//System.out.println("  " + action);
			//System.out.println("  " + variables);
			List<Map<String, String>> flattenedVariableSets =
					ParseForestEvaluation.flattenVariables(variables);
			if (flattenedVariableSets.size() == 0)
			{
				exprs.add(action);
			}
			else
			{
				for (Map<String, String> variableSet : flattenedVariableSets)
				{
					action = ParseForestEvaluation.substituteVariables(action, variableSet);
					exprs.add(action);
				}
			}
			return new EvaluationResult(exprs);
		}
	}
}
