package day007;

import java.util.Scanner;

public class Ex05_StudentScore2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char choice = ' ';
		int max = 10, count = 0;
		Student[] stdList = new Student[max];
		do {
			System.out.print( "***********메뉴************\n"
							+ " 1. 학생 국어 성적 추가\n"
							+ " 2. 전체 학생 국어 성적 조회\n"
							+ " 3. 학생 성적 수정\n"
							+ " 4. 학생 정보 삭제\n"
							+ " 5. 종료\n"
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
				Student temp = new Student(grd, cls, num, name, sub, score);
				
				/*이미 등록된 학생 성적입니다, 성적을 추가했습니다.*/
				int index = -1;
				for (int i = 0; i < count; i++) {
					if(stdList[i].isMe(grd, cls, num, sub)) {
						index = i;
						break;
					}
				}
				if(findStd(stdList, count, grd, cls, num, sub)>=0) {
					System.out.println("이미 등록된 학생 성적입니다.");
				} else {
					System.out.println("성적을 추가했습니다.");
					stdList[count++] = temp;
				}
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
				index = -1;
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
				System.out.println("삭제할 학생 정보를 입력하세요.");
				System.out.print("학년: ");
				grd = sc.nextInt();
				System.out.print("반: ");
				cls = sc.nextInt();
				System.out.print("번호: ");
				num = sc.nextInt();
				System.out.print("과목: ");
				sub = sc.next();
				index = -1;
				for (int i = 0; i < count; i++) {
					if(stdList[i].isMe(grd, cls, num, sub)) {
						index = i;
						break;
					}
				}
				if(index >= 0) {
					if(index != count - 1) {
//						Student[] arr = new Student[stdList.length];
//						System.arraycopy(stdList, 0, arr, 0, count);
//						System.arraycopy(stdList, index + 1, arr, index, count - index - 1);
//						stdList = arr;
						for (int i = index; i < count - 1; i++) {
							stdList[i] = stdList[i + 1];
						}
						count--;
						System.out.println("삭제되었습니다.");
					}
				} else System.out.println("과목이 없거나 학생 정보가 잘못되었습니다.");
				break;
			case '5':
				break;
			default:
				System.out.println("없는 메뉴입니다.");
				break;
			}
		} while(choice != '5');
		System.out.println("프로그램을 종료합니다.");
	}
	
	public static int findStd(Student[] sl, int count, int grd, int cls, int num, String sub) {
		
		for (int i = 0; i < count; i++) {
			if(sl[i].isMe(grd, cls, num, sub)) {
				return i;
			}
		}
		return -1;
	}

}