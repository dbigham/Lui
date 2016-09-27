BeginPackage["Lui`Util`"]

Needs["WUtils`WUtils`"];

ToStringHeld::usage = "ToStringHeld  "

LuiDir::usage = "LuiDir  "

FileNameToDefaultLinguistic::usage = "FileNameToDefaultLinguistic  "

SplitLinguisticAndAction::usage = "SplitLinguisticAndAction  "

SplitLinguisticAndExpression::usage = "SplitLinguisticAndExpression  "

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

End[]

EndPackage[]