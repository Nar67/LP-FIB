grammar Enquestes;
root: enq+ EOF;
enq:
	pregunta
	| resposta
	| item
	| alternativa
	| enquesta
	| 'END';

pregunta: ID COLON 'PREGUNTA' QUESTION;
resposta: ID COLON 'RESPOSTA' (ANSWER)+;
item: ID COLON 'ITEM' ASSIGNACIO;
alternativa: ID COLON 'ALTERNATIVA' ALTERNATIVE;
enquesta: ID COLON 'ENQUESTA' (ID)+;

QUESTION: CHAR+ '?';
ANSWER: [0-9]+ COLON CHAR+ SEMICOLON;
ASSIGNACIO: ID '->' ID;
ALTERNATIVE: ID '[' ('(' NUM ',' ID ')' (',' | ']'))+;
COLON: ': ';
SEMICOLON: ';';
ID: CHAR+ NUM*;
CHAR: [ 0-9A-Za-z\u0080-\u00FF];
NUM: [0-9]+;
WS: [\t\r\n]+ -> skip;