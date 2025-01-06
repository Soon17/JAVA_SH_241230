package day005;

public class Ex02_static {

	public static void main(String[] args) {
		KiaCar k1 = new KiaCar("레이");
		KiaCar k2 = new KiaCar("니로");
		KiaCar k3 = new KiaCar("K5");
		
		k1.setCompany("KIA");
		k1.print();
		k2.print();
		k3.print();
	}

}

class KiaCar {
	private static String company;
	private String carName;
	
	KiaCar(String carName){
		company = "기아";
		this.carName = carName;
	}
	public String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		KiaCar.company = company;	//Ex03_static2 참고
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public void print() {
		System.out.println(company + " : " +  carName);
	}
}