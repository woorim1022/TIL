#include <stdio.h>

int main_s()
{
	int gender = 0;
	printf("성별을 입력하세요:");
	scanf_s("%d", &gender);
	//판단기준이 되는 변수명이나 식
	//switch()안에 올 수 있는 값은 반드시 정수형으로 명시 - int, char
	switch (gender)
	{
	case 1: // gender 와 각 case에 정의한 값과 ==연산을 수행
		printf("남자");
		break;
	case 2:
		printf("여자");
		break;
	case 3:
		printf("남자");
		break;
	case 4:
		printf("여자");
		break;
	default:
		break;
	}
	return 0;
}