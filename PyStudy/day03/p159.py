# 지역변수 : 함수 안에서 선언한 변수
# 전역변수 : 프로그램 전체에서 사용 가능한 변수(프로그램 종료 전까지 메모리에 올라가있음)

data=20;
def calcsum(n):
    sums = 0;
    for d in range(n+1):
        sums += d;
    return sums+data; # d = 10, d의 범위는 함수 전체

result = calcsum(10);
print(result);