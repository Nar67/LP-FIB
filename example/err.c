/*
 * A n t l r  S e t s / E r r o r  F i l e  H e a d e r
 *
 * Generated from: example1.g
 *
 * Terence Parr, Russell Quong, Will Cohen, and Hank Dietz: 1989-2001
 * Parr Research Corporation
 * with Purdue University Electrical Engineering
 * With AHPCRC, University of Minnesota
 * ANTLR Version 1.33MR33
 */

#define ANTLR_VERSION	13333
#include "pcctscfg.h"
#include "pccts_stdio.h"

#include <string>
#include <iostream>
#include <map>
using namespace std;

// struct to store information about tokens
typedef struct {
  string kind;
  string text;
} Attrib;



// function to fill token information (predeclaration)
void zzcr_attr(Attrib *attr, int type, char *text);

// fields for AST nodes
#define AST_FIELDS string kind; string text;
#include "ast.h"

// macro to create a new AST node (and function predeclaration)
#define zzcr_ast(as,attr,ttype,textt) as=createASTnode(attr,ttype,textt)
AST* createASTnode(Attrib* attr, int ttype, char *textt);
#define zzSET_SIZE 4
#include "antlr.h"
#include "ast.h"
#include "tokens.h"
#include "dlgdef.h"
#include "err.h"

ANTLRChar *zztokens[13]={
	/* 00 */	"Invalid",
	/* 01 */	"@",
	/* 02 */	"WRITE",
	/* 03 */	"ID",
	/* 04 */	"ASIG",
	/* 05 */	"OPENPAR",
	/* 06 */	"CLOSEPAR",
	/* 07 */	"MUL",
	/* 08 */	"DIV",
	/* 09 */	"NUM",
	/* 10 */	"PLUS",
	/* 11 */	"MINUS",
	/* 12 */	"SPACE"
};
SetWordType zzerr1[4] = {0xc,0x0,0x0,0x0};
SetWordType zzerr2[4] = {0x0,0xc,0x0,0x0};
SetWordType zzerr3[4] = {0x80,0x1,0x0,0x0};
SetWordType zzerr4[4] = {0x28,0x2,0x0,0x0};
SetWordType setwd1[13] = {0x0,0xd6,0xd5,0xd5,0x0,0x0,0xd0,
	0xa0,0xa0,0x0,0xc8,0xc8,0x0};
