BeginPackage["Lui`Antlr`"]

Needs["JLink`"]
Needs["Lui`Lui`"];
Needs["WUtils`WUtils`"]

GenerateAntlrGrammar::usage = "GenerateAntlrGrammar  "

CompileAntlrGrammar::usage = "CompileAntlrGrammar  "

UpdateAntlrGrammar::usage = "UpdateAntlrGrammar  "

ParseUsingAntlrGrammar::usage = "ParseUsingAntlrGrammar  "

ParseExprUsingAntlrGrammar::usage = "ParseExprUsingAntlrGrammar  "

Begin["`Private`"]

$jdkBin = "E:\\Program Files\\Java\\jdk1.7.0_03\\bin";

(* TODO: Make first letter lower case. *)
If [!ValueQ[$grammarSourceDir],
	$grammarSourceDir = FileNameJoin[{$LuiDir, "AntlrGrammar"}];
];

If [!ValueQ[$grammarOutputDir],
	$grammarOutputDir = FileNameJoin[{$LuiDir, "\\src\\com\\danielbigham\\lui\\antlr"}];
];

If [!ValueQ[$grammarBinOutputDir],
	$grammarBinOutputDir = FileNameJoin[{$LuiDir, "bin"}];
];

grammarOutDir[name_String] :=
	If [ValueQ[$grammarOutputDir],
		$grammarOutputDir
		,
		FileNameJoin[{$TemporaryDirectory, name}]
	]

(* Uses ANTLR to generate a grammar. *)
Clear[GenerateAntlrGrammar];
Options[GenerateAntlrGrammar] =
{
	"GrammarName" -> "Grammar",		(*< The name of the grammar (correspond to grammar file) *)
	"GrammarDir" -> Automatic,		(*< The directory containing the grammar. *)
	"OutDir" -> Automatic,			(*< Output directory for generated classes. *)
	"UseNamespace" -> True			(*< Use package 'com.danielbigham.lui.antlr'? *)
};
GenerateAntlrGrammar[OptionsPattern[]] :=
	Block[{grammarName = OptionValue["GrammarName"],
		   grammarDir = OptionValue["GrammarDir"],
		   grammarFile,
		   outDir = OptionValue["OutDir"]},
		If [grammarDir == Automatic,
			grammarDir = $grammarSourceDir;
		];
		grammarFile = FileNameJoin[{grammarDir, grammarName <> ".g4"}];
		If [!FileExistsQ[grammarFile],
			Print["Missing grammar file: ", grammarFile];
			Return[$Failed, Block];
		];
		If [outDir === Automatic,
			outDir = grammarOutDir[grammarName];
		];
		If [!FileExistsQ[outDir], CreateDirectory[outDir]];
		RunProcess[
			{
			"java",
			"org.antlr.v4.Tool",
			If [TrueQ[OptionValue["UseNamespace"]],
				Sequence @@
				{
					"-package",
					"com.danielbigham.lui.antlr"
				}
				,
				Sequence @@ {}
			],
			"-lib",
			grammarDir,
			"-o",
			outDir,
			grammarFile
			},
			ProcessEnvironment ->
			<|
				"PATH" -> $jdkBin <> ";" <> NotebookDirectory[],
				"CLASSPATH" -> FileNameJoin[{$LuiDir, "Jars", "antlr-4.5.3-complete.jar"}]
			|>
		]
	]

handleRes[res_] :=
	Module[{},
		If [AssociationQ[res] && res["StandardError"] =!= "", Print[Style[res["StandardError"], Red]]];
		If [AssociationQ[res] && res["StandardOutput"] =!= "", Print[res["StandardOutput"]]];
		If [FailureQ[res] || res["ExitCode"] =!= 0, Return[$Failed, Block]];
	]

Options[CompileAntlrGrammar] =
{
	"GrammarName" -> "Grammar"		(*< The name of the grammar (correspond to grammar file) *)
};
CompileAntlrGrammar[OptionsPattern[]] :=
	Block[{grammarName = OptionValue["GrammarName"]},
		XPrint["Compiling grammar..."];
		XPrint["  Output directory: " <> $grammarBinOutputDir];
		If [!FileExistsQ[$grammarBinOutputDir], CreateDirectory[$grammarBinOutputDir]];
		RunProcess[
			{
			"javac",
			FileNameJoin[{grammarOutDir[grammarName], "*.java"}],
			"-d",
			$grammarBinOutputDir
			},
			ProcessEnvironment ->
			<|
				"PATH" -> 
					$jdkBin <> ";" <> 
					NotebookDirectory[],
				"CLASSPATH" -> 
					FileNameJoin[{$LuiDir, "Jars", "antlr-4.5.3-complete.jar"}] <> ";" <> 
					FileNameJoin[{$LuiDir, "bin"}]
			|>
		]
	]

(*!
	\function UpdateAntlrGrammar
	
	\calltable
		UpdateAntlrGrammar[] '' generates and compiles the grammar.
	
	\maintainer danielb
*)
Clear[UpdateAntlrGrammar];
UpdateAntlrGrammar::fgg = "Failed to generate grammar."
UpdateAntlrGrammar::fcg = "Failed to compile grammar."
Options[UpdateAntlrGrammar] =
{
	"GrammarName" -> "Grammar",		(*< The name of the grammar (correspond to grammar file) *)
	"OnlyIfFilesModified" -> True,	(* Only update the grammar if its source files have changed? *)
	"UseNamespace" -> True			(*< Use package 'com.danielbigham.lui.antlr'? *)
};
UpdateAntlrGrammar[opts:OptionsPattern[]] :=
	Block[{res, grammarName = OptionValue["GrammarName"], files, fileDates},
		If [TrueQ[OptionValue["OnlyIfFilesModified"]],
			files = FileNames["*.g4", $grammarSourceDir, Infinity];
			fileDates = FileDate /@ files;
			If [fileDates =!= prevFileDates[grammarName, $grammarOutputDir, $grammarBinOutputDir],
				handleRes[GenerateAntlrGrammar[
					Sequence @@ FilterRules[{opts}, Options[GenerateAntlrGrammar]]]];
				handleRes[CompileAntlrGrammar[
					Sequence @@ FilterRules[{opts}, Options[CompileAntlrGrammar]]]];
			];
			,
			handleRes[GenerateAntlrGrammar[
				Sequence @@ FilterRules[{opts}, Options[GenerateAntlrGrammar]]]];
			handleRes[CompileAntlrGrammar[
				Sequence @@ FilterRules[{opts}, Options[CompileAntlrGrammar]]]];
		];
		prevFileDates[grammarName, $grammarOutputDir, $grammarBinOutputDir] = fileDates;
	];

Clear[ParseUsingAntlrGrammar];
Attributes[ParseExprUsingAntlrGrammar] = {HoldAllComplete};
ParseExprUsingAntlrGrammar[grammarName_String, grammarSymbol_String, expr_] :=
	Block[{exprString, file, res},
		exprString = ToString[HoldComplete[expr], InputForm];
		exprString = StringTake[exprString, {14, -2}];
		ParseUsingAntlrGrammar[grammarName, grammarSymbol, exprString]
	];

Options[ParseUsingAntlrGrammar] =
{
	"GrammarName" -> "Grammar",			(*< The name of the grammar (correspond to grammar file) *)
	"GrammarSymbol" -> "grammarRules",	(*< The resultant grammar symbol of the parse. *)
	"Temporary" -> True					(*< Generate/compile the grammar into a temporary dir? *) 
};
ParseUsingAntlrGrammar[str_, OptionsPattern[]] :=
	Block[{
		exprString, file, res,
		grammarName = OptionValue["GrammarName"],
		grammarSymbol = OptionValue["GrammarSymbol"],
		$grammarOutputDir =
			If [TrueQ[OptionValue["Temporary"]],
				FileNameJoin[{$TemporaryDirectory, "LuiGrammar"}]
				,
				$grammarOutputDir
			],
		$grammarBinOutputDir =
			If [TrueQ[OptionValue["Temporary"]],
				FileNameJoin[{$TemporaryDirectory, "LuiGrammar"}]
				,
				$grammarBinOutputDir
			]
		},
		If [FailureQ[UpdateAntlrGrammar["UseNamespace" -> !OptionValue["Temporary"]]],
			Return[$Failed];
		];
		Print[Style["Input", "Subsection"]];
		Print["String: ", str];
		XPrint["InputForm: ", ToString[str, InputForm]];
		file = OpenWrite[][[1]];
		Close[file];
		Export[file, str, "Text"];
		SetDirectory[$grammarBinOutputDir];
		res =
		RunProcess[
			{
			"grun.bat",
			grammarName,
			grammarSymbol,
			"-tree",
			file
			},
			ProcessEnvironment ->
			<|
			"PATH" -> 
				$jdkBin <> ";" <> 
				NotebookDirectory[],
			"CLASSPATH" -> 
				FileNameJoin[{$LuiDir, "Jars", "antlr-4.5.3-complete.jar"}] <> ";" <> 
				$grammarBinOutputDir
			|>
		];
		DeleteFile[file];
		Print[Style["Result", "Subsection"]];
		handleRes2[res]
	]
	
handleRes2[res_] :=
	Module[{},
		If [AssociationQ[res] && res["StandardError"] =!= "", Print[Style[res["StandardError"], Red]]];
		If [AssociationQ[res] && res["StandardOutput"] =!= "", Print[indentParseTree[res["StandardOutput"]]]];
		If [FailureQ[res] || res["ExitCode"] =!= 0, Return[$Failed, Block]];
	]
	
spaces[n_] := StringJoin[Table["    ", {n}]];
indentParseTree[str_] :=
	Block[{indent = 0, str2},
		StringReplace[
			str,
			{
			"(" :> (++indent; "\n" <> spaces[indent] <> "(\n" <> spaces[indent + 1]),
			"{" :> (++indent; "\n" <> spaces[indent] <> "{\n" <> spaces[indent + 1]),
			")" :> (str2 = "\n" <> spaces[indent] <> ")"; --indent; str2),
			"}" :> (str2 = "\n" <> spaces[indent] <> "}"; --indent; str2)
			}
		]
	]

End[]

EndPackage[]