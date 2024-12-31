package day002;

public class Ex08_ifGrade {

	public static void main(String[] args) {
		
		int score = 105;
		
		if (score > 100 || score < 0) {
			System.out.println("잘못된 점수입니다.");
		} else if(score >= 90){
			System.out.println("A학점입니다.");
		} else if(score >= 80){
			System.out.println("B학점입니다.");
		} else if(score >= 70){
			System.out.println("C학점입니다.");
		} else if(score >= 60){
			System.out.println("D학점입니다.");
		} else {
			System.out.println("F학점입니다.");
		}
		
	}

}
