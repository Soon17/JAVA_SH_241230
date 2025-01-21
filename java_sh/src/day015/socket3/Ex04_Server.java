package day015.socket3;

import java.net.ServerSocket;
import java.net.Socket;

public class Ex04_Server {

	public static void main(String[] args) {
		
		int port = 5001;
		
		try {
			//서버 소켓 생성
			ServerSocket ss = new ServerSocket(port);
			
			System.out.println("[연결 대기중...]");
			
			//연결 대기, 요청 수락 후 소켓 객체 생성
			
			Socket s = ss.accept();
			
			System.out.println("[연결 성공!]");
			
			Client c = new Client(s);
			
			c.receive();
			c.send();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
