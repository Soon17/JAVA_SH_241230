package day023;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Ex18_NetworkClient {

	public static void main(String[] args) {
		
		//ip, port 설정
		//ip 설정 시 내부 아이피로 고정하면 한 PC에서
		//테스트할 땐 동작되지만 여러 PC에서 테스트할 땐 안됨
		//String ip = "192.168.40.3";
		int port = 3001;
		
		try {
			//ip와 port를 이용하여 소켓을 생성
			String ip = InetAddress.getLocalHost().getHostAddress();
			Socket socket = new Socket(ip, port);
			System.out.println("[연결 완료]");
			//데이터를 주고 받음
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("안녕");
			oos.flush();
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
