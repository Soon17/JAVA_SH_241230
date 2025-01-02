package day003;

import java.util.Scanner;

public class Ex10_ForInput {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("문자를 입력하세요(종료는 q):");
			char c = scan.next().charAt(0);
			if(c == 'q') break;
		}
		System.out.println("종료합니다.");
	}

}
