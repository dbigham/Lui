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
			"$start: {<go> to webpage=$webpage} -> webpage",
			"$webpage: {<slashdot>} -> \"http://www.slashdot.org\"",
			"$1: (spacex|spx)",
			"$webpage: {<$1> reddit} -> TODO"
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
			"$start: {<webpage=$webpage>} -> webpage",
			"$1: (spacex|spx)",
			"$2: {<web> page}",
			"$3: (webpage|$2)",
			"$webpage: {<$1> $3}"
		}
	|>
	,
	TestID -> "GrammarToAssoc-20160911-KNOVON"
]