BeginPackage["Lui`Util`"]

NewHeldVar::usage = "NewHeldVar  "

SetHeldVar::usage = "SetHeldVar  "

ToStringHeld::usage = "ToStringHeld  "

LuiDir::usage = "LuiDir  "

Begin["`Private`"]

(*!
    \function NewHeldVar
    
    \calltable
        NewHeldVar[] '' returns a new symbol that is held. This is useful because it can be passed between function like a 'reference', whos value can be set or gotten.
    
    \related 'SetHeldVar
    
    \maintainer danielb
*)
NewHeldVar[] :=
    (* We don't just use unique, we also use the current timestamp
       to lessen the likelihood of collisions. For example, if someone
       emailed you a notebook with dynamic modules that contained instances
       of these held variables that collided with ones used by dynamic modules
       in other notebooks currently open. *)
    With[{sym = Unique["luiHeldVar" <> ToString[Ceiling[AbsoluteTime[]]]]},
    	HoldComplete[sym]
    ]

(*!
    \function SetHeldVar
    
    \calltable
        SetHeldVar[HoldComplete[symbol_], value] '' sets the value of the symbol to the given value.
    
    \related 'NewHeldVar
    
    \maintainer danielb
*)
SetHeldVar[heldVar_HoldComplete, value_] :=
    heldVar /. HoldComplete[symbol_] :> (symbol = value)

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