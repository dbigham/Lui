package com.danielbigham.lui.patternmatch;

/**
 * Wrap a pattern match so that we can associate a 'timestamp' with it.
 * 
 * We do this when storing partials in the chart so that we can avoid
 * triggering partials to be extended by tokens that were created
 * after the partial itself.
 * 
 * See: AvoidingUnnecessaryPartialExtension.md
 * 
 * @author Daniel
 */
public class PatternMatchWrapper
{
	public final IPatternMatch match;
	public final int valueOfIterationCounterWhenCreated;
	
	public PatternMatchWrapper(IPatternMatch match, int valueOfIterationCounterWhenCreated)
	{
		this.match = match;
		this.valueOfIterationCounterWhenCreated = valueOfIterationCounterWhenCreated;
	}
}
