import Math;

Math.cos(34);

class Account:

    # 초기화 해주는 기능
    def __init__(self, accNo, balance, rate):
        "Constructor"
        self.accNo = accNo;
        self.balance = balance;
        self.rate = rate;
    # 입금 기능
    def deposit(self, money):
        self.balance += money;
    # 출금 기능
    def withdraw(self, money):
        self.balance -= money;
    # 잔액 확인 기능
    def inquire(self):
        return self.balance;

# 계좌 객체 acc1 생성, __init__가 자동으로 생성됨
acc1 = Account('1111', 20000, 4.5);
print('잔액은 %d 입니다.' % (acc1.inquire()));

acc1.deposit(10000)

print('잔액은 %d 입니다.' % (acc1.inquire()));