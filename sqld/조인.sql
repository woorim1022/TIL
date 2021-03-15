-- dept 테이블과 emp 테이블을 조인하는 예제
SELECT e.empno, e.ename, d.dname
  FROM dept d, emp e
 WHERE d.deptno = e.deptno;
 
-- INNER JOIN절을 이용하여 조인하는 예제
SELECT e.empno, e.ename, d.dname
  FROM dept d 
 INNER JOIN emp e
    ON d.deptno = e.deptno;
    
-- NATURAL JOIN절을 이용하여 조인하는 예제
SELECT  e.empno, e.ename, d.dname
  FROM  dept d 
NATURAL JOIN emp e;

-- JOIN~USING절을 이용하여 조인하는 예제
SELECT e.empno, e.ename, deptno 
  FROM emp e 
  JOIN dept d 
 USING (deptno);
 
 
-- emp 테이블과 salgrade 테이블의 Non-Equi Join 예제
SELECT e.ename,e.sal,s.grade
  FROM emp e, salgrade s
  WHERE e.sal 
BETWEEN 1000
    AND 2000;
    
-- 사원의 매니저명을 조회하는 Self Join 예제
SELECT e.ename, a.ename "Manager"
  FROM emp e, emp a
 WHERE e.empno = a.mgr;
 
 -- CROSS JOIN절을 이용하여 Cartesian Product 값을 얻는 예제
SELECT  e.empno, e.ename, d.dname
  FROM  dept d CROSS JOIN emp e;