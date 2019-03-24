#!/bin/bash
antlr -gt dataPlot.g
dlg -ci parser.dlg scan.c
g++ -o dataPlot dataPlot.c scan.c err.c -w -I /usr/include/pccts -std=c++11 
if [ $? -eq 0 ]; then
    ./dataPlot < ex0.txt 2>&1 | tee out.txt
else
    echo "Compilation failed"
fi
diff -C 123 out.txt AST0.out

rm -f *.o dataPlot.c scan.c err.c parser.dlg tokens.h mode.h dataPlot
