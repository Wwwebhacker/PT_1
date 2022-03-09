#include <stdio.h>
#include <stdlib.h>
struct Elem
{
	struct Elem* previous;
	int key;
	struct Elem* next;
} *first = NULL, *last = NULL;

struct Elem* insert(int key) {
	struct Elem* p= (struct Elem*)malloc(sizeof(struct Elem));
	if (p==NULL)
	{
		return NULL;
	}
	p->key = key;
	p->next = NULL;
	p->previous = NULL;
	if (!first)
	{
		first = p;
		last = first;
		return p;
	}
	if (last==first)
	{
		last = p;
		first->next = p;
		last->previous = first;		
		return p;
	}

	

	struct Elem*oldlast=last;
	last = p;
	last->previous = oldlast;
	oldlast->next = last;	
	return p;
}
void delfirst() {
	if (first)
	{
		if (first!=last) {
			struct Elem* oldfirst = first;
			if (first->next!=last)
			{
				
				first = first->next;
				
			}
			else
			{
				first = last;
				
				first->next = NULL;
			}
			first->previous = NULL;
			free(oldfirst);
		}
		else
		{
			last = NULL;
			free(first);
			first = NULL;
			
		}

	}
}
void printlist() {
	struct Elem* p = first;
	while (p != NULL)
	{
		printf("%d ", p->key);
		p = p->next;
	}
	printf("\n");
}
void freelist() {
	

	
	while (first != NULL)
	{
		delfirst();
	}
}





int main() {
	
	
	char c = 'c';
	int d;

	while (c != 'x') {
		scanf("%c", &c);
		switch (c) {
		case 'i':
			scanf("%d", &d);
			insert(d);
			break;
		case 'd':
			
			delfirst();
			break;
		case 's':
			printlist();
			break;
		default:
			break;
		}
	}
	freelist();
	return 0;
}