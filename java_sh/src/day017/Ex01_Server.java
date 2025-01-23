package day017;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Ex01_Server {

	//기록을 저장할 리스트 생성
	static List<BaseBall> list = new ArrayList<BaseBall>();
	
	public static void main(String[] args) {
		
		//포트 지정
		int port = 5001;
		//파일을 저장할 경로 지정
		String fileName = "src/day017/data.txt";
		
		try {
			//파일로부터 리스트 불러오기
			list = (List<BaseBall>) load(fileName);
			//만약 비어있다면 새 리스트 생성
			if(list == null) list = new ArrayList<BaseBall>(); 
		
			//소켓연결
			ServerSocket ss = new ServerSocket(port);
		
			//무한반복
			while(true) {
				try {
					//서버 대기 중 연결 요청이 오면 소켓 객체 생성
					Socket s = ss.accept();
					System.out.println("[연결 완료]");
					//출력스트림과 입력스트림 생성
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
					
					//무한반복
					while(true) {
						//메뉴를 입력받음
						int menu = ois.readInt();
						//입력받은 메뉴에 맞는 기능 실행
						runMenu(menu, oos, ois);
					}
					
				} catch(Exception e) {
					System.out.println("[연결 종료]");
					//연결 끊길 시 저장
					save(fileName, list);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		//예상치 못한 종료 시 저장
			save(fileName, list);
		}
	}
	
	private static void runMenu(int menu, ObjectOutputStream oos, ObjectInputStream ois) {
		switch (menu) {
		case 1:
			insertScore(oos, ois);
			break;
		case 2:
			viewScore(oos);
			break;
		}
	}

	private static void insertScore(ObjectOutputStream oos, ObjectInputStream ois) {
		try {
			//게임 정보를 받음
			BaseBall bb = (BaseBall)ois.readObject();
			
			//게임정보를 등록
			oos.writeBoolean(list.add(bb));
			oos.flush();
			
		} catch(Exception e) {
			System.out.println("[기록 저장 중 예외 발생]");
			e.printStackTrace();
		}
	}

	private static void viewScore(ObjectOutputStream oos) {
		try {
			//전체 게임결과를 클라이언트에게 전송
			List<BaseBall> tmpList = new ArrayList<BaseBall>();
			tmpList.addAll(list);
			oos.writeObject(tmpList);
			oos.flush();
		} catch(Exception e) {
			System.out.println("[기록 전송 중 예외 발생]");
			e.printStackTrace();
		}
	}

	private static Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			System.out.println("--------------");
			System.out.println("로딩 성공");
			System.out.println("--------------");
			
			return ois.readObject();
			
		} catch(Exception e) {
			System.out.println("--------------");
			System.out.println("로딩 실패");
			System.out.println("--------------");
		}
		return null;
	}

	private static void save(String fileName, Object obj) {
		try (FileOutputStream fos = new FileOutputStream(fileName);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(obj);
			
			System.out.println("--------------");
			System.out.println("저장 성공");
			System.out.println("--------------");
		} catch(Exception e) {
			System.out.println("--------------");
			System.out.println("저장 실패");
			System.out.println("--------------");
		}
	}

}
