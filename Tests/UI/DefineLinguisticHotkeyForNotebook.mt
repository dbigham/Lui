(* Tests for: Lui`UI`DefineLinguisticHotkeyForNotebook

   Author: danielb
*)

Test[
	Lui`UI`DefineLinguisticHotkeyForNotebook[
		"ai.nb * - Wolfram Mathematica 11.0 (Local)",
		Null
	]
	,
	<|
		"File" -> "ai.nb",
		"Symbol" -> "notebook",
		"Expression" -> "ai.nb",
		"UILabel" -> "ai.nb"
	|>
	,
	TestID -> "DefineLinguisticHotkeyForNotebook-20160926-GACY3D"
]