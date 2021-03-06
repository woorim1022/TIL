class Order:
    def __init__(self, id, date, userid, itemid, price, qt):
        self.__id = id
        self.__date = date
        self.__userid = userid
        self.__itemid = itemid
        self.__price = price
        self.__qt = qt

    def sqlmap(self):
        return self.__id, self.__date, self.__userid, self.__itemid, self.__price, self.__qt

    def getId(self):
        return self.__id

    def setId(self, id):
        self.__id = id

    def getDate(self):
        return self.__date

    def setDate(self, date):
        self.__date = date

    def getUserId(self):
        return self.__userid

    def setUserId(self, userid):
        self.__userid = userid

    def getItemId(self):
        return self.__itemid

    def setItemId(self, itemid):
        self.__itemid = itemid

    def getPrice(self):
        return self.__price

    def setPrice(self, price):
        self.__price = price

    def getQt(self):
        return self.__qt

    def setQt(self, qt):
        self.__qt = qt

    id = property(getId, setId)
    date = property(getDate, setDate)
    userid = property(getUserId, setUserId)
    itemid = property(getItemId, setItemId)
    price = property(getPrice, setPrice)
    qt = property(getQt, setQt)

