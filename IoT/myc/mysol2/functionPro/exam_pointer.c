#include <stdio.h>

int main_ex1()
{
	int num = 10;
	printf("��:%d\n", num);
	int* pdata = &num;
	*pdata = 100;


	printf("��:%d", num);
	return 0;
}
