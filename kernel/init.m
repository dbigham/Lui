If [$Context =!= "Global`",
    Print["WARNING: Lui's init.m seems to have been run when $Context is not Global`."];
    Print["Rather, it is: ", $Context];
];

Get["Lui`Lui`"];

WUtils`WUtils`ReloadFiles[];

Needs["Lui`Util`"];
Needs["Lui`Actions`"];
Needs["Lui`Parse`"];
Needs["Lui`UI`"];

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

InitializeParser[];

Lui`UI`Lui[]