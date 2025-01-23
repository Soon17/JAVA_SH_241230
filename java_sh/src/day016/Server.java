package day016;

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

	private List<Post> list;
	private Socket s;
	
	public void run() {
		Thread t = new Thread(() -> {
			//클라이언트가 메뉴를 보내면 서버는 메뉴를 수신
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				
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
			update(ois, oos);
			break;
		case 3:
			delete(ois, oos);
			break;
		case 4:
			view(oos);
			break;

		default: 
			System.out.println("없는 메뉴입니다.");
		}
	}

	private void insert(ObjectInputStream ois, ObjectOutputStream oos) {
		//클라이언트로부터 게시글 정보를 받음
		try {
			Post p = (Post)ois.readObject();
			
			oos.writeBoolean(list.add(p));
			oos.flush();
			sort();
			
			System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void update(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//게시글 번호를 클라이언트에게서 받음
			Post p = (Post)ois.readObject();
			//번호에 맞는 게시글을 찾음
			int index = list.indexOf(p); 
			
			boolean res = true;
			
			//게시글이 없으면 false반환
			if(index < 0) {
				res = false;
				oos.writeBoolean(res);
				oos.flush();
			}
			//게시글이 있으면
			else {
				//true를 반환
				oos.writeBoolean(res);
				//해당 게시글을 반환
				oos.writeObject(list.remove(index));
				oos.flush();
				
				Post newP = (Post)ois.readObject();
				
				if(list.add(newP)) {
					oos.writeBoolean(res);
					oos.flush();
				} else {
					res = false;
					oos.writeBoolean(res);
					oos.flush();
				};
				sort();
			}
			
			System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void sort() {
		list.sort((o1, o2) ->{
			return o1.getNum() - o2.getNum();
		});
	}

	private void delete(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//클라이언트에게 게시글 정보를 받음
			Post p = (Post)ois.readObject();
			//삭제 결과를 클라이언트에게 전송
			oos.writeBoolean(list.remove(p));
			oos.flush();
			
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void view(ObjectOutputStream oos) {
		
		try {
			oos.writeObject(list);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
