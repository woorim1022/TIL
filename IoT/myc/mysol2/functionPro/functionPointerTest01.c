#include <stdio.h>
//�����͸� ����ϴ� ���� ������� �ʴ� ��츦 ��


//�Լ� �����
void display(int);
void change(int);
void pointerChange(int*);

//�پ��� Ÿ���� ������ ����
int main_fptest()
{
	//�����Լ����� �ٸ� �Լ��� �����ϰ� ���� ��
	//�����Լ� �ȿ� ���ǵǾ� �ִ� �����Լ� ��
	int main_num = 100;
	//call by value : �Ű������� ���� ����
	//main_num �� ����� ���� �Ѿ��
	display(main_num);
	change(main_num);
	printf("%d\n", main_num);
	pointerChange(&main_num);
	printf("%d\n", main_num);
	return 0;
}

//�Լ� ���Ǻ�
void display(int num) { // num�̶�� �Ű������� display ���ο� ����� ��������
	printf("����: %d\n", num);
}

void change(int num) { // num�̶�� �Ű������� display ���ο� ����� ��������
	num = 200;
}

void pointerChange(int* num) { //call by reference
	*num = 300;
}