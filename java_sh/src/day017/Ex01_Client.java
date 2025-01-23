package day017;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {

	static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String ip = "127.0.0.1";
		int port = 5001;
		Socket s = null;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		
		try {
			s = new Socket(ip, port);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			System.out.println("[연결 성공]");
			
		} catch (Exception e) {
			System.out.println("[서버와 연결할 수 없습니다.]");
			return;
		}
		
		int menu = 0;
		
		do {
			printMenu();
			try {
				menu = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
				continue;
			}
			
			try {
				oos.writeInt(menu);
				oos.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			runMenu(menu, ois, oos);
			
		} while(menu != 3);
	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch (menu) {
		case 1:
			playGame(ois, oos);
			break;
		case 2:
			showScore(ois);
			break;
		case 3:
			System.out.println("종료합니다.");
			break;

		default:
			System.out.println("없는 메뉴입니다.");
			break;
		}
	}

	private static void playGame(ObjectInputStream ois, ObjectOutputStream oos) {

		try {
			BaseBall bb = new BaseBall();
			bb.run();
			oos.writeObject(bb);
			oos.flush();
			
			if(ois.readBoolean()) {
				System.out.println("[기록 성공]");
			} else {
				System.out.println("[기록 실패]");
			}
		} catch(Exception e) {
			System.out.println("[기록 전송 중 예외 발생]");
			e.printStackTrace();
		}
	}

	private static void showScore(ObjectInputStream ois) {
		
		List<BaseBall> list;
		try {
			list = (List<BaseBall>)ois.readObject();
			if(!list.isEmpty()) {
				System.out.println(list);	
			} else {
				System.out.println("등록된 기록이 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("[기록 불러오기 중 예외 발생]");
			e.printStackTrace();
		}
	}

	private static void printMenu() {
		System.out.println("-------메뉴-------");
		System.out.println("* 1. 숫자야구 플레이");
		System.out.println("* 2. 최고기록 조회");
		System.out.println("* 3. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}

}
