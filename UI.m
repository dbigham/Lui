BeginPackage["Lui`UI`"]

Needs["JLink`"];
Needs["Lui`Lui`"];
Needs["Lui`Parse`"];
Needs["Lui`Util`"];
Needs["WUtils`WUtils`"];

Needs["JLink`"];

Lui::usage = "Lui  "

FocusLuiUI::usage = "FocusLuiUI  "

LuiJavaInit::usage = "LuiJavaInit  "

LuiMini::usage = "LuiMini  "

LuiMiniBoxes::usage = "LuiMiniBoxes  "

SelectedExpression::usage = "SelectedExpression  "

Begin["`Private`"]

(*!
	\function Lui
	
	\calltable
		Lui[] '' displays the LUI user interface.
	
	\maintainer danielb
*)
Lui[] :=
	DynamicModule[{input = "", interpHeldVar = NewHeldVar[], actionResHeldVar = NewHeldVar[]},
		
		$luiInputFieldBoxId = ToString[Unique["LuiInputFieldBoxID"]];
		
		SetHeldVar[interpHeldVar, Null];
		SetHeldVar[actionResHeldVar, Null];
		
		StartScheduledTask[
			CreateScheduledTask[
				FrontEnd`MoveCursorToInputField[
					InputNotebook[],
					$luiInputFieldBoxId
				],
				{0.3}
			]
		];
		
		With[{boxId = $luiInputFieldBoxId},
			Dynamic[
				interpHeldVar /. HoldComplete[interp_] :>
				(
				actionResHeldVar /. HoldComplete[actionResult_] :>
				(
					Column[
						{
						EventHandler[
							InputField[
								Dynamic[input],
								String,
								ImageSize -> {400, Automatic},
								(*ReturnEntersInput -> False,*)
								FrameMargins -> Medium,
								BoxID -> boxId
							],
							{
								"ReturnKeyDown" :>
								(
									HandleInput[input, interpHeldVar, actionResHeldVar]
								)
							}
						],
						displayIfNotNull[interp, formatInterpretation],
						With[{actionResult2 = actionResult},
							If [HoldComplete[actionResult2] =!= interp &&
								!MatchQ[
									actionResult,
									_NotebookObject
								],
								displayIfNotNull[actionResult]
								,
								Sequence @@ {}
							]
						]
						}
					]
				)
				)
			]
		]
	]

(*!
	\function HandleInput
	
	\calltable
		HandleInput[input, outHeldVar, actionResHeldVar] '' called when the user types in an input and presses ENTER.
	
	\related 'Lui
	
	\maintainer danielb
*)
HandleInput[input_, interpHeldVar_, actionResHeldVar_] :=
	Block[{interpretation, actionResult},
		
		If [StringTrim[input] === "",
			SetHeldVar[interpHeldVar, Null];
			SetHeldVar[actionResHeldVar, Null];
			Return[];
		];
		
		interpretation = LuiParse[input];
		
		SetHeldVar[interpHeldVar, interpretation];
		
		actionResult = ReleaseHold[interpretation];
		SetHeldVar[actionResHeldVar, actionResult];
		
		(*
		If [!MatchQ[interpretation, HoldComplete[_String] | $Failed],
			actionResult = ReleaseHold[interpretation];
			SetHeldVar[actionResHeldVar, actionResult];
			,
			SetHeldVar[actionResHeldVar, Null];
		];
		*)
	]

(*!
	\function formatInterpretation
	
	\calltable
		formatInterpretation[HoldComplete[interpretation]] '' formats the interpretation for display.
	
	\related '
	
	\maintainer danielb
*)
Clear[formatInterpretation];
formatInterpretation[HoldComplete[str_String]] := str
formatInterpretation[other_] := ToStringHeld[other]
	
(*!
	\function displayIfNotNull
	
	\calltable
		displayIfNotNull[] '' if the value is Null, then we return Sequence[], which when inserted into a Column[{...}] etc. causes it not to be displayed. Otherwise, we wrap the value in a frame to give it some padding.
	
	\related 'Lui
	
	\maintainer danielb
*)
displayIfNotNull[val_, formatFunc_:Identity] :=
	Block[{},
		If [val === Null,
			Sequence @@ {}
			,
			Framed[formatFunc[val], FrameMargins -> Medium, FrameStyle -> None]
		]
	]

(*!
	\function FocusLuiUI
	
	\calltable
		FocusLuiUI[] '' un-minimize the LUI notebook, bring it to the front, and put the keyboard focus into the text field.
	
	\related 'Lui
	
	\maintainer danielb
*)
FocusLuiUI[] :=
	Block[{nb},
		nb = Select[Notebooks[], FileNameTake[Quiet[NotebookFileName[#], NotebookFileName::nosv]] === "LuiUI.nb" &];
		If [nb =!= {},
			nb = First[nb];
			FrontEnd`MoveCursorToInputField[
				nb,
				$luiInputFieldBoxId
			]
			,
			nb = NotebookOpen[FileNameJoin[{LuiDir[], "Notebooks", "LuiUI.nb"}]];
			SelectionMove[First[Cells[nb]], All, Cell];
			FrontEndTokenExecute[nb, "EvaluateCells"];
		];
		
		SetSelectedNotebook[nb];
	]

(*!
	\function LuiJavaInit
	
	\calltable
		LuiJavaInit[] '' Java-relatedd initialize for Lui.

	- Configure the class path
	- Load the Lui class
	- Create a Lui Java object
	  - Creates a little HTTP server to enable Ctrl-Q for showing the UI (if C# app is also running)
	
	\maintainer danielb
*)
LuiJavaInit::javc = "The Lui Java class `1` couldn't be loaded.";
LuiJavaInit[] :=
	Module[{javaDir},
		InstallJava[];
		javaDir = FileNameJoin[{LuiDir[], "bin"}];
		Function[{classPathEntry},
			If [!MemberQ[JavaClassPath[], classPathEntry],
				With[{res = AddToClassPath[classPathEntry]},
					If [FailureQ[res],
						Print["AddToClassPath failed. Aborting LUI initialization."];
						Return[$Failed, Module];
					];
					If [MatchQ[res, _AddToClassPath],
						Print["JLink not loaded. Aborting LUI initialization."];
						Return[$Failed, Module]
					];
				];
			];
		] /@
			{
				javaDir,
				FileNameJoin[{LuiDir[], "Jars"}]
			};
		Function[{class},
			If [!MatchQ[LoadJavaClass[class], _JavaClass],
				Message[LuiJavaInit::javc, class];
				Return[$Failed];
			];
		] /@
			{
				"com.danielbigham.lui.Lui",
				"com.danielbigham.lui.Grammar",
				"com.danielbigham.lui.ChartParser"
			};
		If [JavaObjectQ[$luiJavaObject],
			$luiJavaObject@stop[];
			ReleaseJavaObject[$luiJavaObject];
		];
		$luiJavaObject = JavaNew["com.danielbigham.lui.Lui"];
		$luiJavaInitDone = True;
	]
	
(*!
	\function LuiMini
	
	\calltable
		LuiMini[] '' Displays a small UI for Lui that can be accessed via a hotkey.
	
	\related 'Lui
	
	\maintainer danielb
*)
Clear[LuiMini];
Options[LuiMini] =
{
	"DefaultInput" -> None,				(*< The input that should be present in the UI when it is created. *)
	"Notebook" -> Automatic,			(*< The notebook to insert the UI into. *)
	"NotebookWriteAfterAll" -> After	(*< Insert UI: 1) After: After current location in notebook? 2) All: Replace selection *)
};
LuiMini[OptionsPattern[]] :=
	Module[{selectedExpression, defaultInput = OptionValue["DefaultInput"], boxes, boxDetails,
			notebook = InputNotebook[]},
		
		If [OptionValue["Notebook"] =!= Automatic,
			notebook = OptionValue["Notebook"];
		];
		
		$miniInput = Null;
		$miniOutput = "";
		
		selectedExpression = SelectedExpression[];
		
		If [selectedExpression =!= None,
			(* If something is selected, move to the next cell so that
			   the VA UI is in the next cell, rather than replacing
			   the selection. *)
			SelectionMove[InputNotebook[], Next, Cell];
			
			advancePastOutputCells[];
		];
		
		If [defaultInput === None,
			If [MatchQ[selectedExpression, HoldComplete[_Symbol] | _Symbol] &&
				!MatchQ[selectedExpression, None | $Failed],
				defaultInput = ToString[ReleaseHold[selectedExpression]];
			];
			
			If [MatchQ[selectedExpression, HoldComplete[_String] | _String],
				defaultInput = ReleaseHold[selectedExpression];
			];
			
			If [defaultInput =!= None,
				StartScheduledTask[
					CreateScheduledTask[
						FrontEndTokenExecute[EvaluationNotebook[], "HandleShiftReturn"],
						{0.15}
					]
				]
			];
		];
		
		{boxes, boxDetails} = LuiMiniBoxes[defaultInput];
		
		NotebookWrite[
			notebook,
			boxes,
			OptionValue["NotebookWriteAfterAll"]
		];
		
		If [!MatchQ[selectedExpression, HoldComplete[_String]],
			FrontEndTokenExecute[InputNotebook[], "Tab"];
			FrontEndTokenExecute[InputNotebook[], "Tab"];
		];
		
		$miniOutput
	]

(*!
	\function SelectedExpression
	
	\calltable
		SelectedExpression[] '' returns the expression current selected in the current notebook, held, or $Failed if none. If the selection can't be turned into an expression, it is returned as a string.
	
	\maintainer danielb
*)
SelectedExpression[] :=
	Module[{selection, selectedString},
		selection = CurrentValue[NotebookSelection[], "SelectionData"];
		If [selection === $Failed,
			None
			,
			selectedString = ToString[selection];
			With[{e = Quiet[Check[ToExpression[selectedString, StandardForm, HoldComplete], HoldComplete[$Failed]]]},
				If [e === HoldComplete[$Failed],
					(* If the selected string can't be turned into an expression, then
					   treat it as a raw string. *)
					selectedString
					,
					e
				]
			]
		]
	]

(*!
	\function advancePastOutputCells
	
	\calltable
		advancePastOutputCells[] '' advance the current cell past any output cells.
	
	\maintainer danielb
*)
advancePastOutputCells[] :=
	Module[{selectedCells, cellType, iter = 0},
		(* Protect against infinite loop.
		   For example, if the below code were to use
		   Print to output some debug output, it creates
		   an infinite loop. *)
		While[iter < 100,
			++iter;
			selectedCells = SelectedCells[];
			If [selectedCells === {},
				Break[];
				,
				cellType = NotebookRead[selectedCells[[1]]][[2]];
				If [!MatchQ[cellType, "Output" | "Print"],
					(* Move back to the gap above this cell, since we've
					   probably gotten to an input cell, etc. *)
					SelectionMove[InputNotebook[], Before, Cell];
					Break[];
					,
					(* Skip over output cells. *)
					SelectionMove[InputNotebook[], Next, Cell];
				];
			]
		];
	]

With[{
$icon =
RawBoxes[ToBoxes[
Uncompress["1:eJxTTMoPSmNhYGAoZgUSnrmJ6alpTCAuB5AISix3LCpKrAwWAHJC84oz0/NSUzzzSlLTU4sskpiBgtJQDDLh////gxafvP/J9tDtDy70sCt35Z1FTVsf9vz5+4+J\
WmY+fvdDAZufXCdeuuDYd/H//pvvPbDJk+MGkPuBZl4B4Vsvv2mCxLymXD4NsgeEYX5Dsv/K9IPPSsmxa8LeJzUwc2F2QvF/XJhKdhGFV515FU9OfK099zrWuZ/2dkH\
tuUSqv0BhjC3NoGNovBMVL4Tsg2FQ+iEi7aHoB6bD/7gAMAz+YwtrYvIgcrom167UJbfWvPnyS4RQWD55/0PWbeIlcsMP5jZNYtIFPe2iVxjSK21AywmqpnlQmYXNrm\
N3P9rD2NTKy6C4Jybe6FVGIYXpQNhF0zqFnnUltjYAcpqhZhsAn3+p3bbBhenZZhsqOBjU0HaqLIE20kG8oNKc1GIuIMM5Pye/KLggMTk1GNQ0D3J3QlPEA2rhA1vvR\
TmpiWWZeelgmZCi0lQAs2NaIg=="]
]] 
},

Clear[LuiMiniBoxes];
LuiMiniBoxes[defaultInput_:None] :=
	Module[{boxes, boxId = ToString[Unique["LuiBoxId"]] <> StringJoin[ToString /@ Date[]]},
		
		boxes =
		ToBoxes[
			System`DynamicNamespace[
				"Lui",
				DynamicModule[{query},
					
					If [defaultInput =!= None,
						query = defaultInput;
					];
					
					Dynamic[
						EventHandler[
							Grid[
								{
									{
										Framed[#, FrameStyle -> None, FrameMargins -> {{-3, -10}, {0, 0}}] & @
										EventHandler[
											$icon,
											"MouseDown" :>
											(
											deleteLuiMiniUiAndOutput[boxId];
											)
										]
										,
										InputField[
											Dynamic[query],
											String,
											ImageSize ->
											{
												(* So that the InputField occupies the full
												   width of the notebook so that if a user
												   clicks away from the virtual assistant,
												   they can click anywhere in the horizontal
												   space to the right of the spikey and end
												   up back in the InputField. *)
												Full,
												Automatic
											},
											(* FieldSize -> {{1,40}, {1,Infinity}}, *)
											FrameMargins -> Medium,
											Appearance -> "Frameless",
											BoxID -> boxId,
											System`TrapSelection -> True
										]
									}
								},
								Alignment -> Left
							]
							,
								"ReturnKeyDown" :>
								(
									(* Some dummy code that is here so that it can be looked for
									   to tell whether they user's cursor is inside of a UI
									   when Ctrl-E/Command-E is pressed. *)
									{"LuiMiniUserInterfaceFindableTag"};
								
									(* Treat ENTER the same as SHIFT-ENTER *)
									FrontEndTokenExecute[EvaluationNotebook[], "HandleShiftReturn"]
								)
						]
					]
				],
				BaseStyle -> {Deployed -> True},
				Editable -> False,
				DeleteWithContents -> True,
				SelectWithContents -> True
			]
		];
		
		{
			boxes,
			{
				(* Not currently used. Whoops, we need something like this for
				   Va[] instead, not the mini assistant. *)
			   "BoxId" -> boxId
			}
		}
	]
	
] (* end With *)
	
(*!
	\function deleteLuiMiniUiAndOutput
	
	\calltable
		deleteLuiMiniUiAndOutput[boxId] '' deletes the mini Lui UI as well as any output cells that follow it. Called when the blue spikey is clicked. A convenient way to dismiss output.
	
	\maintainer danielb
*)
Clear[deleteLuiMiniUiAndOutput];
deleteLuiMiniUiAndOutput[boxId_] :=
	Module[{},
		FrontEnd`MoveCursorToInputField[InputNotebook[], boxId];
		With[{selectedCells = SelectedCells[]},
			If [Length[selectedCells] === 1,
				
				(* Delete any VA output. *)
				SelectionMove[InputNotebook[], Next, Cell];
				deleteOutputCells[];
				
				(* And delete the VA mini UI. *)
				NotebookDelete[selectedCells[[1]]];
			]
		]
	]

(*!
	\function deleteOutputCells
	
	\calltable
		deleteOutputCells[] '' delete any output cells that follow the current position.
	
	\maintainer danielb
*)
deleteOutputCells[] :=
	Module[{selectedCells, cellType, iter = 0},
		(* Protect against infinite loop.
		   For example, if the below code were to use
		   Print to output some debug output, it creates
		   an infinite loop. *)
		While[iter < 100,
			++iter;
			selectedCells = SelectedCells[];
			If [selectedCells === {},
				Break[];
				,
				cellType = NotebookRead[selectedCells[[1]]][[2]];
				If [!MatchQ[cellType, "Output" | "Print"],
					(* Move back to the gap above this cell, since we've
					   probably gotten to an input cell, etc. *)
					SelectionMove[InputNotebook[], Before, Cell];
					Break[];
					,
					(* Skip over output cells. *)
					NotebookDelete[selectedCells[[1]]];
					SelectionMove[InputNotebook[], Next, Cell];
				];
			]
		];
	]
	
Unprotect[NamespaceBox];

NamespaceBox /: 
	MakeExpression[NamespaceBox["Lui", theboxes_, ___], fmt_] :=
		Module[{interpHeldVar = NewHeldVar[], actionResHeldVar = NewHeldVar[]},
			
			(* Sometimes I was getting a message about Part, but not always.
			   Will use this If statement for now to try and avoid that. *)
			With[{input = If [MatchQ[theboxes[[1, 1]], _List], theboxes[[1, 1, 1, 2]], theboxes[[1, 1, 2]]]},
				With[{res =
						(
						ReloadLui[];
						
						SetHeldVar[interpHeldVar, Null];
						SetHeldVar[actionResHeldVar, Null];
						
						Block[{$MiniUIInUse = True},
							HandleInput[input, interpHeldVar, actionResHeldVar];
						];
						
						XPrint["Interpretation: ", ReleaseHold[interpHeldVar]];
						If [ReleaseHold[interpHeldVar] === HoldComplete["?"],
							"?"
							,
							XPrint["Action evaluated: ", ReleaseHold[actionResHeldVar]];
							ReleaseHold[actionResHeldVar]
						]
						)
					  },
					HoldComplete[res]
				]
			]
		]
		
(*!
	\function installHotkey
	
	\calltable
		installHotkey[] '' installs the hotkey that can be used to access the Lui from a notebook.
	
	\maintainer danielb
*)
installHotkey[] :=
	Module[{keyModifiers},
		
		If [TrueQ[MacOS[]],
			keyModifiers = {"Command"};
			,
			keyModifiers = {"Control"};
		];
		
		With[{keyModifiers = keyModifiers},
			Block[
				{Item},
				(
					Attributes[Item] = {HoldRest};
					MathLink`CallFrontEnd[
						{
							FrontEnd`AddMenuCommands[
								"CellMerge",
								{
									Item[
										"LUI (Linguistic UI)",
										FrontEnd`KernelExecute[
											ReloadLui[];
											LuiMini[]
										],
										FrontEnd`MenuKey["e", FrontEnd`Modifiers -> keyModifiers],
										"MenuEvaluator" -> Automatic
									]
								}
							]
						}
					]
				)
			]
		];
	]

If [!TrueQ[$hotkeyInstalled],
	$hotkeyInstalled = True;
	installHotkey[];
];

If [!TrueQ[$luiJavaInitDone],
	LuiJavaInit[];
];

End[]

EndPackage[]

(*!
	\function MyFunc
	
	\calltable
		MyFunc[] '' desc
	
	\related '
	
	\maintainer danielb
*)
MyFunc[] :=
	Block[{},
		1
	]