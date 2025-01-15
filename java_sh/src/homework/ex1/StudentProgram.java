package homework.ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Data;

@Data
public class StudentProgram {

	static Scanner sc = new Scanner(System.in);
	public void run() {
		
		printMenu();
		
		
		StudentManager sm = new StudentManager();
		
		while(true) {
			
			int menuNum = choiceMenu();
			
			if(menuNum == 0) break;
			if(menuNum == -1) continue;
			sm.runMenu(menuNum);
			
			System.out.println("돌아가려면 엔터를 누르세요.");
			sc.nextLine();
			sc.nextLine();
			printMenu();
		}
		
		System.out.println("프로그램을 종료합니다.");
	}

	private int choiceMenu() {
		System.out.print("메뉴 입력(종료 0): ");
		int input;
		try{
			input = sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			sc.nextLine();
			return -1;
		}
		return input;
	}

	public void printMenu() {
		System.out.println(	  "********************메뉴********************\n"
							+ " 1. 학생 등록\t2. 과목 등록\t3. 성적 등록\n"
							+ " 4. 학생 수정\t5. 과목 수정\t6. 성적 수정\n"
							+ " 7. 학생 삭제\t8. 과목 삭제\t9. 성적 삭제\n"
							+ " 10.학생 조회\t11.과목 조회\t12.성적 조회\n"
							+ "*******************************************");
	}
}