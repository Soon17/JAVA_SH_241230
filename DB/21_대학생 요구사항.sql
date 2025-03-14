# 대학생의 성적을 관리하는 사이트 
# https://www.erdcloud.com/d/qff8Q9k35HC84skkQ 참고
/*
학생 등록/수정/삭제
  - 학생의 전공, 이름, 연락처, 주민번호를 입력하여 학생을 등록한다.
  - 학번은 직접 입력하지 않고, 입학년도 4자리, 전공코드 3자리, 이름순 3자리를 이용하여 구성된다. 
  - 학생은 등록되기 전, 학생 이름, 전공, 주민번호가 이미 등록되어 있다.(입학 원서) 
  - 주민번호는 14자리이다. 
  - 전공은 전공 코드를 입력한다. 
전공 등록/수정/삭제
  - 전공은 전공명, 전공 코드, 학과 사무실, 학과장을 입력하여 등록한다. 
  - 모든 전공은 학과로 구성된다. 
  - 전공 코드는 3자리의 정수이다. 
  - 학과장은 등록된 교수 중 학과장으로 선출된 교수이다. 
교수 등록/수정/삭제
  - 교수의 전공, 이름, 연락처, 주민번호를 입력하여 등록한다. 
  - 교번은 직접 입력하지 않고, 첫자리는 P, 취임년도 4자리 전공코드 3자리, 취임순(같은년도) 3자리를 이용하여 구성된다. 
지도 교수 등록/수정/삭제 
  - 학생은 전공 교수 중 한명이 지도 교수로 배정된다. 
과목 등록/수정/삭제
  - 과목코드, 과목명, 이수 학점, 시간를 입력하여 등록한다.
  - 과목코드는 분류코드3자리, 순서 3자리로 구성된다. 
  - 분류코드는 교직(000), 교양(001), 전공별로 할당된 전공 코드를 사용한다. 
  - 이수학점은 이수 시 인정되는 학점으로 0~4학점까지이다. 
  - 시간은 1주일 강의 시간으로 0~4시간이다. 
  - 같은 내용의 수업이라도 전공마다 각각 등록한다. 
강의 등록/수정/삭제 
  - 등록된 과목, 교수를 선택하교, 년도, 학기, 시간표, 강의장, 강의계획서, 분반, 최대 정원을 입력하여 등록한다. 
  - 년도는 강의가 개설되는 연도 4자리이다.
  - 학기는 1, 2, 여름, 겨울 중 하나이다. 
  - 시간표는 강의 시간표로 1A, 1B 형태로 나타내며 A,B는 30분 간격이다.
  - 월 2B,3A,3B는 월요일 10:30~12:00 수업을 의미한다. 
  - 강의장은 강의 하는 장소로 온라인 수업의 경우, 생략이 가능하다. 
  - 강의 계획서는 교재, 강의 목차 등의 내용이 이루어진 글이다. 
  - 분반은 숫자로 입력한다. 
  - 최대 정원은 강의를 수강할 수 있는 인원으로 최대 1000명까지 가능하다. 
수강 신청/취소 
  - 학생은 정원이 다 차지않은 수업에 한해 수강 신청을 한다. 
  - 한 학생은 같은 기간에 같은 강의를 여러번 수강 신청 할 수 없다. 
성적 등록/수정/삭제
  - 학생이 듣는 강의가 종강되면 교수는 성적을 입력한다. 
  - 성적은 A+, A, B+ ..., D, F, PASS, FAIL로 구성된다. 
  - 성적은 중간, 기말, 과제, 출결로 이루어지며 각 비중은 교수가 변경한다. (기본은 35%, 45%, 10%, 10%) 
  - 출결에서 결석이 4회이상이면 성적에 상관없이 F이다. 
*/