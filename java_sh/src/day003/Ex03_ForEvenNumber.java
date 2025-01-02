package day003;

public class Ex03_ForEvenNumber {

	public static void main(String[] args) {
		
		for(int i = 1 ; i <= 10; i++) {
			if(i%2 == 0)
				System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i = 2 ; i <= 10; i+=2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i = 1 ; i <= 5; i++) {
			System.out.print(i*2 + " ");
		}
	}

}