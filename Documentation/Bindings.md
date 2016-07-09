# Grammar Rule Symbolic Bindings

## Summary

- Any grammar rule can optionally make use of symbolic bindings on its rule parts
- ex. expr: a:integer b:integer -> a + b
- Those bindings are first parsed by ANTLR
- They are then added to the IPattern as an array of strings
- The size of that array is equivalent to the size of the sub-pattern array
- If a sub-pattern doesn't have a binding, then that element is null in the bindings array