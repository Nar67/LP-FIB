// Generated from /home/nars/FIB/LP-FIB/chatbot/cl/Enquestes.g by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EnquestesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, QUESTION=7, ANSWER=8, 
		ASSIGNACIO=9, ALTERNATIVE=10, COLON=11, SEMICOLON=12, ID=13, CHAR=14, 
		NUM=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "QUESTION", "ANSWER", 
		"ASSIGNACIO", "ALTERNATIVE", "COLON", "SEMICOLON", "ID", "CHAR", "NUM", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'END'", "'PREGUNTA'", "'RESPOSTA'", "'ITEM'", "'ALTERNATIVA'", 
		"'ENQUESTA'", null, null, null, null, "': '", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "QUESTION", "ANSWER", "ASSIGNACIO", 
		"ALTERNATIVE", "COLON", "SEMICOLON", "ID", "CHAR", "NUM", "WS"
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


	public EnquestesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Enquestes.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u0098\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\6\bU\n\b\r\b\16\bV"+
		"\3\b\3\b\3\t\6\t\\\n\t\r\t\16\t]\3\t\3\t\6\tb\n\t\r\t\16\tc\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6"+
		"\13w\n\13\r\13\16\13x\3\f\3\f\3\f\3\r\3\r\3\16\6\16\u0081\n\16\r\16\16"+
		"\16\u0082\3\16\7\16\u0086\n\16\f\16\16\16\u0089\13\16\3\17\3\17\3\20\6"+
		"\20\u008e\n\20\r\20\16\20\u008f\3\21\6\21\u0093\n\21\r\21\16\21\u0094"+
		"\3\21\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22\3\2\6\3\2\62;\4\2..__\7\2\"\"\62;C\\c|\u0082"+
		"\u0101\4\2\13\f\17\17\2\u009f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5\'\3\2\2\2\7\60\3\2\2\2\t9\3\2\2\2"+
		"\13>\3\2\2\2\rJ\3\2\2\2\17T\3\2\2\2\21[\3\2\2\2\23g\3\2\2\2\25m\3\2\2"+
		"\2\27z\3\2\2\2\31}\3\2\2\2\33\u0080\3\2\2\2\35\u008a\3\2\2\2\37\u008d"+
		"\3\2\2\2!\u0092\3\2\2\2#$\7G\2\2$%\7P\2\2%&\7F\2\2&\4\3\2\2\2\'(\7R\2"+
		"\2()\7T\2\2)*\7G\2\2*+\7I\2\2+,\7W\2\2,-\7P\2\2-.\7V\2\2./\7C\2\2/\6\3"+
		"\2\2\2\60\61\7T\2\2\61\62\7G\2\2\62\63\7U\2\2\63\64\7R\2\2\64\65\7Q\2"+
		"\2\65\66\7U\2\2\66\67\7V\2\2\678\7C\2\28\b\3\2\2\29:\7K\2\2:;\7V\2\2;"+
		"<\7G\2\2<=\7O\2\2=\n\3\2\2\2>?\7C\2\2?@\7N\2\2@A\7V\2\2AB\7G\2\2BC\7T"+
		"\2\2CD\7P\2\2DE\7C\2\2EF\7V\2\2FG\7K\2\2GH\7X\2\2HI\7C\2\2I\f\3\2\2\2"+
		"JK\7G\2\2KL\7P\2\2LM\7S\2\2MN\7W\2\2NO\7G\2\2OP\7U\2\2PQ\7V\2\2QR\7C\2"+
		"\2R\16\3\2\2\2SU\5\35\17\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3"+
		"\2\2\2XY\7A\2\2Y\20\3\2\2\2Z\\\t\2\2\2[Z\3\2\2\2\\]\3\2\2\2][\3\2\2\2"+
		"]^\3\2\2\2^_\3\2\2\2_a\5\27\f\2`b\5\35\17\2a`\3\2\2\2bc\3\2\2\2ca\3\2"+
		"\2\2cd\3\2\2\2de\3\2\2\2ef\5\31\r\2f\22\3\2\2\2gh\5\33\16\2hi\7/\2\2i"+
		"j\7@\2\2jk\3\2\2\2kl\5\33\16\2l\24\3\2\2\2mn\5\33\16\2nv\7]\2\2op\7*\2"+
		"\2pq\5\37\20\2qr\7.\2\2rs\5\33\16\2st\7+\2\2tu\t\3\2\2uw\3\2\2\2vo\3\2"+
		"\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\26\3\2\2\2z{\7<\2\2{|\7\"\2\2|\30"+
		"\3\2\2\2}~\7=\2\2~\32\3\2\2\2\177\u0081\5\35\17\2\u0080\177\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0087\3\2"+
		"\2\2\u0084\u0086\5\37\20\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\34\3\2\2\2\u0089\u0087\3\2\2"+
		"\2\u008a\u008b\t\4\2\2\u008b\36\3\2\2\2\u008c\u008e\t\2\2\2\u008d\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		" \3\2\2\2\u0091\u0093\t\5\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2"+
		"\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097"+
		"\b\21\2\2\u0097\"\3\2\2\2\13\2V]cx\u0082\u0087\u008f\u0094\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}