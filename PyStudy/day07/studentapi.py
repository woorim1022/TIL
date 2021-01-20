class Human:
    def __init__(self, name, age):
        self.__name = name;
        if age <= 0:
            self.__age = 1;
        else:
            self.__age = age;

    def __str__(self):
        return self.__name+' '+str(self.__age);

    def print(self):
        return self.__name, self.__age;

    def getAge(self):
        return self.__age;

    def setAge(self, age):
        self.__age = age;

    def getName(self):
        return self.__name;

    def setName(self, name):
        self.__name = name;

# Student 클래스는 Human 클래스를 상속받는다.
class Student(Human):
    def __init__(self, name, age, major):
        super().__init__(name, age);
        self.__major = major;

    def __str__(self):
        return super().__str__()+' '+self.__major;

    # Human에는 없고 Student에만 있는 함수
    def study(self):
        return self.__major+'를 공부한다.';

    def print(self):
        # +연산자로 자동으로 튜플의 맨 뒤에 값을 추가
        return super().print()+(self.__major,);