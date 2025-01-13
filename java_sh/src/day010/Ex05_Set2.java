package day010;

import java.util.HashSet;
import java.util.Random;

public class Ex05_Set2 {

	public static void main(String[] args) {
		/*
		 * 1부터 9사이의 랜덤한 수를 생성하여 중복되지 않게 3개 만드는 코드를 작성하시오.
		 */
		int min = 1, max = 9;
		Random r = new Random();
		HashSet<Integer> set = new HashSet<Integer>();
		int count = 0;
		do {
			int n = r.nextInt(max) + min;
			if(set.add(n)) count++;
		} while(count < 3);
		
		System.out.println(set);
	}

}
