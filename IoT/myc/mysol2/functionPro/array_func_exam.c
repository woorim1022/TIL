#include <stdio.h>
//�迭�� ���� �Է��ϰ� �Էµ� �迭 ��� �� �ִ밪�� �����ϴ� �۾��� ����

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
		printf("�� �Է� : ");
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
