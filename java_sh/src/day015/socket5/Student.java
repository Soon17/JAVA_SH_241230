package day015.socket5;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable{
	
	private static final long serialVersionUID = 275690809935514876L;
	
	private int grd, cls, num;
	private String name;
	
	public Student(int grd, int cls, int num, String name) {
		this.grd = grd;
		this.cls = cls;
		this.num = num;
		this.name = name;
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
		return cls == other.cls && grd == other.grd && num == other.num;
	}

	@Override
	public String toString() {
		return grd + "학년 " + cls + "반 " + num + "번 " + name;
	}

}
