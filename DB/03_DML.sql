# INSERT : 데이터 추가
# SELECT : 데이터 조회
# UPDATE : 데이터 수정
# DELETE : 데이터 삭제

# 데이터 추가
/*
INSERT INTO 테이블명 VALUE(값1, .., 값N)
	- 값들의 순서는 속성 순서에 맞게 넣어주어야 함
    - 테이블명 대신 DB명.테이블명으로 해도 됨
    - DB명.테이블명으로 쓰면 선택된 DB와 상관없이 실행
    - 테이블명만 쓰면 선택된 DB에 따라 동작되지 않을 수 있음
*/
INSERT INTO STUDENT VALUE(5,1,1,7,"홍길동");

/*
INSERT INTO 테이블명(속성1, ..., 속성N) VALUE(값1, ..., 값N)
	- 일부 속성값을 생략할 때 사용
    - 생략할 수 있는 속성들
		1. NULL 허용인 속성들
        2. NOT NULL이지만 DEFAULT를 이용하여 기본값을 지정한 속성들
*/
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUE(1,1,2,"임꺽정");
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUE(3,"고길동");

# INSERT INTO 테이블명(속성1, ..., 속성N) VALUES(값1, ..., 값N), (값1, ..., 값N), ...;
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUES(4,"둘리"), (5,"하니");

/*
INSERT INTO 테이블명(속성1, ..., 속성N) SELECT 값1, ..., 값N FROM 테이블명 WHERE 조건
	- 테이블에 검색된 값을 이용하여 추가할 때 사용
    - 여기서 값1, 값2, ...들은 지정된 갑스 속성A는 검색 결과값
*/

# 데이터 수정
/*
UPDATE 테이블명 SET 속성1=값1, ..., 속성N=값N WHERE 조건
	- 조건에서 같다는 =, 반대는 != 또는 <>
    - NULL과 같다는 IS NULL, 반대는 IS NOT NULL
*/

# 1학년 1반 1번 학생의 이름을 홍길동A로 수정하는 쿼리
UPDATE STUDENT
SET ST_NAME = "홍길동A"
WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 7;

# 데이터 삭제
/*
DELETE FROM 테이블명 WHERE 조건;
*/

# 1학년 1반 2번 학생의 데이터를 삭제하는 쿼리
DELETE FROM STUDENT
WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 2;

# 학생 샘플 데이터 추가
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUES
(2, 1, 1, "해리"),(2, 1, 2, "론"),(2, 1, 3, "헤르미온느"),
(2, 2, 1, "말포이"),(2, 2, 2, "크레이브"),(2, 2, 3, "고일"),
(2, 3, 1, "네빌"),(2, 3, 2, "지니"),(2, 3, 3, "퍼시"),

(3, 1, 1, "덤블도어"),(3, 1, 2, "맥고나걸"),(3, 1, 3, "스네이프"),
(3, 2, 1, "루핀"),(3, 2, 2, "퀴렐"),(3, 2, 3, "록허트"),
(3, 3, 1, "볼드모트"),(3, 3, 2, "벨라트릭스"),(3, 3, 3, "루시우스");

# 과목 샘플 데이터 추가
INSERT INTO SUBJECT(SJ_GRADE, SJ_SEMESTER, SJ_NAME) VALUES
(1, 1, "국어"), (1, 1, "영어"), (1, 1, "수학"),
(1, 2, "국어"), (1, 2, "영어"), (1, 2, "수학"),
(2, 1, "국어"), (2, 1, "영어"), (2, 1, "수학"),
(2, 2, "국어"), (2, 2, "영어"), (2, 2, "수학"),
(3, 1, "국어"), (3, 1, "영어"), (3, 1, "수학"),
(3, 2, "국어"), (3, 2, "영어"), (3, 2, "수학");

# 성적 샘플 데이터 추가
INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE) VALUES
(10, 7, 100), (10, 8, 90), (10, 9, 90), # 20101 학생 2-1 국영수 성적
(11, 7, 90), (11, 8, 50), (11, 9, 70), # 20102 학생 2-1 국영수 성적
(12, 7, 100), (12, 8, 100), (12, 9, 100), # 20103 학생 2-1 국영수 성적
(13, 10, 70), (13, 11, 80), (13, 12, 70), # 20201 학생 2-2 국영수 성적
(14, 10, 50), (14, 11, 60), (14, 12, 70), # 20202 학생 2-2 국영수 성적
(15, 10, 70), (15, 11, 50), (15, 12, 50), # 20203 학생 2-2 국영수 성적
(16, 10, 80), (16, 11, 70), (16, 12, 70), # 20303 학생 2-2 국영수 성적
(17, 10, 90), (17, 11, 90), (17, 12, 100), # 20303 학생 2-2 국영수 성적
(18, 10, 99), (18, 11, 98), (18, 12, 97), # 20303 학생 2-2 국영수 성적
(19, 13, 100), (19, 14, 100), (19, 15, 100); # 30101 학생 3-1 국영수 성적

/*
INSERT SELECT
*/
# 2학년 1반 1번의 2학년 2학기 국어 성적을 100으로 추가할 때 쿼리
SELECT ST_KEY, SJ_NUM
FROM STUDENT
JOIN SUBJECT
WHERE ST_GRADE = 2 AND ST_CLASS = 1 AND ST_NUM = 1
		AND SJ_GRADE = 2 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어";
# 위와 동일
SELECT ST_KEY, SJ_NUM
FROM (SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 2 AND ST_CLASS = 1 AND ST_NUM = 1) AS T1
JOIN (SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 2 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어") AS T2;

INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE)
SELECT ST_KEY, SJ_NUM, 100
FROM (SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 2 AND ST_CLASS = 1 AND ST_NUM = 1) AS T1
JOIN (SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 2 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어") AS T2;
