package day008;

import day008.ex02.BenzCar;
import day008.ex02.Car;
import day008.ex02.KiaCar;
import lombok.Data;

@Data
public class Ex03_Polymorphism {

	public static void main(String[] args) {
		
		KiaCar kia = new KiaCar();
		BenzCar benz = new BenzCar();
		
		kia.repair();
		benz.repair();
		
	}
//	자동차별로 기능을 만들면 종류별로 메소드 오버로딩이 필요
//	public static void repair(KiaCar kia) {kia.repair();}
//	
//	public static void repair(BenzCar benz) {benz.repair();}
	
	public static void repair(Car car) {
		car.repair();
	}
}
