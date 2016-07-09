(* Tests for: Lui`Parse`GrammarToAssoc

   Author: danielb
*)

Test[
	Lui`Parse`GrammarToAssoc[
		Lui`Parse`CreateGrammar[
			"Test",
			"start: go to $webpage\nwebpage:\n\tslashdot -> \"http://www.slashdot.org\"\n\tspacex|spx reddit -> TODO\n"
		]
	]
	,
	<|
		"Name" -> "Test",
		"RuleCount" -> 3,
		"Rules" ->
		{
			"<$start:-1>: {<<go:0>> <to:1> <$webpage:2>}",
			"<$webpage:2>: {<<slashdot:3>>}",
			"<$1:7>: <spacex:4>|<spx:5>",
			"<$webpage:2>: {<<$1:7>> <reddit:6>}"
		}
	|>
	,
	TestID -> "GrammarToAssoc-20160709-EZ1WM8"
]