# number guess game
#
# 1.두 자리의 숫자 2개를 입력받는다
# 2.두 수 사이의 랜덤한 숫자를 발생 시킨다
# 3.넘버 게임을 시작한다
# 4.숫자를 입력받아 3가지의 조건을 출력 한다.
#   크다, 작다, 맞다.
# 5.게임 한 횟수를 화면에 출력한다(게임 횟수 제안을 둔다. 횟수는 10회)
# 6.10회가 넘으면 fail
# 7.게임 다시 시작
# 8.숫자가 맞으면 새로운 게임을 다시 만들어 시작
import random

while True:
    numbers = input('두 자리의 숫자 두 개를 입력하시오: ')
    numbers = numbers.split(' ');
    answer = random.randint(int(numbers[0]), int(numbers[1]));
    k = 0;
    while True:
        numbers = input('넘버 게임 시작! ')
        while k < 10:
            inputnum = input('숫자를 예측하시오: ');
            if answer > int(inputnum):
                print('예측한 숫자보다 정답이 더 큽니다.');
            elif answer < int(inputnum):
                print('예측한 숫자보다 정답이 더 작습니다.');
            else:
                print('정답입니다!');
                break;
            k = k + 1;
            print('게임 한 횟수: '+str(k));
        if k == 10:
            print('fail, 게임 다시시작');
            k = 0;
            continue;
        else:
            break;
