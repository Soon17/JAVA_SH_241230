package day004;

public class Ex02_MethodSum {

	public static void main(String[] args) {
		int i = 3, j = 5;
		int s = sum(i,j);
		System.out.println(s);
	}
	
	static int sum(int n, int m) {
		int s = n + m;
		return s;
	}

}
