package day005;

import day004.Ex01_Star;

public class Ex03_static2 {

	
	public static void main(String[] args) {
		System.out.println(sum1(1,2));
		
		Ex03_static2 s = new Ex03_static2();
		System.out.println(s.sum2(1,2));
		
		Ex01_Star.main(args);
		
	}
	public static int sum1(int num1, int num2) {
		return num1 + num2;
	}
	public int sum2(int num1, int num2) {
		return num1 + num2;
	}

}

class StaticTest {
	int a;
	static int sa;
	
	public void printA() {
		a = 10;
		sa = 10;
	}
	
	public static void printSa() {
		//a = 10;		//객체변수는 정적메소드(클래스메소드)에서 사용불가.
		StaticTest st = new StaticTest();
		st.a = 10;		//객체변수 사용을 위해 객체를 생성한 후 사용하면 가능.
		sa = 10;
	}
	
	public void test() {
		printA();
		printSa();
	}
	
	public static void StaticTest() {
		//printA();		//객체메서드는 정적메소드(클래스메소드)에서 사용불가.
		StaticTest st = new StaticTest();
		st.printA();	//객체메서드 사용을 위해 객체를 생성한 후 사용하면 가능.
		printSa();
	}
}