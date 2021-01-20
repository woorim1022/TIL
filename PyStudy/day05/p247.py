# filter

def myFilter1(n):
    # n이 90 보다 크거나 같을 때만 리턴, 작으면 리턴하지 않음
    return n >= 90;

def myFilter2(n):
    # n이 90 보다 크거나 같을 때만 리턴, 작으면 리턴하지 않음
    return n >= 80;

score = [90, 80, 60, 100];

# for i in score:
    # if i >= 90:
# 리스트를 필터링해서 끄집어 내겠다는 의미
for i in filter(myFilter2, score):
    print(i);

print('---------------------------------------');
# 람다 : 이름 없고 입력과 출력만으로 함수 정의하는 축약된 방법

for i in filter(lambda x:x>=90, score):
    print(i);