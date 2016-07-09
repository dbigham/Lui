# Grammar Rule Symbolic Bindings

## Summary

- Any grammar rule can optionally make use of symbolic bindings on its rule parts
- ex. expr: a:integer b:integer -> a + b
- Those bindings are first parsed by ANTLR
- They are then added to the IPattern via setBinding. We set bindings on individual patterns.
- If a pattern doesn't have a binding, then the binding is null