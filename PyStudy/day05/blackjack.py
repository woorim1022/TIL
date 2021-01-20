# Blackjack
# 게임 설명 :
# 무작위 카드 2장을 받는다.
# 카드 2장이 21에 가깝도록 카드를 더 받거나 받지 않는다.
# 만약 받은 카드 총합이 21이 넘게되면 게임에 패배한다.
# 받은 카드 중 합하여 21과 가장 가까운 카드를 선택하여 제출한다.
# 이후 딜러 카드와 비교하여 21 숫자와 가장 가까운 값을 낸 사람이 승리
# 승리할 경우 배팅 금액의 X2, 21일 경우 배팅 금액의 X4배
# 패배할 시 배팅 금액 0원


from random import randint


def cardWork(card, dealer):
    if card == 11 or card == 12 or card == 13:
        card = 10;
    elif card == 1:
        if dealer == True:
            card = 11;
        else:
            print(card);
            a = input('에이스를 1로 계산(1)/11로계산(11): ');
            if a == '1':
                card = 1;
            else:
                card = 11;

    return card;

def sumCard(card):
    sum = 0;
    for i in card:
        sum += i;
    return sum;

def blackJack(money):
    bet = int(input('베팅할 금액: '));
    while bet > money:
        print('잔액부족! 잔액: %d' % (money));
        bet = int(input('베팅할 금액: '));
    money -= bet;

    # 딜러카드 뽑기
    dealerCards = [cardWork(randint(1, 13), True), cardWork(randint(1, 13), True)];
    print('딜러카드: ')
    print(dealerCards);
    # 내 카드 뽑기
    cards = [randint(1, 13), randint(1, 13)];
    print('나온 카드')
    print(cards);
    cards = [cardWork(cards[0], False), cardWork(cards[1], False)];
    print('변환 카드')
    print(cards);



    state = 'none';
    while True:
        while True:
            moreCard = input('카드를 더 받겠습니까?(y/n): ');

            if moreCard == 'y':
                print();

                # 딜러와 나에게 카드 하나씩
                additional = cardWork(randint(1,13),False);
                cards.append(additional);
                dealerCards.append(cardWork(randint(1,13),True));

                print(dealerCards);
                print(cards);

                # 딜러카드 합이 21보다크면
                if sumCard(dealerCards) > 21:
                    state = 'win';
                    break;
                # 아니면
                else:
                    #내 카드가 21보다 크면
                    if sumCard(cards) > 21:
                        state = 'lose';
                        break;
                    # 아니면
                    else:
                        continue;

            elif moreCard == 'n':
                break;

        print('딜러카드: ')
        print(dealerCards);
        print('내 카드')
        print(cards);

        if state == 'win':
            print('win')
            break;
        elif state == 'lose':
            print('lose')
            break;


        choose = input('선택할 카드: ').split(' ');
        for i in range(len(choose)):
            choose[i] = int(choose[i]);

        if sumCard(choose) == 21:
            print('blackjack')
            state = 'blackjack';
        else:
            if sumCard(choose) > sumCard(dealerCards):
                print('win')
                state = 'win'
                break;
            else:
                print('lose')
                state = 'lose'
                break;



blackJack(50000);