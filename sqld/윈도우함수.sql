
-- WINDOW 함수에는 OVER 문구가 키워드로 필수 포함된다.

-- SELECT WINDOW_FUNCTION (ARGUMENTS) OVER ( [PARTITION BY 칼럼]] [ORDER BY 절] [WINDOWING 절] )
--  FROM 테이블 명;


select * from emp;
select * from dept;
--RANK 함수는 ORDER BY를 포함한 QUERY 문에서 특정 항목(칼럼)에 대한 순위를 구하는 함수이다.
-- 이때 특정 범위(PARTITION) 내에서 순위를 구할 수도 있고 전체 데이터에 대한 순위를 구할 수도 있다. 또한 동일한 값에 대해서는 동일한 순위를 부여하게 된다.
SELECT JOB, ENAME, SAL,
       RANK( ) OVER (ORDER BY SAL DESC) ALL_RANK, 
       RANK( ) OVER (PARTITION BY JOB ORDER BY SAL DESC) JOB_RANK
  FROM EMP;


SELECT JOB, ENAME, SAL, 
   RANK() OVER (PARTITION BY JOB ORDER BY SAL DESC) JOB_RANK 
FROM EMP;


SELECT JOB, ENAME, SAL
    , RANK( ) OVER (ORDER BY SAL DESC) RANK
    , DENSE_RANK( ) OVER (ORDER BY SAL DESC) DENSE_RANK
FROM EMP; 
  
  
--ROW_NUMBER 함수는 RANK나 DENSE_RANK 함수가 동일한 값에 대해서는 동일한 순위를 부여하는데 반해, 동일한 값이라도 고유한 순위를 부여한다.
SELECT JOB, ENAME, SAL 
    , RANK( ) OVER (ORDER BY SAL DESC) RANK
    , ROW_NUMBER() OVER (ORDER BY SAL DESC) ROW_NUMBER
FROM EMP;
  
  
  
--SUM 함수를 이용해 파티션별 윈도우의 합을 구할 수 있다.
SELECT MGR, ENAME, SAL
    , SUM(SAL) OVER (PARTITION BY MGR) MGR_SUM 
FROM EMP;

SELECT MGR, ENAME, SAL
    , SUM(SAL) OVER (PARTITION BY MGR ORDER BY SAL RANGE UNBOUNDED PRECEDING) as MGR_SUM 
FROM EMP;

 --MAX 함수
SELECT MGR, ENAME, SAL
    , MAX(SAL) OVER (PARTITION BY MGR) as MGR_MAX 
FROM EMP;
  
  
SELECT MGR, ENAME, SAL 
FROM 
    ( SELECT MGR, ENAME, SAL
        , MAX(SAL) OVER (PARTITION BY MGR) as IV_MAX_SAL 
        FROM EMP
    ) 
WHERE SAL = IV_MAX_SAL ; 
 
--MIN 함수
SELECT MGR, ENAME, HIREDATE, SAL
    , MIN(SAL) OVER(PARTITION BY MGR ORDER BY HIREDATE) as MGR_MIN 
FROM EMP;
   
--avg 함수
-- EMP 테이블에서 같은 매니저를 두고 있는 사원들의 평균 SALARY를 구하는데,
-- 조건은 같은 매니저 내에서 자기 바로 앞의 사번과 바로 뒤의 사번인 직원만을 대상으로 한다.
SELECT MGR, ENAME, HIREDATE, SAL
    , ROUND (AVG(SAL) OVER (PARTITION BY MGR ORDER BY HIREDATE ROWS BETWEEN 1 PRECEDING AND 1 FOLLOWING)) as MGR_AVG 
FROM EMP; 

  
--count 함수
SELECT ENAME, SAL
    , COUNT(*) OVER (ORDER BY SAL RANGE BETWEEN 50 PRECEDING AND 150 FOLLOWING) as SIM_CNT
FROM EMP; 
  
  
--first_value 함수
-- FIRST_VALUE 함수를 이용해 파티션별 윈도우에서 가장 먼저 나온 값을 구한다.
-- SQL Server에서는 지원하지 않는 함수이다. MIN 함수를 활용하여 같은 결과를 얻을 수도 있다.
SELECT DEPTNO, ENAME, SAL
    , FIRST_VALUE(ENAME) OVER (PARTITION BY DEPTNO ORDER BY SAL DESC ROWS UNBOUNDED PRECEDING) as DEPT_RICH 
FROM EMP;

SELECT DEPTNO, ENAME, SAL
    , FIRST_VALUE(ENAME) OVER (PARTITION BY DEPTNO ORDER BY SAL DESC, ENAME ASC ROWS UNBOUNDED PRECEDING) as RICH_EMP
FROM EMP; 
  

--last_value 함수
-- LAST_VALUE 함수를 이용해 파티션별 윈도우에서 가장 나중에 나온 값을 구한다.
-- SQL Server에서는 지원하지 않는 함수이다. MAX 함수를 활용하여 같은 결과를 얻을 수도 있다.
SELECT DEPTNO, ENAME, SAL
    , LAST_VALUE(ENAME) OVER ( PARTITION BY DEPTNO ORDER BY SAL DESC ROWS BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING) as DEPT_POOR 
FROM EMP;
  
  
--lag 함수
-- LAG 함수를 이용해 파티션별 윈도우에서 이전 몇 번째 행의 값을 가져올 수 있다.
-- SQL Server에서는 지원하지 않는 함수이다.
-- LAG 함수는 3개의 ARGUMENTS 까지 사용할 수 있는데,
-- 두 번째 인자는 몇 번째 앞의 행을 가져올지 결정하는 것이고 (DEFAULT 1),
-- 세 번째 인자는 예를 들어 파티션의 첫 번째 행의 경우 가져올 데이터가 없어 NULL 값이 들어오는데
-- 이 경우 다른 값으로 바꾸어 줄 수 있다. 결과적으로 NVL이나 ISNULL 기능과 같다.
SELECT ENAME, HIREDATE, SAL
    , LAG(SAL) OVER (ORDER BY HIREDATE) as PREV_SAL 
FROM EMP 
WHERE JOB = 'SALESMAN';
 

SELECT ENAME, HIREDATE, SAL
    , LAG(SAL, 2, 0) OVER (ORDER BY HIREDATE) as PREV_SAL 
FROM EMP 
WHERE JOB = 'SALESMAN' ;

 --LEAD 함수
--  LEAD 함수를 이용해 파티션별 윈도우에서 이후 몇 번째 행의 값을 가져올 수 있다.
-- 참고로 SQL Server에서는 지원하지 않는 함수이다.
-- LEAD 함수는 3개의 ARGUMENTS 까지 사용할 수 있는데, 
-- 두 번째 인자는 몇 번째 후의 행을 가져올지 결정하는 것이고 (DEFAULT 1),
-- 세 번째 인자는 예를 들어 파티션의 마지막 행의 경우 가져올 데이터가 없어 NULL 값이 들어오는데
-- 이 경우 다른 값으로 바꾸어 줄 수 있다. 결과적으로 NVL이나 ISNULL 기능과 같다
SELECT ENAME, HIREDATE
    , LEAD(HIREDATE, 1) OVER (ORDER BY HIREDATE) as "NEXTHIRED" 
FROM EMP;
  

--RATIO_TO_REPORT 함수
-- RATIO_TO_REPORT 함수를 이용해 파티션 내 전체 SUM(칼럼)값에 대한 행별 칼럼 값의 백분율을 소수점으로 구할 수 있다.
-- 결과 값은 > 0 & <= 1 의 범위를 가진다.
-- 그리고 개별 RATIO의 합을 구하면 1이 된다. SQL Server에서는 지원하지 않는 함수이다.
-- 예제) JOB이 SALESMAN인 사원들을 대상으로 전체 급여에서 본인이 차지하는 비율을 출력한다.
SELECT ENAME, SAL
    , ROUND(RATIO_TO_REPORT(SAL) OVER (), 2) as R_R 
FROM EMP 
WHERE JOB = 'SALESMAN'; 


--PERCENT_RANK 함수
-- PERCENT_RANK 함수를 이용해 파티션별 윈도우에서 제일 먼저 나오는 것을 0으로,
-- 제일 늦게 나오는 것을 1로 하여, 값이 아닌 행의 순서별 백분율을 구한다.
-- 결과 값은 >= 0 & <= 1 의 범위를 가진다. 참고로 SQL Server에서는 지원하지 않는 함수이다.
SELECT DEPTNO, ENAME, SAL
    , PERCENT_RANK() OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) as P_R 
FROM EMP; 

--CUME_DIST 함수
-- CUME_DIST 함수를 이용해 파티션별 윈도우의 전체건수에서 현재 행보다 작거나 같은 건수에 대한 누적백분율을 구한다.
-- 결과 값은 > 0 & <= 1 의 범위를 가진다. 참고로 SQL Server에서는 지원하지 않는 함수이다.
SELECT DEPTNO, ENAME, SAL
    , CUME_DIST() OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) as CUME_DIST 
FROM EMP; 

--NTILE 함수
-- NTILE 함수를 이용해 파티션별 전체 건수를 ARGUMENT 값으로 N 등분한 결과를 구할 수 있다.
SELECT ENAME, SAL
    , NTILE(4) OVER (ORDER BY SAL DESC) as QUAR_TILE 
FROM EMP ;

  