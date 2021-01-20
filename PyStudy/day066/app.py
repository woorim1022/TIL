import sqlite3;
import dbutil;

print('start');
try:
    dbutil.connectDB('addr.db');
    dbutil.makeTable();

    while True:
        try:
            menu = input('Input Menu(c,r,ro,u,d,q): ');
            if menu == 'q':
                print('Bye');
                dbutil.closeDB();
                break;

            elif menu == 'c':
                oneUser = input('Input User Data: ').split(' ');
                dbutil.insertUser(oneUser);

            elif menu == 'r':
                print('Select Users Info...');
                allUsers = dbutil.selectUser();
                for user in allUsers:
                    print('%s %s %s %s %s %d' % (user[0],user[1],user[2],user[3],user[4],user[5]));

            elif menu == 'ro':
                userID = input('Input User ID: ');
                user = dbutil.selectOneUser(userID);
                print('%s %s %s %s %s %d' % (user[0],user[1],user[2],user[3],user[4],user[5]));

            elif menu == 'u':
                oneUser = input('Input User Data: ').split(' ');
                dbutil.updateUser(oneUser);

            elif menu == 'd':
                userID = input('Input User ID: ');
                dbutil.deleteUser(userID);
        except:
            print('Error...');
except :
    print('Error...')
finally:
    dbutil.closeDB();