package day003;

import java.util.Scanner;

public class Ex05_ForPrimeNumber {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("입력된 숫자까지의 소수를 출력합니다:");
		int n = scan.nextInt();
		int m = 0;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 2; j <= i; j++) {
				if(i % j == 0) {
					m = j;
					break;
				}
			}
			if(m == i) System.out.print(m + " ");
		}
	}

}
