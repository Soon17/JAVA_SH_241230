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
		
		System.out.println("[게임이 종료되었습니다]");
		
	}

	private static void run() {
		Field field = new Field();
		field.printField();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			if(field.isBlack()) {
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
				if(!blackList.contains(new Stone(x, y))
						&& !whiteList.contains(new Stone(x, y))) {
					field.setStone(x, y);
					if(field.isBlack()) {
						blackList.add(new Stone(x, y));
					} else {
						whiteList.add(new Stone(x, y));
					}
					field.setBlack(!field.isBlack());
				} else {
					System.out.println("[해당위치에 이미 돌이 있습니다]");
					continue;
				}
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("[필드 범위를 벗어났습니다]");
				sc.nextLine();
				continue;
			}
			field.printField();
			System.out.println("Black " + blackList);
			System.out.println("White " + whiteList);
			sc.nextLine();
			
			if(winCheck(blackList)) {
				System.out.println("[흑이 승리하였습니다!]");
				break;
			}
			
			if(winCheck(whiteList)) {
				System.out.println("[백이 승리하였습니다!]");
				break;
			}
		}
	}
	
	private static boolean winCheck(List<Stone> list) {
		if(widthWin(list) || heightWin(list) ||
				upDiagonWin(list) || downDiagonWin(list))
			return true;
		return false;
	}

	private static boolean widthWin(List<Stone> list) {
		for(Stone s : list) {
			int count = 0;
			for (int i = 0; i < 10; i++) {
				if(!list.contains		//동일 라인의 최좌측만 취급
						(new Stone(s.getX() - 1, s.getY()))) {
					if(list.contains	//우측으로 이어진 갯수를 셈
							(new Stone(s.getX() + i, s.getY())))
						count++;
					else break;			
				}
			}
			// 5개 이상을 오목으로 인정
			if(count >= 5) return true;
		}
		return false;
	}

	private static boolean heightWin(List<Stone> list) {
		for(Stone s : list) {
			int count = 0;
			for (int i = 0; i < 10; i++) {
				if(!list.contains		//동일 라인의 최상측만 취급
						(new Stone(s.getX(), s.getY() - 1))) {
					if(list.contains	//하측으로 이어진 갯수를 셈
							(new Stone(s.getX(), s.getY() + i)))
						count++;
					else break;			
				}
			}
			// 5개 이상을 오목으로 인정
			if(count >= 5) return true;
		}
		return false;
	}

	private static boolean downDiagonWin(List<Stone> list) {
		for(Stone s : list) {
			int count = 0;
			for (int i = 0; i < 10; i++) {
				if(!list.contains		//동일 라인의 최좌상측만 취급
						(new Stone(s.getX() - 1, s.getY() - 1))) {
					if(list.contains	//우하측으로 이어진 갯수를 셈
							(new Stone(s.getX() + i, s.getY() + i)))
						count++;
					else break;			
				}
			}
			// 5개 이상을 오목으로 인정
			if(count == 5) return true;
		}
		return false;
	}
	
	private static boolean upDiagonWin(List<Stone> list) {
		for(Stone s : list) {
			int count = 0;
			for (int i = 0; i < 10; i++) {
				if(!list.contains		//동일 라인의 최좌하측만 취급
						(new Stone(s.getX() - 1, s.getY() + 1))) {
					if(list.contains	//우상측으로 이어진 갯수를 셈
							(new Stone(s.getX() + i, s.getY() - i)))
						count++;
					else break;			
				}
			}
			// 5개 이상을 오목으로 인정
			if(count == 5) return true;
		}
		return false;
	}
}