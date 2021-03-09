#include <stdio.h>
#include <conio.h>


void rotate(int*, int*, int*);
int printMenu_1(void);

int main_44444444()
{
	int menuIndex = 0;
	int num1 = 10, num2 = 20, num3 = 30;
	printf("초기값 %d, %d, %d\n", num1, num2, num3);
	while ((menuIndex = printMenu_1()) == 13) {
		rotate(&num1, &num2, &num3);
		printf("rotate %d, %d, %d\n", num1, num2, num3);
	}
	return 0;
}



int printMenu_1(void) {
	int inputValue = 0;
	printf("엔터키 : rotate, 나머지 키 : 종료\n");
	inputValue = _getch();
	return inputValue;
}

void rotate(int* num1, int* num2, int* num3) {
	int temp;
	temp = *num1;
	*num1 = *num2;
	*num2 = *num3;
	*num3 = temp;
}