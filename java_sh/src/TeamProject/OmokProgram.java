package TeamProject;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OmokProgram {

	public OmokProgram() {
	}
	
	static boolean firstTurn = true;
	static boolean gameOver = false;
	
	static List<Stone> blackList = new ArrayList<Stone>();
	static List<Stone> whiteList = new ArrayList<Stone>();
	static Field field = new Field();

	public void run() {
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
				if(firstTurn) {
					blackList.remove(tmp);
				} else {
					whiteList.remove(tmp);
				}
				sc.nextLine();
				continue;
			}
			
			field.printField();
//			System.out.println("Black " + blackList);
//			System.out.println("White " + whiteList);
			sc.nextLine();
			
			//흑 승리 시 게임 종료
			if(winCheck(blackList, 5)) {
				System.out.println("[흑이 승리하였습니다!]");
				gameOver = true;
			}
			
			//백 승리 시 게임 종료
			if(winCheck(whiteList, 5)) {
				System.out.println("[백이 승리하였습니다!]");
				gameOver = true;
			}
		}
	}
	
	private boolean possibleSeat(Stone tmp) {
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

	private boolean duplicateThree(Stone tmp) {
		int count = 0;
		if(isOpenThree(tmp, 1, 0)) count++;
		if(isOpenThree(tmp, 0, 1)) count++;
		if(isOpenThree(tmp, 1, 1)) count++;
		if(isOpenThree(tmp, 1, -1)) count++;
		return count > 1;
	}

	private boolean isOpenThree(Stone tmp, int dx, int dy) {
		
		boolean result = false;
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
				if(blackList.contains(s)) count++;	//리스트 안의 흑돌의 갯수를 셈
				if(whiteList.contains(s)) {			//단, 그 안에 흰돌이 있으면 리스트로 보지 않음
					count = 0;
					break;
				}
			}
			if(count == 3) {	//리스트 안에 흑돌이 3개가 있는 경우
//				System.out.println("[" + minStone + maxStone + "에서 3을 이룹니다]");
				// 열린 3이 아니라 4인 경우, 다른 리스트 확인할 필요 없음
				if(blackList.contains(maxStone) || blackList.contains(minStone)) {
//					System.out.println("[이것은 3이 아니라 4입니다.]");
					return false;
				}
				// 3이 맞지만 흰 돌에 막힌 경우, 다른 리스트 확인
				if(whiteList.contains(maxStone) || whiteList.contains(minStone)) {
//					System.out.println("[이것은 닫힌 3입니다]");
					continue;
				}
				// 흰돌에 막히지 않았지만 벽에 막힌 경우, 다른 리스트 확인
				else if(minStone.getX() < 0 || minStone.getY() < 0
							|| maxStone.getX() > 14 || maxStone.getY() > 14) {
//					System.out.println("[열린 3이지만 5를 만들 수 없습니다]");
					continue;					
				}
				// 흰 돌에도 벽에도 막히지 않은 열린 3일 경우, 일단 3으로 간주하고 다른 리스트 확인
				else {
//					System.out.println("[이것은 열린 3입니다]");
					result = true;
				}
			}
		}
		return result;
	}

	private boolean duplicateFour(Stone tmp) {
		int count = 0;
		if(isOpenFour(tmp, 1, 0)) count++;
		if(isOpenFour(tmp, 0, 1)) count++;
		if(isOpenFour(tmp, 1, 1)) count++;
		if(isOpenFour(tmp, 1, -1)) count++;
		return count > 1;
	}

	private boolean isOpenFour(Stone tmp, int dx, int dy) {
		
		boolean result = false;
		//5개 인덱스의 리스트 안에서 착수한 돌의 인덱스를 각각 간주
		for (int i = 0; i < 5; i++) {
			List<Stone> tmpList = new ArrayList<Stone>();
			Stone minStone = null;
			Stone maxStone = null;
			//해당 인덱스 입장에서 리스트에 포함된 4개의 자리를 정의
			for (int j = 0; j < 5; j++) {
				Stone sMember = new Stone(tmp.getX() + dx * (j - i), tmp.getY() + dy * (j - i));
				//리스트의 왼쪽밖 인덱스 자리
				if(j == 0) minStone = new Stone(sMember.getX() - dx, sMember.getY() - dy);
				//리스트의 오른쪽밖 인덱스 자리
				if(j == 4) maxStone = new Stone(sMember.getX() + dx, sMember.getY() + dy);
				tmpList.add(sMember);
			}
			int count = 0;
			for (Stone s : tmpList) {
				if(s.getX() < 0 || s.getY() < 0		//범위 밖으로 넘어가는 리스트는 무시함
						|| s.getX() > 14 || s.getY() > 14) {
					count = 0;
					break;
				}
				if(blackList.contains(s)) count++;	//리스트 안의 흑돌의 갯수를 셈
				if(whiteList.contains(s)) {			//단, 그 안에 흰돌이 있으면 리스트로 보지 않음
					count = 0;
					break;
				}
			}
			if(count == 4) {	//리스트 안에 흑돌이 4개가 있는 경우
//				System.out.println("[" + minStone + maxStone + "에서 4를 이룹니다]");
				// 한 리스트에서 다음 수가 6목이 되는 경우 제한하지 않아도 됨
				if(blackList.contains(maxStone) || blackList.contains(minStone)) {
//					System.out.println("[이것은 다음수가 6목입니다]");
					return false;
				}
				result = true;
			}
		}
		return result;
	}

	private boolean overSix() {
		return winCheck(blackList, 6);
	}

	private boolean winCheck(List<Stone> list, int n) {
		//가로, 세로, 상승 대각선, 하강 대각선 승리 판단
		if(widthWin(list, n) || heightWin(list, n) ||
				upDiagonWin(list, n) || downDiagonWin(list, n))
			return true;
		return false;
	}
	
	private boolean widthWin(List<Stone> list, int n) {
	    return checkWinDirection(list, 1, 0, n);  // 가로 방향 (x 증가)
	}

	private boolean heightWin(List<Stone> list, int n) {
	    return checkWinDirection(list, 0, 1, n);  // 세로 방향 (y 증가)
	}

	private boolean downDiagonWin(List<Stone> list, int n) {
	    return checkWinDirection(list, 1, 1, n);  // 내려가는 대각선 (x, y 증가)
	}

	private boolean upDiagonWin(List<Stone> list, int n) {
	    return checkWinDirection(list, 1, -1, n);  // 올라가는 대각선 (x 증가, y 감소)
	}

	private boolean checkWinDirection(List<Stone> list, int dx, int dy, int n) {
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

}