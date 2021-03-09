#include <stdio.h>

int main_asdfadsfsaf()
{
	//문자열은 char 배열로 관리
	//1. 문자열은 컴파일과정에서 첫 번째 문자의 주소로 바뀐다.
	//2. 컴파일러는 문자열을 char 배열에 따로 보관
	//3. char 변수의 주소 바뀌므로 직접 포인터 연산을 할 수 있다.
	//4. 배열처럼 접근할 수 있다. 단, 배열처럼 직접 문자열을 바꿀 수 없다(상수이기 때문에)
		//문자열상수의 경우 읽기 전용 메모리에 저장되기 때문에 수정할 수 없다.
		//ch[0] = 'A' ---> X

	//첫번째 문자가 할당된 주소, 문자열 출력
	printf("주소값:%p,%s\n", "c programming", "c programming");
	//"c programming" 자체가 포인터 변수, *를 붙이면 배열 첫번째 요소를 가져온다
	printf("char 배열의 첫 번째 요소 : %c\n", *"c programming");
	//포인터 연산
	printf("주소값: %p, 세 번째 문자 : %c\n", "c programming" + 2,*("c programming"+2));
	printf("네 번째 문자:%c\n", "c programming"[3]);

	//문자열을 수정
	char* mydata = "c programming";
	printf("mydata:%s\n", mydata);

	mydata = "java programming";
	printf("mydata:%s\n", mydata);



	return 0;
}

