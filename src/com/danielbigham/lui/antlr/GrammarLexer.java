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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, INTEGER=19, REAL=20, ARROW=21, COLON=22, EQUALS=23, ID=24, DOUBLE_INDENT=25, 
		INDENT=26, NEWLINE=27, OTHER_WS=28, STRING=29, WS=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "INTEGER", "REAL", "DIGITS", "ARROW", "COLON", "EQUALS", "ID", 
		"LETTER", "DOUBLE_INDENT", "INDENT", "NEWLINE", "OTHER_WS", "STRING", 
		"WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2 \u00d0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\5\24n\n\24\3\24"+
		"\3\24\3\25\5\25s\n\25\3\25\3\25\3\25\5\25x\n\25\3\26\6\26{\n\26\r\26\16"+
		"\26|\3\27\3\27\3\27\5\27\u0082\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32"+
		"\7\32\u008b\n\32\f\32\16\32\u008e\13\32\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u009c\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u00a3\n\35\3\36\5\36\u00a6\n\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\5\37\u00c1\n\37\3 \3 \3 \3 \6 \u00c7\n \r \16"+
		" \u00c8\3 \3 \3!\3!\3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\2-\27/\30"+
		"\61\31\63\32\65\2\67\339\34;\35=\36?\37A \3\2\5\6\2C\\aac|\u0082\u0101"+
		"\3\2$$\4\2\13\13\"\"\u00df\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7G\3\2\2"+
		"\2\tI\3\2\2\2\13K\3\2\2\2\rM\3\2\2\2\17O\3\2\2\2\21Q\3\2\2\2\23S\3\2\2"+
		"\2\25U\3\2\2\2\27W\3\2\2\2\31Y\3\2\2\2\33[\3\2\2\2\35]\3\2\2\2\37_\3\2"+
		"\2\2!a\3\2\2\2#d\3\2\2\2%h\3\2\2\2\'m\3\2\2\2)r\3\2\2\2+z\3\2\2\2-\u0081"+
		"\3\2\2\2/\u0083\3\2\2\2\61\u0085\3\2\2\2\63\u0087\3\2\2\2\65\u008f\3\2"+
		"\2\2\67\u009b\3\2\2\29\u00a2\3\2\2\2;\u00a5\3\2\2\2=\u00c0\3\2\2\2?\u00c2"+
		"\3\2\2\2A\u00cc\3\2\2\2CD\7*\2\2D\4\3\2\2\2EF\7~\2\2F\6\3\2\2\2GH\7+\2"+
		"\2H\b\3\2\2\2IJ\7&\2\2J\n\3\2\2\2KL\7\u0080\2\2L\f\3\2\2\2MN\7}\2\2N\16"+
		"\3\2\2\2OP\7.\2\2P\20\3\2\2\2QR\7\177\2\2R\22\3\2\2\2ST\7]\2\2T\24\3\2"+
		"\2\2UV\7_\2\2V\26\3\2\2\2WX\7`\2\2X\30\3\2\2\2YZ\7,\2\2Z\32\3\2\2\2[\\"+
		"\7\61\2\2\\\34\3\2\2\2]^\7-\2\2^\36\3\2\2\2_`\7/\2\2` \3\2\2\2ab\7?\2"+
		"\2bc\7?\2\2c\"\3\2\2\2de\7?\2\2ef\7?\2\2fg\7?\2\2g$\3\2\2\2hi\7?\2\2i"+
		"j\7#\2\2jk\7?\2\2k&\3\2\2\2ln\7/\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\5"+
		"+\26\2p(\3\2\2\2qs\7/\2\2rq\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\5+\26\2uw\7"+
		"\60\2\2vx\5+\26\2wv\3\2\2\2wx\3\2\2\2x*\3\2\2\2y{\4\62;\2zy\3\2\2\2{|"+
		"\3\2\2\2|z\3\2\2\2|}\3\2\2\2},\3\2\2\2~\177\7/\2\2\177\u0082\7@\2\2\u0080"+
		"\u0082\7\u2194\2\2\u0081~\3\2\2\2\u0081\u0080\3\2\2\2\u0082.\3\2\2\2\u0083"+
		"\u0084\7<\2\2\u0084\60\3\2\2\2\u0085\u0086\7?\2\2\u0086\62\3\2\2\2\u0087"+
		"\u008c\5\65\33\2\u0088\u008b\5\65\33\2\u0089\u008b\4\62;\2\u008a\u0088"+
		"\3\2\2\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\64\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\t\2\2"+
		"\2\u0090\66\3\2\2\2\u0091\u0092\7\13\2\2\u0092\u009c\7\13\2\2\u0093\u0094"+
		"\7\"\2\2\u0094\u0095\7\"\2\2\u0095\u0096\7\"\2\2\u0096\u0097\7\"\2\2\u0097"+
		"\u0098\7\"\2\2\u0098\u0099\7\"\2\2\u0099\u009a\7\"\2\2\u009a\u009c\7\""+
		"\2\2\u009b\u0091\3\2\2\2\u009b\u0093\3\2\2\2\u009c8\3\2\2\2\u009d\u00a3"+
		"\7\13\2\2\u009e\u009f\7\"\2\2\u009f\u00a0\7\"\2\2\u00a0\u00a1\7\"\2\2"+
		"\u00a1\u00a3\7\"\2\2\u00a2\u009d\3\2\2\2\u00a2\u009e\3\2\2\2\u00a3:\3"+
		"\2\2\2\u00a4\u00a6\7\17\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\7\f\2\2\u00a8<\3\2\2\2\u00a9\u00c1\7\"\2\2"+
		"\u00aa\u00ab\7\"\2\2\u00ab\u00c1\7\"\2\2\u00ac\u00ad\7\"\2\2\u00ad\u00ae"+
		"\7\"\2\2\u00ae\u00c1\7\"\2\2\u00af\u00b0\7\"\2\2\u00b0\u00b1\7\"\2\2\u00b1"+
		"\u00b2\7\"\2\2\u00b2\u00b3\7\"\2\2\u00b3\u00c1\7\"\2\2\u00b4\u00b5\7\13"+
		"\2\2\u00b5\u00b6\7\13\2\2\u00b6\u00c1\7\13\2\2\u00b7\u00b8\7\13\2\2\u00b8"+
		"\u00b9\7\13\2\2\u00b9\u00ba\7\13\2\2\u00ba\u00c1\7\13\2\2\u00bb\u00bc"+
		"\7\13\2\2\u00bc\u00bd\7\13\2\2\u00bd\u00be\7\13\2\2\u00be\u00bf\7\13\2"+
		"\2\u00bf\u00c1\7\13\2\2\u00c0\u00a9\3\2\2\2\u00c0\u00aa\3\2\2\2\u00c0"+
		"\u00ac\3\2\2\2\u00c0\u00af\3\2\2\2\u00c0\u00b4\3\2\2\2\u00c0\u00b7\3\2"+
		"\2\2\u00c0\u00bb\3\2\2\2\u00c1>\3\2\2\2\u00c2\u00c6\7$\2\2\u00c3\u00c7"+
		"\n\3\2\2\u00c4\u00c5\7^\2\2\u00c5\u00c7\7$\2\2\u00c6\u00c3\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7$\2\2\u00cb@\3\2\2\2\u00cc\u00cd"+
		"\t\4\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\b!\2\2\u00cfB\3\2\2\2\20\2mr"+
		"w|\u0081\u008a\u008c\u009b\u00a2\u00a5\u00c0\u00c6\u00c8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}