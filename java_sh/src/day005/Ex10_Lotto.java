package day005;

import java.util.Random;
import java.util.Scanner;

public class Ex10_Lotto {

	public static void main(String[] args) {
		int min = 1, max = 45, choice = 6;
		int[] lotto = Ex09_ArrayRandom2.createArray(min,max,choice);
		
		int bonus;
		do {
			Random r = new Random();
			bonus = r.nextInt(max) + min;
		}while(Ex09_ArrayRandom2.haveNum(lotto, bonus));
		
		Ex09_ArrayRandom2.printArray(lotto);
		System.out.println("\"" + bonus + "\"");
		
		Scanner sc = new Scanner(System.in);
		int[] user = new int[6];
		System.out.print("번호를 입력하세요: ");
		for(int i = 0; i < 6; i++) {
			user[i] = sc.nextInt();
		}
		
		int count = 0;
		for(int i = 0; i < lotto.length; i++) {
			if(Ex09_ArrayRandom2.haveNum(user, lotto[i])) {
				count++;
			}
		}
		
		switch(count) {
		case 6:
			System.out.println("1등 당첨!");
			break;
		case 5:
			if(Ex09_ArrayRandom2.haveNum(user, bonus)) {
				System.out.println("2등 당첨!");
			} else System.out.println("3등 당첨!");
			break;
		case 4:
			System.out.println("4등 당첨!");
			break;
		case 3:
			System.out.println("5등 당첨!");
			break;
		default :
			System.out.println("꽝!");
			break;
		}
	}
}
