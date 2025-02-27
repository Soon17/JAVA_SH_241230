/*
JOIN : 여러 테이블을 묶어서 하나의 결과 테이블을 만들 때 활용
INNER JOIN : 두 테이블의 교집합
	- 성적이 등록된 학생들의 과목 성적을 조회
		-> 성적이 등록되지 않은 학생들은 조회 X
        -> 성적이 등록되지 않은 과목들은 조회 X
OUTER JOIN : 두 테이블의 합집합
	- 모든 과목들의 성적을 조회
		-> 성적이 등록되지 않은 학생들은 조회 X
        -> 성적이 등록되지 않은 과목들은 조회 O
	- 모든 학생들의 과목 성적을 조회
		-> 성적이 등록되지 않은 학생들은 조회 O
        -> 성적이 등록되지 않은 과목들은 조회 X
SELF JOIN : 하나의 테이블로 JOIN
*/

/*
테이블A가 테이블B에 참조되어 있으면 테이블B에는 외래키,
테이블 A에는 기본키로 연결이 되어있을 때 JOIN을 사용
	->	학생 테이블이 성적 테이블에 참조되고 있으면
		성적테이블의 외래키로 SC_ST_KEY,
		학생테이블의 ST_KEY로 연결이 되어있음
        
INNER JOIN

SELECT 테이블A.속성1, 테이블A.속성2, ..., 테이블B.속성1, 테이블B.속성2, ...
FROM 테이블
JOIN 테이블B ON 테이블A.기본키 = 테이블B.외래키
	- 속성명이 겹치지 않으면 테이블명을 쓰지 않아도 됨
*/

# 성적이 등록된 모든 학생들의 성적을 조회하는 쿼리
SELECT ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름,
		SJ_GRADE 과목학년, SJ_SEMESTER 학기, SJ_NAME 과목, SC_SCORE 성적
FROM SCORE
JOIN STUDENT ON STUDENT.ST_KEY = SCORE.SC_ST_KEY
JOIN SUBJECT ON SCORE.SC_SJ_NUM = SUBJECT.SJ_NUM;

/*
VIEW를 이용한 쿼리 재사용
VIEW는 미리 정의된 쿼리를 이용해서 마치 일반 테이블처럼 사용하는 가상의 테이블
장점 : 재사용, 가독성, 쿼리 단순화, 보안 강화
CREATE VIEW 뷰명 AS SELECT 쿼리문;
*/

DROP VIEW STUDENT_SCORE;
CREATE VIEW STUDENT_SCORE AS
SELECT ST_GRADE 학년, ST_CLASS 반, ST_NUM 번호, ST_NAME 이름,
	SJ_GRADE 과목학년, SJ_SEMESTER 학기, SJ_NAME 과목, SC_SCORE 성적,
    ST_KEY 학생번호
FROM SCORE
JOIN STUDENT ON STUDENT.ST_KEY = SCORE.SC_ST_KEY
JOIN SUBJECT ON SCORE.SC_SJ_NUM = SUBJECT.SJ_NUM;
    
SELECT *
FROM STUDENT_SCORE;


# 2학년들의 2학기 국어 성적을 구하는 쿼리
SELECT *
FROM STUDENT_SCORE
WHERE 학년 = 2 AND 과목학년 = 2 AND 학기 = 2 AND 과목 = "국어";

# 2학년들의 2학기 국어 성적의 평균을 구하는 쿼리
SELECT 학년, 과목학년, 학기, AVG(성적) 평균
FROM STUDENT_SCORE
WHERE 학년 = 2 AND 과목학년 = 2 AND 학기 = 2 AND 과목 = "국어";


# 2학년들의 2학기 국어 성적의 평균을 각 반별로 구하는 쿼리
SELECT 학년, 반, 학기, AVG(성적) AS 평균
FROM STUDENT_SCORE
WHERE 학년 = 2 AND 과목학년 = 2 AND 학기 = 2 AND 과목 = "국어"
GROUP BY 반;

# 각 학생별 평균(학년, 학기별)을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, 과목학년, 학기, AVG(성적) 평균
FROM STUDENT_SCORE
GROUP BY 학생번호, 과목학년, 학기;

# 각 학생의 학년별 평균을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, 과목학년, AVG(성적) 평균
FROM STUDENT_SCORE
WHERE 과목학년 = 2
GROUP BY 학생번호, 과목학년;

# 각 학생의 2학년 평균이 가장 높은 학생을 조회하는 쿼리
SELECT 학년, 반, 번호, 이름, 과목학년, AVG(성적) 평균
FROM STUDENT_SCORE
WHERE 과목학년 = 2
GROUP BY 학생번호, 과목학년
ORDER BY 평균 DESC
LIMIT 1;

/*
OUTER JOIN

SELECT 속성, ...
FROM 테이블A
LEFT | RIGHT JOIN 테이블B ON 테이블A.속성1 = 테이블B.속성2;
	- OUTER 조인은 순서가 중요
    - 왼쪽 테이블을 기준으로 연결
*/

# 모든 과목의 평균을 조회하는 쿼리
SELECT SUBJECT.*, IFNULL(AVG(SC_SCORE), 0) 평균
FROM SUBJECT
LEFT JOIN SCORE ON SJ_NUM = SC_SJ_NUM
GROUP BY SJ_NUM;

# 모든 학생의 평균을 조회하는 쿼리, 성적이 없으면 0
SELECT STUDENT.*, IFNULL(AVG(SC_SCORE), 0) 평균
FROM STUDENT
LEFT JOIN SCORE ON SC_ST_KEY = ST_KEY
GROUP BY ST_KEY;

# 등록된 학생 수를 조회하는 쿼리
SELECT COUNT(*) 학생수
FROM STUDENT;

/*
CROSS JOIN : 모든 경우의 수를 조합하여 합치는 조인
*/
SELECT *
FROM STUDENT
JOIN SUBJECT;

# JOIN USING : 테이블B의 외래키와 테이블A의 외래키가 같은 경우(속성이름)
/*
SELECT *
FROM 테이블A
JOIN 테이블B ON 테이블B.속성1 = 테이블A.속성1;
-> 
SELECT *
FROM 테이블A
JOIN 테이블B USING(속성1);
*/

/*
서브쿼리 : 쿼리 안에 쿼리가 들어가는 형태
	장점
		- 쿼리의 구조화
        - JOIN보다 가독성이 높음
        - 속도를 향상시킬 수 있음
	적용 위치
		- SELECT문에서 속성위치
        - SELECT문에서 FROM 다음에 나오는 테이블명 위치
        - SELECT문에서 WHERE절에서 특정 값 위치
        - SELECT문에서 HAVING절에서 특정 값 위치
        - INSERT SELECT
        - UPDATE문에서 수정할 값 위치
*/