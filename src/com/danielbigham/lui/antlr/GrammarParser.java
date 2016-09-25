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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, INTEGER=19, REAL=20, ARROW=21, COLON=22, EQUALS=23, ID=24, DOUBLE_INDENT=25, 
		INDENT=26, NEWLINE=27, OTHER_WS=28, STRING=29, WS=30;
	public static final int
		RULE_grammarRules = 0, RULE_end_of_rule = 1, RULE_grammarRule = 2, RULE_simpleRule = 3, 
		RULE_lhs = 4, RULE_rulePart3 = 5, RULE_rulePart = 6, RULE_rulePart2 = 7, 
		RULE_basicRulePart = 8, RULE_symbol = 9, RULE_expr = 10, RULE_wlSymbol = 11, 
		RULE_string = 12, RULE_integer = 13, RULE_real = 14, RULE_ws = 15, RULE_wsn = 16;
	public static final String[] ruleNames = {
		"grammarRules", "end_of_rule", "grammarRule", "simpleRule", "lhs", "rulePart3", 
		"rulePart", "rulePart2", "basicRulePart", "symbol", "expr", "wlSymbol", 
		"string", "integer", "real", "ws", "wsn"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'|'", "')'", "'$'", "'~'", "'{'", "','", "'}'", "'['", "']'", 
		"'^'", "'*'", "'/'", "'+'", "'-'", "'=='", "'==='", "'=!='", null, null, 
		null, "':'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "INTEGER", "REAL", "ARROW", 
		"COLON", "EQUALS", "ID", "DOUBLE_INDENT", "INDENT", "NEWLINE", "OTHER_WS", 
		"STRING", "WS"
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
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
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
				{
				setState(36);
				switch (_input.LA(1)) {
				case DOUBLE_INDENT:
				case INDENT:
				case OTHER_WS:
					{
					setState(34);
					ws();
					}
					break;
				case NEWLINE:
					{
					setState(35);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			grammarRule();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << ID))) != 0)) {
				{
				{
				setState(42);
				grammarRule();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
				{
				setState(50);
				switch (_input.LA(1)) {
				case DOUBLE_INDENT:
				case INDENT:
				case OTHER_WS:
					{
					setState(48);
					ws();
					}
					break;
				case NEWLINE:
					{
					setState(49);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(54);
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

	public static class End_of_ruleContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(GrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GrammarParser.NEWLINE, i);
		}
		public End_of_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_of_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEnd_of_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEnd_of_rule(this);
		}
	}

	public final End_of_ruleContext end_of_rule() throws RecognitionException {
		End_of_ruleContext _localctx = new End_of_ruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_end_of_rule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
				{
				{
				setState(55);
				ws();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				setState(68); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(61);
						match(NEWLINE);
						setState(65);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(62);
								ws();
								}
								} 
							}
							setState(67);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(70); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case EOF:
				{
				setState(72);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public List<TerminalNode> NEWLINE() { return getTokens(GrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GrammarParser.NEWLINE, i);
		}
		public List<TerminalNode> INDENT() { return getTokens(GrammarParser.INDENT); }
		public TerminalNode INDENT(int i) {
			return getToken(GrammarParser.INDENT, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public End_of_ruleContext end_of_rule() {
			return getRuleContext(End_of_ruleContext.class,0);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public List<RulePart3Context> rulePart3() {
			return getRuleContexts(RulePart3Context.class);
		}
		public RulePart3Context rulePart3(int i) {
			return getRuleContext(RulePart3Context.class,i);
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
		enterRule(_localctx, 4, RULE_grammarRule);
		int _la;
		try {
			int _alt;
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				lhs();
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(76);
					ws();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
				match(COLON);
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(83);
					ws();
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(89);
					rulePart3();
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(90);
						ws();
						}
						}
						setState(95);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID) | (1L << STRING))) != 0) );
				setState(100);
				match(NEWLINE);
				setState(101);
				match(INDENT);
				setState(102);
				expr(0);
				setState(103);
				end_of_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				lhs();
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(106);
					ws();
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(COLON);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(113);
					ws();
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(126); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(119);
					rulePart3();
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(120);
						ws();
						}
						}
						setState(125);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(128); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID) | (1L << STRING))) != 0) );
				setState(130);
				match(ARROW);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(131);
					ws();
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(137);
				expr(0);
				setState(138);
				end_of_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				lhs();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(141);
					ws();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(147);
				match(COLON);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(148);
					ws();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(154);
					rulePart3();
					setState(158);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(155);
							ws();
							}
							} 
						}
						setState(160);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					}
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID) | (1L << STRING))) != 0) );
				setState(165);
				end_of_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				lhs();
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(168);
						ws();
						}
						} 
					}
					setState(173);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				setState(175);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(174);
					match(COLON);
					}
				}

				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(177);
					ws();
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(204); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(183);
						match(NEWLINE);
						setState(193);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(187);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
									{
									{
									setState(184);
									ws();
									}
									}
									setState(189);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								setState(190);
								match(NEWLINE);
								}
								} 
							}
							setState(195);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						}
						setState(196);
						match(INDENT);
						setState(197);
						simpleRule();
						setState(201);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(198);
								ws();
								}
								} 
							}
							setState(203);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(206); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(208);
				end_of_rule();
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
		public List<RulePart3Context> rulePart3() {
			return getRuleContexts(RulePart3Context.class);
		}
		public RulePart3Context rulePart3(int i) {
			return getRuleContext(RulePart3Context.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(GrammarParser.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GrammarParser.NEWLINE, 0); }
		public TerminalNode DOUBLE_INDENT() { return getToken(GrammarParser.DOUBLE_INDENT, 0); }
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
		enterRule(_localctx, 6, RULE_simpleRule);
		int _la;
		try {
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(212);
					rulePart3();
					setState(214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						setState(213);
						ws();
						}
						break;
					}
					}
					}
					setState(218); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID) | (1L << STRING))) != 0) );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(220);
					rulePart3();
					setState(222);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						setState(221);
						ws();
						}
					}

					}
					}
					setState(226); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID) | (1L << STRING))) != 0) );
				setState(228);
				match(ARROW);
				setState(230);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					setState(229);
					ws();
					}
				}

				setState(232);
				expr(0);
				setState(234);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(233);
					ws();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(236);
					rulePart3();
					setState(238);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						setState(237);
						ws();
						}
					}

					}
					}
					setState(242); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID) | (1L << STRING))) != 0) );
				setState(244);
				match(NEWLINE);
				setState(245);
				match(DOUBLE_INDENT);
				setState(246);
				expr(0);
				setState(248);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(247);
					ws();
					}
					break;
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
		enterRule(_localctx, 8, RULE_lhs);
		try {
			setState(254);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				match(ID);
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
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

	public static class RulePart3Context extends ParserRuleContext {
		public RulePartContext rulePart() {
			return getRuleContext(RulePartContext.class,0);
		}
		public RulePart2Context rulePart2() {
			return getRuleContext(RulePart2Context.class,0);
		}
		public RulePart3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulePart3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRulePart3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRulePart3(this);
		}
	}

	public final RulePart3Context rulePart3() throws RecognitionException {
		RulePart3Context _localctx = new RulePart3Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_rulePart3);
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				rulePart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				rulePart2();
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
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
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
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
	public static class OrRulePart2Context extends RulePartContext {
		public RulePart2Context rulePart2() {
			return getRuleContext(RulePart2Context.class,0);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public OrRulePart2Context(RulePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOrRulePart2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOrRulePart2(this);
		}
	}
	public static class BindingContext extends RulePartContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode EQUALS() { return getToken(GrammarParser.EQUALS, 0); }
		public RulePartContext rulePart() {
			return getRuleContext(RulePartContext.class,0);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
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
		enterRule(_localctx, 12, RULE_rulePart);
		int _la;
		try {
			int _alt;
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				_localctx = new OrRulePartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				match(T__0);
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(261);
					ws();
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(267);
				rulePart();
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(268);
						ws();
						}
						} 
					}
					setState(273);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				}
				setState(288); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(274);
						ws();
						}
						}
						setState(279);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(280);
					match(T__1);
					setState(284);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(281);
						ws();
						}
						}
						setState(286);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(287);
					rulePart();
					}
					}
					setState(290); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0) );
				setState(292);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new SeqRulePartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				match(T__0);
				setState(302); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(295);
					rulePart();
					setState(299);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(296);
						ws();
						}
						}
						setState(301);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(304); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << ID) | (1L << STRING))) != 0) );
				setState(306);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new BasicRulePart2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(308);
				basicRulePart();
				}
				break;
			case 4:
				_localctx = new OrRulePart2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(309);
				match(T__0);
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(310);
					ws();
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(316);
				rulePart2();
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(317);
					ws();
					}
					}
					setState(322);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(323);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new BindingContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(325);
				match(ID);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(326);
					ws();
					}
					}
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(332);
				match(EQUALS);
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(333);
					ws();
					}
					}
					setState(338);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(339);
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

	public static class RulePart2Context extends ParserRuleContext {
		public List<BasicRulePartContext> basicRulePart() {
			return getRuleContexts(BasicRulePartContext.class);
		}
		public BasicRulePartContext basicRulePart(int i) {
			return getRuleContext(BasicRulePartContext.class,i);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
		}
		public RulePart2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulePart2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRulePart2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRulePart2(this);
		}
	}

	public final RulePart2Context rulePart2() throws RecognitionException {
		RulePart2Context _localctx = new RulePart2Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_rulePart2);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			basicRulePart();
			setState(357); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(343);
						ws();
						}
						}
						setState(348);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(349);
					match(T__1);
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(350);
						ws();
						}
						}
						setState(355);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(356);
					basicRulePart();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(359); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
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
		enterRule(_localctx, 16, RULE_basicRulePart);
		try {
			setState(364);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				match(ID);
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				symbol();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
				match(STRING);
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
		enterRule(_localctx, 18, RULE_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(367);
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
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
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
	public static class ERuleContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(GrammarParser.ARROW, 0); }
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
		}
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
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
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
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
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
	public static class EUnsameQContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
		}
		public EUnsameQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEUnsameQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEUnsameQ(this);
		}
	}
	public static class EPlusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
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
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
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
	public static class ESameQContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
		}
		public ESameQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterESameQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitESameQ(this);
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
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
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
	public static class EEqualContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<WsnContext> wsn() {
			return getRuleContexts(WsnContext.class);
		}
		public WsnContext wsn(int i) {
			return getRuleContext(WsnContext.class,i);
		}
		public EEqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEEqual(this);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				_localctx = new EStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(370);
				string();
				}
				break;
			case 2:
				{
				_localctx = new EIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371);
				integer();
				}
				break;
			case 3:
				{
				_localctx = new ERealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(372);
				real();
				}
				break;
			case 4:
				{
				_localctx = new ESymbolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(373);
				wlSymbol();
				}
				break;
			case 5:
				{
				_localctx = new EListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(374);
				match(T__5);
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(375);
					wsn();
					}
					}
					setState(380);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(381);
				expr(0);
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(382);
					wsn();
					}
					}
					setState(387);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(388);
					match(T__6);
					setState(392);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(389);
						wsn();
						}
						}
						setState(394);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(395);
					expr(0);
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(396);
						wsn();
						}
						}
						setState(401);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(406);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(407);
				match(T__7);
				}
				break;
			case 6:
				{
				_localctx = new EListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(409);
				match(T__5);
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(410);
					wsn();
					}
					}
					setState(415);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(416);
				match(T__7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(618);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(616);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
					case 1:
						{
						_localctx = new ERuleContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(419);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(423);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(420);
							wsn();
							}
							}
							setState(425);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(426);
						match(ARROW);
						setState(430);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(427);
							wsn();
							}
							}
							setState(432);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(433);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new EPowerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(434);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(438);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(435);
							wsn();
							}
							}
							setState(440);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(441);
						match(T__10);
						setState(445);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(442);
							wsn();
							}
							}
							setState(447);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(448);
						expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ETimesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(449);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(453);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(450);
							wsn();
							}
							}
							setState(455);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(456);
						match(T__11);
						setState(460);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(457);
							wsn();
							}
							}
							setState(462);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(463);
						expr(8);
						}
						break;
					case 4:
						{
						_localctx = new EDivideContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(464);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(468);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(465);
							wsn();
							}
							}
							setState(470);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(471);
						match(T__12);
						setState(475);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(472);
							wsn();
							}
							}
							setState(477);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(478);
						expr(7);
						}
						break;
					case 5:
						{
						_localctx = new EPlusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(479);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(483);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(480);
							wsn();
							}
							}
							setState(485);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(486);
						match(T__13);
						setState(490);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(487);
							wsn();
							}
							}
							setState(492);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(493);
						expr(6);
						}
						break;
					case 6:
						{
						_localctx = new EPlusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(494);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(498);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(495);
							wsn();
							}
							}
							setState(500);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(501);
						match(T__14);
						setState(505);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(502);
							wsn();
							}
							}
							setState(507);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(508);
						expr(5);
						}
						break;
					case 7:
						{
						_localctx = new EEqualContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(509);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(513);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(510);
							wsn();
							}
							}
							setState(515);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(516);
						match(T__15);
						setState(520);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(517);
							wsn();
							}
							}
							setState(522);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(523);
						expr(4);
						}
						break;
					case 8:
						{
						_localctx = new ESameQContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(524);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(528);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(525);
							wsn();
							}
							}
							setState(530);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(531);
						match(T__16);
						setState(535);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(532);
							wsn();
							}
							}
							setState(537);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(538);
						expr(3);
						}
						break;
					case 9:
						{
						_localctx = new EUnsameQContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(539);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(543);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(540);
							wsn();
							}
							}
							setState(545);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(546);
						match(T__17);
						setState(550);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(547);
							wsn();
							}
							}
							setState(552);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(553);
						expr(2);
						}
						break;
					case 10:
						{
						_localctx = new EHeadedExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(554);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(558);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(555);
							wsn();
							}
							}
							setState(560);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(561);
						match(T__8);
						setState(565);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(562);
							wsn();
							}
							}
							setState(567);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(568);
						expr(0);
						setState(572);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(569);
							wsn();
							}
							}
							setState(574);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(591);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__6) {
							{
							{
							setState(575);
							match(T__6);
							setState(579);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
								{
								{
								setState(576);
								wsn();
								}
								}
								setState(581);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							setState(582);
							expr(0);
							setState(586);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
								{
								{
								setState(583);
								wsn();
								}
								}
								setState(588);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							setState(593);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(594);
						match(T__9);
						setState(598);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(595);
								wsn();
								}
								} 
							}
							setState(600);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
						}
						}
						break;
					case 11:
						{
						_localctx = new EHeadedExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(601);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(602);
						match(T__8);
						setState(606);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(603);
							wsn();
							}
							}
							setState(608);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(609);
						match(T__9);
						setState(613);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(610);
								wsn();
								}
								} 
							}
							setState(615);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
						}
						}
						break;
					}
					} 
				}
				setState(620);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
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
		enterRule(_localctx, 22, RULE_wlSymbol);
		try {
			setState(624);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(621);
				match(ID);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(622);
				match(T__3);
				setState(623);
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
		enterRule(_localctx, 24, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
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
		enterRule(_localctx, 26, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
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
		enterRule(_localctx, 28, RULE_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
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

	public static class WsContext extends ParserRuleContext {
		public TerminalNode OTHER_WS() { return getToken(GrammarParser.OTHER_WS, 0); }
		public TerminalNode INDENT() { return getToken(GrammarParser.INDENT, 0); }
		public TerminalNode DOUBLE_INDENT() { return getToken(GrammarParser.DOUBLE_INDENT, 0); }
		public WsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ws; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWs(this);
		}
	}

	public final WsContext ws() throws RecognitionException {
		WsContext _localctx = new WsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class WsnContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(GrammarParser.NEWLINE, 0); }
		public TerminalNode OTHER_WS() { return getToken(GrammarParser.OTHER_WS, 0); }
		public TerminalNode INDENT() { return getToken(GrammarParser.INDENT, 0); }
		public TerminalNode DOUBLE_INDENT() { return getToken(GrammarParser.DOUBLE_INDENT, 0); }
		public WsnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wsn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWsn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWsn(this);
		}
	}

	public final WsnContext wsn() throws RecognitionException {
		WsnContext _localctx = new WsnContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_wsn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		case 9:
			return precpred(_ctx, 10);
		case 10:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 \u027f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3"+
		"\2\3\2\7\2\65\n\2\f\2\16\28\13\2\3\3\7\3;\n\3\f\3\16\3>\13\3\3\3\3\3\7"+
		"\3B\n\3\f\3\16\3E\13\3\6\3G\n\3\r\3\16\3H\3\3\5\3L\n\3\3\4\3\4\7\4P\n"+
		"\4\f\4\16\4S\13\4\3\4\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\4\3\4\7\4^\n\4\f\4"+
		"\16\4a\13\4\6\4c\n\4\r\4\16\4d\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4n\n\4\f"+
		"\4\16\4q\13\4\3\4\3\4\7\4u\n\4\f\4\16\4x\13\4\3\4\3\4\7\4|\n\4\f\4\16"+
		"\4\177\13\4\6\4\u0081\n\4\r\4\16\4\u0082\3\4\3\4\7\4\u0087\n\4\f\4\16"+
		"\4\u008a\13\4\3\4\3\4\3\4\3\4\3\4\7\4\u0091\n\4\f\4\16\4\u0094\13\4\3"+
		"\4\3\4\7\4\u0098\n\4\f\4\16\4\u009b\13\4\3\4\3\4\7\4\u009f\n\4\f\4\16"+
		"\4\u00a2\13\4\6\4\u00a4\n\4\r\4\16\4\u00a5\3\4\3\4\3\4\3\4\7\4\u00ac\n"+
		"\4\f\4\16\4\u00af\13\4\3\4\5\4\u00b2\n\4\3\4\7\4\u00b5\n\4\f\4\16\4\u00b8"+
		"\13\4\3\4\3\4\7\4\u00bc\n\4\f\4\16\4\u00bf\13\4\3\4\7\4\u00c2\n\4\f\4"+
		"\16\4\u00c5\13\4\3\4\3\4\3\4\7\4\u00ca\n\4\f\4\16\4\u00cd\13\4\6\4\u00cf"+
		"\n\4\r\4\16\4\u00d0\3\4\3\4\5\4\u00d5\n\4\3\5\3\5\5\5\u00d9\n\5\6\5\u00db"+
		"\n\5\r\5\16\5\u00dc\3\5\3\5\5\5\u00e1\n\5\6\5\u00e3\n\5\r\5\16\5\u00e4"+
		"\3\5\3\5\5\5\u00e9\n\5\3\5\3\5\5\5\u00ed\n\5\3\5\3\5\5\5\u00f1\n\5\6\5"+
		"\u00f3\n\5\r\5\16\5\u00f4\3\5\3\5\3\5\3\5\5\5\u00fb\n\5\5\5\u00fd\n\5"+
		"\3\6\3\6\5\6\u0101\n\6\3\7\3\7\5\7\u0105\n\7\3\b\3\b\7\b\u0109\n\b\f\b"+
		"\16\b\u010c\13\b\3\b\3\b\7\b\u0110\n\b\f\b\16\b\u0113\13\b\3\b\7\b\u0116"+
		"\n\b\f\b\16\b\u0119\13\b\3\b\3\b\7\b\u011d\n\b\f\b\16\b\u0120\13\b\3\b"+
		"\6\b\u0123\n\b\r\b\16\b\u0124\3\b\3\b\3\b\3\b\3\b\7\b\u012c\n\b\f\b\16"+
		"\b\u012f\13\b\6\b\u0131\n\b\r\b\16\b\u0132\3\b\3\b\3\b\3\b\3\b\7\b\u013a"+
		"\n\b\f\b\16\b\u013d\13\b\3\b\3\b\7\b\u0141\n\b\f\b\16\b\u0144\13\b\3\b"+
		"\3\b\3\b\3\b\7\b\u014a\n\b\f\b\16\b\u014d\13\b\3\b\3\b\7\b\u0151\n\b\f"+
		"\b\16\b\u0154\13\b\3\b\5\b\u0157\n\b\3\t\3\t\7\t\u015b\n\t\f\t\16\t\u015e"+
		"\13\t\3\t\3\t\7\t\u0162\n\t\f\t\16\t\u0165\13\t\3\t\6\t\u0168\n\t\r\t"+
		"\16\t\u0169\3\n\3\n\3\n\5\n\u016f\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\7\f\u017b\n\f\f\f\16\f\u017e\13\f\3\f\3\f\7\f\u0182\n\f\f\f"+
		"\16\f\u0185\13\f\3\f\3\f\7\f\u0189\n\f\f\f\16\f\u018c\13\f\3\f\3\f\7\f"+
		"\u0190\n\f\f\f\16\f\u0193\13\f\7\f\u0195\n\f\f\f\16\f\u0198\13\f\3\f\3"+
		"\f\3\f\3\f\7\f\u019e\n\f\f\f\16\f\u01a1\13\f\3\f\5\f\u01a4\n\f\3\f\3\f"+
		"\7\f\u01a8\n\f\f\f\16\f\u01ab\13\f\3\f\3\f\7\f\u01af\n\f\f\f\16\f\u01b2"+
		"\13\f\3\f\3\f\3\f\7\f\u01b7\n\f\f\f\16\f\u01ba\13\f\3\f\3\f\7\f\u01be"+
		"\n\f\f\f\16\f\u01c1\13\f\3\f\3\f\3\f\7\f\u01c6\n\f\f\f\16\f\u01c9\13\f"+
		"\3\f\3\f\7\f\u01cd\n\f\f\f\16\f\u01d0\13\f\3\f\3\f\3\f\7\f\u01d5\n\f\f"+
		"\f\16\f\u01d8\13\f\3\f\3\f\7\f\u01dc\n\f\f\f\16\f\u01df\13\f\3\f\3\f\3"+
		"\f\7\f\u01e4\n\f\f\f\16\f\u01e7\13\f\3\f\3\f\7\f\u01eb\n\f\f\f\16\f\u01ee"+
		"\13\f\3\f\3\f\3\f\7\f\u01f3\n\f\f\f\16\f\u01f6\13\f\3\f\3\f\7\f\u01fa"+
		"\n\f\f\f\16\f\u01fd\13\f\3\f\3\f\3\f\7\f\u0202\n\f\f\f\16\f\u0205\13\f"+
		"\3\f\3\f\7\f\u0209\n\f\f\f\16\f\u020c\13\f\3\f\3\f\3\f\7\f\u0211\n\f\f"+
		"\f\16\f\u0214\13\f\3\f\3\f\7\f\u0218\n\f\f\f\16\f\u021b\13\f\3\f\3\f\3"+
		"\f\7\f\u0220\n\f\f\f\16\f\u0223\13\f\3\f\3\f\7\f\u0227\n\f\f\f\16\f\u022a"+
		"\13\f\3\f\3\f\3\f\7\f\u022f\n\f\f\f\16\f\u0232\13\f\3\f\3\f\7\f\u0236"+
		"\n\f\f\f\16\f\u0239\13\f\3\f\3\f\7\f\u023d\n\f\f\f\16\f\u0240\13\f\3\f"+
		"\3\f\7\f\u0244\n\f\f\f\16\f\u0247\13\f\3\f\3\f\7\f\u024b\n\f\f\f\16\f"+
		"\u024e\13\f\7\f\u0250\n\f\f\f\16\f\u0253\13\f\3\f\3\f\7\f\u0257\n\f\f"+
		"\f\16\f\u025a\13\f\3\f\3\f\3\f\7\f\u025f\n\f\f\f\16\f\u0262\13\f\3\f\3"+
		"\f\7\f\u0266\n\f\f\f\16\f\u0269\13\f\7\f\u026b\n\f\f\f\16\f\u026e\13\f"+
		"\3\r\3\r\3\r\5\r\u0273\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\2\3\26\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\5\3\2"+
		"\6\7\4\2\33\34\36\36\3\2\33\36\u02e0\2(\3\2\2\2\4<\3\2\2\2\6\u00d4\3\2"+
		"\2\2\b\u00fc\3\2\2\2\n\u0100\3\2\2\2\f\u0104\3\2\2\2\16\u0156\3\2\2\2"+
		"\20\u0158\3\2\2\2\22\u016e\3\2\2\2\24\u0170\3\2\2\2\26\u01a3\3\2\2\2\30"+
		"\u0272\3\2\2\2\32\u0274\3\2\2\2\34\u0276\3\2\2\2\36\u0278\3\2\2\2 \u027a"+
		"\3\2\2\2\"\u027c\3\2\2\2$\'\5 \21\2%\'\7\35\2\2&$\3\2\2\2&%\3\2\2\2\'"+
		"*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+/\5\6\4\2,.\5\6\4\2"+
		"-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\66\3\2\2\2\61/\3\2\2\2"+
		"\62\65\5 \21\2\63\65\7\35\2\2\64\62\3\2\2\2\64\63\3\2\2\2\658\3\2\2\2"+
		"\66\64\3\2\2\2\66\67\3\2\2\2\67\3\3\2\2\28\66\3\2\2\29;\5 \21\2:9\3\2"+
		"\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=K\3\2\2\2><\3\2\2\2?C\7\35\2\2@B\5"+
		" \21\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DG\3\2\2\2EC\3\2\2\2F?\3"+
		"\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IL\3\2\2\2JL\7\2\2\3KF\3\2\2\2KJ\3"+
		"\2\2\2L\5\3\2\2\2MQ\5\n\6\2NP\5 \21\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR"+
		"\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TX\7\30\2\2UW\5 \21\2VU\3\2\2\2WZ\3\2\2\2"+
		"XV\3\2\2\2XY\3\2\2\2Yb\3\2\2\2ZX\3\2\2\2[_\5\f\7\2\\^\5 \21\2]\\\3\2\2"+
		"\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`c\3\2\2\2a_\3\2\2\2b[\3\2\2\2cd\3\2\2"+
		"\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\35\2\2gh\7\34\2\2hi\5\26\f\2ij\5"+
		"\4\3\2j\u00d5\3\2\2\2ko\5\n\6\2ln\5 \21\2ml\3\2\2\2nq\3\2\2\2om\3\2\2"+
		"\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rv\7\30\2\2su\5 \21\2ts\3\2\2\2ux\3\2"+
		"\2\2vt\3\2\2\2vw\3\2\2\2w\u0080\3\2\2\2xv\3\2\2\2y}\5\f\7\2z|\5 \21\2"+
		"{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2"+
		"\2\u0080y\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0088\7\27\2\2\u0085\u0087\5 \21\2"+
		"\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\5\26\f\2"+
		"\u008c\u008d\5\4\3\2\u008d\u00d5\3\2\2\2\u008e\u0092\5\n\6\2\u008f\u0091"+
		"\5 \21\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0099\7\30"+
		"\2\2\u0096\u0098\5 \21\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00a3\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009c\u00a0\5\f\7\2\u009d\u009f\5 \21\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a3\u009c\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\5\4"+
		"\3\2\u00a8\u00d5\3\2\2\2\u00a9\u00ad\5\n\6\2\u00aa\u00ac\5 \21\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\7\30\2\2\u00b1"+
		"\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b6\3\2\2\2\u00b3\u00b5\5 "+
		"\21\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00ce\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00c3\7\35"+
		"\2\2\u00ba\u00bc\5 \21\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c2\7\35\2\2\u00c1\u00bd\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2"+
		"\2\2\u00c6\u00c7\7\34\2\2\u00c7\u00cb\5\b\5\2\u00c8\u00ca\5 \21\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00b9\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d3\5\4\3\2\u00d3\u00d5\3\2\2\2\u00d4M\3\2\2\2\u00d4k\3\2"+
		"\2\2\u00d4\u008e\3\2\2\2\u00d4\u00a9\3\2\2\2\u00d5\7\3\2\2\2\u00d6\u00d8"+
		"\5\f\7\2\u00d7\u00d9\5 \21\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00db\3\2\2\2\u00da\u00d6\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00fd\3\2\2\2\u00de\u00e0\5\f\7\2\u00df"+
		"\u00e1\5 \21\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2"+
		"\2\2\u00e2\u00de\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\7\27\2\2\u00e7\u00e9\5"+
		" \21\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ec\5\26\f\2\u00eb\u00ed\5 \21\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3"+
		"\2\2\2\u00ed\u00fd\3\2\2\2\u00ee\u00f0\5\f\7\2\u00ef\u00f1\5 \21\2\u00f0"+
		"\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00ee\3\2"+
		"\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f7\7\35\2\2\u00f7\u00f8\7\33\2\2\u00f8\u00fa\5"+
		"\26\f\2\u00f9\u00fb\5 \21\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fd\3\2\2\2\u00fc\u00da\3\2\2\2\u00fc\u00e2\3\2\2\2\u00fc\u00f2\3\2"+
		"\2\2\u00fd\t\3\2\2\2\u00fe\u0101\7\32\2\2\u00ff\u0101\5\24\13\2\u0100"+
		"\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\13\3\2\2\2\u0102\u0105\5\16\b"+
		"\2\u0103\u0105\5\20\t\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105"+
		"\r\3\2\2\2\u0106\u010a\7\3\2\2\u0107\u0109\5 \21\2\u0108\u0107\3\2\2\2"+
		"\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010d"+
		"\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0111\5\16\b\2\u010e\u0110\5 \21\2"+
		"\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\u0122\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0116\5 \21\2\u0115"+
		"\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011e\7\4\2\2\u011b"+
		"\u011d\5 \21\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121"+
		"\u0123\5\16\b\2\u0122\u0117\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3"+
		"\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\7\5\2\2\u0127"+
		"\u0157\3\2\2\2\u0128\u0130\7\3\2\2\u0129\u012d\5\16\b\2\u012a\u012c\5"+
		" \21\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0129\3\2"+
		"\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u0135\7\5\2\2\u0135\u0157\3\2\2\2\u0136\u0157\5\22"+
		"\n\2\u0137\u013b\7\3\2\2\u0138\u013a\5 \21\2\u0139\u0138\3\2\2\2\u013a"+
		"\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2"+
		"\2\2\u013d\u013b\3\2\2\2\u013e\u0142\5\20\t\2\u013f\u0141\5 \21\2\u0140"+
		"\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2"+
		"\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\7\5\2\2\u0146"+
		"\u0157\3\2\2\2\u0147\u014b\7\32\2\2\u0148\u014a\5 \21\2\u0149\u0148\3"+
		"\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0152\7\31\2\2\u014f\u0151\5"+
		" \21\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0157\5\16"+
		"\b\2\u0156\u0106\3\2\2\2\u0156\u0128\3\2\2\2\u0156\u0136\3\2\2\2\u0156"+
		"\u0137\3\2\2\2\u0156\u0147\3\2\2\2\u0157\17\3\2\2\2\u0158\u0167\5\22\n"+
		"\2\u0159\u015b\5 \21\2\u015a\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a"+
		"\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f"+
		"\u0163\7\4\2\2\u0160\u0162\5 \21\2\u0161\u0160\3\2\2\2\u0162\u0165\3\2"+
		"\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0166\u0168\5\22\n\2\u0167\u015c\3\2\2\2\u0168\u0169\3"+
		"\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\21\3\2\2\2\u016b"+
		"\u016f\7\32\2\2\u016c\u016f\5\24\13\2\u016d\u016f\7\37\2\2\u016e\u016b"+
		"\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2\2\u016f\23\3\2\2\2\u0170"+
		"\u0171\t\2\2\2\u0171\u0172\7\32\2\2\u0172\25\3\2\2\2\u0173\u0174\b\f\1"+
		"\2\u0174\u01a4\5\32\16\2\u0175\u01a4\5\34\17\2\u0176\u01a4\5\36\20\2\u0177"+
		"\u01a4\5\30\r\2\u0178\u017c\7\b\2\2\u0179\u017b\5\"\22\2\u017a\u0179\3"+
		"\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\u017f\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0183\5\26\f\2\u0180\u0182\5"+
		"\"\22\2\u0181\u0180\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0196\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u018a\7\t"+
		"\2\2\u0187\u0189\5\"\22\2\u0188\u0187\3\2\2\2\u0189\u018c\3\2\2\2\u018a"+
		"\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u018a\3\2"+
		"\2\2\u018d\u0191\5\26\f\2\u018e\u0190\5\"\22\2\u018f\u018e\3\2\2\2\u0190"+
		"\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0195\3\2"+
		"\2\2\u0193\u0191\3\2\2\2\u0194\u0186\3\2\2\2\u0195\u0198\3\2\2\2\u0196"+
		"\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0199\3\2\2\2\u0198\u0196\3\2"+
		"\2\2\u0199\u019a\7\n\2\2\u019a\u01a4\3\2\2\2\u019b\u019f\7\b\2\2\u019c"+
		"\u019e\5\"\22\2\u019d\u019c\3\2\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3"+
		"\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1\u019f\3\2\2\2\u01a2"+
		"\u01a4\7\n\2\2\u01a3\u0173\3\2\2\2\u01a3\u0175\3\2\2\2\u01a3\u0176\3\2"+
		"\2\2\u01a3\u0177\3\2\2\2\u01a3\u0178\3\2\2\2\u01a3\u019b\3\2\2\2\u01a4"+
		"\u026c\3\2\2\2\u01a5\u01a9\f\17\2\2\u01a6\u01a8\5\"\22\2\u01a7\u01a6\3"+
		"\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01b0\7\27\2\2\u01ad\u01af\5"+
		"\"\22\2\u01ae\u01ad\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u026b\5\26"+
		"\f\20\u01b4\u01b8\f\n\2\2\u01b5\u01b7\5\"\22\2\u01b6\u01b5\3\2\2\2\u01b7"+
		"\u01ba\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bb\3\2"+
		"\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01bf\7\r\2\2\u01bc\u01be\5\"\22\2\u01bd"+
		"\u01bc\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0\u01c2\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u026b\5\26\f\13\u01c3"+
		"\u01c7\f\t\2\2\u01c4\u01c6\5\"\22\2\u01c5\u01c4\3\2\2\2\u01c6\u01c9\3"+
		"\2\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9"+
		"\u01c7\3\2\2\2\u01ca\u01ce\7\16\2\2\u01cb\u01cd\5\"\22\2\u01cc\u01cb\3"+
		"\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf"+
		"\u01d1\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u026b\5\26\f\n\u01d2\u01d6\f"+
		"\b\2\2\u01d3\u01d5\5\"\22\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6"+
		"\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d6\3\2"+
		"\2\2\u01d9\u01dd\7\17\2\2\u01da\u01dc\5\"\22\2\u01db\u01da\3\2\2\2\u01dc"+
		"\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e0\3\2"+
		"\2\2\u01df\u01dd\3\2\2\2\u01e0\u026b\5\26\f\t\u01e1\u01e5\f\7\2\2\u01e2"+
		"\u01e4\5\"\22\2\u01e3\u01e2\3\2\2\2\u01e4\u01e7\3\2\2\2\u01e5\u01e3\3"+
		"\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e8\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e8"+
		"\u01ec\7\20\2\2\u01e9\u01eb\5\"\22\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee\3"+
		"\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef\3\2\2\2\u01ee"+
		"\u01ec\3\2\2\2\u01ef\u026b\5\26\f\b\u01f0\u01f4\f\6\2\2\u01f1\u01f3\5"+
		"\"\22\2\u01f2\u01f1\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4"+
		"\u01f5\3\2\2\2\u01f5\u01f7\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f7\u01fb\7\21"+
		"\2\2\u01f8\u01fa\5\"\22\2\u01f9\u01f8\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb"+
		"\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fe\3\2\2\2\u01fd\u01fb\3\2"+
		"\2\2\u01fe\u026b\5\26\f\7\u01ff\u0203\f\5\2\2\u0200\u0202\5\"\22\2\u0201"+
		"\u0200\3\2\2\2\u0202\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2"+
		"\2\2\u0204\u0206\3\2\2\2\u0205\u0203\3\2\2\2\u0206\u020a\7\22\2\2\u0207"+
		"\u0209\5\"\22\2\u0208\u0207\3\2\2\2\u0209\u020c\3\2\2\2\u020a\u0208\3"+
		"\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\3\2\2\2\u020c\u020a\3\2\2\2\u020d"+
		"\u026b\5\26\f\6\u020e\u0212\f\4\2\2\u020f\u0211\5\"\22\2\u0210\u020f\3"+
		"\2\2\2\u0211\u0214\3\2\2\2\u0212\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213"+
		"\u0215\3\2\2\2\u0214\u0212\3\2\2\2\u0215\u0219\7\23\2\2\u0216\u0218\5"+
		"\"\22\2\u0217\u0216\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217\3\2\2\2\u0219"+
		"\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0219\3\2\2\2\u021c\u026b\5\26"+
		"\f\5\u021d\u0221\f\3\2\2\u021e\u0220\5\"\22\2\u021f\u021e\3\2\2\2\u0220"+
		"\u0223\3\2\2\2\u0221\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0224\3\2"+
		"\2\2\u0223\u0221\3\2\2\2\u0224\u0228\7\24\2\2\u0225\u0227\5\"\22\2\u0226"+
		"\u0225\3\2\2\2\u0227\u022a\3\2\2\2\u0228\u0226\3\2\2\2\u0228\u0229\3\2"+
		"\2\2\u0229\u022b\3\2\2\2\u022a\u0228\3\2\2\2\u022b\u026b\5\26\f\4\u022c"+
		"\u0230\f\f\2\2\u022d\u022f\5\"\22\2\u022e\u022d\3\2\2\2\u022f\u0232\3"+
		"\2\2\2\u0230\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0233\3\2\2\2\u0232"+
		"\u0230\3\2\2\2\u0233\u0237\7\13\2\2\u0234\u0236\5\"\22\2\u0235\u0234\3"+
		"\2\2\2\u0236\u0239\3\2\2\2\u0237\u0235\3\2\2\2\u0237\u0238\3\2\2\2\u0238"+
		"\u023a\3\2\2\2\u0239\u0237\3\2\2\2\u023a\u023e\5\26\f\2\u023b\u023d\5"+
		"\"\22\2\u023c\u023b\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2\2\u023e"+
		"\u023f\3\2\2\2\u023f\u0251\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0245\7\t"+
		"\2\2\u0242\u0244\5\"\22\2\u0243\u0242\3\2\2\2\u0244\u0247\3\2\2\2\u0245"+
		"\u0243\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0248\3\2\2\2\u0247\u0245\3\2"+
		"\2\2\u0248\u024c\5\26\f\2\u0249\u024b\5\"\22\2\u024a\u0249\3\2\2\2\u024b"+
		"\u024e\3\2\2\2\u024c\u024a\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u0250\3\2"+
		"\2\2\u024e\u024c\3\2\2\2\u024f\u0241\3\2\2\2\u0250\u0253\3\2\2\2\u0251"+
		"\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0254\3\2\2\2\u0253\u0251\3\2"+
		"\2\2\u0254\u0258\7\f\2\2\u0255\u0257\5\"\22\2\u0256\u0255\3\2\2\2\u0257"+
		"\u025a\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2\2\2\u0259\u026b\3\2"+
		"\2\2\u025a\u0258\3\2\2\2\u025b\u025c\f\13\2\2\u025c\u0260\7\13\2\2\u025d"+
		"\u025f\5\"\22\2\u025e\u025d\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3"+
		"\2\2\2\u0260\u0261\3\2\2\2\u0261\u0263\3\2\2\2\u0262\u0260\3\2\2\2\u0263"+
		"\u0267\7\f\2\2\u0264\u0266\5\"\22\2\u0265\u0264\3\2\2\2\u0266\u0269\3"+
		"\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u026b\3\2\2\2\u0269"+
		"\u0267\3\2\2\2\u026a\u01a5\3\2\2\2\u026a\u01b4\3\2\2\2\u026a\u01c3\3\2"+
		"\2\2\u026a\u01d2\3\2\2\2\u026a\u01e1\3\2\2\2\u026a\u01f0\3\2\2\2\u026a"+
		"\u01ff\3\2\2\2\u026a\u020e\3\2\2\2\u026a\u021d\3\2\2\2\u026a\u022c\3\2"+
		"\2\2\u026a\u025b\3\2\2\2\u026b\u026e\3\2\2\2\u026c\u026a\3\2\2\2\u026c"+
		"\u026d\3\2\2\2\u026d\27\3\2\2\2\u026e\u026c\3\2\2\2\u026f\u0273\7\32\2"+
		"\2\u0270\u0271\7\6\2\2\u0271\u0273\7\32\2\2\u0272\u026f\3\2\2\2\u0272"+
		"\u0270\3\2\2\2\u0273\31\3\2\2\2\u0274\u0275\7\37\2\2\u0275\33\3\2\2\2"+
		"\u0276\u0277\7\25\2\2\u0277\35\3\2\2\2\u0278\u0279\7\26\2\2\u0279\37\3"+
		"\2\2\2\u027a\u027b\t\3\2\2\u027b!\3\2\2\2\u027c\u027d\t\4\2\2\u027d#\3"+
		"\2\2\2a&(/\64\66<CHKQX_dov}\u0082\u0088\u0092\u0099\u00a0\u00a5\u00ad"+
		"\u00b1\u00b6\u00bd\u00c3\u00cb\u00d0\u00d4\u00d8\u00dc\u00e0\u00e4\u00e8"+
		"\u00ec\u00f0\u00f4\u00fa\u00fc\u0100\u0104\u010a\u0111\u0117\u011e\u0124"+
		"\u012d\u0132\u013b\u0142\u014b\u0152\u0156\u015c\u0163\u0169\u016e\u017c"+
		"\u0183\u018a\u0191\u0196\u019f\u01a3\u01a9\u01b0\u01b8\u01bf\u01c7\u01ce"+
		"\u01d6\u01dd\u01e5\u01ec\u01f4\u01fb\u0203\u020a\u0212\u0219\u0221\u0228"+
		"\u0230\u0237\u023e\u0245\u024c\u0251\u0258\u0260\u0267\u026a\u026c\u0272";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}