--집합 연산을 할 때는 SELECT 문의 컬럼 개수와 타입이 일치해야 한다.


--union all - 중복 포함
select colour, shape from my_brick_collection
union all
select colour, shape from your_brick_collection;

--union - 중복 제거
select colour, shape from my_brick_collection
union
select colour, shape from your_brick_collection;


--intersect - 교집합
select colour, shape from my_brick_collection
intersect
select colour, shape from your_brick_collection;

--minus - 차집합
select colour, shape from my_brick_collection
minus
select colour, shape from your_brick_collection;
