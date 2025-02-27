/*
윈도우 함수 : 테이블의 행과 행 사이의 관계를 정의하는 함수
	- OVER 절이 들어간 함수
	- 순위를 표현할 때 사용
	- A:10, B:5, C:10, D:10, E:10, F:9, G:8
*/

USE WINDOW_FUNC;

# ROW_NUMBER() OVER(ORDER BY 속성 정렬방법) : 값이 같더라도 다른 번호를 부여
SELECT ROW_NUMBER() OVER(ORDER BY TS_SCORE DESC) AS 순위, TEAM_SCORE.*
FROM TEAM_SCORE;

# RANK() OVER(ORDER BY 속성 정렬방법) : 값이 같으면 같은 등수, 다음 등수는 개수만큼 건너뜀
SELECT RANK() OVER(ORDER BY TS_SCORE DESC) AS 순위, TEAM_SCORE.*
FROM TEAM_SCORE;

# DENSE_RANK() OVER(ORDER BY 속성 정렬방법) : 값이 같으면 같은 등수, 다음 등수도 이어짐
SELECT DENSE_RANK() OVER(ORDER BY TS_SCORE DESC) AS 순위, TEAM_SCORE.*
FROM TEAM_SCORE;

#NTILE(그룹수) OVER(ORDER BY 속성 정렬방법) : 결과 전체를 저장된 그룹수만큼 분할하여 번호를 할당
#	- 그룹수만큼 나누고 남은 수는 윗순위부터 차례로 더함
#		(7의 경우, 2면 4,3 / 3이면 3,2,2 / 4면 2,2,2,1)
SELECT NTILE(4) OVER(ORDER BY TS_SCORE DESC) AS 순위, TEAM_SCORE.*
FROM TEAM_SCORE;