#include <stdio.h>
#include <stdbool.h>

//booleanŸ��
int main_b()
{
	printf("%d\n", sizeof(_Bool));
	_Bool b1;//
	b1 = 0; // false
	b1 = 1; // true
	printf("%d\n", b1);

	//stdbool.h �߰��߱� ������ true/false �־��� �� ����, ���������δ� 0/1�� ó��
	bool b2, b3;
	b2 = true;
	b3 = false;
	printf("%d%d\n", b2, b3);
	return 0;
}