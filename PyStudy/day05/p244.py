score = [90,80,60,100];
# sort() 변수의 메모리는 그대로 두고 순서만 바꾸는 함수
score.sort(reverse=True);
print(score);

print('------------------------------------')

# sorted() 새로운 리스트를 만드는 함수
score2 = sorted(score, reverse=True);
print(score2);

print('------------------------------------')

# enumerate(a,1) 순서 지정, 1부터 시작, 튜플
# 활용 예 : 순위 매길 때 사용
for i in enumerate(score2,1):
    print(type(i), sep=' ');

