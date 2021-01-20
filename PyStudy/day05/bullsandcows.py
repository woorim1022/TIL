from random import randint

def bullsAndCows():
    money = 100000000;

    ans = [];
    for i in range(4):
        num = randint(0,9);
        while num in ans:
            num = randint(0,9);
        ans.append(num);
    # print(ans);

    while True:
        money -= 10000000;
        strikeCnt = 0;
        ballCnt = 0;

        if money <= 0:
            print('파산');
            break;

        guess = input('숫자를 예측하세요: ');

        for i in range(4):
            try:
                if ans.index(int(guess[i])) == i:
                    strikeCnt += 1;
                else:
                    ballCnt += 1;
            except ValueError:
                continue;

        print('strike: %d, ball: %d' %(strikeCnt, ballCnt));

        if strikeCnt == 4:
            money += 100000000;
            print('정답!!');
            print('잔액: %d' % money);
            break;

    return money;