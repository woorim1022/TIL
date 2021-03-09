//#include <stdio.h>
//
////shortcircuit(쇼트서킷)
//int main() {
//	int python_jumsu = 0, c_jumsu = 0;
//	printf("파이썬점수를 입력:");
//	scanf_s("%d", &python_jumsu);
//	printf("c점수를 입력:");
//	scanf_s("%d", &c_jumsu);
//
//	//쇼트서킷
//	//하지 않아도 되는 연산을 생략해서 논리연산을 할 때 효율을 높이는 것을 의미
//	//1. 논리연산은 무조건 왼쪽에서 오른쪽으로 진행
//	//2. OR 논리식은 조건에 만족하면 이후 연산을 생략
//	//3. AND 논리식은 조건에 만족하지 않으면 이후 연산을 생략
//	printf("결과(1=>합격, 0=>불합격)%d\n", 
//			python_jumsu>80 && python_jumsu<=90 && c_jumsu>=90);
//	return 0;
//}