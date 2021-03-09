#include <stdio.h>

int main_asdfasdf()
{
	char str[80];
	printf("문자열 입력:");
	//scanf_s로 문자열을 입력받을 때는 공백이 없는 연속된 문자를 입력받는다.
	//scanf_s는 버퍼를 사용한다. 버퍼는 키보드로 입력받은 문자열을 저장하는 메모리
	scanf_s("%s", str, sizeof(str));
	printf("문자열 출력 : %s\n", str);
	printf("문자열 입력:");
	scanf_s("%s", str, sizeof(str));
	printf("문자열 출력 : %s\n", str);
	return 0;
}

