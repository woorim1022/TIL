print('start')

f = None;

#### try 안에서 정의된 변수는 try 안에서만 존재한다
#### finally 에서는 존재하지 않음
try:
    f = open('live.txt', 'rt', encoding='UTF-8');
    text = f.read();
    print(text);
except FileNotFoundError:
    print('존재하지 않는 파일')
finally:
    if f != None:
        print('Close.....')
        f.close();
print('end')