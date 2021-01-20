class Account:

    # 초기화 해주는 기능
    def __init__(self, accNo, balance, rate):
        "Constructor"
        self.__accNo = accNo;
        self.__balance = balance;
        self.__rate = rate;

    # 스트링 형태로 출력해주는 기능
    def __str__(self):
        return self.__accNo+' '+str(self.__balance)+' '+str(self.__rate)+' '+str(self.getRateMoney());

    # getter
    def getRate(self):
        return self.__rate;

    # setter
    def setRate(self, rate):
        self.__rate = rate;

    # 이자 계산 기능
    def getRateMoney(self):
        m = self.__balance * (self.__rate/100);
        return m;

    # 입금 기능
    def deposit(self, money):
        self.__balance += money;

    # 출금 기능
    def withdraw(self, money):
        # 출금할 금액이 0 보다 작거나 같으면 출금하지 못하게 함
        if money <= 0:
            raise MinusError;
        # 출금할 금액이 잔액보다 크면 출금하지 못하게 함
        if money > self.__balance:
           raise NotEnoughError;
        self.__balance -= money;



    # 잔액 확인 기능
    def inquire(self):
        return self.__balance;

    # 잔액평균, 금리평균 출력기능
    def getAvg(accList):
        bsum = 0;
        rsum = 0.0;
        for acc in accList:
            bsum += acc.__balance;
            rsum += acc.__rate;
        return bsum/len(accList), rsum/len(accList);


# 직접 만든 에러
class MinusError(BaseException):
    """ Inappropriate argument value (of correct type). """
    def __init__(self, *args, **kwargs):  # real signature unknown
        pass

# 직접 만든 에러
class NotEnoughError(BaseException):
    """ Inappropriate argument value (of correct type). """
    def __init__(self, *args, **kwargs):  # real signature unknown
        pass


