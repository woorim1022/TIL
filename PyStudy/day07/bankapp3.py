import bankapi;
from bankapi import Account;


acc = Account('1111', 10000, 3.4);

print(acc);
try:
    acc.withdraw(20000);
except bankapi.MinusError:
    print('음수값 출력 불가');
except bankapi.NotEnoughError:
    print('잔고부족');

print(acc);