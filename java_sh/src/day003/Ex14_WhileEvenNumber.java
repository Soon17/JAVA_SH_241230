package day003;

public class Ex14_WhileEvenNumber {

	public static void main(String[] args) {
		
		int i = 1;
		int n = 10;
		
		while(i <= n) {
			if(i % 2 == 0) System.out.print(i + " ");
			i++;
		}
		
		System.out.println();
		
		i = 0;
		while(++i <= n) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}
	}

}
