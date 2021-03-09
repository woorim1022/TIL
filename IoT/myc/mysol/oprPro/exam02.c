#include <stdio.h>


int main() {
	int num1 = 0, num2 = 0, num3 = 0;
	printf("값 세개 입력:");
	scanf_s("%d %d %d", &num1, &num2, &num3);

	printf("최대값 : %d\n",
			num1 > num2? (num3 > num1? num3: num1) : (num3 > num2 ? num3 : num2));
	return 0;
}