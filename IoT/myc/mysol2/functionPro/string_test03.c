#include <stdio.h>
#include <string.h>

int main_Adsfsadg()
{
	char str1[100], str2[50];
	char* result;
	printf("������ �� �� �Է��ϼ���:");
	scanf_s("%s%s", str1, sizeof(str1), str2, sizeof(str2));
	if (strlen(str1) > strlen(str2)) {
		result = str1;
	}
	else {
		result = str2;
	}
	printf("%s", result);
	return 0;
}

