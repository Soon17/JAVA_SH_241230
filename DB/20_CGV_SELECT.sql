# 상영중인 영화를 조회하는 쿼리 : 영화제목, 개봉일 
SELECT MV_TITLE 영화, MV_DATE 개봉일
FROM MOVIE 
WHERE MV_STATE = "상영중";

# CGV 강남을 선택하고, 미키17을 선택했을 때 상영 가능한 날짜를 조회하는 쿼리
SELECT DISTINCT SD_DATE
FROM SCHEDULE
JOIN SCREEN ON SC_NUM = SD_SC_NUM
WHERE SD_MV_ID = 1 AND SC_TT_NUM = 1;

SELECT DISTINCT SD_DATE
FROM SCHEDULE
JOIN SCREEN ON SC_NUM = SD_SC_NUM
JOIN THEATER ON TT_NUM = SC_TT_NUM
JOIN MOVIE ON MV_ID = SD_MV_ID
WHERE MV_TITLE = "미키 17" AND TT_NAME = "CGV강남";

# CGV 강남의 1관(기본키 1)에 등록된 좌석을 조회하는 쿼리 
SELECT *
FROM SEAT
WHERE SE_SC_NUM = 1 AND SE_POS = "Y";

# CGV 강남 1관의 3월 11일 16:20에 상영하는 미키 17(기본키 3)의 좌석을 조회하는 쿼리 
SELECT *
FROM SEAT
JOIN SCHEDULE ON SD_SC_NUM = SE_SC_NUM
WHERE SD_NUM = 3 AND SE_POS = "Y";

# 2번 스케쥴에서 예매된 좌석들 
SELECT SEAT.*
FROM SEAT
LEFT JOIN SCHEDULE ON SD_SC_NUM = SE_SC_NUM
LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
LEFT JOIN TICKET_LIST ON TL_TI_NUM = TI_NUM
WHERE SE_POS = "Y" AND SD_NUM = 2 AND TL_SE_NUM = SE_NUM;

# CGV 강남 4관의 3월 11일 19:10에 상영하는 미키 17(기본키 2)의 예약가능한 좌석을 조회하는 쿼리 
# 예매 리스트와 조인해서 예매가 안된 좌석을 조회
SELECT SE_NAME
FROM SEAT
WHERE SE_SC_NUM = 4 AND SE_NUM NOT IN (
	SELECT SE_NUM
	FROM SEAT
	LEFT JOIN SCHEDULE ON SD_SC_NUM = SE_SC_NUM
	LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
	LEFT JOIN TICKET_LIST ON TL_TI_NUM = TI_NUM
	WHERE SE_POS = "Y" AND SD_NUM = 2 AND TL_SE_NUM = SE_NUM AND TI_STATE = "결제");
    
# 장르별 등록된 영화수를 조회하는 쿼리 
SELECT GR_NAME, COUNT(MG_GR_NAME) 등록건수
FROM GENRE
LEFT JOIN MOVIE_GENRE ON MG_GR_NAME = GR_NAME
GROUP BY GR_NAME;

# 현재 시간을 기준으로 한달 사이에 개봉한 영화를 조회하는 쿼리
SELECT *
FROM MOVIE
WHERE MV_DATE > DATE_SUB(NOW(), INTERVAL 1 MONTH);

# 각 영화별 예매수를 조회하는 쿼리 
# 예매수는 상영시간이 지나지 않은 예매만 해당
SELECT MOVIE.*, SUM(TI_ADULT + TI_TEEN) 예매수
FROM MOVIE
LEFT JOIN SCHEDULE ON SD_MV_ID = MV_ID
LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
WHERE TI_STATE = "결제" AND CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
GROUP BY MV_ID;

# 각 영화별 예매수를 조회하여 예매가 높은 순으로 조회하는 쿼리 
SELECT MOVIE.*, SUM(TI_ADULT + TI_TEEN) 예매수
FROM MOVIE
LEFT JOIN SCHEDULE ON SD_MV_ID = MV_ID
LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
WHERE TI_STATE = "결제" AND CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
GROUP BY MV_ID
ORDER BY 예매수 DESC;

# 각 영화별 예매수를 조회하여 예매율을 조회하는 쿼리
SELECT MOVIE.*, SUM(TI_ADULT + TI_TEEN) 예매수, SUM(TI_ADULT + TI_TEEN) * 100 / SUM(SUM(TI_ADULT + TI_TEEN)) OVER() 예매율
FROM MOVIE
LEFT JOIN SCHEDULE ON SD_MV_ID = MV_ID
LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
WHERE TI_STATE = "결제" AND CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
GROUP BY MV_ID
ORDER BY 예매수 DESC;

# 각 예매율 순으로 순위를 조회하는 쿼리 
SELECT RANK() OVER(ORDER BY 예매율 DESC) 순위, M.*
FROM (
	SELECT MOVIE.*, SUM(TI_ADULT + TI_TEEN) 예매수, SUM(TI_ADULT + TI_TEEN) * 100 / SUM(SUM(TI_ADULT + TI_TEEN)) OVER() 예매율
	FROM MOVIE
	LEFT JOIN SCHEDULE ON SD_MV_ID = MV_ID
	LEFT JOIN TICKET ON TI_SD_NUM = SD_NUM
	WHERE TI_STATE = "결제" AND CONCAT(SD_DATE, " ", SD_TIME) >= NOW()
	GROUP BY MV_ID) M;
    
# 영화를 등록 순으로 10개 조회하는 쿼리 
SELECT *
FROM MOVIE
LIMIT 10;

# 봉준호 감독이 참여한 모든 영화를 조회하는 쿼리 
SELECT MOVIE.*, PR_NAME, AT_POSITION
FROM MOVIE
JOIN MOVIE_ACTOR ON MA_MV_ID = MV_ID
JOIN ACTOR ON AT_NUM = MA_AT_NUM
JOIN PERSON ON PR_NUM = AT_PR_NUM
WHERE PR_NAME = "봉준호";

# CGV강남의 3월 11일 모든 스케쥴의 잔여석을 조회하는 쿼리 
SELECT SD_DATE, SD_TIME, SC_NAME, SD_POS_SEAT, SC_SEAT
FROM SCHEDULE
JOIN SCREEN ON SC_NUM = SD_SC_NUM;

# 청소년들이 가장 많이 예매한 영화를 조회하는 쿼리 
SELECT MOVIE.*, SUM(TI_TEEN) 청소년예매수
FROM TICKET
RIGHT JOIN SCHEDULE ON SD_NUM = TI_SD_NUM
RIGHT JOIN MOVIE ON MV_ID = SD_MV_ID
WHERE TI_STATE = "결제"
GROUP BY MV_ID
ORDER BY 청소년예매수 DESC
LIMIT 0, 1;