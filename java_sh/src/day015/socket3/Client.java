package day015.socket3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

/*
 * Client 클래스를 이용하여
 * 서버와 클라이언트가 문자열을 주고받는 예제
 */

@AllArgsConstructor
public class Client {

	private Socket s;
	private final static String EXIT = "EXIT";
	
	public void receive() {
		Thread th2 = new Thread(() -> {
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				
				while(true) {
					String str = ois.readUTF();
					System.out.println("수신 : " + str);
					if(str.equals(EXIT)) break;
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

				while(true) {
					System.out.print("입력(종료 : " + EXIT + ") : ");
					String str = sc.nextLine();
					oos.writeUTF(str);
					oos.flush();
					
					if(str.equals(EXIT)) break;
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
