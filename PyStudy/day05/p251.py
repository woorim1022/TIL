# 메모리에 변수들이 어떻게 저장되는지 알아보자

a = 1;
b = a;
print('a:%d b:%d' % (a,b));

a = 5;
print('a:%d b:%d' % (a,b));

list1 = [1,2,3,4];
list2 = list1;
list3 = list1.copy();

print(list1);
print(list2);

print('-------------------------------');
list1[0] = 100;
print(list1);
print(list2);
print(list3);
