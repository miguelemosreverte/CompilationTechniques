// Generated from /home/miguel/Desktop/CompilationTechniques/C_Compiler/src/C_ANTLR/C.g4 by ANTLR 4.5.3
package C_ANTLR;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ENDLINE=12, EQUAL=13, OTHER_ASSIGN_OPS=14, INCR_DECR=15, 
		COMPARACION=16, MATH_OP=17, LOGIC_OP=18, VALID_C_TYPES=19, ID=20, INT=21, 
		FLOAT=22, CHAR=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "ENDLINE", "EQUAL", "OTHER_ASSIGN_OPS", "INCR_DECR", 
		"COMPARACION", "MATH_OP", "LOGIC_OP", "VALID_C_TYPES", "ID", "INT", "FLOAT", 
		"CHAR", "CHARS_", "ALPHABET", "VALID_ID_SIMBOLS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'return'", "'('", "')'", "'for'", "'while'", "'if'", "'else'", 
		"'{'", "'}'", "','", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ENDLINE", "EQUAL", "OTHER_ASSIGN_OPS", "INCR_DECR", "COMPARACION", "MATH_OP", 
		"LOGIC_OP", "VALID_C_TYPES", "ID", "INT", "FLOAT", "CHAR"
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


	public CLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00e6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17k\n\17\3\20\3\20\3\20\3\20\5\20"+
		"q\n\20\3\21\3\21\3\21\3\21\5\21w\n\21\3\21\3\21\5\21{\n\21\5\21}\n\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u0086\n\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b4"+
		"\n\24\3\25\3\25\6\25\u00b8\n\25\r\25\16\25\u00b9\3\26\6\26\u00bd\n\26"+
		"\r\26\16\26\u00be\3\27\6\27\u00c2\n\27\r\27\16\27\u00c3\3\27\3\27\6\27"+
		"\u00c8\n\27\r\27\16\27\u00c9\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5"+
		"\30\u00d4\n\30\3\31\3\31\3\31\3\31\3\31\7\31\u00db\n\31\f\31\16\31\u00de"+
		"\13\31\3\32\6\32\u00e1\n\32\r\32\16\32\u00e2\3\33\3\33\2\2\34\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\2\3\2\6\5\2\13\f\17\17\"\""+
		"\5\2,-//\61\61\3\2\62;\4\2C\\c|\u0101\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7@\3\2"+
		"\2\2\tB\3\2\2\2\13D\3\2\2\2\rH\3\2\2\2\17N\3\2\2\2\21Q\3\2\2\2\23V\3\2"+
		"\2\2\25X\3\2\2\2\27Z\3\2\2\2\31\\\3\2\2\2\33`\3\2\2\2\35j\3\2\2\2\37p"+
		"\3\2\2\2!|\3\2\2\2#~\3\2\2\2%\u0085\3\2\2\2\'\u00b3\3\2\2\2)\u00b7\3\2"+
		"\2\2+\u00bc\3\2\2\2-\u00c1\3\2\2\2/\u00d3\3\2\2\2\61\u00dc\3\2\2\2\63"+
		"\u00e0\3\2\2\2\65\u00e4\3\2\2\2\678\7=\2\28\4\3\2\2\29:\7t\2\2:;\7g\2"+
		"\2;<\7v\2\2<=\7w\2\2=>\7t\2\2>?\7p\2\2?\6\3\2\2\2@A\7*\2\2A\b\3\2\2\2"+
		"BC\7+\2\2C\n\3\2\2\2DE\7h\2\2EF\7q\2\2FG\7t\2\2G\f\3\2\2\2HI\7y\2\2IJ"+
		"\7j\2\2JK\7k\2\2KL\7n\2\2LM\7g\2\2M\16\3\2\2\2NO\7k\2\2OP\7h\2\2P\20\3"+
		"\2\2\2QR\7g\2\2RS\7n\2\2ST\7u\2\2TU\7g\2\2U\22\3\2\2\2VW\7}\2\2W\24\3"+
		"\2\2\2XY\7\177\2\2Y\26\3\2\2\2Z[\7.\2\2[\30\3\2\2\2\\]\t\2\2\2]^\3\2\2"+
		"\2^_\b\r\2\2_\32\3\2\2\2`a\7?\2\2a\34\3\2\2\2bc\7,\2\2ck\7?\2\2de\7-\2"+
		"\2ek\7?\2\2fg\7/\2\2gk\7?\2\2hi\7\61\2\2ik\7?\2\2jb\3\2\2\2jd\3\2\2\2"+
		"jf\3\2\2\2jh\3\2\2\2k\36\3\2\2\2lm\7/\2\2mq\7/\2\2no\7-\2\2oq\7-\2\2p"+
		"l\3\2\2\2pn\3\2\2\2q \3\2\2\2rs\7?\2\2s}\7?\2\2tv\7@\2\2uw\7?\2\2vu\3"+
		"\2\2\2vw\3\2\2\2w}\3\2\2\2xz\7>\2\2y{\7?\2\2zy\3\2\2\2z{\3\2\2\2{}\3\2"+
		"\2\2|r\3\2\2\2|t\3\2\2\2|x\3\2\2\2}\"\3\2\2\2~\177\t\3\2\2\177$\3\2\2"+
		"\2\u0080\u0081\7~\2\2\u0081\u0086\7~\2\2\u0082\u0083\7(\2\2\u0083\u0086"+
		"\7(\2\2\u0084\u0086\7#\2\2\u0085\u0080\3\2\2\2\u0085\u0082\3\2\2\2\u0085"+
		"\u0084\3\2\2\2\u0086&\3\2\2\2\u0087\u0088\7k\2\2\u0088\u0089\7p\2\2\u0089"+
		"\u00b4\7v\2\2\u008a\u008b\7K\2\2\u008b\u008c\7P\2\2\u008c\u00b4\7V\2\2"+
		"\u008d\u008e\7h\2\2\u008e\u008f\7n\2\2\u008f\u0090\7q\2\2\u0090\u0091"+
		"\7c\2\2\u0091\u00b4\7v\2\2\u0092\u0093\7H\2\2\u0093\u0094\7N\2\2\u0094"+
		"\u0095\7Q\2\2\u0095\u0096\7C\2\2\u0096\u00b4\7V\2\2\u0097\u0098\7f\2\2"+
		"\u0098\u0099\7q\2\2\u0099\u009a\7w\2\2\u009a\u009b\7d\2\2\u009b\u009c"+
		"\7n\2\2\u009c\u00b4\7g\2\2\u009d\u009e\7F\2\2\u009e\u009f\7Q\2\2\u009f"+
		"\u00a0\7W\2\2\u00a0\u00a1\7D\2\2\u00a1\u00a2\7N\2\2\u00a2\u00b4\7G\2\2"+
		"\u00a3\u00a4\7e\2\2\u00a4\u00a5\7j\2\2\u00a5\u00a6\7c\2\2\u00a6\u00b4"+
		"\7t\2\2\u00a7\u00a8\7E\2\2\u00a8\u00a9\7J\2\2\u00a9\u00aa\7C\2\2\u00aa"+
		"\u00b4\7T\2\2\u00ab\u00ac\7x\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7k\2\2"+
		"\u00ae\u00b4\7f\2\2\u00af\u00b0\7X\2\2\u00b0\u00b1\7Q\2\2\u00b1\u00b2"+
		"\7K\2\2\u00b2\u00b4\7F\2\2\u00b3\u0087\3\2\2\2\u00b3\u008a\3\2\2\2\u00b3"+
		"\u008d\3\2\2\2\u00b3\u0092\3\2\2\2\u00b3\u0097\3\2\2\2\u00b3\u009d\3\2"+
		"\2\2\u00b3\u00a3\3\2\2\2\u00b3\u00a7\3\2\2\2\u00b3\u00ab\3\2\2\2\u00b3"+
		"\u00af\3\2\2\2\u00b4(\3\2\2\2\u00b5\u00b8\5\63\32\2\u00b6\u00b8\5\65\33"+
		"\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7"+
		"\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba*\3\2\2\2\u00bb\u00bd\t\4\2\2\u00bc"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf,\3\2\2\2\u00c0\u00c2\t\4\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3"+
		"\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c7\7\60\2\2\u00c6\u00c8\t\4\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3"+
		"\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca.\3\2\2\2\u00cb\u00cc"+
		"\7$\2\2\u00cc\u00cd\5\61\31\2\u00cd\u00ce\7$\2\2\u00ce\u00d4\3\2\2\2\u00cf"+
		"\u00d0\7)\2\2\u00d0\u00d1\5\61\31\2\u00d1\u00d2\7)\2\2\u00d2\u00d4\3\2"+
		"\2\2\u00d3\u00cb\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d4\60\3\2\2\2\u00d5\u00db"+
		"\5\63\32\2\u00d6\u00db\5\65\33\2\u00d7\u00db\5+\26\2\u00d8\u00db\5-\27"+
		"\2\u00d9\u00db\7\"\2\2\u00da\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00da\u00d7"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\62\3\2\2\2\u00de\u00dc\3\2\2"+
		"\2\u00df\u00e1\t\5\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\64\3\2\2\2\u00e4\u00e5\7a\2\2\u00e5"+
		"\66\3\2\2\2\23\2jpvz|\u0085\u00b3\u00b7\u00b9\u00be\u00c3\u00c9\u00d3"+
		"\u00da\u00dc\u00e2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}