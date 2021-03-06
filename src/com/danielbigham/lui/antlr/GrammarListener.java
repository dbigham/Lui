// Generated from E:\Users\Daniel\Dropbox\Projects\Lui\AntlrGrammar\Grammar.g4 by ANTLR 4.5.3
package com.danielbigham.lui.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#grammarRules}.
	 * @param ctx the parse tree
	 */
	void enterGrammarRules(GrammarParser.GrammarRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#grammarRules}.
	 * @param ctx the parse tree
	 */
	void exitGrammarRules(GrammarParser.GrammarRulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#end_of_rule}.
	 * @param ctx the parse tree
	 */
	void enterEnd_of_rule(GrammarParser.End_of_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#end_of_rule}.
	 * @param ctx the parse tree
	 */
	void exitEnd_of_rule(GrammarParser.End_of_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#grammarRule}.
	 * @param ctx the parse tree
	 */
	void enterGrammarRule(GrammarParser.GrammarRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#grammarRule}.
	 * @param ctx the parse tree
	 */
	void exitGrammarRule(GrammarParser.GrammarRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#simpleRule}.
	 * @param ctx the parse tree
	 */
	void enterSimpleRule(GrammarParser.SimpleRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#simpleRule}.
	 * @param ctx the parse tree
	 */
	void exitSimpleRule(GrammarParser.SimpleRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rulePattern}.
	 * @param ctx the parse tree
	 */
	void enterRulePattern(GrammarParser.RulePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rulePattern}.
	 * @param ctx the parse tree
	 */
	void exitRulePattern(GrammarParser.RulePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#lhs}.
	 * @param ctx the parse tree
	 */
	void enterLhs(GrammarParser.LhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#lhs}.
	 * @param ctx the parse tree
	 */
	void exitLhs(GrammarParser.LhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rulePart3}.
	 * @param ctx the parse tree
	 */
	void enterRulePart3(GrammarParser.RulePart3Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rulePart3}.
	 * @param ctx the parse tree
	 */
	void exitRulePart3(GrammarParser.RulePart3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code OrRulePart}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void enterOrRulePart(GrammarParser.OrRulePartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OrRulePart}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void exitOrRulePart(GrammarParser.OrRulePartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OptionalRulePart}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void enterOptionalRulePart(GrammarParser.OptionalRulePartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OptionalRulePart}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void exitOptionalRulePart(GrammarParser.OptionalRulePartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BasicRulePart2}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void enterBasicRulePart2(GrammarParser.BasicRulePart2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code BasicRulePart2}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void exitBasicRulePart2(GrammarParser.BasicRulePart2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code SeqRulePart}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void enterSeqRulePart(GrammarParser.SeqRulePartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SeqRulePart}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void exitSeqRulePart(GrammarParser.SeqRulePartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OrRulePart2}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void enterOrRulePart2(GrammarParser.OrRulePart2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code OrRulePart2}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void exitOrRulePart2(GrammarParser.OrRulePart2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void enterBinding(GrammarParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Binding}
	 * labeled alternative in {@link GrammarParser#rulePart}.
	 * @param ctx the parse tree
	 */
	void exitBinding(GrammarParser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rulePart2}.
	 * @param ctx the parse tree
	 */
	void enterRulePart2(GrammarParser.RulePart2Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rulePart2}.
	 * @param ctx the parse tree
	 */
	void exitRulePart2(GrammarParser.RulePart2Context ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#basicRulePart}.
	 * @param ctx the parse tree
	 */
	void enterBasicRulePart(GrammarParser.BasicRulePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#basicRulePart}.
	 * @param ctx the parse tree
	 */
	void exitBasicRulePart(GrammarParser.BasicRulePartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(GrammarParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(GrammarParser.SymbolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ETimes}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterETimes(GrammarParser.ETimesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ETimes}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitETimes(GrammarParser.ETimesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EInteger}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEInteger(GrammarParser.EIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EInteger}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEInteger(GrammarParser.EIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EAssociation}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEAssociation(GrammarParser.EAssociationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EAssociation}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEAssociation(GrammarParser.EAssociationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ERule}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterERule(GrammarParser.ERuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ERule}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitERule(GrammarParser.ERuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EList}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEList(GrammarParser.EListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EList}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEList(GrammarParser.EListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EHeadedExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEHeadedExpr(GrammarParser.EHeadedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EHeadedExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEHeadedExpr(GrammarParser.EHeadedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ESet}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterESet(GrammarParser.ESetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ESet}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitESet(GrammarParser.ESetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EUnsameQ}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEUnsameQ(GrammarParser.EUnsameQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EUnsameQ}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEUnsameQ(GrammarParser.EUnsameQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EOr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEOr(GrammarParser.EOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EOr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEOr(GrammarParser.EOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EPlus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEPlus(GrammarParser.EPlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EPlus}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEPlus(GrammarParser.EPlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ESameQ}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterESameQ(GrammarParser.ESameQContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ESameQ}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitESameQ(GrammarParser.ESameQContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EDivide}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEDivide(GrammarParser.EDivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EDivide}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEDivide(GrammarParser.EDivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ESymbol}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterESymbol(GrammarParser.ESymbolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ESymbol}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitESymbol(GrammarParser.ESymbolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EPower}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEPower(GrammarParser.EPowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EPower}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEPower(GrammarParser.EPowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EString}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEString(GrammarParser.EStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EString}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEString(GrammarParser.EStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EAnd}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEAnd(GrammarParser.EAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EAnd}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEAnd(GrammarParser.EAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EEqual}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEEqual(GrammarParser.EEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EEqual}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEEqual(GrammarParser.EEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EReal}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEReal(GrammarParser.ERealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EReal}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEReal(GrammarParser.ERealContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#wlSymbol}.
	 * @param ctx the parse tree
	 */
	void enterWlSymbol(GrammarParser.WlSymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#wlSymbol}.
	 * @param ctx the parse tree
	 */
	void exitWlSymbol(GrammarParser.WlSymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(GrammarParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(GrammarParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#real}.
	 * @param ctx the parse tree
	 */
	void enterReal(GrammarParser.RealContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#real}.
	 * @param ctx the parse tree
	 */
	void exitReal(GrammarParser.RealContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ws}.
	 * @param ctx the parse tree
	 */
	void enterWs(GrammarParser.WsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ws}.
	 * @param ctx the parse tree
	 */
	void exitWs(GrammarParser.WsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#wsn}.
	 * @param ctx the parse tree
	 */
	void enterWsn(GrammarParser.WsnContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#wsn}.
	 * @param ctx the parse tree
	 */
	void exitWsn(GrammarParser.WsnContext ctx);
}