# 튜플(소괄호)
# 튜플은 변경이 불가능(리스트는 가능)
# 리스트와 튜플은 중복된 값이 들어갈 수 있음
import random;

score = (10,20,30,40);
print(type(score));
print(score[0:2]);
# score[0] = 99;

print('--------------------------------------')

score = score + (50,60,70);
print(score);

print('--------------------------------------')

t = [];
for i in range(0,6):
    temp = random.randint(1,3);
    t.append(temp)
print(t);

print('--------------------------------------')
# 리스트를 튜플로 변경
tp = tuple(t);
print(tp);

# 튜플을 리스트로 변경
scorelist = list(score);
print(scorelist)

print('--------------------------------------')

