package day002;

public class Ex16_IfMultiple {

	public static void main(String[] args) {
		
		/* 정수 num과 2,3,6의 배수관계를 판별하는 코드를 작성하세요. 
		 * 2 : 2의 배수
		 * 3 : 3의 배수
		 * 4 : 2의 배수
		 * 5 : 2,3,6의 배수가 아님
		 * 6 : 6의 배수 
		 * */
		int num = 9;
		//순서에 상관없이 => 조건식이 복잡
		if(num % 2 == 0 && num % 3 != 0) {				//2의 배수O, 3의 배수X
			System.out.println(num + "는 2의 배수");
		}
		else if(num % 3 == 0 && num % 2 != 0) {			//3의 배수O, 2의 배수X
			System.out.println(num + "는 3의 배수");
		}
		else if(num % 6 == 0) {							//6의 배수
			System.out.println(num + "는 6의 배수");
		}
		else {											//전부 아님
			System.out.println(num + "는 2,3,6의 배수가 아님");
		}
		
		//순서가 중요 => 조건식이 간단
		if(num % 6 == 0) {								//6의 배수
			System.out.println(num + "는 6의 배수");
		}
		else if(num % 2 == 0) {							//외 2의 배수
			System.out.println(num + "는 2의 배수");
		}
		else if(num % 3 == 0) {							//외 3의 배수
			System.out.println(num + "는 3의 배수");
		}
		else {											//전부 아님
			System.out.println(num + "는 2,3,6의 배수가 아님");
		}
		
		//중첩 if문
		if(num % 2 == 0) {								//2의 배수 중 
			if(num % 3 == 0) {							//3의 배수, 즉 6의 배수
				System.out.println(num + "는 6의 배수");
			}
			else {										//외 2의 배수
				System.out.println(num + "는 2의 배수");
			}
		}
		else if(num % 3 == 0) {							//2의 배수 외 3의 배수
			System.out.println(num + "는 3의 배수");
		}
		else {											//전부 아님
			System.out.println(num + "는 2,3,6의 배수가 아님");
		}

	}

}
