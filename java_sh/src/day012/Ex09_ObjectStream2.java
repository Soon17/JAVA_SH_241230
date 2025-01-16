package day012;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex09_ObjectStream2 {

	static Scanner sc = new Scanner(System.in);
	static List<Car> list = new ArrayList<Car>();
	static String fileName = "src/day012/CarList.txt";
	public static void main(String[] args) {
		
		/*
		 * 다음 기능을 갖는 프로그램을 작성하세요.
		 * 단, 저장기능과 불러오기 기능을 추가
		 * 	- 저장은 프로그램 종료하기 전
		 * 	- 불러오기는 프로그램 시작 전
		 * 
		 * 1. 자동차 추가
		 * 2. 자동차 조회(전체)
		 * 3. 종료
		 * 
		 * 힌트: ArrayList도 Serializable 인터페이스를 구현한 클래스이다.
		 */
		
		printMenu();
		int menu;
		downloadList();
		do {
			System.out.print("메뉴 선택: ");
			menu = sc.nextInt();
			
			runMenu(menu);
			printMenu();
		} while(menu != 4);
		
		System.out.println("프로그램을 종료합니다.");
	}
	private static void downloadList() {
		
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				list = (ArrayList<Car>)ois.readObject();
				System.out.println(list);
			} catch (FileNotFoundException e) {
				System.out.println("파일을 찾을 수 없습니다.");
			} catch (IOException e) {
				System.out.println("IO 예외발생");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("클래스를 찾을 수 없습니다.");
				e.printStackTrace();
			}
	}
	private static void runMenu(int menu) {
		switch (menu) {
		case 1:
			insertCar();
			break;
		case 2:
			showCars();
			break;
		case 3:
			deleteCars();
			break;
		case 4:
			uploadList();
			break;

		default:
			System.out.println("잘못된 메뉴입니다.");
			break;
		}
	}
	private static void deleteCars() {
		if(list.size() == 0) {
			System.out.println("등록된 차가 없습니다.");
			return;
		}
		
		System.out.print("회사: ");
		String company = sc.next();
		System.out.print("차종: ");
		String name = sc.next();
		Car c = new Car(company, name);
		if(list.contains(c)) {
			list.remove(c);
			System.out.println("삭제 되었습니다.");
		} else {
			System.out.println("해당하는 자동차가 없습니다.");
		}
	}
	private static void insertCar() {
		System.out.print("회사: ");
		String company = sc.next();
		System.out.print("차종: ");
		String name = sc.next();
		list.add(new Car(company, name));
		System.out.println("추가 되었습니다.");
	}
	private static void showCars() {
		if(list.size() == 0) {
			System.out.println("등록된 차가 없습니다.");
			return;
		}
		
		//정렬
		list.sort((o1, o2) -> {
			//브랜드를 사전순으로 정렬
			if(!o1.getCompany().equals(o2.getCompany())) {
				return o1.getCompany().compareTo(o2.getCompany());
			}
			//이름을 사전순 정렬
			return o1.getName().compareTo(o2.getName());
		});
		for (Car c : list) {
			System.out.println(c);
		}
	}
	private static void uploadList() {
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
					oos.writeObject(list);;
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외발생");
			e.printStackTrace();
		}
	}
	private static void printMenu() {
		System.out.println("****************\n"
					     + "1. 자동차 추가\n"
					     + "2. 자동차 조회\n"
					     + "3. 자동차 삭제\n"
					     + "4. 종료\n"
					     + "****************");
	}

}

@Data
@AllArgsConstructor
class Car implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5722280248442209653L;
	String company, name;
	
	@Override
	public String toString() {
		return company + " : " + name;
	}
}