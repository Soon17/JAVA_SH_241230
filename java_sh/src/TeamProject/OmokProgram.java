package TeamProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OmokProgram {

	
	static List<Stone> blackList = new ArrayList<Stone>();
	static List<Stone> whiteList = new ArrayList<Stone>();
	static boolean firstTurn = true;
	static boolean gameOver = false;
	
	public static void main(String[] args) {
		
		run();
		
		System.out.println("[게임이 종료되었습니다]");
		
	}

	private static void run() {
		Field field = new Field();
		field.printField();
		Scanner sc = new Scanner(System.in);
		
		while(!gameOver) {
			
			firstTurn = field.isBlack();
			
			if(firstTurn) {
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
				//이미 돌이 있는 위치라면 continue
				if(!blackList.contains(new Stone(x, y))
						&& !whiteList.contains(new Stone(x, y))) {
					
					//필드에 업데이트
					field.setStone(x, y);
					
					//색깔에 맞는 리스트에 추가
					if(firstTurn) {
						blackList.add(new Stone(x, y));
					} else {
						whiteList.add(new Stone(x, y));
					}
					
					//다음 순서의 돌 색깔을바꿈
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
			
			//흑 승리 시 break
			if(winCheck(blackList)) {
				System.out.println("[흑이 승리하였습니다!]");
				gameOver = true;
			}
			
			//백 승리 시 break
			if(winCheck(whiteList)) {
				System.out.println("[백이 승리하였습니다!]");
				gameOver = true;
			}
		}
	}
	
	private static boolean winCheck(List<Stone> list) {
		//가로, 세로, 상승 대각선, 하강 대각선 승리 판단
		if(widthWin(list) || heightWin(list) ||
				upDiagonWin(list) || downDiagonWin(list))
			return true;
		return false;
	}
	
	private static boolean checkWinDirection(List<Stone> list, int dx, int dy) {
	    for (Stone s : list) {
	        int count = 0;
	        // (dx, dy) 방향으로 연결된 돌의 개수를 셈
	        for (int i = 0; i < 9; i++) {
	            Stone nextStone = new Stone(s.getX() + dx * i, s.getY() + dy * i);
	            
	            // 연결 방향의 첫 번째 돌만 취급
	            if (!list.contains(new Stone(s.getX() - dx, s.getY() - dy))) {
	                if (list.contains(nextStone))
	                    count++;
	                else break;
	            }
	        }
	        // 5개 이상 이어졌으면 승리
	        if (count >= 5) return true;
	    }
	    return false;
	}

	private static boolean widthWin(List<Stone> list) {
	    return checkWinDirection(list, 1, 0);  // 가로 방향 (x 증가)
	}

	private static boolean heightWin(List<Stone> list) {
	    return checkWinDirection(list, 0, 1);  // 세로 방향 (y 증가)
	}

	private static boolean downDiagonWin(List<Stone> list) {
	    return checkWinDirection(list, 1, 1);  // 내려가는 대각선 (x, y 증가)
	}

	private static boolean upDiagonWin(List<Stone> list) {
	    return checkWinDirection(list, 1, -1);  // 올라가는 대각선 (x 증가, y 감소)
	}

}