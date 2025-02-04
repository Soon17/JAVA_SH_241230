package TeamProject;

import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		int port = 5001;
		//String ip = "192.168.40.3";
		String ip = "127.0.0.1";
		Scanner sc = new Scanner(System.in);
		
		try {
			
			//소켓 생성
			Socket s = new Socket(ip, port);
			
			System.out.println("[연결 성공!]");
			
			System.out.print("사용하실 닉네임을 알려주세요: ");
			String id = sc.nextLine();
			Client c = new Client(id, s);
			
			c.receive();
			c.send();
			
		} catch (Exception e) {
			System.out.println("[클라이언트에서 오류 발생]");
		}
	}
}
