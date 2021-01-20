# 데이터베이스의 입출력 기능을 하는 함수들

def insert(**a):
    id = a['id'];
    pwd = a['pwd'];
    name = a['name'];
    age = a['age'];
    print('%s %s %s %d inserted ....' % (id, pwd, name, age));

def select(**a):
    id = a['id'];
    data = [];
    # 리스트는 데이터를 자유롭게 수정할 수 있다(튜플은 불가능)
    data.append(id);
    data.append('pwd01');
    data.append('이말숙');
    data.append(25);
    # 리스트에는 다양한 타입의 데이터가 들어갈 수 있다.
    return data;

def selectall():
    data = [];
    data.append(['id01','pwd01','이말숙',25]);
    data.append(['id02', 'pwd02', '김말숙',26]);
    data.append(['id03', 'pwd03', '황말숙',27]);
    data.append(['id04', 'pwd04', '정말숙',28]);
    data.append(['id05', 'pwd05', '장말숙',29]);
    return data;


