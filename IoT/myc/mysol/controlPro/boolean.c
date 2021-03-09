#include <stdio.h>
#include <stdbool.h>

//boolean타입
int main_b()
{
	printf("%d\n", sizeof(_Bool));
	_Bool b1;//
	b1 = 0; // false
	b1 = 1; // true
	printf("%d\n", b1);

	//stdbool.h 추가했기 때문에 true/false 넣어줄 수 있음, 내부적으로는 0/1로 처리
	bool b2, b3;
	b2 = true;
	b3 = false;
	printf("%d%d\n", b2, b3);
	return 0;
}