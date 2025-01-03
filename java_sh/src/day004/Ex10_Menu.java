package day004;

import java.util.Scanner;

public class Ex10_Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char n;
		
		do {
			printMenu();
			String menu = sc.next();
			n = menu.charAt(0);
			if(menu.length() != 1) {
				continue;
			}
			if(n=='1') {
				program();
			}
			else if(n=='2') {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else System.out.println("없는 메뉴입니다.");
		} while(n!='2');
		sc.close();
	}

	public static void printMenu() {
		System.out.println("********메뉴********");
		System.out.println("1. 프로그램 실행");
		System.out.println("2. 프로그램 종료");
		System.out.println("*******************");
	}
	
	public static void program() {
		Scanner sc = new Scanner(System.in);
		char c;
		do {
			System.out.print("문자를 입력하세요(종료 q): ");
			c = sc.next().charAt(0);
		} while(c != 'q');
	}
}
