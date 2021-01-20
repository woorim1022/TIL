class Car:
    # 객체 것이 아니라 클래스 Car의 변수.
    # Car로 생성되는 모든 객체(car1, car2, car3...)에서 공통적으로
    # serial = 1000을 갖는다
    serial = 1000;

    def __init__(self, id, name, fsize, cfsize):
        self.__id = id;
        self.__name = name;
        self.__fsize = fsize;
        # 출고시 기름 양
        self.__cfsize = cfsize;
        self.__serial = Car.serial;  # Car라는 클래스의 변수인 serial
        Car.serialCount();

    @classmethod
    def serialCount(cls):
        Car.serial += 1;

    # def __str__(self):
    #     ""

    def print(self):
        return self.__id, self.__name, self.__fsize, self.__cfsize, self.__serial;

    def setCfsize(self, size):
        self.__cfsize += size;

    def getCfsize(self):
        return self.__cfsize;
