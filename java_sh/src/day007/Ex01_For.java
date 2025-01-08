package day007;

public class Ex01_For {

	public static void main(String[] args) {
		/*1에서 16까지 출력하는 코드를 작성하시오.*/
		int max= 16;
		for (int i = 1; i <= max; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		/*1에서 16까지 4개씩 출력하는 코드를 작성하시오.*/
		int enter = 4;
		for (int i = 1; i <= max; i++) {
			System.out.print(i + " ");
			if(i % enter == 0)
				System.out.println();
		}
	}

}
