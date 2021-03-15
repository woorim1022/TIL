-- 테이블 생성 CREATE문
create table emp(  
  empno    number(4,0),  
  ename    varchar2(10),  
  job      varchar2(9),  
  mgr      number(4,0),  
  hiredate date,  
  sal      number(7,2),  
  comm     number(7,2),  
  deptno   number(2,0),  
  constraint pk_emp primary key (empno),  
  constraint fk_deptno foreign key (deptno) references dept (deptno)  
)

-- 데이터 삽입문 
insert into DEPT (DEPTNO, DNAME, LOC)
values(10, 'ACCOUNTING', 'NEW YORK')

-- 테이블 수정 ALTER문
--# 컬럼추가
alter table person add age numeric;
-- 컬럼삭제 
alter table person drop column age;
-- 컬럼 내용 변경
alter table person modify (name varchar(10) not null);
-- 컬럼명 변경
alter table person rename column name to firstname;

-- 테이블명 변경 RENAME문
rename woorim to person;

-- 테이블 삭제 DROP문
drop table person;

-- SELECT문
select * from dept;
select * from emp;

-- BETWEEN a AND b 연산자
select * from emp where SAL between 1250 and 1500;

-- IN (list) 연산자
select * from emp where JOB in ('MANAGER', 'CLERK'); 

-- 와일드카드 %, _
select * from emp where ENAME LIKE '%E%';
select * from emp where ENAME LIKE '%E_';
select * from emp where ENAME LIKE '___E_';

-- IS NULL 연산자
select * from emp where MGR is null;

-- NOT IN (list) 연산자
select * from emp where JOB not in ('PRESIDENT','MANAGER','CLERK');

-- IS NOT NULL 연산자
select * from emp where COMM is not null;

-- <> 연산자
select * from emp where JOB <> 'SALESMAN';

-- NULL값과의 수치연산
select EMPNO, ENAME, SAL, SAL+null as nullexp from emp;

-- ROWNUM 레코드에 순번메김
select rownum, e.* from emp e;

-- CONCAT() 함수 - 문자열 붙이기
select e.*, concat(ENAME,'good~') from emp e;

-- SUBSTR() 함수 - n번째부터 문자 m개
select e.*, SUBSTR(ENAME,2,3) from emp e;

-- LEN() 함수 - 문자열길이
select e.*, LENGTH(ENAME) from emp e;

-- ROUND(), TRUNC() 함수 - 각각 소수 n번째 자리 뒤로 반올림, 버림
select ROUND(SAL/7,2), TRUNC(SAL/7,2) from emp e;

-- SIGN() 함수 - 양수, 음수, 0
select SIGN(SAL*1),SIGN(SAL*-1),SIGN(SAL*0) from emp e;

-- MOD() 함수 - 나머지
select e.*, MOD(SAL,7) from emp e;

-- LTRIM(), RTRIM(), TRIM() 함수 - 문자열 잘라내기
select LTRIM('xxxYYXXxYX','x') from dept;
select RTRIM('XXYYzzXYZZ','z') from dept;
select RTRIM('XXYYzzXYzz','z') from dept;
select TRIM('x' FROM 'xxYYZZxYZxx') from dept;

-- 날짜형함수

-- NULL 관련 함수
-- nvl(), nullif() 함수
select COMM, nvl(COMM,0), DEPTNO, nullif(DEPTNO,10) from emp e;

-- 집계함수
-- stddev() 함수 - 표준편차
select JOB, STDDEV(SAL) from emp group by JOB;
-- COUNT(*), COUNT(식) 차이 - null포함, null 제외
select JOB, COUNT(*), COUNT(COMM) from emp group by JOB;






