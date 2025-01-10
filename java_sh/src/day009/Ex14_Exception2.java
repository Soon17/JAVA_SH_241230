package day009;

import java.util.Arrays;

public class Ex14_Exception2 {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 2, 3, 4, 5};
		
		arr = expend(arr, 5);
		System.out.println(Arrays.toString(arr));
		
		try {
			arr = expend(arr, -10);			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		try {
			arr = null;
			arr = expend(arr, 10);			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("프로그램 종료");
	}
	
	public static int[] expend(int[] arr, int addSize) {
		if(addSize < 0) {
			throw new RuntimeException("배열을 축소할 수 없습니다.");
		}
		if(arr == null) {
			throw new RuntimeException("타겟 배열이 존재하지 않습니다.");
		}
		int[] newArr = new int[arr.length + addSize];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		return newArr;
	}
}