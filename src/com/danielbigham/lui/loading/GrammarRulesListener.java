package com.danielbigham.lui.loading;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.danielbigham.lui.antlr.GrammarListener;
import com.danielbigham.lui.antlr.GrammarParser.BasicRulePart2Context;
import com.danielbigham.lui.antlr.GrammarParser.BasicRulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.BindingContext;
import com.danielbigham.lui.antlr.GrammarParser.EAndContext;
import com.danielbigham.lui.antlr.GrammarParser.EDivideContext;
import com.danielbigham.lui.antlr.GrammarParser.EEqualContext;
import com.danielbigham.lui.antlr.GrammarParser.EHeadedExprContext;
import com.danielbigham.lui.antlr.GrammarParser.EIntegerContext;
import com.danielbigham.lui.antlr.GrammarParser.EListContext;
import com.danielbigham.lui.antlr.GrammarParser.EOrContext;
import com.danielbigham.lui.antlr.GrammarParser.EPlusContext;
import com.danielbigham.lui.antlr.GrammarParser.EPowerContext;
import com.danielbigham.lui.antlr.GrammarParser.ERealContext;
import com.danielbigham.lui.antlr.GrammarParser.ERuleContext;
import com.danielbigham.lui.antlr.GrammarParser.ESameQContext;
import com.danielbigham.lui.antlr.GrammarParser.ESetContext;
import com.danielbigham.lui.antlr.GrammarParser.EStringContext;
import com.danielbigham.lui.antlr.GrammarParser.ESymbolContext;
import com.danielbigham.lui.antlr.GrammarParser.ETimesContext;
import com.danielbigham.lui.antlr.GrammarParser.EUnsameQContext;
import com.danielbigham.lui.antlr.GrammarParser.End_of_ruleContext;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRuleContext;
import com.danielbigham.lui.antlr.GrammarParser.GrammarRulesContext;
import com.danielbigham.lui.antlr.GrammarParser.IntegerContext;
import com.danielbigham.lui.antlr.GrammarParser.LhsContext;
import com.danielbigham.lui.antlr.GrammarParser.OrRulePart2Context;
import com.danielbigham.lui.antlr.GrammarParser.OrRulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.RealContext;
import com.danielbigham.lui.antlr.GrammarParser.RulePart2Context;
import com.danielbigham.lui.antlr.GrammarParser.RulePart3Context;
import com.danielbigham.lui.antlr.GrammarParser.RulePatternContext;
import com.danielbigham.lui.antlr.GrammarParser.SeqRulePartContext;
import com.danielbigham.lui.antlr.GrammarParser.SimpleRuleContext;
import com.danielbigham.lui.antlr.GrammarParser.StringContext;
import com.danielbigham.lui.antlr.GrammarParser.SymbolContext;
import com.danielbigham.lui.antlr.GrammarParser.WlSymbolContext;
import com.danielbigham.lui.antlr.GrammarParser.WsContext;
import com.danielbigham.lui.antlr.GrammarParser.WsnContext;

/**
 * Class that can be passed in to the ANTLR parser such that
 * 'exitGrammarRules' will be called upon finishing parsing
 * a set of grammar rules.
 * 
 * @author danielb
 */
public class GrammarRulesListener implements GrammarListener
{
	private final IRuleHandler ruleHandler;

	/**
	 * Construct GrammarRulesListener.
	 * 
	 * @param ruleHandler		the class that will be called with the ANTLR-parsed rules to actually do something with them.
	 */
	public GrammarRulesListener(IRuleHandler ruleHandler)
	{
		this.ruleHandler = ruleHandler;
	}
	
	@Override
	public void exitGrammarRules(GrammarRulesContext ctx)
	{
		if (ruleHandler != null) { ruleHandler.handle(ctx); }
	}

	@Override
	public void enterEveryRule(ParserRuleContext arg0)
	{

	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0)
	{

	}

	@Override
	public void visitErrorNode(ErrorNode arg0)
	{

	}

	@Override
	public void visitTerminal(TerminalNode arg0)
	{

	}

	@Override
	public void enterGrammarRules(GrammarRulesContext ctx)
	{

	}

	@Override
	public void enterGrammarRule(GrammarRuleContext ctx)
	{

	}

	@Override
	public void exitGrammarRule(GrammarRuleContext ctx)
	{

	}

	@Override
	public void enterLhs(LhsContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitLhs(LhsContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterBasicRulePart(BasicRulePartContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitBasicRulePart(BasicRulePartContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterSymbol(SymbolContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSymbol(SymbolContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterSimpleRule(SimpleRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSimpleRule(SimpleRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEReal(ERealContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEReal(ERealContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterESymbol(ESymbolContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitESymbol(ESymbolContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEHeadedExpr(EHeadedExprContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEHeadedExpr(EHeadedExprContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterERule(ERuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitERule(ERuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEList(EListContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEList(EListContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEInteger(EIntegerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEInteger(EIntegerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEDivide(EDivideContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEDivide(EDivideContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEPower(EPowerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEPower(EPowerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEPlus(EPlusContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEPlus(EPlusContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEString(EStringContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEString(EStringContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterETimes(ETimesContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitETimes(ETimesContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterWlSymbol(WlSymbolContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitWlSymbol(WlSymbolContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterString(StringContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitString(StringContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterInteger(IntegerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitInteger(IntegerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterReal(RealContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitReal(RealContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterOrRulePart(OrRulePartContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitOrRulePart(OrRulePartContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterSeqRulePart(SeqRulePartContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitSeqRulePart(SeqRulePartContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterBasicRulePart2(BasicRulePart2Context ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitBasicRulePart2(BasicRulePart2Context ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterBinding(BindingContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitBinding(BindingContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterWs(WsContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitWs(WsContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEnd_of_rule(End_of_ruleContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEnd_of_rule(End_of_ruleContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterRulePart3(RulePart3Context ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitRulePart3(RulePart3Context ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterOrRulePart2(OrRulePart2Context ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitOrRulePart2(OrRulePart2Context ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterRulePart2(RulePart2Context ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitRulePart2(RulePart2Context ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEUnsameQ(EUnsameQContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEUnsameQ(EUnsameQContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterESameQ(ESameQContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitESameQ(ESameQContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEEqual(EEqualContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEEqual(EEqualContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterWsn(WsnContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitWsn(WsnContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterRulePattern(RulePatternContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitRulePattern(RulePatternContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterESet(ESetContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitESet(ESetContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEOr(EOrContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEOr(EOrContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEAnd(EAndContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exitEAnd(EAndContext ctx)
	{
		// TODO Auto-generated method stub
		
	}

}
