(* Tests for: Lui`UI`DefineLinguisticHotkeyForFile

   Author: danielb
*)

Test[
	Lui`UI`DefineLinguisticHotkeyForFile["Dropbox", FileNameJoin[{$DropboxDir, "Projects"}]]
	,
	<|
		"Linguistic" -> "projects",
		"Symbol" -> "directory",
		"Expression" -> "E:\\Users\\Daniel\\Dropbox\\Projects",
		"UILabel" -> "E:\\Users\\Daniel\\Dropbox\\Projects"
	|>
	,
	TestID -> "DefineLinguisticHotkeyForFile-20161003-FJ0FVU"
]