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
		T__9=10, T__10=11, MATH_OP_MEDIUM_PRIORITY=12, MATH_OP_HIGH_PRIORITY=13, 
		MATH_OP_LOW_PRIORITY=14, ENDLINE=15, EQUAL=16, OTHER_ASSIGN_OPS=17, INCR_DECR=18, 
		COMPARACION=19, LOGIC_OP=20, VALID_C_TYPES=21, ID=22, INT=23, FLOAT=24, 
		CHAR=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "MATH_OP_MEDIUM_PRIORITY", "MATH_OP_HIGH_PRIORITY", "MATH_OP_LOW_PRIORITY", 
		"ENDLINE", "EQUAL", "OTHER_ASSIGN_OPS", "INCR_DECR", "COMPARACION", "LOGIC_OP", 
		"VALID_C_TYPES", "ID", "INT", "FLOAT", "CHAR", "CHARS_", "ALPHABET", "VALID_ID_SIMBOLS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'return'", "'('", "')'", "'for'", "'while'", "'if'", "'else'", 
		"'{'", "'}'", "','", null, "'^'", null, null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"MATH_OP_MEDIUM_PRIORITY", "MATH_OP_HIGH_PRIORITY", "MATH_OP_LOW_PRIORITY", 
		"ENDLINE", "EQUAL", "OTHER_ASSIGN_OPS", "INCR_DECR", "COMPARACION", "LOGIC_OP", 
		"VALID_C_TYPES", "ID", "INT", "FLOAT", "CHAR"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00ee\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\5\22u\n\22\3\23\3\23\3\23\3\23\5\23{\n\23\3\24\3\24\3"+
		"\24\3\24\5\24\u0081\n\24\3\24\3\24\5\24\u0085\n\24\5\24\u0087\n\24\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u008e\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00bc\n\26\3\27\3\27"+
		"\6\27\u00c0\n\27\r\27\16\27\u00c1\3\30\6\30\u00c5\n\30\r\30\16\30\u00c6"+
		"\3\31\6\31\u00ca\n\31\r\31\16\31\u00cb\3\31\3\31\6\31\u00d0\n\31\r\31"+
		"\16\31\u00d1\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00dc\n\32\3"+
		"\33\3\33\3\33\3\33\3\33\7\33\u00e3\n\33\f\33\16\33\u00e6\13\33\3\34\6"+
		"\34\u00e9\n\34\r\34\16\34\u00ea\3\35\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\2\67\29\2\3\2\7\4\2,,\61\61\4\2--//\5"+
		"\2\13\f\17\17\"\"\3\2\62;\4\2C\\c|\u0109\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3"+
		";\3\2\2\2\5=\3\2\2\2\7D\3\2\2\2\tF\3\2\2\2\13H\3\2\2\2\rL\3\2\2\2\17R"+
		"\3\2\2\2\21U\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31`\3\2\2\2"+
		"\33b\3\2\2\2\35d\3\2\2\2\37f\3\2\2\2!j\3\2\2\2#t\3\2\2\2%z\3\2\2\2\'\u0086"+
		"\3\2\2\2)\u008d\3\2\2\2+\u00bb\3\2\2\2-\u00bf\3\2\2\2/\u00c4\3\2\2\2\61"+
		"\u00c9\3\2\2\2\63\u00db\3\2\2\2\65\u00e4\3\2\2\2\67\u00e8\3\2\2\29\u00ec"+
		"\3\2\2\2;<\7=\2\2<\4\3\2\2\2=>\7t\2\2>?\7g\2\2?@\7v\2\2@A\7w\2\2AB\7t"+
		"\2\2BC\7p\2\2C\6\3\2\2\2DE\7*\2\2E\b\3\2\2\2FG\7+\2\2G\n\3\2\2\2HI\7h"+
		"\2\2IJ\7q\2\2JK\7t\2\2K\f\3\2\2\2LM\7y\2\2MN\7j\2\2NO\7k\2\2OP\7n\2\2"+
		"PQ\7g\2\2Q\16\3\2\2\2RS\7k\2\2ST\7h\2\2T\20\3\2\2\2UV\7g\2\2VW\7n\2\2"+
		"WX\7u\2\2XY\7g\2\2Y\22\3\2\2\2Z[\7}\2\2[\24\3\2\2\2\\]\7\177\2\2]\26\3"+
		"\2\2\2^_\7.\2\2_\30\3\2\2\2`a\t\2\2\2a\32\3\2\2\2bc\7`\2\2c\34\3\2\2\2"+
		"de\t\3\2\2e\36\3\2\2\2fg\t\4\2\2gh\3\2\2\2hi\b\20\2\2i \3\2\2\2jk\7?\2"+
		"\2k\"\3\2\2\2lm\7,\2\2mu\7?\2\2no\7-\2\2ou\7?\2\2pq\7/\2\2qu\7?\2\2rs"+
		"\7\61\2\2su\7?\2\2tl\3\2\2\2tn\3\2\2\2tp\3\2\2\2tr\3\2\2\2u$\3\2\2\2v"+
		"w\7/\2\2w{\7/\2\2xy\7-\2\2y{\7-\2\2zv\3\2\2\2zx\3\2\2\2{&\3\2\2\2|}\7"+
		"?\2\2}\u0087\7?\2\2~\u0080\7@\2\2\177\u0081\7?\2\2\u0080\177\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\u0087\3\2\2\2\u0082\u0084\7>\2\2\u0083\u0085\7?\2"+
		"\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086|"+
		"\3\2\2\2\u0086~\3\2\2\2\u0086\u0082\3\2\2\2\u0087(\3\2\2\2\u0088\u0089"+
		"\7~\2\2\u0089\u008e\7~\2\2\u008a\u008b\7(\2\2\u008b\u008e\7(\2\2\u008c"+
		"\u008e\7#\2\2\u008d\u0088\3\2\2\2\u008d\u008a\3\2\2\2\u008d\u008c\3\2"+
		"\2\2\u008e*\3\2\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091\u00bc"+
		"\7v\2\2\u0092\u0093\7K\2\2\u0093\u0094\7P\2\2\u0094\u00bc\7V\2\2\u0095"+
		"\u0096\7h\2\2\u0096\u0097\7n\2\2\u0097\u0098\7q\2\2\u0098\u0099\7c\2\2"+
		"\u0099\u00bc\7v\2\2\u009a\u009b\7H\2\2\u009b\u009c\7N\2\2\u009c\u009d"+
		"\7Q\2\2\u009d\u009e\7C\2\2\u009e\u00bc\7V\2\2\u009f\u00a0\7f\2\2\u00a0"+
		"\u00a1\7q\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7d\2\2\u00a3\u00a4\7n\2\2"+
		"\u00a4\u00bc\7g\2\2\u00a5\u00a6\7F\2\2\u00a6\u00a7\7Q\2\2\u00a7\u00a8"+
		"\7W\2\2\u00a8\u00a9\7D\2\2\u00a9\u00aa\7N\2\2\u00aa\u00bc\7G\2\2\u00ab"+
		"\u00ac\7e\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7c\2\2\u00ae\u00bc\7t\2\2"+
		"\u00af\u00b0\7E\2\2\u00b0\u00b1\7J\2\2\u00b1\u00b2\7C\2\2\u00b2\u00bc"+
		"\7T\2\2\u00b3\u00b4\7x\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7k\2\2\u00b6"+
		"\u00bc\7f\2\2\u00b7\u00b8\7X\2\2\u00b8\u00b9\7Q\2\2\u00b9\u00ba\7K\2\2"+
		"\u00ba\u00bc\7F\2\2\u00bb\u008f\3\2\2\2\u00bb\u0092\3\2\2\2\u00bb\u0095"+
		"\3\2\2\2\u00bb\u009a\3\2\2\2\u00bb\u009f\3\2\2\2\u00bb\u00a5\3\2\2\2\u00bb"+
		"\u00ab\3\2\2\2\u00bb\u00af\3\2\2\2\u00bb\u00b3\3\2\2\2\u00bb\u00b7\3\2"+
		"\2\2\u00bc,\3\2\2\2\u00bd\u00c0\5\67\34\2\u00be\u00c0\59\35\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2.\3\2\2\2\u00c3\u00c5\t\5\2\2\u00c4\u00c3\3\2\2\2"+
		"\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\60"+
		"\3\2\2\2\u00c8\u00ca\t\5\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\7\60"+
		"\2\2\u00ce\u00d0\t\5\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\62\3\2\2\2\u00d3\u00d4\7$\2\2"+
		"\u00d4\u00d5\5\65\33\2\u00d5\u00d6\7$\2\2\u00d6\u00dc\3\2\2\2\u00d7\u00d8"+
		"\7)\2\2\u00d8\u00d9\5\65\33\2\u00d9\u00da\7)\2\2\u00da\u00dc\3\2\2\2\u00db"+
		"\u00d3\3\2\2\2\u00db\u00d7\3\2\2\2\u00dc\64\3\2\2\2\u00dd\u00e3\5\67\34"+
		"\2\u00de\u00e3\59\35\2\u00df\u00e3\5/\30\2\u00e0\u00e3\5\61\31\2\u00e1"+
		"\u00e3\7\"\2\2\u00e2\u00dd\3\2\2\2\u00e2\u00de\3\2\2\2\u00e2\u00df\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\66\3\2\2\2\u00e6\u00e4\3\2\2"+
		"\2\u00e7\u00e9\t\6\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb8\3\2\2\2\u00ec\u00ed\7a\2\2\u00ed:"+
		"\3\2\2\2\23\2tz\u0080\u0084\u0086\u008d\u00bb\u00bf\u00c1\u00c6\u00cb"+
		"\u00d1\u00db\u00e2\u00e4\u00ea\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}