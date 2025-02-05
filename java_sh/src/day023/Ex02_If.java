package day023;

public class Ex02_If {

	public static void main(String[] args) {
		
		/*
		 * 짝수이면 짝수라고 출력하고, 2로 나눈 값을 출력
		 * 홀수이면 홀수라고 출력하고, +1 한 값을 출력
		 */
		
		int num = 2;
		//실행문이 두줄인데 {}을 생략함
		if(num % 2 == 0)
			System.out.println(num + "는 짝수");
			System.out.println(num / 2);
		if(num % 2 != 0)
			System.out.println(num + "는 홀수");
			System.out.println(num + 1);
	}

}
