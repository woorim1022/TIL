#include <stdio.h>

int main_adfafsf()
{
	//���� ������ �����ͺ����� ǥ���� �� ��� => �����͹迭
	char* p_arr[3];// �����͹迭
	p_arr[0] = "IoT";
	p_arr[1] = "raspberry PI";
	p_arr[2] = "c";
	for (int i = 0; i < 3; i++) {
		printf("%s\n", p_arr[i]);
	}
	for (int i = 0; i < 3; i++) {
		printf("%s\n", *(p_arr + i));
	}
	return 0;
}

