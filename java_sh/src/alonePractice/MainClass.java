package alonePractice;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("입력: ");
			String s = sc.nextLine();
			if(s.equals("X")) {
				System.out.println("종료");
				sc.close();
				break;
			}
			System.out.println("출력: " + s);
		}
		
		while(true) {
			
		}
	}
}