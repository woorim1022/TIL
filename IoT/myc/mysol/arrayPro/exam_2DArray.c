#include <stdio.h>

int main_aaa()
{
	//int형 myarr[5][5]배열을 선언하고 1부터 25까지 값을 할당하기
	//할당된 배열의 값을 출력하기
	//1  2	3  4  5  -> 15
	//6  7  8  9  10 -> 40
	//11  12  13  14  15 -> 65
	//모든 행과 열의 총 합을 출력하기
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
