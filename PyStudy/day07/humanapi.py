class Human:
    def __init__(self,id,name,salary):
        self.__id = id;
        self.__name = name;
        self.__salary = salary; # 인캡슐래이션 된 상태, setter, getter를 통해서만 접근 가능

    def __str__(self):
        return self.__id+' '+self.__name+' '+str(self.__salary);

    def getSalary(self):
        return self.__salary;

    def setSalary(self, salary):
        # 봉급이 0보다 작으면 봉급을 변경하지 못하게 함
        if salary <= 0:
            return;
        self.__salary = salary;

    # 이름과 아이디를 변경하지 못하게 하는 함수
    def getID(self):
        return self.__id;

    def getName(self):
        return self.__name;

    # getSalary, setSalary 함수를 sal로 사용할 수 있음
    # human.getSalary(), human.setSalary(4000) 대신
    # human.sal 로 대체 가능
    sal = property(getSalary, setSalary)


