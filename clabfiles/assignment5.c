#include<stdio.h>
int main() {
int a[] = {1,2,-5,9,-8,-4,5};
orderNumber(a,n);
printf("%a\n", a);
}

void orderNumber(int a[], int n){
  int temp ,i,j=0;
  for(i = 0; i < sizeof(a); i++){
      if(a[i] < 0){
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        j++;
      }
    }
  }
