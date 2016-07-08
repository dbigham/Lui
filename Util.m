BeginPackage["Lui`Util`"]

NewHeldVar::usage = "NewHeldVar  "

SetHeldVar::usage = "SetHeldVar  "

ToStringHeld::usage = "ToStringHeld  "

LuiDir::usage = "LuiDir  "

Begin["`Private`"]

(*!
    \function ToStringHeld
    
    \calltable
        ToStringHeld[HoldComplete[expr_]] '' renders the inner expression as InputForm.
    
    \maintainer danielb
*)
Attributes[ToStringHeld] = {HoldFirst};
ToStringHeld[heldExpr_HoldComplete] := StringTake[ToString[heldExpr, InputForm], {14, -2}]
ToStringHeld[heldExpr_Hold] := StringTake[ToString[heldExpr, InputForm], {6, -2}]

(*!
    \function LuiDir
    
    \calltable
        LuiDir[] '' returns the base Lui directory.
    
    \maintainer danielb
*)
LuiDir[] :=
    Block[{},
        FileNameDrop[FindFile["Lui`"], -2]
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