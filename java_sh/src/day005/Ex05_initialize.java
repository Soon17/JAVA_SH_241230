package day005;

public class Ex05_initialize {

	public static void main(String[] args) {
		Point p = new Point();
		System.out.println(p.x1 + ", " + p.y1);
		System.out.println(p.x2 + ", " + p.y2);
		System.out.println(p.x3 + ", " + p.y3);
		System.out.println(p.x4 + ", " + p.y4);
	}

}

class Point {
	/*
	 * 1. 각 타입의 기본값으로 초기화. 0
	 * 2. 명시적 초기화
	 * 3. 초기화 블록
	 * 4. 생성자
	 */
	int x1, y1;
	int x2 = 1, y2 = 1;
	int x3 = 1, y3 = 1;
	int x4 = 1, y4 = 1;
	//초기화 블록
	{
		x3 = 2; y3 = 2;
		x4 = 2; y4 = 2;
	}
	//static 변수 초기화 블록
	static {
		
	}
	Point() {
		x4 = 3;
		y4 = 3;
	}
	
}