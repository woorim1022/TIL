#include <stdio.h>
//포인터를 사용하는 경우와 사용하지 않는 경우를 비교


//함수 선언부
void display(int);
void change(int);
void pointerChange(int*);

//다양한 타입의 포인터 변수
int main_fptest()
{
	//메인함수에서 다른 함수에 공유하고 싶은 값
	//메인함수 안에 정의되어 있는 지역함수 값
	int main_num = 100;
	//call by value : 매개변수로 값을 전달
	//main_num 에 저장된 값만 넘어간다
	display(main_num);
	change(main_num);
	printf("%d\n", main_num);
	pointerChange(&main_num);
	printf("%d\n", main_num);
	return 0;
}

//함수 정의부
void display(int num) { // num이라는 매개변수는 display 내부에 선언된 지역변수
	printf("숫자: %d\n", num);
}

void change(int num) { // num이라는 매개변수는 display 내부에 선언된 지역변수
	num = 200;
}

void pointerChange(int* num) { //call by reference
	*num = 300;
}