grammar WolframLanguage;

import Common;

expr:	string												# EString
	|	integer												# EInteger
	|	real												# EReal
	|	wlSymbol											# ESymbol
	|	expr ws* ARROW ws* expr								# ERule
	|	'{' ws* expr ws* (',' ws* expr ws*)* '}'			# EList
	|	'{' ws* '}'											# EList
	|	expr ws* '[' ws* expr ws* (',' ws* expr ws*)* ']' ws*	# EHeadedExpr
	|	expr '[' ws* ']' ws*								# EHeadedExpr
	|	expr ws* '^' ws* expr								# EPower
	|	expr ws* '*' ws* expr								# ETimes
	|	expr ws* '/' ws* expr								# EDivide
	|	expr ws* '+' ws* expr								# EPlus
	|	expr ws* '-' ws* expr								# EPlus
	|	expr ws* '==' ws* expr								# EEqual
	|	expr ws* '===' ws* expr								# ESameQ
	|	expr ws* '=!=' ws* expr								# EUnsameQ	
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