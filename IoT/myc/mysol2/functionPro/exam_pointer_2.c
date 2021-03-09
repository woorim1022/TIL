#include <stdio.h>

int main_ssss()
{
	int num1 = 10, num2 = 20, total = num1 + num2;
	int* n1 = &num1, * n2 = &num2;
	double avg = total / 2.0;
	//printf("°ª:%d\n", num);
	int* pdata1 = &total;
	double *pdata2 = &avg;
	int total2 = *n1 + *n2;
	double avg2 = (*n1 + *n2) / 2;


	printf("num1:%d num2:%d\n", *n1, *n2);
	printf("ÃÑÇÕ1:%d\n", *pdata1);
	printf("ÃÑÇÕ2:%d\n", total2);
	printf("Æò±Õ1:%f\n", *pdata2);
	printf("Æò±Õ2:%f\n", avg2);
	return 0;
}
