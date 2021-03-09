#include <stdio.h>
#include <conio.h>


void rotate_2(int*, int*, int*);

int main_444444444444444444()
{
	int num = 10, num2 = 20, num3 = 30;
	char ch;
	printf("%d %d %d", num, num2, num3);
	while (1) {
		scanf_s("%c", &ch, 1);
		//enter키 이외의 키보드 키가 눌렸을 때 반복문을 빠져나온다.
		if (ch != '\n') {
			break;
		}
		rotate_2(&num, &num2, &num3);
		printf("%d %d %d", num, num2, num3);
	}
	return 0;
}

void rotate_2(int* pnum, int* pnum2, int* pnum3) {
	int temp;
	temp = *pnum;
	*pnum = *pnum2;
	*pnum2 = *pnum3;
	*pnum3 = temp;
}