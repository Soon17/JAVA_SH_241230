package day003;

import java.util.Scanner;

public class Ex02_Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int month = 0;
		int lastday;
		
		while(true) {
			System.out.print("입력된 월의 마지막 말일을 출력합니다:");
			month = scan.nextInt();
			if(month == -1) {
				System.out.println("종료합니다.");
				break;
			}
			switch(month) {
			case 1,3,5,7,8,10,12:
				lastday = 31;
				break;
			case 4,6,9,11:
				lastday = 30;
				break;
			case 2:
				lastday = 28;
				break;
			default:
				lastday = 0;
			}
			if(lastday != 0) {
				System.out.println(month + "월은 " + lastday + "일이 말일입니다.");
			}
			else {
				System.out.println("존재하지 않는 월입니다.");
			}
		}
		
		scan.close();
	}

}
