#include <stdio.h>


int main_apt1()
 {
	//1. �迭�� ù ��° ����� �ּ�
	//2. �迭���� �ּһ��
	int myarr[5] = { 10,20,30,40,50 };
	int* pmyarr = myarr;
	printf("%p %p %p %d\n", &myarr[0], pmyarr, myarr, pmyarr[1]);

	//pmyarr + 1  => �����ּ� + ����, �ɼ��� �ǹ�(����ּҰ���) 
	*(pmyarr + 1) = 5; //pmyarr[1] = 5�� ���� �ǹ�
	printf("%p = %p = %p = %p\n", &myarr[0], pmyarr, myarr, &pmyarr[0]);
	printf("%p = %p = %p = %p\n", &myarr[1], pmyarr+1, myarr+1, &pmyarr[1]);
	return 0;
}