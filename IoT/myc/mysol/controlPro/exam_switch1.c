#include <stdio.h>

int main_c()
{
	int score = 0;
	printf("점수를 입력하세요:");
	scanf_s("%d", &score);
	switch (score/10)
	{
	case (10):
		if (score/10 == 100)
			printf("A학점");
		else
			printf("잘못입력");
		break;
	case (9):
		printf("A학점");
		break;
	case (8):
		printf("B학점");
		break;
	case (7):
		printf("C학점");
		break;
	case (6):
		printf("D학점");
		break;
	case (5):
		printf("F학점");
		break;
	case (4):
		printf("F학점");
		break;
	case (3):
		printf("F학점");
		break;
	case (2):
		printf("F학점");
		break;
	case (1):
		printf("F학점");
		break;
	case (0):
		printf("F학점");
		break;
	default:
		printf("잘못입력");
		break;
	}
	return 0;
}