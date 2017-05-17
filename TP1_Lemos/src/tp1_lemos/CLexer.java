// Generated from C:\Users\Migue\Documents\NetBeansProjects\TP1_Lemos\src\tp1_lemos\C.g4 by ANTLR 4.5.3
package tp1_lemos;
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
		T__9=10, T__10=11, T__11=12, T__12=13, WS=14, EQUAL=15, OTHER_ASSIGN_OPS=16, 
		INCR_DECR=17, COMPARACION=18, MATH_OP=19, LOGIC_OP=20, VALID_C_TYPES=21, 
		ID=22, INT=23, FLOAT=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "WS", "EQUAL", "OTHER_ASSIGN_OPS", 
		"INCR_DECR", "COMPARACION", "MATH_OP", "LOGIC_OP", "VALID_C_TYPES", "ID", 
		"INT", "FLOAT", "ALPHABET", "VALID_ID_SIMBOLS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'return'", "'('", "')'", "'for'", "'while'", "'if'", "'else'", 
		"'{'", "'}'", "'\"'", "'''", "','", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "WS", "EQUAL", "OTHER_ASSIGN_OPS", "INCR_DECR", "COMPARACION", 
		"MATH_OP", "LOGIC_OP", "VALID_C_TYPES", "ID", "INT", "FLOAT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00d6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21o\n\21\3\22"+
		"\3\22\3\22\3\22\5\22u\n\22\3\23\3\23\3\23\3\23\5\23{\n\23\3\23\3\23\5"+
		"\23\177\n\23\5\23\u0081\n\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\5\25\u008a"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u00b8\n\26\3\27\3\27\6\27\u00bc\n\27\r\27\16\27\u00bd"+
		"\3\30\6\30\u00c1\n\30\r\30\16\30\u00c2\3\31\6\31\u00c6\n\31\r\31\16\31"+
		"\u00c7\3\31\3\31\6\31\u00cc\n\31\r\31\16\31\u00cd\3\32\6\32\u00d1\n\32"+
		"\r\32\16\32\u00d2\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\2\65\2\3\2\6\5\2\13\f\17\17\"\"\5\2,-//\61\61\3\2\62;\4"+
		"\2C\\c|\u00ec\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7@\3\2\2\2\tB\3\2\2"+
		"\2\13D\3\2\2\2\rH\3\2\2\2\17N\3\2\2\2\21Q\3\2\2\2\23V\3\2\2\2\25X\3\2"+
		"\2\2\27Z\3\2\2\2\31\\\3\2\2\2\33^\3\2\2\2\35`\3\2\2\2\37d\3\2\2\2!n\3"+
		"\2\2\2#t\3\2\2\2%\u0080\3\2\2\2\'\u0082\3\2\2\2)\u0089\3\2\2\2+\u00b7"+
		"\3\2\2\2-\u00bb\3\2\2\2/\u00c0\3\2\2\2\61\u00c5\3\2\2\2\63\u00d0\3\2\2"+
		"\2\65\u00d4\3\2\2\2\678\7=\2\28\4\3\2\2\29:\7t\2\2:;\7g\2\2;<\7v\2\2<"+
		"=\7w\2\2=>\7t\2\2>?\7p\2\2?\6\3\2\2\2@A\7*\2\2A\b\3\2\2\2BC\7+\2\2C\n"+
		"\3\2\2\2DE\7h\2\2EF\7q\2\2FG\7t\2\2G\f\3\2\2\2HI\7y\2\2IJ\7j\2\2JK\7k"+
		"\2\2KL\7n\2\2LM\7g\2\2M\16\3\2\2\2NO\7k\2\2OP\7h\2\2P\20\3\2\2\2QR\7g"+
		"\2\2RS\7n\2\2ST\7u\2\2TU\7g\2\2U\22\3\2\2\2VW\7}\2\2W\24\3\2\2\2XY\7\177"+
		"\2\2Y\26\3\2\2\2Z[\7$\2\2[\30\3\2\2\2\\]\7)\2\2]\32\3\2\2\2^_\7.\2\2_"+
		"\34\3\2\2\2`a\t\2\2\2ab\3\2\2\2bc\b\17\2\2c\36\3\2\2\2de\7?\2\2e \3\2"+
		"\2\2fg\7,\2\2go\7?\2\2hi\7-\2\2io\7?\2\2jk\7/\2\2ko\7?\2\2lm\7\61\2\2"+
		"mo\7?\2\2nf\3\2\2\2nh\3\2\2\2nj\3\2\2\2nl\3\2\2\2o\"\3\2\2\2pq\7/\2\2"+
		"qu\7/\2\2rs\7-\2\2su\7-\2\2tp\3\2\2\2tr\3\2\2\2u$\3\2\2\2vw\7?\2\2w\u0081"+
		"\7?\2\2xz\7@\2\2y{\7?\2\2zy\3\2\2\2z{\3\2\2\2{\u0081\3\2\2\2|~\7>\2\2"+
		"}\177\7?\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080v\3\2\2\2\u0080"+
		"x\3\2\2\2\u0080|\3\2\2\2\u0081&\3\2\2\2\u0082\u0083\t\3\2\2\u0083(\3\2"+
		"\2\2\u0084\u0085\7~\2\2\u0085\u008a\7~\2\2\u0086\u0087\7(\2\2\u0087\u008a"+
		"\7(\2\2\u0088\u008a\7#\2\2\u0089\u0084\3\2\2\2\u0089\u0086\3\2\2\2\u0089"+
		"\u0088\3\2\2\2\u008a*\3\2\2\2\u008b\u008c\7k\2\2\u008c\u008d\7p\2\2\u008d"+
		"\u00b8\7v\2\2\u008e\u008f\7K\2\2\u008f\u0090\7P\2\2\u0090\u00b8\7V\2\2"+
		"\u0091\u0092\7h\2\2\u0092\u0093\7n\2\2\u0093\u0094\7q\2\2\u0094\u0095"+
		"\7c\2\2\u0095\u00b8\7v\2\2\u0096\u0097\7H\2\2\u0097\u0098\7N\2\2\u0098"+
		"\u0099\7Q\2\2\u0099\u009a\7C\2\2\u009a\u00b8\7V\2\2\u009b\u009c\7f\2\2"+
		"\u009c\u009d\7q\2\2\u009d\u009e\7w\2\2\u009e\u009f\7d\2\2\u009f\u00a0"+
		"\7n\2\2\u00a0\u00b8\7g\2\2\u00a1\u00a2\7F\2\2\u00a2\u00a3\7Q\2\2\u00a3"+
		"\u00a4\7W\2\2\u00a4\u00a5\7D\2\2\u00a5\u00a6\7N\2\2\u00a6\u00b8\7G\2\2"+
		"\u00a7\u00a8\7e\2\2\u00a8\u00a9\7j\2\2\u00a9\u00aa\7c\2\2\u00aa\u00b8"+
		"\7t\2\2\u00ab\u00ac\7E\2\2\u00ac\u00ad\7J\2\2\u00ad\u00ae\7C\2\2\u00ae"+
		"\u00b8\7T\2\2\u00af\u00b0\7x\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7k\2\2"+
		"\u00b2\u00b8\7f\2\2\u00b3\u00b4\7X\2\2\u00b4\u00b5\7Q\2\2\u00b5\u00b6"+
		"\7K\2\2\u00b6\u00b8\7F\2\2\u00b7\u008b\3\2\2\2\u00b7\u008e\3\2\2\2\u00b7"+
		"\u0091\3\2\2\2\u00b7\u0096\3\2\2\2\u00b7\u009b\3\2\2\2\u00b7\u00a1\3\2"+
		"\2\2\u00b7\u00a7\3\2\2\2\u00b7\u00ab\3\2\2\2\u00b7\u00af\3\2\2\2\u00b7"+
		"\u00b3\3\2\2\2\u00b8,\3\2\2\2\u00b9\u00bc\5\63\32\2\u00ba\u00bc\5\65\33"+
		"\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be.\3\2\2\2\u00bf\u00c1\t\4\2\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\60\3\2\2\2\u00c4\u00c6\t\4\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00cb\7\60\2\2\u00ca\u00cc\t\4\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cd\3"+
		"\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\62\3\2\2\2\u00cf"+
		"\u00d1\t\5\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\64\3\2\2\2\u00d4\u00d5\7a\2\2\u00d5\66"+
		"\3\2\2\2\20\2ntz~\u0080\u0089\u00b7\u00bb\u00bd\u00c2\u00c7\u00cd\u00d2"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}