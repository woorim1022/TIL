//#include <stdio.h>
//#include <stdlib.h>
//
//char stu[50][5] = { {0} };
//int index = 0;
//
//void add(void);
//void viewall(void);
//void viewone(char);
//void subavg(void);
//void stuavg(void);
//
//int main_adadasdas()
//{
//	//�л�����ý���
//	// 1. �л��߰�
//	//		�̸�
//	//		c ����
//	//      ���̽�����
//	//      �������������
//	//      �ȵ���̵� ����
//	// 2. ��ü��ȸ
//	// 3. �̸����� �˻��� ��ȸ
//	// 4 ���� ��� ��ȸ
//	// 5. �л��� ��� ��ȸ
//	int menu = 0;
//	char name = 0;
//	printf("****************************�л���� �ý���********************************\n");
//	printf(" 1. �л��߰� 2. ��ü�л� ��ȸ 3. �Ѹ� ��ȸ 4. ���� ��� ��ȸ 5. �л��� ��� ��ȸ 6. ����\n");
//	scanf_s("%d", &menu);
//	while (menu != 6) {
//		switch (menu)
//		{
//		case 1:
//			add();
//			break;
//		case 2:
//			viewall();
//			break;
//		case 3:
//			printf("�˻��� �л����� �Է��ϼ��� : ");
//			scanf_s(" %c", &name, 1);
//			viewone(name);
//			break;
//		case 4:
//			subavg();
//			break;
//		case 5:
//			stuavg();
//			break;
//		case 6:
//			break;
//		default:
//			printf("�ٽ� �Է��ϼ���");
//			break;
//		}
//		printf("****************************�л���� �ý���********************************\n");
//		printf(" 1. �л��߰� 2. ��ü�л� ��ȸ 3. �Ѹ� ��ȸ 4. ���� ��� ��ȸ 5. �л��� ��� ��ȸ 6. ����\n");
//		scanf_s("%d", &menu);
//	}
//	return 0;
//}
//
//void add(void) {
//	printf("**************************************************************************\n");
//	printf("�̸��� �Է��ϼ��� : ");
//	scanf_s(" %c", &stu[index][0], 1);
//	printf("c���� : ");
//	scanf_s("%d", &stu[index][1]);
//	printf("���̽� ���� : ");
//	scanf_s("%d", &stu[index][2]);
//	printf("������������� : ");
//	scanf_s("%d", &stu[index][3]);
//	printf("�ȵ���̵� ���� : ");
//	scanf_s("%d", &stu[index][4]);
//	index++;
//
//}
//void viewall() {
//	printf("**************************************************************************\n");
//	int i = 0;
//	for (i; i < index; i++) {
//		printf("%c %d %d %d %d\n", stu[i][0], stu[i][1], stu[i][2], stu[i][3], stu[i][4]);
//	}
//}
//void viewone(char name) {
//	printf("**************************************************************************\n");
//	int i = 0;
//	for (i; i < index; i++) {
//		if (stu[i][0] == name) {
//			printf("%c %d %d %d %d\n", stu[i][0], stu[i][1], stu[i][2], stu[i][3], stu[i][4]);
//		}
//	}
//}
//void subavg(void) {
//	printf("**************************************************************************\n");
//	int i = 0;
//	int c = 0, py = 0, ra = 0, an = 0;
//	for (i; i < index; i++) {
//		c += stu[i][1];
//		py += stu[i][2];
//		ra += stu[i][3];
//		an += stu[i][4];
//	}
//	printf("c���: %d\n", c / index);
//	printf("python���: %d\n", py / index);
//	printf("raspberry Pi���: %d\n", ra / index);
//	printf("android���: %d\n", an / index);
//}
//void stuavg(void) {
//	printf("**************************************************************************\n");
//	int i = 0;
//	int sum = 0;
//	for (i; i < index; i++) {
//		sum = 0;
//		printf("%d\n", stu[i][1]);
//		printf("%d\n", stu[i][2]);
//		printf("%d\n", stu[i][3]);
//		printf("%d\n", stu[i][4]);
//		sum += stu[i][1] + stu[i][2] + stu[i][3] + stu[i][4];
//		printf("�л� %c ��ü���� ���: %.1lf\n", stu[i][0], sum/4.0);
//	}
//}
//
//
//
//
//
//