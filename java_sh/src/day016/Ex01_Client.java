package day016;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {

	static Scanner sc = new Scanner(System.in);
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	
	public static void main(String[] args) {
		 /*
		  * day014/Ex01_post 예제를 활용하여 게시글 관리 프로그램을 만드시오.
		  * 단, 네트워크 통신을 이용하여 서버와 클라이언트로 동작하는 프로그램을 작성하시오.
		  */
		String ip = "127.0.0.1";
		int port = 5001;
		
		int menu;
		
		try {
			Socket s = new Socket(ip, port);
			System.out.println("[프로그램을 시작합니다.]");
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
		} catch (Exception e) {
			System.out.println("[서버와의 연결에 실패했습니다.]");
			System.out.println("[프로그램을 종료합니다.]");
			return;
		}
		
		do {
			
			printMenu();
			
			menu = sc.nextInt();
			sc.nextLine();
			
			runMenu(menu);
			
		} while(menu != 5);
		
	}
	
	private static void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			view();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}
		
	}
	
	private static void insert() {
		System.out.println("게시글을 입력하세요.");
		Post p = input();
		
		try {
			oos.writeInt(1);		//메뉴 전송
			oos.writeObject(p);		//게시글 전송
			oos.flush();
			boolean res = ois.readBoolean();
			if(res) {
				System.out.println("게시글을 등록했습니다.");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("게시글을 등록하지 못했습니다.");
	}

	private static Post input() {
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		
		return new Post(title, content, writer);
	}

	private static void update() {
		try {
			//번호를 입력
			System.out.print("번호 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			//메뉴를 전송
			oos.writeInt(2);
			
			//서버에 게시글 번호를 전송
			oos.writeObject(new Post(num));		
			oos.flush();
			
			//서버에서 결과를 받아서 true면
			if(ois.readBoolean()) {
				Post p = (Post)ois.readObject();
				//수정할 게시글 내용 입력
				System.out.println("수정할 내용을 입력하세요.");
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String content = sc.nextLine();
				p.setTitle(title);
				p.setContent(content);
				
				//수정한 게시글을 전송
				oos.writeObject(p);
				oos.flush();
				
				if(ois.readBoolean()) {
					System.out.println("수정하였습니다.");					
				}
				else {
					System.out.println("수정에 실패하였습니다.");	
				}
			}
			//false면 실패를 알림
			else {
				System.out.println("해당번호의 게시글이 없습니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void delete() {
		try {
			//번호를 입력
			System.out.print("번호 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			oos.writeInt(3);
			oos.writeObject(new Post(num));
			oos.flush();
			
			if(ois.readBoolean()) {
				System.out.println("게시글을 삭제 했습니다.");
				return;
			}
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void view() {
		try {
			oos.writeInt(4);
			oos.flush();
			
			System.out.println((List<Post>)ois.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printMenu() {
		System.out.println("--------------------");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 종료");
		System.out.println("--------------------");
		System.out.print("메뉴 선택 : ");
	}

}
