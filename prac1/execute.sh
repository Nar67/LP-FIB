antlr -gt dataPlot.g
dlg -ci parser.dlg scan.c
g++ -o dataPlot dataPlot.c scan.c err.c -w -I /usr/include/pccts
if [ $? -eq 0 ]; then
    ./dataPlot < ex0.txt 2>&1 | tee out.txt
    if diff out.txt AST0.out; then
  		echo Same
	else
  		echo Different
	fi
else
    echo "Compilation failed"
fi

rm -f *.o dataPlot.c scan.c err.c parser.dlg tokens.h mode.h dataPlot
