(* Tests for: Lui`Parse`GetParseForest

   Author: danielb
*)

Test[
	Lui`Parse`GetParseForest[
		Lui`Parse`CreateGrammar["Test", "start: hello world -> \"Hey!\""],
		"hello world"
	]
	,
	{
		{
			{-1, 0, 3},
			"E",
			HoldComplete[HoldComplete["Hey!"]],
			{{{0, 0, 1}, "L", Null}, {{1, 2, 3}, "L", Null}}
		}
	}
	,
	TestID -> "GetParseForest-20160709-VJ3PYZ"
]