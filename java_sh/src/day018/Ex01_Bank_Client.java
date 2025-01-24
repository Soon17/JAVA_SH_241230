package day018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_Bank_Client {

	static Scanner sc = new Scanner(System.in);
	static List<Bank> list;
	public static void main(String[] args) {
		/*
		 * 은행 계좌 관리 프로그램
		 * - 접속
		 * 	- 은행, 이름, 계좌번호, 비밀번호
		 * - 계좌 개설
		 * 	- 은행, 이름, 계좌번호, 비밀번호, 비밀번호 확인
		 * - 종료
		 * 
		 * - 예금조회
		 * - 입금
		 * - 출금
		 * - 이전
		 * 
		 * 주의사항
		 * - 한 계좌에 여러명이 동시에 접근하는 경우 먼저 접근한 사람이 사용하도록 처리
		 */
		
		int firstMenu;
		
		printFirstMenu();
		while(true){
			
			firstMenu = sc.nextInt();
			sc.nextLine();
			
			runFirstMenu(firstMenu);
			
			if(firstMenu == 3) break;
			printFirstMenu();
			
		}
	}

	private static void runFirstMenu(int firstMenu) {
		switch (firstMenu) {
		case 1:
			accessAccount();
			break;
		case 2:
			createAccount();
			break;
		case 3:
			System.out.println("[프로그램을 종료합니다]");
			break;

		default:
			System.out.println("[존재하지 않는 메뉴입니다]");
			break;
		}
	}

	private static void accessAccount() {
		if(list != null) {
			Bank bank = inputAndMake();
			for (Bank b : list) {
				if(b.equals(bank)) {
					if(b.getPassword().equals(bank.getPassword())) {
						int secondMenu;
						
						printSecondMenu();
						
						while(true){
							secondMenu = sc.nextInt();
							sc.nextLine();
							
							runsecondMenu(bank, secondMenu);
							
							if(secondMenu == 4) break;
							
							printSecondMenu();
						}
					} else {
						System.out.println("[비밀번호가 일치하지 않습니다]");
					}
				} else {
					System.out.println("[일치하는 계좌 정보가 없습니다]");
				}
			}
		} else {
			System.out.println("[현재 등록된 계좌가 없습니다]");
		}
	}

	private static void createAccount() {
		
		Bank bank = inputAndMake();
		
		while(true){
			if(list != null && list.contains(bank)) {
				System.out.println("[이미 등록된 계좌정보입니다.]");
				break;
			}
			System.out.print("비밀번호 확인 : ");
			String pwdCheck = sc.next();
			if(pwdCheck.equals("x")) break;
			if(pwdCheck.equals(bank.getPassword())) {
				if(list == null) list = new ArrayList<Bank>();
				list.add(bank);
				System.out.println("[계좌가 개설되었습니다]");
				break;
			} else {
				System.out.println("[비밀번호가 일치하지 않습니다]");
				System.out.println("[처음으로 돌아가려면 x를 입력하세요]");
			}
		}
		sc.nextLine();
	}
	
	private static Bank inputAndMake() {
		System.out.print("은행명 : ");
		String bankName = sc.next();
		System.out.print("예금주명 : ");
		String name = sc.next();
		System.out.print("계좌번호 : ");
		String accountNum = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		
		return new Bank(bankName, name, accountNum, password);
	}

	private static void runsecondMenu(Bank bank, int secondMenu) {
		switch (secondMenu) {
		case 1:
			System.out.println(bank.getBalance());
			break;
		case 2:
			deposit(bank);
			break;
		case 3:
			withdraw(bank);
			break;
		case 4:
			System.out.println("[처음으로 돌아갑니다]");
			break;

		default:
			System.out.println("[존재하지 않는 메뉴입니다]");
			break;
		}
	}

	private static void deposit(Bank bank) {
		// TODO Auto-generated method stub
		
	}

	private static void withdraw(Bank bank) {
		// TODO Auto-generated method stub
		
	}

	private static void printSecondMenu() {
		System.out.println("-------예금 관리-------");
		System.out.println("* 1. 예금 조회");
		System.out.println("* 2. 입금");
		System.out.println("* 3. 출금");
		System.out.println("* 4. 돌아가기");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 :");
	}

	private static void printFirstMenu() {
		System.out.println("-------계좌 관리-------");
		System.out.println("* 1. 계좌 접속");
		System.out.println("* 2. 계좌 개설");
		System.out.println("* 3. 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 :");
	}

}
