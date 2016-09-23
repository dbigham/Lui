grammar Grammar;

import WolframLanguage, Common;

grammarRules: (ws | NEWLINE)* grammarRule (grammarRule)* (ws | NEWLINE)* ;

end_of_rule: ws* ((NEWLINE ws*)+|EOF) ;

grammarRule:	lhs ws* COLON ws* (rulePart3 ws*)+ NEWLINE INDENT expr end_of_rule
	|			lhs ws* COLON ws* (rulePart3 ws*)+ ARROW ws* expr end_of_rule
	|			lhs ws* COLON ws* (rulePart3 ws*)+ end_of_rule
	|			lhs ws* COLON? ws* (NEWLINE (ws* NEWLINE)* INDENT simpleRule ws*)+ end_of_rule
	;

simpleRule:		(rulePart3 ws?)+
	|			(rulePart3 ws?)+ ARROW ws? expr ws?
	|			(rulePart3 ws?)+ NEWLINE DOUBLE_INDENT expr ws?
	;

lhs: ID | symbol ;

rulePart3:		rulePart | rulePart2 ;

rulePart:		'(' ws* rulePart ws* (ws* '|' ws* rulePart)+ ')'	# OrRulePart
	|			'(' (rulePart ws*)+ ')'								# SeqRulePart
	|			basicRulePart										# BasicRulePart2
	|			'(' ws* rulePart2 ws* ')'							# OrRulePart2
				// Unfortunately this allows multiple/nested bindings,
				// but I'm not sure how to prevent that. If I break this
				// up into multiple rules, I get 'mutual left recursion'
				// which apparently isn't allowed.
	|			ID ws* EQUALS ws* rulePart							# Binding
	;

// Since OR patterns cause problems when they both:
// - Don't have surround parentheses
// - And have a binding on the first subpattern
// ... we require they have parentheses if they are to have a binding.
// That is all done in the 'rulePart: ...' rules above, but it would be
// too unfortunate to loose all ability for OR patterns without parens,
// so we use this additional rule to allow that.
rulePart2:		basicRulePart (ws* '|' ws* basicRulePart)+
	;

basicRulePart:
    ID |
    symbol |
    STRING
    ;
    
symbol: ('$'|'~') ID ;