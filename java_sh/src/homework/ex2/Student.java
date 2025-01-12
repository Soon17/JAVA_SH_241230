package homework.ex2;

import java.text.MessageFormat;
import java.util.ArrayList;

import lombok.Data;

@Data
public class Student {
	
	private int grade, classNum, num;
	private String name;
	ArrayList<Subject> subs = new ArrayList<Subject>();
	
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
	public void print() {
		String message = "{0}학년 {1}반 {2}번 {3}";
		String result = MessageFormat.format(message, grade, classNum, num, name);
		System.out.println(result);
	}
	
	public boolean isMe(int grade, int classNum, int num) {
		if(this.grade != grade) return false;
		if(this.classNum != classNum) return false;
		if(this.num != num) return false;
		return true;
	}
}
