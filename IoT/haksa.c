#include <stdio.h>
#include <stdlib.h>

char stu[50][5] = { {0} };
int index = 0;

void add(void);
void viewall(void);
void viewone(char);
void subavg(void);
void stuavg(void);

int main()
{
	//학사관리시스템
	// 1. 학생추가
	//		이름
	//		c 점수
	//      파이썬점수
	//      라즈베리파이점수
	//      안드로이드 점수
	// 2. 전체조회
	// 3. 이름으로 검색해 조회
	// 4 과목별 평균 조회
	// 5. 학생별 평균 조회
	int menu = 0;
	char name = 0;
	printf("****************학사관리 시스템*******************\n");
	printf(" 1. 학생추가 2. 전체학생 조회 3. 한명 조회 4. 과목별 평균 조회 5. 학생별 평균 조회 6. 종료\n");
	scanf_s("%d", &menu);
	while (menu != 6) {
		switch (menu)
		{
			case 1:
				add();
				break;
			case 2:
				viewall();
				break;
			case 3:
				printf("검색할 학생명을 입력하세요 : ");
				scanf_s(" %c", &name, 1);
				viewone(name);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				printf("다시 입력하세요");
				break;
		}
	printf("****************학사관리 시스템*******************\n");
	printf(" 1. 학생추가 2. 전체학생 조회 3. 한명 조회 4. 과목별 평균 조회 5. 학생별 평균 조회 6. 종료\n");
	scanf_s("%d", &menu);
	}
	return 0;
}

void add(void) {
	printf("***********************************************\n");
	printf("이름을 입력하세요 : ");
	scanf_s(" %c", &stu[index][0], 1);
	printf("c점수 : ");
	scanf_s("%d", &stu[index][1]);
	printf("파이썬 점수 : ");
	scanf_s("%d", &stu[index][2]);
	printf("라즈베리파이점수 : ");
	scanf_s("%d", &stu[index][3]);
	printf("안드로이드 점수 : ");
	scanf_s("%d", &stu[index][4]);
	index++;
	
}
void viewall() {
	printf("***********************************************\n");
	int i = 0;
	for (i; i < index; i++) {
		printf("%c %d %d %d %d\n", stu[i][0], stu[i][1], stu[i][2], stu[i][3], stu[i][4]);
	}
}
void viewone(char name) {
	printf("***********************************************\n");
	int i = 0;
	for (i; i < index; i++) {
		if (stu[i][0] == name) {
			printf("%c %d %d %d %d\n", stu[i][0], stu[i][1], stu[i][2], stu[i][3], stu[i][4]);
		}
	}
}
void subavg(void) {
	printf("***********************************************\n");
}
void stuavg(void){
	printf("***********************************************\n");
}







