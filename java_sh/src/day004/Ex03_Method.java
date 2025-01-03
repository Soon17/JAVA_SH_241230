package day004;

import java.util.Random;
import java.util.Scanner;

public class Ex03_Method {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("두 정수: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.println("최대공약수는 " + gcd(a,b));
		System.out.println("최소공배수는 " + lcm(a,b));
		System.out.println("둘 사이의 랜덤한 정수: " + random(a,b));
		System.out.println("둘 사이의 랜덤한 정수: " + random2(a,b));
	}
	
	static int lcm(int n, int m) {
		for(int i = n; ; i+=n) {
			if(i % m == 0) {
				return i;
			}
		}
	}
	/***
	 * 
	 * @param n : 정수 1
	 * @param m : 정수 2
	 * @return : 최대공약수
	 */
	static int gcd(int n, int m) {
		for(int i = n; ; i--) {
			if(n % i == 0) {
				if(m % i == 0) {
					return i;
				}
			}
		}
	}
	static int random(int min, int max) {
		return (int)(Math.random()*(max - min + 1) + min);
	}
	static int random2(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}
}
