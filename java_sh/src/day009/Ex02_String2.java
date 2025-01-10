package day009;

import java.util.Scanner;

public class Ex02_String2 {

	public static void main(String[] args) {
		/*
		 * 파일명을 수정하는 기능을 구현하세요.
		 * 기존 파일명(확장자 포함)을 입력받고
		 * 수정하려는 파일명(확장자 제외)을 입력받아
		 * 파일명을 수정하시오.
		 * 
		 * 입력 : test.txt
		 * 수정 : 연습
		 * 결과 : 연습.txt
		 */
		
		Scanner sc = new Scanner(System.in);
		int index;
		String str;
		do {
			System.out.print("입력 : ");
			str = sc.nextLine();
			index = str.lastIndexOf(".");
			if(index < 0) System.out.println("확장자를 포함한 올바른 파일명을 입력하세요.");
		} while(index < 0);
		
		String fileName = str.substring(0 , index);
		System.out.print("수정 : ");
		String modify = sc.nextLine();
		
		String result = str.replace(fileName, modify);
		
		System.out.print("결과 : " + result);
		
	}

}
