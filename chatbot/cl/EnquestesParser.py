# Generated from Enquestes.g by ANTLR 4.7.2
# encoding: utf-8
from antlr4 import *
from io import StringIO
from typing.io import TextIO
import sys

def serializedATN():
    with StringIO() as buf:
        buf.write("\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22")
        buf.write("?\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b")
        buf.write("\t\b\3\2\6\2\22\n\2\r\2\16\2\23\3\2\3\2\3\3\3\3\3\3\3")
        buf.write("\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5")
        buf.write("\3\5\6\5)\n\5\r\5\16\5*\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3")
        buf.write("\7\3\7\3\7\3\b\3\b\3\b\3\b\6\b;\n\b\r\b\16\b<\3\b\2\2")
        buf.write("\t\2\4\6\b\n\f\16\2\2\2?\2\21\3\2\2\2\4\35\3\2\2\2\6\37")
        buf.write("\3\2\2\2\b$\3\2\2\2\n,\3\2\2\2\f\61\3\2\2\2\16\66\3\2")
        buf.write("\2\2\20\22\5\4\3\2\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3")
        buf.write("\2\2\2\23\24\3\2\2\2\24\25\3\2\2\2\25\26\7\2\2\3\26\3")
        buf.write("\3\2\2\2\27\36\5\6\4\2\30\36\5\b\5\2\31\36\5\n\6\2\32")
        buf.write("\36\5\f\7\2\33\36\5\16\b\2\34\36\7\3\2\2\35\27\3\2\2\2")
        buf.write("\35\30\3\2\2\2\35\31\3\2\2\2\35\32\3\2\2\2\35\33\3\2\2")
        buf.write("\2\35\34\3\2\2\2\36\5\3\2\2\2\37 \7\17\2\2 !\7\r\2\2!")
        buf.write("\"\7\4\2\2\"#\7\t\2\2#\7\3\2\2\2$%\7\17\2\2%&\7\r\2\2")
        buf.write("&(\7\5\2\2\')\7\n\2\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*")
        buf.write("+\3\2\2\2+\t\3\2\2\2,-\7\17\2\2-.\7\r\2\2./\7\6\2\2/\60")
        buf.write("\7\13\2\2\60\13\3\2\2\2\61\62\7\17\2\2\62\63\7\r\2\2\63")
        buf.write("\64\7\7\2\2\64\65\7\f\2\2\65\r\3\2\2\2\66\67\7\17\2\2")
        buf.write("\678\7\r\2\28:\7\b\2\29;\7\17\2\2:9\3\2\2\2;<\3\2\2\2")
        buf.write("<:\3\2\2\2<=\3\2\2\2=\17\3\2\2\2\6\23\35*<")
        return buf.getvalue()


class EnquestesParser ( Parser ):

    grammarFileName = "Enquestes.g"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'END'", "'PREGUNTA'", "'RESPOSTA'", "'ITEM'", 
                     "'ALTERNATIVA'", "'ENQUESTA'", "<INVALID>", "<INVALID>", 
                     "<INVALID>", "<INVALID>", "': '", "';'" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "<INVALID>", "<INVALID>", "QUESTION", 
                      "ANSWER", "ASSIGNACIO", "ALTERNATIVE", "COLON", "SEMICOLON", 
                      "ID", "CHAR", "NUM", "WS" ]

    RULE_root = 0
    RULE_enq = 1
    RULE_pregunta = 2
    RULE_resposta = 3
    RULE_item = 4
    RULE_alternativa = 5
    RULE_enquesta = 6

    ruleNames =  [ "root", "enq", "pregunta", "resposta", "item", "alternativa", 
                   "enquesta" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    T__3=4
    T__4=5
    T__5=6
    QUESTION=7
    ANSWER=8
    ASSIGNACIO=9
    ALTERNATIVE=10
    COLON=11
    SEMICOLON=12
    ID=13
    CHAR=14
    NUM=15
    WS=16

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.7.2")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None



    class RootContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def EOF(self):
            return self.getToken(EnquestesParser.EOF, 0)

        def enq(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(EnquestesParser.EnqContext)
            else:
                return self.getTypedRuleContext(EnquestesParser.EnqContext,i)


        def getRuleIndex(self):
            return EnquestesParser.RULE_root

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitRoot" ):
                return visitor.visitRoot(self)
            else:
                return visitor.visitChildren(self)




    def root(self):

        localctx = EnquestesParser.RootContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_root)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 15 
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while True:
                self.state = 14
                self.enq()
                self.state = 17 
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if not (_la==EnquestesParser.T__0 or _la==EnquestesParser.ID):
                    break

            self.state = 19
            self.match(EnquestesParser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class EnqContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def pregunta(self):
            return self.getTypedRuleContext(EnquestesParser.PreguntaContext,0)


        def resposta(self):
            return self.getTypedRuleContext(EnquestesParser.RespostaContext,0)


        def item(self):
            return self.getTypedRuleContext(EnquestesParser.ItemContext,0)


        def alternativa(self):
            return self.getTypedRuleContext(EnquestesParser.AlternativaContext,0)


        def enquesta(self):
            return self.getTypedRuleContext(EnquestesParser.EnquestaContext,0)


        def getRuleIndex(self):
            return EnquestesParser.RULE_enq

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitEnq" ):
                return visitor.visitEnq(self)
            else:
                return visitor.visitChildren(self)




    def enq(self):

        localctx = EnquestesParser.EnqContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_enq)
        try:
            self.state = 27
            self._errHandler.sync(self)
            la_ = self._interp.adaptivePredict(self._input,1,self._ctx)
            if la_ == 1:
                self.enterOuterAlt(localctx, 1)
                self.state = 21
                self.pregunta()
                pass

            elif la_ == 2:
                self.enterOuterAlt(localctx, 2)
                self.state = 22
                self.resposta()
                pass

            elif la_ == 3:
                self.enterOuterAlt(localctx, 3)
                self.state = 23
                self.item()
                pass

            elif la_ == 4:
                self.enterOuterAlt(localctx, 4)
                self.state = 24
                self.alternativa()
                pass

            elif la_ == 5:
                self.enterOuterAlt(localctx, 5)
                self.state = 25
                self.enquesta()
                pass

            elif la_ == 6:
                self.enterOuterAlt(localctx, 6)
                self.state = 26
                self.match(EnquestesParser.T__0)
                pass


        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class PreguntaContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def ID(self):
            return self.getToken(EnquestesParser.ID, 0)

        def COLON(self):
            return self.getToken(EnquestesParser.COLON, 0)

        def QUESTION(self):
            return self.getToken(EnquestesParser.QUESTION, 0)

        def getRuleIndex(self):
            return EnquestesParser.RULE_pregunta

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitPregunta" ):
                return visitor.visitPregunta(self)
            else:
                return visitor.visitChildren(self)




    def pregunta(self):

        localctx = EnquestesParser.PreguntaContext(self, self._ctx, self.state)
        self.enterRule(localctx, 4, self.RULE_pregunta)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 29
            self.match(EnquestesParser.ID)
            self.state = 30
            self.match(EnquestesParser.COLON)
            self.state = 31
            self.match(EnquestesParser.T__1)
            self.state = 32
            self.match(EnquestesParser.QUESTION)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class RespostaContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def ID(self):
            return self.getToken(EnquestesParser.ID, 0)

        def COLON(self):
            return self.getToken(EnquestesParser.COLON, 0)

        def ANSWER(self, i:int=None):
            if i is None:
                return self.getTokens(EnquestesParser.ANSWER)
            else:
                return self.getToken(EnquestesParser.ANSWER, i)

        def getRuleIndex(self):
            return EnquestesParser.RULE_resposta

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitResposta" ):
                return visitor.visitResposta(self)
            else:
                return visitor.visitChildren(self)




    def resposta(self):

        localctx = EnquestesParser.RespostaContext(self, self._ctx, self.state)
        self.enterRule(localctx, 6, self.RULE_resposta)
        self._la = 0 # Token type
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 34
            self.match(EnquestesParser.ID)
            self.state = 35
            self.match(EnquestesParser.COLON)
            self.state = 36
            self.match(EnquestesParser.T__2)
            self.state = 38 
            self._errHandler.sync(self)
            _la = self._input.LA(1)
            while True:
                self.state = 37
                self.match(EnquestesParser.ANSWER)
                self.state = 40 
                self._errHandler.sync(self)
                _la = self._input.LA(1)
                if not (_la==EnquestesParser.ANSWER):
                    break

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class ItemContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def ID(self):
            return self.getToken(EnquestesParser.ID, 0)

        def COLON(self):
            return self.getToken(EnquestesParser.COLON, 0)

        def ASSIGNACIO(self):
            return self.getToken(EnquestesParser.ASSIGNACIO, 0)

        def getRuleIndex(self):
            return EnquestesParser.RULE_item

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitItem" ):
                return visitor.visitItem(self)
            else:
                return visitor.visitChildren(self)




    def item(self):

        localctx = EnquestesParser.ItemContext(self, self._ctx, self.state)
        self.enterRule(localctx, 8, self.RULE_item)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 42
            self.match(EnquestesParser.ID)
            self.state = 43
            self.match(EnquestesParser.COLON)
            self.state = 44
            self.match(EnquestesParser.T__3)
            self.state = 45
            self.match(EnquestesParser.ASSIGNACIO)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class AlternativaContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def ID(self):
            return self.getToken(EnquestesParser.ID, 0)

        def COLON(self):
            return self.getToken(EnquestesParser.COLON, 0)

        def ALTERNATIVE(self):
            return self.getToken(EnquestesParser.ALTERNATIVE, 0)

        def getRuleIndex(self):
            return EnquestesParser.RULE_alternativa

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitAlternativa" ):
                return visitor.visitAlternativa(self)
            else:
                return visitor.visitChildren(self)




    def alternativa(self):

        localctx = EnquestesParser.AlternativaContext(self, self._ctx, self.state)
        self.enterRule(localctx, 10, self.RULE_alternativa)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 47
            self.match(EnquestesParser.ID)
            self.state = 48
            self.match(EnquestesParser.COLON)
            self.state = 49
            self.match(EnquestesParser.T__4)
            self.state = 50
            self.match(EnquestesParser.ALTERNATIVE)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx

    class EnquestaContext(ParserRuleContext):

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def ID(self, i:int=None):
            if i is None:
                return self.getTokens(EnquestesParser.ID)
            else:
                return self.getToken(EnquestesParser.ID, i)

        def COLON(self):
            return self.getToken(EnquestesParser.COLON, 0)

        def getRuleIndex(self):
            return EnquestesParser.RULE_enquesta

        def accept(self, visitor:ParseTreeVisitor):
            if hasattr( visitor, "visitEnquesta" ):
                return visitor.visitEnquesta(self)
            else:
                return visitor.visitChildren(self)




    def enquesta(self):

        localctx = EnquestesParser.EnquestaContext(self, self._ctx, self.state)
        self.enterRule(localctx, 12, self.RULE_enquesta)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 52
            self.match(EnquestesParser.ID)
            self.state = 53
            self.match(EnquestesParser.COLON)
            self.state = 54
            self.match(EnquestesParser.T__5)
            self.state = 56 
            self._errHandler.sync(self)
            _alt = 1
            while _alt!=2 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt == 1:
                    self.state = 55
                    self.match(EnquestesParser.ID)

                else:
                    raise NoViableAltException(self)
                self.state = 58 
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,3,self._ctx)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





