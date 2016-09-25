(* Tests for: Lui`Parse`GetParserState

   Author: danielb
*)

Test[
	Lui`Parse`GetParserState[
		Lui`Parse`CreateGrammar["Test", "start: hello world -> \"Hey!\""],
		"hello world"
	]
	,
	<|
		"EndPos" -> 3,
		"Forest" ->
		{
			{
				{-1, 0, 3},
				"E",
				HoldComplete[HoldComplete["Hey!"]],
				{{{0, 0, 1}, "L", Null}, {{1, 2, 3}, "L", Null}}
			},
			Null
		}
	|>
	,
	TestID -> "GetParserState-20160709-V8UKTT"
]