# Dictionary
# key : value
score = (1,2,3,4,5);    # tuple
item1 = ['item1',1000,1];   # list
item2 = {'name':'item1','price':1000,'count':1}; # dictionary(키:값)

print('---------------------------------------')
#값이 없으면 에러
print(item2['price']);

print('---------------------------------------')
# get()은 값이 없으면 None 출력 -> item['pri']보다 바람직하다
# get('pri','Empty') -> None 대신 Empty 출력
print(item2.get('pri','Empty'))

print('---------------------------------------')

if 'count' in item2:
    print(item2.get('count') * 100);

print('---------------------------------------')

# 딕셔너리는 추가, 삭제 가능
item2['date'] = '20210105';
del(item2['date'])
print(item2);

