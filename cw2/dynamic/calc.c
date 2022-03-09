# include <stdio.h>

int main ()
{
    char c = 'c';
	int a;
    int b;
   
	while (c != 'x') {
		scanf("%d%c%d", &a,&c,&b);
		switch (c) {
		case '+':
			
			printf("=%d\n",add(a,b));
			break;
		case '-':
			
            printf("=%d\n",sub(a,b));
			break;
        case '*':
			printf("=%d\n",multiply(a,b));
			break;
		default:
			break;
		}
	}
    return 0;
}