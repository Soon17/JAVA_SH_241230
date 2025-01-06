package day005;

public class Ex01_Class {

	public static void main(String[] args) {
		
		String name = "임꺽정";
		int count = 100;
		
		Record r1 = new Record(name, count);
		r1.print();
		record1("홍길동",2);
		r1.print();
		
		System.out.println("-------------------");
		
		Record r2 = new Record(name, count);
		r2.print();
		record2(r2);
		r2.print();
	}
	
	public static void record1(String name, int count) {
		name = "홍길동";
		count = 2;
	}
	
	public static void record2(Record r1) {
		r1.setName("홍길동");
		r1.setCount(2);
	}
}

class Record {
	
	Record(String name,int count) {
		this.name = name;
		this.count = count;
	}
	
	Record() {
		this("홍길동", 100);
		//name = "홍길동";
		//count = 100
	}
	
	private int count;
	private String name;
	
	public void setCount(int count) {
		this.count = count;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.printf("이름: %s - %s회\n",name, count);
	}
	
}