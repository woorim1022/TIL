from random import randint

def coinToss(money):

    bet = int(input('베팅할 금액: '));
    while bet > money:
        print('잔액부족! 잔액: %d' % (money));
        bet = int(input('베팅할 금액: '));
    money -= bet;

    temp = bet;

    while True:
        ans = randint(0, 1);
        print(ans)

        guess = input('앞(0), 뒤(1): ');

        if int(guess) == ans:
            print('정답!\n');

            goStop = input('go(g) stop(s): ');
            if goStop == 'g':
                temp *= 2;
                print('베팅금액 : %d' % (temp));
            elif goStop == 's':
                money += temp;
                print('%d원 획득!' % (temp));
                break;
        else:
            print('오답');
            print('잔액 : %d' % (money));
            break;

