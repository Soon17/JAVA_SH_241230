package day007;

public class Ex02_For {

	public static void main(String[] args) {
		/*1부터 10까지의 합을 구하는 코드를 작성하시오.*/
		int min = 1;
		int max = 10;
		int sum = 0;
		for (int i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println(min + "부터 " + max + "까지의 합은 " + sum);
		
		/*1-2+3-4+5-6+7-8+9-10의 값을 구하는 코드를 작성하시오.*/
		sum = 0;
		for (int i = min; i <= max; i++) {
			if(i%2==0) {
				sum -= i;
			} else {
				sum += i;
			}
		}
		System.out.println("1-2+3-4+5-6+7-8+9-10의 값은 " + sum);
	}

}
