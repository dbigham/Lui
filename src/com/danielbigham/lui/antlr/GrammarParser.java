// Generated from Grammar.g4 by ANTLR 4.5.3
package com.danielbigham.lui.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, STRING=13, INTEGER=14, REAL=15, ARROW=16, 
		COLON=17, ID=18, NEWLINE=19, NEWLINE_DOUBLE_INDENT=20, NEWLINE_INDENT=21, 
		WS=22, WS2=23, INDENT=24;
	public static final int
		RULE_grammarRules = 0, RULE_grammarRule = 1, RULE_simpleRule = 2, RULE_lhs = 3, 
		RULE_rulePart = 4, RULE_or = 5, RULE_basicRulePart = 6, RULE_symbol = 7, 
		RULE_expr = 8, RULE_wlSymbol = 9, RULE_string = 10, RULE_integer = 11, 
		RULE_real = 12;
	public static final String[] ruleNames = {
		"grammarRules", "grammarRule", "simpleRule", "lhs", "rulePart", "or", 
		"basicRulePart", "symbol", "expr", "wlSymbol", "string", "integer", "real"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "'$'", "'{'", "','", "'}'", "'['", "']'", "'^'", "'*'", "'/'", 
		"'+'", "'-'", null, null, null, null, "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "STRING", "INTEGER", "REAL", "ARROW", "COLON", "ID", "NEWLINE", 
		"NEWLINE_DOUBLE_INDENT", "NEWLINE_INDENT", "WS", "WS2", "INDENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GrammarRulesContext extends ParserRuleContext {
		public List<GrammarRuleContext> grammarRule() {
			return getRuleContexts(GrammarRuleContext.class);
		}
		public GrammarRuleContext grammarRule(int i) {
			return getRuleContext(GrammarRuleContext.class,i);
		}
		public List<TerminalNode> WS2() { return getTokens(GrammarParser.WS2); }
		public TerminalNode WS2(int i) {
			return getToken(GrammarParser.WS2, i);
		}
		public List<TerminalNode> WS() { return getTokens(GrammarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(GrammarParser.WS, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(GrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GrammarParser.NEWLINE, i);
		}
		public GrammarRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterGrammarRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitGrammarRules(this);
		}
	}

	public final GrammarRulesContext grammarRules() throws RecognitionException {
		GrammarRulesContext _localctx = new GrammarRulesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_grammarRules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS2) {
				{
				{
				setState(26);
				match(WS2);
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
			grammarRule();
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(33);
				grammarRule();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << WS) | (1L << WS2))) != 0)) {
				{
				{
				setState(39);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << WS) | (1L << WS2))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GrammarRuleContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GrammarParser.COLON, 0); }
		public List<TerminalNode> NEWLINE_INDENT() { return getTokens(GrammarParser.NEWLINE_INDENT); }
		public TerminalNode NEWLINE_INDENT(int i) {
			return getToken(GrammarParser.NEWLINE_INDENT, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GrammarParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<RulePartContext> rulePart() {
			return getRuleContexts(RulePartContext.class);
		}
		public RulePartContext rulePart(int i) {
			return getRuleContext(RulePartContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(GrammarParser.ARROW, 0); }
		public List<SimpleRuleContext> simpleRule() {
			return getRuleContexts(SimpleRuleContext.class);
		}
		public SimpleRuleContext simpleRule(int i) {
			return getRuleContext(SimpleRuleContext.class,i);
		}
		public GrammarRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grammarRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterGrammarRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitGrammarRule(this);
		}
	}

	public final GrammarRuleContext grammarRule() throws RecognitionException {
		GrammarRuleContext _localctx = new GrammarRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammarRule);
		int _la;
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				lhs();
				setState(46);
				match(COLON);
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(47);
					rulePart();
					}
					}
					setState(50); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 || _la==ID );
				setState(52);
				match(NEWLINE_INDENT);
				setState(53);
				expr(0);
				setState(54);
				_la = _input.LA(1);
				if ( !(_la==EOF || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				lhs();
				setState(57);
				match(COLON);
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(58);
					rulePart();
					}
					}
					setState(61); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 || _la==ID );
				setState(63);
				match(ARROW);
				setState(64);
				expr(0);
				setState(65);
				_la = _input.LA(1);
				if ( !(_la==EOF || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				lhs();
				setState(68);
				match(COLON);
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(69);
					rulePart();
					}
					}
					setState(72); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 || _la==ID );
				setState(74);
				_la = _input.LA(1);
				if ( !(_la==EOF || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				lhs();
				setState(78);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(77);
					match(COLON);
					}
				}

				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(80);
					match(NEWLINE_INDENT);
					setState(81);
					simpleRule();
					}
					}
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE_INDENT );
				setState(86);
				_la = _input.LA(1);
				if ( !(_la==EOF || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimpleRuleContext extends ParserRuleContext {
		public List<RulePartContext> rulePart() {
			return getRuleContexts(RulePartContext.class);
		}
		public RulePartContext rulePart(int i) {
			return getRuleContext(RulePartContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(GrammarParser.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE_DOUBLE_INDENT() { return getToken(GrammarParser.NEWLINE_DOUBLE_INDENT, 0); }
		public SimpleRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSimpleRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSimpleRule(this);
		}
	}

	public final SimpleRuleContext simpleRule() throws RecognitionException {
		SimpleRuleContext _localctx = new SimpleRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simpleRule);
		int _la;
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(90);
					rulePart();
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 || _la==ID );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					rulePart();
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 || _la==ID );
				setState(100);
				match(ARROW);
				setState(101);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(103);
					rulePart();
					}
					}
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 || _la==ID );
				setState(108);
				match(NEWLINE_DOUBLE_INDENT);
				setState(109);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LhsContext extends ParserRuleContext {
		public Token symbolName;
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public LhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLhs(this);
		}
	}

	public final LhsContext lhs() throws RecognitionException {
		LhsContext _localctx = new LhsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lhs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			((LhsContext)_localctx).symbolName = match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RulePartContext extends ParserRuleContext {
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public BasicRulePartContext basicRulePart() {
			return getRuleContext(BasicRulePartContext.class,0);
		}
		public RulePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRulePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRulePart(this);
		}
	}

	public final RulePartContext rulePart() throws RecognitionException {
		RulePartContext _localctx = new RulePartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rulePart);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				or();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				basicRulePart();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrContext extends ParserRuleContext {
		public List<BasicRulePartContext> basicRulePart() {
			return getRuleContexts(BasicRulePartContext.class);
		}
		public BasicRulePartContext basicRulePart(int i) {
			return getRuleContext(BasicRulePartContext.class,i);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOr(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_or);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			basicRulePart();
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				match(T__0);
				setState(121);
				basicRulePart();
				}
				}
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasicRulePartContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public BasicRulePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicRulePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBasicRulePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBasicRulePart(this);
		}
	}

	public final BasicRulePartContext basicRulePart() throws RecognitionException {
		BasicRulePartContext _localctx = new BasicRulePartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_basicRulePart);
		try {
			setState(128);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(ID);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				symbol();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SymbolContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSymbol(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_symbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__1);
			setState(131);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ERealContext extends ExprContext {
		public RealContext real() {
			return getRuleContext(RealContext.class,0);
		}
		public ERealContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEReal(this);
		}
	}
	public static class ESymbolContext extends ExprContext {
		public WlSymbolContext wlSymbol() {
			return getRuleContext(WlSymbolContext.class,0);
		}
		public ESymbolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterESymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitESymbol(this);
		}
	}
	public static class EHeadedExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EHeadedExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEHeadedExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEHeadedExpr(this);
		}
	}
	public static class ERuleContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(GrammarParser.ARROW, 0); }
		public ERuleContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterERule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitERule(this);
		}
	}
	public static class EListContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EListContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEList(this);
		}
	}
	public static class EIntegerContext extends ExprContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public EIntegerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEInteger(this);
		}
	}
	public static class EDivideContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EDivideContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEDivide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEDivide(this);
		}
	}
	public static class EPowerContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EPowerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEPower(this);
		}
	}
	public static class EPlusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EPlusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEPlus(this);
		}
	}
	public static class EStringContext extends ExprContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public EStringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEString(this);
		}
	}
	public static class ETimesContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ETimesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterETimes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitETimes(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			switch (_input.LA(1)) {
			case STRING:
				{
				_localctx = new EStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				string();
				}
				break;
			case INTEGER:
				{
				_localctx = new EIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				integer();
				}
				break;
			case REAL:
				{
				_localctx = new ERealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				real();
				}
				break;
			case T__1:
			case ID:
				{
				_localctx = new ESymbolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				wlSymbol();
				}
				break;
			case T__2:
				{
				_localctx = new EListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				match(T__2);
				setState(139);
				expr(0);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(140);
					match(T__3);
					setState(141);
					expr(0);
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(147);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(181);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new ERuleContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(152);
						match(ARROW);
						setState(153);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new EPowerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(155);
						match(T__7);
						setState(156);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ETimesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(158);
						match(T__8);
						setState(159);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new EDivideContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(161);
						match(T__9);
						setState(162);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new EPlusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(163);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(164);
						match(T__10);
						setState(165);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new EPlusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(166);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(167);
						match(T__11);
						setState(168);
						expr(2);
						}
						break;
					case 7:
						{
						_localctx = new EHeadedExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(170);
						match(T__5);
						setState(171);
						expr(0);
						setState(176);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__3) {
							{
							{
							setState(172);
							match(T__3);
							setState(173);
							expr(0);
							}
							}
							setState(178);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(179);
						match(T__6);
						}
						break;
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class WlSymbolContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public WlSymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wlSymbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWlSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWlSymbol(this);
		}
	}

	public final WlSymbolContext wlSymbol() throws RecognitionException {
		WlSymbolContext _localctx = new WlSymbolContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_wlSymbol);
		try {
			setState(189);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(ID);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(T__1);
				setState(188);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(GrammarParser.INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RealContext extends ParserRuleContext {
		public TerminalNode REAL() { return getToken(GrammarParser.REAL, 0); }
		public RealContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitReal(this);
		}
	}

	public final RealContext real() throws RecognitionException {
		RealContext _localctx = new RealContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(REAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u00c8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\3\3\3\3\3\6\3\63"+
		"\n\3\r\3\16\3\64\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3>\n\3\r\3\16\3?\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\6\3I\n\3\r\3\16\3J\3\3\3\3\3\3\3\3\5\3Q\n\3\3\3"+
		"\3\3\6\3U\n\3\r\3\16\3V\3\3\3\3\5\3[\n\3\3\4\6\4^\n\4\r\4\16\4_\3\4\6"+
		"\4c\n\4\r\4\16\4d\3\4\3\4\3\4\3\4\6\4k\n\4\r\4\16\4l\3\4\3\4\3\4\5\4r"+
		"\n\4\3\5\3\5\3\6\3\6\5\6x\n\6\3\7\3\7\3\7\6\7}\n\7\r\7\16\7~\3\b\3\b\5"+
		"\b\u0083\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0091"+
		"\n\n\f\n\16\n\u0094\13\n\3\n\3\n\5\n\u0098\n\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7"+
		"\n\u00b1\n\n\f\n\16\n\u00b4\13\n\3\n\3\n\7\n\u00b8\n\n\f\n\16\n\u00bb"+
		"\13\n\3\13\3\13\3\13\5\13\u00c0\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\2"+
		"\3\22\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\4\2\25\25\30\31\3\3\25\25"+
		"\u00db\2\37\3\2\2\2\4Z\3\2\2\2\6q\3\2\2\2\bs\3\2\2\2\nw\3\2\2\2\fy\3\2"+
		"\2\2\16\u0082\3\2\2\2\20\u0084\3\2\2\2\22\u0097\3\2\2\2\24\u00bf\3\2\2"+
		"\2\26\u00c1\3\2\2\2\30\u00c3\3\2\2\2\32\u00c5\3\2\2\2\34\36\7\31\2\2\35"+
		"\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2"+
		"\2\"&\5\4\3\2#%\5\4\3\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\',\3"+
		"\2\2\2(&\3\2\2\2)+\t\2\2\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\3"+
		"\3\2\2\2.,\3\2\2\2/\60\5\b\5\2\60\62\7\23\2\2\61\63\5\n\6\2\62\61\3\2"+
		"\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7\27"+
		"\2\2\678\5\22\n\289\t\3\2\29[\3\2\2\2:;\5\b\5\2;=\7\23\2\2<>\5\n\6\2="+
		"<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\22\2\2BC\5\22\n"+
		"\2CD\t\3\2\2D[\3\2\2\2EF\5\b\5\2FH\7\23\2\2GI\5\n\6\2HG\3\2\2\2IJ\3\2"+
		"\2\2JH\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\t\3\2\2M[\3\2\2\2NP\5\b\5\2OQ\7\23"+
		"\2\2PO\3\2\2\2PQ\3\2\2\2QT\3\2\2\2RS\7\27\2\2SU\5\6\4\2TR\3\2\2\2UV\3"+
		"\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\t\3\2\2Y[\3\2\2\2Z/\3\2\2\2Z:\3"+
		"\2\2\2ZE\3\2\2\2ZN\3\2\2\2[\5\3\2\2\2\\^\5\n\6\2]\\\3\2\2\2^_\3\2\2\2"+
		"_]\3\2\2\2_`\3\2\2\2`r\3\2\2\2ac\5\n\6\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2"+
		"de\3\2\2\2ef\3\2\2\2fg\7\22\2\2gh\5\22\n\2hr\3\2\2\2ik\5\n\6\2ji\3\2\2"+
		"\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7\26\2\2op\5\22\n\2pr\3\2"+
		"\2\2q]\3\2\2\2qb\3\2\2\2qj\3\2\2\2r\7\3\2\2\2st\7\24\2\2t\t\3\2\2\2ux"+
		"\5\f\7\2vx\5\16\b\2wu\3\2\2\2wv\3\2\2\2x\13\3\2\2\2y|\5\16\b\2z{\7\3\2"+
		"\2{}\5\16\b\2|z\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\r\3\2\2\2"+
		"\u0080\u0083\7\24\2\2\u0081\u0083\5\20\t\2\u0082\u0080\3\2\2\2\u0082\u0081"+
		"\3\2\2\2\u0083\17\3\2\2\2\u0084\u0085\7\4\2\2\u0085\u0086\7\24\2\2\u0086"+
		"\21\3\2\2\2\u0087\u0088\b\n\1\2\u0088\u0098\5\26\f\2\u0089\u0098\5\30"+
		"\r\2\u008a\u0098\5\32\16\2\u008b\u0098\5\24\13\2\u008c\u008d\7\5\2\2\u008d"+
		"\u0092\5\22\n\2\u008e\u008f\7\6\2\2\u008f\u0091\5\22\n\2\u0090\u008e\3"+
		"\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7\7\2\2\u0096\u0098\3\2"+
		"\2\2\u0097\u0087\3\2\2\2\u0097\u0089\3\2\2\2\u0097\u008a\3\2\2\2\u0097"+
		"\u008b\3\2\2\2\u0097\u008c\3\2\2\2\u0098\u00b9\3\2\2\2\u0099\u009a\f\n"+
		"\2\2\u009a\u009b\7\22\2\2\u009b\u00b8\5\22\n\13\u009c\u009d\f\7\2\2\u009d"+
		"\u009e\7\n\2\2\u009e\u00b8\5\22\n\b\u009f\u00a0\f\6\2\2\u00a0\u00a1\7"+
		"\13\2\2\u00a1\u00b8\5\22\n\7\u00a2\u00a3\f\5\2\2\u00a3\u00a4\7\f\2\2\u00a4"+
		"\u00b8\5\22\n\6\u00a5\u00a6\f\4\2\2\u00a6\u00a7\7\r\2\2\u00a7\u00b8\5"+
		"\22\n\5\u00a8\u00a9\f\3\2\2\u00a9\u00aa\7\16\2\2\u00aa\u00b8\5\22\n\4"+
		"\u00ab\u00ac\f\b\2\2\u00ac\u00ad\7\b\2\2\u00ad\u00b2\5\22\n\2\u00ae\u00af"+
		"\7\6\2\2\u00af\u00b1\5\22\n\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2"+
		"\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b5\u00b6\7\t\2\2\u00b6\u00b8\3\2\2\2\u00b7\u0099\3\2\2\2\u00b7"+
		"\u009c\3\2\2\2\u00b7\u009f\3\2\2\2\u00b7\u00a2\3\2\2\2\u00b7\u00a5\3\2"+
		"\2\2\u00b7\u00a8\3\2\2\2\u00b7\u00ab\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\23\3\2\2\2\u00bb\u00b9\3\2\2"+
		"\2\u00bc\u00c0\7\24\2\2\u00bd\u00be\7\4\2\2\u00be\u00c0\7\24\2\2\u00bf"+
		"\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\25\3\2\2\2\u00c1\u00c2\7\17\2"+
		"\2\u00c2\27\3\2\2\2\u00c3\u00c4\7\20\2\2\u00c4\31\3\2\2\2\u00c5\u00c6"+
		"\7\21\2\2\u00c6\33\3\2\2\2\30\37&,\64?JPVZ_dlqw~\u0082\u0092\u0097\u00b2"+
		"\u00b7\u00b9\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}