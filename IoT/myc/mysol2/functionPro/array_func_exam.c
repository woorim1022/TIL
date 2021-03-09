#include <stdio.h>
//배열에 값을 입력하고 입력된 배열 요소 중 최대값을 리턴하는 작업을 수행

void inputArry(double*, int);
double getMax(double*, int);
int main_afe()
{
	double myarr[5] = { 0.0 };
	int size = sizeof(myarr) / sizeof(double);
	inputArry(myarr, size);
	double max = getMax(myarr, size);
	for (int i = 0; i < size; i++) {
		printf("%lf\n", myarr[i]);
	}
	printf("max : %lf\n", max);
	return 0;
}

void inputArry(double *pmyarr, int size) {
	for (int i = 0; i < size; i++) {
		printf("값 입력 : ");
		scanf_s("%lf", pmyarr+i);
	}
}

double getMax(double* pmyarr, int size) {
	double max = 0;
	for (int i = 0; i < size; i++) {
		if (pmyarr[i] > max)
			max = pmyarr[i];
		
	}
	return max;
}
