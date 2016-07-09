# Parse Forest Pruning

## Summary

- After the Java chart parser has finished, we have a set of spanning parses that have
  the start symbol.
- We want to send them back to WL, but we also need to send along any parts of the parse
  forest that are depended upon by the spanning parses.
- The WL code is responsible for transforming that parse forest into individual parse
  trees, applying symbol bindings as appropriate, and pruning away parse trees that
  involve failed branches.

## Design

- Thus, we need a recursive method to explore the parse forest, building up an expression
  to send back to Mathematica.
- At the end of the day, we want a list of items that look like this:
  {{symbol, start, end}, action, children}
- 'children' is a list of items like this:
  {{symbol, start, end}, binding}
- Once this data gets back to WL, we want to put all of those top-level items in
  a lookup like this:
  lookupParseNodes[{symbol, start, end}]
  ... and get back a list. We can use GroupBy to do this.
- processParseNode: We then want to iterate over the spanning start rule matches and process
  them in a recursive manner.
- For each child, we want to lookup the parse nodes and recurse on each of them.
- At the end of the recursion we find parse nodes that don't have any children.
- There are two cases here:
    1. Children that resulted from grammar rule explosion. (See: Rule Explosion.md)
        - For these, we don't want to evaluate their action.
        - Instead, we will return bindings, where bindings are a map from:
          symbol -> expression
    2. Top-level rules.
        - For these, we want to evaluate their action and
          return the result to the parent.
- Once a parent receives the result for each set of children, it can combine all permutations
  that don't involve $Failed. For children that passed back bindings instead of a result,
  we will do a Merge on the parent's bindings with the children's bindings, and then evaluate
  the parent's action. We end up with one or more evaluated expressions, which we pass back
  to the parent of this parent.

## Creating Grammars From WL

- At this point, we also need to be able to create a grammar from WL so that we have something
  to initiate a parse from. (CreateGrammar) This will return back a Grammar[...] object
  which will contain the Java Grammar object.