package day008;

public class Ex05_AbstractClass {

	public static void main(String[] args) {
		
//		A1 a1 = new A1();	//에러발생. 추상클래스는 객체 생성 불가.
		A1 a1 = new B1();	//자식 클래스를 이용하여 객체 생성후 업캐스팅으로 형변환
	}

}

//추상 메소드가 없어도 abstract를 붙이면 추상 클래스가 됨.
abstract class A1 {
	
}

class B1 extends A1 {
	
}

//추상 메소드가 있으면 반드시 추상 클래스로 만들어야 함.
abstract class A2 {
	//추상메소드
	public abstract void print();
	//구현이 안 된 메소드
	public void print2() {}
}
//추상 클래스를 상속받으면 추상클래스만 될 수 있다.
abstract class B2_1 extends A2 {
	
}
//추상 클래스를 상속받고 오버라이딩 구현을 해야 일반 클래스가 될 수 있다.
class B2_2 extends A2 {

	@Override
	public void print() {
		System.out.println("출력합니다.");
	}
	
}