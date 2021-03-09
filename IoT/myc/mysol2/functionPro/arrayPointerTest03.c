#include <stdio.h>


int main_apt3()
{
	int arr[3] = { 0 }; //배열 선언
	int* parr = arr; //포인터에 배열명(첫 번째 요소의 주소) 저장

	*parr = 10; //arr[0] = 10;
	*(parr + 1) = 20;
	parr[2] = 30;  //[]를 이용하면 포인터변수를 배열처럼 사용할 수 있다.
	for (int i = 0; i < 3; i++) {
		printf("%d\n", arr[i]);
	}

	//포인터변수로 배열에 접근할 때의 차이점
	printf("%d\n", sizeof(arr)); // 12 = int크기인4 * 배열크기3
	printf("%d\n", sizeof(parr));// int*의 크기인 4
	return 0;
}