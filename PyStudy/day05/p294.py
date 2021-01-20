d = 'a';
result = 0;

try:
    num = int(d);
    result = 10 / num;
except ValueError as e:
    print(e.with_traceback());
    exit();
except ZeroDivisionError:
    print('zero division error');
    exit();


print(result);
