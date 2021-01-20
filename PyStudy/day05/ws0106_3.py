from random import randint

menu = [[],[],[],[],[]];
snack = ['새우깡', '바나나킥', '다이제', '초코파이', '치토스'];

def charge():
    while True:
        charge = input('충전할 금액 입력하세요: ');
        if charge.isdecimal() == True:
            print('충전완료')
            charge = int(charge);
            break;
        else:
            print('이상한 카드 투입, 다시 시도하세요');
    print();
    return charge;

def buy(charge):
    for i in range(5):
        menu[i].append(snack[i]);
        menu[i].append(randint(0,5));
        menu[i].append(randint(1,50)*100);
        print('메뉴: %s 수량: %s 개 가격: %s 원' % (menu[i][0], menu[i][1], menu[i][2]));
    print('잔액: %d' % (charge));
    select = input('메뉴를 선택하세요: ');
    print();

    if menu[snack.index(select)][1] <= 0:
        print('매진\n')
    else:
        if menu[snack.index(select)][2] > charge:
            print('잔액 부족\n');
        else:
            charge -= menu[snack.index(select)][2];
            menu[snack.index(select)][1] -= 1;
            print('%s 구매완료\n' % (select));


print('start');

charge = charge();
while True:
    game = input('구매(b), 종료(q): ');
    if game == 'q':
        break;
    else:
        buy(charge);

print('end');


