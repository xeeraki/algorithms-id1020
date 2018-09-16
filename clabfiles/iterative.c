#include <stdio.h>
int main(){
char array[] = "hello World";
reverse(array);
printf("%s\n", array);
}
void reverse(char s[])
{
int c, i, j;
for (i = 0, j = strlen(s)-1; i < j; i++, j--) {
c = s[i];
s[i] = s[j];
s[j] = c;
}
}
