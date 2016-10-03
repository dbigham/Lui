BeginPackage["Lui`Lui`"]

Needs["JLink`"]

Needs["WUtils`WUtils`"]; (* CreateReloadFunctionForDirectory, etc. *)

ReloadLui::usage = "ReloadLui  "

$LuiJavaPath::usage = "$LuiJavaPath  "

$LuiDir::usage = "$LuiDir  "; 

$Grammar::usage = "$Grammar  "

Begin["`Private`"]

$LuiDir = FileNameDrop[FindFile["Lui`Lui`"], -1];
$LuiJavaPath = FileNameJoin[{$LuiDir, "bin"}];

With[{package = "Lui`"},
With[{dir = DirectoryName[DirectoryName[FindFile[package]]]},
	Lui`Private`$ReloadFunction = ReloadLui;
	WUtils`WUtils`TabsOrSpaces[package] = "Tabs";
	If [!ValueQ[$reloadLui],
		$reloadLui =
			CreateReloadFunctionForDirectory[
				DirectoryName[DirectoryName[FindFile[package]]]
			];
	];
	Lui`$UnitTestDir = FileNameJoin[{DirectoryName[DirectoryName[FindFile[package]]], "Tests"}];
	WUtils`WUtils`NotebookTypeToDirectory[package] = FileNameJoin[{dir, "Notebooks"}];
];
];

(* Reloads .m files in this directory if they've changed. *)
ReloadLui[] := $reloadLui[]
If [!ListQ[Global`$ReloadFunctions], Global`$ReloadFunctions = {}];
Global`$ReloadFunctions =
	DeleteDuplicates[
		Append[Global`$ReloadFunctions, ReloadLui]
	]

End[]

EndPackage[]
