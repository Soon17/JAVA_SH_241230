package day006.score;

import java.util.Scanner;

public class StudentManager {


	int max = 2;
	int count = 0;
	Student[] std = new Student[max];
	Scanner sc = new Scanner(System.in);
	
	public void runMenu(int pick) {
		switch (pick) {
		case 1:
			std = expend(std);
			inputScore(std);
			break;
		case 2:
			showScore(std);
			break;
		case 3:
			exit();
			break;
		default:
			System.out.println("메뉴에 없는 항목입니다.");
			break;
		}
	}
	private void showScore(Student[] s) {
		if(count==0) {
			System.out.println("조회할 대상이 없습니다.");
			return;
		}
		int sum = 0;
		for (int i = 0; i < count; i++) {
			System.out.println("이름: " + s[i].getName());
			System.out.println("성적: " + s[i].getScore());
			sum += s[i].getScore();
		}
		System.out.println("평균: " + (double)sum/count);
	}
	private void inputScore(Student[] s) {
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("성적: ");
		int score = sc.nextInt();
		s[count] = new Student(name, score);
		count++;
	}
	private Student[] expend(Student[] s) {
		if(s == null) s = new Student[max];
		if(count == max) {
			max *= 2;
			Student[] std = new Student[max];
			for (int i = 0; i < s.length; i++) {
				std[i] = new Student(s[i]);
			}
			return std;
		} else return s;
	}
	private static void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
}
