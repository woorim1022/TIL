# map

def mymap(n):
    # 파이썬은 정수 / 정수 = 실수
    return n / 2;

score = [90, 80, 60, 100];

for i in map(mymap, score):
    print(i);

print('--------------------------------');

# score에 있는 각각의 값을 연산해서 출력
for i in map(lambda x:x/3,score):
    print(i);