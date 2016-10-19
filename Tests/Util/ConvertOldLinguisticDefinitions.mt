(* Tests for: Lui`Util`ConvertOldLinguisticDefinitions

   Author: danielb
*)

Test[
	Lui`Util`ConvertOldLinguisticDefinitions[
		{
			"$curt" -> {("curt" | "curtis") | FO["curt" | "curtis", "beattie"] :> "CurtisBeattie"},
			"$login" -> {"login" | "username" | "user name" | "password" | "account"},
			"$bb" -> {"bb" | "blackberry" | "black berry" :> "BlackBerry"},
			"$bb10" -> {FO[sym["$bb"], "10"] :> "BlackBerry10"}
		}
	]
	,
	"~curt:\n\t(curt | curtis) | ((curt | curtis) beattie)\n\t\t\"CurtisBeattie\"\n~login:\n\tlogin | username | \"user name\" | password | account\n~bb:\n\tbb | blackberry | \"black berry\" -> \"BlackBerry\"\n~bb10:\n\t~bb 10 -> \"BlackBerry10\""
	,
	TestID -> "ConvertOldLinguisticDefinitions-20161018-WBYBZ9"
]