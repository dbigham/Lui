// Generated from E:\Users\Daniel\Dropbox\Projects\Lui\AntlrGrammar\Grammar.g4 by ANTLR 4.5.3
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, STRING=16, 
		INTEGER=17, REAL=18, ARROW=19, COLON=20, EQUALS=21, ID=22, NEWLINE=23, 
		NEWLINE_DOUBLE_INDENT=24, NEWLINE_INDENT=25, WS=26, WS2=27;
	public static final int
		RULE_grammarRules = 0, RULE_grammarRule = 1, RULE_simpleRule = 2, RULE_lhs = 3, 
		RULE_rulePart = 4, RULE_basicRulePart = 5, RULE_symbol = 6, RULE_expr = 7, 
		RULE_wlSymbol = 8, RULE_string = 9, RULE_integer = 10, RULE_real = 11;
	public static final String[] ruleNames = {
		"grammarRules", "grammarRule", "simpleRule", "lhs", "rulePart", "basicRulePart", 
		"symbol", "expr", "wlSymbol", "string", "integer", "real"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'|'", "')'", "'$'", "'~'", "'{'", "','", "'}'", "'['", "']'", 
		"'^'", "'*'", "'/'", "'+'", "'-'", null, null, null, null, "':'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "STRING", "INTEGER", "REAL", "ARROW", "COLON", 
		"EQUALS", "ID", "NEWLINE", "NEWLINE_DOUBLE_INDENT", "NEWLINE_INDENT", 
		"WS", "WS2"
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
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS2) {
				{
				{
				setState(24);
				match(WS2);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			grammarRule();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << ID))) != 0)) {
				{
				{
				setState(31);
				grammarRule();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << WS) | (1L << WS2))) != 0)) {
				{
				{
				setState(37);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NEWLINE) | (1L << WS) | (1L << WS2))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(42);
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				lhs();
				setState(44);
				match(COLON);
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(45);
					rulePart();
					}
					}
					setState(48); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID))) != 0) );
				setState(50);
				match(NEWLINE_INDENT);
				setState(51);
				expr(0);
				setState(52);
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
				setState(54);
				lhs();
				setState(55);
				match(COLON);
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(56);
					rulePart();
					}
					}
					setState(59); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID))) != 0) );
				setState(61);
				match(ARROW);
				setState(62);
				expr(0);
				setState(63);
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
				setState(65);
				lhs();
				setState(66);
				match(COLON);
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(67);
					rulePart();
					}
					}
					setState(70); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID))) != 0) );
				setState(72);
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
				setState(74);
				lhs();
				setState(76);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(75);
					match(COLON);
					}
				}

				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(78);
					match(NEWLINE_INDENT);
					setState(79);
					simpleRule();
					}
					}
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE_INDENT );
				setState(84);
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
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(88);
					rulePart();
					}
					}
					setState(91); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID))) != 0) );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(93);
					rulePart();
					}
					}
					setState(96); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID))) != 0) );
				setState(98);
				match(ARROW);
				setState(99);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(101);
					rulePart();
					}
					}
					setState(104); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID))) != 0) );
				setState(106);
				match(NEWLINE_DOUBLE_INDENT);
				setState(107);
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
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
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
			setState(113);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(ID);
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
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

	public static class RulePartContext extends ParserRuleContext {
		public RulePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulePart; }
	 
		public RulePartContext() { }
		public void copyFrom(RulePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OrRulePartContext extends RulePartContext {
		public List<RulePartContext> rulePart() {
			return getRuleContexts(RulePartContext.class);
		}
		public RulePartContext rulePart(int i) {
			return getRuleContext(RulePartContext.class,i);
		}
		public OrRulePartContext(RulePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOrRulePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOrRulePart(this);
		}
	}
	public static class BasicRulePart2Context extends RulePartContext {
		public BasicRulePartContext basicRulePart() {
			return getRuleContext(BasicRulePartContext.class,0);
		}
		public BasicRulePart2Context(RulePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBasicRulePart2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBasicRulePart2(this);
		}
	}
	public static class SeqRulePartContext extends RulePartContext {
		public List<RulePartContext> rulePart() {
			return getRuleContexts(RulePartContext.class);
		}
		public RulePartContext rulePart(int i) {
			return getRuleContext(RulePartContext.class,i);
		}
		public SeqRulePartContext(RulePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSeqRulePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSeqRulePart(this);
		}
	}
	public static class BindingContext extends RulePartContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(GrammarParser.EQUALS, 0); }
		public RulePartContext rulePart() {
			return getRuleContext(RulePartContext.class,0);
		}
		public BindingContext(RulePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBinding(this);
		}
	}

	public final RulePartContext rulePart() throws RecognitionException {
		RulePartContext _localctx = new RulePartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rulePart);
		int _la;
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new OrRulePartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(T__0);
				setState(116);
				rulePart();
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(117);
					match(T__1);
					setState(118);
					rulePart();
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__1 );
				setState(123);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new SeqRulePartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(T__0);
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(126);
					rulePart();
					}
					}
					setState(129); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID))) != 0) );
				setState(131);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new BasicRulePart2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				basicRulePart();
				}
				break;
			case 4:
				_localctx = new BindingContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				match(ID);
				setState(135);
				match(EQUALS);
				setState(136);
				rulePart();
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
		enterRule(_localctx, 10, RULE_basicRulePart);
		try {
			setState(141);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(ID);
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
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
		enterRule(_localctx, 12, RULE_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(144);
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

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			switch (_input.LA(1)) {
			case STRING:
				{
				_localctx = new EStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(147);
				string();
				}
				break;
			case INTEGER:
				{
				_localctx = new EIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				integer();
				}
				break;
			case REAL:
				{
				_localctx = new ERealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				real();
				}
				break;
			case T__3:
			case ID:
				{
				_localctx = new ESymbolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				wlSymbol();
				}
				break;
			case T__5:
				{
				_localctx = new EListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(T__5);
				setState(152);
				expr(0);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(153);
					match(T__6);
					setState(154);
					expr(0);
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(160);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(194);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ERuleContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(165);
						match(ARROW);
						setState(166);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new EPowerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(168);
						match(T__10);
						setState(169);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ETimesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(171);
						match(T__11);
						setState(172);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new EDivideContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(174);
						match(T__12);
						setState(175);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new EPlusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(177);
						match(T__13);
						setState(178);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new EPlusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(180);
						match(T__14);
						setState(181);
						expr(2);
						}
						break;
					case 7:
						{
						_localctx = new EHeadedExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(183);
						match(T__8);
						setState(184);
						expr(0);
						setState(189);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__6) {
							{
							{
							setState(185);
							match(T__6);
							setState(186);
							expr(0);
							}
							}
							setState(191);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(192);
						match(T__9);
						}
						break;
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		enterRule(_localctx, 16, RULE_wlSymbol);
		try {
			setState(202);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(ID);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(T__3);
				setState(201);
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
		enterRule(_localctx, 18, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
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
		enterRule(_localctx, 20, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
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
		enterRule(_localctx, 22, RULE_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
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
		case 7:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u00d5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\7\2#\n\2"+
		"\f\2\16\2&\13\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\3\3\3\3\3\6\3\61\n\3\r\3"+
		"\16\3\62\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3<\n\3\r\3\16\3=\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\6\3G\n\3\r\3\16\3H\3\3\3\3\3\3\3\3\5\3O\n\3\3\3\3\3\6\3"+
		"S\n\3\r\3\16\3T\3\3\3\3\5\3Y\n\3\3\4\6\4\\\n\4\r\4\16\4]\3\4\6\4a\n\4"+
		"\r\4\16\4b\3\4\3\4\3\4\3\4\6\4i\n\4\r\4\16\4j\3\4\3\4\3\4\5\4p\n\4\3\5"+
		"\3\5\5\5t\n\5\3\6\3\6\3\6\3\6\6\6z\n\6\r\6\16\6{\3\6\3\6\3\6\3\6\6\6\u0082"+
		"\n\6\r\6\16\6\u0083\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008c\n\6\3\7\3\7\5\7"+
		"\u0090\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u009e\n"+
		"\t\f\t\16\t\u00a1\13\t\3\t\3\t\5\t\u00a5\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t"+
		"\u00be\n\t\f\t\16\t\u00c1\13\t\3\t\3\t\7\t\u00c5\n\t\f\t\16\t\u00c8\13"+
		"\t\3\n\3\n\3\n\5\n\u00cd\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\2\3\20\16\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\2\5\4\2\31\31\34\35\3\3\31\31\3\2\6\7\u00ed"+
		"\2\35\3\2\2\2\4X\3\2\2\2\6o\3\2\2\2\bs\3\2\2\2\n\u008b\3\2\2\2\f\u008f"+
		"\3\2\2\2\16\u0091\3\2\2\2\20\u00a4\3\2\2\2\22\u00cc\3\2\2\2\24\u00ce\3"+
		"\2\2\2\26\u00d0\3\2\2\2\30\u00d2\3\2\2\2\32\34\7\35\2\2\33\32\3\2\2\2"+
		"\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 "+
		"$\5\4\3\2!#\5\4\3\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%*\3\2\2"+
		"\2&$\3\2\2\2\')\t\2\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\3\3"+
		"\2\2\2,*\3\2\2\2-.\5\b\5\2.\60\7\26\2\2/\61\5\n\6\2\60/\3\2\2\2\61\62"+
		"\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\33\2\2\65\66"+
		"\5\20\t\2\66\67\t\3\2\2\67Y\3\2\2\289\5\b\5\29;\7\26\2\2:<\5\n\6\2;:\3"+
		"\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\7\25\2\2@A\5\20\t\2A"+
		"B\t\3\2\2BY\3\2\2\2CD\5\b\5\2DF\7\26\2\2EG\5\n\6\2FE\3\2\2\2GH\3\2\2\2"+
		"HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\t\3\2\2KY\3\2\2\2LN\5\b\5\2MO\7\26\2"+
		"\2NM\3\2\2\2NO\3\2\2\2OR\3\2\2\2PQ\7\33\2\2QS\5\6\4\2RP\3\2\2\2ST\3\2"+
		"\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\t\3\2\2WY\3\2\2\2X-\3\2\2\2X8\3\2"+
		"\2\2XC\3\2\2\2XL\3\2\2\2Y\5\3\2\2\2Z\\\5\n\6\2[Z\3\2\2\2\\]\3\2\2\2]["+
		"\3\2\2\2]^\3\2\2\2^p\3\2\2\2_a\5\n\6\2`_\3\2\2\2ab\3\2\2\2b`\3\2\2\2b"+
		"c\3\2\2\2cd\3\2\2\2de\7\25\2\2ef\5\20\t\2fp\3\2\2\2gi\5\n\6\2hg\3\2\2"+
		"\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\32\2\2mn\5\20\t\2np\3\2"+
		"\2\2o[\3\2\2\2o`\3\2\2\2oh\3\2\2\2p\7\3\2\2\2qt\7\30\2\2rt\5\16\b\2sq"+
		"\3\2\2\2sr\3\2\2\2t\t\3\2\2\2uv\7\3\2\2vy\5\n\6\2wx\7\4\2\2xz\5\n\6\2"+
		"yw\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7\5\2\2~\u008c\3"+
		"\2\2\2\177\u0081\7\3\2\2\u0080\u0082\5\n\6\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0086\7\5\2\2\u0086\u008c\3\2\2\2\u0087\u008c\5\f\7\2\u0088"+
		"\u0089\7\30\2\2\u0089\u008a\7\27\2\2\u008a\u008c\5\n\6\2\u008bu\3\2\2"+
		"\2\u008b\177\3\2\2\2\u008b\u0087\3\2\2\2\u008b\u0088\3\2\2\2\u008c\13"+
		"\3\2\2\2\u008d\u0090\7\30\2\2\u008e\u0090\5\16\b\2\u008f\u008d\3\2\2\2"+
		"\u008f\u008e\3\2\2\2\u0090\r\3\2\2\2\u0091\u0092\t\4\2\2\u0092\u0093\7"+
		"\30\2\2\u0093\17\3\2\2\2\u0094\u0095\b\t\1\2\u0095\u00a5\5\24\13\2\u0096"+
		"\u00a5\5\26\f\2\u0097\u00a5\5\30\r\2\u0098\u00a5\5\22\n\2\u0099\u009a"+
		"\7\b\2\2\u009a\u009f\5\20\t\2\u009b\u009c\7\t\2\2\u009c\u009e\5\20\t\2"+
		"\u009d\u009b\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\n\2\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u0094\3\2\2\2\u00a4\u0096\3\2\2\2\u00a4\u0097\3\2"+
		"\2\2\u00a4\u0098\3\2\2\2\u00a4\u0099\3\2\2\2\u00a5\u00c6\3\2\2\2\u00a6"+
		"\u00a7\f\n\2\2\u00a7\u00a8\7\25\2\2\u00a8\u00c5\5\20\t\13\u00a9\u00aa"+
		"\f\7\2\2\u00aa\u00ab\7\r\2\2\u00ab\u00c5\5\20\t\b\u00ac\u00ad\f\6\2\2"+
		"\u00ad\u00ae\7\16\2\2\u00ae\u00c5\5\20\t\7\u00af\u00b0\f\5\2\2\u00b0\u00b1"+
		"\7\17\2\2\u00b1\u00c5\5\20\t\6\u00b2\u00b3\f\4\2\2\u00b3\u00b4\7\20\2"+
		"\2\u00b4\u00c5\5\20\t\5\u00b5\u00b6\f\3\2\2\u00b6\u00b7\7\21\2\2\u00b7"+
		"\u00c5\5\20\t\4\u00b8\u00b9\f\b\2\2\u00b9\u00ba\7\13\2\2\u00ba\u00bf\5"+
		"\20\t\2\u00bb\u00bc\7\t\2\2\u00bc\u00be\5\20\t\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c3\7\f\2\2\u00c3\u00c5\3\2\2\2\u00c4"+
		"\u00a6\3\2\2\2\u00c4\u00a9\3\2\2\2\u00c4\u00ac\3\2\2\2\u00c4\u00af\3\2"+
		"\2\2\u00c4\u00b2\3\2\2\2\u00c4\u00b5\3\2\2\2\u00c4\u00b8\3\2\2\2\u00c5"+
		"\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\21\3\2\2"+
		"\2\u00c8\u00c6\3\2\2\2\u00c9\u00cd\7\30\2\2\u00ca\u00cb\7\6\2\2\u00cb"+
		"\u00cd\7\30\2\2\u00cc\u00c9\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\23\3\2\2"+
		"\2\u00ce\u00cf\7\22\2\2\u00cf\25\3\2\2\2\u00d0\u00d1\7\23\2\2\u00d1\27"+
		"\3\2\2\2\u00d2\u00d3\7\24\2\2\u00d3\31\3\2\2\2\32\35$*\62=HNTX]bjos{\u0083"+
		"\u008b\u008f\u009f\u00a4\u00bf\u00c4\u00c6\u00cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}