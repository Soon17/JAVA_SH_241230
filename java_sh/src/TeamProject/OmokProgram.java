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
			
			Stone tmp = new Stone(x, y);
			try{
				//이미 돌이 있는 위치라면 continue
				if(!blackList.contains(tmp)
						&& !whiteList.contains(tmp)) {
					
					
					//색깔에 맞는 리스트에 추가
					if(firstTurn) {
						blackList.add(tmp);
						if(!possibleSeat(tmp)) {
							blackList.remove(tmp);
							continue;
						}
					} else {
						whiteList.add(tmp);
					}
					//필드에 업데이트
					field.setStone(x, y);
					
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
			if(winCheck(blackList, 5)) {
				System.out.println("[흑이 승리하였습니다!]");
				gameOver = true;
			}
			
			//백 승리 시 break
			if(winCheck(whiteList, 5)) {
				System.out.println("[백이 승리하였습니다!]");
				gameOver = true;
			}
		}
	}
	
	private static boolean possibleSeat(Stone tmp) {
		if(overSix()) {
			System.out.println("[흑은 6목 이상 불가합니다]");
			return false;
		}
		if(duplicateThree(tmp)) {
			System.out.println("[흑은 쌍삼이 불가합니다]");
			return false;
		}
		if(duplicateFour(tmp)) {
			System.out.println("[흑은 쌍사가 불가합니다]");
			return false;
		}
		return true;
	}

	private static boolean duplicateThree(Stone tmp) {
		int count = 0;
		if(checkThree(tmp, 1, 0)) count++;
		if(checkThree(tmp, 0, 1)) count++;
		if(checkThree(tmp, 1, 1)) count++;
		if(checkThree(tmp, 1, -1)) count++;
		return count > 1;
	}

	private static boolean checkThree(Stone tmp, int dx, int dy) {
		//4개 인덱스의 리스트 안에서 착수한 돌의 인덱스를 각각 간주
		for (int i = 0; i < 4; i++) {
			List<Stone> tmpList = new ArrayList<Stone>();
			Stone minStone = null;
			Stone maxStone = null;
			//해당 인덱스 입장에서 리스트에 포함된 4개의 자리를 정의
			for (int j = 0; j < 4; j++) {
				Stone sMember = new Stone(tmp.getX() + dx * (j - i), tmp.getY() + dy * (j - i));
				//리스트의 왼쪽밖 인덱스 자리
				if(j == 0) minStone = new Stone(sMember.getX() - dx, sMember.getY() - dy);
				//리스트의 오른쪽밖 인덱스 자리
				if(j == 3) maxStone = new Stone(sMember.getX() + dx, sMember.getY() + dy);
				tmpList.add(sMember);
			}
			int count = 0;
			for (Stone s : tmpList) {
				if(blackList.contains(s)) count++;	//3개가 있으면 3으로 간주
				if(whiteList.contains(s)) {			//단, 그 안에 흰돌이 있으면 3으로 보지 않음
					count = 0;
					break;
				}
			}
			if(count == 3 && !blackList.contains(maxStone)
					&& !blackList.contains(minStone)
					&& !whiteList.contains(maxStone)
					&& !whiteList.contains(minStone)) {
				
				System.out.println("" + minStone + maxStone);
				return true;
			}
		}
		return false;
	}

	private static boolean duplicateFour(Stone tmp) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean overSix() {
		return winCheck(blackList, 6);
	}

	private static boolean winCheck(List<Stone> list, int n) {
		//가로, 세로, 상승 대각선, 하강 대각선 승리 판단
		if(widthWin(list, n) || heightWin(list, n) ||
				upDiagonWin(list, n) || downDiagonWin(list, n))
			return true;
		return false;
	}
	
	private static boolean checkWinDirection(List<Stone> list, int dx, int dy, int n) {
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
	        if (count >= n) return true;
	    }
	    return false;
	}

	private static boolean widthWin(List<Stone> list, int n) {
	    return checkWinDirection(list, 1, 0, n);  // 가로 방향 (x 증가)
	}

	private static boolean heightWin(List<Stone> list, int n) {
	    return checkWinDirection(list, 0, 1, n);  // 세로 방향 (y 증가)
	}

	private static boolean downDiagonWin(List<Stone> list, int n) {
	    return checkWinDirection(list, 1, 1, n);  // 내려가는 대각선 (x, y 증가)
	}

	private static boolean upDiagonWin(List<Stone> list, int n) {
	    return checkWinDirection(list, 1, -1, n);  // 올라가는 대각선 (x 증가, y 감소)
	}

}