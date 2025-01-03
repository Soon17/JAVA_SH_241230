package day004;

public class Ex09_Class2 {

	public static void main(String[] args) {
		
		Point p1 = new Point();
		
		p1.showPlace();
		p1.changeX(10);
		p1.showPlace();
		p1.changeY(10);
		p1.showPlace();
		p1.move(6, 4);
		p1.showPlace();
		
		Point p2 = new Point(5, 7);
		p2.showPlace();
		
	}

}

class Point{
	
	Point(){}
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	private int x;
	private int y;
	
	public void showPlace() {
		System.out.println("(" + x + ", " + y + ")");
	}
	
	public void changeX(int x) {
		this.x = x;
	}
	
	public void changeY(int y) {
		this.y = y;
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}