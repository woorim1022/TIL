#include <stdio.h>


int main_atp2()
{
	//1. 배열은 첫 번째 요소의 주소
	//2. 배열명은 주소상수
	int myarr[5] = { 10,20,30,40,50 };
	int* pmyarr = myarr + 1;
	pmyarr[0] = 100;

	printf("myarr = [");
	for (int i = 0; i < 5; i++) {
		printf("%d, ", myarr[i]);
	}
	printf("]\n");
	return 0;
}