package day006.score;

public class Student {
	private String name;
	private int score;
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public Student(Student s) {
		this(s.name, s.score);
	}
}
