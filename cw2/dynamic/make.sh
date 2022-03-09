
gcc -c -Wall -fPIC -D_GNU_SOURCE arytm.c
gcc arytm.o -shared -o lib_arytmdyn.so
gcc -c calc.c -o calc.o
gcc calc.o -L. -l_arytmdyn -o wynik.out