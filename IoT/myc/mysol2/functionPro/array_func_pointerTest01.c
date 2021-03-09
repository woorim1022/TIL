#include <stdio.h>

void printArr(int*);
void printallArr(int*, int);
int main_afpt01()
{
	int myarr[5] = { 10,20,30,40,50 };
	int myarr2[7] = { 10,20,30,40,50,60,70 };
	printArr(myarr);
	printf("*******************\n");
	printallArr(myarr, 5);
	printf("*******************\n");
	printallArr(myarr2, 7);
	return 0;
}

void printArr(int* pmyarr) { 
	for (int i = 0; i < 5; i++) {
		printf("%d\n", pmyarr[i]);
	}
}

void printallArr(int* pmyarr, int size) {//배열의 크기가 다른 배열을 모두 출력하기
	for (int i = 0; i < size; i++) {
		printf("%d\n", pmyarr[i]);
	}
}