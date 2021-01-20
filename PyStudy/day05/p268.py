import time;

start = time.time();
for i in range(1,10000):
    print(i);
    time.sleep(0.001);
end = time.time();

print(end - start);