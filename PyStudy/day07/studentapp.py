import studentapi;
from studentapi import Human, Student;

human = Human('james', 20);
print(human);
print('이름: %s 나이: %s' % (human.print()));

student = Student('james', 20, '컴공');
print(student);
print(student.print());
print(student.study());