#include <stdio.h>


int main() {
	int num1 = 0, num2 = 0, num3 = 0;
	printf("�� ���� �Է�:");
	scanf_s("%d %d %d", &num1, &num2, &num3);

	printf("�ִ밪 : %d\n",
			num1 > num2? (num3 > num1? num3: num1) : (num3 > num2 ? num3 : num2));
	return 0;
}