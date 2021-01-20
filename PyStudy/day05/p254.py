# is 연산자
# 파이썬은 같은 값은 같은 메모리를 공통적으로 사용
# 아두이노, 라즈베리파이 같은 메로리가 작은 시스템에서 효율적으로
# 사용하기 위해 하나의 값에 대해서는 유니크한 공간을 사용한다.
a = 1;
b = a;
c = 1;

# 값이 똑같다
# == : 값을 비교
if(a == b):
    print('OK1');

# b = 10;
# 메모리의 주소가 똑같다
# is : 메모리의 위치를 비교
if(a is b):
    print('OK2');

# 값이 똑같다
if(a == c):
    print('OK3');

# 메모리의 주소가 똑같다
if(a is c):
    print('OK4');


a = 2;

# 값이 다르다
if(a == b):
    print('OK1');

# 메모리의 주소가 다르다
if(a is b):
    print('OK2');

# 값이 다르다
if(a == c):
    print('OK3');

# 메모리의 주소가 다르다
if(a is c):
    print('OK4');




print('---------------------')

d1 = [1,2,3];
d2 = d1;
d3 = d1.copy();

# 값이 똑같다
if(d1 == d2):
    print('list ok1');

# 메모리의 주소가 똑같다
if(d1 is d2):
    print('list ok2');

# 값이 똑같다
if(d1 == d3):
    print('list ok3');

# 메모리의 주소가 다르다
if(d1 is d3):
    print('list ok4');