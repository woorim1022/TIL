# 0120

p120

* salaries 테이블 따로 있는 이유
  * from_date와 emp_no를 pk로 묶어서 변경된 히스토리를 기록하기 위함
  * salary 속성을 그냥 employees 테이블에 넣어도 됨
  * title 등 다른 테이블도 마찬가지

* 테이블 설계

  ```sql
  CREATE TABLE dept(
  	deptno CHAR(2) PRIMARY KEY,
      deptname NVARCHAR(20),
      deptloc NVARCHAR(20)
  );
  
  CREATE TABLE title(
  	titleno CHAR(2) PRIMARY KEY,
      titlename NVARCHAR(20)
  );
  
  CREATE TABLE emp(
  	empno CHAR(4) PRIMARY KEY,
      titleno CHAR(2),
      deptno CHAR(2),
      empname NVARCHAR(10),
      manager CHAR(4),
      salary INT(5),
      hdate DATE
  );
  
  # 실제 개발 할 때는 제약사항을 적용하지 않고 최종적으로 테스트 할 때 적용한다
  ALTER TABLE emp
  	ADD CONSTRAINT fk_title
  	FOREIGN KEY (titleno)
  	REFERENCES title (titleno);
  ALTER TABLE emp
  	ADD CONSTRAINT fk_dept
  	FOREIGN KEY (deptno)
  	REFERENCES dept (deptno);
  	
  	
  	
  INSERT INTO title VALUES(10,'사원');
  INSERT INTO title VALUES(20,'대리');
  INSERT INTO title VALUES(30,'과장');
  INSERT INTO title VALUES(40,'사장');
  INSERT INTO title VALUES(50,'인턴');
  
  INSERT INTO dept VALUES(10,'본사','서울');
  INSERT INTO dept VALUES(20,'영업부','경기');
  INSERT INTO dept VALUES(30,'생산부','부산');
  INSERT INTO dept VALUES(40,'연구소','대전');
  
  INSERT INTO emp VALUES(1001,'40','10','킹',NULL,5000,'1997-01-01');
  INSERT INTO emp VALUES(1002,'30','20','이영업',1001,4300,'1998-01-01');
  INSERT INTO emp VALUES(1003,'30','30','김생산',1001,4800,'1999-01-01');
  INSERT INTO emp VALUES(1004,'30','40','홍연구',1001,4500,'1999-12-01');
  
  INSERT INTO emp VALUES(1005,'20','20','이말숙',1002,3500,'2000-01-01');
  INSERT INTO emp VALUES(1006,'10','20','김말숙',1002,2800,'2001-01-01');
  
  INSERT INTO emp VALUES(1007,'20','30','이영자',1003,3500,'2000-01-01');
  INSERT INTO emp VALUES(1008,'10','30','김영자',1003,2300,'2002-05-01');
  
  INSERT INTO emp VALUES(1009,'20','40','이강국',1004,3800,'2001-01-01');
  INSERT INTO emp VALUES(1010,'10','40','김정국',1004,2500,'2002-12-01');
  ```

  

### 조인

##### 이너조인

* pk가 명확하게 존재하는 상태에서 두 개 이상의 테이블을 조인해서 사용할 수있다

```sql
# 사장 '킹'은 출력되지 않는 문제 발생
# '킹'의 deptno가 NULL 이기 때문에 이너조인으로 매칭이 되지 않는다
SELECT e.*
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno;
	
SELECT e.empno, e.empname, d.deptname, t.titlename
FROM emp e 
	INNER JOIN dept d
		ON e.deptno = d.deptno
	INNER JOIN title t
		ON e.titleno = t.titleno;
	
```

##### 아우터조인

```sql
# outer join
# 기준 왼쪽/오른쪽 결정

# 본사 서울은 emp와 매치되지 않고 사장 킹은 dept와 매치되지 않지만 NULL값을 가진 채 출력된다
SELECT *
FROM emp e 
	LEFT OUTER JOIN dept d
		ON e.deptno = d.deptno
UNION        
SELECT *
FROM emp e 
	RIGHT OUTER JOIN dept d
		ON e.deptno = d.deptno;s
```



### 뷰

##### 뷰는 물리적으로 생성지는 않는다



