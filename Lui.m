BeginPackage["Lui`Lui`"]

Needs["WUtils`WUtils`"]; (* CreateReloadFunctionForDirectory, etc. *)

ReloadLui::usage = "ReloadLui  "; 

Begin["`Private`"]

With[{package = "Lui`"},
With[{dir = DirectoryName[DirectoryName[FindFile[package]]]},
	Lui`Private`$ReloadFunction = ReloadLui;
	WUtils`WUtils`TabsOrSpaces["Lui`"] = "Tabs";
	If [!ValueQ[$reloadLui],
		$reloadLui =
			CreateReloadFunctionForDirectory[
				DirectoryName[DirectoryName[FindFile[package]]]
			];
	];
	Lui`$UnitTestDir = FileNameJoin[{DirectoryName[DirectoryName[FindFile[package]]], "Tests"}];
	WUtils`WUtils`NotebookTypeToDirectory["Lui`"] = FileNameJoin[{dir, "Notebooks"}];
];
];

(* Reloads .m files in this directory if they've changed. *)
ReloadLui[] := $reloadLui[]
If [ListQ[Global`$ReloadFunctions],
	Global`$ReloadFunctions =
		DeleteDuplicates[
			Append[Global`$ReloadFunctions, ReloadLui]
		]
	];

End[]

EndPackage[]
