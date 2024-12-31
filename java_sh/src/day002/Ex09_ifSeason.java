package day002;

public class Ex09_ifSeason {

	public static void main(String[] args) {
		
		int month = 12;
		
		if (month < 1 || month > 12) {
			System.out.println("잘못된 월입니다");
		} else if (month == 12 || month == 1 || month == 2) {
			System.out.println(month + "월은 겨울입니다.");
		} else if (month > 8) {
			System.out.println(month + "월은 가을입니다.");
		} else if (month > 5) {
			System.out.println(month + "월은 여름입니다.");
		} else {
			System.out.println(month + "월은 봄입니다.");
		}
		
	}

}
