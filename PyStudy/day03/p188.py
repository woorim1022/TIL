num = 1000;
hnum = '100';
str1 = 'result:';
str2 = 'won';
print('result: '+str(num)+' won');

print('%s %10.2f %s' % (str1,num,str2));    # 전체자리수.소수점자리수
print('%s %d %s' % (str1,num,str2));

print('%10d%%' % num);  # 10칸
print();
nums1 = [1000,2000,30,210000];
for n in nums1:
    print('Price: %-10d Won' % n);