#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

//�Ű����� �ְ�, ���ϰ��� �ִ� �Լ��� ����
int calc(int price, int age) {
	if (age >= 20)
		return price;
	else
		return price * 0.7;
}

int main() {
	int price = 10000;
	int age = 0;
	printf("���� : ");
	scanf("%d", &age);
	float result = calc(price, age);
	printf("�⺻����� %.0f�� �Դϴ�.", result);
	return 0;
}