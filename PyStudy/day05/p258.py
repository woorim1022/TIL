# 파이썬이 제공한 패키지를 import
# random 패키지 안에 randint라는 함수를 import
# 컨트롤 누르고 random 누르면 random 패키지 볼 수 있음
from random import randint;
import myutil1 as m1; # 내가 작성한 것을 import
import myutil2 as m2;

a = 100;
b = randint(1,10);
print(a,b);
print(m1.sum(a,b));
print(m2.sum(a,b));