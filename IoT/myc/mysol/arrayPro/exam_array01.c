#include <stdio.h>

int main_at()
{
	//1���� 100������ ���� �ټ����� ������ �� �ִ� �迭�� �����ϰ� 
	//�迭�� ��� ���ڸ� ���� �հ� ����� ���ؼ� ����ϱ�
	int array[5] = { 100, 99, 88, 75, 78 };
	int sum = 0;
	for (int i = 0; i < sizeof(array) / sizeof(int); i++) {
		sum += array[i];
	}
	printf("��:%d, ���:%d", sum, sum / (sizeof(array)/sizeof(int)));
	return 0;
}
