package day013;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Ex07_Schedule {

	/* 다음 기능을 실행하는 프로그램을 작성하세요.
	 * 
	 * 1. 스케쥴 등록
	 * 	- 날짜, 시작시간, 할일을 입력하여 등록
	 * 2. 스케쥴 수정
	 * 	- 날짜를 입력
	 * 	- 해당 날짜에 등록된 스케쥴을 출력
	 * 	- 수정할 스케쥴을 선택
	 * 	- 날짜, 시작시간, 할일을 입력하여 수정
	 * 3. 스케쥴 삭제
	 * 	- 날짜를 입력
	 * 	- 해당 날짜에 등록된 스케쥴을 출력
	 * 	- 삭제할 스케쥴을 선택하여 삭제
	 * 4. 스케쥴 조회
	 * 	- 월 조회
	 * 		- 년과 월을 입력받아 스케쥴을 조회
	 * 	- 일 조회 
	 * 		- 년, 월, 일을 입력받아 스케쥴을 조회
	 * - 저장, 로딩을 구현
	 * */
	static Scanner sc= new Scanner(System.in);
	static ArrayList<Schedule> list = new ArrayList<Schedule>();
	
	public static void main(String[] args) {
		
		int menu = 0;
		final int EXIT = 5;
		String fileName = "src/day013/schedule.txt";
		
	}
	
}

class Schedule implements Serializable{

	private static final long serialVersionUID = -8796736962571043126L;
	
	private Date date;
	private String toDo;
	
}