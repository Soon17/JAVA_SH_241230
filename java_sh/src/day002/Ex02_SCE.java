package day002;

public class Ex02_SCE {

	public static void main(String[] args) {
		
		//단락 회로 평가 예제(SCE)
		int num1 = -10, num2 = 20;
		//SCE에 의해 num1이 양수이면 num2가 안바뀌고, num1이 음수이면 num2가 10으로 바뀜
		boolean result = num1 < 0 && (num2 = 10) < 0;
		System.out.println("결과 값 : " + result);
		System.out.println("num1 : " + num1 + ", num2 : " + num2);
		
		A a = new A();
		if( a != null && a.num > 0) {
			System.out.println(a.num);
		}									//SCE에 의해 출력가능
		B b = null;
		if( b != null && b.num > 0) {
			System.out.println(b.num);		//SCE에 의해 출력불가
		}
		
	}

}
class A{
	int num = 8;
}
class B{
	int num = 8;
}