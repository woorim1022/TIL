#include <stdio.h>

int main_ap()
{
	// int 형 배열을 선언함, 배열을 구성하는 여러 요소는 첫 번째 요소이고 이 첫 번째 요소의
	// 메모리주소가 반환
	// 배열 변수명은 첫 번째 요소의 주소값을 가지고 있다.
	// int형 데이터를 5개 담을 수 있는 배열을 선언하고 초기값을 0 으로 정의
	int myarray[5] = { 0 };
	myarray[2] = 100;
	for (int i = 0; i < sizeof(myarray)/sizeof(int); i++)
		printf("%d\n", myarray[i]);
	return 0;
}
