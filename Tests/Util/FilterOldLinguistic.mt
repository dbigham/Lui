(* Tests for: Lui`Util`FilterOldLinguistic

   Author: danielb
*)

Test[
	Lui`Util`FilterOldLinguistic["just testing" :> 123]
	,
	"just testing" :> 123
	,
	TestID -> "FilterOldLinguistic-20161018-ZAUU6K"
]

Test[
	Lui`Util`FilterOldLinguistic["just testing" :> "Todo.nb"]
	,
	"just testing" :> "Todo.nb"
	,
	TestID -> "FilterOldLinguistic-20161018-IYBMB0"
]