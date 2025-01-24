package TeamProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OmokProgram {

	
	static List<Stone> blackList = new ArrayList<Stone>();
	static List<Stone> whiteList = new ArrayList<Stone>();
	
	public static void main(String[] args) {
		
		run();
		
	}

	private static void run() {
		Field field = new Field();
		field.printField();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			if(field.isBlack) {
				System.out.print("<흑돌 좌표 입력>");
			} else {
				System.out.print("<백돌 좌표 입력>");
			}
			
			int x = -1, y = -1;
			
			System.out.print("(x, y) : ");
			try{
				x = sc.nextInt();
				y = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("[잘못된 입력입니다]");
				sc.nextLine();
				continue;
			}
			try{
				field.setStone(x, y);
				if(field.isBlack) {
					blackList.add(new Stone(x, y));
					
				} else {
					whiteList.add(new Stone(x, y));
				}
				field.isBlack = !field.isBlack;
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("[필드 범위를 벗어났습니다]");
				sc.nextLine();
				continue;
			}
			field.printField();
			System.out.println("Black " + blackList);
			System.out.println("White " + whiteList);
			sc.nextLine();
		}
	}
	
	private static boolean winCheck(List<Stone> list) {
		if(widthWin(list) || heightWin(list) || diagonWin(list))
			return true;
		return false;
	}

	private static boolean widthWin(List<Stone> list) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean heightWin(List<Stone> list) {
		int count = 0;
		for (int i = 0; i < 15; i++) {					//시작좌표의 x 값 i
			for(int j = 0 ; j < 11; j++){				//시작좌표의 y 값 j
				count = 0;
				for(int k = 0; k < 5; k++){				//길이 변수 k
					if(list.contains(new Stone(i, j+k))) {
						count++;
					}
					if(count >= 5) return true;
				}
			}
		}
		return false;
	}

	private static boolean diagonWin(List<Stone> list) {
		// TODO Auto-generated method stub
		return false;
	}
}