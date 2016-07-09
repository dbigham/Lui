(* Tests for: Lui`Parse`Private`permuteBindings

   Author: danielb
*)

Test[
	Lui`Parse`Private`permuteBindings[
		{
			HoldComplete[a] -> {HoldComplete[1], HoldComplete[2], HoldComplete[3]},
			HoldComplete[b] -> {HoldComplete[4], HoldComplete[5]}
		}
	]
	,
	{{1, 4}, {1, 5}, {2, 4}, {2, 5}, {3, 4}, {3, 5}}
	,
	TestID -> "permuteBindings-20160709-CPAY55"
]