class User:
    def __init__(self, id, pwd, name, age):
        self.__id = id;
        self.__pwd = pwd;
        self.__name = name;
        self.__age = age;

    def __str__(self):
        return self.__id+' '+self.__pwd+' '+self.__name+' '+str(self.__age);

    def sqlmap(self):
        return self.__id, self.__pwd, self.__name, int(self.__age);

    def sqlmapforupdate(self):
        return self.__pwd, self.__name, int(self.__age), self.__id;

    def getId(self):
        return self.__id;

    def setId(self, id):
        self.__id = id;

    def getPwd(self):
        return self.__pwd;

    def setPwd(self, pwd):
        self.__pwd = pwd;

    def getName(self):
        return self.__name;

    def setName(self, name):
        self.__name = name;

    def getAge(self):
        return self.__age;

    def setAge(self, age):
        self.__age = age;

    id = property(getId, setId);
    pwd = property(getPwd, setPwd);
    name = property(getName, setName);
    age = property(getAge, setAge);


# user1 = User('id01','pwd01','james',20);
# user2 = User('id02','pwd02','james',22);