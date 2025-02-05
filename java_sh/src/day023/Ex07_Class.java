package day023;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Ex07_Class {

	public static void main(String[] args) {
		/*
		 * 카페 메뉴 관리를 위한 음료 클래스를 만드려고 한다.
		 * 다음 조건을 만족하는 클래스를 선언하시오.
		 * 
		 * - 클래스 이름 Drink
		 * - 필드로 메뉴얼과 금액이 필요
		 * - 클래스는 캡슐화에 맞춰 구현
		 * - getter / setter 작업
		 * - 매개변수가 있는 생성자를 작성
		 * - 직렬화 / 역직렬화가 가능하도록 작성
		 */
		
		Drink d = new Drink("아이스 아메리카노", 1500);
		System.out.println(d.getMenu() + " : " + d.getPrice() + "원");
	}

}

@Getter
@Setter
@AllArgsConstructor
class Drink implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String menu;
	private int price;
}