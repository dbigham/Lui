If [$Context =!= "Global`",
    Print["WARNING: Lui's init.m seems to have been run when $Context is not Global`."];
    Print["Rather, it is: ", $Context];
];

(* WUtils` shares many symbols with Utility` when used within Wolfram Research, so we make sure
   to avoid shadowing messages by temporarily removing Utility` from the context path if it
   exists, and being sure not to keep WUtils` on the context path after loading it. *)
Block[{$ContextPath},
    $ContextPath = DeleteCases[$ContextPath, "Utility`"];
    << WUtils`;
]

If [!FailureQ[FindFile["DevTools`"]],
    Needs["DevTools`"];
];

(* Allow external systems to setup some code that gets run each time we do a Get["Lui`"]. *)
If [DownValues[Lui`CustomReload] =!= {},
    Lui`CustomReload[];
];

If [DownValues[Lui`CustomReload2] =!= {},
    Lui`CustomReload2[];
];

Get["Lui`Lui`"];

WUtils`WUtils`ReloadFiles[];

Needs["Lui`Util`"];
Needs["Lui`Actions`"];
Needs["Lui`Parse`"];
Needs["Lui`UI`"];

InitializeParser[];

Lui`UI`Lui[]