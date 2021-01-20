import random;

# 당첨 번호(전역변수)
answer = [];
# 상금(전역변수)
money = [0, 0, 0, 0, 0];

# 당첨 번호 생성 함수
def makeAnswer(a):
    for i in range(1, 7):
        num = random.randint(1, int(a));
        while num in answer:  # answer가 lotto에 이미 존재하면,(중복되면)
            num = random.randint(1, int(a));  # 숫자 다시뽑자
        answer.append(num);
    # print('당첨번호: %s' % (answer));

# 로또번호와 당첨번호 비교 함수
def compareNum(choice):
    answerCnt = 0;
    choice = choice.split(' ');
    print('입력한 로또번호: %s, %s, %s, %s, %s, %s' % (choice[0],
                                                 choice[1],
                                                 choice[2],
                                                 choice[3],
                                                 choice[4],
                                                 choice[5]));
    print();
    for i in range(0,6):
        for j in range(0,6):
            if answer[i] == int(choice[j]):
                answerCnt += 1;
    print('당첨 번호: %d, %d, %d, %d, %d, %d' % (answer[0],
                                                answer[1],
                                                answer[2],
                                                answer[3],
                                                answer[4],
                                                answer[5]));
    print();
    return answerCnt;

# 당첨금 랜덤 생성 함수(1~5등)
def randomMoney():
    money[0] = random.randint(1500000000, 2000000000);
    money[1] = random.randint(10000000, 50000000);
    money[2] = random.randint(1000000, 5000000);
    money[3] = 50000;
    money[4] = 5000;
    print("당첨금액 1등: %d 원 \n당첨금액 2등: %d 원 \n당첨금액 3등: %d 원 \n당첨금액 4등: %d 원 \n당첨금액 5등: %d 원" % (money[0],
                                                                           money[1],
                                                                           money[2],
                                                                           money[3],
                                                                           money[4]));
    print();

# 당첨금 지급 함수
def giveMoney(answerCnt):
    if answerCnt == 6:
        print('1등 당첨!  상금: %d원' % (money[0]));
    elif answerCnt == 5:
        print('2등 당첨!  상금: %d원' % (money[1]));
    elif answerCnt == 4:
        print('3등 당첨!  상금: %d원' % (money[2]));
    elif answerCnt == 3:
        print('4등 당첨!  상금: %d원' % (money[3]));
    elif answerCnt == 2:
        print('5등 당첨!  상금: %d원' % (money[4]));
    else:
        print('당첨 되지 않으셨습니다ㅠ');


print('start');

a = input('당첨 번호의 범위를 정하세요(6 이상의 숫자를 입력하세요): ');
makeAnswer(a);

while True:
    print('========================================================');
    inGame = input('게임 시작(s), 게임 종료(q)');

    if inGame == 'q':
        break;
    elif inGame == 's':
        choice = input("선택하신 번호 6개를 입력해주세요(1 ~ %s)" % a);
        answerCnt = compareNum(choice);
        randomMoney();
        giveMoney(answerCnt);
    else:
        print('잘못 입력하셨습니다, 다시 입력하세요.');

print('end');