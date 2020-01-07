import sys
from antlr4 import *
from EnquestesLexer import EnquestesLexer
from EnquestesParser import EnquestesParser
from EnquestesVisitor import EnquestesVisitor
from antlr4.InputStream import InputStream
file = open(sys.argv[1], encoding='utf-8')
questions = InputStream(file.read())
file.close()
lexer = EnquestesLexer(questions)
token_stream = CommonTokenStream(lexer)
parser = EnquestesParser(token_stream)
tree = parser.root()
print(tree.toStringTree(recog=parser))

visitor = EnquestesVisitor()
visitor.visit(tree)
