package day006;

public class Ex04_ArrayCopy2 {

	public static void main(String[] args) {
		/*깊은 복사와 얕은 복사를 비교*/
		Point[] p1 = new Point[5];
		for (int i = 0; i < p1.length; i++) {
			p1[i] = new Point(i,i);
		}
		print(p1);
		
		System.out.println("\n--------------");
		
		//System.arraycopy의 얕은 복사를 보여주는 예제
		Point[] p2 = new Point[p1.length];
		System.arraycopy(p1, 0, p2, 0, p1.length);
		p1[0].x = 100;
		print(p1);
		System.out.print(" | ");
		print(p2);
		
		System.out.println("\n--------------");
		
		//반복문을 사용하여 깊은 복사를 보여주는 예제
		Point[] p3 = new Point[p2.length];
		for (int i = 0; i < p2.length; i++) {
			p3[i] = new Point(p2[i]);
		}
		p2[0].x = 1000;
		
		print(p1);
		System.out.print(" | ");
		print(p2);
		System.out.print(" | ");
		print(p3);
		
	}
	
	public static void print(Point[] p) {
		for (int i = 0; i < p.length; i++) {
			p[i].print();
		}
	}

}

class Point {
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(Point p){
		this(p.x, p.y);
	}
	
	void print() {
		System.out.print("(" + x + ", " + y + ")");
	}
}