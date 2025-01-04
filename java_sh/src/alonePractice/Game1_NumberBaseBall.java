package alonePractice;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game1_NumberBaseBall {

	public static Scanner sc = new Scanner(System.in);
	
	private static String choise;
	private static char c;
	private static int score;
	private static int count;
	
	public static void main(String[] args) {
		
		do {
			printMenu();
			choise = sc.next();
			if(choise.length()!=1) {
				System.out.println("없는 메뉴입니다.");
				exit();
				continue;
			}
			else c = choise.charAt(0);
			switch(c) {
			case '1': 
				playGame();
				exit();
				break;
			case '2':
				showScore();
				exit();
				break;
			case '3':
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("없는 메뉴입니다.");
				exit();
				break;
			}
		} while(c!='3');
		sc.close();
	}

	private static void showScore() {
		if(score == 0) {
			System.out.println("게임을 실행한 기록이 없습니다.");
		} else {
			System.out.println("최고기록은 " + score + "회 입니다.");			
		}
	}

	private static void exit() {
		System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
		sc.nextLine();
		sc.nextLine();
	}

	private static void printMenu() {
		System.out.print( "*********메뉴*********\n"
						+ "* 1. 숫자야구 게임 실행 *\n"
						+ "* 2. 최고기록 확인     *\n"
						+ "* 3. 프로그램 종료     *\n"
						+ "*********************\n"
						+ "메뉴 선택:");
	}

	private static void playGame() {
		System.out.println("숫자 야구 게임은 4자리수의 숫자를 맞추는 게임입니다.\n"
						+ "4자리의 숫자는 각각 다른 숫자로 이루어져 있으며,\n"
						+ "자리와 숫자가 일치하면 Strike,\n"
						+ "숫자만 일치하면 Ball,\n"
						+ "아무것도 숫자도 없다면 Out입니다.\n"
						+ "단서를 모아 최단 횟수 안에 숫자를 찾아보세요!");
		int input;
		int inputNum;
		boolean right = false;
		ArrayList<Integer> exam = makeExamArray();
		System.out.println(exam);
		do {
			System.out.print("4자리의 숫자를 입력하세요:");
			input = sc.nextInt();
			if(input > 9999 || input < 1000) {
				System.out.println("자릿수가 맞지 않습니다.");
				continue;
			}
			else inputNum = input;

			ArrayList<Integer> answer = makeAnswerArray(inputNum);
			
			right = check(exam, answer);
		} while(!right);
	}

	private static boolean check(ArrayList<Integer> exam, ArrayList<Integer> answer) {
		int ball = 0;
		int strike = 0;
		for(int i = 0; i < 4; i++) {
			if(exam.contains(answer.get(i))) {
				if(exam.indexOf(answer.get(i)) == i)
					strike++;
				else ball++;
			}
		}
		if(strike == 0 && ball == 0) {
			System.out.println("Out!!");
			count++;
			return false;
		} else if(strike == 4){
			System.out.println("" + answer.get(0)
			 						+ answer.get(1)
			 						+ answer.get(2)
			 						+ answer.get(3) +" 정답입니다!");
			count++;
			System.out.println("(도전횟수 " + count + "회)");
			if(score==0 || count<score) score = count;
			count = 0;
			return true;
		} else {
			System.out.printf("%dstrike, %dball\n",strike,ball);
			count++;
			return false;
		}
	}

	private static ArrayList<Integer> makeAnswerArray(int n) {

		int i, j, k, l;
		l = n % 10;
		n /= 10;
		k = n % 10;
		n /= 10;
		j = n % 10;
		i = n / 10;
		
		ArrayList<Integer> m = new ArrayList<Integer>();
		m.add(i);m.add(j);m.add(k);m.add(l);
		
		return m;
	}

	private static ArrayList<Integer> makeExamArray() {
		ArrayList<Integer> sample = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			sample.add(i);
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		Random r = new Random();
		int pick;
		for(int i = 0; i < 4; i++) {
			pick = i == 0 ? r.nextInt(sample.size() - 1) + 1 : r.nextInt(sample.size());
			
			result.add(sample.get(pick));
			sample.remove(pick);
		}
		
		return result;
	}
}
