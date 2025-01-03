package day004;

import java.util.Scanner;

public class Ex11_HomeWork {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c;
		do {
			
			printMenu();
			String choise = sc.next();
			c = choise.charAt(0);
			if(choise.length()!=1) continue;
			switch(c) {
			case '1': 
				playGame();
				exit();
				break;
			case '2':
				showScore();
				exit();
				break;
			case '3':
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("없는 메뉴입니다.");
				break;
			}
		} while(c!='3');
	}

	private static void showScore() {
		System.out.println("(결과화면)");
	}

	private static void exit() {
		System.out.println("(나가기)");
	}

	private static void playGame() {
		System.out.println("(게임실행)");
	}

	private static void printMenu() {
		System.out.println("*******메뉴*******\n"
						+ "* 1. UpDown 게임 실행\n"
						+ "* 2. 최고기록 확인\n"
						+ "* 3. 프로그램 종료\n"
						+ "****************\n");
	}

}
