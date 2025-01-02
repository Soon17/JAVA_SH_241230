package day003;

import java.util.Scanner;

public class Ex04_forDevisor {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("입력된 수의 약수를 출력합니다:");
		int n = scan.nextInt();
		
		for(int i = 1; i <= n; i++) {
			if(n%i==0) System.out.print(i + " ");
		}
		scan.close();
	}
}