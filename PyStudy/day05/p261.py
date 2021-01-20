import math;
import turtle;
import statistics;

print(math.sqrt(2)); # root2
print(math.hypot(2,4));

# # 그림그리기
# turtle.penup();
# turtle.goto(-720,0);
# turtle.pendown();
# for x in range(-720,720):
#     turtle.goto(x,math.sin(math.radians(x))*100);
# turtle.down();

# 통계
data = [10,44,20,98,100,98,29];
print(statistics.mean(data));
print(max(data));