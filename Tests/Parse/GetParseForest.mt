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
		{{-1, 0, 1}, "E", HoldComplete["Hey!"], {{{0, 0, 0}, "L", Null}, {{1, 1, 1}, "L", Null}}}
	}
	,
	TestID -> "GetParseForest-20160709-VJ3PYZ"
]