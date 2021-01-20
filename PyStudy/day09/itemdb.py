from sqlitedb import SqliteDb, Sql;
from value import Item;


# 순수하게 Item 관련 데이터만 조작하는 클래스
class ItemDb(SqliteDb):
    def __init__(self, dbName):
        super().__init__(dbName);

    def insert(self, item):
        cc = self.getConnect();
        cc['cursor'].execute(Sql.insertItem % item.sqlmap());
        cc['con'].commit();
        self.close(cc);

    def select(self):
        cc = self.getConnect();
        cc['cursor'].execute(Sql.selectAllItem);
        result = cc['cursor'].fetchall();
        all = [];
        for i in result:
            # u 는 튜플 형태 ( , , ,20)
            tu = Item(i[0],i[1],i[2]);
            all.append(tu);
        self.close(cc)
        return all;

    def selectone(self, id):
        cc = self.getConnect();
        cc['cursor'].execute(Sql.selectItem % id);
        i = cc['cursor'].fetchone();
        obj = Item(i[0], i[1], i[2]);
        self.close(cc);
        return obj;

    def update(self, i):
        cc = self.getConnect();
        cc['cursor'].execute(Sql.updateItem % (i.name, i.price, i.id));
        cc['con'].commit();
        self.close(cc);

    def delete(self, id):
        cc = self.getConnect();
        cc['cursor'].execute(Sql.deleteItem % id);
        cc['con'].commit();
        self.close(cc);


