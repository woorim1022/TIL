str1 = 'python';

print(len(str1));
print(str1[0]);
print(str1[-3]);    # 뒤에서 -1부터 시작

for i in str1:
    print(i,end=',');
print();
for i in range(len(str1)):  #6, 0~5
    print(str1[i], end=',');
print();
for i in range(len(str1)-1, -1, -1):
    print(str1[i], end=',');
print();

# 문자열은 값을 변경할 수 없다.
# str1[1] = 'e';
print(str1);    # 문자열 출력
print(str1[2:3]); # slice(2부터 3전까지 자른다)
print(str1[3:]);    # 3번부터 끝까지
print(str1[:3]);    # 3번 전까지
print(str1[2:-2]);  # 2번째부터 뒤에서 2번째 전까지
print(str1[0:4:2]); # 0부터 4 전까지 2칸 간격으로

# '정형화된 구조로 데이터가 들어가있다'는 의미
# -> 아이디, 주소, 이름, 나이
# 비정형 데이터
# 정형화되어 있지 않은 데이터

filename = '20210104-132400.jpg';
# 2020년 1월 4일
# 1시 24분
# 파일 형식 jpg
def printstr(str):
    print(str[0:4], end='년 ');
    print(str[4:6], end='월 ');
    print(str[6:8], end='일\n');
    print(int(str[9:11])%12, end='시 ');
    print(str[11:13], end='분\n');
    print('파일형식 ' + str[16:19]);

printstr(filename)




