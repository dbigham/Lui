(* Tests for: Lui`Parse`GrammarToAssoc

   Author: danielb
*)

Test[
	Lui`Parse`GrammarToAssoc[
		Lui`Parse`CreateGrammar[
			"Test",
			"start: go to $webpage\nwebpage:\n\tslashdot -> \"http://www.slashdot.org\"\n\t(spacex|spx) reddit -> TODO\n"
		]
	]
	,
	<|
		"Name" -> "Test",
		"RuleCount" -> 3,
		"Rules" ->
		{
			"<$start:-1>: {<<go:0>> <to:1> webpage=<$webpage:2>} -> webpage",
			"<$webpage:2>: {<<slashdot:3>>} -> \"http://www.slashdot.org\"",
			"<$1:7>: (<spacex:4>|<spx:5>)",
			"<$webpage:2>: {<<$1:7>> <reddit:6>} -> TODO"
		}
	|>
	,
	TestID -> "GrammarToAssoc-20160709-EZ1WM8"
]

Test[
	Lui`Parse`GrammarToAssoc[
		Lui`Parse`CreateGrammar[
			"Test",
			"start: $webpage\nwebpage: (spacex|spx) (webpage|(web page))\n"
		]
	]
	,
	<|
		"Name" -> "Test",
		"RuleCount" -> 2,
		"Rules" ->
		{
			"<$start:-1>: {<webpage=<$webpage:0>>} -> webpage",
			"<$1:6>: (<spacex:1>|<spx:2>)",
			"<$2:7>: {<<web:4>> <page:5>}",
			"<$3:8>: (<webpage:3>|<$2:7>)",
			"<$webpage:0>: {<<$1:6>> <$3:8>}"
		}
	|>
	,
	TestID -> "GrammarToAssoc-20160911-KNOVON"
]