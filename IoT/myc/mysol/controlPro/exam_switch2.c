#include <stdio.h>

int main_e()
{
	int num1 = 0, num2 = 0;
	char op = 0;
	printf("����:");
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
		printf("�߸��Է�");
		break;
	}
	return 0;
}