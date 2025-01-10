package day009;

import java.util.ArrayList;
import java.util.Iterator;

import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Ex16_List {

	public static void main(String[] args) {
		
		/*
		 * List : 인터페이스
		 * ArrayList, LinkedList, Vector : List를 구현한 클래스
		 * List 특징 : 순서 보장, 중복 허용
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(20);
		System.out.println(list);
		list.set(1,  20);
		System.out.println(list);
		list.remove((Integer)20);		// 그냥 20을 쓰면 20번지로 접근
		System.out.println(list);
		System.out.println("현재 저장된 개수: " + list.size());
		
		ArrayList<Point> list2 = new ArrayList<Point>();
		list2.add(new Point(1,1));
		list2.add(new Point(10,10));
		System.out.println(list2);
		
		/*
		 * boolean remove(Object o)
		 * 	- 이 remove는 같다를 Objects.equals를 이용하여 판단
		 * 	- Object.equals(Object 01, Object o2)
		 * 		-o1과 o2가 다른 클래스이면 false 리턴
		 * 		-같은 클래스이면 o1.equals를 이용하여 비교
		 */
		list2.remove(new Point(1,1));
		System.out.println(list2);
		
		list2.add(new Point(10,10));
		list2.add(new Point(-1,-1));
		System.out.println(list2);
		
		Iterator<Point> it = list2.iterator();
		System.out.println("-----------------");
		while(it.hasNext()) {
			Point tmp = it.next();
			System.out.println(tmp);
		}
		
		//indexOf(객체) : 객체가 몇번지에 있는지 알려줌
		//Objects.equals를 이용하여 같은 객체를 찾아 번지를 반환
		int index = list2.indexOf(new Point(10, 10));
		System.out.println(index);
		boolean res = list2.contains(new Point(1, 3));
		System.out.println(res);
		
		//1번지에 있는 좌표 정보를 가져와서 (2, 3)으로 수정하시오.
		Point p = list2.get(1);
		p.x = 2;
		p.y = 3;
		System.out.println(list2
				
				
				);
	}

}

@ToString
@EqualsAndHashCode		// 이게 없으면 remove가 안됨
class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}