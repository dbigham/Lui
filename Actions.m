BeginPackage["Lui`Actions`"]

Needs["JLink`"]
Needs["Lui`Lui`"];
Needs["WUtils`WUtils`"]

DefineLinguistic::usage = "DefineLinguistic  "

SearchNotebooks::usage = "SearchNotebooks  "

IndexNotebooks::usage = "IndexNotebooks  "

SearchFiles::usage = "SearchFiles  "

MultilineJavaScriptString::usage = "MultilineJavaScriptString  "

CreateMultilineJavaScriptString::usage = "CreateMultilineJavaScriptString  "

ResetHowLog::usage = "ResetHowLog  "

$HowLog::usage = "$HowLog  "

TailHowLog::usage = "TailHowLog  "

GetHowLog::usage = "GetHowLog  "

MultilineJavaString::usage = "MultilineJavaString  "

CreateMultilineJavaString::usage = "CreateMultilineJavaString  "

Begin["`Private`"]

(*!
	\function DefineLinguistic
	
	\calltable
		DefineLinguistic[] '' defines a linguistic.
	
	\maintainer danielb
*)
Clear[DefineLinguistic];
Options[DefineLinguistic] =
{
	"Linguistic" -> "",				(*< the default linguistic. *)
	"Symbol" -> None,				(*< the grammar symbol. *)
	"Expression" -> Null,			(*< the semantic expression. *)
	"Title" -> "Define Linguistic"	(*< the label above the text field. *)
};
DefineLinguistic[OptionsPattern[]] :=
	DynamicModule[{
		input, symbol = OptionValue["Symbol"],
		expression = OptionValue["Expression"],
		dynamicOutput = NewHeldVar[],
		failureFlag},
		
		$addLinguisticBoxId = ToString[Unique["AddLinguisticBoxId"]];
		
		StartScheduledTask[
			CreateScheduledTask[
				FrontEnd`MoveCursorToInputField[
					InputNotebook[],
					$addLinguisticBoxId
				],
				{0.3}
			]
		];
		
		input = OptionValue["Linguistic"];
		input = input /. Null :> "";
		
		Column[
			{
			Style[OptionValue["Title"], "Subsection"],
			DynamicOutputSection[
				With[{boxId = $addLinguisticBoxId},
					InputField[
						Dynamic[input],
						String,
						ImageSize -> {450, 100},
						FrameMargins -> Medium,
						ReturnEntersInput -> False,
						BoxID -> boxId
					]
				],
				dynamicOutput,
				"NakedSection" -> True
			],
			SmartButton[
				"OK",
				failureFlag = False;
				Block[{$JavaExceptionHandler =
						Function[
							{exceptionSymbol, messageTag, description},
							If [StringMatchQ[
									GetJavaException[]@getClass[]@getCanonicalName[],
									"org.antlr.v4.runtime.misc.ParseCancellationException"
								],
								SetHeldVar[dynamicOutput, "Invalid linguistic."];
								failureFlag = True;
								,
								SetHeldVar[dynamicOutput, description];
								failureFlag = True;
							]
						]},
					$Grammar["JavaObject"]@setLinguistic[
						symbol /. None -> "start",
						ToString[expression, InputForm],
						input
					];
					If [!failureFlag,
						Lui`UI`SetActionRes[Null]
					]
				]
			]
			}
		]
	];

(*!
	\function SearchNotebooks
	
	\calltable
		SearchNotebooks[search] '' searches the notebooks directory.

	Examples:
	
	SearchNotebooks[search] === TODO
	
	\related '
	
	\maintainer danielb
*)
SearchNotebooks[search_] :=
	Block[{},
		TextSearchReport[SearchIndexObject["Notebooks"], SearchQueryString[search]]
	];

(*!
	\function IndexNotebooks
	
	\calltable
		IndexNotebooks[] '' creates or updates a search index for the notebooks directory.
	
	\related '
	
	\maintainer danielb
*)
IndexNotebooks[] :=
	Block[{obj},
		obj = Quiet[SearchIndexObject["Notebooks"]];
		If [MatchQ[obj, _SearchIndexObject],
			UpdateSearchIndex[obj];
			obj
			,
			CreateSearchIndex[Global`$NotebookDirectory, "Notebooks"]
		]
	];

(*!
	\function SearchFiles
	
	\calltable
		SearchFiles[search] '' perform a search on $SearchDirectories and display buttons to edit matching files.

	Examples:
	
	SearchFiles[search] === TODO
	
	\related '
	
	\maintainer danielb
*)
Options[SearchFiles] =
{
	"Directories" -> Automatic			(*< The directories to search. *)
};
SearchFiles[search_, OptionsPattern[]] :=
	Block[{files, dirs, dirsOption = OptionValue["Directories"], res},
		
		dirs = Global`$SearchDirectories;
		If [dirsOption =!= Automatic,
			dirs = dirsOption;
		];
		
		res =
			TextSearch[
				dirs,
				search
			];
		files = res[All, "Location"];
		
		If [EmptyQ[files],
			Print["No search results."];
			,
			Row[
				SmartButton[
					FileNameTake[#, -1],
					OpenFileInWorkbench[
					    (* Work around what appears to be a strange TextSearch bug. *)
					    StringReplace[#, "\\\\" -> "\\"],
					    "Substring" -> search
					]
				] & /@ files[[All, 1]],
				" "
			]
		]
	];

(*!
	\function MultilineJavaScriptString
	
	\calltable
		MultilineJavaScriptString[str] '' generate a multi-line escaped JavaScript string.

	Examples:
	
	MultilineJavaScriptString["this is a \"test\"\nof this function."] === "\"this is a \\\"test\\\"\\n\\\nof this function.\""

	Unit tests:

	RunUnitTests[Lui`Actions`MultilineJavaScriptString]

	\maintainer danielb
*)
MultilineJavaScriptString[str_] :=
	Block[{},
		StringJoin[
			"\"" <>
			StringReplace[
				EscapeString[str],
				"\n" -> "\\n\\\n"
			] <>
			"\""
		]
	];

(*!
	\function CreateMultilineJavaScriptString
	
	\calltable
		CreateMultilineJavaScriptString[] '' take the clipboard, create a multi-line JavaScript string from it, and put the result back in the clipboard.
	
	\related '
	
	\maintainer danielb
*)
CreateMultilineJavaScriptString[] :=
	Block[{},
		CopyToClipboard[MultilineJavaScriptString[GetClipboard[]]]
	];


(*!
	\function MultilineJavaString
	
	\calltable
		MultilineJavaString[str] '' generate a multi-line escaped JavaScript string.

	Examples:
	
	MultilineJavaString["this is a \"test\"\nof this function."] === "\"this is a \\\"test\\\"\\n\\\nof this function.\""

	Unit tests:

	RunUnitTests[Lui`Actions`MultilineJavaString]

	\maintainer danielb
*)
MultilineJavaString[str_] :=
	Block[{},
		StringJoin[
			"\"" <>
			StringReplace[
				EscapeString[str],
				RepeatedNull["\r", 1] ~~ "\n" -> "\\n"
			] <>
			"\""
		]
	];

(*!
	\function CreateMultilineJavaString
	
	\calltable
		CreateMultilineJavaString[] '' take the clipboard, create a multi-line Java string from it, and put the result back in the clipboard.
	
	\related '
	
	\maintainer danielb
*)
CreateMultilineJavaString[] :=
	Block[{},
		CopyToClipboard[MultilineJavaString[GetClipboard[]]]
	];

$HowLog = FileNameJoin[{$TemporaryDirectory, "how.log"}];
(*!
	\function ResetHowLog
	
	\calltable
		ResetHowLog[] '' reset the How log.
	
	\related '
	
	\maintainer danielb
*)
ResetHowLog[] :=
	Block[{},
		Export[$HowLog, "", "Text"];
	];

(*!
	\function TailHowLog
	
	\calltable
		TailHowLog[] '' tail the how log.
	
	\related '
	
	\maintainer danielb
*)
TailHowLog[numLines_:20] :=
	Block[{},
		Dynamic[
			GetLastLines[
				GetHowLog[],
				numLines
			],
			UpdateInterval -> 2
		]
	];

(*!
	\function GetHowLog
	
	\calltable
		GetHowLog[] '' read the how log.
	
	\related '
	
	\maintainer danielb
*)
GetHowLog[] :=
	Block[{},
		Import[$HowLog, "Text"]
	];

End[]

EndPackage[]