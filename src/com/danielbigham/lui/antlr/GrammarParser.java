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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, INTEGER=23, REAL=24, 
		ARROW=25, COLON=26, EQUALS=27, ID=28, ID2=29, DOUBLE_INDENT=30, INDENT=31, 
		NEWLINE=32, OTHER_WS=33, STRING=34, WS=35, DIGITS=36;
	public static final int
		RULE_grammarRules = 0, RULE_end_of_rule = 1, RULE_grammarRule = 2, RULE_simpleRule = 3, 
		RULE_rulePattern = 4, RULE_lhs = 5, RULE_rulePart3 = 6, RULE_rulePart = 7, 
		RULE_rulePart2 = 8, RULE_basicRulePart = 9, RULE_symbol = 10, RULE_expr = 11, 
		RULE_wlSymbol = 12, RULE_string = 13, RULE_integer = 14, RULE_real = 15, 
		RULE_ws = 16, RULE_wsn = 17;
	public static final String[] ruleNames = {
		"grammarRules", "end_of_rule", "grammarRule", "simpleRule", "rulePattern", 
		"lhs", "rulePart3", "rulePart", "rulePart2", "basicRulePart", "symbol", 
		"expr", "wlSymbol", "string", "integer", "real", "ws", "wsn"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'|'", "')'", "'$'", "'~'", "'{'", "','", "'}'", "'<|'", 
		"'|>'", "'['", "']'", "'^'", "'*'", "'/'", "'+'", "'-'", "'=='", "'==='", 
		"'=!='", "'&&'", "'||'", null, null, null, "':'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "INTEGER", 
		"REAL", "ARROW", "COLON", "EQUALS", "ID", "ID2", "DOUBLE_INDENT", "INDENT", 
		"NEWLINE", "OTHER_WS", "STRING", "WS", "DIGITS"
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
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
				{
				setState(38);
				switch (_input.LA(1)) {
				case DOUBLE_INDENT:
				case INDENT:
				case OTHER_WS:
					{
					setState(36);
					ws();
					}
					break;
				case NEWLINE:
					{
					setState(37);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			grammarRule();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << ID))) != 0)) {
				{
				{
				setState(44);
				grammarRule();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
				{
				setState(52);
				switch (_input.LA(1)) {
				case DOUBLE_INDENT:
				case INDENT:
				case OTHER_WS:
					{
					setState(50);
					ws();
					}
					break;
				case NEWLINE:
					{
					setState(51);
					match(NEWLINE);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(56);
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
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
				{
				{
				setState(57);
				ws();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			switch (_input.LA(1)) {
			case NEWLINE:
				{
				setState(70); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(63);
						match(NEWLINE);
						setState(67);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(64);
								ws();
								}
								} 
							}
							setState(69);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(72); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case EOF:
				{
				setState(74);
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
		public RulePatternContext rulePattern() {
			return getRuleContext(RulePatternContext.class,0);
		}
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
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				lhs();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(78);
					ws();
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				match(COLON);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(85);
					ws();
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91);
				rulePattern();
				setState(92);
				match(NEWLINE);
				setState(93);
				match(INDENT);
				setState(94);
				expr(0);
				setState(95);
				end_of_rule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				lhs();
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(98);
					ws();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(104);
				match(COLON);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(105);
					ws();
					}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111);
				rulePattern();
				setState(112);
				match(ARROW);
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
				setState(119);
				expr(0);
				setState(120);
				end_of_rule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				lhs();
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(123);
					ws();
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(129);
				match(COLON);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(130);
					ws();
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				rulePattern();
				setState(137);
				end_of_rule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				lhs();
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(140);
						ws();
						}
						} 
					}
					setState(145);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(147);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(146);
					match(COLON);
					}
				}

				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(149);
					ws();
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(176); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(155);
						match(NEWLINE);
						setState(165);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(159);
								_errHandler.sync(this);
								_la = _input.LA(1);
								while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
									{
									{
									setState(156);
									ws();
									}
									}
									setState(161);
									_errHandler.sync(this);
									_la = _input.LA(1);
								}
								setState(162);
								match(NEWLINE);
								}
								} 
							}
							setState(167);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
						}
						setState(168);
						match(INDENT);
						setState(169);
						simpleRule();
						setState(173);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(170);
								ws();
								}
								} 
							}
							setState(175);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
						}
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(178); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(180);
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
		public RulePatternContext rulePattern() {
			return getRuleContext(RulePatternContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(GrammarParser.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<WsContext> ws() {
			return getRuleContexts(WsContext.class);
		}
		public WsContext ws(int i) {
			return getRuleContext(WsContext.class,i);
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
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				rulePattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				rulePattern();
				setState(186);
				match(ARROW);
				setState(188);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					setState(187);
					ws();
					}
				}

				setState(190);
				expr(0);
				setState(192);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(191);
					ws();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				rulePattern();
				setState(195);
				match(NEWLINE);
				setState(196);
				match(DOUBLE_INDENT);
				setState(197);
				expr(0);
				setState(199);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(198);
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

	public static class RulePatternContext extends ParserRuleContext {
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
		public RulePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRulePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRulePattern(this);
		}
	}

	public final RulePatternContext rulePattern() throws RecognitionException {
		RulePatternContext _localctx = new RulePatternContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rulePattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(203);
				rulePart3();
				setState(205);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(204);
					ws();
					}
					break;
				}
				}
				}
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << INTEGER) | (1L << ID) | (1L << ID2) | (1L << STRING))) != 0) );
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
		enterRule(_localctx, 10, RULE_lhs);
		try {
			setState(213);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(ID);
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
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
		enterRule(_localctx, 12, RULE_rulePart3);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				rulePart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
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
		enterRule(_localctx, 14, RULE_rulePart);
		int _la;
		try {
			int _alt;
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				_localctx = new OrRulePartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				match(T__0);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(220);
					ws();
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(226);
				rulePart();
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(227);
						ws();
						}
						} 
					}
					setState(232);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
				setState(247); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(233);
						ws();
						}
						}
						setState(238);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(239);
					match(T__1);
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(240);
						ws();
						}
						}
						setState(245);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(246);
					rulePart();
					}
					}
					setState(249); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0) );
				setState(251);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new SeqRulePartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(T__0);
				setState(261); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(254);
					rulePart();
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(255);
						ws();
						}
						}
						setState(260);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(263); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << INTEGER) | (1L << ID) | (1L << ID2) | (1L << STRING))) != 0) );
				setState(265);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new BasicRulePart2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(267);
				basicRulePart();
				}
				break;
			case 4:
				_localctx = new OrRulePart2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(268);
				match(T__0);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(269);
					ws();
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(275);
				rulePart2();
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(276);
					ws();
					}
					}
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(282);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new BindingContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(284);
				match(ID);
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(285);
					ws();
					}
					}
					setState(290);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(291);
				match(EQUALS);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(292);
					ws();
					}
					}
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(298);
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
		enterRule(_localctx, 16, RULE_rulePart2);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			rulePart();
			setState(316); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(302);
						ws();
						}
						}
						setState(307);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(308);
					match(T__1);
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(309);
						ws();
						}
						}
						setState(314);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(315);
					rulePart();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(318); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
		public TerminalNode ID2() { return getToken(GrammarParser.ID2, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_basicRulePart);
		try {
			setState(325);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				match(ID);
				}
				break;
			case ID2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				match(ID2);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				integer();
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(323);
				symbol();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(324);
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
		enterRule(_localctx, 20, RULE_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(328);
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
	public static class EAssociationContext extends ExprContext {
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
		public EAssociationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEAssociation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEAssociation(this);
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
	public static class ESetContext extends ExprContext {
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
		public ESetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterESet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitESet(this);
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
	public static class EOrContext extends ExprContext {
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
		public EOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEOr(this);
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
	public static class EAndContext extends ExprContext {
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
		public EAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEAnd(this);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				_localctx = new EStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(331);
				string();
				}
				break;
			case 2:
				{
				_localctx = new EIntegerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(332);
				integer();
				}
				break;
			case 3:
				{
				_localctx = new ERealContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333);
				real();
				}
				break;
			case 4:
				{
				_localctx = new ESymbolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(334);
				wlSymbol();
				}
				break;
			case 5:
				{
				_localctx = new EListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(335);
				match(T__5);
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(336);
					wsn();
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(342);
				expr(0);
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(343);
					wsn();
					}
					}
					setState(348);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(349);
					match(T__6);
					setState(353);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(350);
						wsn();
						}
						}
						setState(355);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(356);
					expr(0);
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(357);
						wsn();
						}
						}
						setState(362);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(367);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(368);
				match(T__7);
				}
				break;
			case 6:
				{
				_localctx = new EListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(370);
				match(T__5);
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(371);
					wsn();
					}
					}
					setState(376);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(377);
				match(T__7);
				}
				break;
			case 7:
				{
				_localctx = new EAssociationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(378);
				match(T__8);
				setState(382);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(379);
					wsn();
					}
					}
					setState(384);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(385);
				expr(0);
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
					{
					{
					setState(386);
					wsn();
					}
					}
					setState(391);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(392);
					match(T__6);
					setState(396);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(393);
						wsn();
						}
						}
						setState(398);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(399);
					expr(0);
					setState(403);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
						{
						{
						setState(400);
						wsn();
						}
						}
						setState(405);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(411);
				match(T__9);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(659);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(657);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
					case 1:
						{
						_localctx = new ERuleContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(415);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(419);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(416);
							wsn();
							}
							}
							setState(421);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(422);
						match(ARROW);
						setState(426);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(423);
							wsn();
							}
							}
							setState(428);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(429);
						expr(18);
						}
						break;
					case 2:
						{
						_localctx = new EPowerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(430);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(434);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(431);
							wsn();
							}
							}
							setState(436);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(437);
						match(T__12);
						setState(441);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(438);
							wsn();
							}
							}
							setState(443);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(444);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new ETimesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(445);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(449);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(446);
							wsn();
							}
							}
							setState(451);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(452);
						match(T__13);
						setState(456);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(453);
							wsn();
							}
							}
							setState(458);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(459);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new EDivideContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(460);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(464);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(461);
							wsn();
							}
							}
							setState(466);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(467);
						match(T__14);
						setState(471);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(468);
							wsn();
							}
							}
							setState(473);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(474);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new EPlusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(475);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(479);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(476);
							wsn();
							}
							}
							setState(481);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(482);
						match(T__15);
						setState(486);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(483);
							wsn();
							}
							}
							setState(488);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(489);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new EPlusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(490);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(494);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(491);
							wsn();
							}
							}
							setState(496);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(497);
						match(T__16);
						setState(501);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(498);
							wsn();
							}
							}
							setState(503);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(504);
						expr(8);
						}
						break;
					case 7:
						{
						_localctx = new ESetContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(505);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(509);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(506);
							wsn();
							}
							}
							setState(511);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(512);
						match(EQUALS);
						setState(516);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(513);
							wsn();
							}
							}
							setState(518);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(519);
						expr(7);
						}
						break;
					case 8:
						{
						_localctx = new EEqualContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(520);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(524);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(521);
							wsn();
							}
							}
							setState(526);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(527);
						match(T__17);
						setState(531);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(528);
							wsn();
							}
							}
							setState(533);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(534);
						expr(6);
						}
						break;
					case 9:
						{
						_localctx = new ESameQContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(535);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(539);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(536);
							wsn();
							}
							}
							setState(541);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(542);
						match(T__18);
						setState(546);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(543);
							wsn();
							}
							}
							setState(548);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(549);
						expr(5);
						}
						break;
					case 10:
						{
						_localctx = new EUnsameQContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(550);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(554);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(551);
							wsn();
							}
							}
							setState(556);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(557);
						match(T__19);
						setState(561);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(558);
							wsn();
							}
							}
							setState(563);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(564);
						expr(4);
						}
						break;
					case 11:
						{
						_localctx = new EAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(565);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(569);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(566);
							wsn();
							}
							}
							setState(571);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(572);
						match(T__20);
						setState(576);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(573);
							wsn();
							}
							}
							setState(578);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(579);
						expr(3);
						}
						break;
					case 12:
						{
						_localctx = new EOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(580);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(584);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(581);
							wsn();
							}
							}
							setState(586);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(587);
						match(T__21);
						setState(591);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(588);
							wsn();
							}
							}
							setState(593);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(594);
						expr(2);
						}
						break;
					case 13:
						{
						_localctx = new EHeadedExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(595);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(599);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(596);
							wsn();
							}
							}
							setState(601);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(602);
						match(T__10);
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
						expr(0);
						setState(613);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(610);
							wsn();
							}
							}
							setState(615);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(632);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__6) {
							{
							{
							setState(616);
							match(T__6);
							setState(620);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
								{
								{
								setState(617);
								wsn();
								}
								}
								setState(622);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							setState(623);
							expr(0);
							setState(627);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
								{
								{
								setState(624);
								wsn();
								}
								}
								setState(629);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
							}
							setState(634);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(635);
						match(T__11);
						setState(639);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(636);
								wsn();
								}
								} 
							}
							setState(641);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
						}
						}
						break;
					case 14:
						{
						_localctx = new EHeadedExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(642);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(643);
						match(T__10);
						setState(647);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOUBLE_INDENT) | (1L << INDENT) | (1L << NEWLINE) | (1L << OTHER_WS))) != 0)) {
							{
							{
							setState(644);
							wsn();
							}
							}
							setState(649);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(650);
						match(T__11);
						setState(654);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(651);
								wsn();
								}
								} 
							}
							setState(656);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
						}
						}
						break;
					}
					} 
				}
				setState(661);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
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
		enterRule(_localctx, 24, RULE_wlSymbol);
		try {
			setState(665);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(662);
				match(ID);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(663);
				match(T__3);
				setState(664);
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
		enterRule(_localctx, 26, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(667);
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
		enterRule(_localctx, 28, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
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
		enterRule(_localctx, 30, RULE_real);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
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
		enterRule(_localctx, 32, RULE_ws);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
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
		enterRule(_localctx, 34, RULE_wsn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
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
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 13);
		case 13:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\u02a8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\7\2\60\n\2\f\2\16\2"+
		"\63\13\2\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\3\7\3=\n\3\f\3\16\3@\13\3"+
		"\3\3\3\3\7\3D\n\3\f\3\16\3G\13\3\6\3I\n\3\r\3\16\3J\3\3\5\3N\n\3\3\4\3"+
		"\4\7\4R\n\4\f\4\16\4U\13\4\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4f\n\4\f\4\16\4i\13\4\3\4\3\4\7\4m\n\4\f\4\16"+
		"\4p\13\4\3\4\3\4\3\4\7\4u\n\4\f\4\16\4x\13\4\3\4\3\4\3\4\3\4\3\4\7\4\177"+
		"\n\4\f\4\16\4\u0082\13\4\3\4\3\4\7\4\u0086\n\4\f\4\16\4\u0089\13\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4\u0090\n\4\f\4\16\4\u0093\13\4\3\4\5\4\u0096\n\4\3"+
		"\4\7\4\u0099\n\4\f\4\16\4\u009c\13\4\3\4\3\4\7\4\u00a0\n\4\f\4\16\4\u00a3"+
		"\13\4\3\4\7\4\u00a6\n\4\f\4\16\4\u00a9\13\4\3\4\3\4\3\4\7\4\u00ae\n\4"+
		"\f\4\16\4\u00b1\13\4\6\4\u00b3\n\4\r\4\16\4\u00b4\3\4\3\4\5\4\u00b9\n"+
		"\4\3\5\3\5\3\5\3\5\5\5\u00bf\n\5\3\5\3\5\5\5\u00c3\n\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5\u00ca\n\5\5\5\u00cc\n\5\3\6\3\6\5\6\u00d0\n\6\6\6\u00d2\n\6\r"+
		"\6\16\6\u00d3\3\7\3\7\5\7\u00d8\n\7\3\b\3\b\5\b\u00dc\n\b\3\t\3\t\7\t"+
		"\u00e0\n\t\f\t\16\t\u00e3\13\t\3\t\3\t\7\t\u00e7\n\t\f\t\16\t\u00ea\13"+
		"\t\3\t\7\t\u00ed\n\t\f\t\16\t\u00f0\13\t\3\t\3\t\7\t\u00f4\n\t\f\t\16"+
		"\t\u00f7\13\t\3\t\6\t\u00fa\n\t\r\t\16\t\u00fb\3\t\3\t\3\t\3\t\3\t\7\t"+
		"\u0103\n\t\f\t\16\t\u0106\13\t\6\t\u0108\n\t\r\t\16\t\u0109\3\t\3\t\3"+
		"\t\3\t\3\t\7\t\u0111\n\t\f\t\16\t\u0114\13\t\3\t\3\t\7\t\u0118\n\t\f\t"+
		"\16\t\u011b\13\t\3\t\3\t\3\t\3\t\7\t\u0121\n\t\f\t\16\t\u0124\13\t\3\t"+
		"\3\t\7\t\u0128\n\t\f\t\16\t\u012b\13\t\3\t\5\t\u012e\n\t\3\n\3\n\7\n\u0132"+
		"\n\n\f\n\16\n\u0135\13\n\3\n\3\n\7\n\u0139\n\n\f\n\16\n\u013c\13\n\3\n"+
		"\6\n\u013f\n\n\r\n\16\n\u0140\3\13\3\13\3\13\3\13\3\13\5\13\u0148\n\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0154\n\r\f\r\16\r\u0157"+
		"\13\r\3\r\3\r\7\r\u015b\n\r\f\r\16\r\u015e\13\r\3\r\3\r\7\r\u0162\n\r"+
		"\f\r\16\r\u0165\13\r\3\r\3\r\7\r\u0169\n\r\f\r\16\r\u016c\13\r\7\r\u016e"+
		"\n\r\f\r\16\r\u0171\13\r\3\r\3\r\3\r\3\r\7\r\u0177\n\r\f\r\16\r\u017a"+
		"\13\r\3\r\3\r\3\r\7\r\u017f\n\r\f\r\16\r\u0182\13\r\3\r\3\r\7\r\u0186"+
		"\n\r\f\r\16\r\u0189\13\r\3\r\3\r\7\r\u018d\n\r\f\r\16\r\u0190\13\r\3\r"+
		"\3\r\7\r\u0194\n\r\f\r\16\r\u0197\13\r\7\r\u0199\n\r\f\r\16\r\u019c\13"+
		"\r\3\r\3\r\5\r\u01a0\n\r\3\r\3\r\7\r\u01a4\n\r\f\r\16\r\u01a7\13\r\3\r"+
		"\3\r\7\r\u01ab\n\r\f\r\16\r\u01ae\13\r\3\r\3\r\3\r\7\r\u01b3\n\r\f\r\16"+
		"\r\u01b6\13\r\3\r\3\r\7\r\u01ba\n\r\f\r\16\r\u01bd\13\r\3\r\3\r\3\r\7"+
		"\r\u01c2\n\r\f\r\16\r\u01c5\13\r\3\r\3\r\7\r\u01c9\n\r\f\r\16\r\u01cc"+
		"\13\r\3\r\3\r\3\r\7\r\u01d1\n\r\f\r\16\r\u01d4\13\r\3\r\3\r\7\r\u01d8"+
		"\n\r\f\r\16\r\u01db\13\r\3\r\3\r\3\r\7\r\u01e0\n\r\f\r\16\r\u01e3\13\r"+
		"\3\r\3\r\7\r\u01e7\n\r\f\r\16\r\u01ea\13\r\3\r\3\r\3\r\7\r\u01ef\n\r\f"+
		"\r\16\r\u01f2\13\r\3\r\3\r\7\r\u01f6\n\r\f\r\16\r\u01f9\13\r\3\r\3\r\3"+
		"\r\7\r\u01fe\n\r\f\r\16\r\u0201\13\r\3\r\3\r\7\r\u0205\n\r\f\r\16\r\u0208"+
		"\13\r\3\r\3\r\3\r\7\r\u020d\n\r\f\r\16\r\u0210\13\r\3\r\3\r\7\r\u0214"+
		"\n\r\f\r\16\r\u0217\13\r\3\r\3\r\3\r\7\r\u021c\n\r\f\r\16\r\u021f\13\r"+
		"\3\r\3\r\7\r\u0223\n\r\f\r\16\r\u0226\13\r\3\r\3\r\3\r\7\r\u022b\n\r\f"+
		"\r\16\r\u022e\13\r\3\r\3\r\7\r\u0232\n\r\f\r\16\r\u0235\13\r\3\r\3\r\3"+
		"\r\7\r\u023a\n\r\f\r\16\r\u023d\13\r\3\r\3\r\7\r\u0241\n\r\f\r\16\r\u0244"+
		"\13\r\3\r\3\r\3\r\7\r\u0249\n\r\f\r\16\r\u024c\13\r\3\r\3\r\7\r\u0250"+
		"\n\r\f\r\16\r\u0253\13\r\3\r\3\r\3\r\7\r\u0258\n\r\f\r\16\r\u025b\13\r"+
		"\3\r\3\r\7\r\u025f\n\r\f\r\16\r\u0262\13\r\3\r\3\r\7\r\u0266\n\r\f\r\16"+
		"\r\u0269\13\r\3\r\3\r\7\r\u026d\n\r\f\r\16\r\u0270\13\r\3\r\3\r\7\r\u0274"+
		"\n\r\f\r\16\r\u0277\13\r\7\r\u0279\n\r\f\r\16\r\u027c\13\r\3\r\3\r\7\r"+
		"\u0280\n\r\f\r\16\r\u0283\13\r\3\r\3\r\3\r\7\r\u0288\n\r\f\r\16\r\u028b"+
		"\13\r\3\r\3\r\7\r\u028f\n\r\f\r\16\r\u0292\13\r\7\r\u0294\n\r\f\r\16\r"+
		"\u0297\13\r\3\16\3\16\3\16\5\16\u029c\n\16\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\23\2\3\30\24\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$\2\5\3\2\6\7\4\2 !##\3\2 #\u030f\2*\3\2\2\2\4>\3\2\2\2\6\u00b8"+
		"\3\2\2\2\b\u00cb\3\2\2\2\n\u00d1\3\2\2\2\f\u00d7\3\2\2\2\16\u00db\3\2"+
		"\2\2\20\u012d\3\2\2\2\22\u012f\3\2\2\2\24\u0147\3\2\2\2\26\u0149\3\2\2"+
		"\2\30\u019f\3\2\2\2\32\u029b\3\2\2\2\34\u029d\3\2\2\2\36\u029f\3\2\2\2"+
		" \u02a1\3\2\2\2\"\u02a3\3\2\2\2$\u02a5\3\2\2\2&)\5\"\22\2\')\7\"\2\2("+
		"&\3\2\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2"+
		"-\61\5\6\4\2.\60\5\6\4\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2"+
		"\2\2\628\3\2\2\2\63\61\3\2\2\2\64\67\5\"\22\2\65\67\7\"\2\2\66\64\3\2"+
		"\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\3\3\2\2\2:8\3\2"+
		"\2\2;=\5\"\22\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?M\3\2\2\2@>\3"+
		"\2\2\2AE\7\"\2\2BD\5\"\22\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FI"+
		"\3\2\2\2GE\3\2\2\2HA\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KN\3\2\2\2L"+
		"N\7\2\2\3MH\3\2\2\2ML\3\2\2\2N\5\3\2\2\2OS\5\f\7\2PR\5\"\22\2QP\3\2\2"+
		"\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VZ\7\34\2\2WY\5\""+
		"\22\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^"+
		"\5\n\6\2^_\7\"\2\2_`\7!\2\2`a\5\30\r\2ab\5\4\3\2b\u00b9\3\2\2\2cg\5\f"+
		"\7\2df\5\"\22\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3"+
		"\2\2\2jn\7\34\2\2km\5\"\22\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o"+
		"q\3\2\2\2pn\3\2\2\2qr\5\n\6\2rv\7\33\2\2su\5\"\22\2ts\3\2\2\2ux\3\2\2"+
		"\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\5\30\r\2z{\5\4\3\2{\u00b9"+
		"\3\2\2\2|\u0080\5\f\7\2}\177\5\"\22\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2"+
		"\u0083\u0087\7\34\2\2\u0084\u0086\5\"\22\2\u0085\u0084\3\2\2\2\u0086\u0089"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u008a\u008b\5\n\6\2\u008b\u008c\5\4\3\2\u008c\u00b9\3\2"+
		"\2\2\u008d\u0091\5\f\7\2\u008e\u0090\5\"\22\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0095\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0096\7\34\2\2\u0095\u0094\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u009a\3\2\2\2\u0097\u0099\5\"\22\2\u0098\u0097\3"+
		"\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u00b2\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u00a7\7\"\2\2\u009e\u00a0\5\""+
		"\22\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\7\""+
		"\2\2\u00a5\u00a1\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7!"+
		"\2\2\u00ab\u00af\5\b\5\2\u00ac\u00ae\5\"\22\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b3\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b2\u009d\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\5\4"+
		"\3\2\u00b7\u00b9\3\2\2\2\u00b8O\3\2\2\2\u00b8c\3\2\2\2\u00b8|\3\2\2\2"+
		"\u00b8\u008d\3\2\2\2\u00b9\7\3\2\2\2\u00ba\u00cc\5\n\6\2\u00bb\u00bc\5"+
		"\n\6\2\u00bc\u00be\7\33\2\2\u00bd\u00bf\5\"\22\2\u00be\u00bd\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\5\30\r\2\u00c1\u00c3\5"+
		"\"\22\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00cc\3\2\2\2\u00c4"+
		"\u00c5\5\n\6\2\u00c5\u00c6\7\"\2\2\u00c6\u00c7\7 \2\2\u00c7\u00c9\5\30"+
		"\r\2\u00c8\u00ca\5\"\22\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cc\3\2\2\2\u00cb\u00ba\3\2\2\2\u00cb\u00bb\3\2\2\2\u00cb\u00c4\3\2"+
		"\2\2\u00cc\t\3\2\2\2\u00cd\u00cf\5\16\b\2\u00ce\u00d0\5\"\22\2\u00cf\u00ce"+
		"\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\13\3\2\2"+
		"\2\u00d5\u00d8\7\36\2\2\u00d6\u00d8\5\26\f\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d6\3\2\2\2\u00d8\r\3\2\2\2\u00d9\u00dc\5\20\t\2\u00da\u00dc\5\22\n"+
		"\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\17\3\2\2\2\u00dd\u00e1"+
		"\7\3\2\2\u00de\u00e0\5\"\22\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2"+
		"\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1"+
		"\3\2\2\2\u00e4\u00e8\5\20\t\2\u00e5\u00e7\5\"\22\2\u00e6\u00e5\3\2\2\2"+
		"\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00f9"+
		"\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ed\5\"\22\2\u00ec\u00eb\3\2\2\2"+
		"\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1"+
		"\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f5\7\4\2\2\u00f2\u00f4\5\"\22\2"+
		"\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6"+
		"\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fa\5\20\t\2"+
		"\u00f9\u00ee\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc"+
		"\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\7\5\2\2\u00fe\u012e\3\2\2\2\u00ff"+
		"\u0107\7\3\2\2\u0100\u0104\5\20\t\2\u0101\u0103\5\"\22\2\u0102\u0101\3"+
		"\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0100\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"\u010c\7\5\2\2\u010c\u012e\3\2\2\2\u010d\u012e\5\24\13\2\u010e\u0112\7"+
		"\3\2\2\u010f\u0111\5\"\22\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0115\u0119\5\22\n\2\u0116\u0118\5\"\22\2\u0117\u0116\3\2\2\2\u0118"+
		"\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7\5\2\2\u011d\u012e\3\2\2\2\u011e"+
		"\u0122\7\36\2\2\u011f\u0121\5\"\22\2\u0120\u011f\3\2\2\2\u0121\u0124\3"+
		"\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0125\u0129\7\35\2\2\u0126\u0128\5\"\22\2\u0127\u0126\3"+
		"\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012e\5\20\t\2\u012d\u00dd\3"+
		"\2\2\2\u012d\u00ff\3\2\2\2\u012d\u010d\3\2\2\2\u012d\u010e\3\2\2\2\u012d"+
		"\u011e\3\2\2\2\u012e\21\3\2\2\2\u012f\u013e\5\20\t\2\u0130\u0132\5\"\22"+
		"\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u013a\7\4\2\2\u0137"+
		"\u0139\5\"\22\2\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3"+
		"\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d"+
		"\u013f\5\20\t\2\u013e\u0133\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u013e\3"+
		"\2\2\2\u0140\u0141\3\2\2\2\u0141\23\3\2\2\2\u0142\u0148\7\36\2\2\u0143"+
		"\u0148\7\37\2\2\u0144\u0148\5\36\20\2\u0145\u0148\5\26\f\2\u0146\u0148"+
		"\7$\2\2\u0147\u0142\3\2\2\2\u0147\u0143\3\2\2\2\u0147\u0144\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0146\3\2\2\2\u0148\25\3\2\2\2\u0149\u014a\t\2\2"+
		"\2\u014a\u014b\7\36\2\2\u014b\27\3\2\2\2\u014c\u014d\b\r\1\2\u014d\u01a0"+
		"\5\34\17\2\u014e\u01a0\5\36\20\2\u014f\u01a0\5 \21\2\u0150\u01a0\5\32"+
		"\16\2\u0151\u0155\7\b\2\2\u0152\u0154\5$\23\2\u0153\u0152\3\2\2\2\u0154"+
		"\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2"+
		"\2\2\u0157\u0155\3\2\2\2\u0158\u015c\5\30\r\2\u0159\u015b\5$\23\2\u015a"+
		"\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2"+
		"\2\2\u015d\u016f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0163\7\t\2\2\u0160"+
		"\u0162\5$\23\2\u0161\u0160\3\2\2\2\u0162\u0165\3\2\2\2\u0163\u0161\3\2"+
		"\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2\2\2\u0165\u0163\3\2\2\2\u0166"+
		"\u016a\5\30\r\2\u0167\u0169\5$\23\2\u0168\u0167\3\2\2\2\u0169\u016c\3"+
		"\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016e\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016d\u015f\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u016f\3\2\2\2\u0172"+
		"\u0173\7\n\2\2\u0173\u01a0\3\2\2\2\u0174\u0178\7\b\2\2\u0175\u0177\5$"+
		"\23\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u01a0\7\n"+
		"\2\2\u017c\u0180\7\13\2\2\u017d\u017f\5$\23\2\u017e\u017d\3\2\2\2\u017f"+
		"\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2"+
		"\2\2\u0182\u0180\3\2\2\2\u0183\u0187\5\30\r\2\u0184\u0186\5$\23\2\u0185"+
		"\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2"+
		"\2\2\u0188\u019a\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018e\7\t\2\2\u018b"+
		"\u018d\5$\23\2\u018c\u018b\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2"+
		"\2\2\u018e\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190\u018e\3\2\2\2\u0191"+
		"\u0195\5\30\r\2\u0192\u0194\5$\23\2\u0193\u0192\3\2\2\2\u0194\u0197\3"+
		"\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0199\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0198\u018a\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2"+
		"\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019a\3\2\2\2\u019d"+
		"\u019e\7\f\2\2\u019e\u01a0\3\2\2\2\u019f\u014c\3\2\2\2\u019f\u014e\3\2"+
		"\2\2\u019f\u014f\3\2\2\2\u019f\u0150\3\2\2\2\u019f\u0151\3\2\2\2\u019f"+
		"\u0174\3\2\2\2\u019f\u017c\3\2\2\2\u01a0\u0295\3\2\2\2\u01a1\u01a5\f\23"+
		"\2\2\u01a2\u01a4\5$\23\2\u01a3\u01a2\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5"+
		"\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a5\3\2"+
		"\2\2\u01a8\u01ac\7\33\2\2\u01a9\u01ab\5$\23\2\u01aa\u01a9\3\2\2\2\u01ab"+
		"\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01af\3\2"+
		"\2\2\u01ae\u01ac\3\2\2\2\u01af\u0294\5\30\r\24\u01b0\u01b4\f\r\2\2\u01b1"+
		"\u01b3\5$\23\2\u01b2\u01b1\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2"+
		"\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7"+
		"\u01bb\7\17\2\2\u01b8\u01ba\5$\23\2\u01b9\u01b8\3\2\2\2\u01ba\u01bd\3"+
		"\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd"+
		"\u01bb\3\2\2\2\u01be\u0294\5\30\r\16\u01bf\u01c3\f\f\2\2\u01c0\u01c2\5"+
		"$\23\2\u01c1\u01c0\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3"+
		"\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6\u01ca\7\20"+
		"\2\2\u01c7\u01c9\5$\23\2\u01c8\u01c7\3\2\2\2\u01c9\u01cc\3\2\2\2\u01ca"+
		"\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cd\3\2\2\2\u01cc\u01ca\3\2"+
		"\2\2\u01cd\u0294\5\30\r\r\u01ce\u01d2\f\13\2\2\u01cf\u01d1\5$\23\2\u01d0"+
		"\u01cf\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2"+
		"\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d9\7\21\2\2\u01d6"+
		"\u01d8\5$\23\2\u01d7\u01d6\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2"+
		"\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc"+
		"\u0294\5\30\r\f\u01dd\u01e1\f\n\2\2\u01de\u01e0\5$\23\2\u01df\u01de\3"+
		"\2\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2"+
		"\u01e4\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e8\7\22\2\2\u01e5\u01e7\5"+
		"$\23\2\u01e6\u01e5\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8"+
		"\u01e9\3\2\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb\u0294\5\30"+
		"\r\13\u01ec\u01f0\f\t\2\2\u01ed\u01ef\5$\23\2\u01ee\u01ed\3\2\2\2\u01ef"+
		"\u01f2\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3\3\2"+
		"\2\2\u01f2\u01f0\3\2\2\2\u01f3\u01f7\7\23\2\2\u01f4\u01f6\5$\23\2\u01f5"+
		"\u01f4\3\2\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2"+
		"\2\2\u01f8\u01fa\3\2\2\2\u01f9\u01f7\3\2\2\2\u01fa\u0294\5\30\r\n\u01fb"+
		"\u01ff\f\b\2\2\u01fc\u01fe\5$\23\2\u01fd\u01fc\3\2\2\2\u01fe\u0201\3\2"+
		"\2\2\u01ff\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0202\3\2\2\2\u0201"+
		"\u01ff\3\2\2\2\u0202\u0206\7\35\2\2\u0203\u0205\5$\23\2\u0204\u0203\3"+
		"\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"\u0209\3\2\2\2\u0208\u0206\3\2\2\2\u0209\u0294\5\30\r\t\u020a\u020e\f"+
		"\7\2\2\u020b\u020d\5$\23\2\u020c\u020b\3\2\2\2\u020d\u0210\3\2\2\2\u020e"+
		"\u020c\3\2\2\2\u020e\u020f\3\2\2\2\u020f\u0211\3\2\2\2\u0210\u020e\3\2"+
		"\2\2\u0211\u0215\7\24\2\2\u0212\u0214\5$\23\2\u0213\u0212\3\2\2\2\u0214"+
		"\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218\3\2"+
		"\2\2\u0217\u0215\3\2\2\2\u0218\u0294\5\30\r\b\u0219\u021d\f\6\2\2\u021a"+
		"\u021c\5$\23\2\u021b\u021a\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u021b\3\2"+
		"\2\2\u021d\u021e\3\2\2\2\u021e\u0220\3\2\2\2\u021f\u021d\3\2\2\2\u0220"+
		"\u0224\7\25\2\2\u0221\u0223\5$\23\2\u0222\u0221\3\2\2\2\u0223\u0226\3"+
		"\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225\u0227\3\2\2\2\u0226"+
		"\u0224\3\2\2\2\u0227\u0294\5\30\r\7\u0228\u022c\f\5\2\2\u0229\u022b\5"+
		"$\23\2\u022a\u0229\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c"+
		"\u022d\3\2\2\2\u022d\u022f\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0233\7\26"+
		"\2\2\u0230\u0232\5$\23\2\u0231\u0230\3\2\2\2\u0232\u0235\3\2\2\2\u0233"+
		"\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0236\3\2\2\2\u0235\u0233\3\2"+
		"\2\2\u0236\u0294\5\30\r\6\u0237\u023b\f\4\2\2\u0238\u023a\5$\23\2\u0239"+
		"\u0238\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239\3\2\2\2\u023b\u023c\3\2"+
		"\2\2\u023c\u023e\3\2\2\2\u023d\u023b\3\2\2\2\u023e\u0242\7\27\2\2\u023f"+
		"\u0241\5$\23\2\u0240\u023f\3\2\2\2\u0241\u0244\3\2\2\2\u0242\u0240\3\2"+
		"\2\2\u0242\u0243\3\2\2\2\u0243\u0245\3\2\2\2\u0244\u0242\3\2\2\2\u0245"+
		"\u0294\5\30\r\5\u0246\u024a\f\3\2\2\u0247\u0249\5$\23\2\u0248\u0247\3"+
		"\2\2\2\u0249\u024c\3\2\2\2\u024a\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b"+
		"\u024d\3\2\2\2\u024c\u024a\3\2\2\2\u024d\u0251\7\30\2\2\u024e\u0250\5"+
		"$\23\2\u024f\u024e\3\2\2\2\u0250\u0253\3\2\2\2\u0251\u024f\3\2\2\2\u0251"+
		"\u0252\3\2\2\2\u0252\u0254\3\2\2\2\u0253\u0251\3\2\2\2\u0254\u0294\5\30"+
		"\r\4\u0255\u0259\f\17\2\2\u0256\u0258\5$\23\2\u0257\u0256\3\2\2\2\u0258"+
		"\u025b\3\2\2\2\u0259\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025c\3\2"+
		"\2\2\u025b\u0259\3\2\2\2\u025c\u0260\7\r\2\2\u025d\u025f\5$\23\2\u025e"+
		"\u025d\3\2\2\2\u025f\u0262\3\2\2\2\u0260\u025e\3\2\2\2\u0260\u0261\3\2"+
		"\2\2\u0261\u0263\3\2\2\2\u0262\u0260\3\2\2\2\u0263\u0267\5\30\r\2\u0264"+
		"\u0266\5$\23\2\u0265\u0264\3\2\2\2\u0266\u0269\3\2\2\2\u0267\u0265\3\2"+
		"\2\2\u0267\u0268\3\2\2\2\u0268\u027a\3\2\2\2\u0269\u0267\3\2\2\2\u026a"+
		"\u026e\7\t\2\2\u026b\u026d\5$\23\2\u026c\u026b\3\2\2\2\u026d\u0270\3\2"+
		"\2\2\u026e\u026c\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u0271\3\2\2\2\u0270"+
		"\u026e\3\2\2\2\u0271\u0275\5\30\r\2\u0272\u0274\5$\23\2\u0273\u0272\3"+
		"\2\2\2\u0274\u0277\3\2\2\2\u0275\u0273\3\2\2\2\u0275\u0276\3\2\2\2\u0276"+
		"\u0279\3\2\2\2\u0277\u0275\3\2\2\2\u0278\u026a\3\2\2\2\u0279\u027c\3\2"+
		"\2\2\u027a\u0278\3\2\2\2\u027a\u027b\3\2\2\2\u027b\u027d\3\2\2\2\u027c"+
		"\u027a\3\2\2\2\u027d\u0281\7\16\2\2\u027e\u0280\5$\23\2\u027f\u027e\3"+
		"\2\2\2\u0280\u0283\3\2\2\2\u0281\u027f\3\2\2\2\u0281\u0282\3\2\2\2\u0282"+
		"\u0294\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u0285\f\16\2\2\u0285\u0289\7"+
		"\r\2\2\u0286\u0288\5$\23\2\u0287\u0286\3\2\2\2\u0288\u028b\3\2\2\2\u0289"+
		"\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028c\3\2\2\2\u028b\u0289\3\2"+
		"\2\2\u028c\u0290\7\16\2\2\u028d\u028f\5$\23\2\u028e\u028d\3\2\2\2\u028f"+
		"\u0292\3\2\2\2\u0290\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0294\3\2"+
		"\2\2\u0292\u0290\3\2\2\2\u0293\u01a1\3\2\2\2\u0293\u01b0\3\2\2\2\u0293"+
		"\u01bf\3\2\2\2\u0293\u01ce\3\2\2\2\u0293\u01dd\3\2\2\2\u0293\u01ec\3\2"+
		"\2\2\u0293\u01fb\3\2\2\2\u0293\u020a\3\2\2\2\u0293\u0219\3\2\2\2\u0293"+
		"\u0228\3\2\2\2\u0293\u0237\3\2\2\2\u0293\u0246\3\2\2\2\u0293\u0255\3\2"+
		"\2\2\u0293\u0284\3\2\2\2\u0294\u0297\3\2\2\2\u0295\u0293\3\2\2\2\u0295"+
		"\u0296\3\2\2\2\u0296\31\3\2\2\2\u0297\u0295\3\2\2\2\u0298\u029c\7\36\2"+
		"\2\u0299\u029a\7\6\2\2\u029a\u029c\7\36\2\2\u029b\u0298\3\2\2\2\u029b"+
		"\u0299\3\2\2\2\u029c\33\3\2\2\2\u029d\u029e\7$\2\2\u029e\35\3\2\2\2\u029f"+
		"\u02a0\7\31\2\2\u02a0\37\3\2\2\2\u02a1\u02a2\7\32\2\2\u02a2!\3\2\2\2\u02a3"+
		"\u02a4\t\3\2\2\u02a4#\3\2\2\2\u02a5\u02a6\t\4\2\2\u02a6%\3\2\2\2b(*\61"+
		"\668>EJMSZgnv\u0080\u0087\u0091\u0095\u009a\u00a1\u00a7\u00af\u00b4\u00b8"+
		"\u00be\u00c2\u00c9\u00cb\u00cf\u00d3\u00d7\u00db\u00e1\u00e8\u00ee\u00f5"+
		"\u00fb\u0104\u0109\u0112\u0119\u0122\u0129\u012d\u0133\u013a\u0140\u0147"+
		"\u0155\u015c\u0163\u016a\u016f\u0178\u0180\u0187\u018e\u0195\u019a\u019f"+
		"\u01a5\u01ac\u01b4\u01bb\u01c3\u01ca\u01d2\u01d9\u01e1\u01e8\u01f0\u01f7"+
		"\u01ff\u0206\u020e\u0215\u021d\u0224\u022c\u0233\u023b\u0242\u024a\u0251"+
		"\u0259\u0260\u0267\u026e\u0275\u027a\u0281\u0289\u0290\u0293\u0295\u029b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}