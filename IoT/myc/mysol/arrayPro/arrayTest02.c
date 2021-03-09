#include <stdio.h>

int main_atat()
{
	//1부터 100까지의 숫자 다섯개를 저장할 수 있는 배열을 정의하고 
	//배열의 모든 숫자를 더한 합과 평균을 구해서 출력하기
	int array[5] = { 100, 99, 88, 75, 78 };
	printf("%d, %p, %p, %p\n", array[0], array, &array[0], &array[1]);

	for (int i = 0; i < 5; i++) {
		printf("%p\n", (int)&array[i]);
	}

	int mydata = 1000;
	printf("%d, %p\n", mydata, &mydata);
	return 0;
}
