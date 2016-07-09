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
		INTEGER=17, REAL=18, ARROW=19, COLON=20, EQUALS=21, ID=22, NEWLINE=23, 
		NEWLINE_DOUBLE_INDENT=24, NEWLINE_INDENT=25, WS=26, WS2=27, INDENT=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "STRING", "INTEGER", 
		"REAL", "DIGITS", "ARROW", "COLON", "EQUALS", "ID", "LETTER", "NEWLINE", 
		"NEWLINE_DOUBLE_INDENT", "NEWLINE_INDENT", "WS", "WS2", "INDENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'|'", "'('", "')'", "'$'", "'~'", "'{'", "','", "'}'", "'['", "']'", 
		"'^'", "'*'", "'/'", "'+'", "'-'", null, null, null, null, "':'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "STRING", "INTEGER", "REAL", "ARROW", "COLON", 
		"EQUALS", "ID", "NEWLINE", "NEWLINE_DOUBLE_INDENT", "NEWLINE_INDENT", 
		"WS", "WS2", "INDENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\6\21b\n\21\r\21\16\21c\3\21\3\21\3\22\3\22\3\23\3\23\3\23\5\23m"+
		"\n\23\3\24\6\24p\n\24\r\24\16\24q\3\25\3\25\3\25\5\25w\n\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\30\7\30\u0080\n\30\f\30\16\30\u0083\13\30\3\31"+
		"\3\31\3\32\5\32\u0088\n\32\3\32\3\32\3\33\5\33\u008d\n\33\3\33\3\33\3"+
		"\33\3\33\3\34\5\34\u0094\n\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\5\37\u00a4\n\37\2\2 \3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\2)\25+\26-\27/\30\61\2\63\31\65\32\67\339\34;\35=\36\3\2\6\3\2$$\6\2"+
		"C\\aac|\u0082\u0101\4\2\13\13\"\"\5\2\13\f\17\17\"\"\u00ad\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5A\3\2\2\2"+
		"\7C\3\2\2\2\tE\3\2\2\2\13G\3\2\2\2\rI\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2"+
		"\23O\3\2\2\2\25Q\3\2\2\2\27S\3\2\2\2\31U\3\2\2\2\33W\3\2\2\2\35Y\3\2\2"+
		"\2\37[\3\2\2\2!]\3\2\2\2#g\3\2\2\2%i\3\2\2\2\'o\3\2\2\2)v\3\2\2\2+x\3"+
		"\2\2\2-z\3\2\2\2/|\3\2\2\2\61\u0084\3\2\2\2\63\u0087\3\2\2\2\65\u008c"+
		"\3\2\2\2\67\u0093\3\2\2\29\u0098\3\2\2\2;\u009c\3\2\2\2=\u00a3\3\2\2\2"+
		"?@\7~\2\2@\4\3\2\2\2AB\7*\2\2B\6\3\2\2\2CD\7+\2\2D\b\3\2\2\2EF\7&\2\2"+
		"F\n\3\2\2\2GH\7\u0080\2\2H\f\3\2\2\2IJ\7}\2\2J\16\3\2\2\2KL\7.\2\2L\20"+
		"\3\2\2\2MN\7\177\2\2N\22\3\2\2\2OP\7]\2\2P\24\3\2\2\2QR\7_\2\2R\26\3\2"+
		"\2\2ST\7`\2\2T\30\3\2\2\2UV\7,\2\2V\32\3\2\2\2WX\7\61\2\2X\34\3\2\2\2"+
		"YZ\7-\2\2Z\36\3\2\2\2[\\\7/\2\2\\ \3\2\2\2]a\7$\2\2^b\n\2\2\2_`\7^\2\2"+
		"`b\7$\2\2a^\3\2\2\2a_\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2"+
		"ef\7$\2\2f\"\3\2\2\2gh\5\'\24\2h$\3\2\2\2ij\5\'\24\2jl\7\60\2\2km\5\'"+
		"\24\2lk\3\2\2\2lm\3\2\2\2m&\3\2\2\2np\4\62;\2on\3\2\2\2pq\3\2\2\2qo\3"+
		"\2\2\2qr\3\2\2\2r(\3\2\2\2st\7/\2\2tw\7@\2\2uw\7\u2194\2\2vs\3\2\2\2v"+
		"u\3\2\2\2w*\3\2\2\2xy\7<\2\2y,\3\2\2\2z{\7?\2\2{.\3\2\2\2|\u0081\5\61"+
		"\31\2}\u0080\5\61\31\2~\u0080\4\62;\2\177}\3\2\2\2\177~\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\60\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0084\u0085\t\3\2\2\u0085\62\3\2\2\2\u0086\u0088"+
		"\7\17\2\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u008a\7\f\2\2\u008a\64\3\2\2\2\u008b\u008d\7\17\2\2\u008c\u008b"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\f\2\2\u008f"+
		"\u0090\7\13\2\2\u0090\u0091\7\13\2\2\u0091\66\3\2\2\2\u0092\u0094\7\17"+
		"\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\7\f\2\2\u0096\u0097\7\13\2\2\u00978\3\2\2\2\u0098\u0099\t\4\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009b\b\35\2\2\u009b:\3\2\2\2\u009c\u009d\t"+
		"\5\2\2\u009d<\3\2\2\2\u009e\u009f\7\"\2\2\u009f\u00a0\7\"\2\2\u00a0\u00a1"+
		"\7\"\2\2\u00a1\u00a4\7\"\2\2\u00a2\u00a4\7\13\2\2\u00a3\u009e\3\2\2\2"+
		"\u00a3\u00a2\3\2\2\2\u00a4>\3\2\2\2\16\2aclqv\177\u0081\u0087\u008c\u0093"+
		"\u00a3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}