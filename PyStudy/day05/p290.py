result = 0;
a = input('Input Number ...?');
try:
    result = 2 / int(a);
except:
    print('Invalid Input Number...');
    exit();
print(result);