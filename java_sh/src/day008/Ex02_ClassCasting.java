package day008;

import day008.ex02.BenzCar;
import day008.ex02.KiaCar;
import day008.ex02.Car;

public class Ex02_ClassCasting {

	public static void main(String[] args) {
		
		/*다양한 자동차를 관리하는 프로그램을 만드는 상황*/
		
		Car[] list = new Car[10];
		
		//업캐스팅, 자동 클래스 변환
		list[0] = new KiaCar();
		list[1] = new BenzCar();
		
		int count = 2;
		for (int i = 0; i < count; i++) {
			Car tmp = list[i];
			if(tmp instanceof KiaCar) {
				KiaCar kiaTmp = (KiaCar)tmp;	//다운 캐스팅. 강제 클래스 변환
				System.out.println(kiaTmp.logo);
			}else if(tmp instanceof BenzCar) {
				System.out.println(((BenzCar)tmp).logo);
			}
		}
	}
}