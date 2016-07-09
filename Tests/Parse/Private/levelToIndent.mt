(* Tests for: Lui`Parse`Private`levelToIndent

   Author: danielb
*)

Test[
	Lui`Parse`Private`levelToIndent[1]
	,
	"\t"
	,
	TestID -> "levelToIndent-20160709-EFU21Q"
]

Test[
	Lui`Parse`Private`levelToIndent[3]
	,
	"\t\t\t"
	,
	TestID -> "levelToIndent-20160709-ST5NEZ"
]