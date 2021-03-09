//#include <stdio.h>
//
////논리연산자, 삼항연산자
//int main() {
//	int inputNum = 0, result = 0, result2 = 0, result3 = 0, result4 = 0, result5 = 0;
//	printf("숫자입력: ");
//	scanf_s("%d", &inputNum);
//	// ||연산자(or연산자 - 조건을 한 개만 만족하면 True)
//	result = inputNum < 5 || inputNum >= 50;
//
//	// && 연산자(and 연산자 - 조건을 모두 만족해야 한다.)
//	result2 = inputNum >= 5 && inputNum < 50;
//
//	result3 = 10 < inputNum < 30;
//
//	result4 = !0;
//
//	//조건?A
//	//조건을 검사해서 조건이 참이면 A를 거짓이면 B를 선택 지정
//	result5 = inputNum > 100 ? 1000: 2000;
//	printf("||연산결과=>%d\n", result);
//	printf("&&연산결과=>%d\n", result2);
//	printf("3연산결과=>%d\n", result3);
//	printf("NOT연산결과=>%d\n", result4);
//	printf("삼항연산자 연산결과=>%d\n", result5);
//	return 0;
//}