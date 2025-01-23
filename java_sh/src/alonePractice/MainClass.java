package alonePractice;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		Num num = new Num(1);
		
		System.out.println("Num.i = " + Num.i);

		System.out.println("num.j = " + num.j);
		
		Num num2 = new Num(1);
		
		System.out.println("Num.i = " + Num.i);

		System.out.println("num.j = " + num2.j);
//		Scanner sc = new Scanner(System.in);
//		
//		for (int i = 12593; i < 55204; i++) {
//			System.out.print((char)i);
//		}
	}
}

class Num {
	
	public Num(int j) {
		++i;
		this.j = j;
	}
	
	static int i = 1;
	int j;
}