package day004;

import java.util.Random;
import java.util.Scanner;

public class Ex11_HomeWork {

	public static Scanner sc = new Scanner(System.in);
	
	private static String choise;
	private static char c;
	private static int score;
	
	public static void main(String[] args) {
		
		do {
			printMenu();
			choise = sc.next();
			if(choise.length()!=1) {
				System.out.println("없는 메뉴입니다.");
				exit();
				continue;
			}
			else c = choise.charAt(0);
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
				exit();
				break;
			}
		} while(c!='3');
		sc.close();
	}

	private static void showScore() {
		if(score == 0) {
			System.out.println("게임을 실행한 기록이 없습니다.");
		} else {
			System.out.println("최고기록은 " + score + "회 입니다.");			
		}
	}

	private static void exit() {
		System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
		sc.nextLine();
		sc.nextLine();
	}

	private static void playGame() {
		Random r = new Random();
		int ranNum = r.nextInt(100) + 1;
		int inputNum;
		int count = 0;
		System.out.println(ranNum);
		do {
			System.out.print("숫자를 맞추세요:");
			inputNum = sc.nextInt();
			if(inputNum > ranNum) {
				System.out.println("Down!");
				count++;
			} else if(inputNum < ranNum) {
				System.out.println("Up!");
				count++;
			} else {
				System.out.println("정답!");
				count++;
				System.out.println("(도전횟수 " + count + "회)");
				if(score==0 || count<score) score = count;
			}
		} while(inputNum != ranNum);
	}

	private static void printMenu() {
		System.out.print( "*********메뉴*********\n"
						+ "* 1. UpDown 게임 실행 *\n"
						+ "* 2. 최고기록 확인     *\n"
						+ "* 3. 프로그램 종료     *\n"
						+ "*********************\n"
						+ "메뉴 선택:");
	}

}
