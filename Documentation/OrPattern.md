# Or Pattern

## Design

- Rather than choosing one of the sub-patterns as a trigger, all of the sub-patterns act as triggers
- Grammar.setTriggers will need to be enhanced
- Prior to this change, it did the work of asking the pattern which of its sub-patterns
  was the rarest, and then it asked for that sub-pattern's token ID, and updated its
  internal trigger map with that new mapping:
  TokenID -> Pattern
- Now that patterns will be capable of having multiple triggers, we should add a new method:
  IPattern.getTriggeringTokenIds()
- In the case of OrPattern, it will return the token ID of all of its sub-patterns
- In the case of SequencePattern, it will internally do the work of determining its rarest
  sub-pattern and returning the token ID of that one.
- When an OrPattern is matched, it should set its matchComplete to true immediately.
  (Easy!)
- The Pattern.parse method should be enhanced to support apple|orange|banana
    - For now, it should just detect whether the pattern contains the vertical bar, and if so,
      it should parse the entire rule assuming that it's a single OR.