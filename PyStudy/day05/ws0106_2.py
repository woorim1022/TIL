from time import sleep;

def pw():
    pw = input('비밀번호: ');
    return pw;

def open(pw):
    tryNum = 0;
    while True:
        pwFromUser = input('비밀번호를 입력하세요: ');
        if pw[0]==pwFromUser[0] and pw[1]==pwFromUser[1] and pw[2]==pwFromUser[2] and pw[3]==pwFromUser[3]:
            print('삐리릭~ 문이 열렸습니다.');
            print();
            break;
        else:
            tryNum += 1;
            if tryNum <= 3:
                print('비밀번호가 일치하지 않습니다.');
                print();
            else:
                print('시도 횟수가 초과되었습니다. 1분 뒤 다시 시도하세요');
                print();
                tryNum = 0;
                sleep(60);



print('start');

pw = pw();
while True:
    game = input('비밀번호 입력(s), 종료(q): ');
    if game == 'q':
        break;
    elif game == 's':
        open(pw);

print('end');