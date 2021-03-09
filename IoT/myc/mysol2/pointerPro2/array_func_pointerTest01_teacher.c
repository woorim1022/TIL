#include <stdio.h>

int main_adfssafsf()
{
	int num = 100;
	int* p_num; // 포인터변수
	//**의 의미 => 1번 *의 의미 현재 내가 선언하려고 하는 변수의 타입을 의미
	//            p_p_num 변수에 할당될 변수의 타입이 int*
	//			  2번 *의 의미는 p_p_num 변수가 포인터변수임을 의미
	int** p_p_num;// 이중 포인터 - 포인터 변수의 주소를 저장

	p_num = &num;// 포인터 변수에 int변수의 주소를 저장
	p_p_num = &p_num; // 포인터 변수 주소를 이중 포인터변수에 저장
	printf("num:%d, num의 주소:%p\n", num, &num);
	printf("p_num에 할당된 주소(&num) :%p\np_num에 저장된 주소에 있는 값(num) :%d\n", p_num, *p_num);		 // &num, num
	printf("실제 p_num의 주소(&p_num) :%p\n", &p_num);												 // &p_num
	printf("p_p_num에 할당된 주소(&p_num) :%p\np_p_num에 저장된 주소에 있는 값(&num) :%p\n", p_p_num, *p_p_num);// &p_num, &num
	printf("실제 p_p_num의 주소(&p_p_num) :%p\n", &p_p_num);											 // &p_p_num
	printf("참조하는 값(num) :%d\n", **p_p_num);											 // &p_p_num

	return 0;
}
