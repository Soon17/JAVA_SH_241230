package day002;

public class Ex01_OperatorLogical {

	public static void main(String[] args) {
		
		//점수에 따른 성적을 판별하는 예제
		int score = 80;
		
		boolean isB = score >= 80 && score < 90;
		System.out.println(score + "는 B인가?" + isB);
		
		//나이가 19세이상이면 성인으로 판별하는 예제
		int age = 15;
		
		boolean isAdult = age >= 19;
		System.out.println(age + "살은 성인입니까? " + isAdult);
		System.out.println(age + "살은 미성년자입니까? " + !isAdult);
			
		//정수가 0이상인지 판별하는 예제(||연산자)
		int num = -1;
		
		boolean isPositive = num > 0 || num == 0; //num >= 0
		System.out.println(num + "는 0이상인가? " + isPositive);
		
	}

}
