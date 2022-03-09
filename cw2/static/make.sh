
gcc -c arytm.c -o arytm.o
ar r lib_arytm.a arytm.o

gcc -c calc.c -o calc.o

gcc calc.o lib_arytm.a -o wynik.out