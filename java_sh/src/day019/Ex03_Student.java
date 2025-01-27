package day019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import lombok.Data;

public class Ex03_Student {

	static Map<String, ArrayList<Student>> attendanceBook = new HashMap<String, ArrayList<Student>>();
	static ArrayList<Student> stdList = new ArrayList<Student>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		 * 학생들의 출석을 관리하는 프로그램을 작성하세요.
		 * 
		 * 1. 학생 등록
		 * 	- 이름만 입력해서 등록
		 * 2. 출석 체크
		 * 	- 날짜를 입력하면 등록된 학생들의 출석 여부를 체크
		 * 		- 2025-01-27
		 * 	- 지각, 조퇴는 없다고 가정
		 * 	- 출석이면 O, 결석이면 X
		 * 3. 출석 확인
		 * 4. 종료
		 */
		
		printMenu();
		
		int menu = 0;

		do {
			try{
				menu = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("[잘못된 입력입니다]");
				sc.nextLine();
				continue;
			}
			
			sc.nextLine();
			runMenu(menu);
			
			printMenu();
		} while(menu != 4);
		
		System.out.println("[종료합니다]");
		
	}

	private static void runMenu(int menu) {
		
		switch (menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			attendanceCheck();
			break;
		case 3:
			viewAttenDance();
			break;
		case 4:
			break;

		default:
			System.out.println("[없는 메뉴입니다]");
			break;
		}
	}

	private static void insertStudent() {
		System.out.print("학생의 이름을 입력하세요: ");
		String name = sc.nextLine();
		stdList.add(new Student(name));
		System.out.println("[추가되었습니다]");
	}

	private static void attendanceCheck() {
		if(stdList.isEmpty()) {
			System.out.println("[등록된 학생이 없습니다]");
			return;
		}
		String date;
		do {
			System.out.print("날짜를 입력하세요: ");
			date = sc.nextLine();
			if(!isDate(date)) {
				System.out.println("[날짜 형식이 잘못되었습니다]");
			}
		} while(!isDate(date));
		
		System.out.println("[출석체크를 진행합니다(출석 O, 결석 X)]");
		ArrayList<Student> tmp = new ArrayList<Student>();
		for (Student s : stdList) {
			tmp.add(new Student(s));
		}
		
		for (int i = 0; i < tmp.size(); i++) {
			System.out.print( (i + 1) + ". " + tmp.get(i).getName() + " : ");
			String check = sc.nextLine();
			System.out.println(check);
			if(check.equals("O")) {
				tmp.get(i).setAttendance(true);
			} else if(check.equals("X")){
				tmp.get(i).setAttendance(false);
			} else {
				System.out.println("[올바른 기호를 입력하세요]");
				i--;
			}
		}
		
		attendanceBook.put(date, tmp);
	}

	private static boolean isDate(String date) {
		String regex = "^\\d{4}-\\d{1,2}-\\d{2}$";
		return Pattern.matches(regex, date);
	}

	private static void viewAttenDance() {
		if(attendanceBook.isEmpty()) {
			System.out.println("[등록된 출석 기록이 없습니다]");
			return;
		}
		int i = 1;
		
		for (Map.Entry<String, ArrayList<Student>> entry : attendanceBook.entrySet()) {
			System.out.println(i + ") " + entry.getKey());
			i++;
		}
		
		String date;
		do {
			System.out.print("확인할 날짜를 입력하세요: ");
			date = sc.nextLine();
			if(!isDate(date)) {
				System.out.println("[날짜 형식이 잘못되었습니다]");
			}
		} while(!isDate(date));
		System.out.println(attendanceBook);
		System.out.println(attendanceBook.get(date));
	}

	private static void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println(" 1. 학생 등록");
		System.out.println(" 2. 출석 체크");
		System.out.println(" 3. 출석 확인");
		System.out.println(" 4. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택: ");
		
	}

}

@Data
class Student {
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(Student s) {
		this.name = s.name;
		this.attendance = s.attendance;
	}
	String name;
	boolean attendance;
	@Override
	public String toString() {
		return "[" + name + " : " + attendance + "]\n";
	}
}