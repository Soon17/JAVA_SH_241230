package day015.socket1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex02_Server {

	/*
	 * 클라이언트와 연결하고
	 * 연결된 클라이언트에서 문자열을 받아 출력하고
	 * 클라이언트에 문자열을 보내는 예제
	 */
	
	public static void main(String[] args) {
		//서버 포트 지정
		int port = 5001;
		//서버용 객체를 생성
		
		Scanner sc = new Scanner(System.in);
		try (ServerSocket ss = new ServerSocket(port)) {
			System.out.println("[연결 대기중]");
			//클라이언트가 접속 요청을 할 때까지 대기
			//요청이 오면 수락 후 클라이언트 소켓 객체를 생성
			Socket s = ss.accept();
			
			System.out.println("[연결 완료]");
			
			//작업(IO스트림 이용)
			InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
				
			//클라이언트가 보낸 데이터를 받아서 콘솔에 출력
			String str = ois.readUTF();
			System.out.println("받은 문자열 :" + str);
			sc.nextLine();
			
			//출력 후 보낼 데이터 작성
			System.out.print("보낼 문자열 :");
			String sendStr = sc.nextLine();
			
			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeUTF(sendStr);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
