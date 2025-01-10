package day009;

import java.util.ArrayList;

import day008.ex02.KiaCar;

public class Ex05_Wrapper {

	public static void main(String[] args) {
		
		int num1 = 10;
		Integer num2 = num1;	//박싱: 기본형 -> 클래스
		int num3 = num2;		//언박싱: 클래스 -> 기본형
		System.out.println(num2 + ", " + num3);
		
		//언박싱의 경우 null을 유의
		num2 = null;			//클래스이기때문에 null저장 가능
//		num3 = num2;			//null을 정수로 만들수 없어서 예외발생
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println(list);
	}

}
