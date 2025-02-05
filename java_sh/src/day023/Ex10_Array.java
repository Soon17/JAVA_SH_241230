package day023;

public class Ex10_Array {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		//배열의 모든 값을 확인하기 위한 코드에서 잘못된 곳을 수정
		
		for (int i = 0; i <= arr.length; i++) {
			System.out.println(arr[i]);
		}
		//배열의 크기보다 작아야 한다.
	}

}
