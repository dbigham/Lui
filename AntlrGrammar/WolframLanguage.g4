grammar WolframLanguage;

import Common;

expr:	string								# EString
	|	integer								# EInteger
	|	real								# EReal
	|	wlSymbol							# ESymbol
	|	expr ARROW expr						# ERule
	|	'{' expr (',' expr)* '}'			# EList
	|	expr '[' expr (',' expr)* ']'		# EHeadedExpr
	|	expr '^' expr						# EPower
	|	expr '*' expr						# ETimes
	|	expr '/' expr						# EDivide
	|	expr '+' expr						# EPlus
	|	expr '-' expr						# EPlus	
	;
 
wlSymbol:
	ID |
	'$' ID
	;

string : STRING ;

integer : INTEGER ;

real : REAL ;

STRING : '"' (~["] | '\\"')+ '"' ;

INTEGER : DIGITS ;

REAL : DIGITS '.' DIGITS? ;

fragment
DIGITS : ('0'..'9')+ ;

ARROW : '->' | '\u2192' ;