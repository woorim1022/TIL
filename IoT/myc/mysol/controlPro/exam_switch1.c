#include <stdio.h>

int main_c()
{
	int score = 0;
	printf("������ �Է��ϼ���:");
	scanf_s("%d", &score);
	switch (score/10)
	{
	case (10):
		if (score/10 == 100)
			printf("A����");
		else
			printf("�߸��Է�");
		break;
	case (9):
		printf("A����");
		break;
	case (8):
		printf("B����");
		break;
	case (7):
		printf("C����");
		break;
	case (6):
		printf("D����");
		break;
	case (5):
		printf("F����");
		break;
	case (4):
		printf("F����");
		break;
	case (3):
		printf("F����");
		break;
	case (2):
		printf("F����");
		break;
	case (1):
		printf("F����");
		break;
	case (0):
		printf("F����");
		break;
	default:
		printf("�߸��Է�");
		break;
	}
	return 0;
}