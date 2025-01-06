package day005;

import java.util.Random;

import javax.print.attribute.standard.PrinterMakeAndModel;

public class Ex07_ArrayRandom {

	public static void main(String[] args) {
		
		int size = 6;
		int min = 1;
		int max = 10;
		
		printArray(makeRandomNumArray(min, max, size));
		
		
	}
	
	static int[] makeRandomNumArray(int min, int max, int size) {
		if(size <= 0) {
			return null;
		}
		int[] n = new int[size];
		Random r = new Random();
		for(int i = 0; i < n.length; i++) {
			n[i] = r.nextInt(max) + min;
		}
		return n;
	}
	
	static void printArray(int[] n) {
		for(int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
	}

}
