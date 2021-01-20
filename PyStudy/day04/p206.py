s = [];
s.append(20);
s.append(30);
s.append(10);
s.append(40);
s.append(50);
s.insert(2,99);
# del s[3];   # 3번째 값을 삭제
# s[1:3] = [1,2,3];   # 범위를 지정해서 데이터를 삽입
# s = s + [9,8,7];
# s = s * 3;  #
# s.sort();
s[3] = [1,2,3];
del(s[0]);  # 위치를 지정해서 삭제
s.remove(50);   # 50을 찾아서 삭제(위치지정해서 삭제하는것 보다 오래걸림)
print('-------------------------')

print(s);

print('-------------------------')

# 원하는 값을 끄집어내는것
print(s.pop());
print(s.pop(1));
print(s.index(30));
s.append(30);
# 활용 예 : 문장 안에서 단어의 개수 셀 수 있음 ( 데이터 분석 )
print(s.count(30));


print('-------------------------')

for i in s:
    print(i);

print('-------------------------')

str = ['B','C','D','D'];

if 'A' in str:
    str.remove('A');
    print(str);
else:
    str.append('A');
    print(str);

