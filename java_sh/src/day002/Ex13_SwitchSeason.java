package day002;

public class Ex13_SwitchSeason {

	public static void main(String[] args) {

		int month = 12;
		
		switch(month) {
		
		case 3, 4, 5:
			System.out.println(month+ "월은 봄입니다.");
			break;
		case 6, 7, 8:
			System.out.println(month+ "월은 여름입니다.");
			break;
		case 9, 10, 11:
			System.out.println(month+ "월은 가을입니다.");
			break;
		case 12, 1, 2:
			System.out.println(month+ "월은 겨울입니다.");
		default:
			System.out.println("잘못된 월입니다.");
		}
	}

}
