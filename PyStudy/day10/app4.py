str = '3+4+5'
strlist = '[1,2,3,4,5]';

# 스트링 내용이 계산식이면 eval()을 활용해 계산 가능
print(eval(str))
print(eval(strlist))

users = """[{'id':'id01', 'name':'james'},
{'id':'id01', 'name':'james'},
{'id':'id01', 'name':'james'}]"""

# 스트링 내부의 내용이 리스트와 일치하면
# eval()을 활용해 리스트처럼 활용할 수 있음
# 서버에서 값이 날라올 때 전부 스트링으로 날라오기 때문에
# eval()를 유용하게 활용해 데이터에 접근할 수 있다.
for i in eval(users):
    print(i['id']+' '+i['name'])

us = [{'id':'id01', 'name':'james'},
{'id':'id01', 'name':'james'},
{'id':'id01', 'name':'james'}];

# 객체로부터 문자열 표현식을 생성
# eval()과 반대
usstr = repr(us);

print(usstr);