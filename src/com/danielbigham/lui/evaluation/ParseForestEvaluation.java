package com.danielbigham.lui.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.danielbigham.lui.EvaluationResult;
import com.danielbigham.lui.ParserState;
import com.danielbigham.lui.patternmatch.IPatternMatch;

public class ParseForestEvaluation
{
	/**
	 * Given the parser state resulting from a parse, return the parsed expression.
	 * 
	 * - For now we do this in a hacky way since we can't really evaluate things,
	 *   but we can try to substitute variable values, etc.
	 *   
	 * - If there are multiple parsed expressions, we currently favor the
	 *   first one.
	 * 
	 * @param state		the parser state.
	 * 
	 * @return			the parsed expression, or null if none.
	 */
	public static String evaluate(ParserState state)
	{
		List<IPatternMatch> results = state.getSpanningStartResults();
		
		if (results != null)
		{
			IPatternMatch match = results.get(0);
			// TODO
			//return match.pattern().getAction();
			EvaluationResult res = match.evaluate(state);
			
			if (res.getExprs().size() > 0)
			{
				// For now just return the first result.
				String expr = res.getExprs().get(0);
				return cleanUpExpr(expr);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Clean up the expression by removing things like HoldComplete that aren't
	 * helpful outside of a WolframLanguage environment.
	 * 
	 * @param expr		the expression.
	 * 
	 * @return			the cleaned up expression.
	 */
	private static String cleanUpExpr(String expr)
	{
		if (expr.startsWith("HoldComplete["))
		{
			return expr.substring(13, expr.length() - 1);
		}
		else
		{
			return expr;
		}
	}
	
	enum CharType
	{
		LETTER,
		DIGIT,
		OTHER
	};
	
	enum VarSubState
	{
		START,
		ID,
		DIGITS
	};

	public static String substituteVariables(String action,
			Map<String, String> variables)
	{
		final boolean debugFlag = false;
		
		StringBuilder str = new StringBuilder(action.length());
		StringBuilder item = new StringBuilder(20);
		
		VarSubState state = VarSubState.START;
		
		for (int i = 0; i < action.length(); ++i)
		{
			char c = action.charAt(i);
			CharType charType;
			if (Character.isLetter(c))
			{
				charType = CharType.LETTER;
			}
			else if (Character.isDigit(c))
			{
				charType = CharType.DIGIT;
			}
			else
			{
				charType = CharType.OTHER;
			}
			
			if (debugFlag)
			{
				System.out.println(c + ":" + charType + ":" + state);
			}
			
			if (state == VarSubState.START)
			{
				if (charType == CharType.LETTER)
				{
					state = VarSubState.ID;
					item.append(c);
				}
				else if (charType == CharType.DIGIT)
				{
					state = VarSubState.DIGITS;
					str.append(c);
				}
				else
				{
					str.append(c);
				}
			}
			else if (state == VarSubState.ID)
			{
				if (charType == CharType.LETTER)
				{
					item.append(c);
				}
				else if (charType == CharType.DIGIT)
				{
					state = VarSubState.ID;
					item.append(c);
				}
				else if (charType == CharType.OTHER)
				{
					// Found ID
					String variable = item.toString();
					if (variables.containsKey(variable))
					{
						if (debugFlag)
						{
							System.out.println("  ID: " + variable + " -> " + variables.get(variable));
						}
						str.append(variables.get(variable));
					}
					else
					{
						if (debugFlag)
						{
							System.out.println("  ID: " + variable);
						}
						str.append(item);
					}
					item = new StringBuilder(20);
					str.append(c);
					state = VarSubState.START;
				}
				else
				{
					throw new IllegalArgumentException("Unexpected char type: " + charType);
				}
			}
			else if (state == VarSubState.DIGITS)
			{
				if (charType == CharType.OTHER)
				{
					state = VarSubState.START;
				}
				
				str.append(c);
			}
		}
		
		if (state == VarSubState.ID)
		{
			// Found ID
			String variable = item.toString();
			if (variables.containsKey(variable))
			{
				if (debugFlag)
				{
					System.out.println("  ID: " + variable + " -> " + variables.get(variable));
				}
				str.append(variables.get(variable));
			}
			else
			{
				if (debugFlag)
				{
					System.out.println("  ID: " + variable);
				}
				str.append(item);
			}
		}
		
		return str.toString();
	}
	
	/**
	 * Given a mapping from variables to possible values, flatten the map
	 * into a list of maps where each map only has one possible value for
	 * each variable.
	 * 
	 * @param variableValues	mapping from variables to possible values.
	 * @return					list of mappings from variables to possible values.
	 */
	public static List<Map<String, String>> flattenVariables(Map<String, Set<String>> variableValues)
	{
		List<Map<String, String>> res = new ArrayList<Map<String, String>>();
		
		Set<String> variables = variableValues.keySet();
		for (String variable : variables)
		{
			List<Map<String, String>> resCopy = new ArrayList<Map<String, String>>();
			resCopy.addAll(res);
			
			res.clear();
			
			Set<String> values = variableValues.get(variable);
			for (String value : values)
			{
				List<Map<String, String>> resCopy2 = new ArrayList<Map<String, String>>();
				resCopy2.addAll(resCopy);
				
				if (resCopy2.size() == 0)
				{
					Map<String, String> item = new HashMap<String, String>();
					item.put(variable, value);
					resCopy2.add(item);
				}
				else
				{
					for (Map<String, String> item : resCopy2)
					{
						item.put(variable, value);
					}
				}
				
				res.addAll(resCopy2);
			}
		}
		
		return res;
	}
}
