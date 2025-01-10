package homework.ex2;

import java.util.Scanner;

public class StudentProgram {

	public void run() {
		Scanner sc = new Scanner(System.in);
		int input;
		do {
			printMenu();
			input = sc.nextInt();
			
		} while(true);
		
	}
	public void printMenu() {
		System.out.print(	  "**********************메뉴**********************\n"
							+ " 1. 학생 등록\t2. 학생 수정\t3. 학생 삭제\n"
							+ " 4. 과목 등록\t5. 과목 수정\t6. 과목 삭제\n"
							+ " 7. 성적 등록\t8. 성적 수정\t9. 성적 삭제\n"
							+ " 10. 학생 조회\t11. 과목 조회\t12. 성적 조회\n"
							+ "***********************************************\n"
							+ "메뉴 선택(종료는 0) : ");
	}

	
}
