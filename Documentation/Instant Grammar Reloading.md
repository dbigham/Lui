# Instant Grammar Reloading

## Summary

Software systems that allow a user to edit configuration and have those changes
reload automatically, and taking < 1 second to reload, allow for rapid iterative
improvement.

The goal here is to allow a set of grammar files to be loaded, and to provide
a 'reload' method that will intelligently determine which files have changed -- then
reloading only those files, and further determining within those files which
rules were removed and while rules were added. (where a modified rule can be
considered both a removal and an addition)

## Design

- When reading a grammar file, we need to maintain, for that grammar file,
  a Set<GrammarRule>, where that set makes use of the GrammarRule's hash code.
  
- GrammarRule needs to implement its hashCode and equals methods.

- Upon reloading a grammar file, we start by parsing each of its rules and forming
  a new Set<GrammarRule>. We then compare it to the old Set<GrammarRule> for that
  file to determine what rules have been added, and what rules removed.
 
- For each added rule, we simply add it to the Grammar object's trigger lookup.

- For each removed rule, we remove it from the Grammar object's trigger lookup.

## How to tell when a file has been modified?

- The simplest approach is to record the modification timestamp of each
  file and then iterate over the files later to see which ones have a
  newer timestamp.
  
- The downside there is that if your grammar has hundreds or thousands
  of files, this isn't scalable.

- The "right" way to do it in Java:
  See: https://docs.oracle.com/javase/tutorial/essential/io/notification.html
  
- This has been implemented in the class FileLoaderAndReloader, which is used
  in conjunction with the class GrammarFiles.

  
## Todo

- Code to parse a file into a list of GrammarRule objects
- BUG: When I modify a file in Workbench, it seems to trigger the modification event 3 times.
- etc.