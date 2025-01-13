package homework.ex2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Data;

@Data
public class StudentManager {

	Scanner sc = new Scanner(System.in);
	ArrayList<Student> students = new ArrayList<Student>();
	int grd;
	int cls;
	int num;
	String name;
	public void runMenu(int n) {
		switch (n) {
		case 1://학생 등록
			System.out.println("등록할 학생의 정보를 입력하세요.");	
			inputStudentInfor();
			
			if(studentIndex() == -1) {
				System.out.print("이름: ");
				name = sc.next();
				students.add(new Student(grd, cls, num, name));
				System.out.println("등록되었습니다.");
			} else {
				System.out.println("이미 등록된 학번입니다.");
			}
			sc.nextLine();				
			break;
			
		case 2://과목 등록
			
			break;
		case 3://성적 등록
			
			break;
		case 4://학생 수정
			System.out.println("수정할 학번을 입력해주세요.");
			inputStudentInfor();
			if(studentIndex() == -1) {
				System.out.println("등록되지 않은 학번입니다.");
			} else {
				System.out.println("수정할 내용을 입력해주세요.");
				inputStudentInfor();
				System.out.print("이름: ");
				name = sc.next();
				if(students.contains(new Student(grd, cls, num, name))) {
					System.out.println("변경 사항이 없습니다.");
				} else{
					
				}
			}
			break;
		case 5://과목 수정
			
			break;
		case 6://성적 수정
			
			break;
		case 7://학생 삭제
			System.out.println("삭제할 학번을 입력하세요.");	
			inputStudentInfor();
			
			if(studentIndex() == -1) {
				System.out.println("등록되지 않은 학번입니다.");
			} else {
				students.remove(studentIndex()).print();
				System.out.println("삭제되었습니다.");
			}
			sc.nextLine();				
			break;
		case 8://과목 삭제
			
			break;
		case 9://성적 삭제
			
			break;
		case 10://학생 조회
			if(students.size()==0) {
				System.out.println("등록된 학생이 없습니다.");
			} else {
				for (Student s : students)
					s.print();				
			}
			break;
		case 11://과목 조회
			
			break;
		case 12://성적 조회
			
			break;
		default:
			break;
		}
	}
	private void inputStudentInfor() {
		do {
			try {
				System.out.print("학년: ");
				grd = sc.nextInt();
				System.out.print("반: ");
				cls = sc.nextInt();
				System.out.print("번호: ");
				num = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				sc.nextLine();
				continue;
			}
			return;
		} while(true);
	}
	private int studentIndex() {
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).isMe(grd, cls, num)) {
				return i;
			}
		}
		return -1;
	}
	
	
}
