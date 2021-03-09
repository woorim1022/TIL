// pointerPro.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <stdio.h>

int main_aaadfsfda()
{
	//프로젝트 우클릭, 속성, 
	int data = 300;//0x0019FED8 
	// &연산자 -> 컴파일 타임 연산자
	// &data -> 변수명이 data인 변수가 할당된 메모리의 주소는 어디야?
	// pdata는 data변수의 주소를 저장
	// 
	int* pdata = &data; //0x0019FECC  d8 fe 19 00 
	//integer 2개만큼 늘어난다는 의미, 즉, 8byte만큰 이동된 주소
	pdata = pdata + 2;
	*pdata = 500;

	 
	printf("값:%d", data);
	return 0;
}
