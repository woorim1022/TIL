
--empno 와 mgr 은 계층형 데이터이다
--lpad() 함수를 사용해 레벨별로 공백을 줘서 계층을 명확하게 표현
--start with mgr 을 통해 관리자번호가 부모컬럼임을 알 수 있으며
-- is null 조건을 통해 관리자 번호가 없는 사원에서 부터 시작한다는 것을 알 수 있음
--connect by 자식데이터 지정 가능, 
--prior empno = mgr을 통해 empno가 자식데이터이고, 
--자식데이터 앞에 prior이 붙어있으므로 순방향 (부모->자식)임을 알 수 있다.
select level, lpad(' ',4*(level-1))||empno 사원, ename 이름, job 직급, mgr 상사,connect_by_isleaf isleaf
from emp
start with mgr is null
connect by prior empno = mgr;


LEVEL 사원	         이름	직급	    상사	ISLEAF
1	  7839	         KING	PRESIDENT	   - 	0
2	    7566	     JONES	MANAGER	    7839	0
3	      7788	     SCOTT	ANALYST	    7566	0
4	        7876     ADAMS	CLERK	    7788	1
3	      7902	     FORD	ANALYST	    7566	0
4	        7369     SMITH	CLERK	    7902	1
2	    7698	     BLAKE	MANAGER	    7839	0
3	      7499	     ALLEN	SALESMAN	7698	1
3	      7521	     WARD	SALESMAN	7698	1
3	      7654	     MARTIN	SALESMAN	7698	1
3	      7844	     TURNER	SALESMAN	7698	1
3	      7900	     JAMES	CLERK	    7698	1
2	    7782	     CLARK	MANAGER	    7839	0
3	      7934	     MILLER	CLERK	    7782	1



--역방향으로 특정 사원번호가 자신의 관리자 그리고 그 관리자의 관리자를 추적하여 최상위 루트를 찾아가는 쿼리
--start with empno='7876' 을 통해 시작 컬럼이 7876 임을 알 수 있음
--자식데이터를 시작 루트로 지정함으로써, 자식데이터가 자신의 상위 데이터를 찾아가게 함
--connect by prior mgr = empno 를 통해 역방향(자식 -> 부모) 임을 알 수 있음
select level, lpad(' ',4*(level-1)) || empno 사원, mgr 관리자, connect_by_isleaf isleaf
from emp
start with empno='7876'
connect by prior mgr = empno;


LEVEL	사원	    관리자	ISLEAF
1	    7876	    7788	0
2	      7788	    7566	0
3	        7566    7839	0
4	          7839	   - 	1




select connect_by_root(empno) 루트사원,
        sys_connect_by_path(empno,'/') 경로,
        empno 사원, mgr 관리자
from emp
start with mgr is null
connect by prior empno=mgr;


루트사원	    경로	        사원	 관리자
7839	/7839	                7839	    - 
7839	/7839/7566	            7566	7839
7839	/7839/7566/7788	        7788	7566
7839	/7839/7566/7788/7876	7876	7788
7839	/7839/7566/7902	        7902	7566
7839	/7839/7566/7902/7369	7369	7902
7839	/7839/7698	            7698	7839
7839	/7839/7698/7499	        7499	7698
7839	/7839/7698/7521	        7521	7698
7839	/7839/7698/7654	        7654	7698
7839	/7839/7698/7844	        7844	7698
7839	/7839/7698/7900	        7900	7698
7839	/7839/7782	            7782	7839
7839	/7839/7782/7934	        7934	7782