USE OMOK2;

INSERT INTO USER(U_NAME, U_PW) VALUES
	("정순형", "1836"), ("박소은", "6974"),
    ("빅토리아", "5877"), ("김가람", "4485");
    
INSERT INTO ROOM(RO_NUM, RO_B_U_NAME, RO_W_U_NAME) VALUES
	(15, "정순형", "박소은"), (7, "김가람", "빅토리아");

INSERT INTO RESULT(RE_WINNER, RE_RO_ID) VALUES
	("BLACK", 1), ("WHITE", 2);