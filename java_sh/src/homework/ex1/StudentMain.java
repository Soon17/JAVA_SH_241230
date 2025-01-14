package homework.ex1;

import lombok.Data;

@Data
public class StudentMain {

	public static void main(String[] args) {
		
		StudentProgram sm = new StudentProgram();
		
		sm.run();
	}

}
