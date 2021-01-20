print('start...');

f = None;

try:
    f = open('live.txt', 'rt', encoding='UTF-8');

    # 한 줄씩 읽어들임
    for text in f:
        print(text, end = '');

except:
    print('Error...')
finally:
    if f != None:
        f.close();




print('end....');