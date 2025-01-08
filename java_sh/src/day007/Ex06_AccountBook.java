package day007;

import java.util.Scanner;

public class Ex06_AccountBook {

	/*
	 * 가계부에 필요한 클래스를 선언
	 * 메뉴
	 * 1. 가계부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 삭제
	 * 4. 가계부 조회
	 * 5. 종료
	 * 메뉴선택 : 1 
	 * 수입 / 지출: 수입
	 * 분류 : 월급
	 * 내용 : 1월 월급
	 * 금액 : 1000000
	 * 일시 : 2025-01-08
	 * 가계부 등록이 완료됐습니다.
	 * 메뉴
	 * 1. 가계부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 삭제
	 * 4. 가계부 조회
	 * 5. 종료
	 * 메뉴선택 : 2
	 * 1. 수입/월급/1월 월급/1000000/2025-01-08
	 * 2...
	 * 3...
	 * 수정할 내역의 번호를 선택하세요 : 1
	 * 금액 : 2000000
	 * 수정이 완료됐습니다.
	 * 메뉴
	 * 1. 가계부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 조회
	 * 4. 가계부 삭제
	 * 5. 종료
	 * 메뉴선택 : 3
	 * 1. 수입/월급/1월 월급/2000000/2025-01-08
	 * 2...
	 * 3...
	 * 메뉴
	 * 1. 가계부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 조회
	 * 4. 가계부 삭제
	 * 5. 종료
	 * 메뉴선택 : 4
	 * 삭제할 내역의 번호를 선택하세요 : 1
	 * 삭제가 완료됐습니다.
	 * 메뉴
	 * 1. 가계부 등록
	 * 2. 가계부 수정
	 * 3. 가계부 조회
	 * 4. 가계부 삭제
	 * 5. 종료
	 * 메뉴선택 : 5
	 * 프로그램을 종료합니다.
	 * */
	static Scanner sc = new Scanner(System.in);
	static char choice = ' ';
	static int max = 10, count = 0;
	static Item[] items = new Item[max];
	
	public static void main(String[] args) {
		
		
		do {
			printMenu();
			
			String input = sc.next();
			if(input.length() != 1) {
				System.out.println("없는 메뉴입니다.");
				continue;
			}
			choice = input.charAt(0);
			switch (choice) {
			case '1':
				insertItem();
				break;
			case '2':
				showItems();
				break;
			case '3':
				//내역출력
				//수정할 내역 숫자 입력
				//금액 입력
				//입력숫자 -1 번지 금액 수정
				break;
			case '4':
				deleteItem();
				break;
			case '5':
				break;
			default:
				System.out.println("없는 메뉴입니다.");
				break;
			}
		} while(choice != '5');
		System.out.println("프로그램을 종료합니다.");
	}
	private static void deleteItem() {
		System.out.print("삭제할 내역의 번호를 입력하세요 : ");
		int num = sc.nextInt();
		if(num > 0 && num <= count) {
			if(num != count) {
				for (int i = num; i < count; i++) {
					items[i-1] = items[i];
				}
			}
			count--;
			System.out.println("삭제되었습니다.");
		} else System.out.println("해당 번호의 내역이 없습니다.");
	}
	private static void printMenu() {
		System.out.print( "***********메뉴************\n"
				+ " 1. 가계부 등록\n"
				+ " 2. 가계부 조회\n"
				+ " 3. 가계부 수정\n"
				+ " 4. 가계부 삭제\n"
				+ " 5. 종료\n"
				+ "**************************\n"
				+ "메뉴 선택: ");
	}
	private static void showItems() {
		if(count == 0) {
			System.out.println("조회 대상이 없습니다.");
			return;
		}
		for(int i = 0; i < count; i++) {
			items[i].print(i+1);
		}
	}
	private static void insertItem() {
		System.out.print("수입/지출: ");
		String income = sc.next();
		System.out.print("분류: ");
		String type = sc.next();
		System.out.print("내용: ");
		String content = sc.next();
		System.out.print("금액: ");
		int money = sc.nextInt();
		System.out.print("일시: ");
		String date = sc.next();
		items[count++] = new Item(income, type, content, money, date);
	}

}

class Item {
	
	public Item(String income, String type, String content, int money, String date) {
		this.money = money;
		this.income = income;
		this.type = type;
		this.content = content;
		this.date = date;
	}
	private int money;
	private String income, type, content, date;
	
	public void print() {
		System.out.printf("%s/%s/%s/%d/%s\n", income, type, content, money, date);
	}
	
	public void print(int n  ) {
		System.out.print(n + ". ");
		print();
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
}
