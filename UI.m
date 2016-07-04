BeginPackage["Lui`UI`"]

Needs["Lui`Parse`"];
Needs["Lui`Util`"];

Needs["JLink`"];

Lui::usage = "Lui  "

FocusLuiUI::usage = "FocusLuiUI  "

LuiJavaInit::usage = "LuiJavaInit  "

Begin["`Private`"]

(*!
    \function Lui
    
    \calltable
        Lui[] '' displays the LUI user interface.
    
    \maintainer danielb
*)
Lui[] :=
    DynamicModule[{input = "", interpHeldVar = NewHeldVar[], actionResHeldVar = NewHeldVar[]},
    	
    	If [!TrueQ[$luiJavaInitDone],
    		LuiJavaInit[];
    	];
    	
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
	                    displayIfNotNull[interp],
	                    displayIfNotNull[actionResult]
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
        
        SetHeldVar[interpHeldVar, formatInterpretation[interpretation]];
        
        If [!MatchQ[interpretation, HoldComplete[_String] | $Failed],
            actionResult = ReleaseHold[interpretation];
            SetHeldVar[actionResHeldVar, actionResult];
            ,
            SetHeldVar[actionResHeldVar, Null];
        ];
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
displayIfNotNull[val_] :=
    Block[{},
        If [val === Null,
        	Sequence @@ {}
        	,
        	Framed[val, FrameMargins -> Medium, FrameStyle -> None]
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
        nb = Select[Notebooks[], FileNameTake[Quiet[NotebookFileName[#], NotebookFileName::nosv]] === "Lui.nb" &];
        If [nb =!= {},
        	nb = First[nb];
			FrontEnd`MoveCursorToInputField[
			    nb,
			    $luiInputFieldBoxId
			]
        	,
        	nb = NotebookOpen[FileNameJoin[{LuiDir[], "Notebooks", "Lui.nb"}]];
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
LuiJavaInit::javc = "The Lui Java class couldn't be loaded.";
LuiJavaInit[] :=
    Block[{javaDir},
    	javaDir = FileNameJoin[{LuiDir[], "bin"}];
        If [!MemberQ[JavaClassPath[], javaDir],
            AddToClassPath[javaDir];
        ];
        If [!MatchQ[LoadJavaClass["com.danielbigham.lui.Lui"], _JavaClass],
        	Message[LuiJavaInit::javc];
        	Return[$Failed];
        ];
        If [JavaObjectQ[$luiJavaObject],
        	$luiJavaObject@stop[];
        	ReleaseJavaObject[$luiJavaObject];
        ];
        $luiJavaObject = JavaNew["com.danielbigham.lui.Lui"];
        $luiJavaInitDone = True;
    ]

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