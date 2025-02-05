package TeamProject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

public class Server {

	//클라이언트들에게 메세지를 보내기 위한 리스트
	private List<ObjectOutputStream> list =
			new ArrayList<ObjectOutputStream>();
	private List<ObjectOutputStream> chatList =
			new ArrayList<ObjectOutputStream>();
	private List<ObjectOutputStream> gameList =
			new ArrayList<ObjectOutputStream>();
	private Socket s;
	private final static String EXIT = "q";
	
	public Server(Socket s) {
		this.s = s;
	}

	public void connected() {
		try {
			//list에 연결된 클라이언트를 추가
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			list.add(oos); //모든 클라이언트들의 출력스트림
			
			while(true) {
				//메뉴를 입력 받음
				int menu = ois.readInt();
				//입력받은 메뉴에 맞는 기능을 실행
				runMenu(menu, oos, ois);
			}
			
		} catch (IOException e) {
			System.out.println("[연결이 끊어졌습니다]");
		} catch (Exception e) {
			System.out.println("메뉴 수신 중 오류 발생");
			e.printStackTrace();
		}
	}

	private void runMenu(int menu, ObjectOutputStream oos, ObjectInputStream ois) {
		switch (menu) {
		case 1:
			chat(oos, ois);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
	
		default:
			break;
		}
	}

	private void chat(ObjectOutputStream oos, ObjectInputStream ois) {
		try{
			String user = ois.readUTF();
			System.out.println("[" + user + "님이 대기실에 입장했습니다]");
		} catch(Exception e) {
			System.out.println("대기실 입장 중 오류 발생");
			e.printStackTrace();
		}
		receive(oos, ois);
	}

	private void receive(ObjectOutputStream oos, ObjectInputStream ois) {
		
	}
}