str = '     python      ';
str = str.upper();
# 문자열은 값이 변경되지 않기 때문에 upper해준 값을 새로운 변수에 넣어주어야 한다
# 기존에 메모리에있던 'python'을 가리키고 있던 str이 새로 'PYTHON'을 가리키게 됨
# 'python'을 가비지 값이 되어버림
# 파이썬 3.0부터는 가비지 값을 모아서 지워주는 기능이 추가되었다.
print(str);
print(str.lstrip());  # 문자를 왼쪽 정렬
print(str.rstrip());  # 문자를 오른쪽 정렬
print(str.strip());  # 문자의 공백을 제거

s1 = 'a b c d';
s2 = 'a - b - c - d';
r1 = s1.split(' ');  # split()의 결과는 리스트
r2 = s2.split('-');
print(type(r1));

for i in r2:
    print(i.strip());

s3 = '[python]';
# '['을 ''로 대체하고 공백 지워라
s4 = s3.replace('[','').rstrip();
s4 = s4.replace(']','').rstrip();
# 문자열은 값이 변경되지 않기 때문에 upper해준 값을 새로운 변수에 넣어주어야 한다
print(s4);
