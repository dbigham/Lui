BeginPackage["Lui`Parse`"]

Needs["JLink`"]
Needs["Lui`Lui`"];
Needs["WUtils`WUtils`"]

LuiParse::usage = "LuiParse  "

CreateGrammar::usage = "CreateGrammar  "

Grammar::usage = "Grammar  "

GrammarToAssoc::usage = "GrammarToAssoc  "

ProcessParseForest::usage = "ProcessParseForest  "

GetParseForest::usage = "GetParseForest  "

GetParserState::usage = "GetParserState  "

$TestGrammar1::usage = "$TestGrammar1  "

$GrammarDir::usage = "$GrammarDir  "

$GrammarFile::usage = "$GrammarFile  "

Dir::usage = "Dir  "

InitializeParser::usage = "InitializeParser  "

ConsiderFileInterpretation::usage = "ConsiderFileInterpretation  "

EditGrammar::usage = "EditGrammar  "

PossibleExpressions::usage = "PossibleExpressions  "

$ParserState::usage = "$ParserState  "

HeldHead::usage = "HeldHead  "

Begin["`Private`"]

$GrammarDir = FileNameJoin[{$LuiDir, "Grammar"}];
$GrammarFile = FileNameJoin[{$GrammarDir, "Main.grammar"}];

$TestGrammar1 =
"start: a=$a PLUS b=$b -> a+b
a: ONE -> 1
b: TWO -> 2
";

(* The start symbol. *)
START = -1;

Attributes[HeldHead] = {HoldAllComplete};

(*!
	\function LuiParse
	
	\calltable
		LuiParse[input] '' parses the input using the default grammar.
		LuiParse[grammar, input] '' parses the given input with the given grammar.
	
	\maintainer danielb
*)
Options[LuiParse] =
{
	"Debug" -> False			(*< Debug output? *)
}
LuiParse[input_String, opts:OptionsPattern[]] :=
	Block[{parse},
		
		ReloadFiles[];
		
		parse = LuiParse[$Grammar, input, opts];
		
		If [Length[parse] > 0,
			Return[First[parse]];
		];
		
		ConsiderFileInterpretation[input]
	]

LuiParse[g_Grammar, inputIn_String, opts:OptionsPattern[]] :=
	Block[{state, prevDebug, debug = TrueQ[OptionValue["Debug"]],
		   input = inputIn},
		
		input = StringReplace[input, "\[Rule]" :> "->"];
		
		prevDebug = ChartParser`debugFlag;
		ChartParser`debugFlag = debug;
		
		$ParserState = state = GetParserState[g, input];
		
		If [debug && prevDebug === False,
			ChartParser`debugFlag = False;
		]; 
		
		If [!FailureQ[state],
			If [debug,
				Print[state // Indent2];
			];
			ProcessParseForest[state]
			,
			$Failed
		]
	]

Clear[Grammar];
Grammar[inner_][key_String] := inner[key] 

(*!
	\function CreateGrammar
	
	\calltable
		CreateGrammar[name, grammarRules_List] '' creates a grammar.
		CreateGrammar[name, grammarRules_String] '' creates a grammar.

	Examples:
	
	CreateGrammar["Test", "start: hello"]
	
	===
	
	<|"Name" -> "Test", "RuleCount" -> 1, "Rules" -> {"<$start:-1>: {<<hello:0>>}"}|>

	Unit tests:

	RunUnitTests[Lui`Parse`CreateGrammar]

	\maintainer danielb
*)
Clear[CreateGrammar];
CreateGrammar::fcj = "Failed to create Grammar Java object.";
CreateGrammar[name_String, grammarRules_] :=
	Block[{javaObject},
		javaObject = JavaNew["com.danielbigham.lui.Grammar", grammarRules];
		If [!JavaObjectQ[javaObject],
			Message[CreateGrammar::fcj];
			Return[$Failed];
		];
		CreateGrammar[name, javaObject]
	];
	
CreateGrammar[name_String, obj_ /; JavaObjectQ[obj]] :=
	Grammar[
		<|
		"JavaObject" -> obj,
		"Name" -> name
		|>
	]

CreateGrammar[name_String, Dir[dir_String]] :=
	Block[{grammar},
		grammar = JavaNew["com.danielbigham.lui.Grammar"];
		JavaNew["com.danielbigham.lui.loading.GrammarFiles", dir, grammar];
		CreateGrammar[name, grammar]
	]

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
	Block[{forest, endPos, topLevelNodes, parseForestLookup, res},
		
		endPos = state["EndPos"];
		
		(* Most -> Drop the last item which is always 'Null' *)
		forest = Most[state["Forest"]];
		
		(* Select the parse forest nodes that span the entire input string
		   and who's result symbol is the START symbol. *)
		topLevelNodes = Select[forest, First[#] === {START, 0, endPos} &];
		
		res =
		Lui`Parse`Private`blockParseForestLookup[
			forest,
			Flatten[
				(evaluateRule /@ topLevelNodes[[All, 2;;]])[[All, 1]],
				1
			]
		];
		
		If [True,
			Replace[
				res,
				p_PossibleExpressions :> Sequence @@ p,
				{1}
			]
			,
			res
		]
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
	Block[{state, state2, wlString},
		state = ChartParser`parse[grammar["JavaObject"], input];
		wlString = state@toWL[];
		If [StringQ[wlString],
			state2 = ToExpression[wlString];
			If [FailureQ[state2],
				Message[LuiParse::te];
				Return[$Failed]
			];
			(* What's the best way to deal with this? Should it be done
			   on the Java side of things? *)
			state2["Forest"] = DeleteDuplicates[state2["Forest"]];
			state2
			,
			Message[LuiParse::jf];
			$Failed
		]
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

	PossibleExpressions[4, 6, 5, 7]

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
			heldAction /. HoldComplete[innerAction_] :>
				(
				func =
					ListOfHeldToHeldList[Keys[bindings]] /. HoldComplete[inner_] :>
	  					Function[inner, innerAction];
	  			);
			Replace[
				func @@@ permuteBindings[bindings],
				{
					List[arg_] :> arg,
					List[args__] :> PossibleExpressions[args]
				},
				{0}
			]
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
Clear[permuteBindings];
permuteBindings[{}] := {}
permuteBindings[bindings_List] :=
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

(*!
	\function evaluateChild
	
	\calltable
		evaluateChild[child] '' given a subpattern match (child) from the parse forest, evaluate the parse forest underneath of it and return the evaluation result.
		evaluateChild[key:{startPos_, endPos_, symbol_}, type_, binding_] '' ...

	Examples:
	
	blockParseForestLookup[
		{{{-1, 0, 0}, "E", HoldComplete[1], {{{0, 0, 0}, "L", Null}}}},
		evaluateChild[{{0, 0, 0}, "L", Null}]
	]

	===

	{{}, {}}

	Unit tests:

	RunUnitTests[Lui`Parse`Private`evaluateChild]

	\maintainer danielb
*)
Clear[evaluateChild];
evaluateChild[child_List] :=
	Block[{},
		evaluateChild[
			Sequence @@ child
		]
	];

(* Literal *)
evaluateChild[key:{startPos_Integer, endPos_Integer, symbol_Integer}, "L", Null] := {{}, <||>}	
evaluateChild[key:{startPos_Integer, endPos_Integer, symbol_Integer}, "L", binding_] :=
	{{}, <|binding -> Null|>}

(* Symbol *)
evaluateChild[key:{startPos_Integer, endPos_Integer, symbol_Integer}, "S", Null] := {{}, <||>}
evaluateChild[key:{startPos_Integer, endPos_Integer, symbol_Integer}, "S", binding_] :=
	Block[{ruleMatches, values, evaluatedRules},
		XPrint["evaluateChild: ", key];
		ruleMatches = $parseForestLookup[key];
		XPrint["ruleMatches: ", ruleMatches];
		evaluatedRules = evaluateRule /@ ruleMatches;
		XPrint["evaluatedRules: ", evaluatedRules];
		{
			{},
			<|binding -> evaluatedRules[[All, 1]]|>
		}
	]

(* Dynamic sub-rule *)
evaluateChild[key:{startPos_Integer, endPos_Integer, symbol_Integer}, "D", binding_] :=
	Block[{ruleMatches, values, evaluatedRules},
		XPrint["evaluateChild: ", key];
		ruleMatches = $parseForestLookup[key];
		XPrint["ruleMatches: ", ruleMatches];
		evaluatedRules = evaluateRule /@ ruleMatches;
		XPrint["evaluatedRules: ", evaluatedRules];
		{
			{},
			If [binding =!= Null,
				(* Not yet tested *)
				Join[
					<|binding -> evaluatedRules[[All, 1]]|>,
					Join @@ evaluatedRules[[All, 2]]
				]
				,
				Join @@ evaluatedRules[[All, 2]]
			]
		}
	]

(*!
	\function blockParseForestLookup
	
	\calltable
		blockParseForestLookup[parseForest, expr] '' given a parse forest, create a lookup function for it and use Block to make it available to the given expr that is evaluated.

	Examples:
	
	blockParseForestLookup[
		{{{-1, 0, 0}, "E", HoldComplete[1], {{{0, 0, 0}, "L", Null}}}},
		$parseForestLookup[{-1, 0, 0}]
	]

	===

	{{"E", HoldComplete[1], {{{0, 0, 0}, "L", Null}}}}

	Unit tests:

	RunUnitTests[Lui`Parse`Private`blockParseForestLookup]

	\maintainer danielb
*)
Attributes[blockParseForestLookup] = {HoldRest};
blockParseForestLookup[parseForest_, expr_] :=
	Block[{$parseForestLookup = createParseForestLookup[parseForest]},
		expr
	];

(*!
	\function evaluateRule
	
	\calltable
		evaluateRule[ruleMatch] '' given a rule match from the parse forest, evaluate the parse forest underneath of it and return the evaluation result.

	Examples:
	
	blockParseForestLookup[
		{
			{
				{-1, 0, 2},
				"E",
				HoldComplete[a + b],
				{
					{{0, 0, 0}, "S", HoldComplete[a]},
					{{1, 1, 1}, "L", Null},
					{{0, 2, 2}, "S", HoldComplete[b]}
				}
			},
			{{0, 0, 0}, "E", HoldComplete[1], {{{2, 0, 0}, "L", Null}}},
			{{0, 2, 2}, "E", HoldComplete[2], {{{3, 2, 2}, "L", Null}}}
		},
		evaluateRule[{"E", HoldComplete[1], {{{2, 0, 0}, "L", Null}}}]
	]

	===

	1

	Unit tests:

	RunUnitTests[Lui`Parse`Private`evaluateRule]

	\maintainer danielb
*)
Clear[evaluateRule];
evaluateRule[ruleMatch_List] :=
	evaluateRule[Sequence @@ ruleMatch]

evaluateRule[type_, action_, children_List] :=
	Block[{evaluatedChildren, mergedVariables, permutedVariableValues, res},
		XPrint["evaluateRule: ", {type, action, children}];
		evaluatedChildren = evaluateChild /@ children;
		XPrint["evaluatedChildren: ", evaluatedChildren];
		mergedVariables =
			Merge[
				evaluatedChildren[[All, 2]],
				Flatten[Join[#], 1] &
			];
		XPrint["mergedVariables: ", Normal[mergedVariables]];
		If [type === "E",
			res =
			{
				evaluateAction[action, Normal[mergedVariables]],
				<||>
			};
			,
			res =
			{
				evaluateAction[action, Normal[mergedVariables]],
				mergedVariables
			};
		];
		XPrint["res: ", type, ": ", res];
		res
	];

(*!
	\function InitializeParser
	
	\calltable
		InitializeParser[] '' loads the grammar, etc.
	
	\maintainer danielb
*)
InitializeParser[] :=
	Block[{},
		$Grammar = CreateGrammar["Lui", Dir[$GrammarDir]]
	];

(*!
	\function ConsiderFileInterpretation
	
	\calltable
		ConsiderFileInterpretation[input] '' considers whether the input is referring to a notebook file or text file, etc.
	
	\maintainer danielb
*)
ConsiderFileInterpretation[input_String] :=
	Block[{},
		Block[{dir},
			dir = "E:\\Users\\" <> $UserName <> "\\Dropbox\\Maluuba\\Notebooks";
			If [!FileExistsQ[dir],
				dir = "C:\\Users\\" <> $UserName <> "\\Dropbox\\Maluuba\\Notebooks";
			];
			If [ResolveIssueNotebook[input] =!= $Failed,
				HoldComplete @ OpenNotebook[input]
				,
				With[{matchingFiles = FileNames[input <> "*", dir]},
					If [Length[matchingFiles] > 0,
						SystemOpen[matchingFiles[[1]]]
						,
						With[{textFile = FileNameJoin[{dir, input <> ".txt"}]},
							If [FileExistsQ[textFile],
								SystemOpen[textFile]
								,
								HoldComplete @ $Failed
							]
						]
					]
				]
			]

		]
	];

(*!
	\function EditGrammar
	
	\calltable
		EditGrammar[] '' edit the LUI grammar.
	
	\related '
	
	\maintainer danielb
*)
EditGrammar[] :=
	Block[{},
		OpenFileInWorkbench[$GrammarFile]
	];


End[]

EndPackage[]