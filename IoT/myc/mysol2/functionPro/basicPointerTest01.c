#include <stdio.h>

//다양한 타입의 포인터 변수
int main_fpt()
{
	char chdata = 'A'; //1byte
	int indata = 100; // 4byte
	double doubledata = 20.5; //8byte

	char* pchardata = &chdata; //캐릭터타입의 변수가 할당된 주소를 가리키고 있는 포인터변수(포인터변수의 타입의 캐릭터라는것이 아님)
	int* pintdata = &indata;	//
	double* pdoubledata = &doubledata;	//

	printf("char변수, int변수, double변수의 크기 : %d %d %d\n", sizeof(chdata), sizeof(indata), sizeof(doubledata));
	printf("char*변수의 크기 : %d\n", sizeof(pchardata));
	printf("int*변수의 크기 : %d\n", sizeof(pintdata));
	printf("double*변수의 크기 : %d\n", sizeof(pdoubledata));

	printf("char*변수가 가리키고 있는 주소에 저장되어 있는 값의 크기 : %d\n", sizeof(*pchardata));
	printf("int*변수가 가리키고 있는 주소에 저장되어 있는 값의 크기 : %d\n", sizeof(*pintdata));
	printf("double*변수가 가리키고 있는 주소에 저장되어 있는 값의 크기 : %d\n", sizeof(*pdoubledata));

	return 0;
}
