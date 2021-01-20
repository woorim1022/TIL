import sqlite3;
from datetime import datetime

from ordervalue import *

class Sql:
    makeTable = """
        CREATE TABLE IF NOT EXISTS orders(
            id CHAR(16) primary key,
            date CHAR(16),
            userid CHAR(16),
            itemid CHAR(16),
            price NUMBER(10),
            qt NUMBER(10)
            )"""
    insertSQL = """Insert into orders values ('%s','%s','%s','%s','%d','%d')"""
    selectOrder = """select * from orders where id='%s'""";
    selectAll = 'select * from orders';
    deleteOrder = """delete from orders where id='%s'"""
    updateOrder = """update orders set date='%s',userid='%s',itemid='%s',price='%d',qt='%d' where id='%s'"""


class OrderDb:
    def __init__(self, dbName):
        self.__dbName = dbName

    def connectDB(self):
        "Connect SQLite..."
        con = sqlite3.connect(self.__dbName)
        cursor = con.cursor()
        print('SQLite connected...')
        return {'con': con, 'cursor': cursor}

    def closeDB(self, cc):
        "Close SQLite"
        if cc['cursor'] != None:
            cc['cursor'].close();
        if cc['con'] != None:
            cc['con'].close();

    def makeTable(self):
        "Make order Table"
        cc = self.connectDB()
        cc['cursor'].execute(Sql.makeTable)
        cc['con'].commit()
        self.closeDB(cc)

    def insertOrder(self, order):
        "Insert order Data"
        cc = self.connectDB()
        cc['cursor'].execute(Sql.insertSQL % (order.sqlmap()));
        cc['con'].commit();
        self.closeDB(cc)

    def selectOrder(self):
        "Select order Data"
        cc = self.connectDB()
        cc['cursor'].execute(Sql.selectAll);
        allOrders = cc['cursor'].fetchall();
        allOrdersList = []
        for o in allOrders:
            t = Order(o[0],
                      o[1],
                      o[2],
                      o[3],
                      o[4],
                      o[5])
            allOrdersList.append(t)
        self.closeDB(cc)
        return allOrdersList

    def selectOneOrder(self, id):
        "Select One order"
        cc = self.connectDB()
        cc['cursor'].execute(Sql.selectOrder % (id))
        oneOrder = cc['cursor'].fetchone();
        orderObj = Order(oneOrder[0],
                          oneOrder[1],
                          oneOrder[2],
                          oneOrder[3],
                          oneOrder[4],
                          oneOrder[5])
        self.closeDB(cc)
        return orderObj

    def deleteOrder(self, id):
        "Delete One order"
        cc = self.connectDB();
        cc['cursor'].execute(Sql.deleteOrder % id);
        cc['con'].commit();
        self.closeDB(cc);

    def updateOrder(self, order):
        "Update One order"
        cc = self.connectDB();
        cc['cursor'].execute(Sql.updateOrder % (order.date,
                                                order.userid,
                                                order.itemid,
                                                order.price,
                                                order.qt,
                                                order.id));
        cc['con'].commit();
        self.closeDB(cc);

    def serialCnt(self):
        allOrders = self.selectOrder()
        serialList = []
        if len(allOrders) == 0:
            serial = self.dateNow() + str(1)
        else:
            for i in range(len(allOrders)):
                serialList.append(int(allOrders[i].id[8:]));
            serial = str(self.dateNow()) + str(max(serialList)+1);
        return serial;

    @staticmethod
    def dateNow():
        t = str(datetime.now())[:10].split('-');
        return t[0] + t[1] + t[2];

