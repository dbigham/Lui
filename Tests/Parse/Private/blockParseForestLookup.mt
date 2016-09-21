(* Tests for: Lui`Parse`Private`blockParseForestLookup

   Author: danielb
*)

Test[
	Lui`Parse`Private`blockParseForestLookup[
		{{{-1, 0, 0}, "E", HoldComplete[1], {{{0, 0, 0}, "L", Null}}}},
		Lui`Parse`Private`$parseForestLookup[{-1, 0, 0}]
	]
	,
	{{"E", HoldComplete[1], {{{0, 0, 0}, "L", Null}}}}
	,
	TestID -> "blockParseForestLookup-20160911-AVZKZB"
]