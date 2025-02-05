package day023;

import java.util.Scanner;

public class Ex12_String {

	public static void main(String[] args) {
		
		/*
		 * 문자열을 입력받아 출력하고 문자열이 EXIT면 종료
		 * 
		 * 다음 코드 중 잘못된 곳을 찾아 수정하세요.
		 */
		
		String str;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("입력: ");
			str = sc.next();
			System.out.println("출력: " + str);
		} while(str != "EXIT");
		//문자열을 == 나 != 로 비교하면 정상적으로 작동하지 않음.
		//equals 사용
	}

}
