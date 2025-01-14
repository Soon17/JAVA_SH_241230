package homework.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

	private ArrayList<Student> stdList = new ArrayList<Student>();
	private Scanner sc = new Scanner(System.in);
	private int grade;
	private int classNum;
	private int num;
	private int semester;
	private String subName;
	
	public void runMenu(int menuNum) {
		switch (menuNum) {
		case 1://학생 등록
			System.out.println("등록할 학생의 정보를 입력하세요.");
			inputStudentInfo();
			insertStudent();
			fieldClear();
			break;
		case 2://과목 등록
			System.out.println("등록할 과목의 정보를 입력하세요.");	
			inputSubjectInfo();
			insertSubject();
			fieldClear();
			break;
		case 3://성적 등록
			System.out.println("성적을 등록할 학생의 정보를 입력하세요.");	
			inputStudentInfo();
			insertScore();
			fieldClear();
			break;
		case 4://학생 수정
			if(stdList.isEmpty()) {
				System.out.println("등록된 학생이 없습니다.");
				break;
			}
			System.out.println("수정할 학생의 정보를 입력하세요.");
			inputStudentInfo();
			modifyStudent();
			break;
		case 5://과목 수정
			modifySubject();
			System.out.println("과목수정을 진행합니다.");	
			break;
		case 6://성적 수정
			modifyScore();
			System.out.println("성적수정을 진행합니다.");	
			break;
		case 7://학생 삭제
			deleteStudent();
			System.out.println("학생삭제를 진행합니다.");			
			break;
		case 8://과목 삭제
			deleteSubject();
			System.out.println("과목삭제를 진행합니다.");		
			break;
		case 9://성적 삭제
			deleteScore();
			System.out.println("성적삭제를 진행합니다.");		
			break;
		case 10://학생 조회
			showStudents();
			System.out.println("학생조회를 진행합니다.");		
			break;
		case 11://과목 조회
			showSubjects();
			System.out.println("과목조회를 진행합니다.");
			break;
		case 12://성적 조회
			showScores();
			System.out.println("성적조회를 진행합니다.");
			break;
		default:
			System.out.println("없는 메뉴입니다.");
			break;
		}
	}

	private void inputStudentInfo() {
		System.out.print("학년: ");
		grade = sc.nextInt();
		System.out.print("반: ");
		classNum = sc.nextInt();
		System.out.print("번호: ");
		num = sc.nextInt();
	}

	private void inputSubjectInfo() {
		System.out.print("학년: ");
		grade = sc.nextInt();
		System.out.print("학기: ");
		classNum = sc.nextInt();
		System.out.print("과목명: ");
		num = sc.nextInt();
	}

	private void insertStudent() {
		Student tmp = new Student(grade, classNum, num);
		int index = stdList.indexOf(tmp);
		if(index < 0) {
			System.out.print("이름: ");
			String name = sc.next();
			tmp.setName(name);
			stdList.add(tmp);
			System.out.println("등록되었습니다.");
		} else {
			System.out.println("이미 등록된 학생입니다.");
		}
		sc.nextLine();
	}

	private void insertSubject() {
		// TODO Auto-generated method stub
		
	}

	private void insertScore() {
		// TODO Auto-generated method stub
		
	}

	private void modifyStudent() {
		
		Student tmp = new Student(grade, classNum, num);	//바꿀 대상 학번
		int index = stdList.indexOf(tmp);					//리스트에서 검색
		if(index > 0) {
			 
		}
		return;
	}

	private void modifySubject() {
		// TODO Auto-generated method stub
		
	}

	private void modifyScore() {
		// TODO Auto-generated method stub
		
	}

	private void deleteStudent() {
		// TODO Auto-generated method stub
		
	}

	private void deleteSubject() {
		// TODO Auto-generated method stub
		
	}

	private void deleteScore() {
		// TODO Auto-generated method stub
		
	}

	private void showStudents() {
		// TODO Auto-generated method stub
		
	}

	private void showSubjects() {
		// TODO Auto-generated method stub
		
	}

	private void showScores() {
		// TODO Auto-generated method stub
		
	}
	
	private void fieldClear() {
		this.grade = 0;
		this.classNum = 0;
		this.num = 0;
		this.semester = 0;
		this.subName = null;
	}
}