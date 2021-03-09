#include <stdio.h>

int main_ex1()
{
	int num = 10;
	printf("°ª:%d\n", num);
	int* pdata = &num;
	*pdata = 100;


	printf("°ª:%d", num);
	return 0;
}
