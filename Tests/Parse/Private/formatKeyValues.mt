(* Tests for: Lui`Parse`Private`formatKeyValues

   Author: danielb
*)

Test[
	Lui`Parse`Private`formatKeyValues[Association["Items" -> 7, "Price" -> "$43.23"]]
	,
	Style[
		Grid[
			{
				{Style["Items:", FontColor -> GrayLevel[0.5]], 7},
				{Style["Price:", FontColor -> GrayLevel[0.5]], "$43.23"}
			},
			Alignment -> Left,
			Spacings -> {0.5, 0.5}
		],
		FontFamily -> "Arial"
	]
	,
	TestID -> "formatKeyValues-20160709-VDNOSZ"
]