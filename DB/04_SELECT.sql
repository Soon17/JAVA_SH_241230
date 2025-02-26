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

/*
내장함수 - 조건

IF(식, 식1, 식2) : 식이 참이면 식1 반환, 거짓이면 식2 반환
IFNULL(식1, 식2) : 식1이 NULL이면 식2를, 아니면 식1을 반환
NULLIF(식1, 식2) : 식1과 식2가 같으면 NULL, 다르면 식1을 반환
CASE 속성
	WHEN 값1 THEN
		결과1
	WHEN 값2 THEN
		결과2
    ELSE
		결과3
END
*/
# 성적이 60 이상이면 통과, 미만이면 실패라고 출력하는 쿼리
SELECT *, IF(SC_SCORE >= 60, "O", "X") AS 통과
FROM SCORE;

SELECT *, CASE
			WHEN SC_SCORE >= 60
				THEN "O"
				ELSE "X" 
			END AS 통과
FROM SCORE;

# 성적이 90 이상이면 A, 80 이상이면 B, 70 이상이면 C,
#		60 이상이면 D, 60 미만이면 F로 출력하는 쿼리
SELECT *, IF(SC_SCORE >= 90, "A", 
			IF(SC_SCORE >= 80, "B",
            IF(SC_SCORE >= 70, "C",
            IF(SC_SCORE >= 60, "D", "F")))) AS 학점
FROM SCORE;

SELECT *, CASE
			WHEN SC_SCORE >= 90 THEN "A"
			WHEN SC_SCORE >= 80 THEN "B"
			WHEN SC_SCORE >= 70 THEN "C"
			WHEN SC_SCORE >= 60 THEN "D"
			WHEN SC_SCORE < 60 THEN "F"
			END AS 학점
FROM SCORE;

# 성적이 최고 성적과 같으면 NULL, 다르면 성적을 출력하는 쿼리
SELECT *, NULLIF(SC_SCORE, (SELECT MAX(SC_SCORE)
							FROM SCORE)) AS 결과
FROM SCORE;

/*
내장함수 - 문자열
*/
#CHAR_LENGTH(문자열) : 문자열 개수
SELECT CHAR_LENGTH("안녕하세요") AS CHAR_LENGTH;
#LENGTH(문자열) : 바이트 수
SELECT LENGTH("안녕하세요") AS LENGTH;
#CONCAT(문자열1, ...) : 문자열을 이어붙임
SELECT CONCAT("안녕", "하", "세요") AS CONCAT;
#FIELD(찾을 문자열, 문자열1, ...) : 찾을 문자열의 위치를 찾아 반환
SELECT FIELD("안녕", "안녕하", "누구안녕", "안녕") AS FIELD;
#INSTR(기준 문자열, 부분 문자열) : 기준 문자열에서 부분 문자열의 위치를 찾아 변환
SELECT INSTR("HELLO SQL", "SQL") AS INSTR;
#LOCATE(부분 문자열, 기준 문자열) : 기분 문자열에서 부분 문자열의 위치를 찾아 변환
SELECT LOCATE("JAVA", "HELLO JAVA") AS LOCATE;
#FORMAT(숫자, 소수점자리) : 숫자를 소수점 이하 자리까지 표현, 1000단위마다 ','를 추가
SELECT FORMAT(10000.12, 3) AS FORMAT;
#BIN(숫자), OCT(숫자), HEX(숫자) : 2, 8, 16진수로 변환
SELECT BIN(255) AS BIN, OCT(255) AS OCT, HEX(255) AS HEX;
#INSERT(기준 문자열, 위치, 길이, 삽입 문자열) : 기준 문자열의 위치에서 길이만큼 지우고 삽입할 문자열을 넣음
SELECT INSERT("HELLO JAVA", 7, 4, "SQL") AS `INSERT`;
#LEFT(문자열, 길이), RIGHT(문자열, 길이) : 왼쪽/오른쪽에서 문자열의 길이만큼 반환
SELECT LEFT("TEST.TXT", 4) AS `LEFT`, RIGHT("TEST.TXT", 3) AS `RIGHT`;
#LOWER(문자열), UPPER(문자열) : 소문자/대문자로
SELECT LOWER("HELLO SQL") AS LOWER, UPPER("HELLO SQL") AS UPPER;
#LPAD(문자열, 길이, 채울 문자열)/RPAD(문자열, 길이, 채울 문자열) : 문자열을 길이만큼 늘리고 빈곳을 문자열로 채움
SELECT LPAD(1, 3, "0") AS LPAD, RPAD(1, 3, "0") AS RPAD;
#REPEAT(문자열, 횟수) : 문자열을 횟수만큼 반복
SELECT REPEAT(1, 3) AS `REPEAT`;
#REPLACE(문자열, 문자열A, 문자열B) : 문자열에서 문자열A를 문자열B로 바꿈
SELECT REPLACE("HELLO JAVA", "JAVA", "SQL") AS `REPLACE`;
#REVERSE(문자열) : 문자열을 역순을 반환
SELECT REVERSE("ABCDEF") AS REVERSE;
#SUBSTRING(문자열, 시작위치, 길이) : 문자열에서 시작위치부터 길이만큼 부분 문자열을 반환
SELECT SUBSTRING("HELLO JAVA", 7, 4) AS SUBSTRING;