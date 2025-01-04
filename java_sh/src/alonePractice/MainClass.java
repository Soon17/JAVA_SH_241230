package alonePractice;

import java.util.ArrayList;
import java.util.Random;

public class MainClass {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add(8);a.add(4);a.add(7);a.add(9);
		b.add(2);b.add(9);b.add(7);b.add(8);
		System.out.println(a);
		System.out.println(b);
		
		int ball = 0;
		int strike = 0;
		for(int i = 0; i < 4; i++) {
			if(a.contains(b.get(i))) {
				if(a.indexOf(b.get(i))==i)
					strike++;
				else ball++;
			}
		}
		if(strike == 0&& ball == 0) {
			System.out.println("Out!!");
		} else {
			System.out.printf("%dstrike, %dball",strike,ball);			
		}
	}
}