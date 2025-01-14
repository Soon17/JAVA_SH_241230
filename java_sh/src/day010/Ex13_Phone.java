package day010;

import java.util.Scanner;

import lombok.Data;

public class Ex13_Phone {

	/*
	 * 전화번호를 관리하는 프로그램을 작성하세요.
	 * 1. 전화번호 추가
	 * 	- 이름과 전화번호를 입력받아 추가
	 * 	- 동명이인이 있을 수 있으므로 중복을 허용
	 * 2. 전화번호 수정
	 * 	- 이름 입력
	 * 	- 이름과 일치하는 목록을 출력
	 * 	- 수정하려는 전화번호를 선택
	 * 	- 새 전화번호를 입력받아 수정
	 * 3. 전화번호 삭제
	 * 	- 이름 입력
	 * 	- 이름과 일치하는 목록을 출력
	 * 	- 삭제하려는 전화번호를 선택
	 * 	- 선택한 전화번호를 삭제
	 * 4. 전화번호 조회
	 * 	- 이름 입력
	 * 	- 이름이 포함된 전화번호 출력
	 */
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		printMenu();
		int n;
		do {
			System.out.print("메뉴 선택: ");
			n = sc.nextInt();
			sc.nextLine();
			
			runMenu(n);
			
		} while (n != 5);
	}
	
	private static void runMenu(int n) {
		switch (n) {
		case 1:
			insetPhoneNumber();
			break;
		case 2:
			updatePhoneNumber();
			break;
		case 3:
			deletePhoneNumber();
			break;
		case 4:
			searchPhoneNumber();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("없는 메뉴입니다.");
		}
	}

	private static void insetPhoneNumber() {
		System.out.println("이름: ");
		String name = sc.nextLine();
		System.out.println("번호(***-****-****):");
		String phoneNumber = sc.nextLine();
	}

	private static void updatePhoneNumber() {
		// TODO Auto-generated method stub
		
	}

	private static void deletePhoneNumber() {
		// TODO Auto-generated method stub
		
	}

	private static void searchPhoneNumber() {
		// TODO Auto-generated method stub
		
	}

	private static void printMenu() {
		System.out.println("*******메뉴*******\n"
						+ " 1. 전화번호 등록\n"
						+ " 2. 전화번호 수정\n"
						+ " 3. 전화번호 삭제\n"
						+ " 4. 전화번호 조회\n"
						+ " 5. 종료\n"
						+ "******************");
	}

}

@Data
class PhoneNumber {
	private String name;
	private String phoneNumber;
}