from userdb import *;
from itemdb import *;


# 1. 사용하고자 하는 데이터베이스 이름을 이용한다
sqlitedb = SqliteDb('shopdb.db');
#
# # 2. 테이블을 생성한다, 단, 존재 하지 않으면(it not exists)
sqlitedb.makeTable();

# 3. 사용자 테이블을 사용하기 위해 userdb 객체를 이용하여 CRUD 진행
udb = UserDb('shopdb.db');
user = User('id02', 'pw01', 'james', 20);
# udb.insert(user);

userlist = udb.select();
for u in userlist:
    print(u)
