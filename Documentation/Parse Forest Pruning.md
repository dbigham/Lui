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
  {{symbol, start, end}, type, action, children}
- The 'type' is one of {E, D, T}
    - E: Top-level rule that returns an expression
    - D: Dynamically-generated rule that passes on bindings
    - T: Token
- 'children' is a list of items like this:
  {{symbol, start, end}, binding}
- Once this data gets back to WL, we want to put all of those top-level items in
  a lookup like this:
  lookupParseNodes[{symbol, start, end}]
  ... and get back a list. We can use GroupBy to do this.
- We then want to iterate over the spanning start rule matches and process
  them in a recursive manner.
- For each child key, we want to lookup the parse nodes and recurse on each of them.
- At the end of the recursion we find parse nodes that don't have any children.
- There are two cases here:
    1. Children keys that resulted from grammar rule explosion. (See: Rule Explosion.md)
        - For these, we don't want to evaluate their action.
        - Instead, we will return bindings, where bindings are a map from:
          symbol -> expression
    2. Top-level rules.
        - For these, we want to evaluate their action and
          return the result to the parent.
- I will call dynamic children keys D children and non-dynamic children keys E children.
- Regardless of whether a child key has a binding, we should process it.
    - If an E child, we need to be sure that not all downstream nodes evaluate
      to $Failed.
    - If a D child, we again need to make sure that not all downstream nodes
      evaluate to failed. Recall that a D child may eventually have E children,
      and those E children might all evaluate to false.
    - TODO: It might be a nice optimization at grammar build time to
      mark sub-patterns if all of the ways they can be produced are via
      tokens (and not via symbolic sub-parses). In that case, if we can
      assume that tokens are never $Failed (which we should be able to do),
      then any sub-pattern that doesn't have a binding isn't worth processing,
      because we know it doesn't evaluate to $Failed.
- One major difference between D and E children is that for E children, we
  don't pass on any of their inner binding values. We throw them away.
  But for D children, we do pass on those binding values. This is perhaps the
  most obvious ready why it's important that the nodes are labelled with their type.
- When we finish processing a node's children, then is a permutation step where
  we permute the various possibilities, and that happens differently depending
  on whether we are processing an E child or D child.
- ** We need more detail here, and perhaps even to cut down on some of the above detail
  so that things are more clear. I don't yet have this figured out in my head.


## Creating Grammars From WL

- At this point, we also need to be able to create a grammar from WL so that we have something
  to initiate a parse from. (CreateGrammar) This will return back a Grammar[...] object
  which will contain the Java Grammar object.