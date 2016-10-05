(* Tests for: Lui`UI`DefineLinguisticHotkeyForWebpage

   Author: danielb
*)

Test[
	Lui`UI`DefineLinguisticHotkeyForWebpage[
		"daniel bigham.ca - Google Chrome",
		"http://danielbigham.ca"
	]
	,
	<|
		"Linguistic" -> "daniel bigham.ca",
		"Symbol" -> "webpage",
		"Expression" -> "http://danielbigham.ca",
		"UILabel" -> "http://danielbigham.ca"
	|>
	,
	TestID -> "DefineLinguisticHotkeyForWebpage-20160926-1150G6"
]