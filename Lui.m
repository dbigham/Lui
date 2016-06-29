BeginPackage["Lui`Lui`"]

Needs["CalculateParse`GeneralLibrary`"]; (* CreateReloadFunctionForDirectory, etc. *)

ReloadLui::usage = "ReloadLui  "; 

Begin["`Private`"]

With[{package = "Lui`"},
With[{dir = DirectoryName[DirectoryName[FindFile[package]]]},
	Lui`Private`$ReloadFunction = ReloadLui;
	CalculateParse`GeneralLibrary`TabsOrSpaces["Lui`"] = "Tabs";
	If [!ValueQ[$reloadLui],
		$reloadLui =
			CreateReloadFunctionForDirectory[
				DirectoryName[DirectoryName[FindFile[package]]]
			];
	];
	Lui`$UnitTestDir = FileNameJoin[{DirectoryName[DirectoryName[FindFile[package]]], "Tests"}];
	CalculateParse`Prototype`VirtualAssistant`Utility`NotebookTypeToDirectory["Lui`"] = FileNameJoin[{dir, "Notebooks"}];
];
];

(* Reloads .m files in this directory if they've changed. *)
ReloadLui[] := $reloadLui[]
If [ListQ[Global`$VaReloadFunctions],
	Global`$VaReloadFunctions =
		DeleteDuplicates[
			Append[Global`$VaReloadFunctions, ReloadLui]
		]
	];

End[]

EndPackage[]
