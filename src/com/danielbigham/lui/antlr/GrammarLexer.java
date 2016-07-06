// Generated from C:\Users\Daniel\WolframWorkspaces\Base2\Lui\AntlrGrammar\Grammar.g4 by ANTLR 4.5.3
package com.danielbigham.lui.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, STRING=16, 
		INTEGER=17, REAL=18, ARROW=19, COLON=20, ID=21, NEWLINE=22, NEWLINE_DOUBLE_INDENT=23, 
		NEWLINE_INDENT=24, WS=25, WS2=26, INDENT=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "STRING", "INTEGER", 
		"REAL", "DIGITS", "ARROW", "COLON", "ID", "LETTER", "NEWLINE", "NEWLINE_DOUBLE_INDENT", 
		"NEWLINE_INDENT", "WS", "WS2", "INDENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "'('", "')'", "'$'", "'~'", "'{'", "','", "'}'", "'['", "']'", 
		"'^'", "'*'", "'/'", "'+'", "'-'", null, null, null, null, "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "STRING", "INTEGER", "REAL", "ARROW", "COLON", 
		"ID", "NEWLINE", "NEWLINE_DOUBLE_INDENT", "NEWLINE_INDENT", "WS", "WS2", 
		"INDENT"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00a1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\6\21"+
		"`\n\21\r\21\16\21a\3\21\3\21\3\22\3\22\3\23\3\23\3\23\5\23k\n\23\3\24"+
		"\6\24n\n\24\r\24\16\24o\3\25\3\25\3\25\5\25u\n\25\3\26\3\26\3\27\3\27"+
		"\3\27\7\27|\n\27\f\27\16\27\177\13\27\3\30\3\30\3\31\5\31\u0084\n\31\3"+
		"\31\3\31\3\32\5\32\u0089\n\32\3\32\3\32\3\32\3\32\3\33\5\33\u0090\n\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\5\36\u00a0\n\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\2)\25+\26-\27/\2\61\30\63"+
		"\31\65\32\67\339\34;\35\3\2\6\3\2$$\6\2C\\aac|\u0082\u0101\4\2\13\13\""+
		"\"\5\2\13\f\17\17\"\"\u00a9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2"+
		";\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2\2\2\13E\3\2\2\2\rG\3"+
		"\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31"+
		"S\3\2\2\2\33U\3\2\2\2\35W\3\2\2\2\37Y\3\2\2\2![\3\2\2\2#e\3\2\2\2%g\3"+
		"\2\2\2\'m\3\2\2\2)t\3\2\2\2+v\3\2\2\2-x\3\2\2\2/\u0080\3\2\2\2\61\u0083"+
		"\3\2\2\2\63\u0088\3\2\2\2\65\u008f\3\2\2\2\67\u0094\3\2\2\29\u0098\3\2"+
		"\2\2;\u009f\3\2\2\2=>\7~\2\2>\4\3\2\2\2?@\7*\2\2@\6\3\2\2\2AB\7+\2\2B"+
		"\b\3\2\2\2CD\7&\2\2D\n\3\2\2\2EF\7\u0080\2\2F\f\3\2\2\2GH\7}\2\2H\16\3"+
		"\2\2\2IJ\7.\2\2J\20\3\2\2\2KL\7\177\2\2L\22\3\2\2\2MN\7]\2\2N\24\3\2\2"+
		"\2OP\7_\2\2P\26\3\2\2\2QR\7`\2\2R\30\3\2\2\2ST\7,\2\2T\32\3\2\2\2UV\7"+
		"\61\2\2V\34\3\2\2\2WX\7-\2\2X\36\3\2\2\2YZ\7/\2\2Z \3\2\2\2[_\7$\2\2\\"+
		"`\n\2\2\2]^\7^\2\2^`\7$\2\2_\\\3\2\2\2_]\3\2\2\2`a\3\2\2\2a_\3\2\2\2a"+
		"b\3\2\2\2bc\3\2\2\2cd\7$\2\2d\"\3\2\2\2ef\5\'\24\2f$\3\2\2\2gh\5\'\24"+
		"\2hj\7\60\2\2ik\5\'\24\2ji\3\2\2\2jk\3\2\2\2k&\3\2\2\2ln\4\62;\2ml\3\2"+
		"\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2p(\3\2\2\2qr\7/\2\2ru\7@\2\2su\7\u2194"+
		"\2\2tq\3\2\2\2ts\3\2\2\2u*\3\2\2\2vw\7<\2\2w,\3\2\2\2x}\5/\30\2y|\5/\30"+
		"\2z|\4\62;\2{y\3\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~.\3"+
		"\2\2\2\177}\3\2\2\2\u0080\u0081\t\3\2\2\u0081\60\3\2\2\2\u0082\u0084\7"+
		"\17\2\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0086\7\f\2\2\u0086\62\3\2\2\2\u0087\u0089\7\17\2\2\u0088\u0087\3\2\2"+
		"\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\7\f\2\2\u008b\u008c"+
		"\7\13\2\2\u008c\u008d\7\13\2\2\u008d\64\3\2\2\2\u008e\u0090\7\17\2\2\u008f"+
		"\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\f"+
		"\2\2\u0092\u0093\7\13\2\2\u0093\66\3\2\2\2\u0094\u0095\t\4\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0097\b\34\2\2\u00978\3\2\2\2\u0098\u0099\t\5\2\2\u0099"+
		":\3\2\2\2\u009a\u009b\7\"\2\2\u009b\u009c\7\"\2\2\u009c\u009d\7\"\2\2"+
		"\u009d\u00a0\7\"\2\2\u009e\u00a0\7\13\2\2\u009f\u009a\3\2\2\2\u009f\u009e"+
		"\3\2\2\2\u00a0<\3\2\2\2\16\2_ajot{}\u0083\u0088\u008f\u009f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}