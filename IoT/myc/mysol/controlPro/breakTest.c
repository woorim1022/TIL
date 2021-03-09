#include <stdio.h>

//break
//continue
int main_sssss()
{
	int i = 0;
	for (i=0; i <= 10; i++) {
		if (i == 5) {
			break;
		}
		printf("i=%d\n", i);
	}

	for (i=0; i <= 10; i++) {
		if (i == 5) {
			continue;
		}
		printf("i=%d\n", i);
	}
	return 0;
}