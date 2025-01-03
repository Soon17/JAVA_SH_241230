package day004;

public class Ex04_Method2 {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++)
			System.out.print(isPrimeNumber(i) ? i + " " : "");
		
		System.out.println();
		
		int n = 17;
		System.out.println(isPrimeNumber2(n) ?
				n + "는 소수입니다." : n + "는 소수가 아닙니다.");
	}
	
	static boolean isPrimeNumber(int n) {
		if(n == 1) return false;		// 1은 소수가 아님
		for(int i = 2; i < n ; i++) {
			if(n % i == 0) {
				return false;			// 나누어지면 소수가 아님
			}
		}
		return true;					// 그 외는 소수
	}
	
	static boolean isPrimeNumber2(int n) {
		for(int i = 2; i <= n ; i++) {
			if(n % i == 0) {
				return i == n ? true : false;
			}
		}
		return false;
	}
}
