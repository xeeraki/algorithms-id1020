#include<stdio.h>
int main() {
int a[] = {1,2,-5,9,-8,-4,5};
int n = sizeof(a)/sizeof(0);
orderNumber(a,n);
for(int i = 0; i < n; i++){
  printf("%d", a[i]);
  }
  printf("\n" );
}
void orderNumber(int a[], int n){
  int temp ,i,j=0;
  for(i = 0; i < n; i++){
      if(a[i] < 0){
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        j++;
      }
    }
  }
