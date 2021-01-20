print('start......');

while True:
    data = input('input number...?[q:quit]');
    if data.lower() == 'q':
        print('bye');
        exit();
        break;
    if data.isdecimal():
        result = int(data) * 1000;
        print(result);
    else:
        print('invalid number type.. try again');


#data.isalnum() 숫자 또는 문자냐
print('end......');
