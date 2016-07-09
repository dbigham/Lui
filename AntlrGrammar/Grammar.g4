grammar Grammar;

import WolframLanguage, Common;

grammarRules: WS2* grammarRule (grammarRule)* (WS2|WS|NEWLINE)*;

grammarRule:	lhs COLON rulePart+ NEWLINE_INDENT expr (NEWLINE|EOF)
	|			lhs COLON rulePart+ ARROW expr (NEWLINE|EOF)
	|			lhs COLON rulePart+ (NEWLINE|EOF)
	|			lhs COLON? (NEWLINE_INDENT simpleRule)+ (NEWLINE|EOF)
	;

simpleRule:		rulePart+
	|			rulePart+ ARROW expr
	|			rulePart+ NEWLINE_DOUBLE_INDENT expr
	;

lhs: ID | symbol ;

rulePart:		ID EQUALS rulePartRhs
	|			rulePartRhs
	;

rulePartRhs:	rulePartRhs ('|' rulePartRhs)+			# OrRulePart
	|			'(' rulePartRhs+ ')'					# SeqRulePart
	|			basicRulePart							# BasicRulePart2
	;

basicRulePart:
    ID |
    symbol
    ;
    
symbol: ('$'|'~') ID ;
