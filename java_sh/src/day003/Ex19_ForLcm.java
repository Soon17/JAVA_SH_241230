package day003;

import java.util.Scanner;

public class Ex19_ForLcm {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("최소 공배수를 구할 두 정수를 입력하시오:");
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int lcm = 0;
		int count = 1;
		
		for(int i = 1; i <= n2; i++, count++) {
			if(n1 * i % n2 == 0) {
				lcm = n1 * i;
				break;
			}
		}
		
		System.out.println("최소공배수는 " + lcm + ", 반복횟수: " + count);
	}

}
