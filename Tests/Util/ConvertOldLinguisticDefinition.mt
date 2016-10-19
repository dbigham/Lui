(* Tests for: Lui`Util`ConvertOldLinguisticDefinition

   Author: danielb
*)

Test[
	Lui`Util`ConvertOldLinguisticDefinition[
		"$bb" -> {"bb" | "blackberry" | "black berry" :> "BlackBerry"}
	]
	,
	"~bb:\n\tbb | blackberry | \"black berry\" -> \"BlackBerry\""
	,
	TestID -> "ConvertOldLinguisticDefinition-20161018-VY30F5"
]

Test[
	Lui`Util`ConvertOldLinguisticDefinition[
		"$multilang" ->
		{
			Alternatives[
				"cross-lingual",
				"cross lingual",
				"multi-lingual",
				"multi lingual",
				"multi language",
				"multi-language"
			]
		}
	]
	,
	"~multilang:\n\t\"cross-lingual\" | \"cross lingual\" | \"multi-lingual\" | \"multi lingual\" | \"multi language\" | \"multi-language\""
	,
	TestID -> "ConvertOldLinguisticDefinition-20161018-RHEJTI"
]