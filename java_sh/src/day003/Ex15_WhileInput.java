package day003;

import java.util.Scanner;

public class Ex15_WhileInput {

	public static void main(String[] args) {
		
		char ch;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("입력: ");
			ch = sc.next().charAt(0);
		}while(ch != 'q');
		
		// while문을 사용하면 ch의 초기화가 필요하다.
	}

}
