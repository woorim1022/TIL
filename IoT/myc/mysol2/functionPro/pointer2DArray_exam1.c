#include <stdio.h>

void inputdata(int**);
void printdata(int**);

int main()
{
	//�����͹迭�� �����ϰ� �Ű������� ����
	//10��
	int* p_arr[10] = { {0} };
	inputdata(p_arr);
	printf("���� : %d", p_arr[0][0]);
	printdata(p_arr);
	return 0;
}

void inputdata(int** p_arr) {
	//int�� ������ 4���� �Է¹޾Ƽ� �迭�� ����
	int arr[4] = { 0 };
	for (int i = 0; i < 10; i++) {
		printf("�Է� : ");
		scanf_s("%d%d%d%d", &arr[0], &arr[1], &arr[2], &arr[3]);
		p_arr[i] = arr;
	}
		
}

void printdata(int** p_arr) {
	//�Ű����� �����͹迭
	printf("2222222222\n");
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 4; j++) {
			printf("%d\t", p_arr[i][j]);
		}
		printf("\n");
	}
}
