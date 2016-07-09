BeginPackage["Lui`Parse`"]

Needs["JLink`"]

LuiParse::usage = "LuiParse  "

CreateGrammar::usage = "CreateGrammar  "

Grammar::usage = "Grammar  "

Begin["`Private`"]

(*!
    \function LuiParse
    
    \calltable
        LuiParse[] '' desc
    
    \related '
    
    \maintainer danielb
*)
LuiParse[input_String] :=
    Block[{},
        Switch[
        	input,
        	
        	"time",
        	HoldComplete[Date[]]
        	,
        	"spacex reddit",
        	HoldComplete[SystemOpen["https://www.reddit.com/r/spacex/"]]
        	,
        	"hello",
        	HoldComplete["Hello, world!"]
        	,
        	_,
        	HoldComplete["?"]
        ]
    ]

(*!
	\function CreateGrammar
	
	\calltable
		CreateGrammar[name, grammarRules] '' creates a grammar.

	Examples:
	
	CreateGrammar[name, grammarRules] === TODO
	
	\related '
	
	\maintainer danielb
*)
CreateGrammar::fcj = "Failed to create Grammar Java object.";
CreateGrammar[name_, grammarRules_] :=
	Block[{javaObject},
		javaObject = JavaNew["com.danielbigham.lui.Grammar", grammarRules];
		If [!JavaObjectQ[javaObject],
			Message[CreateGrammar::fcj];
			Return[$Failed];
		];
		Grammar[
			javaObject
		]
	];

Format[g_Grammar] :=
	Block[{},
		Framed[
			formatKeyValues[
				<|
					"Rules" -> g[[1]]@getRuleCount[]
				|>
			],
			FrameMargins -> 20,
			FrameStyle -> GrayLevel[0.7]
		]
	]

(*!
	\function formatKeyValues
	
	\calltable
		formatKeyValues[assoc] '' formats an association of key/value pairs.

	Examples:
	
	formatKeyValues[Association["Items" -> 7, "Price" -> "$43.23"]]

	===

	Style[
		Grid[
			{
				{Style["Items:", FontColor -> GrayLevel[0.5]], 7},
				{Style["Price:", FontColor -> GrayLevel[0.5]], "$43.23"}
			},
			Alignment -> Left,
			Spacings -> {0.5, 0.5}
		],
		FontFamily -> "Arial"
	]

	Unit tests:

	RunUnitTests[Lui`Parse`Private`formatKeyValues]

	\maintainer danielb
*)
formatKeyValues[assoc_Association] :=
	Block[{items},
		
		items = Transpose[{Style[# <> ":", FontColor -> Gray] & /@ Keys[assoc], Values[assoc]}];
		
		Style[
			Grid[
				items,
				Alignment -> Left,
				Spacings -> {0.5, 0.5}
			],
			FontFamily -> "Arial"
		]
	];

End[]

EndPackage[]