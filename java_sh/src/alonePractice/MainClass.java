package alonePractice;

import java.util.ArrayList;

import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("출력할 삼각형의 층 수:");
		int n = scan.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j = n-i; j >= 1; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= 2*i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scan.nextLine();
		scan.close();
	}
}