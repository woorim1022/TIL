#include <stdio.h>

int main_asdfadsfsaf()
{
	//���ڿ��� char �迭�� ����
	//1. ���ڿ��� �����ϰ������� ù ��° ������ �ּҷ� �ٲ��.
	//2. �����Ϸ��� ���ڿ��� char �迭�� ���� ����
	//3. char ������ �ּ� �ٲ�Ƿ� ���� ������ ������ �� �� �ִ�.
	//4. �迭ó�� ������ �� �ִ�. ��, �迭ó�� ���� ���ڿ��� �ٲ� �� ����(����̱� ������)
		//���ڿ������ ��� �б� ���� �޸𸮿� ����Ǳ� ������ ������ �� ����.
		//ch[0] = 'A' ---> X

	//ù��° ���ڰ� �Ҵ�� �ּ�, ���ڿ� ���
	printf("�ּҰ�:%p,%s\n", "c programming", "c programming");
	//"c programming" ��ü�� ������ ����, *�� ���̸� �迭 ù��° ��Ҹ� �����´�
	printf("char �迭�� ù ��° ��� : %c\n", *"c programming");
	//������ ����
	printf("�ּҰ�: %p, �� ��° ���� : %c\n", "c programming" + 2,*("c programming"+2));
	printf("�� ��° ����:%c\n", "c programming"[3]);

	//���ڿ��� ����
	char* mydata = "c programming";
	printf("mydata:%s\n", mydata);

	mydata = "java programming";
	printf("mydata:%s\n", mydata);



	return 0;
}

