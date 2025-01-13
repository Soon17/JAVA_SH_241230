package day010;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex07_ListSort2 {

	public static void main(String[] args) {
		ArrayList<Student1> list1 = new ArrayList<Student1>();
		list1.add(new Student1(1, 1, 3, "홍길동"));
		list1.add(new Student1(1, 1, 1, "고길동"));
		list1.add(new Student1(1, 1, 2, "김길동"));
		list1.add(new Student1(2, 1, 3, "조길동"));
		list1.add(new Student1(1, 2, 1, "이길동"));
		list1.add(new Student1(1, 2, 2, "박길동"));
		
		System.out.println(list1);
		
		Collections.sort(list1);
		
		System.out.println(list1);
		
		System.out.println("-----------------------");
		
		ArrayList<Student2> list2 = new ArrayList<Student2>();
		list2.add(new Student2(1, 1, 3, "홍길동"));
		list2.add(new Student2(1, 1, 1, "고길동"));
		list2.add(new Student2(1, 1, 2, "김길동"));
		list2.add(new Student2(2, 1, 3, "조길동"));
		list2.add(new Student2(1, 2, 1, "이길동"));
		list2.add(new Student2(1, 2, 2, "박길동"));
		
//		list2.sort(new Student2(1, 1, 1, "a"));		//아래와 동일
		list2.sort(new Comparator<Student2>() {

			@Override
			public int compare(Student2 o1, Student2 o2) {
				if(o1.grd != o2.grd) {
					return o1.grd - o2.grd;
				}
				if(o1.cls != o2.cls) {
					return o1.cls - o2.cls;
				}
				if(o1.num != o2.num) {
					return o1.num - o2.num;
				}
				return 0;
			}
		});
		System.out.println(list2);
		
	}

}

@Data
@AllArgsConstructor
class Student1 implements Comparable<Student1>{
	private int grd, cls, num;
	String name;
	
	public String toString() {
		return grd + "학년 " + cls + "반 " + num + "번 " + name + "\n";
	}

	@Override
	public int compareTo(Student1 o) {
		if(grd != o.grd) {
			return grd - o.grd;
		}
		if(cls != o.cls) {
			return cls - o.cls;
		}
		if(num != o.num) {
			return num - o.num;
		}
		return 0;
	}
}

@Data
@AllArgsConstructor
class Student2 implements Comparator<Student2>{
	public int grd, cls, num;
	public String name;
	
	public String toString() {
		return grd + "학년 " + cls + "반 " + num + "번 " + name + "\n";
	}

	@Override
	public int compare(Student2 o1, Student2 o2) {
		if(o1.grd != o2.grd) {
			return o1.grd - o2.grd;
		}
		if(o1.cls != o2.cls) {
			return o1.cls - o2.cls;
		}
		if(o1.num != o2.num) {
			return o1.num - o2.num;
		}
		return 0;
	}
}