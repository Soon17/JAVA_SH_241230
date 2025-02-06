package day003;

public class Ex11_ForAlphabet {

	public static void main(String[] args) {
		for(int i = 0; i < 26; i++) {
			System.out.print((char)('a'+ i));			
		}
		System.out.println();
		for(char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c);	
		}
	}
}