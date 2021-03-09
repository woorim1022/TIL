#include <stdio.h>


void pointerChange_2(int*, int*);

int main_11111()
{
	int num1 = 100, num2 = 200;

	printf("변경전 %d, %d\n", num1, num2);
	pointerChange_2(&num1, &num2);
	printf("변경후 %d, %d", num1, num2);
	return 0;
}

void pointerChange_2(int* num1, int* num2) {
	int temp;
	temp = *num1;
	*num1 = *num2;
	*num2 = temp;
}