#include <stdio.h>

int main_atat()
{
	//1���� 100������ ���� �ټ����� ������ �� �ִ� �迭�� �����ϰ� 
	//�迭�� ��� ���ڸ� ���� �հ� ����� ���ؼ� ����ϱ�
	int array[5] = { 100, 99, 88, 75, 78 };
	printf("%d, %p, %p, %p\n", array[0], array, &array[0], &array[1]);

	for (int i = 0; i < 5; i++) {
		printf("%p\n", (int)&array[i]);
	}

	int mydata = 1000;
	printf("%d, %p\n", mydata, &mydata);
	return 0;
}
