USE STUDENT;

/*
SELECT *
FROM 테이블명;
# 테이블에 있는 모든 속성들의 데이터를 조회하는 쿼리
*/
SELECT *
FROM STUDENT;

/*
SELECT 속성1, ..., 속성N
FROM 테이블명;
# 테이블에 있는 속성1, ..., 속성N의 데이터를 조회하는 쿼리
# 속성명 옆에 AS 새속성명을 입력하면 결과창에 속성이름을 변경할 수 있음
# AS 생략 가능
*/
SELECT ST_GRADE AS 학년, ST_CLASS AS "반", ST_NUM 번호, ST_NAME "이름"
FROM STUDENT;

/*
SELECT [DISTINCT] 속성1, ..., 속성N
FROM 테이블명
[WHERE 조건식]
# 조건식을 만족하는 속성들을 조회하는 쿼리
# 중복된 행 제거 => 기본키 속성을 포함하지 않는 경우 중복이 가능
# 논리 연산자
	- AND, OR, NOT
    - AND의 우선순위가 OR보다 높다
# 비교 연산자
	- =, !=, <>, <, <=, >, >=
    - 속성 BETWEEN A AND B : A 이상 B 이하
		-> 속성 >= A AND 속성 <= B
    - 속성 NOT BETWEEN A AND B : A 미만 또는 B 초과
		-> 속성 < A OR 속성 > B
    - 속성 IN(값1, ..., 값N) : 속성의 값이 값1, ..., 값N 중에 있을 때 참
		-> 속성 = 값1 OR ... OR 속성 = 값N
	- 속성 NOT IN(값1, ..., 값N) : 속성의 값이 값1, ..., 값N 중에 없을 때 참
		-> 속성 != 값1 AND ... AND 속성 != 값N
*/

# 등록된 학생들의 학년을 조회하는 쿼리
SELECT DISTINCT ST_GRADE 학년
FROM STUDENT;

# 1학년 학생들을 조회하는 쿼리
SELECT *
FROM STUDENT
WHERE ST_GRADE = 1;

# 1학년 1반의 번호가 1~3인 학생들을 조회하는 쿼리
SELECT *
FROM STUDENT
WHERE ST_NUM BETWEEN 1 AND 3  AND ST_CLASS = 1 AND ST_GRADE = 1;

SELECT *
FROM STUDENT
WHERE ST_NUM IN(1,2,3) AND ST_CLASS = 1 AND ST_GRADE = 1;

# 성이 홍씨인 학생들을 조회하는 쿼리
SELECT *
FROM STUDENT
WHERE ST_NAME LIKE "홍%";

SELECT *
FROM STUDENT
WHERE ST_NAME LIKE CONCAT("홍", "%");

# 이름에 길이 들어가는 학생들을 조회하는 쿼리
SELECT *
FROM STUDENT
WHERE ST_NAME LIKE "%길%";

# 성이 홍씨이고 이름이 3글자인 학생들을 조회하는 쿼리
SELECT *
FROM STUDENT
WHERE ST_NAME LIKE "홍__";

# 성이 홍씨가 아닌 학생들을 조회하는 쿼리
SELECT *
FROM STUDENT
WHERE ST_NAME NOT LIKE "홍%";

/*
# 정렬하는 쿼리
SELECT [DISTINCT] 속성1, ..., 속성N
FROM 테이블명
[WHERE 조건]
[ORDER BY 속성A [ASC|DESC] [,속성B [ASC|DESC]]

- ASC : 오름차순, 기본값
- DESC : 내림차순
*/

#학년은 역순으로 조회하고 학년이 같은 경우 반을 오름차순으로 정렬하고, 반이 같은 경우 번호를 오름차순으로 정렬
SELECT *
FROM STUDENT
ORDER BY ST_GRADE DESC, ST_CLASS, ST_NUM;

#3학년 학생들을 이름을 사전순으로 정렬하고, 이름이 같으면 반, 번호 순으로 오름차순 정렬
SELECT *
FROM STUDENT
WHERE ST_GRADE = 3
ORDER BY ST_NAME, ST_CLASS, ST_NUM;

#3학년 학생들 중 번호가 2에 가까운 학생 순으로 정렬
SELECT *, ABS(ST_NUM - 2) AS NUM
FROM STUDENT
WHERE ST_GRADE = 3
ORDER BY NUM, ST_NUM;

/*
# 결과에서 원하는 개수를 가져오는 쿼리
[LIMIT [번지,] 개수]

- 검색 결과에서 번지부터 개수만큼 가져옴
- 번지는 0번지부터
- 번지를 생략할 수 있고, 생략하면 0번지
*/

SELECT *
FROM STUDENT
LIMIT 3;	#0번지부터 3개

SELECT *
FROM STUDENT
LIMIT 8, 3;	#8번지부터 3개

# 한 페이지에 학생 3명의 정보를 조회하는 페이지가 있고, 학생 등록순으로 조회를 한다.
# 이 때 3 페이지에서 조회 가능한 학생들을 선택하는 쿼리
SELECT *
FROM STUDENT
LIMIT 6, 3; # 6 -> 3명 * (3페이지-1)

/*
# 그룹화 하는 쿼리
[GROUP BY 속성1 [, 속성2, ...]]
[HAVING 조건]

- 결과들을 그룹으로 묶어서 처리할 때
	1. 1학년 1반의 학생 수는?
    2. 각 학년별 각 반의 학생 수는?
    3. 각 학년의 학생 수는?
    
- 보통 집계 함수와 함께 사용
- GROUP BY는 묶는 기준
	1. 학년, 반을 기분으로 묶음
    2. 학년, 반을 기분으로 묶음
    3. 학년을 기준으로 묶음
- HAVING은 집계함수에 조건을 걸 때 사용

# 집계 함수
	COUNT(속성) : 결과의 개수를 셈 => NULL이 아닌 개수만 셈
    SUM(속성) : 속성의 합
    AVG(속성) : 속성의 평균
    MIN(속성) : 속성의 최소값
    MAX(속성) : 속성의 최대값
*/

# 1학년 1반의 학생 수를 조회하는 쿼리
SELECT COUNT(*) AS "1학년 1반 학생 수"
FROM STUDENT
WHERE ST_GRADE = 1 AND ST_CLASS = 1;

# 각 학년 각 반의 학생 수를 조회
SELECT ST_GRADE AS 학년, ST_CLASS AS 반, COUNT(*) AS 인원
FROM STUDENT
GROUP BY ST_GRADE, ST_CLASS;

# 각 학년 별 학생 수를 조회
SELECT ST_GRADE AS 학년, COUNT(*) AS 인원
FROM STUDENT
GROUP BY ST_GRADE;

# 학생 수가 7명 이상인 학년들을 조회
SELECT ST_GRADE AS 학년, COUNT(*) AS 인원
FROM STUDENT
GROUP BY ST_GRADE
HAVING 인원 >= 7;

# GROUP BY가 있는 쿼리에서 조건이 필요하면 무조건 HAVING에 써야한다? X
# 조건에 집계함수가 있으면 HAVING을 쓰지만 없으면 WHERE절을 쓴다.

/* GROUP BY 시 속성 에러 발생 해결 쿼리 */
SET GLOBAL SQL_MODE = "STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION";
/* 복구 쿼리 */
SET GLOBAL SQL_MODE = "STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION,ONLY_FULL_GROUP_BY";

SELECT *
FROM STUDENT
GROUP BY ST_GRADE;

# 각 학생별 평균을 조회하는 쿼리

SELECT STUDENT.*, IFNULL(AVG(SC_SCORE), 0) AS 평균
FROM SCORE
RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY
GROUP BY ST_KEY;

# 2학년 1반에서 등수를 조회하는 쿼리(평균)
# 평균이 같으면 국어, 영어, 수학 점수 순으로 비교하여 등수를 결정. 다 같으면 같은 등수
# 같은 등수가 나오는 경우, 다음 등수는 같은 등수만큼 건너뜀
SELECT RANK() OVER(ORDER BY 평균 DESC, 국어평균 DESC, 영어평균 DESC, 수학평균 DESC) 순위, T.*
FROM
	(
		SELECT STUDENT.*,
				IFNULL(AVG(SC_SCORE), 0) AS 평균,
                AVG(CASE WHEN SJ_NAME = "국어" THEN SC_SCORE END) 국어평균,
                AVG(CASE WHEN SJ_NAME = "수학" THEN SC_SCORE END) 수학평균,
                AVG(CASE WHEN SJ_NAME = "영어" THEN SC_SCORE END) 영어평균
		FROM SCORE
        JOIN SUBJECT ON SC_SJ_NUM = SJ_NUM
		RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY
		GROUP BY ST_KEY
	) AS T;

# 2학년에서 등수를 조회하는 쿼리(평균)
SELECT RANK() OVER(ORDER BY 평균 DESC) 순위, T.*
FROM
	(
		SELECT STUDENT.*, IFNULL(AVG(SC_SCORE), 0) AS 평균
		FROM SCORE
		RIGHT JOIN STUDENT ON SC_ST_KEY = ST_KEY
        WHERE ST_GRADE = 2
		GROUP BY ST_KEY
	) AS T;

# 2학년들의 성적평균을 사용하여 반 순위를 조회하는 쿼리
SELECT RANK() OVER(ORDER BY 반평균 DESC) 반순위, T.*
FROM (
	SELECT 학년, 반, AVG(개인평균) 반평균
	FROM (
		SELECT ST_GRADE 학년,ST_CLASS 반, ST_KEY 학생번호, IFNULL(AVG(SC_SCORE), 0) 개인평균
		FROM SCORE
		RIGHT JOIN STUDENT ON ST_KEY = SC_ST_KEY
		GROUP BY ST_KEY
		) AS T
	GROUP BY 학년, 반
    ) AS T;
    
/* 문제점을 찾아보자 3학년 1반의 평균이 이상하다 */
SELECT RANK() OVER(ORDER BY 반평균 DESC) 반순위, T.*
FROM (
	SELECT ST_GRADE 학년, ST_CLASS 반, IFNULL(AVG(IFNULL(SC_SCORE, 0)), 0) 반평균
	FROM SCORE
	RIGHT JOIN STUDENT ON ST_KEY = SC_ST_KEY
	GROUP BY ST_GRADE, ST_CLASS
    ) AS T;