
#include <stdio.h>
#include <stdlib.h>
/// Tree
struct Node
{
	struct Node* left;
	int key;
	struct Node* right;
} *root = NULL;


struct Node* insert(struct Node** root, int key) {
	struct Node* tmp = NULL;

	if (!(*root))
	{
		tmp = (struct Node*)malloc(sizeof(struct Node));
		tmp->left = NULL;
		tmp->right = NULL;
		tmp->key = key;
		*root = tmp;
		return tmp;
	}
	if (key < (*root)->key)
	{
		return insert(&(*root)->left, key);
	}
	else {
		return insert(&(*root)->right, key);
	}
}
void print_inorder(struct Node* root) {
	if (root) {
		print_inorder(root->left);
		printf("%d\n", root->key);
		print_inorder(root->right);
	}
}

void delete_tree(struct Node* root) {
	if (root) {
		delete_tree(root->left);
		delete_tree(root->right);
		free(root);
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
			insert(&root, d);
			break;
		case 's':
			print_inorder(root);
			break;
		case 'd':
			delete_tree(root);
			
			root = NULL;
			break;
		default:
			break;
		}
	}
	delete_tree(root);
    return 0;
}



