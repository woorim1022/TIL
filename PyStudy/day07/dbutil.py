class Sql:
    # 클래스변수
    # sql문은 이 클래스에서만 관리
    insertUser = 'inset into userdb';
    selectUser = 'select * from userdb';
    insertItem = 'insert into itemdb';
    selectItem = 'select * from itemdb';

class UserDb:
    # @staticmethod
    # 객체를 생성하지 않고 그냥 클래스에 포함되는 유틸리티 메서드
    # 코드의 정형화
    @staticmethod
    def insert():
        print(Sql.insertUser);

    @staticmethod
    def select():
        print(Sql.selectUser);

class ItemDb:
    @staticmethod
    def insert():
        print(Sql.insertItem);

    @staticmethod
    def select():
        print(Sql.selectItem);
