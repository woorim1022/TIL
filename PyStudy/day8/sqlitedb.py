import sqlite3;
from value import *;

class Sql:
    makeusertb = """create table if not exists usertb(
	                id char(10) primary key,
	                pwd char(10),
	                name char(10),
	                age number(3)
    )""";
    insertUser = """insert into usertb values('%s','%s','%s',%d)""";
    deleteUser = """delete from usertb where id = '%s'""";
    updateUser = """update usertb set pwd='%s', name='%s', age=%d where id='%s'""";
    selectUser = """select * from usertb where id='%s'""";
    selectAllUser = """select * from usertb""";


class SqliteDb:
    #self.변수명 -> 앞에 self. 을 붙이면 클래스의 속성값이 된다.
    #클래스에 의해 만들어지는 객체의 데이터
    #this. 와 같은 역할
    def __init__(self, dbName):
        self.__dbName = dbName;

    def getConnect(self):
        con = sqlite3.connect(self.__dbName);
        cursor = con.cursor();
        print(self.__dbName+'connected...');
        return {'con':con, 'cursor':cursor};

    def close(self, cc):
        if cc['cursor'] != None:
            cc['cursor'].close();
        if cc['con'] != None:
            cc['con'].close();

    def makeTable(self):
        "Make usertb Table"
        cc = self.getConnect();
        cc['cursor'].execute(Sql.makeusertb);
        cc['con'].commit();
        self.close(cc);

    def insert(self, u):
        cc = self.getConnect();
        cc['cursor'].execute(Sql.insertUser % u.sqlmap());
        cc['con'].commit();
        self.close(cc);

    def select(self):
        cc = self.getConnect();
        cc['cursor'].execute(Sql.selectAllUser);
        result = cc['cursor'].fetchall();
        userall = [];
        for u in result:
            # u 는 튜플 형태 ( , , ,20)
            tu = User(u[0],u[1],u[2],u[3]);
            userall.append(tu);
        self.close(cc)
        return userall;

    def update(self, u):
        cc = self.getConnect();
        cc['cursor'].execute(Sql.updateUser % (u.pwd, u.name, u.age, u.id));
        cc['con'].commit();
        self.close(cc);

    def delete(self, id):

        cc = self.getConnect();
        cc['cursor'].execute(Sql.deleteUser % id);
        cc['con'].commit();
        self.close(cc);

    def selectone(self, id):
        cc = self.getConnect();
        cc['cursor'].execute(Sql.selectUser % id);
        uu = cc['cursor'].fetchone();
        userone = User(uu[0], uu[1], uu[2], uu[3]);
        self.close(cc);
        return userone;





