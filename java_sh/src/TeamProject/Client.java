package TeamProject;

import java.io.IOException;
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
			makeRoom(oos, ois);
			break;
		case 3:
			enterRoom(oos, ois);
			break;
		case 4:
			
			break;

		default:
			break;
		}
	}

	private void enterRoom(ObjectOutputStream oos, ObjectInputStream ois) {
		// TODO Auto-generated method stub
		try {
			while(true) {
				System.out.print("입장할 방의 번호를 입력하세요: ");
				int roomNum = sc.nextInt();
				oos.writeInt(roomNum);	
				oos.flush();
				
				if(ois.readBoolean()) {
					break;
				} else {
					System.out.println("[존재하지 않는 방 번호입니다]");
					continue;
				}
			}
			
			System.out.println("[방에 입장하였습니다]");
			System.out.println("[게임이 시작됩니다]");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private void makeRoom(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			while(true) {
				System.out.print("개설할 방의 번호를 입력하세요: ");
				int roomNum = sc.nextInt();
				oos.writeInt(roomNum);	
				oos.flush();
				boolean success = ois.readBoolean();
				if(success) {
					System.out.println("[상대를 기다리는 중입니다]");
					break;
				} else {
					System.out.println("[이미 존재하는 방 번호입니다]");
					continue;
				}
			}
			System.out.println("[상대가 입장하였습니다]");
			System.out.println("[게임이 시작됩니다]");
		} catch (IOException e) {
			e.printStackTrace();
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
		sendChat(oos);
		receiveChat(ois);
	}

	private void sendChat(ObjectOutputStream oos) {
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

	private void receiveChat(ObjectInputStream ois) {
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
