# collections.deque

1. deque란

   double-ended queue의 줄임말로, 앞과 뒤에서 즉, 양방향에서 데이터를 처리할 수 있는 queue형 자료구조

![img](https://t1.daumcdn.net/cfile/tistory/99F9D33359986A1018)

​		python에서 deque는 list와 비슷하다. list의 append(), pop()등의 메소드를 deque에서도 제공한다.





2. collections.deque의 메소드들

   #### 1) append(x)

   `list.append(x)`와 마찬가지로 x를 `deque`의 오른쪽(마지막)에 추가(삽입)해준다.

   #### 2)appendleft(x)

   앞에서 설명했다시피, `deque`는 양방향에서 데이터를 처리할 수 있는 구조이다. 따라서, `append(x)`가 오른쪽에서 추가(삽입)을 해준다면, `appendleft(x)`는 왼쪽 즉, 앞쪽에서 x를 추가(삽입)해주는 메소드이다.

   #### 3) extend(iterable)

   `list.extend(iterable)`과 마찬가지로 `iterable argument(list, str, tuple...)의 오른쪽(마지막)에 `elements`를 추가(삽입)해주는 메소드이다.

   #### 4) extendleft(iterable)

   `collections.deque.extendleft()`는 `appendleft()`와 마찬가지로 왼쪽(앞쪽)에서 데이터를 추가해주는 메소드이다.

   #### 5) pop()

   `list.pop()`과 같이 오른쪽(마지막)에서 부터 차례대로 제거와 반환(*remove and return*)을 하는 메소드이다.

   #### 6) popleft()

   `pop()`의 반대로, 왼쪽(앞쪽)에서 부터 차례대로 제거와 반환(*remove and return*)을 하는 메소드이다.

   #### 7) rotate(n)

   `collections.deque.rotate(n)`은 요소들(elements)을 n값 만큼 회전 해주는 메소드이다. n의 값이 음수(negative)이면 왼쪽으로 회전하고, n의 값이 양수이면 오른쪽으로 회전한다.

   

   

   

   

   출처: https://excelsior-cjh.tistory.com/96 [EXCELSIOR]

