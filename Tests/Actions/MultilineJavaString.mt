(* Tests for: Lui`Actions`MultilineJavaString

   Author: danielb
*)

Test[
	Lui`Actions`MultilineJavaString["this is a \"test\"\nof this function."]
	,
	"\"this is a \\\"test\\\"\\nof this function.\""
	,
	TestID -> "MultilineJavaString-20161127-KKZSZ4"
]