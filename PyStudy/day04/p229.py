st = {'name':'james','major':'it', 'age':20};

# 딕셔너리에서 키 만 끄집어내기
ks = st.keys();
print(ks); # list

for i in ks:
    print(i);


print('-----------------------------');
vs = st.values();
print(vs);

for i in vs:
    print(i);


print('-----------------------------');

item = st.items();
print(item);

for i in item:
    print(i);

print('-----------------------------');
