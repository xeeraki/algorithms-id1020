
#include<stdio.h>
void printchar(char *c){
  if(*c)
  printchar(c+1);
  //putchar(c);
  printf("%c\n", *c);
}
int main(){
char c[] = "hello world";
//char c = getchar();
printchar(c);
}
