package day002;

import java.util.Scanner;

public class Ex14_SwitchOperator {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int a, b;
		char c;
		
		System.out.println("첫번째 정수를 입력하세요: ");
		a = scan.nextInt();
		System.out.println("두번째 정수를 입력하세요: ");
		b = scan.nextInt();
		System.out.println("연산자를 입력하세요: ");
		c = scan.next().charAt(0);
		
		scan.close();
		
		switch(c) {
		case '+':
			System.out.println("" + a + c + b + "=" + (a+b));
			break;
		case '-':
			System.out.println("" + a + c + b + "=" + (a-b));
			break;
		case '*':
			System.out.println("" + a + c + b + "=" + (a*b));
			break;
		case '/':
			System.out.println("" + a + c + b + "=" + ((double)a/b));
			break;
		case '%':                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
			System.out.println("" + a + c + b + "=" + (a%b));
			break;
		default:
			System.out.println("잘못된 연산자입니다.");
		}
	}

}
