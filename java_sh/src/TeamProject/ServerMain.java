package TeamProject;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {

	public static void main(String[] args) {
		
		int port = 5001;
		
		List<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();
		
		try {
			//서버 소켓 생성
			ServerSocket ss = new ServerSocket(port);
			
			System.out.println("[연결 대기중...]");
			
			while(true) {
				//연결 대기, 요청 수락 후 소켓 객체 생성
				
				Socket s = ss.accept();
				
				System.out.println("[연결 성공!]");
				
				Server server = new Server(list, s);
				server.receive();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
