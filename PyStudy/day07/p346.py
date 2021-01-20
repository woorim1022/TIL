# 실수를 2진수로 표현하면 길어진다는 문제 발생
import math
from array import array
from decimal import Decimal
from fractions import Fraction

n = 0.1;
n = Decimal(str(n))
sum = 0;
for i in range(10):
    sum += n;
print(sum);


result = 1/3;

result = round(result,3);
print(result);

# Fraction() : 표현방법을 정해줌 (분수/소수)
resultf1 = Fraction(1,3);
resultf2 = Fraction(1,4);
print(resultf1 + resultf2 + 0.0);


# array : 리스트, 튜플, 셋 보다 빠르다다다다다다
# 코테에서 리스트사용하지 말고 꼭 배열 사용하자 꼭꼭꼭

# i : 부호가 있는 2바이트의 정수
# 2바이트 -> 16비트 -> ex) 0101 1111 1110 1100
ar = array('i',[1,2,3,6,5,4,3]);
ar[1] = 100;
ar.append(200);
del ar[0];
ar = ar[3:5];
for i in ar:
    print(i, end=',');