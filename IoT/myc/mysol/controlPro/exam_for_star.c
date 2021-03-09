#include <stdio.h>

//for_muilti
int main_ss()
{
	int i = 0, row = 0;
	for (i = 5; i >= 1; i--) {
		for (int j = 0; j < i; j++)
			printf("*");
		printf("\n");
		
	}
	return 0;
}