#include <stdio.h>

int main_s()
{
	int gender = 0;
	printf("������ �Է��ϼ���:");
	scanf_s("%d", &gender);
	//�Ǵܱ����� �Ǵ� �������̳� ��
	//switch()�ȿ� �� �� �ִ� ���� �ݵ�� ���������� ��� - int, char
	switch (gender)
	{
	case 1: // gender �� �� case�� ������ ���� ==������ ����
		printf("����");
		break;
	case 2:
		printf("����");
		break;
	case 3:
		printf("����");
		break;
	case 4:
		printf("����");
		break;
	default:
		break;
	}
	return 0;
}