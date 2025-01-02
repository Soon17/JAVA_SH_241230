package day003;

import java.util.Random;
import java.util.Scanner;

public class Ex13_Random {

	public static void main(String[] args) {
		
		int min = 1, max =100;
		
		//Math.random()은 0이상 1미만의 실수를 제공
		/*
		 * 0 <= r < 1
		 * 0 <= r * (max - min + 1) < max - min + 1
		 * min <= r * (max - min + 1) + min < max +1
		 *
		 * min 과 max 사이의 랜덤한 수
		 * 
		*/
		int r = (int)(Math.random()*(max - min + 1) + min);
		System.out.println(r);
		
		Random random = new Random();
		
//		int r = random.nextInt(max - min + 1) + min;
//		//random.nextInt(a)는 0에서 a-1 사이의 난수 생성
//		System.out.println(r);
		
		Scanner scan = new Scanner(System.in);
		int n = min - 1;
		while(n != r) {
			System.out.print("랜덤한 수 맞추기 UP DOWN:");
			n = scan.nextInt();
			if(n>r) System.out.println("DOWN!");
			else if(n<r) System.out.println("UP!");
			else {
				System.out.println("정답!");
			}
		}
		
		
	}

}
