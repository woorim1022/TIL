#include <stdio.h>


int main_atp2()
{
	//1. �迭�� ù ��° ����� �ּ�
	//2. �迭���� �ּһ��
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