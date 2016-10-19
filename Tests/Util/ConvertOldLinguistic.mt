(* Tests for: Lui`Util`ConvertOldLinguistic

   Author: danielb
*)

Test[
	Lui`Util`ConvertOldLinguistic["testing"]
	,
	"testing"
	,
	TestID -> "ConvertOldLinguistic-20161018-E7B61F"
]

Test[
	Lui`Util`ConvertOldLinguistic["123"]
	,
	"123"
	,
	TestID -> "ConvertOldLinguistic-20161018-GBGG7N"
]

Test[
	Lui`Util`ConvertOldLinguistic["just testing"]
	,
	"\"just testing\""
	,
	TestID -> "ConvertOldLinguistic-20161018-FE77RC"
]

Test[
	Lui`Util`ConvertOldLinguistic["testing123"]
	,
	"\"testing123\""
	,
	TestID -> "ConvertOldLinguistic-20161018-TKDKJM"
]

Test[
	Lui`Util`ConvertOldLinguistic[FO["just", "testing"]]
	,
	"just testing"
	,
	TestID -> "ConvertOldLinguistic-20161018-JPBT91"
]

Test[
	Lui`Util`ConvertOldLinguistic[FO["just testing"]]
	,
	"\"just testing\""
	,
	TestID -> "ConvertOldLinguistic-20161018-FSQPH8"
]

Test[
	Lui`Util`ConvertOldLinguistic["one" | "two"]
	,
	"one | two"
	,
	TestID -> "ConvertOldLinguistic-20161018-ID8ML5"
]

Test[
	Lui`Util`ConvertOldLinguistic[FO["one" | "two", "three"]]
	,
	"(one | two) three"
	,
	TestID -> "ConvertOldLinguistic-20161018-B1R2GM"
]

Test[
	Lui`Util`ConvertOldLinguistic["just testing" -> "action"]
	,
	"\"just testing\" -> \"action\""
	,
	TestID -> "ConvertOldLinguistic-20161018-0OHK4L"
]

Test[
	Lui`Util`ConvertOldLinguistic["just testing" :> 1 + 1]
	,
	"\"just testing\" -> 1 + 1"
	,
	TestID -> "ConvertOldLinguistic-20161018-WUDTTW"
]

Test[
	Lui`Util`ConvertOldLinguistic[
		"just testing" :> {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}
	]
	,
	"\"just testing\"\n\t{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}"
	,
	TestID -> "ConvertOldLinguistic-20161018-IIYD1I"
]

Test[
	Lui`Util`ConvertOldLinguistic[
		"just testing" :>
			{
				1,
				2,
				3,
				4,
				5,
				6,
				7,
				8,
				9,
				10,
				11,
				12,
				13,
				14,
				15,
				16,
				17,
				18,
				19,
				20,
				21,
				22,
				23,
				24,
				25,
				26,
				27,
				28,
				29,
				30
			}
	]
	,
	"\"just testing\"\n\t{\n\t\t1,\n\t\t2,\n\t\t3,\n\t\t4,\n\t\t5,\n\t\t6,\n\t\t7,\n\t\t8,\n\t\t9,\n\t\t10,\n\t\t11,\n\t\t12,\n\t\t13,\n\t\t14,\n\t\t15,\n\t\t16,\n\t\t17,\n\t\t18,\n\t\t19,\n\t\t20,\n\t\t21,\n\t\t22,\n\t\t23,\n\t\t24,\n\t\t25,\n\t\t26,\n\t\t27,\n\t\t28,\n\t\t29,\n\t\t30\n\t}"
	,
	TestID -> "ConvertOldLinguistic-20161018-1YEHFH"
]

Test[
	Lui`Util`ConvertOldLinguistic[
		"watch movie" | FO["netflix", "match rank" | "matchrank" | "movies" | "list" | "pairings"] :>
			"E:\\Users\\Daniel\\Documents\\NetflixMatchRank.nb"
	]
	,
	"\"watch movie\" | (netflix (\"match rank\" | matchrank | movies | list | pairings))\n\t\"E:\\\\Users\\\\Daniel\\\\Documents\\\\NetflixMatchRank.nb\""
	,
	TestID -> "ConvertOldLinguistic-20161018-JSSAAH"
]

Test[
	Lui`Util`ConvertOldLinguistic[sym["$file"]]
	,
	"~file"
	,
	TestID -> "ConvertOldLinguistic-20161018-G5SAWK"
]

Test[
	Lui`Util`ConvertOldLinguistic["$file"]
	,
	"~file"
	,
	TestID -> "ConvertOldLinguistic-20161018-Q1796E"
]

Test[
	Lui`Util`ConvertOldLinguistic[
		sym["$lm"] | FO["$nlu" | sym["$lang"], "models" | "modeling"] | "nlpmodels" :>
			"NlpModels.nb"
	]
	,
	"~lm | ((~nlu | ~lang) (models | modeling)) | nlpmodels\n\t\"NlpModels.nb\""
	,
	TestID -> "ConvertOldLinguistic-20161018-T5OGCQ"
]

Test[
	Lui`Util`ConvertOldLinguistic[op["test"]]
	,
	"test?"
	,
	TestID -> "ConvertOldLinguistic-20161018-T3YPU2"
]

Test[
	Lui`Util`ConvertOldLinguistic[AO["just", "testing"]]
	,
	"(just testing) | (testing just)"
	,
	TestID -> "ConvertOldLinguistic-20161018-Y64UQV"
]

Test[
	Lui`Util`ConvertOldLinguistic[AO["one", "two", "three", "four", "five"]]
	,
	"\"PATTERN_TOO_LARGE\""
	,
	TestID -> "ConvertOldLinguistic-20161018-DYBTS7"
]