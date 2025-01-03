package day004.access.modifier;

import day004.access.modifier2.B;

public class Ex08_AccessModifier {

	public static void main(String[] args) {
		//A클래스는 같은 패키지
		//B클래스는 다른 패키지
		A a1 = new A();
		B b1 = new B();
		
		//public 필드들은 다른 패키지의 클래스에서 사용 가능
		a1.name = "홍길동";
		b1.name = "임꺽정";
		
		//default 필드들은 같은 패키지의 클래서에서만 사용 가능
		a1.address = "서울시";
		//b1.address = "서울시";			//다른 패키지어서 사용 불가능
		
		//private 필드들은 해당 클래스가 아니면 사용 불가능
		//a1.num = "000101-1234567";
		//b1.num = "000101-1234567";
		b1.setNum("000101-1234567");	//
		System.out.println(b1.getNum());
	}

}
