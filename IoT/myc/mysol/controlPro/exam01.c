#include <stdio.h>

int main_1()
{
	int age = 0;
	char gender = 0;
	printf("age, gender:");
	scanf_s("%d %c", &age, &gender);

	if (gender == 'f') {
		if (age >= 20) {
			printf("성인여자");
		}
		else {
			printf("청소년여자");
		}
	}
	else if(gender == 'm') {
		if (age >= 20) {
			printf("성인남자");
		}
		else {
			printf("청소년남자");
		}
	}
	else printf("잘못입력");
	return 0;
}