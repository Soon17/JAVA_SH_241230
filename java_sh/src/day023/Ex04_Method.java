package day023;

public class Ex04_Method {

	public static void main(String[] args) {
		
		/*
		 * 두 정수의 합을 구하는 메소드를 생성하고 테스트 하세요
		 */
		
		int x = 5, y = 6;
		
		System.out.println(sum(x, y));
		
		/*
		 * 세 정수의 합을 구하는 메소드를 생성하고 테스트 하세요
		 */
		
		int z = 7;
		
		System.out.println(sum(x, y, z));
		
		/*
		 * 여러 정수의 합을 구하는 메소드를 생성하고 테스트 하세요
		 */
		
		System.out.println(sum(x, y, z, 9, 4, 65));
	}
	
	private static int sum(int x, int y, int z) {
		return x + y + z;
	}

	private static int sum(int x, int y) {
		return x + y;
	}
	
	private static int sum(int...x) {
		int sum = 0;
		
		for (int i : x) {
			sum += i;
		}
		return sum;
	}

}
