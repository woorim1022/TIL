import time;

i = 1;
while True:
    print('Try Connected');
    if i == 10:
        print('Connected ...');
        break;
    time.sleep(3);
    print('Retry ...');
    i += 1;