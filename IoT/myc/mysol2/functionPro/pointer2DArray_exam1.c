#include <stdio.h>

void inputdata(int**);
void printdata(int**);

int main()
{
	//포인터배열을 정의하고 매개변수로 전달
	//10개
	int* p_arr[10] = { {0} };
	inputdata(p_arr);
	printf("메인 : %d", p_arr[0][0]);
	printdata(p_arr);
	return 0;
}

void inputdata(int** p_arr) {
	//int형 데이터 4개를 입력받아서 배열에 저장
	int arr[4] = { 0 };
	for (int i = 0; i < 10; i++) {
		printf("입력 : ");
		scanf_s("%d%d%d%d", &arr[0], &arr[1], &arr[2], &arr[3]);
		p_arr[i] = arr;
	}
		
}

void printdata(int** p_arr) {
	//매개변수 포인터배열
	printf("2222222222\n");
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 4; j++) {
			printf("%d\t", p_arr[i][j]);
		}
		printf("\n");
	}
}
