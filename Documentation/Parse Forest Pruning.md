# Parse Forest Pruning

## Summary

- After the Java chart parser has finished, we have a set of spanning parses that have
  the start symbol.
- We want to send them back to WL, but we also need to send along any parts of the parse
  forest that are depended upon by the spanning parses.
- The WL code is responsible for transforming that parse forest into individual parse
  trees, applying symbol bindings as appropriate, and pruning away parse trees that
  involve failed branches.

## Design: Part 1

- Thus, we need a recursive method to explore the parse forest, building up an expression
  to send back to Wolfram Language.
- At the end of the day, we want a list of items that look like this:
  {{symbol, start, end}, type, action, children}
- Once this data gets back to WL, we want to put all of those top-level items in
  a lookup like this:
  lookupParseNodes[{symbol, start, end}]
  ... and get back a list. We can use GroupBy to do this.
- We then want to iterate over the spanning start rule matches and process
  them in a recursive manner.

## Design: Part 2

### Nodes

- Each item in the list returned to WL we call a "node". Nodes look like this:

	{{symbol, start, end}, type, action, children}

- However, there may be multiple nodes with the same {symbol, start, end}.

- A node corresponds with an IPattern object in Java.

- The 'type' is one of {E, D, T}
    - E: Top-level rule that returns an expression
    - D: Dynamically-generated rule that passes on bindings
    - T: Token

- The function 'handleNode' is used to recursively process a node and its children.

### Children

- Every node has zero or more children.

- Each child corresponds with a "branch" of the parse forest, where that branch will correspond
  with one or more nodes. A child looks like this:

	{{symbol, start, end}, binding}

- Given the {symbol, start, end} of a child, 'lookupParseNodes' can be used to find the
  corresponding nodes.

- The function 'handleChildren' is used to recursively handle a node's children and their
  respective nodes.

- The function 'handleChild' is used to recursively handle a child and its nodes.

- The function 'handleNodes' is used to recursively handle the nodes that pertain to a
  single child, and their children.

## Creating Grammars From WL

- At this point, we also need to be able to create a grammar from WL so that we have something
  to initiate a parse from. (CreateGrammar) This will return back a Grammar[...] object
  which will contain the Java Grammar object.