BeginPackage["Lui`Parse`"]

Needs["JLink`"]
Needs["WUtils`WUtils`"]

LuiParse::usage = "LuiParse  "

CreateGrammar::usage = "CreateGrammar  "

Grammar::usage = "Grammar  "

GrammarToAssoc::usage = "GrammarToAssoc  "

ProcessParseForest::usage = "ProcessParseForest  "

GetParseForest::usage = "GetParseForest  "

GetParserState::usage = "GetParserState  "

$TestGrammar1::usage = "$TestGrammar1  "

Begin["`Private`"]

$TestGrammar1 =
"start: a=$a PLUS b=$b -> a+b
a: ONE -> 1
b: TWO -> 2
";

(* The start symbol. *)
START = -1;

(*!
	\function LuiParse
	
	\calltable
		LuiParse[input] '' parses the input using the default grammar.
		LuiParse[grammar, input] '' parses the given input with the given grammar.
	
	\maintainer danielb
*)
LuiParse[input_String] :=
	Block[{},
		Switch[
			input,
			
			"time",
			HoldComplete[Date[]]
			,
			"spacex reddit",
			HoldComplete[SystemOpen["https://www.reddit.com/r/spacex/"]]
			,
			"hello",
			HoldComplete["Hello, world!"]
			,
			_,
			HoldComplete["?"]
		]
	]

LuiParse[g_Grammar, input_String] :=
	Block[{state, forest, wlString},
		state = ChartParser`parse[g["JavaObject"], input];
		wlString = state@toWL[];
		If [StringQ[wlString],
			forest = ToExpression[wlString];
			If [FailureQ[forest],
				Message[LuiParse::te];
				Return[$Failed]
			];
			ProcessParseForest[forest]
			,
			Message[LuiParse::jf];
			$Failed
		]
	]

Clear[Grammar];
Grammar[inner_][key_String] := inner[key] 

(*!
	\function CreateGrammar
	
	\calltable
		CreateGrammar[name, grammarRules] '' creates a grammar.

	Examples:
	
	CapturePrint[CreateGrammar["Test", "start -> hello"]] === {{"Line 1 column 6: no viable alternative at input 'start->'"}}

	Unit tests:

	RunUnitTests[Lui`Parse`CreateGrammar]

	\maintainer danielb
*)
CreateGrammar::fcj = "Failed to create Grammar Java object.";
CreateGrammar[name_, grammarRules_] :=
	Block[{javaObject},
		javaObject = JavaNew["com.danielbigham.lui.Grammar", grammarRules];
		If [!JavaObjectQ[javaObject],
			Message[CreateGrammar::fcj];
			Return[$Failed];
		];
		Grammar[
			<|
			"JavaObject" -> javaObject,
			"Name" -> name
			|>
		]
	];

Format[g_Grammar] :=
	Block[{},
		Framed[
			formatKeyValues[
				<|
					"Name" -> g[[1, "Name"]],
					"Rules" -> g[[1, "JavaObject"]]@getRuleCount[]
				|>
			],
			FrameMargins -> 20,
			FrameStyle -> GrayLevel[0.7]
		]
	]

(*!
	\function formatKeyValues
	
	\calltable
		formatKeyValues[assoc] '' formats an association of key/value pairs.

	Examples:
	
	formatKeyValues[Association["Items" -> 7, "Price" -> "$43.23"]]

	===

	Style[
		Grid[
			{
				{Style["Items:", FontColor -> GrayLevel[0.5]], 7},
				{Style["Price:", FontColor -> GrayLevel[0.5]], "$43.23"}
			},
			Alignment -> Left,
			Spacings -> {0.5, 0.5}
		],
		FontFamily -> "Arial"
	]

	Unit tests:

	RunUnitTests[Lui`Parse`Private`formatKeyValues]

	\maintainer danielb
*)
formatKeyValues[assoc_Association] :=
	Block[{items},
		
		items = Transpose[{Style[# <> ":", FontColor -> Gray] & /@ Keys[assoc], Values[assoc]}];
		
		Style[
			Grid[
				items,
				Alignment -> Left,
				Spacings -> {0.5, 0.5}
			],
			FontFamily -> "Arial"
		]
	];

(*!
	\function GrammarToAssoc
	
	\calltable
		GrammarToAssoc[grammar] '' converts a grammar to key/value pairs.

	Examples:
	
	GrammarToAssoc[
		CreateGrammar[
			"Test",
			"start: go to $webpage\nwebpage:\n\tslashdot -> \"http://www.slashdot.org\"\n\tspacex|spx reddit -> TODO\n"
		]
	]

	===

	<|
		"Name" -> "Test",
		"RuleCount" -> 3,
		"Rules" ->
		{
			"<$start:-1>: {<<go:0>> <to:1> <$webpage:2>}",
			"<$webpage:2>: {<<slashdot:3>>}",
			"<$1:7>: <spacex:4>|<spx:5>",
			"<$webpage:2>: {<<$1:7>> <reddit:6>}"
		}
	|>

	Unit tests:

	RunUnitTests[Lui`Parse`GrammarToAssoc]

	\maintainer danielb
*)
GrammarToAssoc[grammar_] :=
	Block[{obj, g},
		g = grammar[[1]];
		obj = g["JavaObject"];
		<|
			"Name" -> g["Name"],
			"RuleCount" -> obj@getRuleCount[],
			"Rules" -> obj@getRulesAsStrings[]
		|>
	];

(*!
	\function ProcessParseForest
	
	\calltable
		ProcessParseForest[forest] '' converts a parse forest into a list of parse trees, pruning trees that have any of their branches or leaves evaluate to $Failed. Returns the final list of expressions.

	Examples:
	
	ProcessParseForest[forest] === TODO
	
	\related '
	
	\maintainer danielb
*)
ProcessParseForest[state_] :=
	Block[{forest, endPos, topLevelNodes, parseForestLookup},
		
		endPos = state["EndPos"];
		
		(* Most -> Drop the last item which is always 'Null' *)
		forest = Most[state["Forest"]];
		
		parseForestLookup = createParseForestLookup[forest];
		
		(* Select the parse forest nodes that span the entire input string
		   and who's result symbol is the START symbol. *)
		topLevelNodes = Select[forest, First[#] === {START, 0, endPos} &];
		
		handleTopLevelNode /@ (topLevelNodes[[All, 2;;]])
	];

(*!
	\function createParseForestLookup
	
	\calltable
		createParseForestLookup[forest] '' create a lookup function parseForestLookup so that given a {symbol,start,end} we can lookup all parse forest nodes.
	
	Examples:
	
	createParseForestLookup[
		{
			{{-1, 0, 2}, HoldComplete[a + b], {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}}},
			{{0, 0, 0}, HoldComplete[1], {{3, 0, 0}}},
			{{2, 2, 2}, HoldComplete[2], {{4, 2, 2}}}
		}
	]

	===

	<|
		{-1, 0, 2} -> {{HoldComplete[a + b], {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}}}},
		{0, 0, 0} -> {{HoldComplete[1], {{3, 0, 0}}}},
		{2, 2, 2} -> {{HoldComplete[2], {{4, 2, 2}}}}
	|>

	Unit tests:

	RunUnitTests[Lui`Parse`Private`createParseForestLookup]

	\maintainer danielb
*)
createParseForestLookup[forest_] := GroupBy[forest, First -> Rest]

(*!
	\function GetParseForest
	
	\calltable
		GetParseForest[grammar, input] '' produces the parse forest for the given input on the given grammar.

	Examples:
	
	GetParseForest[CreateGrammar["Test", "start: hello world -> \"Hey!\""], "hello world"]

	===

	{{{-1, 0, 1}, HoldComplete["Hey!"], {{0, 0, 0}, {1, 1, 1}}}, Null}

	Unit tests:

	RunUnitTests[Lui`Parse`GetParseForest]

	\maintainer danielb
*)
GetParseForest[grammar_, input_] :=
	Block[{state},
		state = GetParserState[grammar, input];
		If [!FailureQ[state],
			Most[state["Forest"]]
			,
			$Failed
		]
	];

(*!
	\function GetParserState
	
	\calltable
		GetParserState[grammar, input] '' produces the final parser state for the given input on the given grammar.

	Examples:
	
	GetParserState[CreateGrammar["Test", "start: hello world -> \"Hey!\""], "hello world"]

	===

	<|
		"EndPos" -> 1,
		"Forest" -> {{{-1, 0, 1}, HoldComplete["Hey!"], {{0, 0, 0}, {1, 1, 1}}}, Null}
	|>

	Unit tests:

	RunUnitTests[Lui`Parse`GetParserState]

	\maintainer danielb
*)
LuiParse::jf = "The return value from Java wasn't a string as expected.";
LuiParse::te = "ToExpression returned $Failed on the result from Java.";
GetParserState[grammar_, input_] :=
	Block[{state, forest, wlString},
		state = ChartParser`parse[grammar["JavaObject"], input];
		wlString = state@toWL[];
		If [StringQ[wlString],
			forest = ToExpression[wlString];
			If [FailureQ[forest],
				Message[LuiParse::te];
				Return[$Failed]
			];
			forest
			,
			Message[LuiParse::jf];
			$Failed
		]
	]

(*!
	\function handleTopLevelNode
	
	\calltable
		handleTopLevelNode[parseForestNode] '' recursively handles this top level parse forest node and its child nodes to produce a parse tree.

	Examples:
	
	handleTopLevelNode[parseForestNode] === TODO
	
	\related '
	
	\maintainer danielb
*)
handleTopLevelNode[parseForestNode_] :=
	Block[{},
		
		Print[Lui`Parse`Private`parseForestLookup // Indent2];
		
		xPrint["TOP LEVEL NODE: ", parseForestNode];
		
		handleNode[parseForestNode, 0]
		
	];

(*!
	\function handleNodesOfKey
	
	\calltable
		handleNodesOfKey[key] '' recursively handles the parse forest node corresponding to this {symbol,start,end} and its child nodes to produce a parse tree.

	Examples:
	
	handleNodesOfKey[key] === TODO
	
	\related '
	
	\maintainer danielb
*)
handleNodesOfKey[key_, lvl_] :=
	Block[{nodes = Lookup[parseForestLookup, Key[key], {}], res},
		Print[levelToIndent[lvl], key];
		res =
		If [nodes === {},
			(* There are no nodes for this key. This implies that
			   we're at the bottom of the tree -- that this key
			   corresponds with a token that we didn't send back
			   a parse forest node for. *)
			(* TODO: It looks like we're not currently sending
			   tokens back as part of the parse forest, but we'll
			   need to do that as soon as we create tokenizers
			   that assign an expression to a token. And it might
			   be nice to be able to bind to a literal token and
			   get back its input substring. *)
			Null
			,
			handleNode[#, lvl + 1] & /@ nodes
		];
		
		(* ? *)
		If [ListQ[res], res = Flatten[res, 1]];
		
		Print[levelToIndent[lvl], key, " res: ", res];
		
		res
	];

(*!
	\function handleNode
	
	\calltable
		handleNode[node] '' recursively handles the parse forest node and its child nodes to produce a parse tree.

	Examples:
	
	handleNode[node] === TODO
	
	\related '
	
	\maintainer danielb
*)
handleNode[node_, lvl_] :=
	Block[{res, type = node[[1]], action = node[[2]], resOfAllChildren},
		Print[levelToIndent[lvl], type, " Node: ", node];
		
		resOfAllChildren =
		Function[{child},
			Print[levelToIndent[lvl + 1], "Child: ", child];
			With[{childKey = child[[1]], childType = child[[2]], binding = child[[3]]},
				With[{childRes = handleNodesOfKey[childKey, lvl + 2]},
					If [childRes === Null,
						(* Our children didn't have nodes sent
						   back for them, so we don't have any
						   expressions for them. *)
						Sequence @@ {}
						,
						If [binding =!= Null,
							binding -> childRes
							,
							childRes
						]
					]
				]
			]
		] /@ node[[3]];
		
		Print[levelToIndent[lvl], "Res of all children: ", resOfAllChildren];
		
		res =
			type /.
				{
					"D" :> Flatten[resOfAllChildren],
					"E" :> evaluateAction[action, resOfAllChildren],
					_ :> (Print["Unexpected token type: ", type]; $Failed)
				};
			
		Print[levelToIndent[lvl], "Res: ", res];
		
		res
	]

(*!
	\function levelToIndent
	
	\calltable
		levelToIndent[lvl] '' create whitespace for indenting to the given level.

	Examples:
	
	levelToIndent[1] === "\t"

	Unit tests:

	RunUnitTests[Lui`Parse`Private`levelToIndent]

	\maintainer danielb
*)
levelToIndent[lvl_] := StringJoin[Table["\t", {lvl}]]

(*!
	\function evaluateAction
	
	\calltable
		evaluateAction[heldAction, bindings] '' evaluates the given held action, applying bindings if appropriate.

	Examples:
	
	evaluateAction[
		HoldComplete[a + b],
		{
			HoldComplete[a] -> {HoldComplete[1], HoldComplete[2]},
			HoldComplete[b] -> {HoldComplete[3], HoldComplete[5]}
		}
	]

	===

	{4, 6, 5, 7}

	Unit tests:

	RunUnitTests[Lui`Parse`Private`evaluateAction]

	\maintainer danielb
*)
evaluateAction[heldAction_, bindings_] :=
	Block[{func},
		Switch[bindings,
			{},
			ReleaseHold[heldAction]
			,
			{Repeated[HoldComplete[_Symbol] -> _List]},
			(* TODO *)
			heldAction /. HoldComplete[innerAction_] :>
				(
				func =
					ListOfHeldToHeldList[Keys[bindings]] /. HoldComplete[inner_] :>
	  					Function[inner, innerAction];
	  			);
			func @@@ permuteBindings[bindings]
			,
			_,
			Print["Unexpected bindings: ", bindings];
			$Failed
		]
	];

(*!
	\function permuteBindings
	
	\calltable
		permuteBindings[bindings] '' given a list of bindings with one or more possible values for each binding, permute into a list of binding mappings.
	
	Perhaps this function should be the thing to actually *evaluate* the action?
	
	Runtime:
	- 0.04 ms for 9 output items, so 4 ms per 100 such invocations
	- 0.5 ms for 250 output items, so 0.5 seconds per 100 such invocations
	
	Examples:
	
	permuteBindings[
		{
			HoldComplete[a] -> {HoldComplete[1], HoldComplete[2], HoldComplete[3]},
			HoldComplete[b] -> {HoldComplete[4], HoldComplete[5]}
		}
	]

	===

	{{1, 4}, {1, 5}, {2, 4}, {2, 5}, {3, 4}, {3, 5}}

	Unit tests:

	RunUnitTests[Lui`Parse`Private`permuteBindings]

	\maintainer danielb
*)
permuteBindings[bindings_] :=
	Block[{keys, values, part, func, res, flattenedValues, indices},
		
		keys = bindings[[All, 1]];
		values = bindings[[All, 2]];
		
		(* Let the binding values evaluate. Alternatively we could wait
		   until they are substituted into the actions to let them evaluate,
		   not sure which is best. *)
		values = Replace[values, HoldComplete -> Identity, {3}, Heads -> True];
		
		With[{tmp = Table[{i, Slot[i]}, {i, 1, Length[keys]}]},
			indices = Flatten[Array[Function[tmp], Length /@ values], Length[keys]]
		];
		
		flattenedValues = Extract[values, indices];
		
		Partition[flattenedValues, Length[keys]]
	];

(* permuteBindingsImpl2 seems to be about 30% slower than permuteBindings
   for outputs of size 9, and about 3x slower for outputs of size 200. *)
permuteBindingsImpl2[bindings_] :=
	Block[{keys, values, part, func, res, flattenedValues, indices},
		
		keys = bindings[[All, 1]];
		values = bindings[[All, 2]];
		
		(* Let the binding values evaluate. Alternatively we could wait
		   until they are substituted into the actions to let them evaluate,
		   not sure which is best. *)
		values = Replace[values, HoldComplete -> Identity, {3}, Heads -> True];
		
		(* Create a function that we can use with Array to grab all of
		   the variable value combinations. Use 'part' for now, with no
		   down values, otherwise it would try to evaluate before we're ready. *)
		With[{inner = Table[part[values, i, Slot[i]], {i, 1, Length[keys]}]},
			func = Function[inner];
		];
		
		res = Flatten[Array[func, Length /@ values], Length[keys] - 1];
		
		(* Now that our expression is ready to go, assign part = Part
		   to 'activate' it and evaluate as desired. *)
		part = Part;
		
		res
	];

End[]

EndPackage[]