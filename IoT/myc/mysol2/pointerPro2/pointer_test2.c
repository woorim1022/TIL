#include <stdio.h>

void print_test(char**, char**);

int main_asdfsadfdsfsd()
{
	char* p_data1 = "c programming";
	char* p_data2 = "raspberry PI";
	printf("p_data1 : %s, p_data2 : %s\n", p_data1, p_data2);
	printf("p_data1 : %c, p_data2 : %c\n", *p_data1, *p_data2);
	printf("p_data1 : %p, p_data2 : %p\n", p_data1, p_data2); // p_data1�� �Ҵ�� �ּ�
	printf("p_data1 : %s, p_data2 : %s\n", *(&p_data1), *(&p_data2)); 
	printf("p_data1 : %p, p_data2 : %p\n", *(&p_data1), *(&p_data2));
	printf("p_data1 : %p, p_data2 : %p\n", &p_data1, &p_data2);  // p_data1�� �ּ�
	
	//�Ű������� ���ڿ��� �ּҸ� �ѱ�� �ȵǰ� p_data1�� �ּҸ� �Ѱܾ� �Ѵ�, ���ڿ��� readonly
	print_test(&p_data1,&p_data2);
	return 0;
}

void print_test(char** p_args1,char** p_args2) {
	char* temp;
	temp = *p_args1;
	*p_args1 = *p_args2;
	*p_args2 = temp;
	printf("�Լ� ����\n");
	printf("%s %s\n", *p_args1, *p_args2);
}