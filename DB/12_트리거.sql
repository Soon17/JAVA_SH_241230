/*
트리거 : 테이블에 발생한 이벤트에 반응해 자동으로 실행되는 작업
	- 데이터 무결성을 지킬 수 있음 
    - 재고량 + 판매량 == 입고량 : 판매 수량만큼 재고량에서 빼주는 작업이 필요함. 
    - 이벤트 : INSERT, UPDATE, DELETE
    - 트리거가 발생된 테이블과 수정하려는 테이블이 같으면 에러 발생. 
*/

# 트리거 확인하는 쿼리
USE SAKILA;
SHOW TRIGGERS;

/*
트리거 삭제 
DELETE TRIGGER 트리거명;
*/
 
/*
트리거 등록
DELIMITER 기호
CREATE TRIGGER 트리거명 TRIGGER_TIME TRIGGER_EVENT ON 이벤트명 
FOR EACH ROW
BEGIN
	실행문;
END 기호 
DELIMITER ;

	- TRIGGER_TIME : 트리거가 작동되는 시점. BEFORE | AFTER
    - TRIGGER_EVENT : 트리거가 작동되는 이벤트. INSERT | UPDATE | DELETE
    - 트리거 안에서 사용되는 키워드 
		- OLD : DELETE, UPDATE 하기 전 데이터. OLD.속성 을 통해 활용 가능 
        - NEW : INSERT, UPDATE 한 후 데이터. NEW.속성 을 통해 활용 가능 
*/

USE STUDENT;
# 학생 성적이 추가되면 학생 평균을 수정하는 트리거
DROP TRIGGER IF EXISTS INSERT_SCORE;

DELIMITER ?!
CREATE TRIGGER INSERT_SCORE AFTER INSERT
ON SCORE
FOR EACH ROW
BEGIN
	DECLARE _AV_GRADE INT;
    DECLARE _AV_SEMESTER INT;
    
    SET _AV_GRADE = (	SELECT SJ_GRADE
						FROM SUBJECT
						WHERE SJ_NUM = NEW.SC_SJ_NUM);
    SET _AV_SEMESTER = (SELECT SJ_SEMESTER
						FROM SUBJECT 
                        WHERE SJ_NUM = NEW.SC_SJ_NUM);
	UPDATE AVERAGE
    SET
		AV_SUM = AV_SUM + NEW.SC_SCORE,
        AV_COUNT = AV_COUNT + 1
	WHERE
		AV_GRADE = _AV_GRADE AND
        AV_SEMESTER = _AV_SEMESTER AND
        AV_ST_KEY = NEW.SC_ST_KEY;
END ?!
DELIMITER ;

INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE) VALUES(20, 13, 100);