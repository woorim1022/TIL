#내장함수

d1 = 20;
d2 = 10.123445;
r1 = d1 + d2;
print(str(round(r1, 3)) +' abc');

print(hex(d1));
print(oct(d1));
print(bin(d1));

help(max);
print(max(d1,d2));

#알고리즘 문제에서는 max()같은 함수조차 사용하지 못할 수도 있음