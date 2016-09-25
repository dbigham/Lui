(* Tests for: Lui`Parse`CreateGrammar

   Author: danielb
*)

(* TODO *)
(*
Test[
	WUtils`WUtils`CapturePrint[Lui`Parse`CreateGrammar["Test", "start -> hello"]]
	,
	{{"Line 1 column 6: no viable alternative at input 'start ->'"}}
	,
	TestID -> "CreateGrammar-20160709-AMS19Z"
]
*)

Test[
	Lui`Parse`GrammarToAssoc[Lui`Parse`CreateGrammar["Test", "start: hello"]]
	,
	<|"Name" -> "Test", "RuleCount" -> 1, "Rules" -> {"$start: {<hello>}"}|>
	,
	TestID -> "CreateGrammar-20160709-LHRS2Y"
]

Test[
	MatchQ[Lui`Parse`CreateGrammar["Test", "start: hello"], _Lui`Parse`Grammar]
	,
	True
	,
	TestID -> "CreateGrammar-20160709-84OM1W"
]

Test[
	Lui`Parse`CreateGrammar["Test", "start: hello"]["Name"]
	,
	"Test"
	,
	TestID -> "CreateGrammar-20160709-8OS4SJ"
]