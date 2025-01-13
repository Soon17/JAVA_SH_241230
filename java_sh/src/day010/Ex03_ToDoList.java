package day010;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03_ToDoList {

	static ArrayList<String> toDo = new ArrayList<String>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * 다음 기능을 갖는 프로그램을 작성하시오.
		 * 1. 할 일 등록
		 * 2. 할 일 삭제
		 * 3. 할 일 조회
		 * 4. 종료
		 * 메뉴 선택: 1
		 * 등원
		 * 1. 할 일 등록
		 * 2. 할 일 삭제
		 * 3. 할 일 조회
		 * 4. 종료
		 * 메뉴 선택: 1
		 * 수업
		 * 1. 할 일 등록
		 * 2. 할 일 삭제
		 * 3. 할 일 조회
		 * 4. 종료
		 * 메뉴 선택: 2
		 * 1.등원
		 * 2.수업
		 * 삭제할 할 일을 선택: 1
		 * 삭제되었습니다.
		 * 1. 할 일 등록
		 * 2. 할 일 삭제
		 * 3. 할 일 조회
		 * 4. 종료
		 * 메뉴 선택: 3
		 * 1. 수업
		 * 1. 할 일 등록
		 * 2. 할 일 삭제
		 * 3. 할 일 조회
		 * 4. 종료
		 * 메뉴 선택: 4
		 * 프로그램을 종료합니다.
		 */
		
		int n = 0;
		do {
			printMenu();
			System.out.print("메뉴 선택: ");
			
			try{
				n = sc.nextInt();
				sc.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("올바른 메뉴를 입력하세요.");
				sc.nextLine();
				continue;
			}
			
			runMenu(n);
			
		} while(n != 4);
	}
	private static void runMenu(int n) {
		switch (n) {
		case 1:
			insertToDo();
			break;
		case 2:
			deleteToto();
			break;
		case 3:
			showToDo();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;

		default:
			System.out.println("없는 메뉴입니다.");
			break;
		}
	}
	private static void showToDo() {
		if(toDo.size() == 0) {
			System.out.println("등록된 할 일이 없습니다.");
			return;
		}
		for (int i = 0; i < toDo.size(); i++) {
			System.out.println((i+1) + ". " + toDo.get(i));
		}
	}
	private static void deleteToto() {
		if(toDo.size() == 0) {
			System.out.println("삭제할 할 일이 없습니다.");
			return;
		}
		for (int i = 0; i < toDo.size(); i++) {
			System.out.println((i+1) + ". " + toDo.get(i));
		}
		System.out.print("삭제할 할 일을 선택: ");
		try {
			int d = sc.nextInt();
			toDo.remove(d-1);
		} catch(InputMismatchException e) {
			System.out.println("올바른 번호를 입력하세요.");
			sc.nextLine();
			return;
		} catch(IndexOutOfBoundsException e) {
			System.out.println("없는 번호입니다.");
			sc.nextLine();
			return;
		}
		System.out.println("삭제되었습니다.");
	}
	private static void insertToDo() {
		System.out.print("할 일 입력: ");
		String doIt = sc.nextLine();
		toDo.add(doIt);
	}
	private static void printMenu() {
		System.out.println("*****메뉴*****\n"
				+ " 1. 할 일 등록\n"
		 		+ " 2. 할 일 삭제\n"
		 		+ " 3. 할 일 조회\n"
		 		+ " 4. 종료\n"
		 		+ "*************");
	}

}
