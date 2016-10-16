(* Tests for: Lui`Parse`Private`evaluateRule

   Author: danielb
*)

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
		Lui`Parse`Private`evaluateRule[{"E", HoldComplete[1], {{{2, 0, 0}, "L", Null}}}]
	]
	,
	{1, <||>}
	,
	TestID -> "evaluateRule-20160911-DL8K8B"
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
		Lui`Parse`Private`evaluateRule[
			"E",
			HoldComplete[a + b],
			{
				{{0, 0, 0}, "S", HoldComplete[a]},
				{{1, 1, 1}, "L", Null},
				{{0, 2, 2}, "S", HoldComplete[b]}
			}
		]
	]
	,
	{3, <||>}
	,
	TestID -> "evaluateRule-20160911-YXHSE8"
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
		Lui`Parse`Private`evaluateRule[
			{"D", HoldComplete[Null], {{{0, 0, 0}, "S", HoldComplete[a]}}}
		]
	]
	,
	{Null, <|HoldComplete[a] -> {1}|>}
	,
	TestID -> "evaluateRule-20160911-QT15L3"
]

Test[
	Lui`Parse`Private`blockParseForestLookup[
		{
			{
				{-1, 0, 5},
				"E",
				HoldComplete[HoldComplete[X]],
				{{{5, 0, 1}, "D", Null}, {{2, 2, 3}, "L", Null}, {{6, 4, 5}, "D", Null}}
			},
			{{5, 0, 1}, "D", HoldComplete[auto], {{{0, 0, 1}, "L", HoldComplete[auto]}}},
			{{6, 4, 5}, "D", HoldComplete[auto], {{{3, 4, 5}, "L", HoldComplete[auto]}}}
		},
		Lui`Parse`Private`evaluateRule[
			{
				"E",
				HoldComplete[HoldComplete[X]],
				{{{5, 0, 1}, "D", Null}, {{2, 2, 3}, "L", Null}, {{6, 4, 5}, "D", Null}}
			}
		]
	]
	,
	{HoldComplete[X], <||>}
	,
	TestID -> "evaluateRule-20161015-MQEOB4"
]