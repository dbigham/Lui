BeginPackage["Lui`Parse`"]

LuiParse::usage = "LuiParse  "

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