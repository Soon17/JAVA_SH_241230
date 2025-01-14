package day010;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
	static ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>();
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
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("번호(***-****-****):");
		String number = sc.nextLine();
		
		String regex = "^\\d{2,3}(-\\d{3,4})(-\\d{4})$";
		if(!Pattern.matches(regex, number)) {
			System.out.println("올바른 전화번호가 아닙니다.");
			return;
		}
		
		PhoneNumber pn = new PhoneNumber(name, number);
		list.add(pn);
		System.out.println("전화번호를 등록했습니다.");
	}

	private static void updatePhoneNumber() {
		//이름을 입력받는다
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		//이름과 일치하는 전화번호 목록을 숫자와 함께 출력한다
		//이름과 일치하는 전화번호 리스트를 가져온다
		ArrayList<PhoneNumber> tmpList = searchPhoneNumberList(name);
		
		
		//새로 만든 리스트를 이용하여 출력한다
		if(!printPhoneNumberList(tmpList, true)) {
			return;
		}
//		for (int i = 0; i < tmpList.size(); i++) {
//			System.out.println(i + 1 + ". " + tmpList.get(i));
//		}
		
		
		//수정할 번호를 입력받는다
		System.out.println("삭제할 번호 선택: ");
		int index = sc.nextInt() - 1;
		sc.nextLine();
		//선택한 전화번호를 삭제한다
		//선택한 번호 - 1 번지에 있는 객체를 새로운 리스트에서 가져온다
		PhoneNumber pn = tmpList.get(index);
		
		//새 이름과 번호를 입력
		System.out.print("이름: ");
		String newName = sc.nextLine();
		System.out.print("번호(***-****-****):");
		String newNumber = sc.nextLine();
		
		pn.update(newName, newNumber);
		System.out.println("수정이 완료되었습니다.");
	}

	private static void deletePhoneNumber() {
		//이름을 입력받는다
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		//이름과 일치하는 전화번호 목록을 숫자와 함께 출력한다
		//이름과 일치하는 전화번호 리스트를 가져온다
		ArrayList<PhoneNumber> tmpList = searchPhoneNumberList(name);
		
		//새로 만든 리스트를 이용하여 출력한다
		if(!printPhoneNumberList(tmpList, true)) {
			return;
		}
//		for (int i = 0; i < tmpList.size(); i++) {
//			System.out.println(i + 1 + ". " + tmpList.get(i));
//		}
		
		//삭제할 번호를 입력받는다
		System.out.println("삭제할 번호 선택: ");
		int index = sc.nextInt() - 1;
		//선택한 전화번호를 삭제한다
		//선택한 번호 - 1 번지에 있는 객체를 새로운 리스트에서 가져온다
		PhoneNumber pn = tmpList.get(index);
		//가져온 객체를 기존 리스트에서 삭제한다
		list.remove(pn);
		System.out.println("전화번호가 삭제 되었습니다.");
	}

	private static ArrayList<PhoneNumber> searchPhoneNumberList(String name) {
		ArrayList<PhoneNumber> tmpList = new ArrayList<PhoneNumber>();
		
		for (PhoneNumber pn : list) {
			if (pn.getName().contains(name)) {
				tmpList.add(pn);
			}
		}
	
		return tmpList;
	}

	private static void searchPhoneNumber() {
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		ArrayList<PhoneNumber> pList = searchPhoneNumberList(name);
		
		printPhoneNumberList(pList, false);
//		for (PhoneNumber pn : list) {
//			if (pn.getName().contains(name)) {
//				System.out.println(pn);
//			}
//		}
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
	
	private static boolean printPhoneNumberList(ArrayList<PhoneNumber> pList, boolean needNumber) {
		if(pList == null || pList.size() == 0){
			System.out.println("결과가 없습니다.");
			return false;
		}
		for (int i = 0; i < pList.size(); i++) {
			if(needNumber) {
				System.out.print(i+1+". ");
			}
			System.out.println(pList.get(i));
		}
		return true;
	}

}

@Getter
@Setter
@AllArgsConstructor
class PhoneNumber {
	private String name;
	private String phoneNumber;
	
	@Override
	public String toString() {
		return name + " : " + phoneNumber;
	}

	public void update(String newName, String newNumber) {
		this.name = newName;
		this.phoneNumber = newNumber;
	}
}