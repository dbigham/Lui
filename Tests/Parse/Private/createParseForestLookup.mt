(* Tests for: Lui`Parse`Private`createParseForestLookup

   Author: danielb
*)

Test[
	Lui`Parse`Private`createParseForestLookup[
		{
			{{-1, 0, 2}, HoldComplete[a + b], {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}}},
			{{0, 0, 0}, HoldComplete[1], {{3, 0, 0}}},
			{{2, 2, 2}, HoldComplete[2], {{4, 2, 2}}}
		}
	]
	,
	<|
		{-1, 0, 2} -> {{HoldComplete[a + b], {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}}}},
		{0, 0, 0} -> {{HoldComplete[1], {{3, 0, 0}}}},
		{2, 2, 2} -> {{HoldComplete[2], {{4, 2, 2}}}}
	|>
	,
	TestID -> "createParseForestLookup-20160709-68MWTA"
]