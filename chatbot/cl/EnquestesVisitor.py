# Generated from Enquestes.g by ANTLR 4.7.2
import networkx as nx
import matplotlib.pyplot as plt
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .EnquestesParser import EnquestesParser
else:
    from EnquestesParser import EnquestesParser
# This class defines a complete generic visitor for a parse tree produced by EnquestesParser.


class EnquestesVisitor(ParseTreeVisitor):

    # Graph from the AST, starts empty and it gets filled as we visit the AST
    def __init__(self):
        self.g = nx.DiGraph()
        super().__init__()

    # Visit a parse tree produced by EnquestesParser#root.
    def visitRoot(self, ctx: EnquestesParser.RootContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by EnquestesParser#enq.
    def visitEnq(self, ctx: EnquestesParser.EnqContext):
        c = next(ctx.getChildren())
        if c.getText() == "END":
            nx.write_gpickle(self.g, "test.gpickle")
            self.draw_graph()
        return self.visitChildren(ctx)

    # Visit a parse tree produced by EnquestesParser#pregunta.
    def visitPregunta(self, ctx: EnquestesParser.PreguntaContext):
        c = ctx.getChildren()
        l = [next(c).getText() for i in range(ctx.getChildCount())]
        self.g.add_node((l[0], l[2], l[3]))
        return self.visitChildren(ctx)

    # Visit a parse tree produced by EnquestesParser#resposta.
    def visitResposta(self, ctx: EnquestesParser.RespostaContext):
        c = ctx.getChildren()
        l = [next(c).getText() for i in range(ctx.getChildCount())]
        self.g.add_node((l[0], l[2], tuple(l[3:])))
        return self.visitChildren(ctx)

    # Visit a parse tree produced by EnquestesParser#item.
    def visitItem(self, ctx: EnquestesParser.ItemContext):
        c = ctx.getChildren()
        l = [next(c).getText() for i in range(ctx.getChildCount())]
        id1, id2 = self.getItemIDs(l[3])
        self.g.add_edge(self.get_node_by_ID(
            id1), self.get_node_by_ID(id2), label=l[0])
        return self.visitChildren(ctx)

    # Visit a parse tree produced by EnquestesParser#alternativa.
    def visitAlternativa(self, ctx: EnquestesParser.AlternativaContext):
        c = ctx.getChildren()
        l = [next(c).getText() for i in range(ctx.getChildCount())]
        itemID, alts = self.get_altervatives(l[3])
        self.add_edges_from_alternatives(itemID, alts)
        return self.visitChildren(ctx)

    # Visit a parse tree produced by EnquestesParser#enquesta.
    def visitEnquesta(self, ctx: EnquestesParser.EnquestaContext):
        c = ctx.getChildren()
        l = [next(c).getText() for i in range(ctx.getChildCount())]
        self.g.add_node((l[0], l[2], l[3]))
        self.add_question_order(l[0], l[3])
        return self.visitChildren(ctx)

    # Gets the two IDs from an ITEM token as strings
    def getItemIDs(self, ids):
        id1, _, id2 = ids.partition('->')
        return id1.strip(), id2.strip()

    # Gets the node by id
    def get_node_by_ID(self, id):
        for i in self.g.nodes():
            for j in i:
                if j == id:
                    return i

    # Gets the edge by id
    def get_edge_by_ID(self, id):
        for i in self.g.edges.data():
            if i[2] != {} and str(i[2]['label']) == id:
                return i

    # Gets all the alternatives with the ids of the Items they refer
    def get_altervatives(self, alts):
        itemID, _, l = alts.partition(' ')
        alternatives = l[1:-1]  # remove [ ]
        list_of_alts = []
        for s in alternatives.split(','):
            list_of_alts.append(
                ''.join([c for c in s if c not in [')', '(']]))
        answer_item_list = []
        i = 0
        while i < len(list_of_alts):
            answer_item_list.append((list_of_alts[i], list_of_alts[i+1]))
            i = i+2
        return itemID, answer_item_list

    # Creates all edges from an alternatives list
    def add_edges_from_alternatives(self, itemID, alts):
        item_edge = self.get_edge_by_ID(itemID)
        item_node = self.get_node_by_ID(item_edge[0][0])
        for (question, id) in alts:
            alt_edge = self.get_edge_by_ID(id)
            alt_node = self.get_node_by_ID(alt_edge[0][0])
            self.g.add_edge(item_node, alt_node, label=str(question))

    # Creates edges with the order from 'Enquesta'
    def add_question_order(self, enquestaID, ord):
        start_node = self.get_node_by_ID(enquestaID)
        items = ord.split(' ')
        for i in items:
            item_edge = self.get_edge_by_ID(i)
            item_node = self.get_node_by_ID(item_edge[0][0])
            self.g.add_edge(start_node, item_node)
            start_node = item_node
        self.g.add_node(("END", ))
        end_node = self.get_node_by_ID("END")
        self.g.add_edge(item_node, end_node)

    # Draws the graph
    def draw_graph(self):
        node_labels = {}
        for n in self.g.nodes:
            if n != None:
                node_labels[n] = n[0]
        nx.draw_circular(self.g, labels=node_labels, with_labels=True)
        item_edge_labels = {}
        alt_edge_labels = {}
        for (e, d) in zip(self.g.edges(), self.g.edges.data()):
            if(d[2] != {} and str(d[2]['label']).isdecimal()):
                alt_edge_labels[e] = str(d[2]['label'])
            elif d[2] != {}:
                item_edge_labels[e] = str(d[2]['label'])
        # color the edges
        nx.draw_networkx_edges(
            self.g, pos=nx.circular_layout(self.g), edgelist=self.g.edges(), edge_color="black")
        nx.draw_networkx_edges(
            self.g, pos=nx.circular_layout(self.g), edgelist=list(alt_edge_labels.keys()), edge_color="green")
        nx.draw_networkx_edges(
            self.g, pos=nx.circular_layout(self.g), edgelist=list(item_edge_labels.keys()), edge_color="blue")
        # color the edge labels
        nx.draw_networkx_edge_labels(
            self.g, pos=nx.circular_layout(self.g), edge_labels=alt_edge_labels, font_color="green")
        nx.draw_networkx_edge_labels(
            self.g, pos=nx.circular_layout(self.g), edge_labels=item_edge_labels, font_color="blue")
        plt.show()


del EnquestesParser
