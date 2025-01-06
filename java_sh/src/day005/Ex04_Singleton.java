package day005;

public class Ex04_Singleton {

	public static void main(String[] args) {
		//Singleton s = new Singleton;
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1.getNum());
		System.out.println(s2.getNum());
		
		s1.setNum(20);
		
		System.out.println(s1.getNum());
		System.out.println(s2.getNum());
	}

}

class Singleton{
	//싱글톤 클래스는 객체를 생성해서 클래스 변수에 연결, 생성자는 이때만 사용
	private Singleton() {
		num = 10;
	}
	
	private static Singleton s = new Singleton();
	
	public static Singleton getInstance() {
		return s;
	}
	
	private int num = 10;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}