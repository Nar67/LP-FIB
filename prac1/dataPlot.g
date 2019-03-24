#header
<<
#include <string>
#include <iostream>
#include <utility>
#include <list>
#include <map>
#include <set>
#include <climits>
using namespace std;

// struct to store information about tokens
typedef struct {
  string kind;
  string text;
} Attrib;


void printList(list<pair<int,int> > list);
list<pair<int,int> > normalizee(list<pair<int,int> > l);



extern map<string, list<pair<int,int> > > dpmap;
// function to fill token information (predeclaration)
void zzcr_attr(Attrib *attr, int type, char *text);

// fields for AST nodes
#define AST_FIELDS string kind; string text;
#include "ast.h"


bool evalBooleanExpr(AST *a);

bool checkList(list<pair<int,int> > l);

list<pair<int,int> > amend(list<pair<int,int> > l);

// macro to create a new AST node (and function predeclaration)
#define zzcr_ast(as,attr,ttype,textt) as=createASTnode(attr,ttype,textt)
AST* createASTnode(Attrib* attr, int ttype, char *textt);
>>

<<
#include <cstdlib>
#include <cmath>


map<string, list<pair<int,int> > > dpmap;

// function to fill token information
void zzcr_attr(Attrib *attr, int type, char *text) {
	if (type == NUM) {
		attr->kind = "intconst";
		attr->text = text;
	}
	else if(type == ID) {
		attr->kind = "identifier";
		attr->text = text;
	}
	else {
		attr->kind = text;
		attr->text = "";
	}
}



// function to create a new AST node
AST* createASTnode(Attrib* attr, int type, char* text) {
  AST* as = new AST;
  as->kind = attr->kind;
  as->text = attr->text;
  as->right = NULL; 
  as->down = NULL;
  return as;
}

/// get nth child of a tree. Count starts at 0.
/// if no such child, returns NULL
AST* child(AST *a,int n) {
 AST *c=a->down;
 for (int i=0; c!=NULL && i<n; i++) c=c->right;
 return c;
} 

/// print AST, recursively, with indentation
void ASTPrintIndent(AST *a,string s)
{
  if (a==NULL) return;

  if(a->kind != "intconst" && a->kind != "identifier" && a->kind != "·") cout<<a->kind;
  if (a->text!="") cout<<a->text;
  cout<<endl;

  AST *i = a->down;
  while (i!=NULL && i->right!=NULL) {
    if(i->kind != "·"){
    	cout<<s+"  \\__";
    	ASTPrintIndent(i,s+"  |"+string(i->kind.size()+i->text.size(),' '));
    }
    i=i->right;
  }
  
  if (i!=NULL) {
      cout<<s+"  \\__";
      ASTPrintIndent(i,s+"   "+string(i->kind.size()+i->text.size(),' '));
      i=i->right;
  }
}

/// print AST 
void ASTPrint(AST *a)
{
  while (a!=NULL) {
    cout<<" ";
    ASTPrintIndent(a,"");
    a=a->right;
  }
}

AST* createASTstring(AST *child, string kind){
	AST* as = new AST;
	as->kind = kind;
	//as->right = ((kind == "def") ? concat : NULL;
	as->right = NULL;
	as->down = child;
}

int evaluate(AST *a) {
	if (a == NULL) return 0;
	else if (a->kind == "intconst")
		return atoi(a->text.c_str());
	}

pair<int,int> evaluatePair(AST *a) {
	if (a->kind == "pair"){
		return make_pair(evaluate(child(a,0)), evaluate(child(a,1)));
	}
}

list<pair<int,int> > evaluateList(AST *a) {
	if (a->kind == "literal" || a->kind == "·" ){
		list<pair<int,int> > l;
		int i = 0;
		while(child(a, i)!=NULL){
			l.push_back(evaluatePair(child(a, i++)));
		}
		return l;
	}
	else if (a->kind == "identifier"){
		return dpmap[a->text];
	}
}

list<pair<int,int> > evaluateExpr(AST *a) {
	if (a->kind == "def"){
		int i = 0;
		list<pair<int,int> > lst; //= evaluateList(child(a,i++));
		while(child(a,i)!=NULL){
			list<pair<int,int> > l = evaluateList(child(a,i++));
			lst.insert(lst.end(), l.begin(), l.end());
		}
		return lst;
	}
	else if (a->kind == "NORMALIZE"){
		return normalizee(evaluateExpr(child(a,0)));
	}
	else if (a->kind == "POP"){
		list<pair<int,int> > l = evaluateExpr(child(a,0));
		l.pop_back();
		return l;
	}
	else if (a->kind == "PUSH"){
		list<pair<int,int> > l = evaluateExpr(child(a,0));
		l.push_back(evaluatePair(child(a,1)));
		return l;
	}
	else if (a->kind == "AMEND"){
		list<pair<int,int> > l = amend(evaluateExpr(child(a,0)));
		return l;
	}
}

list<pair<int,int> > amend(list<pair<int,int> > l){
	set<int> xrep, yrep;
	list<pair<int,int> > lst = l;
	//list<pair<int,int> >::iterator it = lst.begin();
	list<pair<int,int> >::iterator it = lst.begin();
	while(it != lst.end()){
		pair<int,int> p = *it;
		if(xrep.end() == xrep.find(p.first) && yrep.end() == yrep.find(p.second)) {
			xrep.insert(p.first);
			yrep.insert(p.second);
		}
		else {
			it = lst.erase(it);
		}
		++it;
	}
	//for(list<pair<int,int> >::iterator it = lst.begin(); it != lst.end(); ++it){
	//}
	return lst;
}

void plot(AST* a){
	cout << child(a,0)->text;
	cout << "[";
	printList(evaluateExpr(a));
	cout << "]" << endl; 
 }

void execute(AST *a) {
	if (a == NULL){
		return;
	}
	else if(a->kind == "identifier"){
		execute(child(a, 0));
	}
	else if(a->kind == "list"){
		execute(child(a, 0));
	}
	else if (a->kind == "="){
		dpmap[child(a,0)->text] = evaluateExpr(child(a,1));
		//printList(dpmap[child(a,0)->text]);
	}
	else if (a->kind == "PLOT" || a->kind == "LOGPLOT" ){
		cout << a->kind << " ";
		plot(child(a,0));
	}
	else if(a->kind == "WHILE"){
		while(evalBooleanExpr(child(a,0))){
			execute(child(a,1));
		}
	}
	else if(a->kind == "IF"){
		if(evalBooleanExpr(child(a,0))){
			execute(child(a,1));
		}
	}
	execute(a->right);
}

bool evalBooleanExpr(AST *a){
	if(a == NULL) return false;
	else if(a->kind == "NOT"){
		return not evalBooleanExpr(child(a,0));
	}
	else if(a->kind == "AND"){
		//cout << "a0: " << child(a,0)->kind << " a1: " << child(a,1)->kind << endl;
		return evalBooleanExpr(child(a,0)) && evalBooleanExpr(child(a,1));
	}
	else if(a->kind == "OR"){
		return evalBooleanExpr(child(a,0)) || evalBooleanExpr(child(a,1));
	}
	else if(a->kind == ">"){
		return evaluatePair(child(a,0)) > evaluatePair(child(a,1));
	}
	else if(a->kind == "<"){
		return evaluatePair(child(a,0)) < evaluatePair(child(a,1));
	}
	else if(a->kind == "!="){
		return evaluatePair(child(a,0)) != evaluatePair(child(a,1));
	}
	else if(a->kind == "=="){
		return evaluatePair(child(a,0)) == evaluatePair(child(a,1));
	}
	else if(a->kind == "EMPTY"){
		return evaluateExpr(child(a,0)).empty();
	}
	else if(a->kind == "CHECK"){
		return checkList(evaluateExpr(child(a,0)));
	}
}


bool checkList(list<pair<int,int> > l){
	set<int> xrep, yrep;
	for(auto const& p : l){
		if(xrep.end() == xrep.find(p.first)) xrep.insert(p.first);
		else return false;
		if(yrep.end() == yrep.find(p.second)) yrep.insert(p.second);
		else return false;
	}
	return true;
}



void printList(list<pair<int,int> > list){
	bool f = true;
	for(auto it : list){
		if(not f) cout << ",";
		f = false;
		cout << "<" << it.first << "," << it.second << ">";
	}
}

list<pair<int,int> > normalizee(list<pair<int,int> > l){
	int xmin, ymin = 10;
	for(auto p : l){
		xmin = min(p.first, xmin);
		ymin = min(p.second, ymin);
	}
	list<pair<int,int> > lst;
	for(list<pair<int,int> >::iterator it = l.begin(); it != l.end(); ++it)
		lst.push_back(make_pair(it->first-xmin, it->second-ymin));
	return lst;
}

int main() {
	AST *root = NULL;
	ANTLR(plots(&root), stdin);
	ASTPrint(root);
	execute(child(root,0));
}
>>

#lexclass START

#token PLOT "PLOT"
#token PLOT "LOGPLOT"
#token NORMALIZE "NORMALIZE"

#token WHILE "WHILE"
#token ENDWHILE "ENDWHILE"

#token IF "IF"
#token ENDIF "ENDIF"

#token EMPTY "EMPTY"
#token CHECK "CHECK"
#token PUSH "PUSH"
#token POP "POP"
#token AMEND "AMEND"
#token ITH "ITH"

#token NOT "NOT"
#token AND "AND"
#token OR "OR"

#token ID "[a-zA-Z][a-zA-Z0-9]+"
#token ASIG "="

#token OPENPAR "\("
#token CLOSEPAR "\)"
#token LISTSTART "\["
#token LISTEND "\]"

#token LESSTHAN "\<"
#token MORETHAN "\>"
#token UNEQUALSIGN "!="
#token EQUALSIGN "=="

#token COMMA "\,"
#token CONC "\·"

#token NUM "[0-9]+"
#token SPACE "[\ \n]" << zzskip();>>
#token TAB "\t" << zzskip();>>
#token NEWLINE "\n" << zzskip();>>

plots: linstrucction "@"! <<#0=createASTstring(_sibling,"DataPlotsProgram");>>;
linstrucction: (instrucction)* <<#0=createASTstring(_sibling, "list");>>;
instrucction: ID ASIG^ expr | plot | logplot | ghile | iff; 


expr: (def | normalize | pop | push | amend);
def: listp (CONC listp)* <<#0=createASTstring(_sibling, "def");>>;
listp: listt | ID;
listt: LISTSTART! literal LISTEND!; 

normalize: NORMALIZE^ OPENPAR! expr CLOSEPAR!;
plot: PLOT^ OPENPAR! expr CLOSEPAR!;
logplot: LOGPLOT^ OPENPAR! expr CLOSEPAR!;

push: PUSH^ OPENPAR! expr COMMA! point CLOSEPAR!;
pop: POP^ OPENPAR! expr CLOSEPAR!;
amend: AMEND^ OPENPAR! expr CLOSEPAR!;

ghile: WHILE^ OPENPAR! boolexpr CLOSEPAR! linstrucction ENDWHILE!; 
iff: IF^ OPENPAR! boolexpr CLOSEPAR! linstrucction ENDIF!;

boolexpr: andexpr; 
andexpr: orexpr (AND^ orexpr)*;
orexpr: notexpr (OR^ notexpr)*; 
notexpr: NOT^ boolatom | boolatom;
boolatom: boolquark |(OPENPAR! andexpr CLOSEPAR!);
boolquark: empty | check | comparison;

empty: EMPTY^ OPENPAR! expr CLOSEPAR!;
check: CHECK^ OPENPAR! expr CLOSEPAR!;
ith: ITH^ OPENPAR! NUM COMMA! def CLOSEPAR!; 

comparison: point (UNEQUALSIGN^ | EQUALSIGN^ | LESSTHAN^ | MORETHAN^) point;
point: pairint | ith;


literal: pairint (COMMA! pairint)* <<#0=createASTstring(_sibling, "literal");>>;
pairint: LESSTHAN! NUM COMMA! NUM MORETHAN! <<#0=createASTstring(_sibling, "pair");>>;
