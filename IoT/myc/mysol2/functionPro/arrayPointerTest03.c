#include <stdio.h>


int main_apt3()
{
	int arr[3] = { 0 }; //�迭 ����
	int* parr = arr; //�����Ϳ� �迭��(ù ��° ����� �ּ�) ����

	*parr = 10; //arr[0] = 10;
	*(parr + 1) = 20;
	parr[2] = 30;  //[]�� �̿��ϸ� �����ͺ����� �迭ó�� ����� �� �ִ�.
	for (int i = 0; i < 3; i++) {
		printf("%d\n", arr[i]);
	}

	//�����ͺ����� �迭�� ������ ���� ������
	printf("%d\n", sizeof(arr)); // 12 = intũ����4 * �迭ũ��3
	printf("%d\n", sizeof(parr));// int*�� ũ���� 4
	return 0;
}