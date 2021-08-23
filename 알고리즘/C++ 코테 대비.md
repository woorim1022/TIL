# C++ 코테 대비

* C++ 이용한 알고리즘 문제풀이시 유용한 라이브러리, 함수 정리

https://velog.io/@gowoonsori/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%97%90%EC%9C%A0%EC%9A%A9%ED%95%9Ccpp%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%ACor%ED%95%A8%EC%88%98



### 배열

```c++
int arr1[5] = { 1, 2, 3 }; // 배열의 요소들은 { 1, 2, 3, 0, 0 } 으로 초기화 됨

int arr2[5]; // 배열의 요소들은 모두 쓰레기값으로 초기화 됨

int arr3[10] = { 0 }; // 배열의 요소들은 모두 0으로 초기화 됨
```

* 배열은 일반 변수와 같이 자료형(type)을 먼저 선언하고 배열의 이름(기본적으로 arr 또는 ary 등을 사용합니다)을 명시해준 후, 대괄호( ' [ ' , ' ] ' )를 사용해서 배열의 크기를 지정해 줍니다. 

* 이때 배열의 크기는 고정된 상수(양의 정수형 숫자)여야 하며 일반 변수를 지정해 줄 수 없습니다.

* 배열 요소의 자료형은 int(정수)형을 포함, 모든 기본 자료형(char, double 등)을 지원합니다.

* 또한 아래와 같이 크기를 명시 해 주지않고 배열의 요소를 모두 정의할 수 있습니다.

```c++
int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
```

* 배열의 이름은 배열의 시작주소이다

```c++
  arr = &arr[0] ;

  arr[2] = *(arr + 2);
```

##### 배열의 크기를 동적으로 만드는 방법

1.  int *p; // 포인터 변수 선언

2. int arr_size; // 배열의 크기를 입력받을 변수

3. cin >> arr_size; // 배열의 크기를 입력받음

4. p = new int[arr_size]; // 입력받은 크기만큼 배열을 동적 생성

5. delete[] p; // 사용이 끝난 후 메모리 해제

##### 벡터 사용법

```c++
vector<int> integer_vector;

vector<double> double_vector;

vector<char> char_vector;
```

* 벡터에 데이터 추가하기

```c++
for (int i = 0; i < 5; i++) {
    integer_vector.push_back(i);
    double_vector.push_back((double)i);
    char_vector.push_back('a' + i);
}
```

*  벡터 클래스에서 push_back() 함수를 이용하여 요소의 끝에 데이터를 추가할 수 있습니다.

* 지정된 위치에 요소를 추가하려면 insert() 함수를 사용하세요.

* 벡터의 데이터 삭제하기

```c++
integer_vector.pop_back(); // 요소 끝의 데이터 삭제

double_vector.erase(double_vector.begin()); // 지정된 위치의 데이터 삭제

char_vector.clear(); // 모든 데이터 삭제
```

* 벡터는 다음과 같은 내부 함수가 존재합니다.

​    begin() - 벡터의 첫번째 요소를 가리킵니다.

​    end() - 벡터의 마지막 요소를 가리킵니다.

​    size() - 벡터의 요소 수(크기)를 반환합니다.

​    resize() - 벡터의 크기를 재조정합니다.

​    empty() - 벡터가 비어있는지 여부(true or false)를 반환합니다.

​    at() (또는 [ ]) - 벡터의 인덱스에 접근할 수 있습니다.

​    front() - 벡터의 첫번째 요소를 반환합니다.

​    back() - 벡터의 마지막 요소를 반환합니다.

​    data() - 포인터가 접근할 수 있도록 벡터의 주소값을 반환합니다( int *p = vector1.data() )

