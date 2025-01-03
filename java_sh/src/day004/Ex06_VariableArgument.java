package day004;

public class Ex06_VariableArgument {

	public static void main(String[] args) {
		
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
		System.out.println(sum(1,2,3,4));
		System.out.println(sum(1,2,3,4,5));
		
	}

	static int sum(int...n) {
		int sum = 0;
		
		for(int i : n) {
			sum += i;
		}
		
		return sum;
	}
}
