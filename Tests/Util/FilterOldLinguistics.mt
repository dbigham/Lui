(* Tests for: Lui`Util`FilterOldLinguistics

   Author: danielb
*)

Test[
	Lui`Util`FilterOldLinguistics[
		{"just testing" :> "C:\\Temp\\Lsdlkfjd.nb", "just testing" :> "Todo.nb"}
	]
	,
	{"just testing" :> "Todo.nb"}
	,
	TestID -> "FilterOldLinguistics-20161018-X0KX33"
]