#include <stdio.h>

int main_asdfasdf()
{
	char str[80];
	printf("���ڿ� �Է�:");
	//scanf_s�� ���ڿ��� �Է¹��� ���� ������ ���� ���ӵ� ���ڸ� �Է¹޴´�.
	//scanf_s�� ���۸� ����Ѵ�. ���۴� Ű����� �Է¹��� ���ڿ��� �����ϴ� �޸�
	scanf_s("%s", str, sizeof(str));
	printf("���ڿ� ��� : %s\n", str);
	printf("���ڿ� �Է�:");
	scanf_s("%s", str, sizeof(str));
	printf("���ڿ� ��� : %s\n", str);
	return 0;
}

