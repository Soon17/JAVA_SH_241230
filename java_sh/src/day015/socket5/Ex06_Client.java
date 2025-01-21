package day015.socket5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex06_Client {

	static Scanner sc = new Scanner(System.in);
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	
	public static void main(String[] args) {
		
		String ip = "127.0.0.1";
		int port = 5001;
		
		int menu;
		
		try {
			Socket s = new Socket(ip, port);
			System.out.println("[프로그램을 시작합니다.]");
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
		} catch (Exception e) {
			System.out.println("[서버와의 연결에 실패했습니다.]");
			System.out.println("[프로그램을 종료합니다.]");
			return;
		}
		
		do {
			
			printMenu();
			
			menu = sc.nextInt();
			sc.nextLine();
			
			runMenu(menu);
			
		} while(menu != 5);
	}

	private static void runMenu(int menu) {
		switch (menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			search();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;

		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			break;
		}
	}

	private static void insert() {
		System.out.print("추가할 학생의 정보를 입력하세요: ");
		Student std = input();
		
		try {
			oos.writeInt(1);		//메뉴 전송
			oos.writeObject(std);	//학생 전송
			oos.flush();
			boolean res = ois.readBoolean();
			if(res) {
				System.out.println("학생을 등록했습니다.");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("학생을 등록하지 못했습니다.");
	}

	private static Student input() {
		Student std = inputBase();
		System.out.print("이름: ");
		String name = sc.nextLine();
		std.setName(name);
		return std;
	}
	
	private static Student inputBase() {
		System.out.print("학년: ");
		int grd = sc.nextInt();
		System.out.print("반: ");
		int cls = sc.nextInt();
		System.out.print("번호: ");
		int num = sc.nextInt();
		sc.nextLine();
		
		return new Student(grd, cls, num, "");
	}

	private static void update() {
		// TODO Auto-generated method stub
		
	}

	private static void delete() {
		// TODO Auto-generated method stub
		
	}

	private static void search() {
		// TODO Auto-generated method stub
		
	}

	private static void printMenu() {
		System.out.print("1. 학생 추가\n"
				+ "2. 학생 수정\n"
				+ "3. 학생 삭제\n"
				+ "4. 학생 조회\n"
				+ "5. 종료\n"
				+ "메뉴 선택 : ");
	}

}
