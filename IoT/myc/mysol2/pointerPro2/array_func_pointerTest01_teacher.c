#include <stdio.h>

int main_adfssafsf()
{
	int num = 100;
	int* p_num; // �����ͺ���
	//**�� �ǹ� => 1�� *�� �ǹ� ���� ���� �����Ϸ��� �ϴ� ������ Ÿ���� �ǹ�
	//            p_p_num ������ �Ҵ�� ������ Ÿ���� int*
	//			  2�� *�� �ǹ̴� p_p_num ������ �����ͺ������� �ǹ�
	int** p_p_num;// ���� ������ - ������ ������ �ּҸ� ����

	p_num = &num;// ������ ������ int������ �ּҸ� ����
	p_p_num = &p_num; // ������ ���� �ּҸ� ���� �����ͺ����� ����
	printf("num:%d, num�� �ּ�:%p\n", num, &num);
	printf("p_num�� �Ҵ�� �ּ�(&num) :%p\np_num�� ����� �ּҿ� �ִ� ��(num) :%d\n", p_num, *p_num);		 // &num, num
	printf("���� p_num�� �ּ�(&p_num) :%p\n", &p_num);												 // &p_num
	printf("p_p_num�� �Ҵ�� �ּ�(&p_num) :%p\np_p_num�� ����� �ּҿ� �ִ� ��(&num) :%p\n", p_p_num, *p_p_num);// &p_num, &num
	printf("���� p_p_num�� �ּ�(&p_p_num) :%p\n", &p_p_num);											 // &p_p_num
	printf("�����ϴ� ��(num) :%d\n", **p_p_num);											 // &p_p_num

	return 0;
}
