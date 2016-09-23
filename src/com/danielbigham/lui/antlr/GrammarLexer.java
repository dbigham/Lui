// Generated from E:\Users\Daniel\Dropbox\Projects\Lui\AntlrGrammar\Grammar.g4 by ANTLR 4.5.3
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, INTEGER=16, 
		REAL=17, ARROW=18, COLON=19, EQUALS=20, ID=21, DOUBLE_INDENT=22, INDENT=23, 
		NEWLINE=24, OTHER_WS=25, STRING=26, WS=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "INTEGER", "REAL", 
		"DIGITS", "ARROW", "COLON", "EQUALS", "ID", "LETTER", "DOUBLE_INDENT", 
		"INDENT", "NEWLINE", "OTHER_WS", "STRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'|'", "')'", "'$'", "'~'", "'{'", "','", "'}'", "'['", "']'", 
		"'^'", "'*'", "'/'", "'+'", "'-'", null, null, null, "':'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "INTEGER", "REAL", "ARROW", "COLON", "EQUALS", 
		"ID", "DOUBLE_INDENT", "INDENT", "NEWLINE", "OTHER_WS", "STRING", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00b9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22"+
		"\5\22a\n\22\3\23\6\23d\n\23\r\23\16\23e\3\24\3\24\3\24\5\24k\n\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\27\7\27t\n\27\f\27\16\27w\13\27\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0085\n\31\3\32"+
		"\3\32\3\32\3\32\3\32\5\32\u008c\n\32\3\33\5\33\u008f\n\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00aa\n\34\3\35\3\35"+
		"\3\35\3\35\6\35\u00b0\n\35\r\35\16\35\u00b1\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\2\'\24)\25+\26-\27/\2\61\30\63\31\65\32\67\33"+
		"9\34;\35\3\2\5\6\2C\\aac|\u0082\u0101\3\2$$\4\2\13\13\"\"\u00c6\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2"+
		"\7A\3\2\2\2\tC\3\2\2\2\13E\3\2\2\2\rG\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2"+
		"\23M\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33U\3\2\2\2\35W\3\2\2"+
		"\2\37Y\3\2\2\2![\3\2\2\2#]\3\2\2\2%c\3\2\2\2\'j\3\2\2\2)l\3\2\2\2+n\3"+
		"\2\2\2-p\3\2\2\2/x\3\2\2\2\61\u0084\3\2\2\2\63\u008b\3\2\2\2\65\u008e"+
		"\3\2\2\2\67\u00a9\3\2\2\29\u00ab\3\2\2\2;\u00b5\3\2\2\2=>\7*\2\2>\4\3"+
		"\2\2\2?@\7~\2\2@\6\3\2\2\2AB\7+\2\2B\b\3\2\2\2CD\7&\2\2D\n\3\2\2\2EF\7"+
		"\u0080\2\2F\f\3\2\2\2GH\7}\2\2H\16\3\2\2\2IJ\7.\2\2J\20\3\2\2\2KL\7\177"+
		"\2\2L\22\3\2\2\2MN\7]\2\2N\24\3\2\2\2OP\7_\2\2P\26\3\2\2\2QR\7`\2\2R\30"+
		"\3\2\2\2ST\7,\2\2T\32\3\2\2\2UV\7\61\2\2V\34\3\2\2\2WX\7-\2\2X\36\3\2"+
		"\2\2YZ\7/\2\2Z \3\2\2\2[\\\5%\23\2\\\"\3\2\2\2]^\5%\23\2^`\7\60\2\2_a"+
		"\5%\23\2`_\3\2\2\2`a\3\2\2\2a$\3\2\2\2bd\4\62;\2cb\3\2\2\2de\3\2\2\2e"+
		"c\3\2\2\2ef\3\2\2\2f&\3\2\2\2gh\7/\2\2hk\7@\2\2ik\7\u2194\2\2jg\3\2\2"+
		"\2ji\3\2\2\2k(\3\2\2\2lm\7<\2\2m*\3\2\2\2no\7?\2\2o,\3\2\2\2pu\5/\30\2"+
		"qt\5/\30\2rt\4\62;\2sq\3\2\2\2sr\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2"+
		"v.\3\2\2\2wu\3\2\2\2xy\t\2\2\2y\60\3\2\2\2z{\7\13\2\2{\u0085\7\13\2\2"+
		"|}\7\"\2\2}~\7\"\2\2~\177\7\"\2\2\177\u0080\7\"\2\2\u0080\u0081\7\"\2"+
		"\2\u0081\u0082\7\"\2\2\u0082\u0083\7\"\2\2\u0083\u0085\7\"\2\2\u0084z"+
		"\3\2\2\2\u0084|\3\2\2\2\u0085\62\3\2\2\2\u0086\u008c\7\13\2\2\u0087\u0088"+
		"\7\"\2\2\u0088\u0089\7\"\2\2\u0089\u008a\7\"\2\2\u008a\u008c\7\"\2\2\u008b"+
		"\u0086\3\2\2\2\u008b\u0087\3\2\2\2\u008c\64\3\2\2\2\u008d\u008f\7\17\2"+
		"\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091"+
		"\7\f\2\2\u0091\66\3\2\2\2\u0092\u00aa\7\"\2\2\u0093\u0094\7\"\2\2\u0094"+
		"\u00aa\7\"\2\2\u0095\u0096\7\"\2\2\u0096\u0097\7\"\2\2\u0097\u00aa\7\""+
		"\2\2\u0098\u0099\7\"\2\2\u0099\u009a\7\"\2\2\u009a\u009b\7\"\2\2\u009b"+
		"\u009c\7\"\2\2\u009c\u00aa\7\"\2\2\u009d\u009e\7\13\2\2\u009e\u009f\7"+
		"\13\2\2\u009f\u00aa\7\13\2\2\u00a0\u00a1\7\13\2\2\u00a1\u00a2\7\13\2\2"+
		"\u00a2\u00a3\7\13\2\2\u00a3\u00aa\7\13\2\2\u00a4\u00a5\7\13\2\2\u00a5"+
		"\u00a6\7\13\2\2\u00a6\u00a7\7\13\2\2\u00a7\u00a8\7\13\2\2\u00a8\u00aa"+
		"\7\13\2\2\u00a9\u0092\3\2\2\2\u00a9\u0093\3\2\2\2\u00a9\u0095\3\2\2\2"+
		"\u00a9\u0098\3\2\2\2\u00a9\u009d\3\2\2\2\u00a9\u00a0\3\2\2\2\u00a9\u00a4"+
		"\3\2\2\2\u00aa8\3\2\2\2\u00ab\u00af\7$\2\2\u00ac\u00b0\n\3\2\2\u00ad\u00ae"+
		"\7^\2\2\u00ae\u00b0\7$\2\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b4\7$\2\2\u00b4:\3\2\2\2\u00b5\u00b6\t\4\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00b8\b\36\2\2\u00b8<\3\2\2\2\16\2`ejsu\u0084\u008b\u008e"+
		"\u00a9\u00af\u00b1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}