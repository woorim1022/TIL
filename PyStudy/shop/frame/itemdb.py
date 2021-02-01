from frame.db import Db
from frame.sql import Sql
from frame.value import Item


class ItemDb(Db):
    def insert(self ,name, price, imgname):
        try:
            conn = super().getConnection();
            cursor = conn.cursor();
            cursor.execute(Sql.iteminsert % (name, price, imgname));
            conn.commit();
        except:
            conn.rollback();
            raise Exception;
        finally:
            super().close(conn, cursor);

    def select(self):
        conn = super().getConnection();
        cursor = conn.cursor();
        cursor.execute(Sql.itemlist);
        result = cursor.fetchall();
        all = [];
        for u in result:
            item = Item(u[0],u[1],u[2],u[3],u[4]);
            all.append(item);
        super().close(conn,cursor);
        return all;

    def selectone(self, id):
        conn = super().getConnection();
        cursor = conn.cursor()
        cursor.execute(Sql.itemlistone % id)
        i = cursor.fetchone()
        item = Item(i[0],i[1],i[2],i[3],i[4])
        super().close(conn, cursor)
        return item




def iteminsert_test():
    ItemDb().insert(6, 'shirts',30000,'2020-10-10', 's.jpg');

def itemselect_test():
    user = ItemDb().select();
    print(user)

def selectone_test():
    item = ItemDb().selectone(1)
    print(item)

if __name__ == '__main__':
    itemselect_test();
    itemselect_test()
    selectone_test()