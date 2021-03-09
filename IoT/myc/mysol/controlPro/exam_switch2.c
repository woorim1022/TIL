#include <stdio.h>

int main_e()
{
	int num1 = 0, num2 = 0;
	char op = 0;
	printf("계산식:");
	scanf_s("%d%c%d", &num1, &op, &num2);
	switch (op)
	{
	case ('+'):
		printf("%d", num1+num2);
		break;
	case ('-'):
		printf("%d", num1 - num2);
		break;
	case ('*'):
		printf("%d", num1 * num2);
		break;
	case ('/'):
		printf("%d", num1 / num2);
		break;
	default:
		printf("잘못입력");
		break;
	}
	return 0;
}