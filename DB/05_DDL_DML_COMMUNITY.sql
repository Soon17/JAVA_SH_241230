/*
다음을 만족하는 쿼리를 작성해서 데이터베이스와 테이블을 작성하세요.
데이터베이스명 : COMMUNITY
테이블명 : BOARD
	- 게시글은 제목, 내용, 작성자를 입력하여 등록한다
    - 제목은 최대 50자, 내용은 긴 문장, 작성자는 최대 15자
    - 게시글은 게시글 목록에서 번호, 제목, 작성자, 작성일, 조회수를 확인할 수 있다
    - 작성일은 연, 월, 일, 시, 분, 초를 확인할 수 있다
*/
DROP DATABASE IF EXISTS COMMUNITY;
CREATE DATABASE COMMUNITY;

USE COMMUNITY;

DROP TABLE IF EXISTS BOARD;
CREATE TABLE BOARD(
	B_NUM INT PRIMARY KEY AUTO_INCREMENT,
    B_TITLE VARCHAR(50) NOT NULL,
    B_CONTENT LONGTEXT NOT NULL,
    B_WRITER VARCHAR(15) NOT NULL,
    B_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    B_VIEW INT NOT NULL DEFAULT 0
);

# ABC123 회원이 "인사"라는 제목으로 "안녕하세요"라는 내용을 작성했을때 필요한 쿼리
INSERT INTO BOARD(B_TITLE, B_CONTENT, B_WRITER)
VALUE ("인사", "안녕하세요", "ABC123");

# 1번 게시글을 클릭해서 게시글 내용을 조회할 때 필요한 쿼리 => 조회수 증가, 내용 출력

# 조회수 증가
UPDATE BOARD
SET B_VIEW = B_VIEW + 1
WHERE B_NUM = 1;

# 1번 게시글 조회
SELECT 
    *
FROM
    BOARD
WHERE
    B_NUM = 1;

# ABC123 회원이 1번 게시글을 삭제할 때 쿼리
-- DELETE FROM BOARD WHERE B_NUM = 1;

# 샘플 데이터 추가
INSERT INTO BOARD(B_TITLE, B_CONTENT, B_WRITER) VALUES
("밥팟구함", "제곧내", "QWER"),("안녕히계세요 여러분", "떠납니다", "ASDF"),
("내 이름은 남도일", "탐정이죠", "ZXCV"),("제목이 뭐냐 물으신다면", "대답해 드리는게 인지상정", "WASD");

# 2025년 2월 25일에 작성된 게시글을 조회하는 쿼리
SELECT *
FROM BOARD
WHERE B_DATE BETWEEN "2025-02-25" AND "2025-02-25 23:59:59";

# 제목이나 내용에 "안녕"을 포함하는 게시글을 조회하는 쿼리
SELECT *
FROM BOARD
WHERE B_TITLE LIKE "%안녕%" OR B_CONTENT LIKE "%안녕%";

# 최신 글을 조회하는 쿼리 -> 등록 날짜 최근
SELECT *
FROM BOARD
ORDER BY B_DATE DESC;

# 인기 글을 조회하는 쿼리 -> 조회수 가장 높음
SELECT *
FROM BOARD
ORDER BY B_VIEW DESC;