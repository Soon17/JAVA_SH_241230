package day006;

public class Ex01_Swap {

	public static void main(String[] args) {
		
		int num1 = 10, num2 = 20;
		
		int t = num1;
		
		num1 = num2;
		num2 = t;
		
		System.out.println(num1 + ", " + num2);
	}

}
