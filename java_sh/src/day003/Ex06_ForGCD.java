package day003;

import java.util.Scanner;

public class Ex06_ForGCD {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("최대 공약수를 구할 두 정수를 입력하시오:");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int pn = 0;
		
		for(int i = a; i > 0; i--) {
			if(a % i == 0) {
				if(b % i == 0) {
					pn = i;
					break;
				}
			}
		}
		System.out.println("두 수의 최대 공약수는 " + pn);
		scan.close();
	}
}
