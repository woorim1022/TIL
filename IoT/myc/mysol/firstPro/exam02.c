#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main(void) {
	int num = 0;
	printf("입력값 :");
	scanf("%d", &num);
	printf("연산결과 : %d", num*100);
	return 0;
}