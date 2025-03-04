USE OMOK2;

DROP TRIGGER IF EXISTS INSERT_USER;
DELIMITER ?!
CREATE TRIGGER INSERT_USER AFTER INSERT
ON USER
FOR EACH ROW
BEGIN
	DECLARE _S_U_NAME VARCHAR(10);
    SET _S_U_NAME = (SELECT NEW.U_NAME);
    INSERT INTO SCORE(S_POSITION, S_U_NAME) VALUES
		("BLACK", _S_U_NAME), ("WHITE", _S_U_NAME);
END ?!
DELIMITER ;

DROP TRIGGER IF EXISTS INSERT_RESULT;
DELIMITER ?!
CREATE TRIGGER INSERT_RESULT AFTER INSERT
ON RESULT
FOR EACH ROW
BEGIN
    DECLARE _RE_WINNER ENUM("BLACK", "WHITE", "DRAW");
    DECLARE _RO_B_U_NAME VARCHAR(10);
    DECLARE _RO_W_U_NAME VARCHAR(10);
    
    SET _RE_WINNER = (SELECT NEW.RE_WINNER);
    SET _RO_B_U_NAME = (SELECT RO_B_U_NAME
						FROM RESULT
						JOIN ROOM ON RE_RO_ID = RO_ID
                        WHERE RO_ID = NEW.RE_RO_ID);
	SET _RO_W_U_NAME = (SELECT RO_W_U_NAME
						FROM RESULT
						JOIN ROOM ON RE_RO_ID = RO_ID
                        WHERE RO_ID = NEW.RE_RO_ID);
    
    UPDATE SCORE
    SET S_COUNT = S_COUNT + 1,
		S_WIN = CASE _RE_WINNER WHEN "BLACK" THEN S_WIN + 1 ELSE S_WIN END,
        S_LOSE = CASE _RE_WINNER WHEN "WHITE" THEN S_LOSE + 1 ELSE S_LOSE END,
        S_DRAW = CASE _RE_WINNER WHEN "DRAW" THEN S_DRAW + 1 ELSE S_DRAW END
	WHERE 
		S_U_NAME = _RO_B_U_NAME AND S_POSITION = "BLACK";
	
    UPDATE SCORE
    SET S_COUNT = S_COUNT + 1,
		S_WIN = CASE _RE_WINNER WHEN "WHITE" THEN S_WIN + 1 ELSE S_WIN END,
        S_LOSE = CASE _RE_WINNER WHEN "BLACK" THEN S_LOSE + 1 ELSE S_LOSE END,
        S_DRAW = CASE _RE_WINNER WHEN "DRAW" THEN S_DRAW + 1 ELSE S_DRAW END
	WHERE 
		S_U_NAME = _RO_W_U_NAME AND S_POSITION = "WHITE";
    
END ?!
DELIMITER ;