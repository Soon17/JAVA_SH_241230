package day010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ex06_ListSort {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(1);
		list.add(3);
		System.out.println(list);
		
		//오름차순 정렬
		Collections.sort(list);		//배열도 사용 가능
		System.out.println(list);
		
		//내림차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
		/*
		 * sort 메소드는 Comparator 인터페이스의 구현클래스 객체가 필요
		 * -> 구현 클래스의 메소드를 이용해서 정리하기 때문
		 * 익명클래스를 만들고, 그 객체를 생성해서 매개변수로 사용
		 */
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;		//오름차순 정렬
			}
		});
		
		System.out.println(list);
		
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;		//내림차순 정렬
			}
		});
		
		System.out.println(list);
		
		list.sort((o1,o2)->o2-o1);	//람다식(위의 내림차순 코드와 동일한 코드)
	}

}
