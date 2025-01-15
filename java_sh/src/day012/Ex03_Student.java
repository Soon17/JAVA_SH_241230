package day012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * 다음 기능을 갖는 프로그램을 작성하세요.
		 * 1. 학생 추가
		 * 	- 학년, 반, 번호, 이름 입력
		 * 2. 학생 조회
		 * 3. 종료
		 * 
		 * 2-1. 학년 조회: 학년 입력
		 * 2-2. 반 조회: 학년, 반 입력
		 * 2-3. 번호 조회: 학년, 반, 번호 입력
		 * 2-4. 전체 조회: X
		 * 
		 * - 학생 클래스 추가
		 * - List를 이용하여 학생들을 관리
		 * - Stream과 람다식을 이용하여 구현
		 */
		List<Student> list = new ArrayList<Student>();
		
		printMenu();
		
		while(true) {
			System.out.print("메뉴 선택: ");
			int menu = sc.nextInt();
			if(menu == 3) break;
			runMenu(list, menu);
			System.out.println("메뉴로 돌아가려면 엔터를 누르세요.");
			sc.nextLine();
			sc.nextLine();
			printMenu();
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
	private static void runMenu(List<Student> list, int menu) {
		
		switch (menu) {
		case 1:
			System.out.print("학년: ");
			int grd = sc.nextInt();
			System.out.print("반: ");
			int cls = sc.nextInt();
			System.out.print("번호: ");
			int num = sc.nextInt();
			System.out.print("이름: ");
			String name = sc.next();
			
			insertStudent(list, grd, cls, num, name);
			break;
			
		case 2:
			if(list.size() == 0) {
				System.out.println("등록된 학생이 없습니다.");
				break;
			}
			printMenu2();
			System.out.print("메뉴 선택: ");
			int menu2 = sc.nextInt();
			runMenu2(list, menu2);
			break;

		default:
			System.out.println("없는 메뉴입니다.");
			break;
		};
	}
	private static void runMenu2(List<Student> list, int menu2) {
		Stream<Student> stream = list.stream();
		
		switch (menu2) {
		case 1:
			System.out.print("학년 입력: ");
			int grd = sc.nextInt();
			stream
			.filter( t -> t.getGrd() == grd)
			.forEach( t -> System.out.println(t));
			break;
		case 2:
			System.out.print("학년 입력: ");
			grd = sc.nextInt();
			System.out.print("반 입력: ");
			int cls = sc.nextInt();
			stream
			.filter( t -> t.getGrd() == grd)
			.filter( t -> t.getCls() == cls)
			.forEach( t -> System.out.println(t));
			break;
		case 3:
			System.out.print("학년 입력: ");
			grd = sc.nextInt();
			System.out.print("반 입력: ");
			cls = sc.nextInt();
			System.out.print("반 입력: ");
			int num = sc.nextInt();
			stream
			.filter( t -> t.getGrd() == grd)
			.filter( t -> t.getCls() == cls)
			.filter( t -> t.getNum() == num)
			.forEach( t -> System.out.println(t));
			break;
		case 4:
			stream
			.filter( t -> true)
			.forEach( t -> System.out.println(t));
			break;

		default:
			System.out.println("없는 메뉴입니다.");
			break;
		}
	}
	
	private static void printMenu2() {
		System.out.println("*************\n"
				+ " 2-1. 학년 조회\n"
				+ " 2-2. 반 조회\n"
				+ " 2-3. 번호 조회\n"
				+ " 2-4. 전체 조회\n"
				+ "*************");
	}
	private static void insertStudent(List<Student> list, int grd, int cls, int num, String name) {
		Student s = new Student(grd, cls, num, name);
		if(list.contains(s)) {
			System.out.println("이미 등록된 학생입니다.");
		} else {
			list.add(s);
		}
	}
	private static void printMenu() {
		System.out.println("*************\n"
						+ " 1. 학생 추가\n"
						+ " 2. 학생 조회\n"
						+ " 3. 종료\n"
						+ "*************");
	}

}

@Data
@AllArgsConstructor
class Student {
	private int grd;
	private int cls;
	private int num;
	private String name;
	
	@Override
	public String toString() {
		return grd + "학년 " + cls + "반 " + num + "번 " + name;
	}
}
