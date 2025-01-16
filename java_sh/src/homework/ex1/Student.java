package homework.ex1;

import java.text.MessageFormat;
import java.util.ArrayList;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
	
	private int grade, classNum, num;
	private String name;
	private ArrayList<Subject> subList = new ArrayList<Subject>();
	
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
	public Student(int grade, int classNum, int num) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
	}

	@Override
	public String toString() {
		String message = "{0}학년 {1}반 {2}번 {3}";
		String result = MessageFormat.format(message, grade, classNum, num, name);
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return this.grade == other.grade
				&& this.classNum == other.classNum
				&& this.num == other.num;
	}

}
