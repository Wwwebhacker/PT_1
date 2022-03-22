# include <unistd.h>
# include <stdio.h>

#define URLS 2


int main ()
{
    char url [URLS][66]={"https://cdn.kernel.org/pub/linux/kernel/v4.x/linux-4.17.2.tar.xz\0","https://cdn.kernel.org/pub/linux/kernel/v5.x/linux-5.0-rc3.tar.gz\0"};
    int pid;
    for(int i=0;i<URLS;i++){

        pid=fork();
        if (pid==0){
        execlp ("wget","wget" , "-q",url[i],NULL ) ;

        exit(0);        
        }
        
        
    }
    while ((pid=wait(0))>0)
    {
        printf("%d ended\n", pid);
    }
    
}