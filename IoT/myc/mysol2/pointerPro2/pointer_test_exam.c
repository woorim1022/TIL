#include <stdio.h>

void printexam(char**, int);

int main_asdfasfsdafsafsadf()
{
	//myarr = {char*, char*, char*};
	//주소는 4byte에 저장됨
	char* myarr[] = { "c programming", "python", "raspberry PI", "andr" };
	//배열의 요소의 수를 저장
	int count = sizeof(myarr)/sizeof(myarr[0]);
	printexam(&myarr, count);
	return 0;
}
//myarr를 매개변수로 받아서 값을 출력하기 - 이중포인터로 선언 printexam
// 문자열 출력하기

void printexam(char** myarr,int count) {
	for (int i = 0; i < count; i++) {
		printf("%s\n", myarr[i]);
	}
}