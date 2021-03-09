//#include <stdio.h>
//
//void inputdata(int**);
//void printdata(int**);
//int arr[10][4] = { {0} };
//
//int main_123131232()
//{
//	//포인터배열을 정의하고 매개변수로 전달
//	//10개
//	int* p_arr[10] = { {0} };
//	inputdata(p_arr);
//	printdata(p_arr);
//	return 0;
//}
//
//void inputdata(int** p_arr) {
//	//int형 데이터 4개를 입력받아서 배열에 저장
//	for (int i = 0; i < 10; i++) {
//		printf("입력 : ");
//		scanf_s("%d%d%d%d", &arr[i][0], &arr[i][1], &arr[i][2], &arr[i][3]);
//		p_arr[i] = arr[i];
//	}
//
//}
//
//void printdata(int** p_arr) {
//	//매개변수 포인터배열
//	for (int i = 0; i < 10; i++) {
//		for (int j = 0; j < 4; j++) {
//			printf("%d\t", p_arr[i][j]);
//		}
//		printf("\n");
//	}
//}
