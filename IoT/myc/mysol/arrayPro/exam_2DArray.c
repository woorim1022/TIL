#include <stdio.h>

int main_aaa()
{
	//int�� myarr[5][5]�迭�� �����ϰ� 1���� 25���� ���� �Ҵ��ϱ�
	//�Ҵ�� �迭�� ���� ����ϱ�
	//1  2	3  4  5  -> 15
	//6  7  8  9  10 -> 40
	//11  12  13  14  15 -> 65
	//��� ��� ���� �� ���� ����ϱ�
	int myarr[5][5] = {
		{0},
		{0},
		{0},
		{0},
		{0}
	};
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			printf("myarr[%d][%d] : ", i, j);
			scanf_s("%d", &myarr[i][j]);
		}
	}
	int sumcol = 0, sumrow = 0;
	for (int i = 0; i < 5; i++) {
		sumrow = 0;
		for (int j = 0; j < 5; j++) {
			printf("%d\t", myarr[i][j]);
			sumrow += myarr[i][j];
		}
		printf("%d\n", sumrow);
	}
	for (int i = 0; i < 5; i++) {
		sumcol = 0;
		for (int j = 0; j < 5; j++) {
			sumcol += myarr[j][i];
		}
		printf("%d\t", sumcol);
	}
	return 0;
}
