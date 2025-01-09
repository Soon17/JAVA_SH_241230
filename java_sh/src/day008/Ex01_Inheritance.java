package day008;

import day008.ex02.*;
import lombok.Data;

@Data
public class Ex01_Inheritance {

	public static void main(String[] args) {
		/* KiaCar 객체를 만들 때, 
		 * Car 클래스의 멤버변수(power, speed)가 먼저 생성되고,
		 * Car 클래스의 생성자로 초기화가 됨
		 * KiaCar 클래스에서 선언한 멤버변수를 생성하고
		 * KiaCar 클래스의 생성자로 초기화가 됨 
		 * */
		KiaCar kia = new KiaCar();
		//kia.power = true; //에러 발생 : 다른 클래스에서 private을 사용할 수 없다
		kia.turnOn();
		System.out.println(kia.isPower());
		
		//protected는 자신 + 패키지 + 자식
//		kia.speed = 10; 	//자식 클래스가 아니고, 다른 패키지에 있는 클래스에서 사용할 수 없다. 
	}

}

class HyundaiCar extends Car{
	
	public String logo = "현대";
	
	public void test() {
		//다른 패키지이만 자식 클래스이기 때문에 speed를 사용할 수 있다.
		speed = 0;
		//자식 클래스이어도 private으로 된 변수에는 접근할 수 없다
//		power = false;		//에러 발생
	}
}