package day009;

import java.util.Scanner;

public class Ex12_TryCatch2 {

	public static void main(String[] args) {
		
		/*
		 * 두 정수와 산술연산자를 입력받아 산술 연산 코드를 출력하는
		 * 메소드를 예외처리를 적용하여 작성하시오.*
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int i = sc.nextInt();
		String s = sc.next();
		if(s.length()>1) {
			System.out.println("연산자가 올바르지 않습니다.");
			return;
		}
		char c = s.charAt(0);
		int j = sc.nextInt();
		
		try {
			double res = calculate(i,c,j);
			System.out.println("결과 : " + res);
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static double calculate(int i, char c, int j) throws Exception {
		switch (c) {								//RuntimeException이 아니라서 throws 필요
		case '+':
			return i + j;
		case '*':
			return i * j;
		case '-':
			return i - j;
		case '/':
			return i / j;
		case '%':
			return i % j;
		default:
			throw new Exception("산술 연산자가 아닙니다.");
//					예외클래스 생성 시 생성자에 문자열을 넣으면
//					message에 저장, getMessage를 통해 호출
		}
	}
}
