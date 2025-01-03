package day004;

public class Ex07_Class {

	public static void main(String[] args) {
		
		Car c1 = new Car("현대","아반떼",2025);
		System.out.println(c1.name);
		Car c2 = new Car("기아","K5",2025);
		System.out.println(c2.name);
		
		c1.print();
		c1.turnOn();
		c1.print();
		for(int i = 1; i<= 10; i++) {
			c1.speedUp();
		}
		c1.print();
		c1.changeGear('D');
		for(int i = 1; i<= 10; i++) {
			c1.speedUp();
		}
		c1.print();
		c1.color = "Green";		//public 가능
		//c1.gear = 'N';		//private 불가능
		c1.changeGear('N');
		c1.print();
		
	}

}

class 클래스명{
	클래스명() {} // 생성자
	int 멤버변수;
	void 메소드() {};
}

class Car{
	
	public Car() {}
	public Car(String com) {					// 생성자 오버로딩
		company = com;
	}
	public Car(String com, String n, int y) {	// 생성자 오버로딩
		company = com;
		name = n;
		year = y;
		gear = 'P';
	}
	
	public String company, name, type, color, oilType;
	public int year;
	private int speed, deg;
	private boolean power;
	private char gear;
	
	public void turnOn() {
		power = true;
	}
	 
	public void turnOff() {
		if(speed == 0) {
			power = false;			
		}
	}
	
	public void speedUp() {
		if(power && (gear == 'D' || gear == 'R')) {
			speed++;
		}
	}
	
	public void speedDown() {
		if(power) {
			speed--;
		}
	}
	
	public void changeGear(char g) {
		if(power) {
			gear = g;
		}
	}
	
	public void chageDeg(int d) {
		deg = d;
	}
	
	
	public void print() {
		System.out.println("****************");
		System.out.println("전원: " + power);
		System.out.println("속력: " + speed);
		System.out.println("기어: " + gear);
		System.out.println("색상: " + color);
		System.out.println("****************");
	}
}