package day005;

import java.util.Scanner;

public class Ex06_Array {

	public static void main(String[] args) {
		int studentCount = 3;
		int[] kors = new int[studentCount];
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < studentCount; i++) {
			System.out.print("학생 " + (i+1) + " 국어 성적 입력:");
			kors[i] = sc.nextInt();
		}
		
		for(int i = 0; i < studentCount; i++) {
			System.out.println("학생 " + (i+1) + " 국어 성적:" + kors[i]);
		}
		
		int sum = 0;
		for(int i = 0; i < studentCount; i++) {
			sum += kors[i];
		}
		
		System.out.println("세 학생의 국어성적 평균은 " + (double)sum/3 + "입니다.");
	}

}
