package day010;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Ex02_List2 {

	public static void main(String[] args) {
		
		/*
		 * 클래스 형변환
		 * 구현클래스(ArrayList)의 객체 인터페이스(List)로 자동 클래스 형변환 할 수 있다.
		 */
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(1,1));
		list.add(new Point(2,2));
		
		System.out.println(list);
		
		//get을 이용해서 가져오면 주소를 공유함.(변경 반영)
		Point p = list.get(0);
		p.setX(10);
		p.setY(10);
		
		System.out.println(list);
		
		//가져온 주소를 복사생성자를 통해 새로운 객체를 만듦.(변경 미반영)
		Point p2 = new Point(list.get(1));
		
		p2.setX(20);
		p2.setY(20);
		
		System.out.println(list);
	}

}

@Data
@AllArgsConstructor	//모든 멤버를 매개변수로 하는 생성자
@NoArgsConstructor	//기본 생성자
class Point {

	private int x, y;
	
	public Point(Point p) {
		x = p.x;
		y = p.y;
	}
}