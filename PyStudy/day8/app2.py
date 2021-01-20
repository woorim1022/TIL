from sqlitedb import *;
from value import *;

sqlitedb = SqliteDb('udb.db');

userList = sqlitedb.select();
for u in userList:
    print(u);

us = User('id01', '2222', 'awetasetas',20);
sqlitedb.update(us);
print('------------------------------------------------------')

userList = sqlitedb.select();
for u in userList:
    print(u);