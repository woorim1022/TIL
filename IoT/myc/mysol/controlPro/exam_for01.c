#include <stdio.h>

//for
int main_f()
{
	int i = 0;
	int sum1 = 0, sum2 = 0, sum3 = 0;
	for (i; i <= 100;i++) {
		sum1 += i;
		if (i % 2 == 0) sum2 += i;
		else sum3 += i;
	}
	printf("����=%d\n", sum1);
	printf("¦����=%d\n", sum2);
	printf("Ȧ����=%d\n", sum3);
	return 0;
}