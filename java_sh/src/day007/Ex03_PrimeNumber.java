package day007;

public class Ex03_PrimeNumber {
	
	public static void main(String[] args) {
		
		/*정수 num가 소수인지 아닌지 판별하는 코드를 작성하세요.*/
		int num = 100;
		if(isPrime(num)) System.out.println(num + " : 소수입니다.");
		else System.out.println(num + " : 소수가 아닙니다.");
		
		/*num 이하의 소수를 판별하기 위해 배열을 활용하여 작성하시오.*/
		/*i 가 소수인지에 따라 i 인덱스에 boolean 값을 저장*/
		boolean[] primeArray = new boolean[num+1];
		for (int i = 0; i < primeArray.length; i++) {
			primeArray[i] = isPrime(i);
		}

		/*배열의 소수들만 출력하는 코드를 작성하시오.*/
		for (int i = 0; i < primeArray.length; i++) {
			if(primeArray[i]) System.out.print(i + " ");
		}
	}
	static boolean isPrime(int n) {
		int i;
		for(i = 2; i <= n; i++) {
			if(n % i == 0) {
				break;
			}
		}
		if(i == n) return true;
		else return false;
	}
}
