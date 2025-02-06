package TeamProject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	//클라이언트들에게 메세지를 보내기 위한 리스트
	private static List<ObjectOutputStream> list =
			new ArrayList<ObjectOutputStream>();
	private static List<ObjectOutputStream> chatList =
			new ArrayList<ObjectOutputStream>();
	private static List<ObjectOutputStream> gameList =
			new ArrayList<ObjectOutputStream>();
	private Socket s;
	private final static String EXIT = "q";
	
	public Server(Socket s) {
		this.s = s;
	}

	public void connected() {
		Thread th = new Thread(()->{
			try {
				//list에 연결된 클라이언트를 추가
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				list.add(oos); //모든 클라이언트들의 출력스트림
				System.out.println(list);
				while(true) {
					//메뉴를 입력 받음
					int menu = ois.readInt();
					//입력받은 메뉴에 맞는 기능을 실행
					runMenu(menu, oos, ois);
				}
				
			} catch (IOException e) {
				System.out.println("메뉴 수신 중 IO오류 발생");
			} catch (Exception e) {
				System.out.println("메뉴 수신 중 예기치 못한 오류 발생");
				e.printStackTrace();
			}
		});
		
		th.start();
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
			receive(user, oos, ois);
		} catch(IOException e) {
			System.out.println("대기실 입장 중 IO오류 발생");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("대기실 입장 중 예기치 못한 오류 발생");
			e.printStackTrace();
		}
	}

	private void receive(String user, ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			chatList.add(oos);
			System.out.println("대기실 인원: " + chatList.size());
			//무한루프로 반복
			while(true) {
				Chat c = (Chat)ois.readObject();
				
				System.out.println(c); // 확인용
				
				boolean flag = false;
				synchronized (chatList) {
					for (ObjectOutputStream client : chatList) {
						//메세지를 쓴 클라이언트에겐 메세지를 보내지 않음
						if(client != oos && !c.getChat().equals(EXIT)) {
							send(client, c);
						} 
						//연결된 클라이언트가 EXIT를 입력했을 때
						else if(client == oos && c.getChat().equals(EXIT)) {
							//클라이언트의 receive에 있는 쓰레드를 종료하기 위해서
							send(client, c);
							flag = true;
						}
					}
				}
				if(flag) {
					chatList.remove(oos);
				}
			}
		} catch (IOException e) {
			System.out.println("대기실에서 수신 중 " + user +  " IO오류");
			chatList.remove(oos);
		} catch (Exception e) {
			System.out.println("대기실 수신 중 예기치 못한 오류 발생");
			e.printStackTrace();
		}
	}

	private void send(ObjectOutputStream client, Chat c) {
		if(client == null || c == null) {
			return;
		}
		try {
			/*
			 * 하나의 클라이언트에 여러 메세지를 보내려 하면
			 * 순서가 꼬이거나 예상치못한 문제 발생 가능성 있음
			 * 동기화를 통해 먼저 들어온 작업부터 실행되도록 해줌
			 */
			synchronized(client) {
				client.writeObject(c);
				client.flush();
			}
			
		} catch (Exception e) {
			System.out.println("대기실 송신 중 예기치 못한 오류 발생");
			chatList.remove(client);
			e.printStackTrace();
		}
	}
}