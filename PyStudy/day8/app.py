from sqlitedb import *;
from value import *;

print('start.....');
sqldb = SqliteDb('udb.db');
sqldb.makeTable();
u = User('id04','pw04','sara',28)

# sqldb.insert(u);
# sqldb.update(u);
# sqldb.delete('id02');

userlist = sqldb.select();
for us in userlist:
    print(us.id+' '+us.pwd+' '+us.name+' '+str(us.age))

# print(sqldb.selectone('id01'));





print('end.....');