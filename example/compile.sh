antlr -gt example1.g
dlg -ci parser.dlg scan.c
g++ -o example1 example1.c scan.c err.c -w -I /usr/include/pccts
