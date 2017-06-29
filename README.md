# LUI (Linguistic User Interface) 

## Summary

LUI implements a parser for a Context Free Grammar (CFG).  While CFGs have been around for a long time (Chomsky formalized them in the 1950s), they remain a very powerful way to create linguistic UIs.

When paired with the Wolfram Language, we can use CFGs to associate linguistics with snippets of code that we want to run.

When LUI is hooked up to a hotkey on your keyboard (such as Ctrl-Q), you can be in any application, hit a hotkey, type an intent, and have some code execute. This is an immensely powerful ability, and can be used in many different ways such as:

* Associating linguistics with documents/notebooks (such as having one notebook per concept/term you learn, one notebook per frequent person in your life, notebooks for your lists, notebooks for your projects, subprojects, and tasks, etc, etc.)
* Associating linguistics with programs on your computer
* Associating linguistics with "scripts" you write
* Associating linguistics with webpages
* Associating linguistics with directories or files
* ```search for 'abc' in <dir>```
* ```new <file alias> func AddNumbers[a, b] "Adds two numbers."```
* ```run unit tests```
* etc, etc.

## Loading

```
Get["Lui`"]
```

## Using

To display the LUI input box:

```
Lui[]
```

## About CFGs

CFGs are essentially regular expressions that have been extended to allow you to create named "subroutines".  For example, rather than writing the following two 'rules':

    email (daniel | meredith | eli | hazel)
    phone (daniel | meredith | eli | hazel)

We can instead write:

    email $person
    phone $person
    $person -> daniel | meredith | eli | hazel

Just as writers of programming languages write grammars with "actions" that form an "abstract syntax tree", we can write actions for our grammar rules:

    email $person -> ComposeEmail[person]

## Grammar Rule Syntax

### Simple Rules

```
myGrammarSymbol: my linguistic -> MyAction[]
```

### Grouping by Grammar Symbol

    start:
        my rule -> MyAction1[]
        my rule 2 -> MyAction2[]

Note that the `start` symbol means that it is a "top level" grammar rule instead of being akin to a "subroutine".

### Alternatives

    one | two | three

### Grouping with Parens

    (one|two|three) (four|five|six)

### Pattern Bindings

    email p=$person -> ComposeEmail[p]
    
    (* Default pattern binding *)
    email $person -> ComposeEmail[person]

## Grammar Directory

By default, LUI will look in the `Grammar` subdirectory of `Lui` for grammar rules.

You can override this by setting `Lui`Parse`$GrammarDirectory`.  You may want to copy the default grammar files into your directory, and you can then customize them. Restart your kernel after setting `Lui`Parse`$GrammarDirectory`, then ```Get["Lui`"]```.

## Grammar Files

By default there are files such as `Directory.grammar`, `SourceFile.grammar`, `Webpage.grammar`, etc.

You can customize these to point to your directories, your source files, your webpages, etc.

There is also a way to call LUI via HTTP to tell it to associate a linguistic with something, allowing you to use AutoHotKey (etc.) to for example add a linguistic to the webpage you are currently viewing, etc, etc.

Have a look in `Main.grammar` to see the top level rules that come by default, and how they interact with the above grammar files.

When you modify the grammar files, Lui will be watching and reload them automatically.

## Hotkey

As mentioned, LUI becomes much more useful if you can associate a hotkey (ex. Ctrl-Q / Command-Q) to bring up the LUI prompt.

Example AutoHotKey script that opens / shows a Mathematica notebook named LuiUI.nb:

    ^q::
        FocusLUI()
    Return
    
    FocusLUI(Click:=true)
    {
        ;; TODO: Set baseDirectory
        global baseDirectory
        path = % baseDirectory. "\LuiUI.nb"
        
        name = % "LuiUI.nb - Wolfram Mathematica 11.1"
        if (not WinExist(name))
        {
            name = % "LuiUI.nb * - Wolfram Mathematica 11.1"
        }
        OpenDirectoryOrFile(name, path, "None")
        if (Click)
        {
            Click 100, 102, 3
        }
        Return name
    }
    
    OpenDirectoryOrFile(Name, Path, ScreenSide)
    {
        IsWindowOpen := WinExist(Name)
        
        if (IsWindowOpen)
        {
            ;; If the file/dir is already open, then display it
            WinActivate, %Name%
            Sleep, 200
        }
        else
        {
            ;; If the file/dir isn't open yet, then open it
            Run explorer.exe %Path%
            ;; Wait for the window to open
            Loop 20 {
                IfWinExist, %Name%
                {
                    break
                }
                Sleep, 100
            }
        }
    }