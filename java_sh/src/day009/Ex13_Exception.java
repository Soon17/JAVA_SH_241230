package day009;

public class Ex13_Exception {

	public static void main(String[] args) {
		try {			
			test1();
			System.out.println(1/0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}
	
	public static void test1() {
		test2();
	}
	
	public static void test2() {
		test3();
	}

	public static void test3() {
		throw new RuntimeException("예외가 발생");
	}
}
