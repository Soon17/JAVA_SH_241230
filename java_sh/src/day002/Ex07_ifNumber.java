package day002;

public class Ex07_ifNumber {

	public static void main(String[] args) {
		
		int num = 4;
		
		if(num > 0) {
			System.out.println(num + "은(는) 양수");
		} else if(num == 0){
			System.out.println(num + "은 0");
		} else {
			System.out.println(num + "은(는) 음수");
		}
		
	}

}
