package homework.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
	private int grade;
	private int semester;
	private String subName;
	private int score;
	
	public Subject(int grade, int semester, String subName) {
		
		this.grade = grade;
		this.semester = semester;
		this.subName = subName;
	}

	@Override
	public String toString() {
		return grade + "학년 " + semester + "학기 " + subName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return this.grade == other.grade
				&& this.semester == other.semester
				&& this.subName == other.subName;
	}
}