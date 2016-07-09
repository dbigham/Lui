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
		"EndPos" -> 1,
		"Forest" ->
		{
			{{-1, 0, 1}, "E", HoldComplete["Hey!"], {{{0, 0, 0}, "L", Null}, {{1, 1, 1}, "L", Null}}},
			Null
		}
	|>
	,
	TestID -> "GetParserState-20160709-V8UKTT"
]