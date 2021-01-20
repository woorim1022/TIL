import time;
import datetime;

t = time.time();
print(t); # 1970.1.1 ~ 현재까지의 초
localt = datetime.datetime.now();

print(type(localt));
print(localt.month);
print(localt.day);