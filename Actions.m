BeginPackage["Lui`Actions`"]

Needs["JLink`"]
Needs["Lui`Lui`"];
Needs["WUtils`WUtils`"]

AddLinguistic::usage = "AddLinguistic  "

Begin["`Private`"]

(*!
	\function AddLinguistic
	
	\calltable
		AddLinguistic[] '' adds a linguistic.
	
	\maintainer danielb
*)
AddLinguistic[] :=
	Block[{input},
		
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
		
		Column[
			{
			Style["Add Linguistic", "Subsection"],
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