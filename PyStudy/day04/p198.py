score = []; # 아무것도 없는 리스트
# score1 = ['James',10,20,30,40]; # 가능하지만 생각x
score1 = [10,20,30,40];
print(score1[1:3]); # 리스트를 잘라내도 리스트

print('-------------------------')

sum = 0;
for i in score1:
    print(i);
    sum += i;

print('-------------------------')

print('Result: %d %10.2f'% (sum,sum/len(score1)));

print('-------------------------')

score2 = [[1,2,3,4],[5,6,7,8],[9,10,11,12]];    # 리스트 안에 리스트
# print(score2[1][3]);

###외우기#################################################################
####################################################################
for i1 in score2:
    for i2 in i1:
        print(i2,end=',');
    print();
####################################################################
####################################################################


print('-------------------------')


###외우기#################################################################
####################################################################
# 각 리스트의 합 평균을 출력하고
# 전체 합과 평균을 출력
total = 0;
totalcnt = 0;
for i1 in score2:
    sum1 = 0;
    for i2 in i1:
        sum1 += i2;
    print('합: %d 평균: %.1f' % (sum1, sum1 / len(i1)));
    total += sum1;
    totalcnt += len(i1);
print('합: %d 평균: %.1f' % (total, total/totalcnt));
####################################################################
####################################################################
