(* Tests for: Lui`Parse`Score

   Author: danielb
*)

Test[
	Lui`Parse`Score[123]
	,
	1
	,
	TestID -> "Score-20161005-28WDHD"
]

Test[
	Lui`Parse`Score[Lui`Parse`Scored[Lui`Parse`Scored["expr", 0.9], 0.8]]
	,
	0.9
	,
	TestID -> "Score-20161005-IEI4S1"
]

Test[
	Lui`Parse`Score[
		HoldComplete[Lui`Parse`Scored[Lui`Parse`Scored[Print["SHOULD NOT PRINT"], 0.9]], 0.8]
	]
	,
	0.9
	,
	TestID -> "Score-20161005-JIUJ4B"
]