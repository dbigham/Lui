BeginPackage["Lui`Util`"]

Needs["WUtils`WUtils`"];

ToStringHeld::usage = "ToStringHeld  "

LuiDir::usage = "LuiDir  "

FileNameToDefaultLinguistic::usage = "FileNameToDefaultLinguistic  "

SplitLinguisticAndAction::usage = "SplitLinguisticAndAction  "

SplitLinguisticAndExpression::usage = "SplitLinguisticAndExpression  "

ConvertOldLinguistic::usage = "ConvertOldLinguistic  "

FilterOldLinguistics::usage = "FilterOldLinguistics  "

FilterOldLinguistic::usage = "FilterOldLinguistic  "

ConvertOldLinguisticDefinition::usage = "ConvertOldLinguisticDefinition  "

ConvertOldLinguisticDefinitions::usage = "ConvertOldLinguisticDefinitions  "

Begin["`Private`"]

(*!
    \function ToStringHeld
    
    \calltable
        ToStringHeld[HoldComplete[expr_]] '' renders the inner expression as InputForm.
    
    \maintainer danielb
*)
Attributes[ToStringHeld] = {HoldFirst};
ToStringHeld[heldExpr_HoldComplete] := StringTake[ToString[heldExpr, InputForm], {14, -2}]
ToStringHeld[heldExpr_Hold] := StringTake[ToString[heldExpr, InputForm], {6, -2}]

(*!
    \function LuiDir
    
    \calltable
        LuiDir[] '' returns the base Lui directory.
    
    \maintainer danielb
*)
LuiDir[] :=
    Block[{},
        FileNameDrop[FindFile["Lui`"], -2]
    ]

(*!
	\function FileNameToDefaultLinguistic
	
	\calltable
		FileNameToDefaultLinguistic[file] '' given a filename, which for example may be camel case, returns a default linguistic to use for the file.

	Examples:
	
	FileNameToDefaultLinguistic["JustTestingABC.nb"] === "just testing abc"

	Unit tests:

	RunUnitTests[Lui`Util`FileNameToDefaultLinguistic]

	\maintainer danielb
*)
FileNameToDefaultLinguistic[file_] :=
	Block[{},
		ToLowerCase[DeCamelCase[FileBaseName[file]]]
	];

(*!
	\function SplitLinguisticAndExpression
	
	\calltable
		SplitLinguisticAndExpression[str] '' splits a linguistic and action into it's two parts.

	Examples:
	
	SplitLinguisticAndExpression["my linguistic -> \"My Expression\""] === {"my linguistic", "\"My Expression\""}

	Unit tests:

	RunUnitTests[Lui`Util`SplitLinguisticAndExpression]

	\maintainer danielb
*)
SplitLinguisticAndExpression[str_] :=
	Block[{pattern, expression = Null},
		pattern =
			StringReplace[
				str,
				Longest[pre__] ~~ "->" ~~ expr__ :>
					(
						expression = StringTrim[expr];
						StringTrim[pre]
					)
			];
		{pattern, expression}
	];

(*!
	\function ConvertOldLinguistic
	
	\calltable
		ConvertOldLinguistic[ling] '' converts a linguistic from the old format to the new format.

	Examples:
	
	ConvertOldLinguistic["testing"] === "testing"

	Unit tests:

	RunUnitTests[Lui`Util`ConvertOldLinguistic]

	\maintainer danielb
*)
Clear[ConvertOldLinguistic];
Clear[convertOldLinguisticInner];

ConvertOldLinguistic[ling_] := convertOldLinguisticInner[ling]

ConvertOldLinguistic[(RuleDelayed|Rule)[lhs_, rhs_]] :=
	With[{action = Indent2[HoldComplete[rhs], 0, 4, "RemoveHold" -> True, "UseTabs" -> True],
		  pattern = ConvertOldLinguistic[lhs]},
		  
		pattern <>
			If [StringLength[action] < 20 &&
				StringFreeQ[action, "\n"] &&
				StringLength[pattern] < 40,
				
				" -> " <> action
				,
				"\n" <> Indent2[HoldComplete[rhs], 1, 4, "RemoveHold" -> True, "UseTabs" -> True]
			]
	]

ConvertOldLinguistic[ling_Alternatives] :=
	StringJoin[Riffle[convertOldLinguisticInner /@ (List@@ling), " | "]]
	
ConvertOldLinguistic[ling_Global`FO] :=
	StringJoin[Riffle[convertOldLinguisticInner /@ (List@@ling), " "]]
	
convertOldLinguisticInner[ling_Alternatives] :=
	"(" <> StringJoin[Riffle[convertOldLinguisticInner /@ (List@@ling), " | "]] <> ")"

convertOldLinguisticInner[ling_String] :=
	Block[{},
		Which[
			StringMatchQ[ling, LetterCharacter.. | DigitCharacter..],
			ling
			,
			StringMatchQ[ling, ("$" ~~ __)],
			"~" <> StringTake[ling, {2, -1}]
			,
			True,
			ToString[ling, InputForm]
		]
	];

convertOldLinguisticInner[ling_Global`FO] :=
	"(" <> StringJoin[Riffle[convertOldLinguisticInner /@ (List@@ling), " "]] <> ")"

convertOldLinguisticInner[ling_Global`sym] :=
	With[{str = First[ling]},
		"~" <> StringTake[str, {2, -1}]
	]

convertOldLinguisticInner[(Global`op|Global`opt)[ling_]] :=
	convertOldLinguisticInner[ling] <> "?"

convertOldLinguisticInner[ling_Global`AO] :=
	With[
		{
			res =
			ConvertOldLinguistic[
				Alternatives @@
				(
					Global`FO @@@
						Permutations[List @@ ling]
				)
			]
		},
		
		If [StringLength[res] > 200,
			"\"PATTERN_TOO_LARGE\""
			,
			res
		]
	]
(*!
	\function FilterOldLinguistics
	
	\calltable
		FilterOldLinguistics[list] '' removes items from the list that correspond to notebooks that no longer exist, etc.

	Examples:
	
	FilterOldLinguistics[
		{
			"just testing" -> NotebookFileName[],
			"just testing" :> "C:\\Temp\\Lsdlkfjd.nb",
			"just testing" :> "Todo.nb"
		}
	]

	===

	{
		"just testing" ->
			"E:\\Users\\Daniel\\Dropbox\\Notebooks\\FilterOldLinguistics\\FilterOldLinguistics.nb",
		"just testing" :> "Todo.nb"
	}

	Unit tests:

	RunUnitTests[Lui`Util`FilterOldLinguistics]

	\maintainer danielb
*)
FilterOldLinguistics[list_] := FilterOldLinguistic /@ list

(*!
	\function FilterOldLinguistic
	
	\calltable
		FilterOldLinguistic[ling] '' returns the linguistic if we should keep it, or Sequence[] if not.

	Examples:
	
	FilterOldLinguistic["just testing" :> 123] === "just testing" :> 123

	Unit tests:

	RunUnitTests[Lui`Util`FilterOldLinguistic]

	\maintainer danielb
*)
Clear[FilterOldLinguistic];
FilterOldLinguistic[ling:(Rule|RuleDelayed)[_, action_String]] :=
	Block[{keep = True},
		If [!StringFreeQ[action, "\\"],
			keep = FileExistsQ[action];
			,
			keep = ResolveIssueNotebook[action] =!= $Failed;
		];
		If [keep,
			ling
			,
			Sequence @@ {}
		]
	]

FilterOldLinguistic[ling_] := ling

(*!
	\function ConvertOldLinguisticDefinition
	
	\calltable
		ConvertOldLinguisticDefinition[ling] '' converts an old linguistic definition to the new format.

	Examples:
	
	ConvertOldLinguisticDefinition[
		"$bb" -> {"bb" | "blackberry" | "black berry" :> "BlackBerry"}
	]

	===

	"~bb:\n\tbb | blackberry | \"black berry\" -> \"BlackBerry\""

	Unit tests:

	RunUnitTests[Lui`Util`ConvertOldLinguisticDefinition]

	\maintainer danielb
*)
ConvertOldLinguisticDefinition[ling_] :=
	Block[{symbol = ling[[1]], patterns = ling[[2]]},
		"~" <> StringTake[symbol, {2, -1}] <> ":\n\t" <>
			StringJoin[
				Riffle[
					StringReplace[ConvertOldLinguistic /@ patterns, "\n\t" :> "\n\t\t"],
					"\n\t"
				]
			]
	];

(*!
	\function ConvertOldLinguisticDefinitions
	
	\calltable
		ConvertOldLinguisticDefinitions[list] '' converts old linguistic definitions to the new format.

	Examples:
	
	ConvertOldLinguisticDefinitions[
		{
			"$curt" -> {("curt" | "curtis") | FO["curt" | "curtis", "beattie"] :> "CurtisBeattie"},
			"$login" -> {"login" | "username" | "user name" | "password" | "account"},
			"$bb" -> {"bb" | "blackberry" | "black berry" :> "BlackBerry"},
			"$bb10" -> {FO[sym["$bb"], "10"] :> "BlackBerry10"}
		}
	]

	===

	"~curt:\n\t(curt | curtis) | ((curt | curtis) beattie)\n\t\t\"CurtisBeattie\"\n~login:\n\tlogin | username | \"user name\" | password | account\n~bb:\n\tbb | blackberry | \"black berry\" -> \"BlackBerry\"\n~bb10:\n\t~bb 10 -> \"BlackBerry10\""

	Unit tests:

	RunUnitTests[Lui`Util`ConvertOldLinguisticDefinitions]

	\maintainer danielb
*)
ConvertOldLinguisticDefinitions[list_] :=
	StringJoin[Riffle[ConvertOldLinguisticDefinition /@ list, "\n"]]

End[]

EndPackage[]