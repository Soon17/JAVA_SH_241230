package day009;

public class Ex10_RuntimeException {

	public static void main(String[] args) {
		//대표적인 RuntimeException들
		
		/*ArithmeticException					: 0으로 나누는 경우(a/0, a%0. double이면 무한)*/
		int num1 = 1, num2 = 0;
		System.out.println(num1 / (double)num2);
		
		/*NullPointerException					: 객체 생성 없이 null인 상태로 호출되는 경우*/
		String str = null;
//		System.out.println(str.charAt(0));
		
		/*ArrayIndexOutOfBoundsException		: 배열 범위 밖의 번지에 접근하는 경우*/
		int[] arr = new int[4];
//		arr[4] = 10;
		
		/*NumberFormatException					: 숫자 형식이 필요한 곳에서 숫자가 아닌 값을 받은 경우*/
		String strNum = "1234a";
//		System.out.println(Integer.parseInt(strNum));
		
		/*ClassCastException					: 부모객체 -> 자식객체의 다운캐스팅한 일부 경우
		 * 										  업캐스팅 후 다운캐스팅을 하면 예외 발생 없음.*/
		Parent p = new Parent();
//		Child ch = (Child)p;
		
		
	}

}
class Parent {}
class Child extends Parent{}