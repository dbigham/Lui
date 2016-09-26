BeginPackage["Lui`Actions`"]

Needs["JLink`"]
Needs["Lui`Lui`"];
Needs["WUtils`WUtils`"]

DefineLinguistic::usage = "DefineLinguistic  "

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
	"Linguistic" -> ""		(*< the default linguistic. *)
};
DefineLinguistic[OptionsPattern[]] :=
	DynamicModule[{input},
		
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
			Style["Define Linguistic", "Subsection"],
			With[{boxId = $addLinguisticBoxId},
				InputField[
					Dynamic[input],
					String,
					ImageSize -> {450, 100},
					FrameMargins -> Medium,
					BoxID -> boxId
				]
			],
			SmartButton[
				"OK",
				Print["TODO"]
			]
			}
		]
	];

End[]

EndPackage[]