package day003;

import java.util.Scanner;

public class Ex01_Test {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		for(int i = 1; i <= 3; i++) {
			System.out.print(i + "번째 학생의 성적을 입력하시오:");
			sum += scan.nextInt();
		}
		scan.close();
		System.out.println("세 학생의 총점은 " + sum + "점,"
				+ "평균은 " + String.format("%.2f", (double)sum/3) + "점 입니다.");
	}

}
