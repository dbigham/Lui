(* Tests for: Lui`Util`SplitLinguisticAndExpression

   Author: danielb
*)

Test[
	Lui`Util`SplitLinguisticAndExpression["my linguistic -> \"My Expression\""]
	,
	{"my linguistic", "\"My Expression\""}
	,
	TestID -> "SplitLinguisticAndExpression-20160926-GN92XG"
]