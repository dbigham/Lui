# ANTLR

## Summary

ANTLR is used to parse *.grammar files.

This file will serve as a place to take notes about ANLTR.

## Notes

- A rule has a name, followed by a colon, followed by alternatives, followed by a semi-colon
    - ie. name : ... | ... | ... ;
    - Rule names must start with lower case
- Rule elements can be either
    - Literals. ex. 'literal'
    - Grammar symbol. ex. otherSymbol
    - Tokens. ex. TOKEN (from the lexer)
- If your grammar should match an entire file, you can use the EOF token
- To match zero or more elements:
  file : element* EOF;
- To match one or more elments:
  file : element+ EOF;
- Rule elements are implicitly named, but can be explicitly named like this: name : ...
- The action is { ... }. Each alternative can have its own action.
    - You can think of an action like generated Java code
    - Refer to bound rule elements with the $
- A grammar gets turned into Java classes
    - Each rule corresponds to a generated class
    - The class name for a rule 'item' is ItemContext
    - Rule elements get turned into fields
- How to use a generated parser:
  https://github.com/antlr/antlr4/blob/master/doc/listeners.md
- Eclipse plugin:
  https://github.com/jknack/antlr4ide/blob/master/README.md
    - Eclipse -> Help -> Eclipse Marketplace...
    - Search for 'antlr'
    - Choose 'ANTLR 4 IDE' and click 'Install'
    - XText
        - http://www.eclipse.org/downloads/download.php?file=/modeling/tmf/xtext/downloads/drops/2.7.3/R201411190455/tmf-xtext-Update-2.7.3.zip
   	    - Eclipse -> Help -> Install New Software...
   	    - Add -> Archive -> Select downloaded file
   	    - Lui/Downloads/ zip file

## Problems

- 'lhs' doesn't seem to work if I use lhs:ID;, but it does work if
  I use lhs:WORD;
  http://stackoverflow.com/questions/38156574/simple-grammar-fails-to-parse

- I seem to be having problems with my grammar and I'm suspicious
  that the lexer is "stupid" -- that it isn't capable of creating
  "token stacks" and might be creating the wrong tokens, causing
  the parser to fail.

## Questions

- ...