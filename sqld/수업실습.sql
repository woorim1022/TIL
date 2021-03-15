-- #직원정보를 출력한다. 직원의 연봉 정보와 연봉의 세금 정보를 같이 출력한다.
SELECT *, CAST(salary*0.1 AS INTEGER) AS '세금'
FROM emp;

-- # 직원정보 중 2000 이전에 입사한
SELECT *
FROM emp
WHERE YEAR(hdate) < '2001'
AND salary < 4000;

-- # 매니저가 있는 직원 중 이름에 '자'가 들어가 있는 직원정보 조회
SELECT *
FROM emp
WHERE empname LIKE '%자%';


-- # 월급이 2000 미만은 '하', 4000 미만은 '중' 4000 이상은 '고'를 출력
SELECT *,
CASE
WHEN (salary < 2000) THEN '하'
WHEN (salary < 4000) THEN '중'
WHEN (salary >= 4000) THEN '고'
ELSE '모름'
END
FROM emp

-- # 2000년 이후 입사 한 사원들의 정보를 출력
-- # 사번, 이름, 타이틀, 부서, 지역
SELECT e.empno, e.empname, t.titlename, d.deptname, d.deptloc
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
INNER JOIN title t
ON e.titleno = t.titleno
WHERE YEAR(hdate) > '2000';
​


-- #2. 부서 이름 별 월급의 평균을 구하시오
-- #단, 평균이 3000 이상인 부서만 출력
SELECT d.deptname, AVG(salary)
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
GROUP BY d.deptname
HAVING AVG(salary) > 3000



-- #3. 경기 지역의 직원 들의 평균 연봉을 구하시오
SELECT d.deptloc AS 지역, AVG(salary)
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE d.deptloc = '경기';
​

-- #4. 홍영자 직원와 같은 부서 직원들의 근무 월수를 구하시오
SELECT empname, PERIOD_DIFF(DATE_FORMAT(CURRENT_DATE,'%Y%m'), DATE_FORMAT(hdate,'%Y%m')) AS 근무월수
FROM emp e
WHERE deptno = (SELECT deptno FROM emp WHERE empname = '김영자');


-- # 입사 년수가 가장 많은 직원 순으로 정렬하여 순위를 정한다
-- # 이름, 부서명, 직위, 년수
SELECT RANK() OVER(ORDER BY 년수 DESC) 순위, empname, deptname, titlename, YEAR(CURRENT_DATE)-YEAR(hdate) AS 년수
FROM emp e
LEFT OUTER JOIN dept d
ON e.deptno = d.deptno
INNER JOIN title t
ON e.titleno = t.titleno
ORDER BY 년수 DESC;

-- # 5. 부서 별 월급의 평균을 구하시오
-- # 단, 평균이 3000 이상인 부서만 출력
SELECT deptno, AVG(salary)
FROM emp
GROUP BY deptno
HAVING AVG(salary)> 3000;
​

-- # 6. 부서 별 대리와 사원 연봉의 평균을 구하시오
-- # 단, 평균이 2500 이상인 부서만 출력
SELECT deptno, AVG(salary)
FROM emp
WHERE titleno = 20
OR titleno = 10
GROUP BY deptno
HAVING AVG(salary)> 2500;
​

​

-- # 7. 2000년 부터 2002년에 입사는 직원들의 월급의 평균을 구하시오
SELECT AVG(salary)
FROM emp
WHERE YEAR(hdate) >= '2000' AND YEAR(hdate) <= '2002'
​

-- # 8. 부서 별 월급의 합의 ranking을 1위부터 조회 하시오
SELECT RANK() OVER(ORDER BY SUM(salary) DESC) 'rank', deptno, SUM(salary)
FROM emp
GROUP BY deptno
ORDER BY 'rank';

​

-- #9. 서울에서 근무하는 직원들을 조회 하시오
SELECT emp.*
FROM emp
INNER JOIN dept
ON emp.deptno = dept.deptno
WHERE dept.deptloc = '서울';
​

-- # 10. 이영자가 속한 부서의 직원들을 조회 하시오
SELECT *
FROM emp
WHERE deptno = (SELECT deptno FROM emp WHERE empname = '이영자');

​

-- # 11. 김강국의 타이틀과 같은 직원들을 조회 하시오
SELECT emp.*
FROM emp
WHERE titleno = (SELECT titleno FROM emp WHERE empname = '이강국');



-- 1. 사원 정보를 조회 한다. 
-- 사원의 모든 정보와 사원의 Manager 정보 까지 조회 한다.
-- 추가 적으로 사원의 부서와 타이틀 정보 까지 조회 한다.
SELECT e1.*, IFNULL(e2.empname, '없음') 매니저이름
FROM emp e1
LEFT OUTER JOIN emp e2
ON e1.manager = e2.empno;



​

-- 2. 사원 정보를 조회 한다. 
-- 사원의 모든 정보와 사원의 Manager 정보 까지 조회 한다.
SELECT e1.*, IFNULL(e2.empname, '없음') 매니저이름, d.deptname, t.titlename
FROM emp e1
LEFT OUTER JOIN emp e2
ON e1.manager = e2.empno
INNER JOIN dept d
ON e1.deptno = d.deptno
INNER JOIN title t
ON e1.titleno = t.titleno;