lexer grammar Common;

COLON : ':' ;

EQUALS : '=' ;

ID : LETTER (LETTER|'0'..'9')* ;

fragment
LETTER : [a-zA-Z\u0080-\u00FF_] ;

NEWLINE : '\r'? '\n' ;

NEWLINE_DOUBLE_INDENT : '\r'? '\n' '\t\t' ;

NEWLINE_INDENT : '\r'? '\n' '\t' ;

// Ignore whitespace
WS : [ \t] -> skip ;
WS2 : [ \t\r\n] ;

// Don't appear to be using this. Commented out August 2016.
//INDENT : ('    ' | '\t') ;

// The special arrow char didn't seem to work when I tried it
ARROW : '->' | '\u2192' ;

// Handle characters which failed to match any other token
// http://stackoverflow.com/questions/22415208/get-rid-of-token-recognition-error
//ERRORCHARACTER : . ;