#include <stdio.h>

int main_ex2()
{
	int array[5] = { 100, 99, 88, 75, 78 };

	int i = 0, max = 0;
	//max ������ �����ϰ� �迭 ����� �� �� �ִ밪�� �����ϱ�
	//�ִ밪:
	for (int i = 0; i < sizeof(array)/sizeof(int); i++) {
		if (array[i] > max) {
			max = array[i];
		}
	}
	printf("�ִ밪: %d\n", max);
	return 0;
}
