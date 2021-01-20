s = 'python programming';
print(type(s));

#다른 언어와 달리 스트링의 하나의 원소가 캐릭터가 아니라 똑같이 스트링
print(type(s[0]));

print(len(s));
print(s.find('o')); # 스트링 's'의 위치
print(s.rfind('o')); # 뒤에서 부터 찾음
print(s.index('r')); # 'r'의 위치
print(s.rindex('r')); # 뒤에서부터 'r'의 위치
print(s.count('o')); # 'o'의 개수

print('a' in s); # s 에 'a'의 존재 여부
print('a' not in s);

if('a' in s):
    print('OK');
else:
    print('NO');


if str.startswith('p'):
    print('ok');

if str.endswith('g'):
    print('ok');