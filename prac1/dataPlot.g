#header
<<
#include <string>
#include <iostream>
#include <utility>
#include <list>
#include <map>
using namespace std;

// struct to store information about tokens
typedef struct {
  string kind;
  string text;
} Attrib;


extern map<string, list<pair<int,int> > > dpmap;
// function to fill token information (predeclaration)
void zzcr_attr(Attrib *attr, int type, char *text);

// fields for AST nodes
#define AST_FIELDS string kind; string text;
#include "ast.h"

// macro to create a new AST node (and function predeclaration)
#define zzcr_ast(as,attr,ttype,textt) as=createASTnode(attr,ttype,textt)
AST* createASTnode(Attrib* attr, int ttype, char *textt);
>>

<<
#include <cstdlib>
#include <cmath>


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

AST* createASTstring(AST *child, string kind){
	AST* as = new AST;
	as->kind = kind;
	as->right = NULL;
	as->down = child;
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

  if(a->kind != "intconst" && a->kind != "identifier") cout<<a->kind;
  if (a->text!="") cout<<a->text;
  cout<<endl;

  AST *i = a->down;
  while (i!=NULL && i->right!=NULL) {
    cout<<s+"  \\__";
    ASTPrintIndent(i,s+"  |"+string(i->kind.size()+i->text.size(),' '));
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

//int evaluate(AST *a) {
//	if (a == NULL) return 0;
//	else if (a->kind == "intconst")
//		return atoi(a->text.c_str());
//	}
//
//pair<int,int> evaluatePair(AST *a) {
//	if (a == NULL) return 0;
//	else if (a->kind == "pair"){
//		pair<int,int> p(evaluate(child(a,0)), evaluate(child(a,1)));
//		return p;
//	}
//	
//}
//
//list<pair<int,int>> evaluateList(AST *a) {
//	if (a == NULL) return 0;
//	else if (a->kind == "def"){
//		list<pair<int,int>> l(evaluatePair(child(a,0)));
//		return l.splice(l.end(), evaluateList(child(a,1)));
//	}
//	else if (a->kind == "pair"){
//		list<pair<int,int>> l 
//	}
//}
//
//void execute(AST *a) {
//	if (a == NULL)
//		return;
//	else if (a->kind == "=")
//		dps[child(a,0)->text] = evaluateList(child(a,1));
//	else if(a->kind == "write")
//		cout << evaluate(child(a,0)) << endl;
//	execute(a->right);
//}

int main() {
	AST *root = NULL;
	ANTLR(plots(&root), stdin);
	ASTPrint(root);
	//execute(root);
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
def: listp (CONC! listp)* <<#0=createASTstring(_sibling, "def");>>;
listp: listt | ID;
listt: LISTSTART! literal LISTEND!; 

normalize: NORMALIZE^ OPENPAR! def CLOSEPAR!;
plot: PLOT^ OPENPAR! expr CLOSEPAR!;
logplot: LOGPLOT^ OPENPAR! expr CLOSEPAR!;

push: PUSH^ OPENPAR! expr COMMA! point CLOSEPAR!;
pop: POP^ OPENPAR! expr CLOSEPAR!;
amend: AMEND^ OPENPAR! expr CLOSEPAR!;

ghile: WHILE^ OPENPAR! boolexpr CLOSEPAR! linstrucction ENDWHILE!; 
iff: IF^ OPENPAR! boolexpr CLOSEPAR! linstrucction ENDIF!;

boolexpr: andexpr | comparison; 
andexpr: orexpr (AND^ orexpr)*;
orexpr: notexpr (OR^ notexpr)*; 
notexpr: NOT^ boolatom | boolatom;
boolatom: boolquark |(OPENPAR! andexpr CLOSEPAR!);
boolquark: empty | check;

empty: EMPTY^ OPENPAR! expr CLOSEPAR!;
check: CHECK^ OPENPAR! expr CLOSEPAR!;
ith: ITH^ OPENPAR! NUM COMMA! def CLOSEPAR!; 

comparison: point (UNEQUALSIGN^ | EQUALSIGN^ | LESSTHAN^ | MORETHAN^) point;
point: pairint | ith;


literal: pairint (COMMA! pairint)* <<#0=createASTstring(_sibling, "literal");>>;
pairint: LESSTHAN! NUM COMMA! NUM MORETHAN! <<#0=createASTstring(_sibling, "pair");>>;
