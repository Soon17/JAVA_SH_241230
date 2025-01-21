package day015.socket3;

import java.net.Socket;

public class Ex04_Client {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "127.0.0.1";
		
		try {
			
			//소켓 생성
			Socket s = new Socket(ip, port);
			
			System.out.println("[연결 성공!]");
			
			Client c = new Client(s);
			
			c.receive();
			c.send();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
