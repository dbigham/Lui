grammar Common;

ws: OTHER_WS | INDENT | DOUBLE_INDENT ;

wsn: NEWLINE | OTHER_WS | INDENT | DOUBLE_INDENT ;

COLON : ':' ;

EQUALS : '=' ;

ID : LETTER (LETTER|'0'..'9')* ;

ID2 : '0'..'9' (LETTER|'0'..'9')+ ;

fragment
LETTER : [a-zA-Z\u0080-\u00FF_] ;

// Don't appear to be using this. Commented out August 2016.
//INDENT : ('    ' | '\t') ;

// The special arrow char didn't seem to work when I tried it
ARROW : '->' | '\u2192' ;

// Handle characters which failed to match any other token
// http://stackoverflow.com/questions/22415208/get-rid-of-token-recognition-error
//ERRORCHARACTER : . ;

DOUBLE_INDENT : '\t\t' | '        ' ;

INDENT : '\t' | '    ' ;

NEWLINE : '\r'? '\n' ;

OTHER_WS : ' ' | '  ' | '   ' | '     ' | '\t\t\t' | '\t\t\t\t' | '\t\t\t\t\t' ;

STRING : '"' (~["] | '\\"')+ '"' ;

// Ignore whitespace
WS : [ \t] -> skip ;

DIGITS : ('0'..'9')+ ;