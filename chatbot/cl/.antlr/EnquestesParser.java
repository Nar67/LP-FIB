// Generated from /home/nars/FIB/LP-FIB/chatbot/cl/Enquestes.g by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EnquestesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, QUESTION=7, ANSWER=8, 
		ASSIGNACIO=9, ALTERNATIVE=10, COLON=11, SEMICOLON=12, ID=13, CHAR=14, 
		NUM=15, WS=16;
	public static final int
		RULE_root = 0, RULE_enq = 1, RULE_pregunta = 2, RULE_resposta = 3, RULE_item = 4, 
		RULE_alternativa = 5, RULE_enquesta = 6;
	public static final String[] ruleNames = {
		"root", "enq", "pregunta", "resposta", "item", "alternativa", "enquesta"
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

	@Override
	public String getGrammarFileName() { return "Enquestes.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EnquestesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(EnquestesParser.EOF, 0); }
		public List<EnqContext> enq() {
			return getRuleContexts(EnqContext.class);
		}
		public EnqContext enq(int i) {
			return getRuleContext(EnqContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				enq();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==ID );
			setState(19);
			match(EOF);
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

	public static class EnqContext extends ParserRuleContext {
		public PreguntaContext pregunta() {
			return getRuleContext(PreguntaContext.class,0);
		}
		public RespostaContext resposta() {
			return getRuleContext(RespostaContext.class,0);
		}
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public AlternativaContext alternativa() {
			return getRuleContext(AlternativaContext.class,0);
		}
		public EnquestaContext enquesta() {
			return getRuleContext(EnquestaContext.class,0);
		}
		public EnqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enq; }
	}

	public final EnqContext enq() throws RecognitionException {
		EnqContext _localctx = new EnqContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_enq);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				pregunta();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				resposta();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(23);
				item();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(24);
				alternativa();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(25);
				enquesta();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(26);
				match(T__0);
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

	public static class PreguntaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EnquestesParser.ID, 0); }
		public TerminalNode COLON() { return getToken(EnquestesParser.COLON, 0); }
		public TerminalNode QUESTION() { return getToken(EnquestesParser.QUESTION, 0); }
		public PreguntaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pregunta; }
	}

	public final PreguntaContext pregunta() throws RecognitionException {
		PreguntaContext _localctx = new PreguntaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pregunta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(ID);
			setState(30);
			match(COLON);
			setState(31);
			match(T__1);
			setState(32);
			match(QUESTION);
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

	public static class RespostaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EnquestesParser.ID, 0); }
		public TerminalNode COLON() { return getToken(EnquestesParser.COLON, 0); }
		public List<TerminalNode> ANSWER() { return getTokens(EnquestesParser.ANSWER); }
		public TerminalNode ANSWER(int i) {
			return getToken(EnquestesParser.ANSWER, i);
		}
		public RespostaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resposta; }
	}

	public final RespostaContext resposta() throws RecognitionException {
		RespostaContext _localctx = new RespostaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_resposta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(ID);
			setState(35);
			match(COLON);
			setState(36);
			match(T__2);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				match(ANSWER);
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ANSWER );
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

	public static class ItemContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EnquestesParser.ID, 0); }
		public TerminalNode COLON() { return getToken(EnquestesParser.COLON, 0); }
		public TerminalNode ASSIGNACIO() { return getToken(EnquestesParser.ASSIGNACIO, 0); }
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(ID);
			setState(43);
			match(COLON);
			setState(44);
			match(T__3);
			setState(45);
			match(ASSIGNACIO);
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

	public static class AlternativaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EnquestesParser.ID, 0); }
		public TerminalNode COLON() { return getToken(EnquestesParser.COLON, 0); }
		public TerminalNode ALTERNATIVE() { return getToken(EnquestesParser.ALTERNATIVE, 0); }
		public AlternativaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativa; }
	}

	public final AlternativaContext alternativa() throws RecognitionException {
		AlternativaContext _localctx = new AlternativaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_alternativa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(ID);
			setState(48);
			match(COLON);
			setState(49);
			match(T__4);
			setState(50);
			match(ALTERNATIVE);
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

	public static class EnquestaContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(EnquestesParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EnquestesParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(EnquestesParser.COLON, 0); }
		public EnquestaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enquesta; }
	}

	public final EnquestaContext enquesta() throws RecognitionException {
		EnquestaContext _localctx = new EnquestaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_enquesta);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(ID);
			setState(53);
			match(COLON);
			setState(54);
			match(T__5);
			setState(56); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(55);
					match(ID);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(58); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22?\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\6\5)\n\5\r\5\16\5*\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\6\b;\n\b\r\b\16\b<\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2?\2"+
		"\21\3\2\2\2\4\35\3\2\2\2\6\37\3\2\2\2\b$\3\2\2\2\n,\3\2\2\2\f\61\3\2\2"+
		"\2\16\66\3\2\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2"+
		"\2\23\24\3\2\2\2\24\25\3\2\2\2\25\26\7\2\2\3\26\3\3\2\2\2\27\36\5\6\4"+
		"\2\30\36\5\b\5\2\31\36\5\n\6\2\32\36\5\f\7\2\33\36\5\16\b\2\34\36\7\3"+
		"\2\2\35\27\3\2\2\2\35\30\3\2\2\2\35\31\3\2\2\2\35\32\3\2\2\2\35\33\3\2"+
		"\2\2\35\34\3\2\2\2\36\5\3\2\2\2\37 \7\17\2\2 !\7\r\2\2!\"\7\4\2\2\"#\7"+
		"\t\2\2#\7\3\2\2\2$%\7\17\2\2%&\7\r\2\2&(\7\5\2\2\')\7\n\2\2(\'\3\2\2\2"+
		")*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\t\3\2\2\2,-\7\17\2\2-.\7\r\2\2./\7\6\2"+
		"\2/\60\7\13\2\2\60\13\3\2\2\2\61\62\7\17\2\2\62\63\7\r\2\2\63\64\7\7\2"+
		"\2\64\65\7\f\2\2\65\r\3\2\2\2\66\67\7\17\2\2\678\7\r\2\28:\7\b\2\29;\7"+
		"\17\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\17\3\2\2\2\6\23\35*<";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}