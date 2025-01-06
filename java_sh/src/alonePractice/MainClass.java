package alonePractice;

import java.util.ArrayList;
import java.util.Random;

public class MainClass {
	public static void main(String[] args) {
		System.out.println(Q.a);
		Q.printA();
		
		Q q = new Q();
		System.out.println(q.b);
		q.printB();
	}
}
class Q {
	static int a = 10;
	static void printA() {
		System.out.println(a);
	}
	int b = 10;
	void printB() {
		System.out.println(b);
	}
}