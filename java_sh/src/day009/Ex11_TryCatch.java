package day009;

public class Ex11_TryCatch {

	public static void main(String[] args) {
		try {
			System.out.println(1/0);
			int[] arr = new int[4];
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (RuntimeException e) {		//모든 런타임 예외처리, 자식 클래스보다 위에 오면 안됨
			System.out.println("실행 예외가 발생했습니다.");
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
		}
		System.out.println("----------------------");
		print();
	}
	
	public static void print() {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			System.out.println("예외 발생");
			return;
		} finally {								//return을 만나도 실행됨
			System.out.println("수정하세요.");
		}
		System.out.println("메소드 종료");
	}

}
