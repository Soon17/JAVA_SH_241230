package day004;

public class Ex05_Method3 {

	public static void main(String[] args) {
		for(int i = 1; i <= 9; i++) {
			gugu(i);
			System.out.println();
		}
	}

	static void gugu(int n) {
		for(int i = 2; i <= 9; i++) {
			System.out.print(i + "X" + n + "=" + n*i + "\t");
		}
	}
}
