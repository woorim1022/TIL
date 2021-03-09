#include <stdio.h>

int main_ex2()
{
	int array[5] = { 100, 99, 88, 75, 78 };

	int i = 0, max = 0;
	//max 변수를 선언하고 배열 요소의 값 중 최대값을 저장하기
	//최대값:
	for (int i = 0; i < sizeof(array)/sizeof(int); i++) {
		if (array[i] > max) {
			max = array[i];
		}
	}
	printf("최대값: %d\n", max);
	return 0;
}
