package day006.score;

import java.util.Scanner;

public class StudentProgram {

	Scanner sc= new Scanner(System.in);
	public void run() {
		int pick = 0;
		StudentManager sm = new StudentManager();
		do {
			printMenu();
			pick = sc.nextInt();
			sm.runMenu(pick);
		} while(pick != 3);
	}
	private static void printMenu() {
		System.out.print( "***********메뉴************\n"
						+ " 1. 학생 국어 성적 추가\n"
						+ " 2. 전체 학생 국어 성적 조회\n"
						+ " 3. 종료\n"
						+ "**************************\n"
						+ "메뉴 선택: ");
	}
}
