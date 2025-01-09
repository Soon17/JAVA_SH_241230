package day008;

public class Ex06_Final {

	public static void main(String[] args) {
		/*
		 * final : 변하지 않는다
		 * 	- 변수 : 변수가 변하지 않음 -> 상수
		 * 	- 메소드 : 메소드가 변하지 않음 -> 오버라이딩 불가능
		 * 	- 클래스 : 클래스가 변하지 않음 -> 상속 불가능(String 등)
		 */
		final int max;
		max = 10;
//		max = 11;						//	final 변수인 max 는 바꿀 수 없음.
		
	}
}

	final class C1{}
	
	class C2 {
		public void test1() {}
		public final void test2() {}
	}
	
//	class D1 extends C1 {}				//	final class 인 C1은 부모가 될 수 없음
	
	class D2 extends C2 {
		@Override
		public void test1() {}
//		@Override
//		public final void test2() {}	//	final 메소드인 test2는 오버라이딩 될 수 없음
	}