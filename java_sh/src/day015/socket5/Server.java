package day015.socket5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {

	private List<Student> list;
	private Socket s;
	
	public void run() {
		Thread t = new Thread(() -> {
			//클라이언트가 메뉴를 보내면 서버는 메뉴를 수신
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				
				//클라이언트가 메뉴를 보내면 서버는 메뉴를 수신
				int menu;
				
				do {					
					menu = ois.readInt();
					runMenu(menu, ois, oos);
				} while(menu != 5);
				
				//수신한 메뉴에 따라 작업이 달라짐
				
			} catch (IOException e) {
				System.out.println("연결이 끊어졌습니다.");
			}
		});
		t.start();
	}

	private void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch (menu) {
		case 1:
			insert(ois, oos);
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			search();
			break;

		default: 
		}
	}

	private void insert(ObjectInputStream ois, ObjectOutputStream oos) {
		//클라이언트로부터 학생 정보를 받음
		try {
			Student std = (Student)ois.readObject();
			
			boolean res = true;
			//중복확인, 있으면 flase 전송
			if(list.contains(std)) res = false;
			//없으면 list에 추가
			else list.add(std);
			
			oos.writeBoolean(res);
			oos.flush();
			
			System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update() {
		// TODO Auto-generated method stub
		
	}

	private void delete() {
		// TODO Auto-generated method stub
		
	}

	private void search() {
		// TODO Auto-generated method stub
		
	}
}
