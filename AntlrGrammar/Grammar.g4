grammar Grammar;

import WolframLanguage, Common;

grammarRules: grammarRule (grammarRule)* ;

end_of_rule: ws* ((NEWLINE ws*)+|EOF) ;

grammarRule:	lhs ws* COLON ws* (rulePart ws*)+ NEWLINE INDENT expr end_of_rule
	|			lhs ws* COLON ws* (rulePart ws*)+ ARROW ws* expr end_of_rule
	|			lhs ws* COLON ws* (rulePart ws*)+ end_of_rule
	|			lhs ws* COLON? ws* (NEWLINE (ws* NEWLINE)* INDENT simpleRule ws*)+ end_of_rule
	;

simpleRule:		(rulePart ws?)+
	|			(rulePart ws?)+ ARROW ws? expr ws?
	|			(rulePart ws?)+ NEWLINE DOUBLE_INDENT expr ws?
	;

lhs: ID | symbol ;

rulePart:		'(' rulePart ('|' rulePart)+ ')'	# OrRulePart
	|			'(' (rulePart ws*)+ ')'				# SeqRulePart
	|			basicRulePart						# BasicRulePart2
				// Unfortunately this allows multiple/nested bindings,
				// but I'm not sure how to prevent that. If I break this
				// up into multiple rules, I get 'mutual left recursion'
				// which apparently isn't allowed.
	|			ID EQUALS rulePart					# Binding
	;

basicRulePart:
    ID |
    symbol
    ;
    
symbol: ('$'|'~') ID ;