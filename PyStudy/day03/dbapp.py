import dbutil;

# dbutil.insert(id = 'woorim', pwd = '1022', name = '김우림', age = 26);
#
# dbutil.select(id = 'woorim');
#
# dbutil.select();

print('start');
while True:
    menu = input('i,s,sa,q');
    if menu == 'q':
        print('bye');
        break;
    elif menu == 'i':
        datas = input('Input information..[id, pwd, name, age]');
        datas = datas.split(' ');
        if datas[3].isdecimal() == False:
            print("Age shold be a number. Try again ..");
            continue;
        dbutil.insert(id=datas[0].strip(),
                      pwd=datas[1].strip(),
                      name=datas[2].strip(),
                      age=int(datas[3].strip()));
    elif menu == 's':
        inputid = input('id: ');
        user = dbutil.select(id=inputid);
        print('id: %s pwd: %s name: %s age: %s' % (user[0],
                                                   user[1],
                                                   user[2],
                                                   user[3]));
    elif menu == 'sa':
        users = dbutil.selectall();  #list 안에 list
        for i in range(0, len(users)):
            for j in range(0, len(users[i]), 4):
             print('id: %s pwd: %s name: %s age: %s' % (users[i][j],
                                                        users[i][j+1],
                                                        users[i][j+2],
                                                        users[i][j+3]));
    else:
        print('Try again ..');

print('end');
