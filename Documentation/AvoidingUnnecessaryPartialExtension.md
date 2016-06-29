# Avoiding Unnecessary Partial Extension

## Problem

Consider the grammar:

$start -> just $symbol $symbol
$symbol -> testing

And the input:

just testing testing

Now consider the following debug output: (especially the last line)

Triggered: {.<just:0>.<$symbol:1><$symbol:1>}
{.<just:0>.<$symbol:1><$symbol:1>} -> Partials
  Start: 1
  Symbol: 1
Triggered: {.<testing:2>.}
New result might trigger partials: {.<testing:2>.}
Triggered: {.<testing:2>.}
New result might trigger partials: {.<testing:2>.}
Continue partial right: {.<just:0>.<$symbol:1><$symbol:1>}
{.<just:0><$symbol:1>.<$symbol:1>} -> Partials
  Start: 2
  Symbol: 1
**Continue partial right: {.<just:0><$symbol:1>.<$symbol:1>}**

(this is taken from 'test6' from TestChartParser.java)

Notice that we continue the partial {.<just:0><$symbol:1>.<$symbol:1>}. But if you think
about it, you should realize that there was no need to continue that partial, because
at the time the partial was created, the token being used to extended *already existed*, and
that's precisely why we were able to continue the other partial and completely match it.

## Solution

I wish I had a more elegant solution, but for now:

- When adding things to the partials chart, wrap them with PatternMatchWrapper
    - Assign the wrapper a 'iterationCount' integer that records the value of a counter to indicate when the partial was created
- When considering whether to continue a partial, only do so if its 'iterationCount' indicates that it was created before the triggering token was created
    - How to tell whether the partial pre-existed the triggering token?
    - Each time we make a new match and add it to the 'toTriggerPartials' list, we increment the iterationCount.
    - We assign that iterationCount to the partial wrapper.
    - When we finish processing the current items in toTrigger, we move on to process the partials.
    - If a partial being triggered has a value of iterationCount that is <= to the value of iterationCount that the triggering match has, that implies that the triggering match existing prior to the partial being created, and thus it should not be allowed to extend the partial.