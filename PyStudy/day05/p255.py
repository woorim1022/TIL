# 파이썬 변수 전달 : 단순변수

a = 10;

# 전역변수 a 와 함수 안의 a(지역변수)는 다른 변수다
def f1(a):
    a += 5;
    return a;

b = f1(6);

print(a);
print(b);
if a == b:
    print('ok1');
if a is b:
    print('ok2');