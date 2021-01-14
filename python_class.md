# 파이썬의 클래스

#### 객체지향 프로그래밍

* 파이썬은 스크립트 언어임에도 불구하고 간단한 클래스 정의, 연산자 오버로딩, 다중상속 등을 지원한다

#### 클래스란?

* 관련된 속성과 동작을 하나의 범주로 묶어 실세계의 사물을 흉내낸다.
* 클래스로부터 만든 객체는 프로그램을 구성하는 부품이 됨
* 객체 지향 프로그래밍 : 객체 간의 관계를 정의하는 식의 프로그래밍 기법

##### 모델링

* 사물을 분석하여 필요한 속성과 동작을 추출하는 것
* 사물의 속성은 변수로 표현하고 동작은 함수로 표현

##### 캡슐화

* 모델링된 결과를 클래스로 포장하는 것
* 긴밀하게 연관된 정보를 하나의 클래스로 묶어 두는것

##### 생성자

* __init__
* self : 자기 자신을 의미(this)
* 멤버 참조 시 'self.멤버' 구문 사용
* this와 달리 명시적으로 전달해야 한다.
* self 외의 나머지 인수로 멤버의 초기값을 전달받아 대입

##### 객체

* 객체 = 클래스명(인수)
* 클래스로부터 생성된 각각의 객체를 인스턴스라고 부른다

##### 상속

```python
class 이름(부모)
	....
```

* 기존 클래스를 확장하여 멤버를 추가하거나 동작을 변경하는 방법
* 자식 클래스는 부모 클래스의 모든 멤버를 물려받는다

```python
class Human():
    def __init__(self, age, name):
        self.age = age
        self.name = name
        
    def intro(self):
        print(str(self.age) + '살' + self.name + '입니다')
        

class Student(Human):
    def __init__(self, age, name, stunum):
        super().__init__(age, name)
        self.stunum = stunum
        	
	def intro(self):
        super().intro()
        print('학번: ' + str(self.srunum))
        
    def study(self):
        print("하늘천 따지 검을현 누를황")
```

* 자식 클래스에서 부모의 메서드를 호출할 때는 **super()** 메서드로 부모를 구해 호출
* **부모로부터 물려받은 멤버는 부모의 생성자에게 초기화를 위임하고 직접 추가한 멤버만 초기화 하는 것이 정석**
* 자식은 부모의 모든 메서드를 물려받는다. 자식 클래스에서 메서드를 따로 정의하지 않아도 됨
* **override : 같은 이름의 메서드를 재정의 하여 부모의 동작을 원하는 대로 수정**
* 상속 받은 자식 클래스가 또 다른 클래스를 파생시킬 수 있음, 파생될수록 클래스는 더 특수한 대상을 표현하게 되어 속성과 동작이 늘어난다

##### 엑세서

* getter, setter : 멤버를 외부에서 마음대로 조작하게 내 버려두지 않고 일정한 규칙을 마련해 안전하게 엑세스하기 위해 getter, setter 메서드 정의

* 프로퍼티 형식

  ```python
  name = property(getName, setName)
  
  # 객체명.getName(), 객체명.setName() 대신 객체명.name 으로 사용 가능
  
  # 다음과 같이 데커레이터로도 프로퍼티 정의 가능
  @property
  def name(self):
      return self.inner_name
  @name.setter
  def name(self, name):
      self.inner_name = name
  ```


#### 여러가지 메서드

##### 클래스 메서드

* 인스턴스 메서드 : 일반적으로 객체에 소속되는 메서드, 첫 번째 인수 self를 받아 이 객체에 대한 작업을 수행
* 클래스 메서드 : 특정 객체에 대한 작업을 처리하는 것이 아니라 클래스 전체가 공유한다
  * 함수 앞에 @classmethod 데커레이터를 붙이고 첫 번째 인수로 클래스에 해당하는 cls 인수를 받아들인다.
  * 객체를 생성하지 않고 사용한다
  * 객체별로 하나씩 생성되지 않고 클래스별로 딱 하나 생성되기 때문에 여러 객체가 접근할 때는 문제가 발생할 수 있음

##### 정적메서드

* 클래스에 포함되는 단순한 유틸리티 메서드
* 특정 객체에 소속되지 않고 클래스와 관련된 동작을 하는것도 아님 -> self나 cls를 인수로 받지 않음
* @staticmethod 데커레이터를 붙인다
* 클래스나 객체와 직접적인 연관이 없고 단순히 클래스에 소속되어 있을 뿐
* 객체가 없어도 호출 가능

##### 연산자메서드

```python
__eq__ # ==
__ne__ # !=
__lt__ # <
__gt__ # >
__le__ # <=
__ge__ # >=
__add__ # +
__sub__ # -
__mul__ # *
__div__ # /
__truediv__ # /(division 임포트)
__floordiv__ # //
__mod__ # %
__pow__ # **
__lshift # <<
__rshift__ # >> 
```

##### 특수메서드

```python
__str__
__repr__
__len__
```



#### 유틸리티 클래스

##### Decimal

* 오차 없이 정확하게 10진 실수를 표현하는 클래스

* 정수로 초기화하거나 '0.1' 형태의 문자열 실수로 초기화

* 실수 상수는 그 자체로 오차가 있기 때문에 Decimal 객체 생성에 사용할 수 없다.

  ```python
  Decimal(123)	# 정수로 초기화
  Decimal('3.14') # 실수 문자열로 초기화
  Decimal('3.14e3') # 부동 소수점 형태의 초기화 3140
  Decimal((0, (3,1,4), -2)) # 튜플로 초기화 3.14
  ```

##### Context 객체

* 연산을 수행하는 방법을 지정한다

##### Fraction

* 유리수를 표현

##### array 모듈

* 리스트보다 효율적, 사용하는 메모리 훨씬 적고 속도 훨씬 빠름

* 파이썬에는 배열이 없지만 array  모듈로 동일 타입의 집합인 배열을 지원

* 대량의 자료를 메모리 낭비 없이 저장하고 고속으로 엑세스가능

  ```python
  import array
  
  array(타입코드, [초기값])
  array('i', range(5,10))
  
  
  # i : 2바이트의 정수
  # 첫 번째 인수로 배열 요소의 타입을 밝힌다
  # 생성과 동시에 초기값을 지정할 때는 두 번째 인수로 초기값 나열
  ```

* 동일 타입의 자료 집합이라는 것 외에는 리스트와 거의 유사해 리스트에서 가능한 대부분의 연산을 지원
* 배열 생성 후 추가, 삽입, 삭제 가능, [] 기호로 위치 지정하여 요소 읽을 수 있고 슬라이스 지원


