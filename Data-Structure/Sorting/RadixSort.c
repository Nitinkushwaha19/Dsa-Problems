
#include<stdio.h>
#include<conio.h>
#define Row 10

void inputArray(int arr[], int size,int len){
   int i;
   printf("\nEnter %d element of the array\n",size);

   for(i=0;i<size;i++) {
	scanf("%d",&arr[i]);

	while( getLen(arr[i]) != len ) {
		printf("Enter the num having length of %d : ",len);
		scanf("%d",&arr[i]);

	}
   }
}

void printArray(int arr[], int size) {
	int i;
	for(i=0;i<size;i++){
	   printf("%d ", arr[i]);
	}

}

int getLen(int num) {
	int l = 0;
	while( num != 0) {
		num = num/10;
		l++;
	}
	return l;
}

void radixSort(int arr[], int N, int l) {

	int bucket[Row][10] = {0};
	int ub[10] = {0};

	int m = 10, d = 1;
	int r,i,j,k,s,p;

	for( p = 1;p<=l;p++) {
	  for( k = 0;k<N;k++){

		r = arr[k] % m;
		i = r/d;

		bucket[ub[i]][i] = arr[k];
		ub[i] = ub[i] + 1;
	  }

	  m *= 10;
	  d *= 10;

	  for( j = 0,s=0;j<10;j++) {
		for( k = 0;k<ub[j];k++,s++){
			arr[s] = bucket[j][k];
		}
		ub[j] = 0;
	  }

	}

}

void main()
{
   int arr[40], size, len;
   clrscr();

   printf("Enter the size of the array : ");
   scanf("%d",&size);

   printf("Enter the len of the element of the array : ");
   scanf("%d",&len);

   inputArray(arr,size,len);

   printf("\nArray before sorting\n");
   printArray(arr,size);

   radixSort(arr,size,len);

   printf("\nArray after sorting\n");
   printArray(arr,size);

   getch();

}
