package day016;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Ex01_Server {

	public static void main(String[] args) {
		
		/*
		 * 게시글 프로그램을 구현하고
		 * 프로그램에서 관리하는 정보를 서버에 기록하는 예제
		 */
		int port = 5001;
		
		String fileName = "src/day016/data.txt";
		List<Post> list = (List<Post>)load(fileName);
		if(list == null) {
			list = new ArrayList<Post>();
		} else if(!list.isEmpty()) {
			int count = list.get(list.size() - 1).getNum();
			Post.setCount(count);
		}
		
		try {
			
			ServerSocket ss = new ServerSocket(port);
			
			while(true) {
				
				Socket s = ss.accept();
				System.out.println("[연결 성공]");
				Server server = new Server(list, s);
				
				server.run();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			save(fileName, list);
		}
	}
	
	private static Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			System.out.println("-----------------");
			System.out.println("로딩성공!");
			System.out.println("-----------------");
			return ois.readObject();
			
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("로딩실패!");
			System.out.println("-----------------");
		}
		return null;
	}
	
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(obj);
			System.out.println("-----------------");
			System.out.println("저장성공!");
			System.out.println("-----------------");
			
		} catch (Exception e) {
			System.out.println("-----------------");
			System.out.println("저장실패!");
			System.out.println("-----------------");
		}
		
	}

}
