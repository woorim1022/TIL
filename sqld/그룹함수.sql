-- 1. ROLLUP 함수
-- 그룹핑된 컬럼의 소계를 생성하기 위해 사용.
-- 그룹핑된 컬럼의 수가 n 이면 소계는 N+1 레벨이 생성
SELECT DNAME, JOB, COUNT(*) "Total Empl",SUM(SAL) "Total Sal"
FROM EMP, DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO
GROUP BY ROLLUP (DNAME, JOB);

-- // 결과는 (부서명,직업)으로 그룹핑하고 해당 그룹의 총 인원과 총 급여를 출력한다.
-- // 그리고 그 부서별로 소계가 밑에 나오고 마지막으로 총계가 나온다.
 
 
-- * GROUPING 함수
SELECT 
    CASE GROUPING(DNAME) WHEN 1 THEN 'All Departments' ELSE DNAME END AS DNAME,
    CASE GROUPING(JOB) WHEN 1 THEN 'All Jobs' ELSE JOB END AS JOB,
    COUNT(*) "Total Empl",
    SUM(SAL) "Total Sal"
FROM EMP, DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO
GROUP BY ROLLUP (DNAME, JOB);
-- // GROUPING 함수가 컬럼에 추가되었는데
-- // GROUPING 함수는 ROLLUP이나 CUBE에 의해 소계가 생성되었을때 1이 표시되고 이외에는 0을 
-- 표시한다.
-- // 따라서 소계 필드에 원하는 문자열을 넣는등 보고서쓸때 적절하다.

-- => ROLLUP 함수 일부 사용
SELECT
    CASE GROUPING(DNAME) WHEN 1 THEN 'All Departments' ELSE DNAME END AS DNAME,
    CASE GROUPING(JOB) WHEN 1 THEN 'All Jobs' ELSE JOB END AS JOB,
    COUNT(*) "Total Empl",
    SUM(SAL) "Total Sal"
FROM EMP, DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO
GROUP BY DNAME, ROLLUP(JOB);
-- // 이렇게 ROLLUP을 JOB에만 사용했을 때 결과는 어떨까?
-- // 결과를 보면 기존과 같이 소계는 나오지만 부서별로 소계를 낼 필요가 없기 때문에
-- // 총 합계는 나오지 않는다.
 
 
 
-- 2. CUBE 함수
-- ROLLUP함수에서 단순히 소계만 생성했지만, CUBE는 결합 가능한 모든 값에 대하여 다차원
-- 집계를함
-- * 연산이 많아 시스템에 부담을 줌.
SELECT
    CASE GROUPING(DNAME) WHEN 1 THEN 'All Departments' ELSE DNAME END AS DNAME,
    CASE GROUPING(JOB) WHEN 1 THEN 'All Jobs' ELSE JOB END AS JOB,
    COUNT(*) "Total Empl",
    SUM(SAL) "Total Sal"
FROM EMP, DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO
GROUP BY CUBE(DNAME,JOB);
-- // ROLLUP은 부서별 소계와 총합계까지만 나타내줬으나
-- // CUBE는 직업(JOB)별로도 소계가 다 구해진다.
 
-- 3. GROUPING SETS 함수
-- 표시된 인수들에 대한 개별 집계를 구할 수 있으며,
-- ROLLUP인수의 계층구조와 달리 평등한 관계라 순서에 상관없이 동일한결과가 나옴.
SELECT DECODE(GROUPING(DNAME), 1, 'All Departments', DNAME) AS DNAME,
       DECODE(GROUPING(JOB), 1, 'All Jobs', JOB) AS JOB,
       COUNT(*) "Total Empl", SUM(SAL) "Total Sal"
FROM EMP, DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO
GROUP BY GROUPING SETS (DNAME, JOB);
-- // 부서별 모든 직업의 소계
-- // 직업별 모든 부서의 소계

