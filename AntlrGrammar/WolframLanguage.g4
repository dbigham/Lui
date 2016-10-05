grammar WolframLanguage;

import Common;

expr:	string												# EString
	|	integer												# EInteger
	|	real												# EReal
	|	wlSymbol											# ESymbol
	|	expr wsn* ARROW wsn* expr							# ERule
	|	'{' wsn* expr wsn* (',' wsn* expr wsn*)* '}'		# EList
	|	'{' wsn* '}'										# EList
	|	'<|' wsn* expr wsn* (',' wsn* expr wsn*)* '|>'		# EAssociation
	|	expr wsn* '[' wsn* expr wsn* (',' wsn* expr wsn*)* ']' wsn*	# EHeadedExpr
	|	expr '[' wsn* ']' wsn*								# EHeadedExpr
	|	expr wsn* '^' wsn* expr								# EPower
	|	expr wsn* '*' wsn* expr								# ETimes
	|	expr wsn* '/' wsn* expr								# EDivide
	|	expr wsn* '+' wsn* expr								# EPlus
	|	expr wsn* '-' wsn* expr								# EPlus
	|	expr wsn* '=' wsn* expr								# ESet
	|	expr wsn* '==' wsn* expr							# EEqual
	|	expr wsn* '===' wsn* expr							# ESameQ
	|	expr wsn* '=!=' wsn* expr							# EUnsameQ
	|	expr wsn* '&&' wsn* expr							# EAnd
	|	expr wsn* '||' wsn* expr							# EOr
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

ARROW : '->' | '\u2192' ;