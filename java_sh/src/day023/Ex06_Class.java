package day023;

import lombok.Data;

public class Ex06_Class {

	public static void main(String[] args) {
		/*
		 * 다음 예제에서 잘못된 부분을 찾아 수정하세요.
		 */
		MyStudent std = null;
		print(std);
		
	}
	
	public static void print(MyStudent std) {
		System.out.println(std.getGrade() + "학년");
		System.out.println(std.getClassNum() + "반");
		System.out.println(std.getNum() + "번호");
		System.out.println(std.getName());
	}

}

@Data
class MyStudent{
	int grade, classNum, num;
	String name;
}