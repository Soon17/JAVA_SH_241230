package day003;

public class Ex17_NestingPrimeNumber {

	public static void main(String[] args) {
		
		int num = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 2; j <= i; j++) {
				if(i % j == 0) {
					num = j;
					break;
				}
			}
			if(num == i) System.out.print(num + " ");
		}
	}

}
