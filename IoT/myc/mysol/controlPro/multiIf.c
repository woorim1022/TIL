#include <stdio.h>

int main_m()
{
	int gender = 0;
	printf("성별을 입력하세요:");
	scanf_s("%d", &gender);
	if (gender == 1) {
		printf("남자");
	}
	else if (gender == 2) {
		printf("여자");
	}
	else if (gender == 3) {
		printf("남자");
	}
	else if (gender == 4) {
		printf("여자");
	}
	else {
		printf("기타");
	}
	return 0;
}