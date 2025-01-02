package day003;

public class Ex18_NestingAlphabet {

	public static void main(String[] args) {
		
		for(char ch = 'a'; ch <= 'z'; ch++) {
			for(char c = 'a'; c <= ch; c++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

}
