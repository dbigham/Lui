package com.danielbigham.lui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The result of evaluating a pattern match.
 * 
 * @author Daniel
 */
public class EvaluationResult
{
	private final List<String> exprs;
	private final Map<String, Set<String>> variables;
	
	/**
	 * @param exprs			a list of one or more expressions.
	 * @param variables		bindings from variables to possible values.
	 */
	public EvaluationResult(List<String> exprs, Map<String, Set<String>> variables)
	{
		this.exprs = exprs;
		this.variables = variables;
	}
	
	/**
	 * @param exprs			a list of one or more expressions.
	 */
	public EvaluationResult(List<String> exprs)
	{
		this.exprs = exprs;
		this.variables = new HashMap<String, Set<String>>();
	}
	
	/**
	 * @param expr			the resultant expression.
	 */
	public EvaluationResult(String expr)
	{
		this.exprs = new ArrayList<String>();
		this.exprs.add(expr);
		this.variables = new HashMap<String, Set<String>>();
	}

	public List<String> getExprs()
	{
		return exprs;
	}

	public Map<String, Set<String>> getVariables()
	{
		return variables;
	}
	
	public String toString()
	{
		return "EvaluationResult[\n" + "    " + exprs + ",\n    " + variables + "\n]"; 
	}
	
	/**
	 * Populate the given variable with the values of this evaluation result.
	 * 
	 * @param variable	the variable.
	 */
	public void populateVariable(String variable)
	{
		if (exprs.size() > 0)
		{
			Set<String> values = variables.get(variable);
			if (values == null)
			{
				values = new HashSet<String>();
				variables.put(variable, values);
			}
			values.addAll(exprs);
		}
	}
}
