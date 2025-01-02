package day003;

public class Ex07_ForSum {

	public static void main(String[] args) {
		
		int n = 10;
		int sum = 0;
		for(int i = 1 ; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		int sum2 = 0;
		for(int i = 2 ; i <= n; i+=2) {
			sum2 += i;
		}
		System.out.println(sum2);
		
	}

}
