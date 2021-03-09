#include <stdio.h>

int main_at()
{
	//1부터 100까지의 숫자 다섯개를 저장할 수 있는 배열을 정의하고 
	//배열의 모든 숫자를 더한 합과 평균을 구해서 출력하기
	int array[5] = { 100, 99, 88, 75, 78 };
	int sum = 0;
	for (int i = 0; i < sizeof(array) / sizeof(int); i++) {
		sum += array[i];
	}
	printf("합:%d, 평균:%d", sum, sum / (sizeof(array)/sizeof(int)));
	return 0;
}
