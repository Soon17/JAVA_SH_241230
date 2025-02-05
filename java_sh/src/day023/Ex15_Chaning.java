package day023;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex15_Chaning {

	public static void main(String[] args) {
		
		Point4 p = new Point4(-10, 10);
		
		p.print1();
		//print1은 리턴값이 void여서 체이닝 사용 불가
		System.out.println("=================");
		
		p.print2().print1();
		//print2는 리턴값이 Point4여서 Point4에서 제공하는 메소드를 이어서 체이닝 사용 가능
		System.out.println("=================");
		
		String str = p.print2().toString().substring(3);
		//print2는 리턴값이 Point4여서 Point4에서 제공하는 메소드를 이어서 체이닝 사용 가능
		//toString은 리턴이 String이어서 String에서 제공하는 메소드를 이어서 체이닝 사용 가능
		System.out.println("=================");
		
		System.out.println(str);
		//System 클래스의 필드로 PrintStream 객체 out이 있고,
		//PrintStream에서 제공하는 메소드를 이어서 체이닝 사용 가능
	}

}

@Data
@AllArgsConstructor
class Point4{
	private int x, y;
	
	public void print1() {
		System.out.println(x + ", " + y);
	}
	
	public Point4 print2() {
		System.out.println(x + ", " + y);
		return this;
	}
}