package day007;

import java.util.Scanner;

public class Ex04_StudentScore1 {

	public static void main(String[] args) {
		/*학생의 성적을 관리하는 프로그램을 만들기 위해 필요한
		 * Student 클래스를 작성하세요.
		 * 
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 1
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 이름 : 홍길동
		 * 과목 : 국어
		 * 성적 : 100
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 1학년 1반 1번 홍길동 국어 : 100
		 * 1학년 1반 1번 홍길동 수학 : 100
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 3
		 * 수정할 학생 정보를 입력하세요:
		 * 학년: 1
		 * 반: 1
		 * 번호: 1
		 * 과목: 국어
		 * 수정할 점수를 입력하세요:
		 * 성적: 95
		 * 수정되었습니다.(or 과목이 없거나 학생 정보가 잘못되었습니다.)
		 */
		//메뉴 4를 입력하기 전까지 계속해서 출력하는 코드를 작성하시오.
		Scanner sc = new Scanner(System.in);
		char choice = ' ';
		int max = 10, count = 0;
		Student[] stdList = new Student[max];
		do {
			System.out.print( "***********메뉴************\n"
							+ " 1. 학생 국어 성적 추가\n"
							+ " 2. 전체 학생 국어 성적 조회\n"
							+ " 3. 학생 성적 수정\n"
							+ " 4. 종료\n"
							+ "**************************\n"
							+ "메뉴 선택: ");
			String input = sc.next();
			if(input.length() != 1) {
				System.out.println("없는 메뉴입니다.");
				continue;
			}
			choice = input.charAt(0);
			switch (choice) {
			case '1':
				System.out.print("학년: ");
				int grd = sc.nextInt();
				System.out.print("반: ");
				int cls = sc.nextInt();
				System.out.print("번호: ");
				int num = sc.nextInt();
				System.out.print("이름: ");
				String name = sc.next();
				System.out.print("과목: ");
				String sub = sc.next();
				System.out.print("성적: ");
				int score = sc.nextInt();
				stdList[count++] = new Student(grd, cls, num, name, sub, score);
				break;
			case '2':
				if(count == 0) {
					System.out.println("조회 대상이 없습니다.");
					continue;
				}
				for(int i = 0; i < count; i++) {
					stdList[i].print();
				}
				break;
			case '3':
				System.out.println("수정할 학생 정보를 입력하세요.");
				System.out.print("학년: ");
				grd = sc.nextInt();
				System.out.print("반: ");
				cls = sc.nextInt();
				System.out.print("번호: ");
				num = sc.nextInt();
				System.out.print("과목: ");
				sub = sc.next();
				System.out.println("수정할 성적을 입력하세요.");
				System.out.print("성적: ");
				score = sc.nextInt();
				int index = -1;
				for (int i = 0; i < count; i++) {
					if(stdList[i].isMe(grd, cls, num, sub)) {
						index = i;
						break;
					}
				}
				if(index >= 0) {
					stdList[index].setScore(score);
					System.out.println("수정되었습니다.");
				} else System.out.println("과목이 없거나 학생 정보가 잘못되었습니다.");
				break;
			case '4':
				break;
			default:
				System.out.println("없는 메뉴입니다.");
				break;
			}
		} while(choice != '4');
		System.out.println("프로그램을 종료합니다.");
	}

}

class Student {
	public Student(int grd, int cls, int num, String name, String sub, int score) {
		this.grd = grd;
		this.cls = cls;
		this.num = num;
		this.score = score;
		this.name = name;
		this.sub = sub;
	}

	private int grd, cls, num, score; 
	private String name, sub;
	
	public void print() {
		System.out.printf("%d학년 %d반 %d번 %s %s : %d\n", grd, cls, num, name, sub, score);
	}
	
	public boolean isMe(int grd, int cls, int num, String sub) {
		if(this.grd != grd) return false;
		if(this.cls != cls) return false;
		if(this.num != num) return false;
		if(!this.sub.equals(sub)) return false;
		return true;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
