#include <stdio.h>
#include <stdbool.h>

//while
int main_w()
{
	/*int num = 1;
	while (num < 11) {
		printf("%d\n", num);
		num = num + 1;
	}
	num = 1;
	while (num < 2) {
		printf("%d\n", num);
		num = num + 1;
	}*/

	//scanf_s�� ���� ����
	//scanf_s�� �о���� ������ ������ �����Ѵ�.
	/*int num2 = 0;
	int value1 = 0, value2 = 0, value3 = 0;
	num2 = scanf_s("%d,%d,%d", &value1, &value2, &value3);
	printf("%d, %d, %d, %d\n", num2, value1, value2, value3);*/




	/*char value4 = 0;
	int sum = 0;
	while (value4 != 'q') {
		printf("���ڸ� �Է��ϼ��� : ");
		scanf_s("%c", &value4);
		printf("aaaaaaa%d", (int)value4 - 48);
		sum += (int)value4-48;
		if (value4 == 'q') break;
	}
	printf("sum=%d\n", sum);*/


	//��Ʈ������
	int i = 0, row = 0;
	while (row < 5) {
		i = 0;
		while (i < 5) {
			printf("*\t");
			i++;
		}
		printf("\n");
		row++;
	}


	return 0;
}