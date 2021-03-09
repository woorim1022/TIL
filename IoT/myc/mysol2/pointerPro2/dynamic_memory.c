#include <stdio.h>
#include <stdlib.h>

int main_dm()
{
	int* plist = NULL;

	//malloc리턴값 - 힙에 할당된 메모리영역 중 첫 번째 바이트의 주소(void*)
	//malloc 매개변수 - 요청할 메모리의 사이즈(바이트단위)
	plist = malloc(sizeof(int)); // 12
	plist[0] = 10;
	plist[1] = 20;
	plist[2] = 30;

	//동적으로 할당받은 메모리 범위를 벗어나게 프로그래밍 함(할 당받은 메모리의 경계에 값이 저장됨..ㄷ), 메모리 반납 시 에러 발생
	//*(((char*)plist) + 12) = 'A';

	free(plist);
	return 0;
}









