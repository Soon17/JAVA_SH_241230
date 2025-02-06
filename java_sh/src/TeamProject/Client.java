package TeamProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * Client 클래스를 이용하여
 * 서버와 클라이언트가 문자열을 주고받는 예제
 */

public class Client {

	private String id;
	private Socket s;
	private boolean myTurn;
	private final static String EXIT = "q";
	private Scanner sc = new Scanner(System.in);
	
	public Client(String id, Socket s) {
		this.id = id;
		this.s = s;
	}

	
	public void connection() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			int menu = 0;
			do {
				printMenu();
				
				menu = sc.nextInt();
				sc.nextLine();
				
				oos.writeInt(menu);
				oos.flush();
				
				runMenu(menu, ois, oos);
				
			}while(menu != 4);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch (menu) {
		case 1:
			chat(oos, ois);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;

		default:
			break;
		}
	}


	private void chat(ObjectOutputStream oos, ObjectInputStream ois) {
		try{
			oos.writeUTF(id);
			oos.flush();
		} catch(Exception e) {
			System.out.println("대기실 입장 중 오류 발생");
			e.printStackTrace();
		}
		send(oos);
		receive(ois);
	}


	private void send(ObjectOutputStream oos) {
		Thread th = new Thread(()->{
			Scanner sc = new Scanner(System.in);
			
			try {
				Thread.sleep(10);
				while(true) {
					System.out.print("채팅 입력(종료q): ");
					String chat = sc.nextLine();
					oos.writeObject(new Chat(id, chat));
					oos.flush();
					
					if(chat.equals(EXIT)) break;
				}
				
				System.out.println("[대기실을 나갑니다]");
				
			} catch (Exception e) {
				System.out.println("[송신 중 오류 발생]");
			}
		});
		th.start();
	}


	private void receive(ObjectInputStream ois) {
		try {
			while(true) {
				String s = ois.readUTF();
				if(s.equals(EXIT)) break;
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println("[수신 중 오류 발생]");
		}
	}


	private void printMenu() {
		System.out.println("1. 채팅, 2. 방 만들기, 3. 방 들어가기, 4. 종료");
		System.out.print("메뉴 입력: ");
	}
}
