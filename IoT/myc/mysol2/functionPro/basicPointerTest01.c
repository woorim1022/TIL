#include <stdio.h>

//�پ��� Ÿ���� ������ ����
int main_fpt()
{
	char chdata = 'A'; //1byte
	int indata = 100; // 4byte
	double doubledata = 20.5; //8byte

	char* pchardata = &chdata; //ĳ����Ÿ���� ������ �Ҵ�� �ּҸ� ����Ű�� �ִ� �����ͺ���(�����ͺ����� Ÿ���� ĳ���Ͷ�°��� �ƴ�)
	int* pintdata = &indata;	//
	double* pdoubledata = &doubledata;	//

	printf("char����, int����, double������ ũ�� : %d %d %d\n", sizeof(chdata), sizeof(indata), sizeof(doubledata));
	printf("char*������ ũ�� : %d\n", sizeof(pchardata));
	printf("int*������ ũ�� : %d\n", sizeof(pintdata));
	printf("double*������ ũ�� : %d\n", sizeof(pdoubledata));

	printf("char*������ ����Ű�� �ִ� �ּҿ� ����Ǿ� �ִ� ���� ũ�� : %d\n", sizeof(*pchardata));
	printf("int*������ ����Ű�� �ִ� �ּҿ� ����Ǿ� �ִ� ���� ũ�� : %d\n", sizeof(*pintdata));
	printf("double*������ ����Ű�� �ִ� �ּҿ� ����Ǿ� �ִ� ���� ũ�� : %d\n", sizeof(*pdoubledata));

	return 0;
}
