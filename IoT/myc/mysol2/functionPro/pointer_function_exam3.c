#include <stdio.h>


void test_sort(double*, double*, double*);

int main_333333333333()
{
	double num1, num2, num3;
	printf("값1 : ");
	scanf_s("%lf", &num1);
	printf("값2 : ");
	scanf_s("%lf", &num2);
	printf("값3 : ");
	scanf_s("%lf", &num3);
	printf("정렬전 %lf, %lf, %lf\n", num1, num2, num3);
	test_sort(&num1, &num2, &num3);
	printf("정렬후 %lf, %lf, %lf", num1, num2, num3);
	return 0;
}

void test_sort(double* num1, double* num2, double* num3) {
	if (*num1 > *num2) {
		if (*num1 > *num3) {
			if (*num3 > *num2) {
				//num1 num3 num2
				int temp = *num3;
				*num3 = *num2;
				*num2 = temp;
			}
			else;//num1 num2 num3
		}
		else {
			//num3 num1 num2
			int temp = *num3;
			*num3 = *num2;
			*num2 = *num1;
			*num1 = temp;
		}
	}
	else {
		if (*num3 > *num2) {
			//num3 num2 num1
			int temp = *num3;
			*num3 = *num1;
			*num1 = temp;
		}
		else {
			if (*num1 > *num3) {
				//num2 num1 num3
				int temp = *num2;
				*num2 = *num1;
				*num1 = temp;
			}
			else {
				//num2 num3 num1
				int temp = *num3;
				*num3 = *num1;
				*num1 = *num2;
				*num2 = temp;
			}
		}
	}
}