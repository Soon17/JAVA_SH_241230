package TeamProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

/*
 * Client 클래스를 이용하여
 * 서버와 클라이언트가 문자열을 주고받는 예제
 */

public class Client {

	private String id;
	private Socket s;
	private boolean myTurn;
	private final static String EXIT = "EXIT";
	
	public Client(String id, Socket s) {
		this.id = id;
		this.s = s;
	}

	public void receive() {
		Thread th2 = new Thread(() -> {
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				
				while(true) {
					String id = ois.readUTF();
					String chat = ois.readUTF();
					System.out.println(id + " : " + chat);
					if(chat.equals(EXIT)) break;
				}
				System.out.println("[수신 기능을 종료합니다.]");
			} catch (Exception e) {
				System.out.println("[수신 중 오류 발생]");
			}
		});
		
		th2.start();
	}
	
	public void send() {
		Thread th1 = new Thread(() -> {
			Scanner sc = new Scanner(System.in);
			
			try {
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

				System.out.println("종료하려면 " + EXIT + "를 입력하세요.");
				while(true) {
					System.out.print("채팅 입력: ");
					String chat = sc.nextLine();
					oos.writeUTF(id);
					oos.writeUTF(chat);
					oos.flush();
					
					if(chat.equals(EXIT)) break;
				}
				
				System.out.println("[송신 기능을 종료합니다.]");
				sc.close();
			} catch (Exception e) {
				System.out.println("[송신 중 오류 발생]");
			}
		});
		
		th1.start();
	}
}
