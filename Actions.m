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
									"org.antlr.v4.runtime.misc.ParseCancellationException" |
									"java.lang.Exception"
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
						expression,
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

End[]

EndPackage[]