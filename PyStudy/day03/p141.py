# 다른 파일에서 만든 함수를 가져와서 사용할 수 있다.
import p140

p140.data = 200;

data2 = [1,2,3,4,5];
print(p140.calcsum(data2));

print('--------------------');

result2 = p140.f1();
print(result2);

print('--------------------');

# 두 개의 f2()함수가 존재하면 둘 중에 두 번째 f2()가 호출됨
# 스크립트 함수의 특성, 조심해야 함
# 동일한 이름의 함수를 사용하는것은 지양
# 두 번째 f2()는 리턴되는 값이 없기 때문에 rusult3에 아무런 값도
# 저장되지 않는다. 따라서, None을 출력하게 됨
# 숫자와 문자는 합칠(+) 수 없기 때문에 result3를 형변환 해준다.
result3 = p140.f2(2,9);
print(str(result3)+'%');

print('--------------------');

# 함수 안에서 값을 출력하는것은(print) 좋지 않다.
# 출력값이 고정되어 버리기 때문에 좋지 않다.
p140.f3(4,9);

print('--------------------');

result4 = p140.f4(1,2,3,4,5);
print(result4);

print('--------------------');

result6 = p140.f6(step=1,end=100,begin=2);
print(result6);

print('--------------------');

help(p140.f6);

print('--------------------');

result7 = p140.f7(step=1,end=100,begin=2);
print(result7);

print('--------------------');

p140.f8('datas',1,2,3,4,5,start=10,end=100);