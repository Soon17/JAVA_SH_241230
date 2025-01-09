package day007;

import java.util.Scanner;

import lombok.Data;

@Data
public class Ex06_AccountBook {
	
	static Scanner sc = new Scanner(System.in);
	static char choice = ' ';
	static int max = 10, count = 0;
	static Item[] items = new Item[max];
	
	public static void main(String[] args) {
		
		do {
			printMenu();
			
			String input = sc.nextLine();
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
				showItems();
				modifyItem();
				break;
			case '4':
				showItems();
				deleteItem();
				break;
			case '5':
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("없는 메뉴입니다.");
				break;
			}
		} while(choice != '5');
	}
	private static void modifyItem() {
		System.out.print("수정할 내역의 번호를 선택하세요: ");
		int num = sc.nextInt();
		if(num > 0 && num <= count) {
			System.out.print("수정할 금액: ");
			int change = sc.nextInt();
			items[num-1].setMoney(change);
			System.out.println("수정되었습니다.");
		} else System.out.println("해당 번호의 내역이 없습니다.");
	}
	private static int moneySum() {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += items[i].getMoney();
		}
		return sum;
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
		System.out.println("----------------------");
		System.out.println("잔액: " + moneySum() + "원");
		System.out.println("----------------------");
	}
	private static void insertItem() {
		System.out.print("수입/지출: ");
		String income = sc.nextLine();
		System.out.print("분류: ");
		String type = sc.nextLine();
		System.out.print("내용: ");
		String content = sc.nextLine();
		System.out.print("금액: ");
		int money = sc.nextInt();
		sc.nextLine();
		System.out.print("일시: ");
		String date = sc.nextLine();
		items[count++] = new Item(income, type, content, money, date);
		System.out.println("등록이 완료됐습니다.");
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
	
	public void print(int n) {
		System.out.printf("%d. %s/%s/%s/%d/%s\n", n, income, type, content, money, date);
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
}
