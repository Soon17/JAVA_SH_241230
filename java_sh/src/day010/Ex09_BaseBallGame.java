package day010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ex09_BaseBallGame {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int min = 1, max = 9, size = 4;
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> user = new ArrayList<Integer>();
		
		createRandomList(min, max, size, list);
		
		int ball = 0;
		int strike = 0;
		
		do {
			user.clear();
			
			inputAnswer(user);
			
			strike = getStrike(list, user);
			
			ball = getBall(list, user);
			
			printResult(strike, ball);
			
		} while(strike != 4);
		
		System.out.println("정답입니다!");
	}

	private static void inputAnswer(ArrayList<Integer> user) {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			System.out.print(i + "번째 숫자 입력:");
			try{
				int n = sc.nextInt();
				if(n < 1 || n > 9) {
					System.out.println("한자리 수인 양의 정수로 입력해 주세요.");
					i--;
					continue;
				}
				if(user.contains(n)) {
					System.out.println("숫자가 중복되었습니다.");
					i--;
					continue;
				}
				user.add(n);
			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력 가능합니다.");
				i--;
				sc.nextLine();
				continue;
			}
		}
	}

	private static int getStrike(ArrayList<Integer> list, ArrayList<Integer> user) {
		int count = 0;
		for (int i = 0; i < user.size(); i++) {
			if(list.get(i).equals(user.get(i)))
				count++;
		}
		return count;
	}

	private static int getBall(ArrayList<Integer> list, ArrayList<Integer> user) {
		int count = 0;
		for (int i = 0; i < user.size(); i++) {
			if(list.contains(user.get(i)) && !list.get(i).equals(user.get(i)))
				count++;
		}
		return count;
	}

	private static void printResult(int strike, int ball) {
		if(strike ==0 && ball == 0) {
			System.out.println("OUT");
		} else {
			System.out.println(strike + "S, " + ball + "B");			
		}
	}

	private static void createRandomList(int min, int max, int size, ArrayList<Integer> list) {
		HashSet<Integer> set = new HashSet<Integer>();
		Random r = new Random();
		do {
			int n = r.nextInt(max - min + 1) + min;
			set.add(n);
		} while(set.size() < size);
		
		list.addAll(set);
		Collections.shuffle(list);
		
		System.out.println(list);
	}

}
