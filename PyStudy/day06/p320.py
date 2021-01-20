import sqlite3;

# 저장소(SQLite)에 테이블 생성
# sql
# 'create table users (
#     id CHAR(16),
#     pwd CHAR(16),
#     name CHAR(10), # 디비에서는 보통 한글을 2바이트로 잡는다
#     phone CHAR(15),
#     addr CHAR(20),
#     age NUMBER(3),
# );



print('start.....');

con = None;
cursor = None;

# 1. SQLite에 접속한다.
con = sqlite3.connect('addr.db');
cursor = con.cursor();
print('SQLite connected...')
# 2. Table을 만든다.
# cursor.execute('drop table if exists users');
cursor.execute("""
    create table if not exists users (
        id CHAR(16) primary key,
        pwd CHAR(16),
        name CHAR(10), 
        phone CHAR(15),
        addr CHAR(20),
        age NUMBER(3));
    """);
print('Table Created..')
# 3. 사용자 정보를 입력한다.
cursor.execute("""
insert into users values
('id04','pwd04','이말숙',' 01099992222','서울',29)
""");
con.commit();  # 데이터베이스의 정보의 변경이 있을때 해야하는 명령어
# 4. 사용자 정보를 조회한다.

# 데이터 탐색할 때는 정보의 변경이 일어나지 않기 때문에 commit() 할 필요 없음
cursor.execute('select * from users');
allusers = cursor.fetchall();
for user in allusers:
    print('%s %s %s %s %s %d' % (user[0],user[1],user[2],user[3],user[4],user[5]));
# 5. SQLite를 Close 한다.
cursor.close();
con.close();


print('end......');