package day015.socket4;

import java.net.Socket;
import java.util.Scanner;

public class Ex05_Client {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "192.168.40.3";
		Scanner sc = new Scanner(System.in);
		
		try {
			
			//소켓 생성
			Socket s = new Socket(ip, port);
			
			System.out.println("[연결 성공!]");
			
			String id = sc.nextLine();
			Client c = new Client(id, s);
			
			c.receive();
			c.send();
			
		} catch (Exception e) {
			System.out.println("[클라이언트에서 오류 발생]");
		}
	}

}
