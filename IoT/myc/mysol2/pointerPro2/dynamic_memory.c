#include <stdio.h>
#include <stdlib.h>

int main_dm()
{
	int* plist = NULL;

	//malloc���ϰ� - ���� �Ҵ�� �޸𸮿��� �� ù ��° ����Ʈ�� �ּ�(void*)
	//malloc �Ű����� - ��û�� �޸��� ������(����Ʈ����)
	plist = malloc(sizeof(int)); // 12
	plist[0] = 10;
	plist[1] = 20;
	plist[2] = 30;

	//�������� �Ҵ���� �޸� ������ ����� ���α׷��� ��(�� ����� �޸��� ��迡 ���� �����..��), �޸� �ݳ� �� ���� �߻�
	//*(((char*)plist) + 12) = 'A';

	free(plist);
	return 0;
}









