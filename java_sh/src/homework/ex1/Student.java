package homework.ex1;

import java.text.MessageFormat;
import java.util.List;

import lombok.Data;

@Data
public class Student {
	
	private int grade, classNum, num;
	private String name;
	private List<Subject> subList;
	
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
