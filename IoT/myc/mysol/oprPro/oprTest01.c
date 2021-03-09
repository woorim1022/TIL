//#include <stdio.h>
//
//int main() {
//	int a;
//	a = 3;
//	char ch = 'A';
//	//int a = 3;
//	//l-value = r-value
//	//left, location = right
//	printf("%c\n", ch+1);
//	printf("%c\n", 'A' + 2);
//
//	//double int 의 연산
//	//8 4 double 형식으로 연산하므로 %d는 사용할 수 없다.
//	//연산의 결과가 표현범위가 넓은 형식으로 변환되는 현상을 type promotion이라 한다.
//	printf("%d\n", 5.0 + 2);
//	printf("%f\n", 5.0 + 2);
//
//	int num = 10;
//	printf("%d\n", num * 10);
//	// int * double => double 연산이므로 %d로 표현할 수 없다.
//	printf("%d\n", num * 10.0);
//	printf("%f\n", num * 10.0);
//
//	//int / int => int연산 -> 몫
//	printf("%d\n", num / 2);
//	printf("%d\n", num / 3);
//
//
//	printf("%몫 : %d\n", 5 / 2);
//	printf("%나머지 : %d\n", 5 % 2);
//	return 0;
//}