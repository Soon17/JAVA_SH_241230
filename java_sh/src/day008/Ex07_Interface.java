package day008;

public class Ex07_Interface {

	public static void main(String[] args) {

		System.out.println(ConsoleProgram.num);		//static 변수라 사용가능.
		ConsoleProgram cp = new StudentScoreProgram();
		cp.run();
	}

}

interface ConsoleProgram {
	
	int num = 10;				//자동으로 public static final 이 붙은 상태.
	
	void printMenu();			//자동으로 public abstract 가 붙은 상태.

	static void test() {		//static 이 붙은 부분은 구현을 해주어야 함.
		System.out.println("정적메소드");
	}
	
	void runMenu(int menu);
	
	void run();
	
	default void funtion() {}	//default 를 붙이면 자식 클래스에 구현메소드가 없어도 에러를 일으키지 않음.
	
}

//인터페이스의 구현
class StudentScoreProgram implements ConsoleProgram {

	@Override
	public void printMenu() {
		System.out.println("메뉴 출력");
	}

	@Override
	public void runMenu(int menu) {
		System.out.println("메뉴에 따른 기능 실행");
	}

	@Override
	public void run() {
		System.out.println("프로그램 구동");
	}
	
}

interface Program {
	void run();
}

interface GeneralProgram extends Program, ConsoleProgram {
	//다중상속이 가능.
}