#(arguments), 리스트의 합을 구하는 함수
# n에 어떤 타입의 변수를 넣는지에 따라
# n의 타입이 달라짐(스크립트 언어이기 때문에)
# 따라서, 변수에 대한 설명이 필요함
#calcsum : argument
#sum : return값

#모든 함수에서 사용할 수 있는 전역변수
data=100;

def calcsum(n):
    sum = 0;
    for d in n:
        sum += d;
    return sum;

#argument가 없는 함수
def f1():
    data = 100;
    return data;

#sum을 정수로 선언했는데 리턴값은 실수
def f2(s,e):
    sum = 0;
    for data in range(s, e+1):
        sum += data;
    return sum / (e-s+1);

#이름이 같은 두 개의 함수를 선언해도 에러가 나지 않음
def f3(s,e):
    sum = 0;
    for data in range(s, e+1):
        sum += data;
    print('Result: ');
    print( sum / (e-s+1) );

# 가변 인수 : 고정되지 않은 임의 개수의 인수를 받음
# 가변 인수는 tuple타입(리스트와 달리 값을 변경할 수 없는 타입)
def f4(*n):
    sum = 0;
    for d in n:
        sum += d;
    return sum;

def f5(m,*n):
    sum = 0;
    for d in n:
        sum += d;
    return sum+m;

# step : 얼만큼씩 증가할지 알려줌
# 인수에 기본값 지정
def f6(begin=1,end=2,step=1):
    """ begin:start data ... default value = 1
        ,,,,,
     """
    sum = 0;
    for d in range(begin, end+1, step):
        sum += d;
    return sum;

# f7() 함수를 사용하기 위해 함수가 요구하는 인자를 알맞게 넣어주어야 한다.
# 꼭 args일 필요 없으나 통상적으로 args라고 이름짓는다
def f7(**args):
    begin = args['begin'];
    end = args['end'];
    step = args['step'];
    sum = 0;
    for d in range(begin, end + 1, step):
        sum += d;
    return sum;

def f8(n, *m, **args):
    print('TEST');
    print(n);
    print(m);
    print(args);

#파이썬은 자바, C언어에 비해 함수의 구조가 자유롭다.