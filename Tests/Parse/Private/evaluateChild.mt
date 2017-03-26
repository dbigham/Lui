(* Tests for: Lui`Parse`Private`evaluateChild

   Author: danielb
*)

Test[
	Lui`Parse`Private`blockParseForestLookup[
		{{{-1, 0, 0}, "E", HoldComplete[1], {{{0, 0, 0}, "L", Null}}}},
		Lui`Parse`Private`evaluateChild[{{0, 0, 0}, "L", Null}]
	]
	,
	{{}, <||>}
	,
	TestID -> "evaluateChild-20160911-TGNNTK"
]

Test[
	Lui`Parse`Private`blockParseForestLookup[
		{{{-1, 0, 0}, "E", HoldComplete[1], {{{0, 0, 0}, "L", HoldComplete[a]}}}},
		Lui`Parse`Private`evaluateChild[{{0, 0, 0}, "L", HoldComplete[a]}]
	]
	,
	{{}, <|HoldComplete[a] -> Null|>}
	,
	TestID -> "evaluateChild-20160911-QBLTKO"
]

Test[
	Lui`Parse`Private`blockParseForestLookup[
		{
			{
				{-1, 0, 2},
				"E",
				HoldComplete[a + b],
				{
					{{0, 0, 0}, "S", HoldComplete[a]},
					{{1, 1, 1}, "L", Null},
					{{0, 2, 2}, "S", HoldComplete[b]}
				}
			},
			{{0, 0, 0}, "E", HoldComplete[1], {{{2, 0, 0}, "L", Null}}},
			{{0, 2, 2}, "E", HoldComplete[2], {{{3, 2, 2}, "L", Null}}}
		},
		Lui`Parse`Private`evaluateChild[{{0, 0, 0}, "S", HoldComplete[a]}]
	]
	,
	{{}, <|HoldComplete[a] -> {1}|>}
	,
	TestID -> "evaluateChild-20160911-LY3IQ9"
]

Test[
	Lui`Parse`Private`blockParseForestLookup[
		{
			{{-1, 0, 0}, "E", HoldComplete[Wrapper[a, b]], {{{0, 0, 0}, "S", Null}}},
			{{0, 0, 0}, "E", HoldComplete[1], {{{2, 0, 0}, "L", Null}}}
		},
		Lui`Parse`Private`evaluateChild[{{0, 0, 0}, "S", Null}]
	]
	,
	{{}, <||>}
	,
	TestID -> "evaluateChild-20160911-DK9W72"
]

Test[
	Lui`Parse`Private`blockParseForestLookup[
		{
			{
				{-1, 0, 1},
				"E",
				HoldComplete[Wrapper[a, b, c, d]],
				{{{4, 0, 0}, "D", Null}, {{5, 1, 1}, "D", Null}}
			},
			{{4, 0, 0}, "D", HoldComplete[Null], {{{0, 0, 0}, "S", HoldComplete[a]}}},
			{{0, 0, 0}, "E", HoldComplete[1], {{{2, 0, 0}, "L", Null}}},
			{{5, 1, 1}, "D", HoldComplete[Null], {{{1, 1, 1}, "S", HoldComplete[d]}}},
			{{1, 1, 1}, "E", HoldComplete[2], {{{3, 1, 1}, "L", Null}}}
		},
		Lui`Parse`Private`evaluateChild[{{4, 0, 0}, "D", Null}]
	]
	,
	{{}, <|HoldComplete[a] -> {1}|>}
	,
	TestID -> "evaluateChild-20160911-KKCDM3"
]

(* For example, an unmatched optional. When we use $parseForestLookup to get the 'ruleMatches', we'll get a Missing (key absent), so we need to detect that and handle it properly. *)
Test[
	Lui`Parse`Private`blockParseForestLookup[
		{
			{
				{-1, 0, 1},
				"E",
				HoldComplete[HoldComplete[1]],
				{{{0, 0, 1}, "L", Null}, {{3, 2, 1}, "D", Null}}
			}
		},
		Lui`Parse`Private`evaluateChild[{{3, 2, 1}, "D", Null}]
	]
	,
	{{}, {}}
	,
	TestID -> "evaluateChild-20170318-011WS5"
]