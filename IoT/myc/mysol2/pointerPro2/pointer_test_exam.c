#include <stdio.h>

void printexam(char**, int);

int main_asdfasfsdafsafsadf()
{
	//myarr = {char*, char*, char*};
	//�ּҴ� 4byte�� �����
	char* myarr[] = { "c programming", "python", "raspberry PI", "andr" };
	//�迭�� ����� ���� ����
	int count = sizeof(myarr)/sizeof(myarr[0]);
	printexam(&myarr, count);
	return 0;
}
//myarr�� �Ű������� �޾Ƽ� ���� ����ϱ� - ���������ͷ� ���� printexam
// ���ڿ� ����ϱ�

void printexam(char** myarr,int count) {
	for (int i = 0; i < count; i++) {
		printf("%s\n", myarr[i]);
	}
}