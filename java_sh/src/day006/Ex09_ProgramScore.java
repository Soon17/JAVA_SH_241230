package day006;

import java.util.Scanner;

public class Ex09_ProgramScore {

	static Scanner sc= new Scanner(System.in);
	static int count;
	static int max = 2;
	public static void main(String[] args) {
		int pick = 0;
		Student[] std = new Student[max];
		do {
			printMenu();
			pick = sc.nextInt();
			runMenu(pick, std);
		} while(pick != 3);
	}
	private static void runMenu(int pick, Student[] std) {
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
	private static void printMenu() {
		System.out.print( "***********메뉴************\n"
						+ " 1. 학생 국어 성적 추가\n"
						+ " 2. 전체 학생 국어 성적 조회\n"
						+ " 3. 종료\n"
						+ "**************************\n"
						+ "메뉴 선택: ");
	}
	private static Student[] expend(Student[] s) {
		if(s == null) return new Student[max];
		if(count == max) {
			max *= 2;
			Student[] std = new Student[max];
			for (int i = 0; i < s.length; i++) {
				std[i] = new Student(s[i]);
			}
			return std;
		} else return s;
	}
	private static void inputScore(Student[] s) {
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("성적: ");
		int score = sc.nextInt();
		s[count] = new Student(name, score);
		count++;
	}
	private static void showScore(Student[] s) {
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
	private static void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
}

class Student {

	private String name;
	private int score;
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public Student(Student s) {
		this(s.name, s.score);
	}
}
