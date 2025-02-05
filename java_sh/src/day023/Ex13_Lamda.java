package day023;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex13_Lamda {

	public static void main(String[] args) {
		
		List<Point3> list = new ArrayList<Point3>();
		list.add(new Point3(0, 0));
		list.add(new Point3(1, 1));
		list.add(new Point3(-1, 1));
		list.add(new Point3(1, -1));
		
		//X좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어서 테스트 하세요.
		printListX(list);
		System.out.println("=======================");
		//Y좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어서 테스트 하세요.
		printListY(list);
		System.out.println("=======================");
		
		//Predicate인터페이스를 활용하여 전체 좌표를 출력하시오.
		printList(list, new Predicate<Point3>() {
			
			@Override
			public boolean test(Point3 t) {
				return true;
			}
		});
		
		System.out.println("=======================");
		//람다식을 이용하여 X좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어서 테스트 하세요.
		printList(list, p -> p.getX() >= 0);
		System.out.println("=======================");
		//람다식을 이용하여 Y좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어서 테스트 하세요.
		printList(list, t -> t.getY() >= 0);
	}
	
	public static void printList(List<Point3> list, Predicate<Point3> p) {
		for (Point3 tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}
	
	public static void printListX(List<Point3> list) {
		for (Point3 tmp : list) {
			if(tmp.getX() >= 0) {
				System.out.println(tmp);
			}
		}
	}
	
	public static void printListY(List<Point3> list) {
		for (Point3 tmp : list) {
			if(tmp.getY() >= 0) {
				System.out.println(tmp);
			}
		}
	}

}

@Data
@AllArgsConstructor
class Point3{
	int x, y;
}