package day008.ex02;

import lombok.Data;

@Data
public class KiaCar extends Car{

	public String logo = "기아";
	
	@Override
	public void repair() {
		System.out.println("기아를 수리합니다.");
	}
}
