#include <stdio.h>

//for_muilti
int main_fm()
{
	int i = 0, row = 0;
	for (i = 1; i <= 5; i++) {
		for(int j = 0; j < 5; j++)
			printf("*\t");
		printf("\n");
	}

	return 0;
}