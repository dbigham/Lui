(* Tests for: Lui`Actions`MultilineJavaScriptString

   Author: danielb
*)

Test[
	Lui`Actions`MultilineJavaScriptString["this is a \"test\"\nof this function."]
	,
	"\"this is a \\\"test\\\"\\n\\\nof this function.\""
	,
	TestID -> "MultilineJavaScriptString-20161118-MNYO8R"
]