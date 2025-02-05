package day023;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class Ex05_List {

	public static void main(String[] args) {
		/*
		 * 리스트에 좌표의 점을 저장해서 관리하는 예제.
		 * 잘못된 부분을 찾아 수정하세요.
		 */
		
		List<Point> list = new ArrayList<Point>();

//		list.add(new Point());
		
//		list.add(new Point(1, 2));
//		//정의되지 않은 생성자
//		list.add(new Point(1));
//		//정의되지 않은 생성자
		
//		list.add(1);
//		//클래스 타입 불일치
		
		/*
		 * 리스트에 좌표의 점과 문자열, 정수를 함께 관리하려한다.
		 * 이때 필요한 리스트를 선언하시오.
		 */
		
		List<Object> list2 = new ArrayList<Object>();
		list2.add(new Point());
		list2.add("안녕");
		list2.add(1);
	}

}

@Data
class Point{
	int x, y;
}