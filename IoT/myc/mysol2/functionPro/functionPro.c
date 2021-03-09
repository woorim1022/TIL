#include <stdio.h>


int stu[50][5] = { 0, };
int index = 0;

void stuReg(void){
	printf("이름 : ");
	scanf_s("%d", &stu[index][0]);
	printf("python 점수: ");
	scanf_s("%d", &stu[index][1]);
	printf("c 점수: ");
	scanf_s("%d", &stu[index][2]);
	printf("ras 점수: ");
	scanf_s("%d", &stu[index][3]);
	printf("mon 점수: ");
	scanf_s("%d", &stu[index][4]);
	printf("%d, %d, %d, %d, %d\n", stu[index][0], stu[index][1], stu[index][2], stu[index][3], stu[index][4]);
	index++;
}
void viewall(void){
	for (int i = 0; i < (sizeof(stu) / sizeof(int)); i++) {
		printf("%d %d %d %d %d\n", stu[i][0], stu[i][1], stu[i][2], stu[i][3], stu[i][4]);
	}
}
void viewone(void){}
void subAvg(void){}
void stuAvg(void){}

int printMenu(void) {
	int inputValue = 0;
	system("cls");
	printf("**************학사관리시스템***************\n");
	printf("1.학생등록\t2.전체학생조회\t3.학생검색\t4.과목별평균점수\t5.학생별평균점수\t6.종료\n");
	scanf_s("%d", &inputValue);
	return inputValue;
}


int main_aaaa()
{
	int menuIndex = 0;
	while ((menuIndex = printMenu()) != 6) {
		switch (menuIndex)
		{
			case 1:
				stuReg();
				break;
			case 2:
				viewall();
				break;
			case 3:
				viewone();
				break;
			case 4:
				subAvg();
				break;
			case 5:
				stuAvg();
				break;
			default:
				printf("잘못입력\n");
				break;
		}
	}
	printf("hello");
}
