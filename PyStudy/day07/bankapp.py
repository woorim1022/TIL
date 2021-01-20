from bankapi import Account;

accList = [];
accList.append(Account('1111',10000,3.5));
accList.append(Account('2222',20000,3.6));
accList.append(Account('3333',30000,3.7));
accList.append(Account('4444',40000,3.8));
accList.append(Account('5555',50000,3.9));

for acc in accList:
    # __str__ 때문에 자동으로 스트링 형태로 출력됨
    print(acc);

#  잔액 평균과 금리 평균을 구하시오
print('잔액 평균: %d 이자 평균: %.2f' % (Account.getAvg(accList)));

