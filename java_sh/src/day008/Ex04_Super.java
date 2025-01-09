package day008;

public class Ex04_Super {

	public static void main(String[] args) {
		
		Parent p = new Parent("홍길동");
		p.print();
		System.out.println("--------------");
		Child c = new Child("임꺽정");
		c.print();
	}

}

class Parent {
	
	String name;

	public Parent(String name) {
		super();
		this.name = name;
	}
	
	
	public void print() {
		System.out.println("부모 클래스에서 출력합니다.");
	}
	
}
class Child extends Parent {
	
	String type;
	
	public Child() {
//		type = "";	//super 생성자 위에 올라갈 수 없음
		super("");
		type = "";
	}
	
	public Child(String name) {
		super(name);
		type = "일반";
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println(name + " : " + type);
	}
}