#include <stdio.h>


int divide(int*, int*);

int main_2222222222()
{
	int result, rest;
	divide(&result, &rest);
	printf("몫 : %d, 나머지 : %d\n", result, rest);
	return 0;
}

int divide(int* result, int* rest) {
	int num1, num2;
	printf("값1 : ");
	scanf_s("%d", &num1);
	printf("값2 : ");
	scanf_s("%d", &num2);
	*result = num1 / num2;
	*rest = num1 % num2;
}