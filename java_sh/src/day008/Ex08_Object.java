package day008;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.ToString;

public class Ex08_Object {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Point p = new Point();
		
		/*
		 * println 은 매개변수가 클래스의 객체면 toString 을 호출해서 출력
		 * -> 모든 클래스는 Object 클래스를 상속받음
		 * -> Object 클래스에서 물려받은 toString()을 갖고있기 때문에
		 */
		System.out.println(p);
		System.out.println(p.toString());
		
		Student std1 = new Student(1, 1, 1, "홍길동", "국어", 100);
		Student std2 = new Student(1, 1, 2, "홍길동", "국어", 100);
		Student std3 = new Student(1, 1, 1, "엄꺽정", "국어", 90);
		
		System.out.println(std1.equals(std2));
		System.out.println(std1.equals(std3));
		
		Student std4 = (Student)std1.clone();
		std1.score = 90;
		System.out.println(std4);
		
	}
	public void println(Object obj) {
		System.out.println(obj.toString());
	}

}

@ToString
class Point {
	private int x, y;

	@Override
	public String toString() {
		return "Point (x좌표:" + x + ", y좌표:" + y + ")";
	}
}

@AllArgsConstructor			//기본으로 모든 멤버변수를 포함하는 생성자를 만듦.
class Student {
	int grade, classNum, num;
	String name, subject;
	int score;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num
				&& Objects.equals(subject, other.subject);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}