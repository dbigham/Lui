grammar WolframLanguage;

import Common;

expr:	string												# EString
	|	integer												# EInteger
	|	real												# EReal
	|	wlSymbol											# ESymbol
	|	expr ws* ARROW ws* expr								# ERule
	|	'{' ws* expr ws* (',' ws* expr ws*)* '}'			# EList
	|	expr '[' ws* expr ws* (',' ws* expr ws*)* ']' ws*	# EHeadedExpr
	|	expr ws* '^' ws* expr								# EPower
	|	expr ws* '*' ws* expr								# ETimes
	|	expr ws* '/' ws* expr								# EDivide
	|	expr ws* '+' ws* expr								# EPlus
	|	expr ws* '-' ws* expr								# EPlus	
	;
 
wlSymbol:
	ID |
	'$' ID
	;

string : STRING ;

integer : INTEGER ;

real : REAL ;

INTEGER : DIGITS ;

REAL : DIGITS '.' DIGITS? ;

fragment
DIGITS : ('0'..'9')+ ;

ARROW : '->' | '\u2192' ;