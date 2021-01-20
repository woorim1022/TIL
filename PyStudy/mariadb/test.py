import pymysql;

config = {
    'user':'root',
    'password':'111111',
    'host':'127.0.0.1',
    'database':'employees',
    'port':3306
};

conn = pymysql.connect(**config);
print(conn);

cursor = conn.cursor();
sql = 'select * from salaries';

cursor.execute(sql);
result = cursor.fetchall();
print(result)

for u in result:
    print('%s, %s, %s, %d, %s'% (u[0],u[1],u[2],u[3],u[4]));

cursor.close()
conn.close()