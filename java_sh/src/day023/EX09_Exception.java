package day023;

public class EX09_Exception {

	public static void main(String[] args) {
		
		/*
		 *0으로 나눌 수 없음을 처리하도록 수정
		 */
		
		double num1 = 1, num2 = 0;
		
		try{
			if(num2 == 0) throw new ArithmeticException();
			System.out.println(num1 + "/" + num2 + "=" + num1/num2);
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}

}
