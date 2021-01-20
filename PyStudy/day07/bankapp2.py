# 인캡슐래이션
# 인캡슐래이션을 하면 외부에서 속성에 접근할 때 함수를 통해서만 접근할 수 있다
# (private)
from bankapi import Account;

acc1 = Account('1111', 10000, 3.5);
print(acc1.getRate());