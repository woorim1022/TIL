#include <stdio.h>

int main_m()
{
	int gender = 0;
	printf("������ �Է��ϼ���:");
	scanf_s("%d", &gender);
	if (gender == 1) {
		printf("����");
	}
	else if (gender == 2) {
		printf("����");
	}
	else if (gender == 3) {
		printf("����");
	}
	else if (gender == 4) {
		printf("����");
	}
	else {
		printf("��Ÿ");
	}
	return 0;
}