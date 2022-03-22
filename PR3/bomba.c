int main(void)
{
    int i=2;
    while(i>0) {
        fork();
        i--;
        printf(" # ");
    }
    while (wait(0)>0);
}