grammar WolframLanguage;

import Common;

expr:	string												# EString
	|	integer												# EInteger
	|	real												# EReal
	|	wlSymbol											# ESymbol
	|	expr wsn* ARROW wsn* expr							# ERule
	|	'{' wsn* expr wsn* (',' wsn* expr wsn*)* '}'		# EList
	|	'{' wsn* '}'										# EList
	|	expr wsn* '[' wsn* expr wsn* (',' wsn* expr wsn*)* ']' wsn*	# EHeadedExpr
	|	expr '[' wsn* ']' wsn*								# EHeadedExpr
	|	expr wsn* '^' wsn* expr								# EPower
	|	expr wsn* '*' wsn* expr								# ETimes
	|	expr wsn* '/' wsn* expr								# EDivide
	|	expr wsn* '+' wsn* expr								# EPlus
	|	expr wsn* '-' wsn* expr								# EPlus
	|	expr wsn* '==' wsn* expr							# EEqual
	|	expr wsn* '===' wsn* expr							# ESameQ
	|	expr wsn* '=!=' wsn* expr							# EUnsameQ	
	;
 
wlSymbol:
	ID |
	'$' ID
	;

string : STRING ;

integer : INTEGER ;

real : REAL ;

INTEGER : '-'? DIGITS ;

REAL : '-'? DIGITS '.' DIGITS? ;

fragment
DIGITS : ('0'..'9')+ ;

ARROW : '->' | '\u2192' ;