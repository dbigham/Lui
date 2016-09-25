(* Tests for: Lui`Parse`Private`evaluateAction

   Author: danielb
*)

Test[
	Lui`Parse`Private`evaluateAction[
		HoldComplete[a + b],
		{
			HoldComplete[a] -> {HoldComplete[1], HoldComplete[2]},
			HoldComplete[b] -> {HoldComplete[3], HoldComplete[5]}
		}
	]
	,
	Lui`Parse`PossibleExpressions[4, 6, 5, 7]
	,
	TestID -> "evaluateAction-20160709-K0PISL"
]

Test[
	Block[
		{a = 1, b = 0, c = 99},
		Lui`Parse`Private`evaluateAction[
			HoldComplete[a + b + c],
			{
				HoldComplete[a] -> {HoldComplete[1], HoldComplete[2]},
				HoldComplete[b] -> {HoldComplete[3], HoldComplete[5]},
				HoldComplete[c] -> {HoldComplete[7], HoldComplete[9]}
			}
		]
	]
	,
	Lui`Parse`PossibleExpressions[11, 13, 13, 15, 12, 14, 14, 16]
	,
	TestID -> "evaluateAction-20160709-IDS5UQ"
]

Test[
	Lui`Parse`Private`evaluateAction[
		HoldComplete[a],
		{HoldComplete[a] -> {HoldComplete[{"x", "y"}]}}
	]
	,
	{"x", "y"}
	,
	TestID -> "evaluateAction-20160924-AFWKZY"
]