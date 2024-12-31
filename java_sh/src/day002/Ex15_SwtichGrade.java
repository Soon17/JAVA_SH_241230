package day002;

public class Ex15_SwtichGrade {

	public static void main(String[] args) {
		
		int score = 95;
		switch(score / 10) {
		case 10, 9:
			System.out.println(score + "는 A");
			break;
		case 8:
			System.out.println(score + "는 B");
			break;
		case 7:
			System.out.println(score + "는 C");
			break;
		case 6:
			System.out.println(score + "는 D");
			break;
		case 0,1,2,3,4,5:
			System.out.println(score + "는 F");
			break;
		default:
			System.out.println(score + "는 잘못된 성적");
		}
	}

}
