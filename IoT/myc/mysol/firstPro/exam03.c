#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//매개변수 있고, 리턴값도 있는 함수의 정의
int calc(int price, int age) {
	if (age >= 20)
		return price;
	else
		return price * 0.7;
}

int main() {
	int price = 10000;
	int age = 0;
	printf("나이 : ");
	scanf("%d", &age);
	float result = calc(price, age);
	printf("기본요금은 %.0f원 입니다.", result);
	return 0;
}