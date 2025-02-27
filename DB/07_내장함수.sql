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



/*
내장함수 - 날짜, 시간
*/

#ADDDATE/SUDATE(날짜, 차이) : 날짜를 기준으로 차이만큼 일(DATE)을 더한/뺀 날짜를 반환
SELECT ADDDATE("2025-02-27 13:00:00", 2);
SELECT ADDDATE(NOW(), 14);
SELECT SUBDATE(NOW(), 14);
#ADDTIME/SUTIME(날짜/시간, 차이) : 날짜/시간을 기준으로 차이만큼 시간을 더한/뺀 날짜/시간을 반환
SELECT ADDTIME(NOW(), "2:00:00");
SELECT ADDTIME(NOW(), "00:10:00");
#YEAR/MONTH/DAY(날짜) : 날짜에서 년/월/일을 구함
SELECT YEAR(NOW()) AS YEAR,
		MONTH(NOW()) AS MONTH,
        DAY(NOW()) AS DAY;
#HOUR/MINUTE/SECOND/MICROSECOND(시간) : 시간에서 시/분/초/마이크로초를 반환
SELECT HOUR(NOW()) AS HOUR,
		MINUTE(NOW()) AS MINUTE,
		SECOND(NOW()) AS SECOND,
        MICROSECOND(NOW(6)) AS MICROSECOND;
#DATE/TIME(날짜) : 날짜에서 년-월-일/시:분:초를 반환
SELECT DATE(NOW()) AS DATE, TIME(NOW()) AS TIME;
#DATEDIFF(날짜1, 날짜2) : 날짜1에서 날짜2의 차이를 일(DATE)로 반환. 날짜1 - 날짜2
SELECT DATEDIFF(NOW(), "2025-02-26 23:00:00") AS DATEDIFF;
#TIMEDIFF(날짜1/시간1, 날짜2/시간2) : 날짜1/시간1에서 날짜2/시간2의 차이를 시:분:초로 반환
SELECT TIMEDIFF(NOW(), "2025-02-26 23:00:00") AS TIMEDIFF;
#NOW()/SYSDATE() : 현재 날짜와 시간을 반환
SELECT NOW(), SYSDATE();

#DATE_ADD/DATE_SUB(기준날짜, INTERVAL 간격 종류) : 기준날짜에서 INTERVAL만큼 더한/뺀 날짜
	#INTERVAL 종류
	#	- YEAR/MONTH/DAY/HOUR/MINUTE/SECOND/MICROSECOND/QUARTER/WEEK
	#	- YEAR_MONTH/DAY_HOUR/DAY_MINUTE/DAY_MICROSECOND: A_B : A에서 B까지의 시간들
SELECT DATE_ADD(NOW(), INTERVAL 1 DAY) 하루뒤;
SELECT DATE_ADD(NOW(), INTERVAL 1 QUARTER) 분기뒤;
SELECT DATE_ADD(NOW(), INTERVAL 1 WEEK) 한주뒤;
SELECT DATE_ADD(NOW(), INTERVAL 13 YEAR_MONTH) 13개월뒤;
SELECT DATE_ADD(NOW(), INTERVAL "2 1" YEAR_MONTH) 2년1개월뒤;
SELECT DATE_ADD(NOW(), INTERVAL "3 2 1" DAY_MICROSECOND) 3분2초1마이크로초뒤;
SELECT DATE_ADD(NOW(), INTERVAL "4 3 2 1" DAY_MICROSECOND) 4시간3분2초1마이크로초뒤;



/*
내장함수 - 수학

ABS(숫자) : 절댓값
CEIL(숫자) : 소수점 첫번째자리 올림
FLOOR(숫자) : 소수점 첫번째자리 내림
ROUND(숫자) : 소수점 첫번째자리 반올림
ROUND(숫자, N) : N+1번째 자리에서 반올림
*/

SELECT ABS(1), ABS(-1);
SELECT CEIL(1.49), FLOOR(1.49), ROUND(1.49);
SELECT CEIL(1.59), FLOOR(1.59), ROUND(1.59);
SELECT ROUND(1.49, 1);