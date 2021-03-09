#include <stdio.h>

void print_test(char**, char**);

int main_asdfsadfdsfsd()
{
	char* p_data1 = "c programming";
	char* p_data2 = "raspberry PI";
	printf("p_data1 : %s, p_data2 : %s\n", p_data1, p_data2);
	printf("p_data1 : %c, p_data2 : %c\n", *p_data1, *p_data2);
	printf("p_data1 : %p, p_data2 : %p\n", p_data1, p_data2); // p_data1에 할당된 주소
	printf("p_data1 : %s, p_data2 : %s\n", *(&p_data1), *(&p_data2)); 
	printf("p_data1 : %p, p_data2 : %p\n", *(&p_data1), *(&p_data2));
	printf("p_data1 : %p, p_data2 : %p\n", &p_data1, &p_data2);  // p_data1의 주소
	
	//매개변수로 문자열의 주소를 넘기면 안되고 p_data1의 주소를 넘겨야 한다, 문자열은 readonly
	print_test(&p_data1,&p_data2);
	return 0;
}

void print_test(char** p_args1,char** p_args2) {
	char* temp;
	temp = *p_args1;
	*p_args1 = *p_args2;
	*p_args2 = temp;
	printf("함수 내부\n");
	printf("%s %s\n", *p_args1, *p_args2);
}