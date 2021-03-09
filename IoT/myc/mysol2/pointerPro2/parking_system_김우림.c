#include <stdio.h>

void parkin(int* []);
void parkout(int* []);
void viewall(int* []);
void viewfloor(int* []);


int main()
{
	int arr1[10] = { 1,2,3,4,5,6,7,8,9,10 };
	int arr2[10] = { 1,2,3,4,5,6,7,8,9,10 };
	int arr3[10] = { 1,2,3,4,5,6,7,8,9,10 };
	int* pl[3] = { arr1, arr2, arr3};
	int menu = 0;
	printf("********주차관리시스템**********\n");
	printf("1. 주차\n");
	printf("2. 출차\n");
	printf("3. 주차현황 출력\n");
	printf("4. 층별 빈 주차 공간 확인하기\n");
	printf("0. 종료\n");
	printf("번호 선택 : ");
	scanf_s("%d", &menu);
	while (menu != 0) {
		switch (menu)
		{
			case 1:
				parkin(pl);
				break;
			case 2:
				parkout(pl);
				break;
			case 3:
				viewall(pl);
				break;
			case 4:
				viewfloor(pl);
				break;
			case 0:
				break;
			default:
				printf("다시 입력하세요");
				break;
		}
		printf("\n********주차관리시스템**********\n");
		printf("1. 주차\n");
		printf("2. 출차\n");
		printf("3. 주차현황 출력\n");
		printf("4. 층별 빈 주차 공간 확인하기\n");
		printf("0. 종료\n");
		printf("번호 선택 : ");
		scanf_s("%d", &menu);
	}
	return 0;
}

void parkin(int* pl[]) {
	int carnum = 0, worknum = 0, floor = 1;
	int count[3] = { 0 };
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 10; j++) {
			if (pl[i][j] / 1000 == 0) {
				count[i]++;
			}
		}
	}
	printf("\n주차할 차번 입력(숫자 4자리) : ");
	scanf_s("%d", &carnum);

	 do {
		printf("\n***************주차 가능 공간 : B1층[%d대] B2층[%d대] B3층[%d대]\n",count[0],count[1],count[2]);
		printf("[B%d층]============================\n", floor);
		printf("[%d] [%d] [%d] [%d] [%d]\n", pl[floor-1][0], pl[floor-1][1], pl[floor - 1][2], pl[floor - 1][3], pl[floor - 1][4]);
		printf("[%d] [%d] [%d] [%d] [%d]\n", pl[floor - 1][5], pl[floor - 1][6], pl[floor - 1][7], pl[floor - 1][8], pl[floor - 1][9]);
		printf("주차 번호 입력:(다른층 0, 취소 -1) : ");
		scanf_s("%d", &worknum);
		if (worknum == 0)
		{
			printf("\n1. B1층 2. B2층 3. B3층\n");
			printf("주차층을 선택하세요:");
			scanf_s("%d", &floor);
		}
		else if (worknum == -1) break;
		else {
			//주차시키기
			pl[floor-1][worknum-1] = carnum;
			break;
		}
	 } while (1);

}
void parkout(int* pl[]) {
	int carnum = 0;
	printf("\n출차할 차번 입력(숫자 4자리) : ");
	scanf_s("%d", &carnum);
	//출차하기
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 10; j++) {
			if (pl[i][j] == carnum) {
				pl[i][j] = j + 1;
			}
		}
	}
	printf("출차 완료\n");
}
void viewall(int* pl[]) {
	printf("\n");
	for (int i = 0; i < 3; i++) {
			printf("[B%d층]============================\n", i+1);
			printf("[%d] [%d] [%d] [%d] [%d]\n", pl[i][0],pl[i][1],pl[i][2],pl[i][3],pl[i][4]);
			printf("[%d] [%d] [%d] [%d] [%d]\n", pl[i][5], pl[i][6], pl[i][7], pl[i][8], pl[i][9]);
	}
}
void viewfloor(int* pl[]) {
	int floor = 0;
	printf("\n층을 선택하세요(1, 2, 3):");
	scanf_s("%d", &floor);
	printf("[B%d층]============================\n", floor);
	printf("[%d] [%d] [%d] [%d] [%d]\n", pl[floor - 1][0], pl[floor - 1][1], pl[floor - 1][2], pl[floor - 1][3], pl[floor - 1][4]);
	printf("[%d] [%d] [%d] [%d] [%d]\n", pl[floor - 1][5], pl[floor - 1][6], pl[floor - 1][7], pl[floor - 1][8], pl[floor - 1][9]);
}