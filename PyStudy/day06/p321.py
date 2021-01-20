import sqlite3

import dbutil;
print('start')
try:
    # 1. SQLite에 접속한다.
    dbutil.connectDB('addr.db');

    # 2. Table을 만든다.
    dbutil.makeTable();

    # 3. 사용자 정보를 입력한다.
    user = ['id14','pwd14','홍말숙','01077776666','경기',20];
    # dbutil.insertUser(user);

    # 3-1. 한명 조회
    user = dbutil.selectOneUser('id01');
    print(user);
    print();

    # 3-2. 수정
    user = ['id01', '11111111', '이말숙', '01077776666', '경기', 20];
    dbutil.updateUser(user);

    # 3-3. 삭제
    dbutil.deleteUser('id02');

    # 4. 사용자 정보를 조회한다.
    allusers = dbutil.selectUser();
    for user in allusers:
        print(user);

except sqlite3.IntegrityError:
    print('Duplicated ID Except...')
finally:
    # 5. SQLite를 Close 한다.
    dbutil.closeDB();
print('end')