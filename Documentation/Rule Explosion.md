# Rule Explosion

## Summary

- Our chart parser explodes nested rules into primitive rules.
- ie. Every SequencePattern only have LitterlPattern or SymbolPattern as children, etc.
- We thus introduce dynamically generated grammar symbols like $1, $2, etc.

## Design

- Given a pattern, we want to be able to explode it.
- Add a .explode(...) method to IPattern.
- This method needs to accept a Grammar as an argument so that it can introduce new
  grammar symbols as necessary.
- Thus Grammar will now need a dynamicRuleCounter
- Grammar will also need to keep a mapping: patternHash -> symbol
  ... so that we don't introduce a new symbol if we already have one for a given primitive
  pattern.
- This implies that we'll now need to implement a proper hash function for patterns.
- .explode will be a recursive method
- It will iterate over every sub-pattern
    - If a given sub-pattern is 'basic', it can stay.
    - Otherwise, we call explode on that pattern, and explode returns to us a new basic
      pattern that can be used in its place.
    - Explode is thus responsible, once all of its sub-patterns are basic, to do the work
      of looking to see whether we already have a dynamic symbol for it, and if not, to
      generate a new dynamic symbol.
    - Each time the explode method is about to return, if it has generated a never-before-seen
      pattern, it adds that pattern to Grammar's global list of patterns.
    - explode will be called from Grammar.setPatterns prior to it passing the patterns on to
      setTriggers.
- At the end of this process, one is left a now expanded list of patterns, and the process
  resumes as before -- setTriggers wires up the triggers, and the chart parser is ready
  for action.

## Questions

- But grammar rules also have actions. How do you maintain the link between
  a pattern and its action, especially since one pattern, if it occurs multiple
  times in a grammar, will now map to multiple actions? (and binding?)
  - Answer: Firstly, remember that sub-patterns don't have actions, so this
    is only an issue for top-level rules.
  - The answer depends on whether you allow a combined rule to produce more
    than one grammar symbol. If so, then yes, you need to also store a 
    List<Action>, where an Action contains both its action as well as the
    bindings array.
  - But for now, to keep things simple, I'd prefer IPattern to only produce
    a single result symbol. And if so, then the only time you can get
    duplicate top-level patterns is if you have multiple rules with the
    same pattern AND the same result symbol. And at the moment I can't think
    of an example of when you'd want to do that, so we should probably just
    detect that situation and issue an exception.

- But how do the bindings of an exploded sub-rule end up getting mapped
  back to the top-level action?
  - Answer: Each sub-rule tracks its bindings as usual -- an array with
    one item per sub-pattern.
  - When the parse trees are being formed, a sub-pattern passes on its
    bindings like (ex. {a, Null, b, Null, Null}) to its parent.
  - But top-level rules, when they are matched, obviously do not pass
    their bindings on to the higher node of the parse tree.
  - A parent pattern essentially merges the Association (key/value map)
    of its bindings with the bindings of its sub-rules.
   
- And how does that work if you have multiple instances of a sub-pattern that get combined?
  - Answer: That does get tricky. The easiest thing to do is to only combine
    sub-patterns into a single pattern if their bindings match. ie. The has code of
    a pattern should also include its bindings array.
  - A more advanced approach would be to have not a single bindings array for a
    pattern but rather a map <parent pattern> -> <bindings array>, so that the bindings
    array used depends on the parent pattern that was matched. At this point, that
    sounds too complicated for too little gain, so I won't explore it further.