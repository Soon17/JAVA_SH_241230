package day006;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex07_BaseballGame {

	static int count = 0;
	public static void main(String[] args) {
		//숫자야구를 구현하세요.
		Scanner sc = new Scanner(System.in);
		
		int seat = 3;
		
		int[] exam = createArray(1, 9, seat);
		for (int i = 0; i < exam.length; i++) {
			System.out.print(exam[i]);
		}
		System.out.println();
		int inputNum[] = new int[seat];
		boolean right = false;
		do {
			System.out.print(seat + "개의 정수를 입력하세요:");
			for (int i = 0; i < seat; i++) {
				inputNum[i] = sc.nextInt();
			}
			right = check(exam, inputNum, seat);
		} while(!right);
		
		
	}
	public static int[] createArray(int i, int j, int k) {
		int count = 0;
		int[] array = new int[k];
		Random r = new Random();
		
		while(count < array.length) {
			int ranNum = r.nextInt(j) + i;
			
			if(haveNum(array, ranNum)) continue;
			array[count] = ranNum;
			count++;
		}
		return array;
	}
	public static boolean haveNum(int[] array, int ranNum) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == ranNum) {
				return true;
			}
		}
		return false;
	}
	public static boolean check(int[] exam, int[] answer, int seat) {
		int ball = 0;
		int strike = 0;
		for(int i = 0; i < seat; i++) {
			if(haveNum(exam, answer[i])) {
				if(exam[i] == answer[i])
					strike++;
				else ball++;
			}
		}
		if(strike == 0 && ball == 0) {
			System.out.println("Out!!");
			count++;
			return false;
		} else if(strike == seat){
			System.out.println("정답입니다!");
			count++;
			System.out.println("(도전횟수 " + count + "회)");
			return true;
		} else {
			System.out.printf("%dstrike, %dball\n",strike,ball);
			count++;
			return false;
		}
	}
}