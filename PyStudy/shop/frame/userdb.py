from frame.db import Db
from frame.sql import Sql
from frame.value import User


class UserDb(Db):
    def select(self):
        conn = super().getConnection();
        cursor = conn.cursor()
        cursor.execute(Sql.userlist)
        result = cursor.fetchall()
        all = []
        for u in result:
            user = User(u[0],u[1],u[2])
            all.append(user)
        super().close(conn,cursor)
        return all

    def selectone(self, id):
        conn = super().getConnection();
        cursor = conn.cursor()
        cursor.execute(Sql.user % id)
        u = cursor.fetchone()
        user = User(u[0],u[1],u[2])
        super().close(conn,cursor)
        return user

    def delete(self, id):
        try:
            conn = super().getConnection();
            cursor = conn.cursor()
            cursor.execute(Sql.userdelete % (id))
            conn.commit()
        except:
            conn.rollback();
            raise Exception
        finally:
            super().close(conn, cursor)

    def insert(self, u):
        try:
            conn = super().getConnection();
            cursor = conn.cursor()
            cursor.execute(Sql.insertuser % u.sqlmap())
            conn.commit()
        except:
            conn.rollback();
            raise Exception
        finally:
            super().close(conn, cursor)

    def update(self, id, pwd, name):
        try:
            conn = super().getConnection();
            cursor = conn.cursor()
            cursor.execute(Sql.userupdate % (pwd, name, id))
            conn.commit()
        except:
            conn.rollback();
            raise Exception
        finally:
            super().close(conn, cursor)









# userlist Test Function ..............
def userlist_test():
    users = UserDb().select()
    for u in users:
        print(u)


def userone_test():
    users = UserDb().selectone('id02')
    print(users)


def update_test():
    users = UserDb().update('id02','비밀번호다으하하','김우림')
    print(users)


def delete_test():
    users = UserDb().delete('id21')
    print(users)


# 파이썬 파일을 시작했을 때 여기가 시작점이라는 것을 알리는 코드
if __name__ == '__main__':
    userlist_test()
    userone_test()
    update_test()
    delete_test()
