(* Tests for: Lui`Parse`ChooseParse

   Author: danielb
*)

Test[
	Lui`Parse`ChooseParse[
		{
			HoldComplete[Lui`Parse`Scored["C", 0.7]],
			HoldComplete["A"],
			HoldComplete[Lui`Parse`Scored["B", 0.9]]
		}
	]
	,
	HoldComplete["A"]
	,
	TestID -> "ChooseParse-20161005-1TW7NO"
]